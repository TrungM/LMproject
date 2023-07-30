/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package fpt.aptech.LMproject.controller;

import fpt.aptech.LMproject.DTO.StadiumsDTO;
import fpt.aptech.LMproject.services.IFStadiums;
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
@RequestMapping("/api/stadiums")
public class StadiumsController {

    @Autowired
    private IFStadiums stadium;

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<StadiumsDTO> listPage(@RequestParam("page") Integer number) {
        return stadium.findAll(number);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public List<StadiumsDTO> listFull() {
        return stadium.findAllNoPagination();
    }

    @GetMapping(value = "/all/totalPage")
    @ResponseStatus(HttpStatus.OK)
    public int Totalpage() {
        return stadium.PageTotal();
    }

    @GetMapping("/all/{id}")
    @ResponseStatus(HttpStatus.OK)
    // gia tri tu link 
    public StadiumsDTO get(@PathVariable Integer id) {
        return stadium.getStadiumsByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StadiumsDTO> put(@PathVariable Integer id, @RequestBody StadiumsDTO stadiumdto) {
//        Optional<StadiumsDTO> c= stadium.getStadiumsByID(id);
//        if(!c.is){
//        return ResponseEntity.noContent().build();
//        }
        stadiumdto.setId(id);
        StadiumsDTO edit = stadium.updateStadiums(stadiumdto);

        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<StadiumsDTO> putStadiumActive(@PathVariable Integer id) {
        stadium.updateStadiumActive(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/activereset/{id}")
    public ResponseEntity<StadiumsDTO> putStadiumActiveDelete(@PathVariable Integer id) {
        stadium.updateStadiumActive0(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<StadiumsDTO> post(@RequestBody StadiumsDTO a) {
        return new ResponseEntity<>(stadium.saveStadiums(a), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        stadium.deleteByID(id);
    }
    
    
     @PutMapping("/image/{id}")
    public ResponseEntity<StadiumsDTO> putStadiumImage(@PathVariable Integer id) {
        stadium.updateImageStadium(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
