<template>
    <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="图书名称" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>

        <el-form-item label="作者" prop="author">
            <el-input v-model="ruleForm.author"></el-input>
        </el-form-item>

        <el-form-item label="出版社" prop="publish">
            <el-input v-model="ruleForm.publish"></el-input>
        </el-form-item>

        <el-form-item label="页数" prop="pages">
            <el-input v-model="ruleForm.pages"></el-input>
        </el-form-item>

        <el-form-item label="价格" prop="price">
            <el-input v-model="ruleForm.price"></el-input>
        </el-form-item>


        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        data() {
            return {
               // 双向绑定
                ruleForm: {
                    name: '',
                    author: '',
                    publish: '',
                    pages:'',
                    price: '',
                },
               //表单验证，required: true必填项，message提示信息，trigger触发事件blur失焦
                rules: {
                    name: [
                        {required: true, message: '图书名不能为空', trigger: 'blur'},
                    ],
                    author: [
                        {required: true, message: '作者名不能为空', trigger: 'blur'},
                    ] ,
                    publish: [
                        {required: true, message: '出版社不能为空', trigger: 'blur'},
                    ] ,
                    pages: [
                        {required: true, message: '页数不能为空', trigger: 'blur'},
                    ] ,
                    price: [
                        {required: true, message: '价格不能为空', trigger: 'blur'},
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.post("http://localhost:8181/book/save", this.ruleForm).then(function (resp) {
                            if (resp.data == "success") {
                              // 从官网找样式直接调方法
                                _this.$alert('《'+_this.ruleForm.name  +'》 添加成功!', '', {
                                        confirmButtonText: '确定',
                                        //样式中的回调函数。流程结束则路由跳转
                                        callback: action => {
                                                _this.$router.push('/bookManage')
                                        }
                                    });

                            }

                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style>

</style>
