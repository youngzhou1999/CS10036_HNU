import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Operate from '@/components/Operate'
import DBshow from '@/components/DBshow'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld 
    },
    {
      path: '/Operate',
      name: 'Operate',
      component: Operate
    },
    {
      path: '/DBshow',
      name: 'DBshow',
      component: DBshow
    }
  ]
})
