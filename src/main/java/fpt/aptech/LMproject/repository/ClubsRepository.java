/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package fpt.aptech.LMproject.repository;

import fpt.aptech.LMproject.entites.Clubs;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import fpt.aptech.LMproject.entites.Stadiums;

/**
 *
 * @author Minh Trung
 */
public interface ClubsRepository extends JpaRepository<Clubs, Integer> {

    @Query("SELECT c FROM Clubs c WHERE c.name  LIKE %:nameClubs%")
    List<Clubs> FindByNameClubs(@Param("nameClubs") String nameClubs);

    @Query("SELECT c FROM Clubs c WHERE c.active=1")
    List<Clubs> FindByActive();

    @Query("SELECT c FROM Clubs c WHERE c.codeClub = :codeClub")
    Clubs FindOneClubs(@PathVariable("codeClub") String codeClub);

    @Transactional
    @Modifying
    @Query("DELETE FROM Clubs c WHERE c.id = :id ")
    void DeleteByCode(@PathVariable("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Clubs c SET c.image = null  WHERE c.id = :id")
    int updateImageClubs(@PathVariable("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Clubs c SET c.active = :active  WHERE c.id = :id")
    int updateActiveClubs(@PathVariable("id") Integer id, @PathVariable("active") Integer active);

    @Query("SELECT c FROM Clubs c WHERE c.active=1 ")
    List<Clubs> FindClubsActive();

    @Transactional
    @Modifying
    @Query("UPDATE Clubs c SET c.active= 0 WHERE c.active = 1 ")
    int ResetActiveClubs();

    @Query("SELECT COUNT(*) FROM Clubs Where active=1")
    int countClubsActive();
    
     @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Clubs u WHERE u.stadiumid = :id")
    boolean checkStadiums(@PathVariable("id") Stadiums id );

 

}
