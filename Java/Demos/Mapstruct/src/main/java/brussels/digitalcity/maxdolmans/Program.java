package brussels.digitalcity.maxdolmans;

import brussels.digitalcity.maxdolmans.mappers.PersonMapper;
import brussels.digitalcity.maxdolmans.models.Sex;
import brussels.digitalcity.maxdolmans.models.entities.Address;
import brussels.digitalcity.maxdolmans.models.entities.Animal;
import brussels.digitalcity.maxdolmans.models.entities.Person;
import brussels.digitalcity.maxdolmans.models.dtos.PersonDTO;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {

        PersonMapper mapper = Mappers.getMapper(PersonMapper.class);

        Person p = new Person(1L,
                "Bob",
                "L'éponge",
                LocalDate.of(1991, 6, 20),
                new Address(1L, "avenue principale", "5b", "150000", "Bikkini Bottom"),
                Sex.MALE
        );

        System.out.println(p);
        PersonDTO dto = mapper.fromEntity(p);
        System.out.println(dto);
        Person p2 = mapper.toEntity(dto);
        System.out.println(p2);

        // -----------------

        Animal a = Animal.instance;
    }
}
