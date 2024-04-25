<script setup>
  import { definedPerson } from '../store/store'
  let person = definedPerson()
</script>

<template>
  <div>
    <h1>修改pinia数据</h1>
    名字：<input type="text" v-model="person.username">
    年龄：<input type="text" v-model="person.age">
    爱好：
    篮球<input type="checkbox" value="篮球" v-model="person.hobbies">
    足球<input type="checkbox" value="足球" v-model="person.hobbies">
    乒乓球<input type="checkbox" value="乒乓球" v-model="person.hobbies">
    唱歌<input type="checkbox" value="唱歌" v-model="person.hobbies">
    跳舞<input type="checkbox" value="跳舞" v-model="person.hobbies"> <br>

    <button @click="person.doubleAge()">年龄加倍</button> <br>
    <button @click="person.$reset()">重置</button> <br>
    <button @click="person.$patch({username:'奥特曼',age:20,hobbies:['晒太阳','打怪兽']})">变身奥特曼</button> <br>

    {{ person }}
  </div>
  
</template>

<style scoped>

</style>
