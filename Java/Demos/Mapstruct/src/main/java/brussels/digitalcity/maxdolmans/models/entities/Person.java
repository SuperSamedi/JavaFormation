package brussels.digitalcity.maxdolmans.models.entities;

import brussels.digitalcity.maxdolmans.models.Sex;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Classe mutable représentant un membre de la société.
 * <p>
 * FA = { id, firstName, lastName, dateOfBirth }
 * @attribute id Long
 * @attribute firstName String
 * @attribute lastName String
 * @attribute dateOfBirth LocalDate
 *
 * @invariant id != null > 0
 * @invariant firstName != null length > 0
 * @invariant lastName != null
 * @invariant dateOfBirth != null
 */
public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Address address;
    private Sex sex;


    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate dateOfBirth, Address address, Sex sex) {
        this.id = 0L;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.sex = sex;
    }

    public Person(Long id, String firstName, String lastName, LocalDate dateOfBirth, Address address, Sex sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long value) {
        id = value;
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the entity.
     * @param value String | value != null AND value.length > 0
     * @throws IllegalArgumentException e | value == null OR value.length <= 0
     * @return void
     * @modify this.firstName
     */
    public void setFirstName(String value) {
        if (value == null) throw new IllegalArgumentException("Can't set a firstname to null.");
        if (value.length() <= 0) throw new IllegalArgumentException("Can't set a firstname with a String of length 0.");
        firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        lastName = value;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate value) {
        dateOfBirth = value;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address value) {
        address = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id)
                && firstName.equals(person.firstName)
                && lastName.equals(person.lastName)
                && dateOfBirth.equals(person.dateOfBirth)
                && address.equals(person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
