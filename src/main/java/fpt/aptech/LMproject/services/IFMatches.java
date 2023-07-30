/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.RankingDTO;
import fpt.aptech.LMproject.DTO.SchedulesDTO;
import java.util.List;

/**
 *
 * @author Minh Trung
 */
public interface IFMatches {

    public void createSchdule(List<RankingDTO> clubs);

    public List<SchedulesDTO> findAll();
    
    public SchedulesDTO updateAndFixMatches (SchedulesDTO update); 
    public SchedulesDTO getMatchByID(Integer id);


    public int SchduleCount();

}
