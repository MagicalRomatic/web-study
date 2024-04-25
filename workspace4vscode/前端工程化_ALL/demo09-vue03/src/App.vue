<script setup>
//响应式的数据 引用ref
  import {ref} from 'vue';

  
      let counter = ref(10);
      function counterIncr(){
        counter.value++;
      }
      function counterDecr(){
        counter.value--;
      }
      function showCounter(){
        alert(counter.value);
      }
      
</script>

<template>
  <div>
    <button @click="counterIncr()">+</button>
    <span v-text="counter"></span>
    <button @click="counterDecr()">-</button>
    <button @click="showCounter()">showCounter</button>
  </div>
</template>

<style scoped>

</style>
