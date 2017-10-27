<%--
  Created by IntelliJ IDEA.
  User: ZhangGuozhao
  Date: 2017/9/13
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body><br>
<hr>
<br>
<form action="/mvc/test1">
    <%--测试： 传入User对象--%>
    请输入：<br/>
    <div align="middle">
        用户名：
        <input type="text" name="username" value=""></div>
    <div align="middle">
        密 码:
        <input type="text" name="password" value=""></div>
    <div align="middle">
        <input type="submit" value="提交1">
    </div>
</form>
<br>
<hr>
<br>

<form action="/mvc/test2">
    <%--测试： 传入Intger参数--%>
    <input type="text" name="cout" value=10>
    <input type="submit" value="提交2">
</form>
<br>
<hr>
<br>

<form action="/mvc/test3">
    <%--测试： 传入复合对象--%>
    姓：<input type="text" name="firstName" value="zhang">
    名：<input type="text" name="lastName" value="le">
    地址：<input type="text" name="contactInfo.address" value="">
    电话：<input type="text" name="contactInfo.tel" value="">
    <input type="submit" value="提交3"/>
</form>
<br>
<hr>
<br>

<form action="/mvc/test4">
    <%--测试： 传入List对象，注意name要和UserList类里的userList名字一样--%>
    <input type="text" name="userList[0].username" value="aaa">
    <input type="text" name="userList[0].password" value="aaa">
    <input type="text" name="userList[1].username" value="bbb">
    <input type="text" name="userList[1].password" value="bbb">
    <input type="text" name="userList[2].username" value="ccc">
    <input type="text" name="userList[2].password" value="ccc">
    <input type="text" name="userList[5].password" value="fff">
    <input type="text" name="userList[5].password" value="fff">
    <input type="submit" value="提交4">
</form>
<br>
<hr>

<br>
<form action="/mvc/upload" enctype="multipart/form-data" method="post">
    <%--上传组件--%>
    <input type="file" name="file" value="点击上传">
    <input type="submit" value="提交5">
</form>

<form action="/mvc/addAttachment" method="post">
    <input type="text" name="fileType" value="123"/>
<input type="submit" value="提交6"/>
</form>


</body>
</html>
