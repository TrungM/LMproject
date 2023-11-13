/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.DTO;

import fpt.aptech.LMproject.entites.Season;

/**
 *
 * @author Minh Trung
 */
public class ClubsRefSeasonDTO {

    private Integer id;
    private ClubsDTO clubID;
    private Season season;
    private Integer active;

    public ClubsRefSeasonDTO() {
    }

    public ClubsRefSeasonDTO(Integer id, ClubsDTO clubID, Season season, Integer active) {
        this.id = id;
        this.clubID = clubID;
        this.season = season;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClubsDTO getClubID() {
        return clubID;
    }

    public void setClubID(ClubsDTO clubID) {
        this.clubID = clubID;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
    
    

}
