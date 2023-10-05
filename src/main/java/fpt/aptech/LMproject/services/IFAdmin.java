/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.AdminDTO;
import fpt.aptech.LMproject.entites.Manager;

/**
 *
 * @author Minh Trung
 */
public interface IFAdmin {
        public Manager loginAdmin (String email , String password);

}
