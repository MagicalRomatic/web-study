<script setup>
    import { ref } from 'vue';
    import { useRouter } from 'vue-router';
    let router = useRouter()

    let username = ref('')
    let password = ref('')

    function login() {
        //如果用户名和密码都正确，登录成功，跳转Home组件
        if(username.value=='root' && password.value=='123456'){
            //router编程式跳转
            router.push("/home")
            //将用户名保存在浏览器上
            window.sessionStorage.setItem("username", username.value)
        }else{
            //用户名或密码错误，弹出提示信息
            alert("用户名或密码错误")
        }
    }
</script>

<template>
    <div>
      <!-- 登录用户名和密码 -->
      用户名：<input type="text" v-model="username"> <br>
      密码：<input type="password" v-model="password"> <br>
      <button @click="login()">登录</button>
    </div>
  

</template>

<style scoped>

</style>
