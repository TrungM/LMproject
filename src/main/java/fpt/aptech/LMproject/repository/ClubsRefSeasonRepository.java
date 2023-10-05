/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package fpt.aptech.LMproject.repository;

import fpt.aptech.LMproject.entites.Clubs;
import fpt.aptech.LMproject.entites.ClubsRefSeason;
import fpt.aptech.LMproject.entites.Season;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Minh Trung
 */
public interface ClubsRefSeasonRepository extends JpaRepository<ClubsRefSeason, Integer> {
    @Query("SELECT COUNT(*) FROM ClubsRefSeason Where season=:season")
    int countClubsRef(@PathVariable("season") Season season);
    
     @Transactional
    @Modifying
    @Query("DELETE FROM ClubsRefSeason c WHERE c.season = :season AND c.clubID = :clubID  ")
    void DeleteByChooseClub(@PathVariable("season") Season season,@PathVariable("clubID") Clubs clubID);
}
