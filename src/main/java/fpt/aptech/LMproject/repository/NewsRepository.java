/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package fpt.aptech.LMproject.repository;

import fpt.aptech.LMproject.entites.News;
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
public interface NewsRepository extends JpaRepository<News, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE News c SET c.image = null  WHERE c.id = :id")
    int updateImageNews(@PathVariable("id") Integer id);

    @Query("SELECT c FROM News c WHERE c.status=1 ORDER BY c.id DESC ")
    List<News> getAll();

    @Query("SELECT c FROM News c WHERE c.status=1 AND c.isHome=1 ORDER BY c.id DESC ")
    List<News> getNewsHome();

}
    