<script setup>
  import request from './axios'
  import {ref} from 'vue'

  let message = ref("")

  function getLoveWord(){
    //用get方法发请求
    return request.get("api/rand.qinghua?format=json")
  }

  async function getLoveMessage(){
    //利用axios向服务器请求数据
    //axios设置请求的参数  1.请求url  2.请求方式  3.请求参数
    let promise = getLoveWord()
    //拿到了response里的data数据
    let {data} = await promise

    message.value = data.content
    
  }
</script>

<template>
  <div>
    <h1 v-text="message"></h1>
    <button @click="getLoveMessage()">变</button>
  </div>
  
</template>

<style scoped>

</style>
