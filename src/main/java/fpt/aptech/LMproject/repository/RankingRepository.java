/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package fpt.aptech.LMproject.repository;

import fpt.aptech.LMproject.entites.Ranking;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

    @Query("SELECT c FROM Ranking c WHERE c.clubid = :codeClub")
    Ranking FindOneClubs(@PathVariable("codeClub") Integer codeClub);
}
