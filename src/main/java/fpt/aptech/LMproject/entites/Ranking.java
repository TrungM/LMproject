/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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

/**
 *
 * @author Minh Trung
 */
@Entity
@Table(name = "Ranking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ranking.findAll", query = "SELECT r FROM Ranking r"),
    @NamedQuery(name = "Ranking.findById", query = "SELECT r FROM Ranking r WHERE r.id = :id"),
    @NamedQuery(name = "Ranking.findByPosition", query = "SELECT r FROM Ranking r WHERE r.position = :position"),
    @NamedQuery(name = "Ranking.findByPlayed", query = "SELECT r FROM Ranking r WHERE r.played = :played"),
    @NamedQuery(name = "Ranking.findByWon", query = "SELECT r FROM Ranking r WHERE r.won = :won"),
    @NamedQuery(name = "Ranking.findByDraw", query = "SELECT r FROM Ranking r WHERE r.draw = :draw"),
    @NamedQuery(name = "Ranking.findByLose", query = "SELECT r FROM Ranking r WHERE r.lose = :lose"),
    @NamedQuery(name = "Ranking.findByGf", query = "SELECT r FROM Ranking r WHERE r.gf = :gf"),
    @NamedQuery(name = "Ranking.findByGa", query = "SELECT r FROM Ranking r WHERE r.ga = :ga"),
    @NamedQuery(name = "Ranking.findByGd", query = "SELECT r FROM Ranking r WHERE r.gd = :gd"),
    @NamedQuery(name = "Ranking.findByPoints", query = "SELECT r FROM Ranking r WHERE r.points = :points"),
    @NamedQuery(name = "Ranking.findByNextmatch", query = "SELECT r FROM Ranking r WHERE r.nextmatch = :nextmatch"),
    @NamedQuery(name = "Ranking.findBySeason", query = "SELECT r FROM Ranking r WHERE r.season = :season")})
public class Ranking implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "position")
    private int position;
    @Size(max = 50)
    @Column(name = "nextmatch")
    private String nextmatch;
    @OneToMany(mappedBy = "clubHome")
    private List<Schedules> schedulesList;
    @OneToMany(mappedBy = "clubAway")
    private List<Schedules> schedulesList1;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "played")
    private Integer played;
    @Column(name = "won")
    private Integer won;
    @Column(name = "draw")
    private Integer draw;
    @Column(name = "lose")
    private Integer lose;
    @Column(name = "GF")
    private Integer gf;
    @Column(name = "GA")
    private Integer ga;
    @Column(name = "GD")
    private Integer gd;
    @Column(name = "points")
    private Integer points;
    @Column(name = "season")
    private Integer season;
    @Column(name = "clubid")
    private Integer clubid;
    @Column(name = "active")
    private Integer active;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "clubname", referencedColumnName = "id")
    private Clubs clubName;

    public Ranking() {
    }

    public Ranking(Integer id) {
        this.id = id;
    }

    public Ranking(Integer id, int position) {
        this.id = id;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlayed() {
        return played;
    }

    public void setPlayed(Integer played) {
        this.played = played;
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

    public Integer getGf() {
        return gf;
    }

    public void setGf(Integer gf) {
        this.gf = gf;
    }

    public Integer getGa() {
        return ga;
    }

    public void setGa(Integer ga) {
        this.ga = ga;
    }

    public Integer getGd() {
        return gd;
    }

    public void setGd(Integer gd) {
        this.gd = gd;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Clubs getClubName() {
        return clubName;
    }

    public void setClubName(Clubs clubName) {
        this.clubName = clubName;
    }

    public Integer getClubid() {
        return clubid;
    }

    public void setClubid(Integer clubid) {
        this.clubid = clubid;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getNextmatch() {
        return nextmatch;
    }

    public void setNextmatch(String nextmatch) {
        this.nextmatch = nextmatch;
    }

}
