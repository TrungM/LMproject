/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Minh Trung
 */
@Entity
@Table(name = "Schedules")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedules.findAll", query = "SELECT s FROM Schedules s"),
    @NamedQuery(name = "Schedules.findById", query = "SELECT s FROM Schedules s WHERE s.id = :id"),
    @NamedQuery(name = "Schedules.findByMatchCode", query = "SELECT s FROM Schedules s WHERE s.matchCode = :matchCode"),
    @NamedQuery(name = "Schedules.findByMatchDay", query = "SELECT s FROM Schedules s WHERE s.matchDay = :matchDay"),
    @NamedQuery(name = "Schedules.findByMatchTime", query = "SELECT s FROM Schedules s WHERE s.matchTime = :matchTime"),
    @NamedQuery(name = "Schedules.findByReferees", query = "SELECT s FROM Schedules s WHERE s.referees = :referees")})
public class Schedules implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 225)
    @Column(name = "match_code")
    private String matchCode;
    @Size(max = 50)
    @Column(name = "match_day")
    private String matchDay;
    @Size(max = 30)
    @Column(name = "match_time")
    private String matchTime;
    @Column(name = "referees")
    private Integer referees;
    @Column(name = "roundmatch")
    private Integer roundmatch;
    @Size(max = 20)
    @Column(name = "leg")
    private String leg;

    @Column(name = "result_club_home")
    private Integer resultClubHome;

    @Column(name = "result_club_away")
    private Integer resultClubAway;

    @Column(name = "active")
    private Integer active;

    @JoinColumn(name = "club_home", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)

    private Ranking clubHome;

    @JoinColumn(name = "club_away", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ranking clubAway;

    @JoinColumn(name = "season", referencedColumnName = "id")
    @ManyToOne
    private Season season;
    @JoinColumn(name = "stadium_id", referencedColumnName = "id")
    @ManyToOne
    private Stadiums stadiumId;

    public Schedules() {
    }

    public Schedules(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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

    public Integer getReferees() {
        return referees;
    }

    public void setReferees(Integer referees) {
        this.referees = referees;
    }

    public Ranking getClubHome() {
        return clubHome;
    }

    public void setClubHome(Ranking clubHome) {
        this.clubHome = clubHome;
    }

    public Ranking getClubAway() {
        return clubAway;
    }

    public void setClubAway(Ranking clubAway) {
        this.clubAway = clubAway;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Stadiums getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(Stadiums stadiumId) {
        this.stadiumId = stadiumId;
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

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
    
    
}
