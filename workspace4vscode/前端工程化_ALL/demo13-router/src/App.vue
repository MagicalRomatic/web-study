<script setup>
//编程式路由
  import { ref } from 'vue';
  import { useRouter } from 'vue-router'
  
  let router = useRouter()
  function toPath(id,language){
    //router.push({path:'/showDetail2', query:{id:id, language:language}})
    router.push(`/showDetail/${id}/${language}`)
  }

  
</script>

<template>
  <div>
    <router-link to="/showDetail/1/java">showDetail声明式路径传参</router-link>
    <button @click="toPath(2,'PHP')">编程式路径传参</button>
    <hr>

    <router-link to="/showDetail2?id=1&language=java">showDetail声明式键值对传参</router-link>
    <br>
    <!-- 用v-bind更灵活一点 -->
    <router-link v-bind:to="{path:'/showDetail2', query:{id:2, language:'php'}}">showDetail声明式键值对对象式传参</router-link>
    <button @click="toPath(3,'python')">编程式键值对传参</button>
    <hr>

    <router-view></router-view>
    
  </div>
</template>

<style scoped>

</style>
