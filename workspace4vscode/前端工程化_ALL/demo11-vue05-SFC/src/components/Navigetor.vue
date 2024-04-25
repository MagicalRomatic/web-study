<script setup>
    //不同文件之间的传参 利用父子关系
    import {defineEmits} from 'vue'
    //定义一个向父组件提交的事件 事件名自定义
    const emits = defineEmits(["sendMenu"])

    function send(data){
        emits("sendMenu", data)
    }

</script>

<template>
    <div>
        <ul>
            <li @click="send('学生管理')">学生管理</li>
            <li @click="send('项目管理')">项目管理</li>
            <li @click="send('签到点名')">签到点名</li>
            <li @click="send('作业完成')">作业完成</li>
            <li @click="send('最终成绩')">最终成绩</li>
        </ul>
    </div>
</template>

<style scoped>

</style>
