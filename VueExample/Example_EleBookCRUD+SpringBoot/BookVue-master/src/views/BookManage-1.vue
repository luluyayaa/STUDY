
<template>
  <div>
    <!--表格-->
    <el-table
        :data="tableData"
        border
        style="width: 100%">
      <el-table-column
          fixed
          prop="id"
          label="编号"
          width="150">
      </el-table-column>
      <el-table-column
          prop="name"
          label="书名"
          width="120">
      </el-table-column>
      <el-table-column
          prop="author"
          label="作者"
          width="120">
      </el-table-column>
      <el-table-column
          prop="publish"
          label="出版社"
          width="120">
      </el-table-column>
      <el-table-column
          prop="pages"
          label="页数"
          width="600">
      </el-table-column>
      <el-table-column
          prop="price"
          label="价格"
          width="120">
      </el-table-column>
      <el-table-column
          fixed="right"
          label="操作"
          width="100">
        <template #default="scope">
          <!--              scope.row返回当行数据-->
          <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
          <el-button @click="deteleBook(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--设置分页,根据total与page-size计算页数，@current-change="page"创建点击事件-->
    <el-pagination
        background
        layout="prev, pager, next"
        page-size="5"
        :total="total"
        @current-change="page">
    </el-pagination>
  </div>
</template>

<script>
export default {
  methods: {
    // 重定向/update并传递参数
    edit(row) {
      this.$router.push({
        path:'/update',
        query:{
          name:row.name,
          id:row.id
        }
      })
    },
    // window.location.reload()动态刷新页面
    deteleBook(row) {
      const _this = this
      axios.delete('http://localhost:8181/book/'+row.id).then(function (resp) {
        _this.$alert('《'+row.name  +'》 删除成功!', '', {
          confirmButtonText: '确定',
          callback: action => {
            window.location.reload()

          }
        });
      })
    },
    page(currentPage){
      const _this = this
      axios.get('http://localhost:8181/book/'+currentPage+'/5').then(function (resp) {
        _this.tableData = resp.data.content
        _this.total = resp.data.totalElements
      })
    }
  },

  data() {
    return {
      total: null,
      tableData: null,
    }
  },
  //回调数据
  created() {
    const _this = this
    axios.get('http://localhost:8181/book/findAll/1/5').then(function (resp) {
      _this.tableData = resp.data.content
      _this.total = resp.data.totalElements
    })
  }
}
</script>

<style>

</style>
