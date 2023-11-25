/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.DTO;

import fpt.aptech.LMproject.entites.Referees;
import fpt.aptech.LMproject.entites.Season;
import fpt.aptech.LMproject.entites.Stadiums;

/**
 *
 * @author Minh Trung
 */
public class SchedulesDTO {

    private Integer id;
    private String matchCode;
    private RankingDTO clubHome;
    private RankingDTO clubAway;
    private String matchDay;
    private String matchTime;
    private Season season;
    private Integer roundmatch;
    private String leg;
    private Integer resultClubHome;
    private Integer resultClubAway;
    private Stadiums stadiumId;
    private Referees referees;
    private Integer active;
    private Integer isHome;
    private Integer status;
    private String timeHappen;

    public SchedulesDTO() {
    }

    ;

    public SchedulesDTO(Integer id, String matchCode, RankingDTO clubHome, RankingDTO clubAway, String matchDay, String matchTime, Season season, Integer roundmatch, String leg, Integer resultClubHome, Integer resultClubAway, Stadiums stadiumId, Referees referees, Integer active, Integer isHome, Integer status, String timeHappen) {
        this.id = id;
        this.matchCode = matchCode;
        this.clubHome = clubHome;
        this.clubAway = clubAway;
        this.matchDay = matchDay;
        this.matchTime = matchTime;
        this.season = season;
        this.roundmatch = roundmatch;
        this.leg = leg;
        this.resultClubHome = resultClubHome;
        this.resultClubAway = resultClubAway;
        this.stadiumId = stadiumId;
        this.referees = referees;
        this.active = active;
        this.isHome = isHome;
        this.status = status;
        this.timeHappen = timeHappen;
    }

    

    public Integer getId() {
        return id;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatchCode() {
        return matchCode;
    }

    public void setMatchCode(String matchCode) {
        this.matchCode = matchCode;
    }

    public RankingDTO getClubHome() {
        return clubHome;
    }

    public void setClubHome(RankingDTO clubHome) {
        this.clubHome = clubHome;
    }

    public RankingDTO getClubAway() {
        return clubAway;
    }

    public void setClubAway(RankingDTO clubAway) {
        this.clubAway = clubAway;
    }

    public String getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(String matchDay) {
        this.matchDay = matchDay;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public Integer getRoundmatch() {
        return roundmatch;
    }

    public void setRoundmatch(Integer roundmatch) {
        this.roundmatch = roundmatch;
    }

    public String getLeg() {
        return leg;
    }

    public void setLeg(String leg) {
        this.leg = leg;
    }

    public Integer getResultClubHome() {
        return resultClubHome;
    }

    public void setResultClubHome(Integer resultClubHome) {
        this.resultClubHome = resultClubHome;
    }

    public Integer getResultClubAway() {
        return resultClubAway;
    }

    public void setResultClubAway(Integer resultClubAway) {
        this.resultClubAway = resultClubAway;
    }

    public Stadiums getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(Stadiums stadiumId) {
        this.stadiumId = stadiumId;
    }

    public Referees getReferees() {
        return referees;
    }

    public void setReferees(Referees referees) {
        this.referees = referees;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getIsHome() {
        return isHome;
    }

    public void setIsHome(Integer isHome) {
        this.isHome = isHome;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
   
    public String getTimeHappen() {
        return timeHappen;
    }

    public void setTimeHappen(String timeHappen) {
        this.timeHappen = timeHappen;
    }
    
   
}
