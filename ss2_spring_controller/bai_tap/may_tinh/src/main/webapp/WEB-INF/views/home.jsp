<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/11/2024
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator/home" method="post">
  <h1>Máy tính</h1>
  <input type="number" name="numberOne">
  <input type="number" name="numberTwo">
  <input type="submit" name="operation" value="+">
  <input type="submit" name="operation" value="-">
  <input type="submit" name="operation" value="*">
  <input type="submit" name="operation" value="/">
</form><br>
<h3>${message}</h3>

</body>
</html>
