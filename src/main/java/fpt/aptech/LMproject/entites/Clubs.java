/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Minh Trung
 */
@Entity
@Table(name = "Clubs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clubs.findAll", query = "SELECT c FROM Clubs c"),
    @NamedQuery(name = "Clubs.findById", query = "SELECT c FROM Clubs c WHERE c.id = :id"),
    @NamedQuery(name = "Clubs.findByCodeClub", query = "SELECT c FROM Clubs c WHERE c.codeClub = :codeClub"),
    @NamedQuery(name = "Clubs.findByName", query = "SELECT c FROM Clubs c WHERE c.name = :name"),
    @NamedQuery(name = "Clubs.findByImage", query = "SELECT c FROM Clubs c WHERE c.image = :image"),
    @NamedQuery(name = "Clubs.findByLogo", query = "SELECT c FROM Clubs c WHERE c.logo = :logo"),
    @NamedQuery(name = "Clubs.findByActive", query = "SELECT c FROM Clubs c WHERE c.active = :active"),
    @NamedQuery(name = "Clubs.findByLinkclub", query = "SELECT c FROM Clubs c WHERE c.linkclub = :linkclub")})
public class Clubs implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "code_club")
    private String codeClub;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 225)
    @Column(name = "image")
    private String image;
    @Size(max = 225)
    @Column(name = "logo")
    private String logo;
    @Size(max = 255)
    @Column(name = "linkclub")
    private String linkclub;
  
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clubName")
    private List<Ranking> rankingList;
//    private Collection<Ranking> rankingList = new HashSet<>();

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clubid")
//    private List<Players> playersList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "active")
    private Integer active;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "stadiumid", referencedColumnName = "id")
    private Stadiums stadiumid;

    public Clubs() {
    }

    public Clubs(Integer id) {
        this.id = id;
    }

    public Clubs(Integer id, String codeClub, String name, String logo) {
        this.id = id;
        this.codeClub = codeClub;
        this.name = name;
        this.logo = logo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeClub() {
        return codeClub;
    }

    public void setCodeClub(String codeClub) {
        this.codeClub = codeClub;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Stadiums getStadiumid() {
        return stadiumid;
    }

    public void setStadiumid(Stadiums stadiumid) {
        this.stadiumid = stadiumid;
    }

//    @XmlTransient
//    public List<Players> getPlayersList() {
//        return playersList;
//    }
//
//    public void setPlayersList(List<Players> playersList) {
//        this.playersList = playersList;
//    }
//
//    @XmlTransient
//    public List<Schedules> getSchedulesList() {
//        return schedulesList;
//    }
//
//    public void setSchedulesList(List<Schedules> schedulesList) {
//        this.schedulesList = schedulesList;
//    }
//
//    @XmlTransient
//    public List<Schedules> getSchedulesList1() {
//        return schedulesList1;
//    }
//
//    public void setSchedulesList1(List<Schedules> schedulesList1) {
//        this.schedulesList1 = schedulesList1;
//    }
////
//    public String getCodeClub() {
//        return codeClub;
//    }
//
//    public void setCodeClub(String codeClub) {
//        this.codeClub = codeClub;
//    }

//    public String getCodeClub() {
//        return codeClub;
//    }
//
//    public void setCodeClub(String codeClub) {
//        this.codeClub = codeClub;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLinkclub() {
        return linkclub;
    }

    public void setLinkclub(String linkclub) {
        this.linkclub = linkclub;
    }

}
