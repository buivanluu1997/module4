<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/10/2024
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sach khach hang</title>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<table border="1">
  <tr>
    <th>Id</th>
    <th>Tên khách hàng</th>
    <th>Email</th>
    <th>Địa chỉ</th>
  </tr>
  <c:forEach items="${customerList}" var="customer">
    <tr>
      <td>${customer.id}</td>
      <td>${customer.name}</td>
      <td>${customer.email}</td>
      <td>${customer.address}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
