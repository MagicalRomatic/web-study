<script setup>
  import {ref, reactive} from 'vue'
  import request from '../utils/request'
  import { useRouter } from 'vue-router'

  let router = useRouter()

  let registUser = reactive({
    username:"",
    userPwd:""  
  })

  let usernameMsg = ref("")
  let userPwdMsg = ref("")
  let reUserPwd = ref("")
  let reUserPwdMsg = ref("")

  async function checkUsername(){
    let username = /^[0-9a-zA-Z]{5,10}$/
    
    if(!username.test(registUser.username)){
      usernameMsg.value = "用户名不合法"
      return false
    } 

    //注册时不仅要校验格式是否合法，还要校验是否已经被注册
    //用axios检验浏览器是否已经有该用户
    //出现跨域处理的问题  使用后端的跨域过滤器
    let {data} = await request.post(`/user/checkUsernameUsed?username=${registUser.username}`)
    if(data.code != 200){
      //用户名已经被注册
      usernameMsg.value = "用户名不可用"
      return false
    }

    usernameMsg.value = "可用"
    return true
  }

  function checkUserPwd(){
    let userPwd = /^[0-9]{6}$/
    if(!userPwd.test(registUser.userPwd)){
      userPwdMsg.value = "密码不合法"
      return false
    }

    userPwdMsg.value = "ok"
    return true
  }

  function checkReUserPwd(){
    let userPwd = /^[0-9]{6}$/
    if(!userPwd.test(reUserPwd.value)){
      reUserPwdMsg.value = "密码不合法"
      return false
    }

    if(registUser.userPwd != reUserPwd.value){
      reUserPwdMsg.value = "两次密码不一致"
      return false
    }

    reUserPwdMsg.value = "ok"
    return true
  }

  //实现注册的功能
  async function regist(){
    //校验输入是否合法
    let flag1 = await checkUsername()
    let flag2 = checkUserPwd()
    let flag3 = checkReUserPwd()
    
    if(flag1 && flag2 && flag3){
      //输入合法的话，将信息发给后端服务器，由后端服务器进行处理
      //将用户名和密码转为JSON字符串发送
      let {data} = await request.post("/user/regist",registUser)
      console.log(data)

      if(data.code == 200){
        //如果注册成功，就跳转到登录页面
        router.push("/login")
      }else{
        alert("注册失败")
      }
    }else{
      alert("用户名已占用")
    }
  }
</script>

<template>
  <div>
    <h3 class="ht">请注册</h3>

    <table class="tab" cellspacing="0px">
        <tr class="ltr">
            <td>请输入账号</td>
            <td>
                <input class="ipt" 
                  id="usernameInput" 
                  type="text" 
                  name="username" 
                  v-model="registUser.username"
                  @blur="checkUsername()">

                <span id="usernameMsg" class="msg" v-text="usernameMsg"></span>
            </td>
        </tr>
        <tr class="ltr">
            <td>请输入密码</td>
            <td>
                <input class="ipt" 
                id="userPwdInput" 
                type="password" 
                name="userPwd" 
                v-model="registUser.userPwd"
                @blur="checkUserPwd()">
                <span id="userPwdMsg" class="msg" v-text="userPwdMsg"></span>
            </td>
        </tr>
        <tr class="ltr">
            <td>确认密码</td>
            <td>
                <input class="ipt" 
                id="reUserPwdInput" 
                type="password" 
                v-model="reUserPwd"
                @blur="checkReUserPwd()">
                <span id="reUserPwdMsg" class="msg" v-text="reUserPwdMsg"></span>
            </td>
        </tr>
        <tr class="ltr">
            <td colspan="2" class="buttonContainer">
                <input class="btn1" type="button" @click="regist()" value="注册">
                <input class="btn1" type="button" value="重置">
                <router-link to="/login">
                  <button class="btn1">去登录</button>
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
        .msg {
            color: gold;
        }
        .buttonContainer{
            text-align: center;
        }
</style>