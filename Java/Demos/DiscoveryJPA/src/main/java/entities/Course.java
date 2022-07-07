package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @Column(name = "course_id")
    private String id;
    @Column(name = "course_name")
    private String name;
    @Column(name = "course_ects", columnDefinition = "DECIMAL(3,1)")
    private double ects;
    @Column(name = "professor_id")
    private Integer professorId;

    @ManyToMany(mappedBy = "courses")
    private Set<Section> sections = new HashSet<>();

    @Override
    public String toString() {
        return "Course{" +
                "\n\t id: " + id +
                "\n\t name: " + name +
                "\n\t ects: " + ects +
                "\n\t professor id: " + professorId +
                "\n}";
    }
}
