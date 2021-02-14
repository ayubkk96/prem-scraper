/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ayubkaoukaou.webscrapingproject.mavenproject1;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kaouk
 */

@Entity
@Table(name="football")
public class Football implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private int id;

@Column (name = "team_name")
   private String teamName;


@Column (name = "stadium")
   private String stadiumName;

@Column (name = "next_game")
   private LocalDate nextGame;

@Column (name = "team_url")
   private String url;

@Column (name = "matches_played")
private int matchesPlayed;

@Column (name = "wins")
private int wins;

@Column (name = "losses")
private int losses;

@Column (name = "goals")
private int goals;

@Column (name = "goals_conceded")
private int goalsConceded;

@Column (name = "clean_sheets")
private int cleanSheets;

@Column (name = "top_scorer")
private String topScorer;

@Column (name = "top_scorer_number")
private int topScorerNumber;

@Column (name = "top_assister")
private String topAssister;

@Column (name = "top_assister_number")
private int topAssisterNumber;

@Column (name = "all_time_appearances")
private String allTimeAppearances;

@Column (name = "all_time_appearances_number")
private int allTimeAppearancesNumber;

@Column (name = "all_time_scorer")
private String allTimeScorer;

@Column (name = "all_time_scorer_number")
private int allTimeScorerNumber;

@Column (name = "all_time_assister")
private String allTimeAssister;

@Column (name = "all_time_assister_number")
private int allTimeAssisterNumber;

@Column (name = "image_scorer")
private String topScorerImage;

@Column (name = "image_assister")
private String topAssisterImage;

@Column (name = "image_all_time_scorer")
private String allTimeScorerImage;

@Column (name = "image_all_time_assister")
private String allTimeAssisterImage;

@Column (name = "image_all_time_appearances")
private String allTimeAppearancesImage;

@Column (name = "image_badge")
private String clubBadge;

@Column (name = "image_headline")
private String headlineImage;

@Column (name = "total_wins_home")
private int totalWinsForHomeClub;

@Column (name = "total_wins_away")
private int totalWinsForAwayClub;

@Column (name = "total_wins_home_at_home")
private int totalWinsHomeAtHome;

@Column (name = "total_wins_away_at_home")
private int totalWinsAwayAtHome;
        

@Column (name = "total_wins_home_at_away")
private int totalWinsHomeAtAway;
        
@Column (name = "total_wins_away_at_away")
private int totalWinsAwayAtAway;
        
@Column (name = "games_played_against")
private int gamesPlayedAgainst;
        
@Column (name = "draws")
private int draws;
        
@Column (name = "kick_off_time")
private String kickOffTime;
        
@Column (name = "home_kit")
private String homeKit;
        
@Column (name = "away_kit")
private String awayKit;

@Column (name = "third_kit")
private String thirdKit;
        
@Column (name = "home_team")
private String homeTeam;
        
@Column (name = "away_team")
private String awayTeam;
        
 /** Empty constructor. */
