<script setup>
  import axios from 'axios'
  import {ref} from 'vue'

  let message = ref("")

  function getLoveMessage(){
    //利用axios向服务器请求数据
    //axios设置请求的参数  1.请求url  2.请求方式  3.请求参数
    let promise = axios({
      method:"get",
      url:"https://api.uomg.com/api/rand.qinghua?format=json",
      data:{

      }
    })

    promise.then(
      function(response){
        console.log(response.data.content)
        message.value = response.data.content
      }
    ).catch(
      function(){}
    )
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
