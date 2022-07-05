package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "section")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Section {

    @Id
    @Column(name = "section_id")
    private int id;

    @Column(name = "section_name")
    private String name;

    @Column(name = "delegate_id")
    private Integer delegateId;

    @Override
    public String toString() {
        return "Section{" + id + ", " + name + ", delegate id: " + delegateId + "}";
    }
}
