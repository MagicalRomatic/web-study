<script setup>
  import { ref, onUpdated } from 'vue';
  import { useRoute } from 'vue-router'
  
  let languageId = ref(0)
  let languageName = ref("")
  //useRoute是接收参数
  let route = useRoute()
  languageId.value = route.params.id
  languageName.value = route.params.language
  
  onUpdated(() =>{
    languageId.value = route.params.id
    languageName.value = route.params.language
  })
</script>

<template>
  <div>
    <h1>showDetail接收路径信息</h1>
    <h3>{{ languageId }}{{ languageName }}是世界上最好的编程语言</h3>
  </div>
  
</template>

<style scoped>

</style>
