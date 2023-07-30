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

/**
 *
 * @author Minh Trung
 */
@Entity
@Table(name = "Season")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Season.findAll", query = "SELECT s FROM Season s"),
    @NamedQuery(name = "Season.findById", query = "SELECT s FROM Season s WHERE s.id = :id"),
    @NamedQuery(name = "Season.findBySeasonname", query = "SELECT s FROM Season s WHERE s.seasonname = :seasonname"),
    @NamedQuery(name = "Season.findByChampion", query = "SELECT s FROM Season s WHERE s.champion = :champion")})
public class Season implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "seasonname")
    private String seasonname;
    @Size(max = 225)
    @Column(name = "champion")
    private String champion;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "season")
    private List<Schedules> schedulesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "season")
    private List<Ranking> rankingList;

    public Season() {
    }

    public Season(Integer id) {
        this.id = id;
    }

    public Season(Integer id, String seasonname) {
        this.id = id;
        this.seasonname = seasonname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @XmlTransient
//    public List<Ranking> getRankingList() {
//        return rankingList;
//    }
//
//    public void setRankingList(List<Ranking> rankingList) {
//        this.rankingList = rankingList;
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

    public String getSeasonname() {
        return seasonname;
    }

    public void setSeasonname(String seasonname) {
        this.seasonname = seasonname;
    }

    public String getChampion() {
        return champion;
    }

    public void setChampion(String champion) {
        this.champion = champion;
    }

}
