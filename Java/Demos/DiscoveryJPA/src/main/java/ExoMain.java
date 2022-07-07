import entities.Section;
import entities.Student;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ExoMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceDemoMySQL");
        SectionDAO sectionDAO = new SectionDAO(emf.createEntityManager());
        StudentDAO studentDAO = new StudentDAO(emf.createEntityManager());

        Student bobby = studentDAO.getStudent(1);
        System.out.println(bobby);
//        Section waterBending = sectionDAO.getSection(5522);
//        System.out.println(waterBending);
//        waterBending.setDelegateId(12);
//        sectionDAO.update(waterBending);
//
//        Section darkArts = new Section(999, "Dark Arts", 666);
//        sectionDAO.insert(darkArts);

//        sectionDAO.delete(999);
        emf.close();
    }
}
