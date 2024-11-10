<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/10/2024
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="convert" method="post">
    <h1>Ứng dụng chuyển đổi tiền tệ USD - VNĐ</h1>
    <label>Tỉ giá: </label>
    <input type="text" name="rate" required><br>
    <label>USD: </label>
    <input type="text" name="usd" required><br>
    <input type="submit" value="Chuyển đổi">
</form>
</body>
</html>
