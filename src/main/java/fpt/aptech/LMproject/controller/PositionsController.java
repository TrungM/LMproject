/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package fpt.aptech.LMproject.controller;

import fpt.aptech.LMproject.DTO.PositionsDTO;
import fpt.aptech.LMproject.services.IFPositions;
import org.springframework.web.bind.annotation.RestController;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Minh Trung
 */
@RestController
@RequestMapping("/api/positions")
public class PositionsController {

    @Autowired
    private IFPositions positions;

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<PositionsDTO> listPage(@RequestParam("page") Integer number) {
        return positions.findAll(number);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public List<PositionsDTO> listFull() {
        return positions.findAllNoPagination();
    }

    @GetMapping(value = "/all/totalPage")
    @ResponseStatus(HttpStatus.OK)
    public int Totalpage() {
        return positions.PageTotal();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PositionsDTO get(@PathVariable Integer id) {
        return positions.getPositionsByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PositionsDTO> put(@PathVariable Integer id, @RequestBody PositionsDTO positionsDTO) {
        positionsDTO.setId(id);
        PositionsDTO edit = positions.updatePositions(positionsDTO);

        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<PositionsDTO> post(@RequestBody PositionsDTO positionsDTO) {
        return new ResponseEntity<>(positions.savePositions(positionsDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        positions.deleteByID(id);
    }
    
     @GetMapping("/check/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean checkExist(@PathVariable Integer id) {
        return positions.checkExistPositions(id);
    }

}
