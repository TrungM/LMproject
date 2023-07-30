/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Minh Trung
 */
@Entity
@Table(name = "Result")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r"),
    @NamedQuery(name = "Result.findById", query = "SELECT r FROM Result r WHERE r.id = :id"),
    @NamedQuery(name = "Result.findByMatchCode", query = "SELECT r FROM Result r WHERE r.matchCode = :matchCode"),
    @NamedQuery(name = "Result.findByClubHome", query = "SELECT r FROM Result r WHERE r.clubHome = :clubHome"),
    @NamedQuery(name = "Result.findByResultClubHome", query = "SELECT r FROM Result r WHERE r.resultClubHome = :resultClubHome"),
    @NamedQuery(name = "Result.findByClubAway", query = "SELECT r FROM Result r WHERE r.clubAway = :clubAway"),
    @NamedQuery(name = "Result.findByResultClubAway", query = "SELECT r FROM Result r WHERE r.resultClubAway = :resultClubAway"),
    @NamedQuery(name = "Result.findByMatchDay", query = "SELECT r FROM Result r WHERE r.matchDay = :matchDay")})
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "match_code")
    private String matchCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "club_home")
    private int clubHome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "result_club_home")
    private int resultClubHome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "club_away")
    private int clubAway;
    @Basic(optional = false)
    @NotNull
    @Column(name = "result_club_away")
    private int resultClubAway;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "match_day")
    private String matchDay;
    @JoinColumn(name = "stadiumid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Stadiums stadiumid;


    public Result() {
    }

    public Result(Integer id) {
        this.id = id;
    }

    public Result(Integer id, String matchCode, int clubHome, int resultClubHome, int clubAway, int resultClubAway, String matchDay) {
        this.id = id;
        this.matchCode = matchCode;
        this.clubHome = clubHome;
        this.resultClubHome = resultClubHome;
        this.clubAway = clubAway;
        this.resultClubAway = resultClubAway;
        this.matchDay = matchDay;
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

    public int getClubHome() {
        return clubHome;
    }

    public void setClubHome(int clubHome) {
        this.clubHome = clubHome;
    }

    public int getResultClubHome() {
        return resultClubHome;
    }

    public void setResultClubHome(int resultClubHome) {
        this.resultClubHome = resultClubHome;
    }

    public int getClubAway() {
        return clubAway;
    }

    public void setClubAway(int clubAway) {
        this.clubAway = clubAway;
    }

    public int getResultClubAway() {
        return resultClubAway;
    }

    public void setResultClubAway(int resultClubAway) {
        this.resultClubAway = resultClubAway;
    }

    public String getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(String matchDay) {
        this.matchDay = matchDay;
    }

    public Stadiums getStadiumid() {
        return stadiumid;
    }

    public void setStadiumid(Stadiums stadiumid) {
        this.stadiumid = stadiumid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Result)) {
            return false;
        }
        Result other = (Result) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fpt.aptech.LMproject.entites.Result[ id=" + id + " ]";
    }

}
