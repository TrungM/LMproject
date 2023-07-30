/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.SeasonDTO;
import java.util.List;

/**
 *
 * @author Minh Trung
 */
public interface IFSeason {
        public List<SeasonDTO> findAllNoPaginationSeason();
    public SeasonDTO createSeason(SeasonDTO season);

}
