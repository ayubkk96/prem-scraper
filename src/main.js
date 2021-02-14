import Vue from 'vue'
import App from './App'
import VueResource from 'vue-resource';

Vue.use(VueResource);

import { router } from './routes'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'




import { BJumbotron } from 'bootstrap-vue'
Vue.component('b-jumbotron', BJumbotron)
// Install BootstrapVue
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)


Vue.config.productionTip = false

new Vue({
    router,
    el: '#app',
    render: h => h(App),
}).$mount('#app');