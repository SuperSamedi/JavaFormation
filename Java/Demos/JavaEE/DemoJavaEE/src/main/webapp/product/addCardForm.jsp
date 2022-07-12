<%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 12-07-22
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cards! - Add Card</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">Home</a>

<form>
    <fieldset>
        <legend>New Card</legend>
        <label>ID: </label>
        <input type="text" name="index" id="index" placeholder="Index">
        <label>Name: </label>
        <input type="text" name="name" id="name" placeholder="Name">
        <label>Edition: </label>
        <input type="text" name="edition" id="edition" placeholder="Edition">
        <label>Type: </label>
        <input type="text" name="type" id="type" placeholder="Type">
        <label>Price: </label>
        <input type="text" name="price" id="price" placeholder="Price">
    </fieldset>
    <input type="submit">
</form>
</body>
</html>
