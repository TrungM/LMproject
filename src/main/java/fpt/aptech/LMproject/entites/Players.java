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
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Players.findByCodePlayer", query = "SELECT p FROM Players p WHERE p.codePlayer = :codePlayer"),
    @NamedQuery(name = "Players.findByImage", query = "SELECT p FROM Players p WHERE p.image = :image"),
    @NamedQuery(name = "Players.findByNumber", query = "SELECT p FROM Players p WHERE p.number = :number"),
    @NamedQuery(name = "Players.findByDateOfBirth", query = "SELECT p FROM Players p WHERE p.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Players.findByStatistics", query = "SELECT p FROM Players p WHERE p.statistics = :statistics")})
public class Players implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "height")
    private int height;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "code_player")
    private String codePlayer;
    @Size(max = 225)
    @Column(name = "image")
    private String image;
    @Column(name = "number")
    private Integer number;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "date of birth")
    private String dateOfBirth;
    @Column(name = "statistics")
    private Integer statistics;
    @JoinColumn(name = "clubid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clubs clubid;
    @JoinColumn(name = "nationality", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Flags nationality;
    @JoinColumn(name = "positionid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Positions positionid;

    public Players() {
    }

    public Players(Integer id) {
        this.id = id;
    }

    public Players(Integer id, String name, int height, String codePlayer, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.codePlayer = codePlayer;
        this.dateOfBirth = dateOfBirth;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getCodePlayer() {
        return codePlayer;
    }

    public void setCodePlayer(String codePlayer) {
        this.codePlayer = codePlayer;
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

    public Integer getStatistics() {
        return statistics;
    }

    public void setStatistics(Integer statistics) {
        this.statistics = statistics;
    }

    public Clubs getClubid() {
        return clubid;
    }

    public void setClubid(Clubs clubid) {
        this.clubid = clubid;
    }

    public Flags getNationality() {
        return nationality;
    }

    public void setNationality(Flags nationality) {
        this.nationality = nationality;
    }

    public Positions getPositionid() {
        return positionid;
    }

    public void setPositionid(Positions positionid) {
        this.positionid = positionid;
    }

    
}
