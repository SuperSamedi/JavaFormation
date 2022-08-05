package brussels.digitalcity.maxdolmans.demorest.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Guardian extends Person{
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Embedded
    @Column(nullable = false)
    private Address address;

    @ManyToMany(mappedBy = "guardians")
    private Set<Child> children;


    public Guardian(String firstName, String lastName, String phoneNumber, Address address) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
