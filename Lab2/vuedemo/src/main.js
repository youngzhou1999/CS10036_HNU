import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'
import router from './router'
import 'iview/dist/styles/iview.css'
import iView from 'iview';
import store from './store';
import elementui from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'
// 引用axios，并设置基础URL为后端服务api地址
var axios = require('axios')
axios.defaults.baseURL = 'https://localhost:8080/api'
// axios.withCredentials= true
// 将API方法绑定到全局
Vue.prototype.$axios = axios
Vue.config.productionTip = false


Vue.use(VueRouter);
Vue.use(iView);
Vue.use(elementui);
new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
