<%@ page import="com.bxl.javatym.hotel.models.Room" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bxl.javatym.hotel.service.RoomService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <%@include file="assets/include/toADD.jsp"%>
</head>
<body>

<%@include file="assets/include/navBar.jsp"%>
<%@include file="WEB-INF/caroussel.jsp"%>
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


<%--<h5 class="card-title">Room number : <%=room.getId()%></h5>--%>
<%--<p class="card-text">type : <%=room.getType()%></p>--%>
<%--<p class="card-text">capacity : <%=room.getCapacity()%></p>--%>
<%--<p class="card-text">price : <%=room.getPrice()%> €</p>--%>
