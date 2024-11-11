<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/11/2024
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form action="/sandwich/save" method="post">
    <h1>Sandwich Condiments</h1>
<label><input type="checkbox" name="condiment" value="lettuce">Lettuce</label>
<label><input type="checkbox" name="condiment" value="tomato">Tomato</label>
<label><input type="checkbox" name="condiment" value="mustard">Mustard</label>
<label><input type="checkbox" name="condiment" value="sprouts">Sprouts</label>
  <input type="submit" value="save">
</form>
</body>
</html>
