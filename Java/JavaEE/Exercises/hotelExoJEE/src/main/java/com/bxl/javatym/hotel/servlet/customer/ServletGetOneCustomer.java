package com.bxl.javatym.hotel.servlet.customer;

import com.bxl.javatym.hotel.models.Customer;
import com.bxl.javatym.hotel.service.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletGetOneCustomer", value = "/customer/getOne")
public class ServletGetOneCustomer extends HttpServlet {

    private final CustomerService customerService = CustomerService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = customerService.getOne(Integer.parseInt(request.getParameter("customer_id")));
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("/hotel/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
