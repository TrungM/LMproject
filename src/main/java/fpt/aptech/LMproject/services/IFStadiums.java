/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.StadiumsDTO;
import java.util.List;

/**
 *
 * @author Minh Trung
 */
public interface IFStadiums {

    public List<StadiumsDTO> findAll(int number);

    public List<StadiumsDTO> findAllNoPagination();

    public int PageTotal();

    public StadiumsDTO saveStadiums(StadiumsDTO newStadiums);

    public StadiumsDTO updateStadiums(StadiumsDTO updateStadiums);

    public StadiumsDTO getStadiumsByID(int id);

    public void deleteByID(int id);

    public void updateStadiumActive(Integer id);

    public void updateStadiumActive0(Integer id);

    public void updateImageStadium(Integer id);

    public boolean checkExistStadiums(Integer id);

}
