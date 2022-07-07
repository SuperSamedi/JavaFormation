import entities.Section;
import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class StudentDAO {

    private final EntityManager manager;


    public StudentDAO(EntityManager manager) {
        this.manager = manager;
    }


    public Student getStudent(int id){
        return manager.find(Student.class, id);
    }

    public List<Student> getAllStudents(){
        TypedQuery<Student>query = manager.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }

    public void insert(Student student){
        manager.getTransaction().begin();
        manager.persist(student);
        manager.getTransaction().commit();
    }

    public void delete(Student student) {
        Student toDelete = getStudent(student.getId());
        manager.getTransaction().begin();
        manager.remove(toDelete);
        manager.getTransaction().commit();
    }

    public void delete(int id) {
        Student toDelete = getStudent(id);
        manager.getTransaction().begin();
        manager.remove(toDelete);
        manager.getTransaction().commit();
    }

    public void update(Student student){
        manager.getTransaction().begin();
        manager.merge(student);
        manager.getTransaction().commit();
    }

    public void assignWinners(){
        List<Student> students = getAllStudents();
        for (Student student : students) {
            if (student.getYearResult() > 12){
                student.setLogin("winner_" + student.getLogin());
            }
        }
    }
}
