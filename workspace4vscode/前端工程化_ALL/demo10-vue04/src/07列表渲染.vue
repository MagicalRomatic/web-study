<script setup>
import { reactive } from 'vue';

let items = reactive([
    {
        id:"item1",
        name:"薯片"
    },
    {
        id:"item2",
        name:"可乐"
    },
    {
        id:"item3",
        name:"炸鸡"
    }

])


let carts = reactive([
    {
        name:"薯片",
        price:5,
        number:3
    },
    {
        name:"可乐",
        price:4,
        number:6
    },
    {
        name:"炸鸡",
        price:12,
        number:2
    }
])

//求购物车中的物品总和
function compute(){
    let total = 0
    for(let index in carts){
        total += carts[index].price*carts[index].number
    }

    return total
}

//删除购物车里物品
function deleteItem(index){
    carts.splice(index,1)
}

//一键清空购物车
function clearCart(){
    carts.splice(0,carts.length)
}
</script>

<template>
  <div>
    <table border="1px">
        <thead>
            <tr>
                <th>序号</th>
                <th>名称</th>
                <th>价格</th>
                <th>数量</th>
                <th>小计</th>
                <th>操作</th>
            </tr>
        </thead>
        <!-- 当购物车里有东西时 -->
        <tbody v-if="carts.length > 0">
            <tr v-for="(cart,index) in carts" :key="index">
                <td v-text="index+1"></td>
                <td>{{ cart.name }}</td>
                <td>{{ cart.price }}</td>
                <td>{{ cart.number }}</td>
                <td v-text="cart.number*cart.price"></td>
                <td>
                    <button @click="deleteItem(index)">删除</button>
                </td>
            </tr>
        </tbody>
        <!-- 购物车清空时 -->
        <tbody v-else>
            <tr>
                <td colspan="6">购物车清空</td>
            </tr>
            
        </tbody>
    </table>
    <br>
    <button @click="clearCart()">一键清空购物车</button>
    <br>
    购物车共计{{ compute() }}元

    <hr>
    <ul>
        <li v-for="item in items" v-bind:key="item.id">
        {{ item.name }}
        </li>
    </ul>
  </div>
</template>

<style scoped>

</style>
