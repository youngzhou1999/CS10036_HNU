<template>
    <div class="DataBase">
        <h1>{{ msg }}</h1>
        <br>
        <h2>user表</h2>
      <Table border :columns="columns1" :data="userlist"></Table>
      <br><br>
      <h2>person表</h2>
      <Table border :columns="columns2" :data="personlist"></Table>
      <br>
      <router-link to="/">返回数据库操作页面</router-link>
    </div>
</template>
<script>
// import axios from 'axios'
import { UsersQryAction } from '../api/users';
import {PersonQryAction} from '../api/person'
export default {
    name: 'DBshow',
    data () {
        return {
        msg: '数据库:',
        columns1: [
        {
          title: "用户名",
          key: "username"
        },
        {
          title: "密码",
          key: "pass"
        },
      ],
      columns2: [
        {
          title: "用户名",
          key: "username"
        },
        {
          title: "姓名",
          key: "name"
        },
        {
          title: "年龄",
          key: "age"
        },
        {
          title: "电话号码",
          key:"teleno"
        }
      ],
      userlist: [],
      personlist: []
        }
    },
    mounted: function() {
      this.userQry();
      this.personQry();
    },
    methods: {
      // UserQry() {
      //   UsersQryAction().then(res =>{
      //     this.datalist = res.data;
      //     console.log(this.datalist)
      //     this.data = res.data;
      //   })
      // },
    // UsersQry() {
    //     this.$axios.get('http://localhost:8080/api/users',)
    //     .then(res => {
    //         console.log(res)
    //         this.datalist = res.data;
    //     })
    //     .catch(err => {
    //         console.error(err); 
    //     })
    // },
    userQry() {
      UsersQryAction().then(res =>{
          this.userlist = res.data;
        })
    },
    personQry() {
      PersonQryAction().then(res =>{
          this.personlist = res.data;
        })
    },

      // mounted: {
      //   //console.log("nounted")
      //   this.UsersQry();
      // }
    }
    // methods:{
    //     hrefDB() {
    //         this.$router.push({
    //             path:''
    //         })
    //     }
    // }

  } 
</script>

<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
  font-size: 25px;
}
</style>