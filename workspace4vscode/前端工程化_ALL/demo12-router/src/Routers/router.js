import {createRouter, createWebHashHistory} from 'vue-router'

//导入vue组件
import Home from '../components/Home.vue'
import List from '../components/List.vue'
import Update from '../components/Update.vue'

//创建Router对象
const router = createRouter({
    //历史记录
    history: createWebHashHistory(),
    //路由配置
    routes:[
        {
            path:"/home", 
            component:Home
        },
        {
            path:"/list", 
            component:List
        },
        {
            path:"/update", 
            component:Update
        },
        {
            path:"/",
            component:Home
        },
        {
            path:"/show",
            redirect:"/list"
        }
    ]
})

//向外暴露router
export default router