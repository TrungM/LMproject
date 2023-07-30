/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Stadiums")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stadiums.findAll", query = "SELECT s FROM Stadiums s  ORDER BY s.name DESC"),
    @NamedQuery(name = "Stadiums.findById", query = "SELECT s FROM Stadiums s WHERE s.id = :id"),
    @NamedQuery(name = "Stadiums.findByName", query = "SELECT s FROM Stadiums s WHERE s.name = :name"),
    @NamedQuery(name = "Stadiums.findByImage", query = "SELECT s FROM Stadiums s WHERE s.image = :image")})
public class Stadiums implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "name")
    private String name;
    @Size(max = 225)
    @Column(name = "image")
    private String image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stadiumId")
    private List<Schedules> schedulesList;
    @Column(name = "active")
    private Integer active;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "stadiumid")
    private List<Clubs> clubsList;
//    private Collection<Clubs> clubsList = new HashSet<>();

    public Stadiums() {
    }

    public Stadiums(Integer id) {
        this.id = id;
    }

    public Stadiums(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


//    @XmlTransient
//    public List<Clubs> getClubsList() {
//        return clubsList;
//    }
//
//    public void setClubsList(List<Clubs> clubsList) {
//        this.clubsList = clubsList;
//    }
    
     public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }


    @XmlTransient
    public List<Schedules> getSchedulesList() {
        return schedulesList;
    }

    public void setSchedulesList(List<Schedules> schedulesList) {
        this.schedulesList = schedulesList;
    }

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
}
