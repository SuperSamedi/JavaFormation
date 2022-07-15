<%@ page import="brussels.digitalcity.maxdolmans.demojavaee.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 12-07-22
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cards! - Add Card</title>
</head>
<body>
<% Product toUpdate = (Product)request.getAttribute("product"); %>

<a href="<%= request.getContextPath() %>/index.jsp">Home</a>
<h1>Update a card</h1>

<%
    String error = (String) request.getAttribute("error");
    if (error != null){ %>
        <p style="color: red"> <%= error %>
    <%}
%>

<form action="<%= request.getContextPath() %>/product/update" method="post">
    <fieldset>
        <legend>Update Card</legend>
        <input type="hidden" name="id" value="<%= toUpdate.getId() %>">
        <div>
            <label for="in-name">Name: </label><br>
            <input type="text" name="name" id="in-name" placeholder="Name" value="<%= toUpdate.getName() %>">
        </div>

        <div>
            <label for="in-edition">Edition: </label><br>
            <input type="text" name="edition" id="in-edition" placeholder="Edition" value="<%= toUpdate.getEdition() %>">
        </div>

        <div>
            <label for="in-type">Type: </label><br>
            <input type="text" name="type" id="in-type" placeholder="Type" value="<%= toUpdate.getType() %>">
        </div>

        <div>
            <label for="in-price">Price: </label><br>
            <input type="number" step="0.01" name="price" id="in-price" placeholder="Price" value="<%= toUpdate.getPrice() %>">
        </div>
    </fieldset>
    <button type="submit">Confirm</button>
</form>
</body>
</html>
