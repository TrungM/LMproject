/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package fpt.aptech.LMproject.controller;

import fpt.aptech.LMproject.entites.Users;
import fpt.aptech.LMproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Minh Trung
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userservice ;

    @PostMapping(value = "/register")
    public ResponseEntity<Users> register(@RequestBody Users user) {
        return new ResponseEntity<>(userservice.saveUser(user), HttpStatus.CREATED);
    }

}
