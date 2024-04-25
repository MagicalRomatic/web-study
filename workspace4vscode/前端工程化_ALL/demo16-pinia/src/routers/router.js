import {createRouter, createWebHashHistory} from 'vue-router'
import Operate from '../components/Operate.vue'
import List from '../components/List.vue'

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path:"/",
            component:List
        },
        {
            path:"/operate",
            component:Operate
        },
        {
            path:"/list",
            component:List
        }
    ]
})

export default router