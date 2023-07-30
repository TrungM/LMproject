/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package fpt.aptech.LMproject.controller;

import fpt.aptech.LMproject.DTO.ClubsDTO;
import fpt.aptech.LMproject.services.IFClubs;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Minh Trung
 */
@RestController
@RequestMapping("/api/clubs")
public class ClubsController {

    @Autowired
    private IFClubs clubs;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ClubsDTO> list(@RequestParam("page") Integer number) {
        return clubs.getAll(number);
    }

    @GetMapping("/activeAll")
    @ResponseStatus(HttpStatus.OK)
    public List<ClubsDTO> listActive() {
        return clubs.getActive();
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public List<ClubsDTO> listFull() {
        return clubs.findAllNoPagination();
    }

    @GetMapping(value = "/listActiveClub")
    @ResponseStatus(HttpStatus.OK)
    public List<ClubsDTO> listActiveClub() {
        return clubs.listActiveClub();
    }

    @GetMapping(value = "/all/totalPage")
    @ResponseStatus(HttpStatus.OK)
    public int Totalpage() {
        return clubs.PageTotal();
    }

    @GetMapping("/all/{id}")
    public Object get(@PathVariable String id) {
        return clubs.getClubByCode(id);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public Object searchClubs(@RequestParam("name") String name) {

        return clubs.searchByName("%" + name + "%");
    }

    @GetMapping("/countClubs")
    @ResponseStatus(HttpStatus.OK)
    public int countClubs() {
        return clubs.clubCount();
    }

    @PutMapping("/{code}")
    public ResponseEntity<ClubsDTO> put(@PathVariable String code, @RequestBody ClubsDTO clubdto) {

        clubdto.setCodeClub(code);
        ClubsDTO edit = clubs.updateClubs(clubdto);
        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClubsDTO> post(@RequestBody ClubsDTO a) {

        return new ResponseEntity<>(clubs.saveClubs(a), HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        clubs.deleteByID(id);
    }

    @PutMapping("/image/{id}")
    public ResponseEntity<ClubsDTO> putStadiumActiveDelete(@PathVariable Integer id) {
        clubs.updateImageClubs(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/activeClub/{code}/{active}")
    public ResponseEntity<ClubsDTO> putClubActive(@PathVariable Integer code, @PathVariable Integer active) {
        clubs.updateActiveClubs(code, active);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/activeClub/reset")
    public ResponseEntity<ClubsDTO> resetClubActive() {
        clubs.resetActiveClubs();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
