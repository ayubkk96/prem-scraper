import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from './views/Home'
import About from './views/About'
import Arsenal from "@/views/Arsenal";
import AstonVilla from "@/views/AstonVilla";
import Brighton from "@/views/Brighton";
import Burnley from "@/views/Burnley";
import Chelsea from "@/views/Chelsea";
import CrystalPalace from "@/views/CrystalPalace";
import Everton from "@/views/Everton";
import Fulham from "@/views/Fulham";
import LeedsUnited from "@/views/LeedsUnited";
import Liverpool from "@/views/Liverpool";
import LeicesterCity from "@/views/LeicesterCity";
import ManchesterCity from "@/views/ManchesterCity";
import ManchesterUnited from "@/views/ManchesterUnited";
import NewcastleUnited from "@/views/NewcastleUnited";
import SheffieldUnited from "@/views/SheffieldUnited";
import Southampton from "@/views/Southampton";
import TottenhamHotspur from "@/views/TottenhamHotspur";
import WestBromwichAlbion from "@/views/WestBromwichAlbion";
import WestHamUnited from "@/views/WestHamUnited";
import WolverhamptonWanderers from "@/views/WolverhamptonWanderers";

Vue.use(VueRouter)

export const router = new VueRouter({
    mode: 'history',
    routes: [
        { path : '/', component: Home},
        { path : '/about', component: About},
        { path : '/Arsenal', component: Arsenal},
        { path : '/AstonVilla', component: AstonVilla},
        { path : '/Brighton', component: Brighton},
        { path : '/Burnley', component: Burnley},
        { path : '/Chelsea', component: Chelsea},
        { path : '/CrystalPalace', component: CrystalPalace},
        { path : '/Everton', component: Everton},
        { path : '/Fulham', component: Fulham},
        { path : '/LeedsUnited', component: LeedsUnited},
        { path : '/Liverpool', component: Liverpool},
        { path : '/LeicesterCity', component: LeicesterCity},
        { path : '/ManchesterCity', component: ManchesterCity},
        { path : '/ManchesterUnited', component: ManchesterUnited},
        { path : '/NewcastleUnited', component: NewcastleUnited},
        { path : '/SheffieldUnited', component: SheffieldUnited},
        { path : '/Southampton', component: Southampton},
        { path : '/TottenhamHotspur', component: TottenhamHotspur},
        { path : '/WestBromwichAlbion', component: WestBromwichAlbion},
        { path : '/WestHamUnited', component: WestHamUnited},
        { path : '/WolverhamptonWanderers', component: WolverhamptonWanderers}
    ]
})