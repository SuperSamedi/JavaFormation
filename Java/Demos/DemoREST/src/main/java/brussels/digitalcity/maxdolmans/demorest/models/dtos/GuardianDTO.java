package brussels.digitalcity.maxdolmans.demorest.models.dtos;

import java.util.List;
import java.util.Set;

public class GuardianDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Set<ChildDTO> children;

}
