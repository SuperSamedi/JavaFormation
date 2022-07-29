package brussels.digitalcity.maxdolmans.demorest.services.impl;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.services.IChildService;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class MockIChildService implements IChildService {
    @Override
    public Child save(Child child) {
        return new Child();
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
    public Child delete(Long id) {
        return new Child();
    }
}
