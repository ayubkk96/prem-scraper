/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ayubkaoukaou.webscrapingproject.mavenproject1;

import static com.ayubkaoukaou.webscrapingproject.mavenproject1.FootballChatbot.isNumeric;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FootballChatbot {

    static private String[] arrayOfTeams = new String[]{"Arsenal", "Aston Villa", "Brighton", "Burnley", "Chelsea", "Crystal Palace", "Everton", "Fulham", "Leeds United", "Leicester City", "Liverpool", "Manchester City", "Manchester United", "Newcastle United",
        "Sheffield United", "Southampton", "Tottenham Hotspur", "West Bromwich Albion", "West Ham United", "Wolverhampton Wanderers"};

    public static void startChat() {
        //We need an options class to run headless - not needed if we want default options
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);

        //Create instance of web driver - this must be on the path.
        WebDriver driver = new ChromeDriver(options);

        Scanner userInput = new Scanner(System.in);
        System.out.print("Press stop to quit.");

        //A loop that accepts input commands infinitely until the user types stop.
        while (true) {

            getClubDetails(arrayOfTeams);
            if (userInput.next().equalsIgnoreCase("stop")) {
                break;
            }

        }
        //Exit driver and close Chrome
        driver.quit();
    }

    //Check if the string is a numeric valuea
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Alter the string to be the same format as the team links on the premier league website.
    public static String alterLinkString(String text) {
        if (text.isEmpty()) {
            return text;
        }
        String newText = text.toUpperCase();

        StringBuilder stringBuilder = new StringBuilder();
        String[] parts = newText.split(" ");

        for (String splittedString : parts) {
            stringBuilder.append(splittedString.toUpperCase().charAt(0));
            stringBuilder.append(splittedString.toLowerCase(), 1, splittedString.length());
            stringBuilder.append("-");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

    public static void getClubDetails(String[] teams) {
        //We need an options class to run headless - not needed if we want default options
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        //Create instance of web driver - this must be on the path.biray    
        WebDriver driver = new ChromeDriver(options);
        Actions act = new Actions(driver);
        Actions actTwo = new Actions(driver);

        driver.get("https://www.premierleague.com/clubs");

        // driver.findElement(By.xpath("//*[@id=\"logoClose\"]")).click();
        //Click new budweiser advert for dry january
        //driver.findElement(By.xpath("//*[@id=\"advertClose\"]")).click();
        //Click and accept cookie
        driver.findElement(By.xpath("/html/body/section/div/div")).click();

        for (int i = 0; i < teams.length; i++) {

            try {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
            }

            try {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                Thread.sleep(3000);

                String alterLinkString = alterLinkString(teams[i]);

                actTwo.moveToElement(driver.findElement(By.cssSelector("a[href*='" + alterLinkString + "']"))).click().perform();

                //Click new budweiser advert for dry january
                if (driver.findElement(By.xpath("//*[@id=\"advertClose\"]")).isDisplayed()) {
                    driver.findElement(By.xpath("//*[@id=\"advertClose\"]")).click();
                }

                //Home page
                //Get variables could be a method
                String nextGame = "";
                String clubBadge = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/header/div[2]/div/div/div[1]/picture/img")).getAttribute("src"));
                String headlineImage = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[1]/div[1]/img")).getAttribute("src"));
                String homeKit = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[3]/a/img")).getAttribute("src"));;
                String awayKit = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[4]/a/img")).getAttribute("src"));;
                String thirdKit = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[5]/a/img")).getAttribute("src"));;

                String allTimeAppearancesImage = "";
                String allTimeGoalScorerImage = "";
                String allTimeAssisterImage = "";
                String clubDetails = String.valueOf(driver.findElement(By.className("clubDetails")).getText());
                String teamName = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/header/div[2]/div/div/div[2]/h1")).getText());
                String url = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/header/div[2]/div/div/div[2]/div[2]/a")).getText());
                String stadiumName = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/header/div[2]/div/div/div[2]/div[1]/a/span")).getText());

                //All time appearances
                String allTimeAppearancesName = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[1]/div/ul/li[1]/div[1]/a")).getText());
                int allTimeAppearancesNumber = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[1]/div/ul/li[1]/div[1]/div[2]")).getText()));
                act.moveToElement(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/header/h3")));

                //All time appearances images
                Boolean isPresent = driver.findElements(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[1]/div/ul/li[1]/div[3]/img")).size() > 0;
                Boolean isCityPresent = driver.findElements(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[1]/div/ul/li[1]/div[2]/img")).size() > 0;

                //All time goal scorer images
                Boolean isGoalScorerPresent = driver.findElements(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[2]/div/ul/li[1]/div[2]/img")).size() > 0;
                Boolean isGoalScorerBurnley = driver.findElements(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[2]/div/ul/li[1]/div[3]/img")).size() > 0;

                //All time assister                                      //*[@id="mainContent"]/div[3]/div/div/section[10]/ul/li[3]/div/ul/li[1]/div[2]/img
                Boolean isAssisterPresent = driver.findElements(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[3]/div/ul/li[1]/div[2]/img")).size() > 0;
                Boolean otherAssisterPresent = driver.findElements(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[3]/div/ul/li[1]/div[3]/img")).size() > 0;
                Boolean leicesterOtherAssister = driver.findElements(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[3]/div/ul/li[1]/div[2]/img")).size() > 0;

                if (isPresent == true) {
                    allTimeAppearancesImage = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[1]/div/ul/li[1]/div[3]/img")).getAttribute("src"));
                } else if (isCityPresent == true) {
                    allTimeAppearancesImage = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[1]/div/ul/li[1]/div[2]/img")).getAttribute("src"));
                } else {
                    allTimeAppearancesImage = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[2]/div/ul/li[1]/div[2]/img")).getAttribute("src"));
                }

                if (isGoalScorerPresent == true) {
                    allTimeGoalScorerImage = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[2]/div/ul/li[1]/div[2]/img")).getAttribute("src"));
                } else if (isGoalScorerBurnley == true) {
                    allTimeGoalScorerImage = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[2]/div/ul/li[1]/div[3]/img")).getAttribute("src"));
                }

                if (isAssisterPresent == true) {
                    allTimeAssisterImage = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[3]/div/ul/li[1]/div[2]/img")).getAttribute("src"));
                } else {
                    allTimeAssisterImage = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[3]/div/ul/li[1]/div[3]/img")).getAttribute("src"));
                }

                //All time scorer
                String allTimeScorerName = String.valueOf(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[2]/div/ul/li[1]/div[1]/a")).getText()));
                int allTimeScorerNumber = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[2]/div/ul/li[1]/div[1]/div[2]")).getText()));

                //All time assists
                String allTimeAssistsName = String.valueOf(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[3]/div/ul/li[1]/div[1]/a")).getText()));
                int allTimeAssistsNumber = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section[10]/ul/li[3]/div/ul/li[1]/div[1]/div[2]")).getText()));

                //Head to head page
                //Click to head to head page
                driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/nav/div[3]/div/div[1]/span/a")).click();
                Thread.sleep(3000);

                //*[@id="mainContent"]/div/section[2]/div[2]/section/div[3]/div/div[1]/div[3]/strong
                String kickOffTime = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/section[2]/div[2]/section/div[3]/div/div[1]/div[3]/strong")).getText());
                //*[@id="mainContent"]/div/section[2]/div[2]/section/div[3]/div/div[1]/div[1]/div[1]/a[2]/span[1]
                String homeTeam = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/section[2]/div[2]/section/div[3]/div/div[1]/div[1]/div[1]/a[2]/span[1]")).getText());
                String awayTeam = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/section[2]/div[2]/section/div[3]/div/div[1]/div[1]/div[3]/a[2]/span[1]")).getText());

                //Click stats
                driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/section[2]/div[2]/div[2]/div[1]/div/div/ul/li[3]")).click();

                int totalWinsHome = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/section[2]/div[2]/div[2]/div[2]/section[3]/div[2]/div[1]/div[1]/div/div[1]/section/div[1]/div[1]/div[1]/div[2]")).getText()));
                int totalWinsAway = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/section[2]/div[2]/div[2]/div[2]/section[3]/div[2]/div[1]/div[1]/div/div[1]/section/div[2]/div[1]/div[1]/div[2]")).getText()));
                int totalWinsHomeAtHome = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/section[2]/div[2]/div[2]/div[2]/section[3]/div[2]/div[1]/div[1]/div/div[1]/section/div[1]/div[2]/div[1]/div[2]")).getText()));
                int totalWinsAwayAtHome = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/section[2]/div[2]/div[2]/div[2]/section[3]/div[2]/div[1]/div[1]/div/div[1]/section/div[2]/div[2]/div[1]/div[2]")).getText()));
                int totalWinsHomeAtAway = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/section[2]/div[2]/div[2]/div[2]/section[3]/div[2]/div[1]/div[1]/div/div[1]/section/div[1]/div[3]/div[1]/div[2]")).getText()));
                int totalWinsAwayAtAway = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/section[2]/div[2]/div[2]/div[2]/section[3]/div[2]/div[1]/div[1]/div/div[1]/section/div[2]/div[3]/div[1]/div[2]")).getText()));
                int gamesPlayedAgainstEachOther = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/section[2]/div[2]/div[2]/div[2]/section[3]/div[2]/div[1]/div[1]/div/div[1]/section/div[3]/p[2]")).getText()));
                int draws = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/section[2]/div[2]/div[2]/div[2]/section[3]/div[2]/div[1]/div[1]/div/div[1]/section/div[3]/p[3]/span")).getText()));

                driver.navigate().back();
                Thread.sleep(3000);

                //Move to top so that driver can see stats button
                js.executeScript("window.scrollTo(0, 0)");

                //Click to stats and get stats
                driver.findElement(By.xpath("//*[@id=\"mainContent\"]/nav/ul/li[5]/a")).click();
                Thread.sleep(3000);

                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                Thread.sleep(3000);

                //Current top scorer
                String topScorerName = String.valueOf(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/section[2]/ul/li[1]/div/ul/li[1]/div[1]/a[1]")).getText()));
                int topScorerNumber = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/section[2]/ul/li[1]/div/ul/li[1]/div[1]/div[2]")).getText()));
                String topScorerImage = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/section[2]/ul/li[1]/div/ul/li[1]/div[3]/img")).getAttribute("src"));

                //Current top assister
                String topAssisterName = String.valueOf(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/section[2]/ul/li[2]/div/ul/li[1]/div[1]/a[1]")).getText()));
                int topAssisterNumber = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/section[2]/ul/li[2]/div/ul/li[1]/div[1]/div[2]")).getText()));
                String topAssisterImage = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/section[2]/ul/li[2]/div/ul/li[1]/div[3]/img")).getAttribute("src"));

                //Chelsea
                //*[@id="mainContent"]/div[3]/section[2]/ul/li[2]/div/ul/li[1]/div[3]/img
                //ars
                //*[@id="mainContent"]/div[3]/section[2]/ul/li[2]/div/ul/li[1]/div[3]/img
                WebElement element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section/div[1]/div[2]"));

                String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                        + "var elementTop = arguments[0].getBoundingClientRect().top;"
                        + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

                ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
                Thread.sleep(3000);

                driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section/div[1]/div[2]")).click();
                driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/section/div[1]/ul/li[2]")).click();
                Thread.sleep(3000);

                //Current matches played, wins losses goals
                int matchesPlayed = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/div/div[1]/span/span")).getText()));
                int wins = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/div/div[2]/span/span")).getText()));
                int losses = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/div/div[3]/span/span")).getText()));
                int goals = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/div/div[4]/span/span")).getText()));
                int goalsConceded = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/div/div[5]/span/span")).getText()));
                int cleanSheets = Integer.parseInt(String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/div/div/div/div[6]/span/span")).getText()));

                js.executeScript("window.scrollTo(0,0)");
                Thread.sleep(3000);

                //Click to fixtures and get the date of next game
                driver.findElement(By.xpath("/html/body/main/nav/ul/li[3]/a")).click();
                Thread.sleep(3000);

                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                Thread.sleep(3000);

                //If it has TBC on the game because of corona, then get the next game
                if (String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div/div[1]/div[2]/section/time[1]")).getAttribute("datetime")).equalsIgnoreCase("Date To Be Confirmed")) {
                    nextGame = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div/div[1]/div[2]/section/time[3]")).getAttribute("datetime"));
                } else {
                    nextGame = String.valueOf(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div/div[1]/div[2]/section/time[1]")).getAttribute("datetime"));
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy", Locale.ENGLISH);
                LocalDate date = LocalDate.parse(nextGame, formatter);

                System.out.println(teamName + " " + url + " " + date + " " + stadiumName + " All time appearances: " + allTimeAppearancesName + " allTimeAppearancesNumber: "
                        + allTimeAppearancesNumber + " allTimeScorer: " + allTimeScorerName + " allTimeScorerNumber: " + allTimeScorerNumber
                        + " All Time Assister: " + allTimeAssistsName + " All time Assiter Number "
                        + allTimeAssistsNumber + " current top scorer: " + topScorerName + " top scorer number: " + topScorerNumber
                        + " top assister name: " + topAssisterName + " top assister number: " + topAssisterNumber + " matches played: "
                        + matchesPlayed + " wins: " + wins + " losses: " + losses + " goals: "
                        + goals + " goalsConceded: " + goalsConceded + " clean sheets: "
                        + cleanSheets + " Link app: " + allTimeAppearancesImage
                        + " Link scorer: " + allTimeGoalScorerImage + " Top Scorer Image: " + topScorerImage
                        + " Top Assister image: "
                        + topAssisterImage + " Club Badge Link: " + clubBadge + "Headline image link: " + headlineImage
                        + " Total wins home club: " + totalWinsHome + " Total wins away club: " + totalWinsAway + " Total wins of home club at home: "
                        + totalWinsHomeAtHome + "Total wins away club at home: " + totalWinsAwayAtHome + " Total wins Home at Away: " + totalWinsHomeAtAway
                        + "Total wins Away at Away: " + totalWinsAwayAtAway + " Games played against each other: " + gamesPlayedAgainstEachOther + " draws:" + draws + kickOffTime + homeKit
                        + awayKit + thirdKit + "home team: " + homeTeam + "away team: " + awayTeam);

                //How to go back
                //webDriver.navigate().back();
                Football football = new Football();
                football.setTeamName(teamName);
                football.setNextGame(date);
                football.setUrl(url);
                football.setStadiumName(stadiumName);
                football.setAllTimeAppearances(allTimeAppearancesName);
                football.setAllTimeAppearancesNumber(allTimeAppearancesNumber);
                football.setAllTimeAssister(allTimeAssistsName);
                football.setAllTimeAssisterNumber(allTimeAssistsNumber);
                football.setAllTimeScorer(allTimeScorerName);
                football.setAllTimeScorerNumber(allTimeScorerNumber);
                football.setCleanSheets(cleanSheets);
                football.setGoals(goals);
                football.setGoalsConceded(goalsConceded);
                football.setTopAssister(topAssisterName);
                football.setLosses(losses);
                football.setTopAssisterNumber(topAssisterNumber);
                football.setWins(wins);
                football.setTopScorer(topScorerName);
                football.setTopScorerNumber(topScorerNumber);
                football.setMatchesPlayed(matchesPlayed);
                football.setAllTimeAppearancesImage(allTimeAppearancesImage);
                football.setAllTimeScorerImage(allTimeGoalScorerImage);
                football.setAllTimeAssisterImage(allTimeAssisterImage);
                football.setTopScorerImage(topScorerImage);
                football.setTopAssisterImage(topAssisterImage);

                football.setHomeKit(homeKit);
                football.setAwayKit(awayKit);
                football.setThirdKit(thirdKit);

                football.setClubBadge(clubBadge);
                football.setHeadlineImage(headlineImage);

                football.setHomeTeam(homeTeam);
                football.setAwayTeam(awayTeam);

                football.setGamesPlayedAgainst(gamesPlayedAgainstEachOther);
                football.setDraws(draws);
                football.setTotalWinsAwayAtAway(totalWinsAwayAtAway);
                football.setTotalWinsAwayAtHome(totalWinsAwayAtHome);

                football.setTotalWinsHomeAtAway(totalWinsHomeAtAway);
                football.setTotalWinsHomeAtHome(totalWinsHomeAtHome);

                football.setTotalWinsForHomeClub(totalWinsHome);
                football.setTotalWinsForAwayClub(totalWinsAway);

                football.setKickOffTime(kickOffTime);

                FootballDao footballDao = new FootballDao();
                footballDao.init();

                footballDao.saveCheesePrice(football);

//Go back to clubs section
                driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[8]/a")).click();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }

    public static void getNextGame(String userCommand) {
        //We need an options class to run headless - not needed if we want default options
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        //Create instance of web driver - this must be on the path.
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.premierleague.com/clubs");
        //driver.findElement(By.xpath("//*[@id=\"logoClose\"]")).click();
        driver.findElement(By.xpath("/html/body/section/div/div")).click();
        try {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(9000);
            String linkString = userCommand;
            String alterLinkString = alterLinkString(linkString);
            driver.findElement(By.cssSelector("a[href*='" + alterLinkString + "']")).click();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(9000);
            System.out.println(userCommand + "'s " + "next game is on: " + driver.findElement(By.className("day")).getText());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}

//System.out.print("Hello, I am Aldred, the PREMIER LEAGUE chatbot. \n Enter the fixture number you want to know about e.g. '1'. \n "
//                    + "Enter the team that you want to know about e.g. 'Arsenal'. \n "
//                    + "Type 'stop' to quit the chat.");
//
//            String userCommand = userInput.next();
//            int fixtureNumber = 0;
//
//            if (isNumeric(userCommand)) {
//                driver.get("https://www.premierleague.com/results");
//                //Wait for page to load
//                try {
//                    JavascriptExecutor js = ((JavascriptExecutor) driver);
//                    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//                    Thread.sleep(9000);
//
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//                List<WebElement> fixtureList = driver.findElements(By.className("matchList"));
//
//                fixtureNumber = Integer.parseInt(userCommand);
//
//                Collections.reverse(fixtureList);
//                System.out.println("Ok. The results for fixture number " + fixtureNumber + " are: " + fixtureList.get(fixtureNumber - 1).getText());
//                Collections.reverse(fixtureList);
//                continue;
//            }
