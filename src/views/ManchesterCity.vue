<template>
    <div class="home">

        <div class="row">
            <div class="column">
                <div class="card">
                    <img :src="topscorerimagelink" alt="Jane" style="width:100%">
                    <div class="container">
                        <h2 style="color: black; font-family: Neue, Helvetica, Arial, sans-serif">Most Goals</h2>
                        <p class="title">{{getFirstAndLastName(topscorer)}}</p>
                        <p>{{topscorernumber}}</p>

                    </div>
                </div>
            </div>

            <div class="column">
                <div class="card">
                    <img :src="topassisterimagelink" alt="Mike" style="width:100%">
                    <div class="container">
                        <h2 style="color: black; font-family: Neue, Helvetica, Arial, sans-serif">Most Assists </h2>
                        <p class="title">{{getFirstAndLastName(topassister)}}</p>
                        <p>{{topassisternumber}} </p>

                    </div>
                </div>
            </div>

            <div class="column">
                <div class="card">
                    <img :src="alltimescorerimagelink" alt="John" style="width:100%">
                    <div class="container">
                        <h2 style="color: black; font-family: Neue, Helvetica, Arial, sans-serif">Club Goals</h2>
                        <p class="title">{{getFirstAndLastName(alltimescorer)}}</p>
                        <p>{{alltimescorernumber}}</p>
                    </div>
                </div>
            </div>

            <div class="column">
                <div class="card">
                    <img :src="alltimeassisterimagelink" alt="John" style="width:100%">
                    <div class="container">
                        <h2 style="color: black; font-family: Neue, Helvetica, Arial, sans-serif">Club Assists</h2>
                        <p class="title">{{getFirstAndLastName(alltimeassister)}}</p>
                        <p>{{alltimeassisternumber}}</p>
                    </div>
                </div>
            </div>

            <div class="column">
                <div class="card">
                    <img :src="alltimeappearancesimagelink" alt="John" style="width:100%">
                    <div class="container">
                        <h2 style="color: black; font-family: Neue, Helvetica, Arial, sans-serif">Appearances</h2>
                        <p class="title">{{getFirstAndLastName(alltimeappearances)}}</p>
                        <p>{{alltimeappearancesnumber}}</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- Club Stats -->
        <div class="clubStats" style="text-align: center;">
            <br/> <b-header>
            <b-img alt="Responsive Image" fluid
                   :src="imagebadge"> text="Badge"
            </b-img>
        </b-header>
            <br/> <h2 style="color: black; font-family: Neue, Helvetica, Arial, sans-serif">{{teamname}}</h2>
            Matches played: <b>{{matchesplayed}} </b>
            <br/> Wins: <b>{{wins}} </b>
            <br/> Losses: <b> {{losses}} </b>
            <br/> Goals conceded: <b> {{goalsconceded}} </b>
            <br/> Goals scored: <b> {{goals}} </b>
            <br/> Clean sheets: <b> {{cleansheets}} </b>
        </div>


        <div class="left"> {{sendData()}}
        </div>
        <div class="wrapper">


            <!--HEAD TO HEAD brief summary-->
            <div class="one" style="text-align: center">
                <h2 style="background-color: #37003c; color: white">Head To Head</h2>
                <p id="demo">{{countdownToNextGame(nextgame.substring(0,10), kickofftime )}}</p>
                Date: {{nextgame.substring(0,10)}}
                <br/> Time: {{kickofftime}}
                <h2 style="background-color: #37003c; color: white">Shared Stats</h2>
                <i> Games played: <b> {{gamesplayedagainst}} </b> </i>
                <br/> <i> Draws: <b> {{draws}} </b> </i>



            </div>

            <!--Club kits-->
            <div class="two" style="text-align: center">
                <br/><h2 style="background-color: #37003c">{{teamname}}'s kits </h2>
                <br/> <b-img alt="Responsive Image" fluid
                             :src="homekit"> text="Badge"
            </b-img>
                <b-img alt="Responsive Image" fluid
                       :src="awaykit"> text="Badge"
                </b-img>
                <b-img alt="Responsive Image" fluid
                       :src="thirdkit"> text="Badge"
                </b-img>
            </div>



            <div class="four"></div>

            <!--AWAY TEAM STATS-->
            <div class="five">
                <h2 style=" background-color: black">AWAY</h2>
                <br/> <h2 style="color: black; font-family: Neue, Helvetica, Arial, sans-serif"> {{awayteam}} </h2>
                <br/> Away team wins: <b> {{totalwinsaway}} </b>
                <br/> Away team wins at Home: <b> {{totalwinsawayathome}} </b>
                <br/> Away team wins at Away: <b> {{totalwinsawayataway}} </b>
            </div>

            <div class="six"></div>
        </div>

        <!--HOME TEAM STATS-->
        <div class="three">
            <br/>
            <br/><h2 style="background-color: black">HOME</h2>
            <br/> <h2 style="color: black; font-family: Neue, Helvetica, Arial, sans-serif"> {{hometeam}} </h2>
            <br/> Home team wins: <b> {{totalwinshome}} </b>
            <br/> Home team wins at Home: <b> {{totalwinshomeathome}} </b>
            <br/> Home team wins at Away: <b> {{totalwinshomeataway}} </b>


        </div>




    </div>
