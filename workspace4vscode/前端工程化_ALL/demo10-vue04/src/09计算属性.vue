<script setup>
//计算属性
import { reactive,computed } from 'vue';

    const author = reactive({
        name:"张三",
        books:["java","js","算法"]
    })

    function isPublish(){
        return author.books.length>0 ? "是":"否"
    }
    //每次使用时，如果和上次的数据相同，则不会重新计算
    let bookMssage = computed(() => {
        return author.books.length>0 ? "是":"否"
    })
</script>

<template>
    <div>
        <p>作者：{{ author.name }}</p>
        是否出版过图书：{{ isPublish() }}
        <br>
        是否出版过图书：{{ bookMssage }}
    </div>
</template>

<style scoped>

</style>
