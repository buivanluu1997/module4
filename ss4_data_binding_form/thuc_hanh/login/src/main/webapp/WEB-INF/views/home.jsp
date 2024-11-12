<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form:form action="/user/home" method="post" modelAttribute="login">
  <form:label path="account">Account:</form:label>
  <form:input  path="account" /><br>
  <form:label path="password">Password</form:label>
  <form:input path="password"/><br>
  <form:button>Login</form:button>
</form:form>
</body>
</html>
