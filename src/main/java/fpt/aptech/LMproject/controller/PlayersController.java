/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package fpt.aptech.LMproject.controller;

import fpt.aptech.LMproject.DTO.PlayersDTO;
import fpt.aptech.LMproject.services.IFPlayers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Minh Trung
 */
@RestController
@RequestMapping("/api/players")
public class PlayersController {

    @Autowired
    private IFPlayers player;

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayersDTO> list(@RequestParam("page") Integer number) {
        return player.findAll(number);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayersDTO> listFull() {
        return player.findAllNoPagination();
    }

    @GetMapping(value = "/all/totalPage")
    @ResponseStatus(HttpStatus.OK)
    public int Totalpage() {
        return player.PageTotal();
    }

    @GetMapping(value = "/{id}")
    public PlayersDTO get(@PathVariable Integer id) {
        return player.getPlayersByID(id);
    }

    @GetMapping(value = "/search")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayersDTO> searchPlayers(@RequestParam("name") String name) {

        return player.searchByName("%" + name + "%");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PlayersDTO> put(@PathVariable Integer id, @RequestBody PlayersDTO playersDTO) {

        playersDTO.setId(id);
        PlayersDTO edit = player.updatePlayer(playersDTO);
        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PlayersDTO> post(@RequestBody PlayersDTO a) {

        return new ResponseEntity<>(player.savePlayers(a), HttpStatus.CREATED);

    }
    
     @PutMapping("/image/{id}")
    public ResponseEntity<PlayersDTO> putImage(@PathVariable Integer id) {
        player.updateImagePlayers(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        player.deleteByID(id);
    }

    @GetMapping("/index")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayersDTO> index() {
        return player.getAll();
    }

}
