<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>LUNA的书店</title>
    <link rel="stylesheet" type="text/css" href="css/back.css" charset="utf-8">
    <link rel="stylesheet" href="css/iconfont.css">
    <style>
        @font-face {
            font-family: 'iconfont';
            /* Project id 3346226 */
            src: url('font/iconfont.woff2') format('woff2'), url('font/iconfont.woff') format('woff'), url('font/iconfont.ttf') format('truetype');
        }
    </style>
</head>

<body>
<div id="header">
</div>
<div id="menu">
    <a href="#"><span class="iconfont icon-a-caozhiwu"></span>后台管理首页</a>
    <a href="#"><span class="iconfont icon-a-guoshushuzhiwu"></span>书本信息管理</a>
    <a href="#"><span class="iconfont icon-a-huahuaduopenzaizhiwu"></span>用户订单管理</a>
    <a href="#"><span class="iconfont icon-a-huahuaduozhiwu"></span>注册用户管理</a>
    <a href="#"><span class="iconfont icon-a-lvsedeshumuzhiwu"></span>管理员设置</a>
    <a href="#"> <span class="iconfont icon-a-shushumuzhiwu"></span>管理员退出</a>
</div>
<div id="main">
    <div class="content">
        <form action="/JSPDemo/addServlet" method="post">
            <p style="text-indent:70px; font: 700 18px 'Microsoft yahe'; padding-top: 50px;">书籍信息录入</p>
            <%--隐藏域提交id--%>
            <input type="hidden" name="bkId" value="${book.bkId}"/>
            书籍名称：<input name="bkName"/>
            <p>作&nbsp; &nbsp; &nbsp; &nbsp;者：<input name="bkAuthor"/></p>
            <p>
                国籍/地区：
                <select name="bkCountry">
                    <option>中国</option>
                    <option>法国</option>
                    <option>英国</option>
                    <option>日本</option>
                </select>
            </p>
            <p>
                书本类型：<span name="bkType">
                        <input type="checkbox"/>任意类型
                        <input type="checkbox"/>心理
                        <input type="checkbox"/>商贸
                        <input type="checkbox"/>哲学<br>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="checkbox"/>人文&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="checkbox"/>专业
                        <input type="checkbox"/>小说
                        <input type="checkbox"/>社会
                    </span>
            </p>
            <p>
                库存数量：<input type="text" name="bkStockNum" style="width: 70px" />
            </p>
            <p>
                书本价格：<input type="text" name="bkPrice" style="width: 70px" />
            </p>
            <p>
                发行日期：<input name="bkSellDate"/>【格式:YYYY-MM-DD】
            </p>
            <p></p>
            <input type="submit"  value="确认"  style="margin-right: 20px; margin-left: 80px;">
            <a href="JSPDemo/selectAllServlet">
                <input type="button" value="重置"></a>
            </p>
            <br/>
        </form>
    </div>

    <div class="sidebar">
        <form align="center">
            <p>书籍信息查询</p>
            <p>书籍信息录入</p>
        </form>
    </div>
</div>

</body>

</html>
