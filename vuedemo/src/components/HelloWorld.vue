import dialogBar from './dialog.vue'
<template>
  <div class="hello">
    <h1>{{ msg }}</h1>

    <div>
      <h2>数据库表person插入信息</h2>
      <Form ref="personFormList" :model="personFormList" :rules="personRuleValidate" :label-width="80">
        <FormItem label="用户名" prop="username">
          <Input v-model="personFormList.username" placeholder="请输入用户名"/>
        </FormItem>
        <FormItem label="姓名" prop="name">
          <Input v-model="personFormList.name" placeholder="请输入姓名"/>
        </FormItem>
        <FormItem label="年龄" prop="age">
          <Input v-model="personFormList.age" placeholder="" number/>
        </FormItem>
        <FormItem label="电话号码" prop="telenum">
          <Input v-model="personFormList.teleno" placeholder=""/>
          <br>
        </FormItem>
      </Form>
      <button @click="handleAdd('personFormList')" style="font-size:25px">插入</button>
      <br><br>
      <h2>数据库表user删除信息</h2>
      <br>
      <Form ref="userFormList" :model="userFormList" :rules="userRuleValidate" :label-width="80">
        <FormItem label="用户名" prop="username">
          <Input v-model="userFormList.username" placeholder="请输入用户名"/>
        </FormItem>
      </Form>
      <br>
      <button @click="handleDel('userFormList')" style="font-size:25px">删除</button>
    </div>
    <br>
  </div>
</template>
<script>
import { UsersAddAction, UsersQryAction, UsersUpdateAction, UsersDelAction } from '../api/users';
import { PersonAddAction, PersonQryAction, PersonUpdateAction, PersonDelAction } from '../api/person';

const usernameLength = function(rule, value, callback) {
  if(value.length > 10) {
    return callback(new Error("用户名不能超过10字节"))
  }else if(value.length == 0){
    return callback(new Error("用户名不能为空！"))
  } else {
    callback();
  }
}

const nameLength = function(rule, value, callback) {
  if(value.length > 20) {
    return callback(new Error("姓名不能超过20字节"))
  }else if(value.length == 0){
    return callback(new Error("姓名不能为空！"))
  } else {
    callback();
  }
}

const telenoLength = function(rule, value, callback) {
  if(value.length > 11) {
    return callback(new Error("号码不能超过11字节"))
  } else {
    callback();
  }
}

export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: '表格',


      personFormList: {
        username: "",
        name: "",
        age: 0,
        teleno: ""
      },
      userFormList: {
        username: "",
        pass: ""
      },
      userData:[],
      personData: [],
      userRuleValidate: {
        username:[
          {
            required: true,
           // message: "用户名不能为空！",
            trigger: "blur",
            validator: usernameLength
          }
        ]
      },
      personRuleValidate: {
        username:[
          {
            required: true,
            //message:"用户名不能为空！",
            trigger: "blur",
            validator: usernameLength
          }
        ],
        name: [
          {
            required: true,
            // message:"姓名不能为空！",
            trigger: "blur",
            validator: nameLength,
          }
        ],
        age: [
          {
            type: "number",
            message: "年龄只能为数字！",
            trigger: "blur"
          }
        ],
        teleno: [
          {
            validator: telenoLength,
            // message: "号码不正确！",
            trigger: "blur",
          }
        ]
      }
    }
  },
  mounted: function() {
    this.userQry();
    this.personQry();
  },
  methods: {
    userQry() {
      UsersQryAction().then(res =>{
          this.userData = res.data;
        });
    },
    personQry() {
      PersonQryAction().then(res =>{
          this.personData = res.data;
        });
    },
    findUser() {
      let flag = false;
      this.userData.forEach(item => {
        if(item.username == this.userFormList.username)
          flag = true;
      });
      return flag;
    },
    findPerson() {
      let flag = false;
      this.personData.forEach(item =>{
        if(item.username == this.personFormList.username) 
          flag = true;
      });
      return flag;
    },
    personUpdate() {
      PersonUpdateAction(this.personFormList).then(res =>{
        this.$router.push({name: 'Operate', params: {action: "成功修改 ", database: "person ", username: this.personFormList.username}});
      });
    },
    personAdd() {
      PersonAddAction(this.personFormList).then(res =>{
        this.$router.push({name: 'Operate', params: {action: "成功插入 ", database: "person ", username: this.personFormList.username}});
      });
    },
    userAdd() {
      UsersAddAction(this.userFormList).then(res =>{
        // this.$router.push({name: 'Operate', params: {action: "成功插入 ", database: "person ", username: this.personFormList.username}});
      });
    },


    handleAdd(name) {
      this.$refs[name].validate(valid => {
        if(valid) {
          let flag = this.findPerson();
          if(flag) {
            this.personUpdate();
          }
          else {
            this.userFormList.username = this.personFormList.username;
            this.userFormList.pass = "888888";
            this.userAdd();
            this.personAdd();
          }
          // test
          // this.$router.push('/DBshow');
          // this.$router.push({name: 'Operate', params: {database: "person", username: this.personFormList.username}});
        } else {
          this.$Message.error("填写信息错误");
        }
      })
    },

    userDel() {
      UsersDelAction(this.userFormList.username).then(res => {
        this.$router.push({name: 'Operate', params: {action: "成功删除 ", database: "users ", username: this.userFormList.username}});
      });
    },
    personDel() {
      PersonDelAction(this.userFormList.username).then(res => {

      });
    },
    handleDel(name) {
      this.$refs[name].validate(valid => {
        if(valid) {
          this.$confirm('确定要删除该用户吗？', '提示',{
            confirmButtonText: '确定',
            concelButtonText: '取消',
            type: 'warning'
          }).then(() => {
          let flag = this.findUser();
          if(flag) {
            this.personDel();
            this.userDel();
          }
          else {
            this.$Message.error("此用户名不存在，无法删除！");
          }
            //this.$Message.success("删除成功！");
          }).catch(() => {
            this.$Message.info("已取消删除！");
          });  
        } else {
            this.$Message.error("填写信息错误");
        }
      })
    },
    
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
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
}
</style>
