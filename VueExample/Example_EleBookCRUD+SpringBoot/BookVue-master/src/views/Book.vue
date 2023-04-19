<!--后端连接测试-->
<template>
    <div>
        <table>
            <tr>
                <td>编号</td>
                <td>书名</td>
                <td>作者</td>
                <td>出版社</td>
                <td>页数</td>
                <td>价格</td>
            </tr>

            <tr v-for="book in books">
                <td>{{book.id}}</td>
                <td>{{book.name}}</td>
                <td>{{book.author}}</td>
                <td>{{book.publish}}</td>
                <td>{{book.pages}}</td>
                <td>{{book.price}}</td>
            </tr>
        </table>
    </div>
</template>

<script>
    export default {
        name: "Book",
        data() {
            return {
                books: [
                    {
                        id: 1,
                        name: '解忧杂货店',
                        author: '东野圭吾',
                        publish: '电子工业出版社',
                        pages: 100,
                        price: 22
                    }
                ]
            }
        },
      //钩子函数初始化操作
        created() {
           //提升作用域
            const _this = this
            axios.get('http://localhost:8181/book/findAll/').then(function (resp) {
             _this.books = resp.data
            })
        }
    }
</script>

<style scoped>

</style>