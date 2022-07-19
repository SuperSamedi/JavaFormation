<%@ page import="com.bxl.javatym.hotel.service.CustomerService" %>
<%@ page import="com.bxl.javatym.hotel.models.Customer" %>
<%@ page import="java.util.List" %>
<%
    CustomerService customerService = CustomerService.getInstance();
    List<Customer> customerList= customerService.getAll();
%>

<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="<%=request.getContextPath()%>">InnovHotel</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()  %>/">Home</a>
                </li>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="<%=request.getContextPath()  %>/myProfile.jsp">MyProfile</a>--%>
<%--                </li>--%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Profiles
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <% for (Customer customer : customerList) {%>
                        <li><a class="dropdown-item" href="<%=request.getContextPath() %>/myProfile?id=<%=customer.getId()%>"><%=customer.getFirstName()%> <%=customer.getLastName()%></a></li>
                        <%}%>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()  %>/booking.jsp">Booking</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()  %>/contact.jsp">Contact</a>
                </li>
            </ul>
            <form class="d-flex" role="search" action="<%= request.getContextPath() %>/createAccount.jsp" method="get">
                <button class="btn btn-outline-success" type="submit">Register</button>
            </form>
        </div>
    </div>
</nav>
