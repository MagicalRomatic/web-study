<script setup>
  import {ref, reactive} from 'vue'  
  import request from '../utils/request'
  import { useRouter } from 'vue-router'
  import { definedUser } from '../store/userStore'

  let sysUser = definedUser()
  let router = useRouter()

  let loginUser = reactive({
    username:"",
    userPwd:""
  })

  let usernameMsg = ref("")
  let userPwdMsg = ref("")

  function checkUsername(){
    let username = /^[0-9a-zA-Z]{5,10}$/
    
    if(!username.test(loginUser.username)){
      usernameMsg.value = "用户名不合法"
      return false
    } 

    usernameMsg.value = "ok"
    return true
  }

  function checkUserPwd(){
    let userPwd = /^[0-9]{6}$/
    if(!userPwd.test(loginUser.userPwd)){
      userPwdMsg.value = "密码不合法"
      return false
    }

    userPwdMsg.value = "ok"
    return true
  }

  //进行登录业务的操作
  async function login(){
    let flag1 = checkUsername()
    let flag2 = checkUserPwd()

    if(!flag1 || !flag2){
      return
    }
    
    //发送给后端服务器
    let {data} = await request.post("user/login",loginUser)
    //处理后端服务器响应的信息
    console.log(data)

    if(data.code == 200){
      alert("登录成功")
      console.log(data)

      sysUser.uid = data.data.loginUser.uid
      sysUser.username = data.data.loginUser.username
      //登录成功，跳转到show页面
      router.push("/showSchedule")
      //登录成功，将用户信息更新到pinia中
    }else if(data.code == 501){
      //登录失败，给出提示信息
      alert("用户名错误")
    }else if(data.code == 503){
      alert("密码错误")
    }else{
      alert("未知错误")
    }
  }
</script>

<template>
  <div>
    <h3 class="ht">请登录</h3>
        <table class="tab" cellspacing="0px">
            <tr class="ltr">
                <td>请输入账号</td>
                <td>
                    <input class="ipt" 
                    type="text" 
                    v-model="loginUser.username"
                    @blur="checkUsername()">
                    <span id="usernameMsg" v-text="usernameMsg"></span>
                </td>
            </tr>
            <tr class="ltr">
                <td>请输入密码</td>
                <td>
                    <input class="ipt" 
                    type="password" 
                    v-model="loginUser.userPwd"
                    @blur="checkUserPwd()">
                    <span id="userPwdMsg" v-text="userPwdMsg"></span>
                </td>
            </tr>
            <tr class="ltr">
                <td colspan="2" class="buttonContainer">
                    <input class="btn1" type="button" @click="login()" value="登录">
                    <input class="btn1" type="button" value="重置">
                    <router-link to="/regist">
                      <button class="btn1">去注册</button>
                    </router-link>
                </td>
            </tr>
        </table>
  </div>
</template>

<style scoped>
        .ht{
            text-align: center;
            color: cadetblue;
            font-family: 幼圆;
        }
        .tab{
            width: 500px;
            border: 5px solid cadetblue;
            margin: 0px auto;
            border-radius: 5px;
            font-family: 幼圆;
        }
        .ltr td{
            border: 1px solid  powderblue;
        }
        .ipt{
            border: 0px;
            width: 50%;
        }
        .btn1{
            border: 2px solid powderblue;
            border-radius: 4px;
            width:60px;
            background-color: antiquewhite;
        }
        #usernameMsg , #userPwdMsg {
            color: gold;
        }
        .buttonContainer{
            text-align: center;
        }
</style>
