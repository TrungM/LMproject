/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.ClubsDTO;
import fpt.aptech.LMproject.DTO.ClubsRefSeasonDTO;
import fpt.aptech.LMproject.entites.ClubsRefSeason;
import java.util.List;

/**
 *
 * @author Minh Trung
 */
public interface IFClubs {

    public List<ClubsDTO> getAll(int number);

    public int PageTotal();

    public List<ClubsDTO> findAllNoPagination();

    public List<ClubsDTO> listActiveClub();

    public List<ClubsRefSeasonDTO> listRefClub();

    public List<ClubsRefSeasonDTO> listRefClubUI();

    public ClubsDTO saveClubs(ClubsDTO clubs);

    public ClubsRefSeasonDTO addClubsForSeason(ClubsRefSeasonDTO ref);

    public ClubsDTO updateClubs(ClubsDTO updateclubs);

    public void updateActiveClubs(Integer code, Integer active);

    public void resetActiveClubs();

    public void updateImageClubs(Integer id);

    public ClubsDTO getClubByCode(String code);

    public List<ClubsDTO> searchByName(String nameclubs);

    public void deleteByID(Integer id);

    public List<ClubsDTO> getActive();

    public int clubCount();

    public int clubCountRef(Integer season);

    public void deleteChooseClub(Integer season, Integer clubID);

    public void updateClubsRefActiveUI(Integer season);

    public boolean checkExistclubs(Integer id);
    
     public boolean checkExistClubPlayers(Integer id);

}
