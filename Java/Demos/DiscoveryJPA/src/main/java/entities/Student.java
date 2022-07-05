package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "student_id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private LocalDateTime dateOfBirth;
    @Column(name = "login")
    private String login;
    @Column(name = "section_id")
    private int sectionId;
    @Column(name = "year_result")
    private int yearResult;
    @Column(name = "course_id")
    private String courseId;

    @Override
    public String toString() {
        return "Student{" + id +
                ", " + firstName +
                " " + lastName +
                ", dateOfBirth=" + dateOfBirth +
                ", login=" + login +
                ", sectionId=" + sectionId +
                ", yearResult=" + yearResult +
                ", courseId=" + courseId +
                "}";
    }
}
