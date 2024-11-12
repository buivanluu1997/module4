<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form:form action="/mailbox/home" method="post" modelAttribute="mailbox">
    <label>Language:</label>
    <form:select path="language">
        <form:option value="english">English</form:option>
        <form:option value="vietnamese">Vietnamese</form:option>
        <form:option value="japanese">Japanese</form:option>
        <form:option value="chinese">Chinese</form:option>
    </form:select> <br>
    <label>Page size: Show </label>
    <form:select path="pageSize">
        <form:option value="5">5</form:option>
        <form:option value="10">10</form:option>
        <form:option value="15">15</form:option>
        <form:option value="25">25</form:option>
        <form:option value="50">50</form:option>
        <form:option value="100">100</form:option>
    </form:select>
    <label> email per page</label> <br>
    <label>Spams Filter:</label>
    <form:checkbox path="spamsFilter"/> Enable spams filter <br>
    <label>Signature:</label>
    <form:textarea path="signature" rows="4" cols="35" /> <br>
    <button type="submit">Update</button>
    <button type="reset">Cancel</button>
</form:form>
</body>
</html>
