package brussels.digitalcity.maxdolmans.demorest.utils;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.services.impl.ChildService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class DataInit implements InitializingBean {

    private final ChildService childService;


    public DataInit(ChildService childService) {
        this.childService = childService;
    }

    private List<Child> children = Arrays.asList(
        new Child(
                "Max",
                "Dolmans",
                LocalDate.of(1991, 6, 20),
                true,
                Arrays.asList("banana", "cunts", "traitors")
                )
    );

    @Override
    public void afterPropertiesSet() throws Exception {
        try{
            children.forEach(childService::save);
        }
        catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
