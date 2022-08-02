package brussels.digitalcity.maxdolmans.demorest.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class GuardianDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Set<Long> childrenId;

}
