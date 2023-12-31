/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package fpt.aptech.LMproject.repository;

import fpt.aptech.LMproject.entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Minh Trung
 */
public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByEmail(String email);


}
