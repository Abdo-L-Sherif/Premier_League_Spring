package com.fantasy.PrimierLeague.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {
    private final PlayerService Pservice;

    @Autowired
    public PlayerController(PlayerService Pservice) {
        this.Pservice = Pservice;
    }

    @GetMapping
    public List<Player> getAllPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation
    ) {
        if (team != null || position != null) {
            return Pservice.getPlayerByTeamAndPosition(team,position);
        }
        else if(team != null){
            return Pservice.getPlayerByTeam(team);
        }
        else if(position != null){
            return Pservice.getPlayerByPosition(position);
        } else if (nation != null) {
            return Pservice.getPlayerByNation(nation);
        }
        else {
            return Pservice.getPlayers();
        }
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player newPlayer = Pservice.addPlayer(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player upPlayer = Pservice.updatePlayer(player);
        if (upPlayer != null) {
            return new ResponseEntity<>(upPlayer, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deletePlayer(@PathVariable String name) {
        Pservice.removePlayer(name);
        return new ResponseEntity<>("Player removed", HttpStatus.OK);
    }

}
