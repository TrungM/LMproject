/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package fpt.aptech.LMproject.controller;

import fpt.aptech.LMproject.DTO.FlagsDTO;
import fpt.aptech.LMproject.services.IFFlags;
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
@RequestMapping("/api/flags")
public class FlagsController {

    @Autowired
    private IFFlags flags;

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<FlagsDTO> listPage(@RequestParam("page") Integer number) {
        return flags.findAll(number);
    }

    @GetMapping(value = "/list")
    public List<FlagsDTO> listfull() {
        return flags.findAllNoPagination();
    }

    @GetMapping(value = "/all/totalPage")
    @ResponseStatus(HttpStatus.OK)
    public int Totalpage() {
        return flags.PageTotal();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FlagsDTO get(@PathVariable Integer id) {
        return flags.getFlagsByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlagsDTO> put(@PathVariable Integer id, @RequestBody FlagsDTO flagsDTO) {
        flagsDTO.setId(id);
        FlagsDTO edit = flags.updateFlags(flagsDTO);

        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<FlagsDTO> post(@RequestBody FlagsDTO flagsDTO) {
        return new ResponseEntity<>(flags.saveFlags(flagsDTO), HttpStatus.CREATED);
    }

    @PutMapping("/image/{id}")
    public ResponseEntity<FlagsDTO> putImage(@PathVariable Integer id) {
        flags.updateImageFlags(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        flags.deleteByID(id);
    }
    
        @GetMapping("/check/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean checkExist(@PathVariable Integer id) {
        return flags.checkExistFlags(id);
    }
}
