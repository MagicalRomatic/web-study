<script setup>
//响应式数据
//reactive 作用于对象
import {reactive} from 'vue'
let person = reactive({
    name:"",
    age:7
})

function incrAge(){
    person.age++
}

</script>

<template>
  <div>
    <button @click="incrAge()">+</button>
    <button @click="person.age++">+</button>
    {{ person.age }}
  </div>
</template>

<style scoped>

</style>
