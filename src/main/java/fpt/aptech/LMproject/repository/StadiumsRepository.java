/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package fpt.aptech.LMproject.repository;

import fpt.aptech.LMproject.entites.Stadiums;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Minh Trung
 */
public interface StadiumsRepository extends JpaRepository<Stadiums, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Stadiums c SET c.active = 1  WHERE c.id = :id")
    int updateActiveByID(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("UPDATE Stadiums c SET c.active = 0  WHERE c.id = :id")
    int updateActive0ByID(@Param("id") int id);
    
     @Transactional
    @Modifying
    @Query("UPDATE Stadiums c SET c.image = null  WHERE c.id = :id")
    int updateImageStadiums(@PathVariable("id") Integer id);
    
    
}
