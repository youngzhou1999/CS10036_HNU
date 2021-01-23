<template>
    <div class="Result">
        <h1>{{ msg }}</h1>
        <!-- <Table border :columns="columnsAction" :data="mes"></Table> -->
        <!-- <keep-alive>
        <li v-text= mes></li>
        </keep-alive> -->
        
        <div class="text-wrapper">{{this.$store.state.mes}}</div>
        <br>
        <router-link to="/DBshow">查看数据库数据</router-link>
    </div>
</template>
<script>
export default {
    name: 'Operate',
    data () {
        return {
        msg: '数据库操作结果：',
        action: "",
        database: "",
        username: "",
        mes: "",
        // columnsAction: [
        //   {
        //     title: "操作",
        //     key: ""
        //   }
        // ]
        }
    },
    // methods:{
    //     hrefDB() {
    //         this.$router.push({
    //             path:''
    //         })
    //     }
    // }
    mounted: function() {
      this.show();
    },
    methods: {
      show() {
        this.username = this.$route.params.username;
        this.database = this.$route.params.database;
        this.action = this.$route.params.action;
        this.$store.commit('show', this.mes + this.action + this.database + this.username + '\n');
        //this.$store.mutations.show(this.mes + this.action + this.database + this.username + '\n');
      },

    }

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
}
.text-wrapper {
  white-space: pre-wrap;
}
</style>