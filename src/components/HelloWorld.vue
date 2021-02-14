<template>
  <div class="hello">


    {{sendData()}}

  </div>
</template>


<script>

  import axios from "axios";

  export default {
    name: 'HelloWorld',
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

          console.log(result.data.data[0].next_game)
        }, error => {
          console.error(error);
        });

      }

    }

  }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }

  textarea {
    width: 600px;
    height: 200px;
  }
</style>
