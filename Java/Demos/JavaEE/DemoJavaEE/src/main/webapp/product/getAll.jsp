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
<html>
<head>
    <title>Cards! - GetAll</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">Home</a>
<%-- Déclaration d'un champ de la classe getOne.jsp (avec le '!')--%>
<%!
    ProductService service = ProductService.getInstance();
%>

<%--Déclaration de variable locale à la methode 'service' de la Servlet qui va etre 'créée' par getOne.jsp à chacune de ses call.--%>
<%
    List<Product> products = service.getAll();
    PrintWriter writer = response.getWriter();
%>

<h1>All Cards</h1>
<ul>
    <%
        for (Product product : products) {
            writer.print(
                "<li>" +
                "        <p><span>Name : </span><strong>" + product.getName() + "</strong></p>" +
                "    <div>" +
                "        <p><span>id : </span>" + product.getId() + "</p>" +
                "        <p><span>Set : </span>" + product.getEdition() + "</p>" +
                "        <p><span>Type : </span>" + product.getType() + "</p>" +
                "        <p><span>Price : </span>" + product.getPrice() +"€</p>" +
                "    </div>" +
                "</li>"
            );
        }
    %>
</ul>
</body>
</html>
