/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Minh Trung
 */
@Entity
@Table(name = "clubs_ref_season")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clubsforseason.findAll", query = "SELECT c FROM Clubsforseason c"),
    @NamedQuery(name = "Clubsforseason.findById", query = "SELECT c FROM Clubsforseason c WHERE c.id = :id"),
    @NamedQuery(name = "Clubsforseason.findByCodeClub", query = "SELECT c FROM Clubsforseason c WHERE c.codeClub = :codeClub"),
    @NamedQuery(name = "Clubsforseason.findByName", query = "SELECT c FROM Clubsforseason c WHERE c.name = :name"),
    @NamedQuery(name = "Clubsforseason.findByImage", query = "SELECT c FROM Clubsforseason c WHERE c.image = :image"),
    @NamedQuery(name = "Clubsforseason.findByLogo", query = "SELECT c FROM Clubsforseason c WHERE c.logo = :logo"),
    @NamedQuery(name = "Clubsforseason.findByStadiumid", query = "SELECT c FROM Clubsforseason c WHERE c.stadiumid = :stadiumid"),
    @NamedQuery(name = "Clubsforseason.findByActive", query = "SELECT c FROM Clubsforseason c WHERE c.active = :active")})
public class Clubsforseason implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "stadiumid")
    private int stadiumid;
    @Column(name = "active")
    private Integer active;
    @Column(name = "season")
    private Integer season;

    public Clubsforseason() {
    }

    public Clubsforseason(Integer id) {
        this.id = id;
    }

    public Clubsforseason(Integer id, String codeClub, String name, int stadiumid) {
        this.id = id;
        this.codeClub = codeClub;
        this.name = name;
        this.stadiumid = stadiumid;
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

    public int getStadiumid() {
        return stadiumid;
    }

    public void setStadiumid(int stadiumid) {
        this.stadiumid = stadiumid;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    
}
