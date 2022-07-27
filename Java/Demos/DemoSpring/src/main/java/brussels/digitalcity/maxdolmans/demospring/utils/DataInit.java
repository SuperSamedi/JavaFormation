package brussels.digitalcity.maxdolmans.demospring.utils;

import brussels.digitalcity.maxdolmans.demospring.entities.Player;
import brussels.digitalcity.maxdolmans.demospring.services.PlayerService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class DataInit implements InitializingBean {

    private final PlayerService playerService;

    private List<Player> players = Arrays.asList(
            Player.builder()
                    .name("Yassin")
                    .dateOfBirth(LocalDate.of(1990, 5, 12))
                    .number(1)
                    .position(Position.GOAL_KEEPER)
                    .salary(42_420.42)
                    .build(),
            Player.builder()
                    .name("Therence")
                    .dateOfBirth(LocalDate.of(1989, 11, 3))
                    .number(6)
                    .position(Position.BACK_LEFT)
                    .salary(42_420.42)
                    .build(),
            Player.builder()
                    .name("Chidi")
                    .dateOfBirth(LocalDate.of(1989, 1, 6))
                    .number(8)
                    .position(Position.CENTRAL_DEFENDER)
                    .salary(42_420.42)
                    .build(),
            Player.builder()
                    .name("James")
                    .dateOfBirth(LocalDate.of(1996, 8, 20))
                    .number(10)
                    .position(Position.FORWARD_CENTRE)
                    .salary(42_420.42)
                    .build(),
            Player.builder()
                    .name("Rufat")
                    .dateOfBirth(LocalDate.of(1993, 2, 14))
                    .number(7)
                    .position(Position.LIBERO)
                    .salary(42_420.42)
                    .build(),
            Player.builder()
                    .name("Thabit")
                    .dateOfBirth(LocalDate.of(1996, 8, 20))
                    .number(9)
                    .position(Position.CENTRAL_DEFENDER)
                    .salary(42_420.42)
                    .build(),
            Player.builder()
                    .name("Marcelo")
                    .dateOfBirth(LocalDate.of(1996, 8, 20))
                    .number(5)
                    .position(Position.CENTRAL_OFFENSIVE)
                    .salary(42_420.42)
                    .build(),
            Player.builder()
                    .name("Sebastien")
                    .dateOfBirth(LocalDate.of(1996, 8, 20))
                    .number(12)
                    .position(Position.CENTRAL_OFFENSIVE)
                    .salary(42_420.42)
                    .build(),
            Player.builder()
                    .name("Rami")
                    .dateOfBirth(LocalDate.of(1996, 8, 20))
                    .number(11)
                    .position(Position.FORWARD_RIGHT)
                    .salary(42_420.42)
                    .build(),
            Player.builder()
                    .name("Abed")
                    .dateOfBirth(LocalDate.of(1996, 8, 20))
                    .number(4)
                    .position(Position.BACK_RIGHT)
                    .salary(42_420.42)
                    .build(),
            Player.builder()
                    .name("Giuseppe")
                    .dateOfBirth(LocalDate.of(1996, 8, 20))
                    .number(3)
                    .position(Position.FORWARD_LEFT)
                    .salary(42_420.42)
                    .build(),
            Player.builder()
                    .name("Max")
                    .dateOfBirth(LocalDate.of(1991, 6, 20))
                    .number(13)
                    .position(Position.CENTRAL_DEFENDER)
                    .salary(42_420.42)
                    .build()
    );

    public DataInit(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            players.forEach(playerService::insert);
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
