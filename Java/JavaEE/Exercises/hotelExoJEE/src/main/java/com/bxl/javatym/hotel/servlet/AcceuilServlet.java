package com.bxl.javatym.hotel.servlet;

import com.bxl.javatym.hotel.models.Room;
import com.bxl.javatym.hotel.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "accueilServlet", value = {"/index", "/index.jsp"})
public class AcceuilServlet extends HttpServlet {
    private final RoomService roomService = RoomService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Room> roomList = roomService.getAll();
        request.setAttribute("roomList", roomList);
        request.getRequestDispatcher("/accueil.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
