import entities.Section;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Program {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceDemoMySQL");
        EntityManager manager = emf.createEntityManager();

        // Get one
        System.out.println("\n\n----- GET ONE -----");
        Section s = manager.find(Section.class, 1010);
        System.out.println("\nOne section:");
        System.out.println(s);

        // Get all
        System.out.println("\n\n----- GET ALL -----");
        TypedQuery<Section> query = manager.createQuery("SELECT s FROM Section s", Section.class);
        List<Section> allSections = query.getResultList();
        System.out.println("\nAll sections:");
        allSections.forEach(System.out::println);

        // Insert
        System.out.println("\n\n----- INSERT -----");
        Section toInsert = new Section(999, "Dark Arts", 666);
        manager.getTransaction().begin();
        manager.persist(toInsert);
        manager.getTransaction().commit();
        System.out.println("\nInserted: ");
        System.out.println(toInsert);

        // Delete
        System.out.println("\n\n----- DELETE -----");
        Section toDelete = manager.find(Section.class, 999);
        manager.getTransaction().begin();
        manager.remove(toDelete);
        manager.getTransaction().commit();
        System.out.println("\nDeleted: ");
        System.out.println(toDelete);

        // Update
        System.out.println("\n\n----- UPDATE -----");
        manager.getTransaction().begin();
        s.setDelegateId(25);
        manager.getTransaction().commit();
        System.out.println("Updated:");
        System.out.println(s);

        emf.close();
    }
}
