import Vue from 'vue'
import App from './App'
import router from './router'//自动扫描里面的路由配置
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import  axios from 'axios'
import  VueAxios from 'vue-axios'

Vue.config.productionTip = false

Vue.use(router);
Vue.use(VueAxios,axios);
Vue.use(ElementUI);

new Vue({
  el: '#app',
  router,
  render:h=>h(App)
})
