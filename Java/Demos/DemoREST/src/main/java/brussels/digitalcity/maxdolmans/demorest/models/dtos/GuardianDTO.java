package brussels.digitalcity.maxdolmans.demorest.models.dtos;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Child;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class GuardianDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Set<ChildDTO> children;

    @Data
    @Builder
    public static class ChildDTO {
        private long id;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private String cleanliness;
        private List<String> allergies;

        public static ChildDTO fromEntity(Child entity) {
            if (entity == null)
                return null;

            return ChildDTO.builder()
                    .id(entity.getId())
                    .firstName(entity.getFirstName())
                    .lastName(entity.getLastName())
                    .dateOfBirth(entity.getDateOfBirth())
                    .cleanliness(entity.isClean() ? "clean" : "not clean")
                    .allergies(entity.getAllergies())
                    .build();
        }
    }

}
