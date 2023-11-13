/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.PositionsDTO;
import java.util.List;

/**
 *
 * @author Minh Trung
 */
public interface IFPositions {

    public List<PositionsDTO> findAll(int number);

    public List<PositionsDTO> findAllNoPagination();

    public int PageTotal();

    public PositionsDTO savePositions(PositionsDTO newPositions);

    public PositionsDTO updatePositions(PositionsDTO updatePositions);

    public PositionsDTO getPositionsByID(int id);

    public void deleteByID(int id);

    public boolean checkExistPositions(Integer id);

}
