/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.DTO;

/**
 *
 * @author Minh Trung
 */
public class SeasonDTO {

    private Integer id;
    private String seasonname;
    private String champion;
    
    public SeasonDTO () {};

    public SeasonDTO(Integer id, String seasonname, String champion) {
        this.id = id;
        this.seasonname = seasonname;
        this.champion = champion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
