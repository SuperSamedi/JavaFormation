<%@ page import="com.bxl.javatym.hotel.models.Room" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 19-07-22
  Time: 08:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Available Rooms</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/styles.css">
    <%@include file="assets/include/toADD.jsp"%>
</head>
<body>
<%@include file="assets/include/navBar.jsp"%>

<div id="main">
        <%
        List<Room> roomList = (List<Room>) request.getAttribute("roomList");
        for (Room room : roomList ) {
    %>
    <div class="card" style="width: 18rem;">
        <img src="<%= room.getImg()%>" class="img5">
        <div class="card-body text-center">
            <h5 class="card-title"><%= room.getType()%></h5>
            <p>room number: <%= room.getId()%></p>
            <p>price: <%= room.getPrice()%>€</p>
            <p>capacity: <%= room.getCapacity()%> persons</p>
            <a href="<%=request.getContextPath()%>/room/getOne?id=<%=room.getId()%>" class="btn btn-primary">Book now</a>
        </div>
    </div>
    <%}%>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>
