/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "clubstadium")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "clubstadium.findAll", query = "SELECT c FROM clubstadium c"),
    @NamedQuery(name = "clubstadium.findById", query = "SELECT c FROM clubstadium c WHERE c.id = :id"),
    @NamedQuery(name = "clubstadium.findByCodeClub", query = "SELECT c FROM clubstadium c WHERE c.codeClub = :codeClub"),
    @NamedQuery(name = "clubstadium.findByName", query = "SELECT c FROM clubstadium c WHERE c.name = :name"),
    @NamedQuery(name = "clubstadium.findByImage", query = "SELECT c FROM clubstadium c WHERE c.image = :image"),
    @NamedQuery(name = "clubstadium.findByLogo", query = "SELECT c FROM clubstadium c WHERE c.logo = :logo"),
    @NamedQuery(name = "clubstadium.findByActive", query = "SELECT c FROM clubstadium c WHERE c.active = :active"),
    @NamedQuery(name = "clubstadium.findByLinkclub", query = "SELECT c FROM clubstadium c WHERE c.linkclub = :linkclub"),
    @NamedQuery(name = "clubstadium.findByStadiumname", query = "SELECT c FROM clubstadium c WHERE c.stadiumname = :stadiumname"),
    @NamedQuery(name = "clubstadium.findByStadiumimage", query = "SELECT c FROM clubstadium c WHERE c.stadiumimage = :stadiumimage")})
public class clubstadium implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @Id
    private int id;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "logo")
    private String logo;
    @Column(name = "active")
    private Integer active;
    @Size(max = 255)
    @Column(name = "linkclub")
    private String linkclub;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "stadiumname")
    private String stadiumname;
    @Size(max = 225)
    @Column(name = "stadiumimage")
    private String stadiumimage;

    public clubstadium() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getLinkclub() {
        return linkclub;
    }

    public void setLinkclub(String linkclub) {
        this.linkclub = linkclub;
    }

    public String getStadiumname() {
        return stadiumname;
    }

    public void setStadiumname(String stadiumname) {
        this.stadiumname = stadiumname;
    }

    public String getStadiumimage() {
        return stadiumimage;
    }

    public void setStadiumimage(String stadiumimage) {
        this.stadiumimage = stadiumimage;
    }
    
}
