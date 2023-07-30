/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package fpt.aptech.LMproject.controller;

import fpt.aptech.LMproject.DTO.RankingDTO;
import fpt.aptech.LMproject.services.IFRanking;
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
@RequestMapping("/api/table")
public class TableController {

    @Autowired
    private IFRanking ranking;

    @GetMapping("/list")
    public List<RankingDTO> list() {
        return ranking.getAll();
    }

    @GetMapping("/list/{id}")
    public Object get(@PathVariable Integer id) {
        return ranking.getRankingByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RankingDTO> put(@PathVariable Integer id, @RequestBody RankingDTO a) {

        a.setId(id);
        RankingDTO edit = ranking.updateTables(a);

        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public RankingDTO post(@RequestBody RankingDTO a) {

        a.setPlayer(0);
        a.setWon(0);
        a.setDraw(0);
        a.setLose(0);
        a.setGF(0);
        a.setGD(0);
        a.setGA(0);
        a.setPoints(0);
        a.setSeason(1);
        return ranking.createTable(a);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        ranking.deleteByID(id);
    }

}
