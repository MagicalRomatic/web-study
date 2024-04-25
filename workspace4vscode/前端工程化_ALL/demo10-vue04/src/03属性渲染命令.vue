<script setup>
  //v-bind 代表标签的属性值
  const data = {
    imgUrl:"https://tse3-mm.cn.bing.net/th/id/OIP-C.7KW5GT7NQ8yUGlBbCHEm0gHaNK?w=1024&h=1820&rs=1&pid=ImgDetMain",
    name:"某图"
  }

</script>

<template>
  <div>
    <img v-bind:src="data.imgUrl" v-bind:title="data.name">
  </div>
</template>

<style scoped>

</style>
