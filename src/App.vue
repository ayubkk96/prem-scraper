<template>
  <div id="app">
    <Navbar/>
    <router-view></router-view>


  </div>
</template>

<script>

import Navbar from './components/Navbar'


export default {
  name: 'App',
  components: {
    Navbar,
  }

  }
</script>


<style>
  /* Extra small devices (phones, 600px and down) */
  @media only screen and (max-width: 600px) {
    #app {}
  }

  /* Small devices (portrait tablets and large phones, 600px and up) */
  @media only screen and (min-width: 600px) {
    #app {}
  }

  /* Medium devices (landscape tablets, 768px and up) */
  @media only screen and (min-width: 768px) {
    #app {}
  }

  /* Large devices (laptops/desktops, 992px and up) */
  @media only screen and (min-width: 992px) {
    #app {}
  }

  /* Extra large devices (large laptops and desktops, 1200px and up) */
  @media only screen and (min-width: 1200px) {
    #app {}
  }
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  margin-top: 200px;

}
</style>
