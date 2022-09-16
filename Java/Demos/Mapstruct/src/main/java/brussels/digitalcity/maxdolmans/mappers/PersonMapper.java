package brussels.digitalcity.maxdolmans.mappers;

import brussels.digitalcity.maxdolmans.models.entities.Person;
import brussels.digitalcity.maxdolmans.models.dtos.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;

@Mapper
public interface PersonMapper {

    @Mapping(source = "address.locality", target = "locality")
    @ValueMapping(source = "sex", target = "sex")
    PersonDTO fromEntity(Person entity);

    Person toEntity(PersonDTO dto);

}
