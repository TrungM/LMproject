/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package fpt.aptech.LMproject.controller;

import fpt.aptech.LMproject.services.IFClubs;
import fpt.aptech.LMproject.services.IFStadiums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Minh Trung
 */
@Controller
public class HomeController {
       @Autowired
    private IFStadiums stadium;
        
    @RequestMapping("/stadiums")
    public String index(Model model) {
//        model.addAttribute("list", stadium.getAllStadiums());
        return "index";
    }
    
}
