package com.bxl.javatym.hotel.service;

import com.bxl.javatym.hotel.listeners.EMFWebListener;
import com.bxl.javatym.hotel.models.Room;
import com.bxl.javatym.hotel.models.TypeEnum;
import org.hibernate.type.EnumType;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomService {

    private static RoomService instance;

    public static RoomService getInstance(){
        return instance == null ? instance = new RoomService() : instance;
    }

    private RoomService() {
    }

    private final EntityManager manager = EMFWebListener.createEntityManager();


    public List<Room> getAll(){
        return manager.createQuery("SELECT r FROM Room r", Room.class).getResultList();
    }

    public Room getOne(int id){
        return manager.find(Room.class, id);
    }

    public void insert(Room toInsert){
        manager.getTransaction().begin();
        manager.persist(toInsert);
        manager.getTransaction().commit();
    }

    public void update(Room room) {
        if( room == null ) throw new IllegalArgumentException("Room cannot be null");
        if( !existsById(room.getId()) ) throw new EntityNotFoundException("Entity not found");
        manager.getTransaction().begin();
        manager.merge(room);
        manager.getTransaction().commit();
    }

    public List<Room> search(int capacity, TypeEnum type, LocalDate checkin, LocalDate checkout, int priceMin, int priceMax) {
        List<Room> result = new ArrayList<>();
        List<Room> allRooms = getAll();

        for (Room room : allRooms) {
            // If the room is too small, we skip it.
            if (room.getCapacity() < capacity) { continue; }

            // If the room is of the wrong type, we skip it.
            if (room.getType() != type && type != TypeEnum.DEFAULT) { continue; }

            // If the room is too expensive, we skip it.
            if (room.getPrice() < priceMin) { continue; }

            // If the room is too expensive, we skip it.
            if (room.getPrice() > priceMax) { continue; }

            // If the room is not available, we skip it.
            if (!room.isAvailable(checkin, checkout)){ continue; }

            // If the room matches all conditions we add it to the result list.
            result.add(room);
        }

        return  result;
    }


    public void delete(int id) {
        manager.getTransaction().begin();
        Room roomToDelete = getOne(id);
        manager.remove(roomToDelete);
        manager.getTransaction().commit();
    }

    public boolean existsById(int id){
        return getOne(id) != null;
    }
}
