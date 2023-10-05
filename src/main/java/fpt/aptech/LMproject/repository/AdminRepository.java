/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package fpt.aptech.LMproject.repository;

import fpt.aptech.LMproject.entites.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Minh Trung
 */
public interface AdminRepository extends JpaRepository<Manager, Integer> {

    @Query("SELECT c FROM Manager c WHERE c.email = :email AND c.password = :password")
    Manager checkLogin(@PathVariable("email") String email ,@PathVariable("password") String password );
    
}
