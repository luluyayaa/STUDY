
<template>
  <h1>欢迎您！ {{id}}</h1>
</template>

<script>
export default {
  props:['id'],
  name: "UserProfile",
  beforeRouteEnter: (to, from, next) => {
    console.log("准备进入个人信息页");
    next(vm => {
    //进入路由之前执行getData方法
    vm.getData()
  });
  },
    beforeRouteLeave: (to, from, next) => {
    console.log("准备离开个人信息页");
    next();
  },
  //axios
    methods: {
    getData: function () {
    this.axios({
    method: 'get',
    url: 'http://localhost:8080/static/mock/data.json'
  }).then(function (response) {
      console.log(response)
  })
  }
}
}
</script>

<style scoped>

</style>
