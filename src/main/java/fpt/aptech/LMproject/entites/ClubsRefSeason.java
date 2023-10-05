/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Minh Trung
 */
@Entity
@Table(name = "clubs_ref_season")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClubsRefSeason.findAll", query = "SELECT c FROM ClubsRefSeason c"),
    @NamedQuery(name = "ClubsRefSeason.findById", query = "SELECT c FROM ClubsRefSeason c WHERE c.id = :id"),
    @NamedQuery(name = "ClubsRefSeason.findByActive", query = "SELECT c FROM ClubsRefSeason c WHERE c.active = :active")})
public class ClubsRefSeason implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "active")
    private Integer active;
    @JoinColumn(name = "clubID", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Clubs clubID;

    @JoinColumn(name = "season", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Season season;

    public ClubsRefSeason() {
    }

    public ClubsRefSeason(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Clubs getClubID() {
        return clubID;
    }

    public void setClubID(Clubs clubID) {
        this.clubID = clubID;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

}
