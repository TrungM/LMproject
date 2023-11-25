/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.controller;

import fpt.aptech.LMproject.DTO.RefereesDTO;
import fpt.aptech.LMproject.services.IFReferees;
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
@RequestMapping("/api/referees")
public class RefereesController {

    @Autowired
    private IFReferees referees;

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<RefereesDTO> listPage(@RequestParam("page") Integer number) {
        return referees.findAll(number);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public List<RefereesDTO> listFull() {
        return referees.findAllNoPagination();
    }

    @GetMapping(value = "/all/totalPage")
    @ResponseStatus(HttpStatus.OK)
    public int Totalpage() {
        return referees.PageTotal();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RefereesDTO get(@PathVariable Integer id) {
        return referees.getRefereesByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RefereesDTO> put(@PathVariable Integer id, @RequestBody RefereesDTO refereesDTO) {
        refereesDTO.setId(id);
        RefereesDTO edit = referees.updateReferees(refereesDTO);

        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<RefereesDTO> post(@RequestBody RefereesDTO RefereesDTO) {
        return new ResponseEntity<>(referees.saveReferees(RefereesDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        referees.deleteByID(id);
    }

    @GetMapping("/check/{referee}")
    @ResponseStatus(HttpStatus.OK)
    public boolean checkReferee(@PathVariable Integer referee) {
        return referees.checkReferees(referee);
    }

}
