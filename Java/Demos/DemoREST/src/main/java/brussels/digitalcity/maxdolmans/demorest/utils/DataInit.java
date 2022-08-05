package brussels.digitalcity.maxdolmans.demorest.utils;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Address;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Guardian;
import brussels.digitalcity.maxdolmans.demorest.models.forms.AddressForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildInsertForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.ChildUpdateForm;
import brussels.digitalcity.maxdolmans.demorest.models.forms.GuardianForm;
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

    private List<ChildInsertForm> children = Arrays.asList(
            new ChildInsertForm(
                    "Max",
                    "Dolmans",
                    LocalDate.of(1991, 6, 20),
                    true
            ),
            new ChildInsertForm(
                    "Nora",
                    "Dolmans",
                    LocalDate.of(1993, 2, 14),
                    true
            )
    );

    private List<GuardianForm> guardians = Arrays.asList(
            new GuardianForm(
                    "Christine",
                    "Herinckx",
                    "063424786",
                    new AddressForm("Rue Abraham Gilson",1, 6723, "Habay-la-Vieille")
            ),

            new GuardianForm(
                    "Michel",
                    "Dolmans",
                    "063424786",
                    new AddressForm("Rue Abraham Gilson",1, 6723, "Habay-la-Vieille")
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
