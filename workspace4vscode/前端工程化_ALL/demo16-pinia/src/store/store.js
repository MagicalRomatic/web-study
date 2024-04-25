import {defineStore} from 'pinia'

export const definedPerson = defineStore(
    {
        id:"personStore",   //唯一
        
        state:()=>{
            //状态也就是响应式数据
            return{
                username:"张三",
                age:18,
                hobbies:["篮球","足球","乒乓球"]
            }
        },

        getters:{
            //获得数据或者使用计算结果
            getAge(){
                return this.age
            },
            getHobbiesCount(){
                return this.hobbies.length
            }
        },

        actions:{
            doubleAge(){
                this.age *= 2
            }
        }
    })