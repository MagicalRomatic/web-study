import {defineStore} from 'pinia'

export const definedUser = defineStore(
    "logonUser",

    {
        state: ()=>{
            return{
                uid:1,
                username:""
            }
        },
        getters:{

        },
        actions:{
            
        }
    }
)