import Vue from'vue'
import Router from 'vue-router'

//导入上面定义的组件
import Content from '../components/Content'
import Main from '../views/Main'
import Login from "../views/Login"
import UserList from '../views/user/List'
import UserProfile from '../views/user/Profile'
import NotFound from '../views/NotFound'

//安装路由
Vue.use(Router) ;
//配置路由
export default new Router({
  mode:'history',
  routes:[
    {
      //路由路径
      path:'/content',
      name:'Content',
      //跳转到组件
      component:Content
    },{
      //路由路径
      path:'/main/:name',
      //跳转到组件
      name:'Main',
      component:Main,
      props:true,
      //路由嵌套
      children : [
        {path : '/user/profile/:id',name:'UserProfile',component :UserProfile,props:true},
        {path : '/user/list/:name',name:'UserList',component :UserList,props:true},
      ]
    }, {
      path: '/login',
      name:'Login',
      component: Login
    }, {
      path:'/gohome',
      name:'main',
      redirect:'/main'
    }, {
    // 匹配不到就走*
      path:'*',
      name:'notfound',
      component:NotFound
    }
  ]
});
