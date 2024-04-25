import {createRouter, createWebHashHistory} from 'vue-router'

import Home from '../components/Home.vue'
import Login from '../components/Login.vue'

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path:"/home",
            component:Home
        },
        {
            path:"/",
            component:Login
        },
        {
            path:"/login",
            component:Login
        }
    ]
})

//用router的前置守卫，禁止在未登录时访问Home页面
router.beforeEach((to,from,next) =>{
    if(to.path == '/login'){
        //如果到登录页面，直接放行
        next()
    }else{
        //如果访问其他页面，查找是否有登录信息
        let isLogin = window.sessionStorage.getItem("username")
        if(null != isLogin){
            next()
        }else{
            //如果没有登录信息，跳转到登录页面
            next('/login')
        }
    }
})


export default router