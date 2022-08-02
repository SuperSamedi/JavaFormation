package brussels.digitalcity.maxdolmans.demorest.utils;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.services.impl.ChildServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class DataInit implements InitializingBean {

    private final ChildServiceImpl childServiceImpl;


    public DataInit(ChildServiceImpl childServiceImpl) {
        this.childServiceImpl = childServiceImpl;
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
            children.forEach(childServiceImpl::save);
        }
        catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
