package brussels.digitalcity.maxdolmans.demospring.mapper;

import brussels.digitalcity.maxdolmans.demospring.dtos.PlayerDTO;
import brussels.digitalcity.maxdolmans.demospring.entities.Player;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class Mapper {

    public PlayerDTO toPlayerDto(Player entity) {
        int ageCalc = Period.between(entity.getDateOfBirth(), LocalDate.now()).getYears();
        return PlayerDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .dateOfBirth(entity.getDateOfBirth())
                .number(entity.getNumber())
                .position(entity.getPosition())
                .salary(entity.getSalary())
                .age(ageCalc)
                .build();
    }

    public Player toPlayerEntity(PlayerDTO dto) {
        return null;
    }
}
