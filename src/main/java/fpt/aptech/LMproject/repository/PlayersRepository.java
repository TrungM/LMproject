/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package fpt.aptech.LMproject.repository;

import fpt.aptech.LMproject.entites.Clubs;
import fpt.aptech.LMproject.entites.Flags;
import fpt.aptech.LMproject.entites.News;
import fpt.aptech.LMproject.entites.Players;
import fpt.aptech.LMproject.entites.Positions;
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
public interface PlayersRepository extends JpaRepository<Players, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Players c SET c.image = null  WHERE c.id = :id")
    int updateImagePlayers(@PathVariable("id") Integer id);

    @Query("SELECT c FROM Players c WHERE c.status=1 ORDER BY c.name DESC ")
    List<Players> getAll();

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Players u WHERE u.clubId = :id")
    boolean checkClubs(@PathVariable("id") Clubs id);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Players u WHERE u.nationality = :id")
    boolean checkFlags(@PathVariable("id") Flags id);

        @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Players u WHERE u.positionId = :id")
    boolean checkPositions(@PathVariable("id") Positions id);
}
