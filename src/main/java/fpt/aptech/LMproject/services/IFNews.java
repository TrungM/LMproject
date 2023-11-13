/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.NewsDTO;
import java.util.List;

/**
 *
 * @author Minh Trung
 */
public interface IFNews {

    public List<NewsDTO> findAll(int number);

    public List<NewsDTO> findAllNoPagination();

    public int PageTotal();

    public NewsDTO saveNews(NewsDTO saveNews);

    public NewsDTO updateNews(NewsDTO updateNews);

    public NewsDTO getNewsByID(int id);

    public void deleteByID(int id);

    public void updateImageClubs(Integer id);

    public List<NewsDTO> getAll();

    public List<NewsDTO> getAllHome();

}