</template>

<script>




    import axios from "axios";

    export default {
        name: 'Arsenal',
        data() {
            return {
                ip: "",
                input: {
                    firstname: "",
                    lastname: ""
                },
                response: "",
                teamname: "",
                stadium: "",
                nextgame: "",
                teamurl: "",
                matchesplayed: "",
                wins: "",
                losses: "",
                goals: "",
                goalsconceded: "",
                cleansheets: "",
                topscorer: "",
                topscorerimagelink: "",
                topscorernumber: "",
                topassister: "",
                topassisterimagelink: "",
                topassisternumber: "",
                alltimeappearances: "",
                alltimeappearancesnumber: "",
                alltimeappearancesimagelink: "",
                alltimescorer: "",
                alltimescorerimagelink: "",
                alltimescorernumber: "",
                alltimeassister: "",
                alltimeassisterimagelink: "",
                alltimeassisternumber: "",
                imagebadge: "",
                imageheadline: "",
                totalwinshome: "",
                totalwinsaway: "",
                kickofftime: "",
                totalwinshomeathome: "",
                totalwinshomeataway: "",
                totalwinsawayathome: "",
                totalwinsawayataway: "",
                gamesplayedagainst: "",
                draws: "",
                homekit: "",
                awaykit: "",
                thirdkit: "",
                hometeam: "",
                awayteam: ""

            }
        },

        methods: {
            sendData() {
                axios.get('http://localhost:3000/teams').then(result => {
                    this.response = result.data.data;
                    this.nextgame = result.data.data[11].next_game;
                    this.teamname = result.data.data[11].team_name;
                    this.stadium = result.data.data[11].stadium;
                    this.teamurl = result.data.data[11].team_url;
                    this.matchesplayed = result.data.data[11].matches_played;
                    this.wins = result.data.data[11].wins;
                    this.losses = result.data.data[11].losses;
                    this.goals = result.data.data[11].goals;
                    this.goalsconceded = result.data.data[11].goals_conceded;
                    this.cleansheets = result.data.data[11].clean_sheets;
                    this.topscorer = result.data.data[11].top_scorer;
                    this.topscorernumber = result.data.data[11].top_scorer_number;
                    this.topassister = result.data.data[11].top_assister;
                    this.topassisternumber = result.data.data[11].top_assister_number;
                    this.alltimeappearances = result.data.data[11].all_time_appearances;
                    this.alltimeappearancesnumber = result.data.data[11].all_time_appearances_number;
                    this.alltimescorer = result.data.data[11].all_time_scorer;
                    this.alltimescorernumber = result.data.data[11].all_time_scorer_number;
                    this.alltimeassister = result.data.data[11].all_time_assister;
                    this.alltimeassisternumber = result.data.data[11].all_time_assister_number;
                    this.topscorerimagelink = result.data.data[11].image_scorer;
                    this.topassisterimagelink = result.data.data[11].image_assister;
                    this.alltimescorerimagelink = result.data.data[11].image_all_time_scorer;
                    this.alltimeassisterimagelink = result.data.data[11].image_all_time_assister;
                    this.alltimeappearancesimagelink = result.data.data[11].image_all_time_appearances;
                    this.imagebadge = result.data.data[11].image_badge;
                    this.imageheadline = result.data.data[11].image_headline;
                    this.totalwinshome = result.data.data[11].total_wins_home;
                    this.totalwinsaway = result.data.data[11].total_wins_away;
                    this.kickofftime = result.data.data[11].kick_off_time;
                    this.totalwinshomeathome = result.data.data[11].total_wins_home_at_home;
                    this.totalwinshomeataway = result.data.data[11].total_wins_home_at_away;
                    this.totalwinsawayathome = result.data.data[11].total_wins_away_at_home;
                    this.totalwinsawayataway = result.data.data[11].total_wins_away_at_away;
                    this.gamesplayedagainst = result.data.data[11].games_played_against;
                    this.draws = result.data.data[11].draws;
                    this.homekit = result.data.data[11].home_kit;
                    this.awaykit = result.data.data[11].away_kit;
                    this.thirdkit = result.data.data[11].third_kit;
                    this.hometeam = result.data.data[11].home_team;
                    this.awayteam = result.data.data[11].away_team;



                }, error => {
                    console.error(error);
                });

            },

            getFirstAndLastName(fullname) {
                let names = fullname.split(" ")
                if (names.length < 2) {
                    return fullname;
                }
                let firstname = names[0]
                let lastname = names.reverse()[0]
                console.log(firstname + " " + lastname )
                return firstname + " " + lastname
            },

            countdownToNextGame(yearMonthDay, time) {

                // Set the date we're counting down to
                var countDownDate = new Date(yearMonthDay + " " + time).getTime();

                // Update the count down every 1 second
                var x = setInterval(function() {

                    // Get today's date and time
                    var now = new Date().getTime();

                    // Find the distance between now and the count down date
                    var distance = countDownDate - now;

                    // Time calculations for days, hours, minutes and seconds
                    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                    var seconds = Math.floor((distance % (1000 * 60)) / 1000);

                    // Display the result in the element with id="demo"
                    document.getElementById("demo").innerHTML = days + "d " + hours + "h "
                        + minutes + "m " + seconds + "s ";

                    // If the count down is finished, write some text
                    if (distance < 0) {
                        clearInterval(x);
                        document.getElementById("demo").innerHTML = "EXPIRED";
                    }
                }, 1000);
            }



        }

    }
