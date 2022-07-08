package main;

import entities.Aisle;
import entities.Director;
import entities.Market;
import entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Program {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceDemoMySQL");
        EntityManager manager = emf.createEntityManager();

//        Market bikiniBottomSupermarkt = new Market("Bikini Bottom Supermarkt", "Barnacle Road", "Bikini Bottom", 12);
//
//        Director bob = new Director("Spongebob", "Squarepants", 999_999.42, bikiniBottomSupermarkt);
//        Aisle aisleUtensils = new Aisle("Cooking utensils", bikiniBottomSupermarkt);
//        Aisle aislePatties = new Aisle("Patties", bikiniBottomSupermarkt);
//        Aisle aisleBreads = new Aisle("Bread", bikiniBottomSupermarkt);
//        Aisle aisleVegetables = new Aisle("Vegetables", bikiniBottomSupermarkt);
//        Product spatula = new Product("spat", "Hydro-dynamic spatula", "Chum Bucket", 42.42);
//        Product crabPatty = new Product("patty", "Crab Patty","Patrick's Yum Enterprise", 2.5);
//        Product bun = new Product("buns", "Hamburger Buns", "Big Buns", 0.99);
//        Product onion = new Product("onion", "Onion", "Under the See Farming Inc.", 0.15);
//        Product lettuce = new Product("letce", "Lettuce", "Under the See Farming Inc.", 0.1);
//        Product tomato = new Product("tomat", "Tomato", "Under the See Farming Inc.", 0.25);
//
//
//        bikiniBottomSupermarkt.setDirector(bob);
//        bikiniBottomSupermarkt.getAisles().add(aisleUtensils);
//        bikiniBottomSupermarkt.getAisles().add(aislePatties);
//        bikiniBottomSupermarkt.getAisles().add(aisleBreads);
//        bikiniBottomSupermarkt.getAisles().add(aisleVegetables);
//        bikiniBottomSupermarkt.getProducts().add(spatula);
//        bikiniBottomSupermarkt.getProducts().add(crabPatty);
//        bikiniBottomSupermarkt.getProducts().add(bun);
//        bikiniBottomSupermarkt.getProducts().add(onion);
//        bikiniBottomSupermarkt.getProducts().add(lettuce);
//        bikiniBottomSupermarkt.getProducts().add(tomato);
//        spatula.getMarkets().add(bikiniBottomSupermarkt);
//        crabPatty.getMarkets().add(bikiniBottomSupermarkt);
//        bun.getMarkets().add(bikiniBottomSupermarkt);
//        onion.getMarkets().add(bikiniBottomSupermarkt);
//        lettuce.getMarkets().add(bikiniBottomSupermarkt);
//        tomato.getMarkets().add(bikiniBottomSupermarkt);
//
//        // Add to db
//        manager.getTransaction().begin();
//        manager.persist(bob);
//        manager.persist(aisleUtensils);
//        manager.persist(aislePatties);
//        manager.persist(aisleBreads);
//        manager.persist(aisleVegetables);
//        manager.persist(spatula);
//        manager.persist(crabPatty);
//        manager.persist(bun);
//        manager.persist(onion);
//        manager.persist(lettuce);
//        manager.persist(tomato);
//        manager.persist(bikiniBottomSupermarkt);
//        manager.getTransaction().commit();


        // Get Store
        Market bikiniBottomSupermarkt = manager.find(Market.class, 5);
        System.out.println();
        System.out.println();
        System.out.println(bikiniBottomSupermarkt);


    }
}
