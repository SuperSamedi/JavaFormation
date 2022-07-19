package com.bxl.javatym.hotel.servlet.customer;

import com.bxl.javatym.hotel.models.Customer;
import com.bxl.javatym.hotel.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MyProfileServlet", value = "/myProfile")
public class MyProfileServlet extends HttpServlet {
    private final CustomerService customerService = CustomerService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = customerService.getOne(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("/myProfile.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
