<script setup>
import {ref} from 'vue'
//v-on 事件渲染
function fun(){
    alert("hi")
}

function fun02(event){
    let flag = confirm("确定跳转链接？")
    if(!flag){
        event.preventDefault()
    }
}

function fun03(){
    alert("hi")
}

let counter = ref(1)
</script>

<template>
  <div>
    <button v-on:click="fun()">hello</button>
    <!-- 内联事件处理器 -->
    <button @click="counter++">+</button>
    {{ counter }}
    <br>
    <a href="http://www.atguigu.com" v-on:click="fun02($event)">尚硅谷</a>
    <a href="http://www.atguigu.com" v-on:click.prevent="fun03()">尚硅谷</a>
  </div>
</template>

<style scoped>

</style>
