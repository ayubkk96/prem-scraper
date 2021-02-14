<template>
      <div class="home" >
          <div class="left">{{response}}
          </div>

          <HelloWorld> </HelloWorld>
          <b-jumbotron header="" lead="All data has been scraped using Selenium Web Driver">
              <p>Click below to find out more</p>
              <b-button variant="primary" href="/About">About this project</b-button>
          </b-jumbotron>



      </div>




</template>

<script>

    import axios from "axios";
import HelloWorld from "@/components/HelloWorld";

    export default {
        name: "Home",
        data () {
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
                teamurl: ""
            }
        },

        methods: {
            sendData() {
                axios.get('http://localhost:3000/teams').then(result => {
                    this.response = result.data.data;
                    this.nextgame = result.data.data[0].next_game;
                    this.teamname = result.data.data[0].team_name;
                    this.stadium = result.data.data[0].stadium;
                    this.teamurl = result.data.data[0].team_url;
                    this.matchesplayed = result.data.data[0].team.matches_played;
                    this.wins = result.data.data[0].wins;
                    this.losses = result.data.data[0].losses;
                    this.goals = result.data.data[0].goals;
                    this.goalsconceded = result.data.data[0].goals_conceded;
                    this.cleansheets = result.data.data[0].clean_sheets;
                    this.topscorer = result.data.data[0].top_scorer;
                    this.topscorernumber = result.data.data[0].top_scorer_number;
                    this.topassister = result.data.data[0].top_assister;
                    this.topassisternumber = result.data.data[0].top_assister_number;
                    this.alltimeappearances = result.data.data[0].all_time_appearances;
                    this.alltimeappearancesnumber = result.data.data[0].all_time_appearances_number;
                    this.alltimescorer = result.data.data[0].all_time_scorer;
                    this.alltimescorernumber = result.data.data[0].all_time_scorer_number;
                    this.alltimeassister = result.data.data[0].all_time_assister;
                    this.alltimeassisternumber = result.data.data[0].all_time_assister_number;


                    console.log(result.data.data[0].next_game)
                }, error => {
                    console.error(error);
                });

            }

        },
        components:  {

            HelloWorld
}


    }
</script>

<style scoped>

    .left {
        font-family: Neue Helvetica W01,Helvetica,helvetica,arial,"sans-serif";
        position: absolute;
        top:100px;
        left: 16px;
        font-size: 45px;
        line-height: 1.1667;
        margin-top: -9.9608px;
        margin-bottom: 26.0392px;
        background-color: #37003c;

    }
h1 {
    font-family: Neue, Helvetica, Arial, sans-serif;
    font-size: medium;
    text-align: left;
    color: black;
}
    header {
        background-color: black;
        display: flex;

    }

    b-jumbotron {
        position: absolute;
        top:100px;
        left: 16px;
        font-size: 45px;
        line-height: 1.1667;
        margin-top: -9.9608px;
        margin-bottom: 26.0392px;
        display: flex;
    }


</style>