public Football() {

}

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public void setNextGame(LocalDate nextGame) {
        this.nextGame = nextGame;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public void setCleanSheets(int cleanSheets) {
        this.cleanSheets = cleanSheets;
    }

    public void setTopScorer(String topScorer) {
        this.topScorer = topScorer;
    }

    public void setTopScorerNumber(int topScorerNumber) {
        this.topScorerNumber = topScorerNumber;
    }

    public void setTopAssister(String topAssister) {
        this.topAssister = topAssister;
    }

    public void setTopAssisterNumber(int topAssisterNumber) {
        this.topAssisterNumber = topAssisterNumber;
    }

    public String getKickOffTime() {
        return kickOffTime;
    }

    public void setKickOffTime(String kickOffTime) {
        this.kickOffTime = kickOffTime;
    }

    public void setAllTimeAppearances(String allTimeAppearances) {
        this.allTimeAppearances = allTimeAppearances;
    }

    public void setAllTimeAppearancesNumber(int allTimeAppearancesNumber) {
        this.allTimeAppearancesNumber = allTimeAppearancesNumber;
    }

    public void setAllTimeScorer(String allTimeScorer) {
        this.allTimeScorer = allTimeScorer;
    }

    public void setAllTimeScorerNumber(int allTimeScorerNumber) {
        this.allTimeScorerNumber = allTimeScorerNumber;
    }

    public void setAllTimeAssister(String allTimeAssister) {
        this.allTimeAssister = allTimeAssister;
    }

    public void setAllTimeAssisterNumber(int allTimeAssisterNumber) {
        this.allTimeAssisterNumber = allTimeAssisterNumber;
    }

    public String getTopScorerImage() {
        return topScorerImage;
    }

    public void setTopScorerImage(String topScorerImage) {
        this.topScorerImage = topScorerImage;
    }

    public String getTopAssisterImage() {
        return topAssisterImage;
    }

    public void setTopAssisterImage(String topAssisterImage) {
        this.topAssisterImage = topAssisterImage;
    }

    public String getAllTimeScorerImage() {
        return allTimeScorerImage;
    }

    public void setAllTimeScorerImage(String allTimeScorerImage) {
        this.allTimeScorerImage = allTimeScorerImage;
    }

    public String getAllTimeAssisterImage() {
        return allTimeAssisterImage;
    }

    public void setAllTimeAssisterImage(String allTimeAssisterImage) {
        this.allTimeAssisterImage = allTimeAssisterImage;
    }

    public String getAllTimeAppearancesImage() {
        return allTimeAppearancesImage;
    }

    public void setAllTimeAppearancesImage(String allTimeAppearancesImage) {
        this.allTimeAppearancesImage = allTimeAppearancesImage;
    }

    public String getClubBadge() {
        return clubBadge;
    }

    public void setClubBadge(String clubBadge) {
        this.clubBadge = clubBadge;
    }

    public String getHeadlineImage() {
        return headlineImage;
    }

    public void setHeadlineImage(String headlineImage) {
        this.headlineImage = headlineImage;
    }

    public int getTotalWinsForHomeClub() {
        return totalWinsForHomeClub;
    }

    public void setTotalWinsForHomeClub(int totalWinsForHomeClub) {
        this.totalWinsForHomeClub = totalWinsForHomeClub;
    }

    public int getTotalWinsForAwayClub() {
        return totalWinsForAwayClub;
    }

    public void setTotalWinsForAwayClub(int totalWinsForAwayClub) {
        this.totalWinsForAwayClub = totalWinsForAwayClub;
    }

    public int getTotalWinsHomeAtHome() {
        return totalWinsHomeAtHome;
    }

    public void setTotalWinsHomeAtHome(int totalWinsHomeAtHome) {
        this.totalWinsHomeAtHome = totalWinsHomeAtHome;
    }

    public int getTotalWinsAwayAtHome() {
        return totalWinsAwayAtHome;
    }

    public void setTotalWinsAwayAtHome(int totalWinsAwayAtHome) {
        this.totalWinsAwayAtHome = totalWinsAwayAtHome;
    }

    public int getTotalWinsHomeAtAway() {
        return totalWinsHomeAtAway;
    }

    public void setTotalWinsHomeAtAway(int totalWinsHomeAtAway) {
        this.totalWinsHomeAtAway = totalWinsHomeAtAway;
    }

    public int getTotalWinsAwayAtAway() {
        return totalWinsAwayAtAway;
    }

    public void setTotalWinsAwayAtAway(int totalWinsAwayAtAway) {
        this.totalWinsAwayAtAway = totalWinsAwayAtAway;
    }

    public int getGamesPlayedAgainst() {
        return gamesPlayedAgainst;
    }

    public void setGamesPlayedAgainst(int gamesPlayedAgainst) {
        this.gamesPlayedAgainst = gamesPlayedAgainst;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

  
    public String getHomeKit() {
        return homeKit;
    }

    public void setHomeKit(String homeKit) {
        this.homeKit = homeKit;
    }

    public String getAwayKit() {
        return awayKit;
    }

    public void setAwayKit(String awayKit) {
        this.awayKit = awayKit;
    }

    public String getThirdKit() {
        return thirdKit;
    }

    public void setThirdKit(String thirdKit) {
        this.thirdKit = thirdKit;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return "Football{" + "id=" + id + ", teamName=" + teamName + ", stadiumName=" + stadiumName + ", nextGame=" + nextGame + ", url=" + url + ", matchesPlayed=" + matchesPlayed + ", wins=" + wins + ", losses=" + losses + ", goals=" + goals + ", goalsConceded=" + goalsConceded + ", cleanSheets=" + cleanSheets + ", topScorer=" + topScorer + ", topScorerNumber=" + topScorerNumber + ", topAssister=" + topAssister + ", topAssisterNumber=" + topAssisterNumber + ", allTimeAppearances=" + allTimeAppearances + ", allTimeAppearancesNumber=" + allTimeAppearancesNumber + ", allTimeScorer=" + allTimeScorer + ", allTimeScorerNumber=" + allTimeScorerNumber + ", allTimeAssister=" + allTimeAssister + ", allTimeAssisterNumber=" + allTimeAssisterNumber + ", topScorerImage=" + topScorerImage + ", topAssisterImage=" + topAssisterImage + ", allTimeScorerImage=" + allTimeScorerImage + ", allTimeAssisterImage=" + allTimeAssisterImage + ", allTimeAppearancesImage=" + allTimeAppearancesImage + ", clubBadge=" + clubBadge + ", headlineImage=" + headlineImage + ", totalWinsForHomeClub=" + totalWinsForHomeClub + ", totalWinsForAwayClub=" + totalWinsForAwayClub + ", totalWinsHomeAtHome=" + totalWinsHomeAtHome + ", totalWinsAwayAtHome=" + totalWinsAwayAtHome + ", totalWinsHomeAtAway=" + totalWinsHomeAtAway + ", totalWinsAwayAtAway=" + totalWinsAwayAtAway + ", gamesPlayedAgainst=" + gamesPlayedAgainst + ", draws=" + draws + ", kickOffTime=" + kickOffTime + ", homeKit=" + homeKit + ", awayKit=" + awayKit + ", thirdKit=" + thirdKit + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + '}';
    }

   
    

 
    
    

    

    
}