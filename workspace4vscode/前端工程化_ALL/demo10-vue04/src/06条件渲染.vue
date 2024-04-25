<script setup>
    import { ref } from 'vue';
    let flag = ref(true);
</script>

<template>
    <div>
        <h1 v-if="flag">vue is awesome!</h1>
        <h1 v-else>oh no</h1>
        <button @click="flag = !flag">toggle</button>
    </div>
</template>

<style scoped>

</style>
