/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.AdminDTO;
import fpt.aptech.LMproject.entites.Manager;
import fpt.aptech.LMproject.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Minh Trung
 */
@Service
public class AdminService implements IFAdmin {

    @Autowired
    private AdminRepository admin;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Manager loginAdmin(String email, String password) {
      
        Manager a = admin.checkLogin(email, password);
        
        return a;

    }

   public AdminDTO mapToDto(Manager a) {
        AdminDTO result = modelMapper.map(a, AdminDTO.class);
        return result;
    }
   
     public Manager mapToEntity(AdminDTO a) {
        Manager m = modelMapper.map(a, Manager.class);
        return m;
    }


}
