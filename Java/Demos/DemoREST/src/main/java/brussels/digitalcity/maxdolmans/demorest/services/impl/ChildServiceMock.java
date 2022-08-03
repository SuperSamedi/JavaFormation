package brussels.digitalcity.maxdolmans.demorest.services.impl;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.services.ChildService;

import java.util.List;

//@Service
public class ChildServiceMock implements ChildService {

    @Override
    public Child create(Child toCreate) {
        return null;
    }

    @Override
    public Child update(Long id, Child toUpdate) {
        return null;
    }

    @Override
    public Child getOne(Long id) {
        return new Child();
    }

    @Override
    public List<Child> getAll() {
        return List.of(new Child());
    }

    @Override
    public void delete(Long id) {
    }
}
