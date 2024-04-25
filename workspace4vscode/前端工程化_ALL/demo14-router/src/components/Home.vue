<script setup>
    import {useRouter} from 'vue-router'
    const router = useRouter()
    let username = window.sessionStorage.getItem("username")

    function logout() {
        //销毁数据
        window.sessionStorage.removeItem("username")
        //返回Login页面
        router.push("/login")
    }
</script>

<template>
  <div>
    <h1>Home页面</h1>
    <h3>欢迎{{ username }}登录</h3>
    <button @click="logout()">退出登录</button>
  </div>
</template>

<style scoped>

</style>
