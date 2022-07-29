package brussels.digitalcity.maxdolmans.demorest.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Guardian extends Person{
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @ManyToMany(mappedBy = "guardians")
    private Set<Child> children;

}
