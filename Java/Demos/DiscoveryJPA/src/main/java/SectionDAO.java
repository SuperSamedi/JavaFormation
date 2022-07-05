import entities.Section;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class SectionDAO {

    private final EntityManager manager;


    public SectionDAO(EntityManager manager) {
        this.manager = manager;
    }


    public Section getSection(int id){
        return manager.find(Section.class, id);
    }

    public List<Section> getAllSection(){
        TypedQuery<Section>query = manager.createQuery("SELECT s FROM Section s", Section.class);
        return query.getResultList();
    }

    public void insert(Section section){
        manager.getTransaction().begin();
        manager.persist(section);
        manager.getTransaction().commit();
    }

    public void delete(Section section) {
        Section toDelete = getSection(section.getId());
        manager.getTransaction().begin();
        manager.remove(toDelete);
        manager.getTransaction().commit();
    }

    public void delete(int id) {
        Section toDelete = getSection(id);
        manager.getTransaction().begin();
        manager.remove(toDelete);
        manager.getTransaction().commit();
    }

    public void update(Section section){
        manager.getTransaction().begin();
        manager.merge(section);
        manager.getTransaction().commit();
    }

}
