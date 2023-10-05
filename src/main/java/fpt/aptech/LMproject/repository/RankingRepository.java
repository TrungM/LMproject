/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package fpt.aptech.LMproject.repository;

import fpt.aptech.LMproject.DTO.RankingDTO;
import fpt.aptech.LMproject.entites.Clubs;
import fpt.aptech.LMproject.entites.Ranking;
import fpt.aptech.LMproject.entites.Season;
import java.util.List;
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
public interface RankingRepository extends JpaRepository<Ranking, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Ranking c WHERE c.clubid = :id ")
    void DeleteByCode(@PathVariable("id") Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Ranking c WHERE c.season = :season AND c.clubName = :clubName ")
    void DeleteBySeason(@PathVariable("season") Integer season, @PathVariable("clubName") Clubs clubName);

    @Query("SELECT c FROM Ranking c WHERE c.clubid = :codeClub")
    Ranking FindOneClubs(@PathVariable("codeClub") Integer codeClub);

    @Query("SELECT c FROM Ranking c WHERE c.id =:id")
    Ranking getByID(@PathVariable("id") Integer id);

    @Query("SELECT c FROM Ranking c WHERE c.active = 1 ORDER BY c.clubName.name ASC ")
    List<Ranking> getRankingUI();

    @Query("SELECT c FROM Ranking c ORDER BY c.clubName.name ASC ")
    List<Ranking> getAll();

    @Transactional
    @Modifying
    @Query("UPDATE Ranking c SET c.active = 1  WHERE c.season = :season")
    int updateRankingUI(@PathVariable("season") Integer season);
}
