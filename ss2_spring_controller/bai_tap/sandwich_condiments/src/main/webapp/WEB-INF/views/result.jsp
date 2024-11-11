<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/11/2024
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách các gia vị đã chọn:</h2>
    <c:forEach items="${condimentList}" var="condiment" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${condiment}</td></br>
        </tr>
    </c:forEach>
</body>
</html>
