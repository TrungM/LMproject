/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.RefereesDTO;
import java.util.List;

/**
 *
 * @author Minh Trung
 */
public interface IFReferees {

    public List<RefereesDTO> findAll(int number);

    public List<RefereesDTO> findAllNoPagination();

    public int PageTotal();

    public RefereesDTO saveReferees(RefereesDTO newReferees);

    public RefereesDTO updateReferees(RefereesDTO updateReferees);

    public RefereesDTO getRefereesByID(int id);

    public void deleteByID(int id);

    public boolean checkReferees(Integer referees);

}
