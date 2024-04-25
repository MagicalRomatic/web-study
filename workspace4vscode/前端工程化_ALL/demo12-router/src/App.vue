<script setup>

</script>

<template>
  <div>
    开头内容 <br>
    <router-link to="/list">list页</router-link>
    <hr>
    <!-- 此标签中间展示.vue文件 -->
    <router-view></router-view>
    <hr>
    结尾内容
  </div>
  
</template>

<style scoped>

</style>
