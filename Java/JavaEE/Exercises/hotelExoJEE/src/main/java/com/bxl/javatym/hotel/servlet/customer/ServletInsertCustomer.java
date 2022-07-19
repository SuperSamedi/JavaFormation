package com.bxl.javatym.hotel.servlet.customer;

import com.bxl.javatym.hotel.models.Customer;
import com.bxl.javatym.hotel.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletInsertCustomer", value = "/customer/add")
public class ServletInsertCustomer extends HttpServlet {

    private final CustomerService service = CustomerService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/customer/add.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (confirmPassword.equals(password) && firstName != "" && lastName != "" && email != "") {
            Customer toInsert = new Customer(firstName, lastName, email, password);
            service.insert(toInsert);

            response.sendRedirect(request.getContextPath() + "/myProfile?id="+toInsert.getId());
        }
        else
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
}
