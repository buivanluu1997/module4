<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/10/2024
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/customers/add" method="post">
  <h1>Thêm khách hàng</h1>
  <label>Id: </label>
  <input type="text" name="id" required><br>
  <label>Tên: </label>
  <input type="text" name="name" required><br>
  <label>Email: </label>
  <input type="text" name="email" required><br>
  <label>Địa chỉ: </label>
  <input type="text" name="address" required><br>
  <input type="submit" value="Thêm">
</form>
</body>
</html>