</script>

<style scoped>

    .row {

        margin: auto;
        width: 50%;

        padding: 10px;
    }
    .left {
        font-family: Neue Helvetica W01, Helvetica, helvetica, arial, "sans-serif";
        top: 100px;
        left: 16px;
        font-size: 20px;
        line-height: 1.1667;
        margin-top: -9.9608px;
        margin-bottom: 26.0392px;
        position: relative;
        text-align: center;
        color: black;
    }

    .wrapper {
        display: grid;
        grid-template-columns: repeat(3, 1fr);
        gap: 10px;
        grid-auto-rows: minmax(100px, auto);
        font-size: large;
        font-family: Neue Helvetica W01, Helvetica, helvetica, arial, "sans-serif";
    }

    .one {
        grid-column: 2;
        grid-row: 1/3;
        border-top: 1px solid #000000;

    }

    .two {
        grid-column: 1/5;
        grid-row: 3;

    }

    .three {
        float: none;
        position: absolute;
        top: 60%;
        left: 28%;
        transform: translate(-50%, -50%);
        font-size: large;

    }



    .five {
        grid-column: 3;
        grid-row: 1/3;
    }


    .home {
    }

    .carousel {
        width: 800px;
        grid-column: 2/3;
        grid-row: 1;
    }

    .responsive {
        width: 30%;
        height: auto;

    }

    h2 {
        color: #ffffff;
    }
    .clubStats {
        float: none;
        position: absolute;
        top: 30%;
        left: 18%;
        transform: translate(-50%, -50%);
        font-size: large;
    }



</style>