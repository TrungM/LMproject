/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.DTO;

import fpt.aptech.LMproject.entites.Clubs;

/**
 *
 * @author Minh Trung
 */
public class RankingDTO {

    private Integer id;
    private Integer position;
    private Clubs clubName;
    private Integer player;
    private Integer won;
    private Integer draw;
    private Integer lose;
    private Integer GA;
    private Integer GF;
    private Integer GD;
    private Integer points;
    private Integer nextmatch;
    private Integer season;
    private Integer clubid;

      public RankingDTO() {
    }

    ;

    public RankingDTO(Integer id, Integer position, Clubs clubName, Integer player, Integer won, Integer draw, Integer lose, Integer GA, Integer GF, Integer GD, Integer points, Integer nextmatch, Integer season, Integer clubid) {
        this.id = id;
        this.position = position;
        this.clubName = clubName;
        this.player = player;
        this.won = won;
        this.draw = draw;
        this.lose = lose;
        this.GA = GA;
        this.GF = GF;
        this.GD = GD;
        this.points = points;
        this.nextmatch = nextmatch;
        this.season = season;
        this.clubid = clubid;
    }
    
   
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Clubs getClubName() {
        return clubName;
    }

    public void setClubName(Clubs clubName) {
        this.clubName = clubName;
    }

    public Integer getPlayer() {
        return player;
    }

    public void setPlayer(Integer player) {
        this.player = player;
    }

    public Integer getWon() {
        return won;
    }

    public void setWon(Integer won) {
        this.won = won;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    public Integer getGA() {
        return GA;
    }

    public void setGA(Integer GA) {
        this.GA = GA;
    }

    public Integer getGF() {
        return GF;
    }

    public void setGF(Integer GF) {
        this.GF = GF;
    }

    public Integer getGD() {
        return GD;
    }

    public void setGD(Integer GD) {
        this.GD = GD;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getNextmatch() {
        return nextmatch;
    }

    public void setNextmatch(Integer nextmatch) {
        this.nextmatch = nextmatch;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getClubid() {
        return clubid;
    }

    public void setClubid(Integer clubid) {
        this.clubid = clubid;
    }
    
    

}
