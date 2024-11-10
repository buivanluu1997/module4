<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/10/2024
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Kết quả tra cứu</h1>
<c:if test="${not empty work}" >
    <p>${key}: ${work}</p>
</c:if>
<c:if test="${empty work}">
    <p>${message}</p>
</c:if>
</body>
</html>
