import {createRouter, createWebHashHistory} from 'vue-router'

import ShowSchedule from '../components/ShowSchedule.vue'
import Login from '../components/Login.vue'
import Regist from '../components/Regist.vue'
import pinia from '../pinia.js'
import {definedUser} from '../store/userStore.js'


let sysUser = definedUser(pinia)
const router = createRouter({
    history: createWebHashHistory(),
    routes:[
        {
            path:"/",
            redirect:"/showSchedule"
        },
        {
            path:"/login",
            component:Login
        },
        {
            path:"/regist",
            component:Regist
        },
        {
            path:"/showSchedule",
            component:ShowSchedule
        }
    ]
})

//router的 全局前置守卫防止随意访问show页面
router.beforeEach((to, from, next)=>{
    if(to.path == "/showSchedule"){
        //判断是否登录过，
        //没登陆过，重定向
        if(sysUser.username == ""){
            next("/login")
        }else{
            next()
        }
    }else{
        next()
    }
})

export default router