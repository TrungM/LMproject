/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package fpt.aptech.LMproject.controller;

import fpt.aptech.LMproject.DTO.RankingDTO;
import fpt.aptech.LMproject.DTO.SchedulesDTO;
import fpt.aptech.LMproject.services.IFMatches;
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
@RequestMapping("/api/match")
public class MatchesController {

    @Autowired
    private IFMatches matches;

    @GetMapping("/list")
    public List<SchedulesDTO> list(@RequestParam("id") Integer id) {
        if (id == 0) {
            return matches.findAll();
        } else {
            return matches.findClubsActive(id);
        }
    }

    @GetMapping("/listLeg/{leg}/{season}")
    public List<SchedulesDTO> listLeg(@PathVariable("leg") String leg, @PathVariable("season") Integer season) {
        return matches.findLeg(leg, season);
    }

    @PostMapping(value = "/createMatches")
    public ResponseEntity<String> postSchedules(@RequestBody List<RankingDTO> clubs) {
        matches.createSchdule(clubs);
        return ResponseEntity.ok("Congra");

    }

    @GetMapping("/list/{id}")
    public Object get(@PathVariable Integer id) {
        return matches.getMatchByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchedulesDTO> put(@PathVariable Integer id, @RequestBody SchedulesDTO dto) {

        dto.setId(id);
        SchedulesDTO edit = matches.updateAndFixMatches(dto);

        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }

    @GetMapping("/countMatches")
    @ResponseStatus(HttpStatus.OK)
    public int countClubs() {
        return matches.SchduleCount();
    }

    @PutMapping("/activeClub/{code}/{active}")
    public ResponseEntity<SchedulesDTO> putSchedulesActive(@PathVariable Integer code, @PathVariable Integer active) {
        matches.updateActiveMatches(code, active);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteAll")
    @ResponseStatus(HttpStatus.OK)
    public void delete() {
        matches.deleteAll();
    }

    @GetMapping("/countLeg/{leg}/{season}")
    @ResponseStatus(HttpStatus.OK)
    public int countClubs(@PathVariable String leg, @PathVariable Integer season) {
        return matches.legCount(leg, season);
    }

    @GetMapping("/checkSeason/{season}")
    @ResponseStatus(HttpStatus.OK)
    public boolean countClubs(@PathVariable Integer season) {
        return matches.checkSeason(season);
    }

    @DeleteMapping("/deleteSeason/{season}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSeason(@PathVariable int season) {
        matches.deleteSeasonTable(season);
    }

    @GetMapping("/matches/{id}/{season}")
    public Object getMatchClub(@PathVariable Integer id, @PathVariable Integer season) {
        return matches.listMatchFollowClub(id, season);
    }

    // UI
    @GetMapping("/index")
    public List<SchedulesDTO> index() {
        return matches.getListUI();
    }

    @PutMapping("/active/{season}")
    public ResponseEntity<RankingDTO> putActiveUI(@PathVariable Integer season) {
        matches.updateSchduleActiveUI(season);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
