<script setup>
import { reactive, ref,watch, watchEffect } from 'vue';

//watch函数监听一个ref式的响应数据
    let firstname = ref('')
    //lastname为什么刚才用ref响应就没有反应呢？
    let lastname = reactive({
        name:""
    })
    let fullname = ref('')

    watch(firstname, (newValue, oldValue) =>{
        console.log(`${oldValue}变为${newValue}`)
        fullname.value = newValue + lastname.name
    })

//watch函数监听reactive式的响应数据
    watch(()=>lastname.name, (newValue, oldValue) =>{
        console.log(`${oldValue}变为${newValue}`)
        fullname.value = firstname.value + newValue
    })

//任何的响应式数据，都可以直接监听，无需放入参数
    watchEffect(() =>{
        fullname.value = firstname.value + lastname.name
        console.log('watchEffect执行了')
    })
</script>

<template>
    <div>
        firstname: <input type="text" v-model="firstname"><br>
        lastname: <input type="text" v-model="lastname.name"><br>
        fullname: {{fullname}}
    </div>
</template>

<style scoped>

</style>
