package brussels.digitalcity.maxdolmans.demospring.services;

import brussels.digitalcity.maxdolmans.demospring.dtos.PlayerDTO;
import brussels.digitalcity.maxdolmans.demospring.entities.Player;
import brussels.digitalcity.maxdolmans.demospring.mapper.Mapper;
import brussels.digitalcity.maxdolmans.demospring.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService implements IService<Player, PlayerDTO, Long> {

    private final PlayerRepository playerRepository;
    private final Mapper mapper;

    public PlayerService(PlayerRepository playerRepository, Mapper mapper) {
        this.playerRepository = playerRepository;
        this.mapper = mapper;
    }

    @Override
    public List<PlayerDTO> getAll() {
        return this.playerRepository
                .findAll().stream()
                .map(mapper::toPlayerDto)
                .collect(Collectors.toList());
    }

    @Override
    public PlayerDTO getById(Long id) {
        return this.playerRepository
                .findById(id)
                .map(mapper::toPlayerDto)
                .orElse(null);
    }

    @Override
    public boolean update(Long id, Player player) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public PlayerDTO insert(Player player) {
        if (player == null){
            throw new IllegalArgumentException("Cannot insert a null object in db.");
        }

        return mapper.toPlayerDto(this.playerRepository.save(player));
    }
}
