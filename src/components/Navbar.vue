<template>
    <b-navbar type="dark" variant="dark" fixed="top" ml-auto>

        <b-navbar-nav>
            <b-navbar-brand href="#">
                <b-img :src="require('C:\\Users\\kaouk\\WebstormProjects\\fballvuefrontend\\src\\assets\\output-onlinepngtools.png')"
                       fluid alt="Responsive Image"></b-img>
            </b-navbar-brand>

            <div class="topnav-left-centered">
                <b-nav-item href="#">
                    <router-link to="/">Home</router-link>
                </b-nav-item>
            </div>
            <div class="topnav-centered">
                <b-nav-item href="#">
                    <router-link to="/about">About</router-link>
                </b-nav-item>
            </div>
            <div class="topnav-right-centered">
                <b-nav-item>
                    <router-link to="/">Clubs</router-link>
                </b-nav-item>
            </div>


            <!-- Navbar dropdowns -->


            <div class="topnav-dropdown" >  Select club
                <b-nav-item-dropdown>
                    <b-dropdown-item style="font-size: small" href="/Arsenal">Arsenal</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/AstonVilla">Aston Villa</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/Brighton">Brighton</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/Burnley">Burnley</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/Chelsea">Chelsea</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/CrystalPalace">Crystal Palace</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/Everton">Everton</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/Fulham">Fulham</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/LeedsUnited">Leeds United</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/LeicesterCity">Leicester City</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/Liverpool">Liverpool</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/ManchesterCity">Manchester City</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/ManchesterUnited">Manchester United</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/NewcastleUnited">Newcastle United</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/SheffieldUnited">Sheffield United</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/Southampton">Southampton</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/TottenhamHotspur">Tottenham Hotspur</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/WestBromwichAlbion">West Bromwich Albion</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/WestHamUnited">West Ham United</b-dropdown-item>
                    <b-dropdown-item style="font-size: small" href="/WolverhamptonWanderers">Wolverhampton Wanderers</b-dropdown-item>
                </b-nav-item-dropdown>
            </div>

        </b-navbar-nav>

    </b-navbar>
</template>
<script>
    export default {
        name: "Navbar"
    }
</script>

<style scoped>
    h1 {
        font-size: large;
        text-align: center;
    }

    a {
        line-height: 6rem;
        list-style-type: none;
        color: #fff;
        cursor: pointer;
        font-size: 1.5rem;
        font-family: PremierSans-Bold,Arial,Helvetica Neue,Helvetica,sans-serif;
        font-weight: 400;
        -webkit-font-smoothing: antialiased;
        box-sizing: border-box;
    }

    nav {
        background-color: #37003c !important;
    }

    /* Extra small devices (phones, 600px and down) */
    @media only screen and (max-width: 600px) {
        .topnav-centered a {
            display: flex;
            float: none;
            position: absolute;
            top: 100%;
            left: 50%;
            transform: translate(-50%, -50%);
            font-size: large;
        }

        .topnav-left-centered {
            display: flex;
            float: none;
            position: absolute;
            top: 104%;
            left: 35%;
            transform: translate(-50%, -50%);
            font-size: large;
        }

        .topnav-right-centered {
            display: flex;
            float: none;
            position: absolute;
            top: 104%;
            right: 18%;
            transform: translate(-50%, -50%);
            font-size: large;
        }

        .topnav-dropdown {
            display: flex;
            float: none;
            position: absolute;
            top: 120%;
            right: 50%;
            transform: translate(-50%, -50%);
            font-size: large;
        }
    }

    /* Small devices (portrait tablets and large phones, 600px and up) */
    @media only screen and (min-width: 600px) {
        .topnav-centered  {
            display: flex;
            float: none;
            position: absolute;
            top: 100%;
            left: 50%;
            transform: translate(-50%, -50%);
            font-size: large;
        }

        .topnav-left-centered {
            display: flex;
            float: none;
            position: absolute;
            top: 104%;
            left: 35%;
            transform: translate(-50%, -50%);
            font-size: large;
        }

        .topnav-right-centered {
            display: flex;
            float: none;
            position: absolute;
            top: 104%;
            right: 18%;
            transform: translate(-50%, -50%);
            font-size: xx-large;
        }

        .topnav-dropdown {
            display: flex;
            float: none;
            position: absolute;
            top: 115%;
            right: 70%;
            transform: translate(-50%, -50%);
            font-size: large;
        }
    }

    /* Medium devices (landscape tablets, 768px and up) */
    @media only screen and (min-width: 768px) {
        nav {
        }
    }

    /* Large devices (laptops/desktops, 992px and up) */
    @media only screen and (min-width: 992px) {
        .topnav-centered  {
            display: flex;
            float: none;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            font-size: large;
        }

        .topnav-left-centered {
            display: flex;
            float: none;
            position: absolute;
            top: 50%;
            left: 30%;
            transform: translate(-50%, -50%);
            font-size: large;
        }

        .topnav-right-centered {
            display: flex;
            float: none;
            position: absolute;
            top: 50%;
            right: 48%;
            transform: translate(-50%, -50%);
            font-size: large;
        }

        .topnav-dropdown {
            display: flex;
            float: none;
            position: absolute;
            top: 50%;
            right: 100%;
            transform: translate(-50%, -50%);
            font-size: large;
            color: white;

        }
    }

    /* Extra large devices (large laptops and desktops, 1200px and up) */
    @media only screen and (min-width: 1200px) {
        .topnav-centered  {
            display: flex;
            float: none;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            line-height: 6rem;
            list-style-type: none;
            color: #fff;
            cursor: pointer;
            font-size: 1.5rem;
            font-family: PremierSans-Bold,Arial,Helvetica Neue,Helvetica,sans-serif;
            font-weight: 400;
            -webkit-font-smoothing: antialiased;
            box-sizing: border-box;
        }

        .topnav-left-centered {
            display: flex;
            float: none;
            position: absolute;
            top: 50%;
            left: 45%;
            transform: translate(-50%, -50%);
            font-size: large;
        }

        .topnav-right-centered {
            display: flex;
            float: none;
            position: absolute;
            top: 50%;
            right: 41%;
            transform: translate(-50%, -50%);
            font-size: large;
        }

        .topnav-dropdown {
            display: flex;
            float: none;
            position: absolute;
            top: 55%;
            right: 60%;
            transform: translate(-50%, -50%);
            font-size: small;

        }
    }

    body {
        background-color: #37003c;
    }


    a:hover {
        color: silver;
        text-decoration: none;

    }


</style>