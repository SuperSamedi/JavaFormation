import entities.Section;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ExoMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceDemoMySQL");
        SectionDAO sectionDAO = new SectionDAO(emf.createEntityManager());

        Section waterBending = sectionDAO.getSection(5522);
        System.out.println(waterBending);
        waterBending.setDelegateId(12);
        sectionDAO.update(waterBending);

        Section darkArts = new Section(999, "Dark Arts", 666);
//        sectionDAO.insert(darkArts);

//        sectionDAO.delete(999);
        emf.close();
    }
}
