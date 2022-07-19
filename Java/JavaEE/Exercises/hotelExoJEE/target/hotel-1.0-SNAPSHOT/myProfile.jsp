<%@ page import="com.bxl.javatym.hotel.models.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bxl.javatym.hotel.models.Booking" %><%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 15-07-22
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My profile</title>
    <%@include file="assets/include/toADD.jsp"%>
</head>
<body>
<%@include file="assets/include/navBar.jsp"%>

<%
    Customer customer = (Customer) request.getAttribute("customer");
    List<Booking> bookingList = customer.getBookings();
%>
<div class="image-profil">
    <img src="https://www.pngmart.com/files/21/Account-Avatar-Profile-PNG-Photo.png" alt="img profil">
</div>
<h5 class="reservation-h5">reservations:</h5>
<div id="main">
    <%
        for (Booking booking : bookingList ) {
    %>
    <div class="card" style="width: 18rem;">
        <img src="<%= booking.getRoom().getImg()%>" class="img5">
        <div class="card-body text-center">
            <h5 class="card-title"> du <%=booking.getBeginDate()%> au <%=booking.getEndDate()%></h5>
            <p><%= booking.getRoom().getType()%> n°<%= booking.getRoom().getId()%></p>
            <p>price: <%= booking.getRoom().getPrice()%>€</p>
            <a href="<%=request.getContextPath()%>/booking/delete?id=<%=booking.getId()%>&customer=<%=booking.getCustomer().getId()%>" class="btn btn-primary">Cancel</a>
        </div>
    </div>
    <%}%>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>
