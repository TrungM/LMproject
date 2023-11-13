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
@Table(name = "Players")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Players.findAll", query = "SELECT p FROM Players p"),
    @NamedQuery(name = "Players.findById", query = "SELECT p FROM Players p WHERE p.id = :id"),
    @NamedQuery(name = "Players.findByName", query = "SELECT p FROM Players p WHERE p.name = :name"),
    @NamedQuery(name = "Players.findByHeight", query = "SELECT p FROM Players p WHERE p.height = :height"),
    @NamedQuery(name = "Players.findByWeight", query = "SELECT p FROM Players p WHERE p.weight = :weight"),
    @NamedQuery(name = "Players.findByImage", query = "SELECT p FROM Players p WHERE p.image = :image"),
    @NamedQuery(name = "Players.findByNumber", query = "SELECT p FROM Players p WHERE p.number = :number"),
    @NamedQuery(name = "Players.findByDateOfBirth", query = "SELECT p FROM Players p WHERE p.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Players.findByStatus", query = "SELECT p FROM Players p WHERE p.status = :status")})
public class Players implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "height")
    private String height;
    @Size(max = 50)
    @Column(name = "weight")
    private String weight;
    @Size(max = 225)
    @Column(name = "image")
    private String image;
    @Column(name = "number")
    private Integer number;
    @Size(max = 30)
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "status")
    private Integer status;
    @JoinColumn(name = "club_id", referencedColumnName = "id")
    @ManyToOne
    private Clubs clubId;
    @JoinColumn(name = "nationality", referencedColumnName = "id")
    @ManyToOne
    private Flags nationality;
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    @ManyToOne
    private Positions positionId;

    public Players() {
    }

    public Players(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Clubs getClubId() {
        return clubId;
    }

    public void setClubId(Clubs clubId) {
        this.clubId = clubId;
    }

    public Flags getNationality() {
        return nationality;
    }

    public void setNationality(Flags nationality) {
        this.nationality = nationality;
    }

    public Positions getPositionId() {
        return positionId;
    }

    public void setPositionId(Positions positionId) {
        this.positionId = positionId;
    }

    
    

}
