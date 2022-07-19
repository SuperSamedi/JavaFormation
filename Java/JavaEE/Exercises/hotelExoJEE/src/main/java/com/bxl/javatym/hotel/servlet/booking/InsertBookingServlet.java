package com.bxl.javatym.hotel.servlet.booking;

import com.bxl.javatym.hotel.models.Booking;
import com.bxl.javatym.hotel.models.Customer;
import com.bxl.javatym.hotel.models.Room;
import com.bxl.javatym.hotel.service.BookingService;
import com.bxl.javatym.hotel.service.CustomerService;
import com.bxl.javatym.hotel.service.RoomService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@WebServlet(name = "bookingServlet", value = "/booking/insert")
public class InsertBookingServlet extends HttpServlet {
    private final BookingService bookingService = BookingService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = CustomerService.getInstance().getOne(Integer.parseInt(request.getParameter("customerId")));
        Room room = RoomService.getInstance().getOne(Integer.parseInt(request.getParameter("roomId")));
        List<Customer> customerList = CustomerService.getInstance().getAll();

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            String dateBeginString = request.getParameter("dateBegin");
            String dateEndString = request.getParameter("dateEnd");

            LocalDate dateBegin = LocalDate.parse(dateBeginString, formatter);
            LocalDate dateEnd = LocalDate.parse(dateEndString, formatter);

            if (!room.isAvailable(dateBegin, dateEnd)){
                System.out.println("=============================== !!!!!!");
                request.setAttribute("error","les date entrées ne sont pas disponible");
                request.setAttribute("room",room);
                request.setAttribute("customerList",customerList);
                request.getRequestDispatcher("/room.jsp").forward(request,response);
            }else{
                Booking toInsert = new Booking(customer, room, dateBegin, dateEnd);
                System.out.println(toInsert);
                bookingService.insert(toInsert);
                response.sendRedirect(request.getContextPath());
            }

        }catch (Throwable th){
//            response.sendError(404);
            request.setAttribute("error","une erreur s'est produite");
            request.setAttribute("room",room);
            request.setAttribute("customerList",customerList);
            request.getRequestDispatcher("/room.jsp").forward(request,response);
        }
    }
}
