package brussels.digitalcity.maxdolmans.demorest.utils;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import brussels.digitalcity.maxdolmans.demorest.services.impl.ChildServiceImpl;
import brussels.digitalcity.maxdolmans.demorest.services.impl.GuardianServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class DataInit implements InitializingBean {

    private final ChildServiceImpl childServiceImpl;
    private final GuardianServiceImpl guardianServiceImpl;


    public DataInit(ChildServiceImpl childServiceImpl, GuardianServiceImpl guardianServiceImpl) {
        this.childServiceImpl = childServiceImpl;
        this.guardianServiceImpl = guardianServiceImpl;
    }

    private List<Child> children = Arrays.asList(
            new Child(
                    "Max",
                    "Dolmans",
                    LocalDate.of(1991, 6, 20),
                    true,
                    Arrays.asList("banana", "poison")
            ),
            new Child(
                    "Nora",
                    "Dolmans",
                    LocalDate.of(1993, 2, 14),
                    true,
                    Arrays.asList("la peur")
            )
    );

    private List<Guardian> guardians = Arrays.asList(
            new Guardian(
                    "Christine",
                    "Herinckx",
                    "063424786",
                    "1 rue Abraham Gilson " +
                            "6723 Habay-la-Vieille"
            ),

            new Guardian(
                    "Michel",
                    "Dolmans",
                    "063424786",
                    "1 rue Abraham Gilson " +
                            "6723 Habay-la-Vieille"
            )
    );

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            children.forEach(childServiceImpl::create);
            guardians.forEach(guardianServiceImpl::create);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
