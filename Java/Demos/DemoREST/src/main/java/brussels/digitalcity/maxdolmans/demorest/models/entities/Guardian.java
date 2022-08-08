package brussels.digitalcity.maxdolmans.demorest.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Guardian extends Person{
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(nullable = false, name = "address_id")
    private Address address;

    @ManyToMany(mappedBy = "guardians")
    private Set<Child> children;
}
