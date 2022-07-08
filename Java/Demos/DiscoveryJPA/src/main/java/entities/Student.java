package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Entity
@Table(name = "student")
@Getter @Setter
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
    @Column(name = "year_result")
    private int yearResult;
    @Column(name = "course_id")
    private String courseId;

    @ManyToOne
    @JoinColumn(name = "section_id", foreignKey = @ForeignKey())
    private Section section;

    @OneToOne(mappedBy = "delegate")
    private Section delegateOf;


    private String formattedDOB() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateOfBirth.format(dtf);
    }

    @Override
    public String toString() {
        String display = "Student{" +
                "\n\t id: " +  id +
                "\n\t name: " + firstName + " " + lastName +
                "\n\t date of birth: " + formattedDOB() +
                "\n\t login: " + login +
                "\n\t year result: " + yearResult +
                "\n\t course id: " + courseId +
                "\n\t section: ";

        if (section == null){
            display +=  "null" +
                    "\n}";
        }
        else {
            display += "Section{" +
                    "\n\t\t id: " + section.getId() +
                    "\n\t\t name: " + section.getName() +
                    "\n\t\t delegate id: " + section.getDelegate().getId() +
                    "\n\t}" +
                    "\n}";
        }

        return display;
    }
}
