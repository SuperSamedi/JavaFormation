import entities.Section;
import exceptions.EntityAlreadyExistsException;
import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

public class SectionDAO {

    private final EntityManager manager;


    public SectionDAO(EntityManager manager) {
        this.manager = manager;
    }


    public Optional<Section> getSection(int id) {
        return Optional.ofNullable(manager.find(Section.class, id));
    }

    public List<Section> getAllSections() {
        TypedQuery<Section> query = manager.createQuery("SELECT s FROM Section s", Section.class);
        return query.getResultList();
    }

    public void insert(Section section) {
        if (section == null)
            throw new IllegalArgumentException("Section is null.");

        if (sectionExists(section.getId()))
            throw new EntityAlreadyExistsException(section.getId(), Section.class);

        manager.getTransaction().begin();
        manager.persist(section);
        manager.getTransaction().commit();

//        try {
//            manager.getTransaction().begin();
//            manager.persist(section);
//            manager.getTransaction().commit();
//        } catch (RollbackException ex) {
//            throw new EntityAlreadyExistsException(section.getId(), Section.class);
//        }
    }

    public void delete(int id) {
        manager.getTransaction().begin();
        getSection(id).ifPresent( manager::remove );
        manager.getTransaction().commit();
    }

    public void delete(Section section) {
        delete(section.getId());
    }

    public void update(Section section) {
        if (section == null) {
            throw new IllegalArgumentException("Can not update a null section.");
        }

        if (!sectionExists(section.getId())) {
            throw new EntityNotFoundException("Section not found. Can not update.");
        }

        manager.getTransaction().begin();
        manager.merge(section);
        manager.getTransaction().commit();
    }

    public boolean sectionExists(int id) {
        TypedQuery<Integer> query = manager.createQuery("SELECT COUNT(s) FROM Section s WHERE s.id = " + id, Integer.class);
        return query.getSingleResult() > 0;
    }
}
