<script setup>
  import { definedPerson } from '../store/store'
  let person = definedPerson()
</script>

<template>
  <div>
    <h1>展示pinia数据</h1> <br>
    {{ person }}
  </div>
  
</template>

<style scoped>

</style>
