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

    public void createSchedule(List<RankingDTO> clubs);

    public List<SchedulesDTO> findAll();

    public List<SchedulesDTO> findClubsActive(Integer a);

    public SchedulesDTO updateAndFixMatches(SchedulesDTO update);

    public SchedulesDTO getMatchByID(Integer id);

    public void updateActiveMatches(Integer code, Integer active);

    public void updateMatchesHomepage(Integer isHome, Integer roundmatch);

    public void updateResetMatchesHomepage(Integer roundmatch);

    public void updateType(Integer type, Integer id);

    public List<SchedulesDTO> findLeg(String leg, Integer season);

    public int SchduleCount();

    public int legCount(String leg, Integer season);

    public boolean checkSeason(Integer season);


    public void deleteAll();

    public void deleteSeasonTable(Integer season);

    public List<SchedulesDTO> listMatchFollowClub(Integer id, Integer season);

//    UI
    public List<SchedulesDTO> getListUI();

    public void updateSchduleActiveUI(Integer season);

    public List<SchedulesDTO> getMatchHomepage();

    public List<SchedulesDTO> getResult();

}
