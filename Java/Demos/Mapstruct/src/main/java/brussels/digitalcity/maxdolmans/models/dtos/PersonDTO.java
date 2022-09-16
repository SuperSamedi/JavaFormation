package brussels.digitalcity.maxdolmans.models.dtos;

import brussels.digitalcity.maxdolmans.models.Sex;

import java.util.Objects;

public class PersonDTO {

    public String firstName;
    public String lastName;
    public String locality;
    public Sex sex;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(firstName, personDTO.firstName) && Objects.equals(lastName, personDTO.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", locality='" + locality + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
