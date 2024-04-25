import { createApp } from 'vue'

//配置router进行使用
import router from './Routers/router'
import App from './App.vue'

const app = createApp(App)
app.use(router)
app.mount('#app')
