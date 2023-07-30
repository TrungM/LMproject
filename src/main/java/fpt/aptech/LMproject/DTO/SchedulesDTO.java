/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.DTO;

import fpt.aptech.LMproject.entites.Result;
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
    private Integer season;
    private Integer roundmatch;
    private String leg;
    private Integer resultClubHome;
    private Integer resultClubAway;
    private Stadiums stadiumId;

    
    public SchedulesDTO() {
    }

    ;

    public SchedulesDTO(Integer id, String matchCode, RankingDTO clubHome, RankingDTO clubAway, String matchDay, String matchTime, Integer season, Integer roundmatch, String leg, Integer resultClubHome, Integer resultClubAway, Stadiums stadiumId) {
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
    }

   
    public Integer getId() {
        return id;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
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

}
