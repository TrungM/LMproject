/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package fpt.aptech.LMproject.repository;

import fpt.aptech.LMproject.DTO.SeasonDTO;
import fpt.aptech.LMproject.entites.Season;
import java.util.List;
import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Minh Trung
 */
public interface SeasonRepository extends JpaRepository<Season, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Season c SET c.active=1 WHERE c.id =:id")
    int updateSeasonID(@PathVariable("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Season c SET c.activeUI=1 WHERE c.id =:id")
    int updateSeasonUI(@PathVariable("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Season c SET c.activeUI=0 WHERE NOT c.id =:id")
    int updateResetSeasonUI(@PathVariable("id") Integer id);

    @Query("SELECT c FROM Season c WHERE c.activeUI =1")
    List<Season> getActiveUI();

    @Query("SELECT COUNT(*) FROM Season Where activeUI = 1 ")
    int countActiveUI();

}
