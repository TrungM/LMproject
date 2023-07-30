/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package fpt.aptech.LMproject.controller;

import fpt.aptech.LMproject.DTO.RankingDTO;
import fpt.aptech.LMproject.DTO.SchedulesDTO;
import fpt.aptech.LMproject.DTO.SeasonDTO;
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
    public List<SchedulesDTO> list() {
        return matches.findAll();
    }

    @PostMapping(value = "/createMatches")
    public ResponseEntity<String> postSchedules(@RequestBody List<RankingDTO> clubs) {
         matches.createSchdule(clubs);
         return  ResponseEntity.ok("Congra");

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

}
