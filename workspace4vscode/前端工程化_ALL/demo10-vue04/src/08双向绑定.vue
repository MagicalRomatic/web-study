<script setup>
import { reactive, ref } from 'vue';

//v-model 双向绑定 一般用于表单
let user = reactive({
    username:"",
    userPwd:""
})

let hbs = ref([])
</script>

<template>
  <div>
    用户名:<input type="text" v-model="user.username"><br>
    密码:<input type="password" v-model="user.userPwd"><br>
    爱好：
    唱  <input type="checkbox" v-model="hbs" value="sing">
    跳  <input type="checkbox" v-model="hbs" value="dance">
    rap  <input type="checkbox" v-model="hbs" value="rap">
    <br>
    {{ user.username }} 
    <br>
    {{ user.userPwd }}
    <br>
    {{ hbs }}
  </div>
</template>

<style scoped>

</style>
