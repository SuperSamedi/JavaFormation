<%@ page import="brussels.digitalcity.maxdolmans.demojavaee.services.ProductService" %>
<%@ page import="brussels.digitalcity.maxdolmans.demojavaee.models.Product" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 12-07-22
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cards! - GetOne</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
<%-- Déclaration d'un champ de la classe getOne.jsp (avec le '!')--%>
<%!
    ProductService service = ProductService.getInstance();
%>

<%--Déclaration de variable locale à la methode 'service' de la Servlet qui va etre 'créée' par getOne.jsp à chacune de ses call.--%>
<%
    String id = request.getParameter("id");

    if (id == null){
        response.setStatus(400);
        return;
    }

    if (Integer.parseInt(id) > service.getAll().size()){
        response.setStatus(404);
        return;
    }

    Product p = service.getOne(Integer.parseInt(id));
    PrintWriter writer = response.getWriter();
%>

<h1> Product <%= p.getId() %></h1>
<div>
    <p><span>id : </span><%= p.getId()%></p>
    <p><span>Name : </span><%= p.getName()%></p>
    <p><span>Set : </span><%= p.getEdition()%></p>
    <p><span>Type : </span><%= p.getType() %></p>
    <p><span>Price : </span><%= p.getPrice() %>€</p>
</div>
</body>
</html>
