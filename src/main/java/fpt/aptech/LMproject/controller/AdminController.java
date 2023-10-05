/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package fpt.aptech.LMproject.controller;

import fpt.aptech.LMproject.DTO.AdminDTO;
import fpt.aptech.LMproject.entites.Manager;
import fpt.aptech.LMproject.services.IFAdmin;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Minh Trung
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private IFAdmin admin;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Manager login(@RequestParam("email") String email, @RequestParam("password") String password) {
       Manager a= admin.loginAdmin(email, password);
        return a;
    }

}
