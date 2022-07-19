package com.bxl.javatym.hotel.servlet.customer;

import com.bxl.javatym.hotel.models.Customer;
import com.bxl.javatym.hotel.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletUpdateCustomer", value = "/customer/update")
public class ServletUpdateCustomer extends HttpServlet {

    private final CustomerService service = CustomerService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/customer/add.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = new Customer();
        int id;

        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last-name");
        customer.setFirstName(firstName);
        customer.setLastName(lastName);

        try{
            id = Integer.parseInt(request.getParameter("customer_id"));
            customer.setId(id);

            service.update(customer);

            response.sendRedirect(request.getContextPath() + "/");
        }
        catch(NumberFormatException ex){
            if (customer.getId() != 0){
                request.setAttribute("Error", "Les données entrées sont invalides.");
                request.setAttribute("customer", customer);
                request.getRequestDispatcher("/customer/update.jsp").forward(request, response);
            }
            else {
                response.sendError(400, "ID invalid");
            }
        }
    }
}