<%--
  Created by IntelliJ IDEA.
  User: JAVA
  Date: 15-07-22
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking</title>
    <%@include file="assets/include/toADD.jsp" %>
</head>
<body>

    <%@include file="assets/include/navBar.jsp" %>


<div class="input-group mb-3">
    <form action="<%= request.getContextPath() %>/room/search" method="get">
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">Capacity</label>
            <input type="number" min="1" max="6"  class="form-control" id="formGroupExampleInput" placeholder="1" name="capacity">
        </div>
        <div class="mb-3">
            <label for="inputState" class="form-label">Room's type</label>
            <select id="inputState" class="form-select" name="type">
                <option selected value="default">Choose...</option>
                <option>Basic</option>
                <option>Medior</option>
                <option>Suite</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">Check-In</label>
            <input type="date" class="form-control" id="formGroupExampleInput26" placeholder="Enter name" name="checkin" required>
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">Check-Out</label>
            <input type="date" class="form-control" id="formGroupExampleInput25" placeholder="Enter name" name="checkout" required>
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">Minimum price</label>
            <input type="number" class="form-control" min="200" max="405" id="formGroupExampleInput24" placeholder="201$" name="minprice">
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">Maximum price</label>
            <input type="number" class="form-control" min="201" max="405" id="formGroupExampleInput23" placeholder="405$" name="maxprice">
        </div>
        <div class="mb-3">
            <div class="form-check">
                <input class="form-check-input is-invalid" type="checkbox" value="" id="invalidCheck3" aria-describedby="invalidCheck3Feedback" required>
                <label class="form-check-label" for="invalidCheck3">
                    Agree to terms and conditions
                </label>
            </div>
        <button class="btn btn-outline-secondary" type="submit" id="button-addon1">Send</button>
    </form>
</div>
    <script src="assets/js/main.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>
