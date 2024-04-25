<script setup>
//编程式路由
  import { ref } from 'vue';
import { useRouter } from 'vue-router'
  let myPath = ref("")
  const router = useRouter()

  function toMyPage(){
    router.push(myPath.value)
  }

</script>

<template>
  <div>
    <!-- 利用双向绑定 -->
    <button @click="toMyPage()">Go</button><input type="text" v-model="myPath">
    <router-view></router-view>
  </div>
</template>

<style scoped>

</style>
