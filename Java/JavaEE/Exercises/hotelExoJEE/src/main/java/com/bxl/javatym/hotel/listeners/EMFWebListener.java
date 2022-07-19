package com.bxl.javatym.hotel.listeners;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class EMFWebListener implements ServletContextListener {

    private static EntityManagerFactory factory;
    public static EntityManager createEntityManager(){
        return factory.createEntityManager();
    }
    public EMFWebListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        factory = Persistence.createEntityManagerFactory("hoteldb");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        factory.close();
    }
}
