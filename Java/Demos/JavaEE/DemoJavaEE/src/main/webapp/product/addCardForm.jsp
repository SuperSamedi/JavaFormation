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
<a href="<%= request.getContextPath() %>/index.jsp">Home</a>
<h1>Add a card</h1>

<form action="<%= request.getContextPath()%>/product/add" method="post">
    <fieldset>
        <legend>New Card</legend>
        <div>
            <label for="in-name">Name: </label><br>
            <% String name = request.getParameter("name"); %>
            <input type="text" name="name" id="in-name" placeholder="Name" value="<%= name == null ? "" : name %>">
        </div>

        <div>
            <label for="in-edition">Edition: </label><br>
            <% String edition = request.getParameter("edition"); %>
            <input type="text" name="edition" id="in-edition" placeholder="Edition" value="<%= edition == null ? "" : edition %>">
        </div>

        <div>
            <label for="in-type">Type: </label><br>
            <% String type = request.getParameter("type"); %>
            <input type="text" name="type" id="in-type" placeholder="Type" value="<%= type == null ? "" : type %>">
        </div>

        <div>
            <label for="in-price">Price: </label><br>
            <input type="number" step="0.01" name="price" id="in-price" placeholder="Price">
        </div>
    </fieldset>
    <button type="submit">Confirm</button>
</form>
</body>
</html>
