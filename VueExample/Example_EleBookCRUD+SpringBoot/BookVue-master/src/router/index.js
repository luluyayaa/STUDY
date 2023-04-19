import Vue from 'vue'
import VueRouter from 'vue-router'
import BookUpdate from '../views/BookUpdate'
import BookManage from '../views/BookManage'
import AddBook from '../views/AddBook'
import Book from '../views/Book'
import Index from "../views/Index";


Vue.use(VueRouter)


const routes = [
  // 动态路由导航栏
  {
    // 什么都不写默认跳转/bookManage
    //一级菜单，index[0]
    path: '/',
    name: "图书管理",
    component: Index,
    redirect:"/bookManage",
    show:true,
    //二级菜单
    children:[

      {
        path: '/bookManage',
        name: "查询图书",
        component: BookManage
      },
      {
        path: '/addBook',
        name: "添加图书",
        component: AddBook
      }
    ]
  },
    //一级菜单,index[1]
    //show则遍历，false则不遍历
  {
    path: '/update',
    show: false,
    component: BookUpdate
  }


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
