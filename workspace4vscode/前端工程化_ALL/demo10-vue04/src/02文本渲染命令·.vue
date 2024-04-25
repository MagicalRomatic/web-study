<script setup>
//命令依赖标签
let msg = "hello vue3"
//命令支持模版字符串
let haha = "haha"
let msg2 = `hello ${haha}`
//命令中支持常见的运算符
let age = 17
//命令中支持常见对象API的调用
let bee = "蜜 蜂"
//命令中支持函数的调用
let getMsg = () => {
  return "hello"
}
//v-html 支持html结构的文本
let fontMsg = "<font color='red'>你好</font>"
</script>

<template>
  <div>
    <h1 v-text="msg"></h1>
    <h1 v-text="msg2"></h1>
    <h1 v-text="age >= 18 ? '成年':'未成年'"></h1>
    <h1 v-text="bee.split(' ').reverse().join('-')"></h1>
    <h1 v-text="getMsg()"></h1>
    <h1 v-html="fontMsg"></h1>
  </div>
</template>

<style scoped>

</style>
