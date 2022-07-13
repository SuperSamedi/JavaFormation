<%@ page import="brussels.digitalcity.maxdolmans.demojavaee.services.ProductService" %>
<%@ page import="brussels.digitalcity.maxdolmans.demojavaee.models.Product" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 12-07-22
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cards! - GetAll</title>
</head>
<body>
<a href="<%= request.getContextPath() %>/index.jsp">Home</a>
<h1>All Cards</h1>
<%-- Déclaration d'un champ de la classe getOne.jsp (avec le '!')--%>
<%!
    ProductService service = ProductService.getInstance();
%>


<% for (Product product : service.getAll()) { %>
<div>
    <p><span>Name : </span><strong><%= product.getName() %></strong></p>
    <p><span>Set : </span> <%= product.getEdition() %></p>
    <p><span>Type : </span> <%= product.getType() %></p>
    <p><span>Price : </span> <%= product.getPrice() %> €</p>
    <a href="<%= request.getContextPath() %>/product/getOne.jsp?id=<%= product.getId()%>">Details</a>
    <a href="<%= request.getContextPath() %>/product/update?id=<%= product.getId()%>">Modify</a>
    <a href="<%= request.getContextPath() %>/product/delete?id=<%= product.getId()%>">Delete</a>
    <hr/>
</div>

<% } %>
</body>
</html>
