/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package fpt.aptech.LMproject.controller;

import fpt.aptech.LMproject.DTO.SeasonDTO;
import fpt.aptech.LMproject.services.IFSeason;
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
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Minh Trung
 */
@RestController
@RequestMapping("/api/season")
public class SeasonController {

    @Autowired
    private IFSeason season;

    @GetMapping(value = "/listSeason")
    @ResponseStatus(HttpStatus.OK)
    public List<SeasonDTO> listMatch() {
        return season.findAllNoPaginationSeason();
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<SeasonDTO> post(@RequestBody SeasonDTO a) {
        return new ResponseEntity<>(season.createSeason(a), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }

}
