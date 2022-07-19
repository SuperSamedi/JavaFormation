package com.bxl.javatym.hotel.servlet.booking;

import com.bxl.javatym.hotel.service.BookingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteBookingServlet", value = "/booking/delete")
public class deleteBookingServlet extends HttpServlet {
    private final BookingService bookingService= BookingService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookingService.delete(id);
        response.sendRedirect(request.getContextPath()+"/myProfile?id="+request.getParameter("customer"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
