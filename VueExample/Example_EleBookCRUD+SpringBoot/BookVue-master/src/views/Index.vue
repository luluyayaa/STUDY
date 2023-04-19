<!--
主框架
-->
<template>
<!--框架-->
    <el-container style="height: 500px; border: 1px solid #eee">
<!--定义侧边栏-->
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
<!-- 定义菜单,添加router属性,默认加载 index为0 ,1的一级菜单-->
            <el-menu router :default-openeds="['0','1']">
                                <!-- 嵌套循环打印菜单-->
<!--一级菜单,循环打印index递增,index="index+''"-->
                <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''" v-if="item.show">
<!--                    设置样式-->
                    <template #title><i class="el-icon-setting"></i>{{item.name}}</template>
<!--二级菜单,index设置为跳转的router,:index="item2.path"-->
                    <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path"
                                  :class="$route.path==item2.path?'is-active':''">{{item2.name}}
<!--                    设置样式：route.path==item2.path（浏览器路径=子路径，则设置'is-active'触发样式）-->
                    </el-menu-item>
                </el-submenu>
            </el-menu>
        </el-aside>

 <!--动态渲染选择的router-->
        <el-main>
            <router-view></router-view>
        </el-main>

    </el-container>

</template>

<script>
    export default {
        name: "Index"
    }
</script>

<style scoped>

</style>