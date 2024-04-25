import axios from 'axios'

//使用axios创建一个可以发送请求的实例对象
const instance = axios.create({
    baseURL: "https://api.uomg.com/",
})


//设置请求拦截器
instance.interceptors.request.use(
    function(config){
        //请求之前设置请求信息
        config.headers.Accept = "application/json, text/plain, text/html,*/*"
        return config
    },
    function(error){
        console.log("请求拦截器异常的方法")

        return Promise.reject("something wrong")
    }
)

//设置响应拦截器
instance.interceptors.response.use(
    function(response){
        //响应状态码为200的信息
        console.log("response success")
        console.log(response)

        return response
    },
    function(error){
        //响应错误时
        console.log("response fail")
        console.log(error)

        //返回一个promise对象
        return Promise.reject("something wrong")
    }
)

//默认导出暴露
export default instance;