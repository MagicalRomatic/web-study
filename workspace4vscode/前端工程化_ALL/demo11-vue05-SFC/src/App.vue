<script setup>
  import Header from './components/Header.vue'
  import Navigetor from './components/Navigetor.vue'
  import Context from './components/Context.vue'
import { ref } from 'vue'

  let menu = ref("")
  function receiver(data){
    menu.value = data
  }

</script>

<template>
  <div>
    <Header class="Header"></Header>
    <!-- 子传父事件名对应的方法receiver不用加括号 -->
    <Navigetor class="Navigetor" @sendMenu="receiver"></Navigetor>
    <Context class="Context" :message="menu"></Context>

  </div>
</template>

<style scoped>
.Header {
  height: 80px;
  border: 1px solid red;
}

.Navigetor {
  width: 35%;
  height: 650px;
  border: 1px solid green;
  float: left;
}

.Context {
  width: 63%;
  height: 650px;
  border: 1px solid blue;
  float: right;
}
</style>
