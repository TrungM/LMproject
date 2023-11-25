/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package fpt.aptech.LMproject.repository;

import fpt.aptech.LMproject.entites.Ranking;
import fpt.aptech.LMproject.entites.Referees;
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

    @Query("SELECT c FROM Schedules c WHERE c.season = :season AND c.clubHome=:id OR c.clubAway=:id")
    List<Schedules> FindByMatchClub(@PathVariable("id") Ranking id, @PathVariable("season") Season season);

    @Query("SELECT c FROM Schedules c WHERE c.clubHome=:id OR c.clubAway=:id")
    List<Schedules> FindByMatchNameClub(@PathVariable("id") Ranking id);

    @Query("SELECT c FROM Schedules c WHERE c.leg=:leg AND c.season=:season ORDER BY c.roundmatch ASC NULLS LAST ")
    List<Schedules> FindLeg(@PathVariable("leg") String leg, @PathVariable("season") Season season);

    @Query("SELECT COUNT(c) FROM Schedules c WHERE c.leg=:leg AND c.season=:season ")
    int countLeg(@PathVariable("leg") String leg, @PathVariable("season") Season season);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Schedules u WHERE u.season = :season")
    boolean checkSeason(@PathVariable("season") Season season);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Schedules u WHERE u.referees = :referees")
    boolean checkReferees(@PathVariable("referees") Referees referees);

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

    @Query("SELECT c  FROM Schedules c  Where c.active = 1 AND c.status IS NULL  AND c.matchDay IS NOT NULL AND c.matchDay != '' AND c.matchTime IS NOT NULL AND c.matchTime != ''  OR c.status = 0 Order By c.matchDay ASC ")
    List<Schedules> getSchedulesUI();

    @Transactional
    @Modifying
    @Query("UPDATE Schedules c SET c.isHome = :isHome  WHERE c.roundmatch = :roundmatch AND c.active = 1 ")
    int updateHomepage(@PathVariable("isHome") Integer isHome, @PathVariable("roundmatch") Integer roundmatch);

    @Transactional
    @Modifying
    @Query("UPDATE Schedules c SET c.isHome = 0  WHERE NOT c.roundmatch = :roundmatch")
    int updateResetHomepage(@PathVariable("roundmatch") Integer roundmatch);

    @Query("SELECT c  FROM Schedules c  Where c.active = 1 AND c.isHome = 1 AND c.matchDay IS NOT NULL AND c.matchDay != '' AND c.matchTime IS NOT NULL AND c.matchTime != ''  Order By c.matchDay ASC ")
    List<Schedules> getMatchHomepage();

    @Transactional
    @Modifying
    @Query("UPDATE Schedules c SET c.status = :status  WHERE id = :id ")
    int updateType(@PathVariable("type") Integer status, @PathVariable("id") Integer id);

    @Query("SELECT c  FROM Schedules c  Where c.active = 1 AND c.status = 0 OR c.status = 1 Order By c.matchDay ASC ")
    List<Schedules> getResult();

}
