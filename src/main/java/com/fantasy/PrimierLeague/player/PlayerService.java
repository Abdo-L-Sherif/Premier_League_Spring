package com.fantasy.PrimierLeague.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {

    private final PlayerRepository PlayerRepo;

    @Autowired
    public PlayerService(PlayerRepository repo) {
        this.PlayerRepo = repo;
    }


    public List<Player> getPlayers() {
        List<Player> players = PlayerRepo.findAll();
        System.out.println(players);
        return players;
    }

    public List<Player> getPlayerByTeam(String teamName) {
        return PlayerRepo.findAll().stream().
                filter(player -> teamName.equals(player.getTeamName())).collect(Collectors.toList());
    }

    public List<Player> getPlayerByName(String name) {
        return PlayerRepo.findAll().stream()
                .filter(player -> player.getName().toLowerCase()
                    .contains(name.toLowerCase()))
                        .collect(Collectors.toList());

    }

    public List<Player> getPlayerByPosition(String position) {
        return PlayerRepo.findAll().stream()
                .filter(player -> player.getPosision().toLowerCase()
                    .contains(position.toLowerCase())).collect(Collectors.toList());
    }

    public List<Player> getPlayerByNation(String nation) {
        return PlayerRepo.findAll().stream()
                .filter(player -> player.getNation().toLowerCase()
                        .contains(nation.toLowerCase())).collect(Collectors.toList());
    }

    public List<Player> getPlayerByTeamAndPosition(String team, String position) {
        return PlayerRepo.findAll().stream()
                .filter(player -> team.equals(player.getTeamName()) && position.equals(player.getPosision()))
                        .collect(Collectors.toList());
    }

    public Player addPlayer(Player player) {
        PlayerRepo.save(player);
        return player;
    }

    public Player updatePlayer(Player player) {
        Optional<Player> Xplayer = PlayerRepo.findByName(player.getName());
        if (Xplayer.isPresent()) {
            Player playerToUpdate = Xplayer.get();
            playerToUpdate.setName(player.getName());
            playerToUpdate.setTeamName(player.getTeamName());
            playerToUpdate.setPosision(player.getPosision());
            playerToUpdate.setNation(player.getNation());

            PlayerRepo.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }
    @Transactional
    public void removePlayer(String playerName) {
        PlayerRepo.deleteByName(playerName);
    }

}
