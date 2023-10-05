/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package fpt.aptech.LMproject.repository;

import fpt.aptech.LMproject.entites.Clubs;
import fpt.aptech.LMproject.entites.Ranking;
import fpt.aptech.LMproject.entites.Schedules;
import fpt.aptech.LMproject.entites.Season;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Minh Trung
 */
public interface SchedulesRepository extends JpaRepository<Schedules, Integer> {

    @Query("SELECT COUNT(*) FROM Schedules")
    int countSchedulesActive();

    @Query("SELECT c FROM Schedules c WHERE c.clubHome=:id OR c.clubAway=:id")
    List<Schedules> FindByMatchNameClub(@PathVariable("id") Ranking id);

    @Query("SELECT c FROM Schedules c WHERE c.leg=:leg AND c.season=:season ORDER BY c.roundmatch ASC NULLS LAST ")
    List<Schedules> FindLeg(@PathVariable("leg") String leg, @PathVariable("season") Season season);

    @Query("SELECT COUNT(c) FROM Schedules c WHERE c.leg=:leg AND c.season=:season ")
    int countLeg(@PathVariable("leg") String leg, @PathVariable("season") Season season);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Schedules u WHERE u.season = :season")
    boolean checkSeason(@PathVariable("season") Season season);

    @Transactional
    @Modifying
    @Query("UPDATE Schedules c SET c.active = :active  WHERE c.id = :id")
    int updateActiveMatch(@PathVariable("id") Integer id, @PathVariable("active") Integer active);

    @Transactional
    @Modifying
    @Query("DELETE FROM Schedules c WHERE c.season = :season ")
    void DeleteBySeason(@PathVariable("season") Season season);

    @Transactional
    @Modifying
    @Query("UPDATE Schedules c SET c.active = 1  WHERE c.season = :season")
    int updateScheduleUI(@PathVariable("season") Season season);

    @Query("SELECT c FROM Schedules c WHERE c.active = 1 ")
    List<Schedules> getSchedulesUI();

}
