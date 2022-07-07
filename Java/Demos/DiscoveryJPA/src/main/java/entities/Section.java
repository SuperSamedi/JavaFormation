package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "section")
    private List<Student> studentsList;

    @ManyToMany
    @JoinTable(
            name = "course_section",
            joinColumns = @JoinColumn(name = "section_id"), // ref à la table de Section
            inverseJoinColumns = @JoinColumn(name = "course_id") // ref à la table de Course
    )
    private Set<Course> courses = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "delegate_id")
    private Student delegate;


    public Section(int id, String name) {
        this.id = id;
        this.name = name;
        this.studentsList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Section{" +
                "\n\t id: " +id +
                "\n\t name: " + name +
                "\n\t delegate id: " + delegate.getId() +
                "\n}";
    }
}
