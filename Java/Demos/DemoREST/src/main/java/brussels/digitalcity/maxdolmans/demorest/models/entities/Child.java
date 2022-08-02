package brussels.digitalcity.maxdolmans.demorest.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Child extends Person{

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    private boolean clean;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> allergies;

    @ManyToMany
    @JoinTable(
        name = "tutoring",
        joinColumns = @JoinColumn(name = "child_id"),
        inverseJoinColumns = @JoinColumn(name = "guardian_id")
    )
    private Set<Guardian> guardians;


    public Child(String firstName, String lastName, LocalDate dateOfBirth, boolean clean) {
        super(firstName, lastName);
        this.dateOfBirth = dateOfBirth;
        this.clean = clean;
    }

    public Child(String firstName, String lastName, LocalDate dateOfBirth, boolean clean, List<String> allergies) {
        super(firstName, lastName);
        this.dateOfBirth = dateOfBirth;
        this.clean = clean;
        this.allergies = allergies;
    }
}
