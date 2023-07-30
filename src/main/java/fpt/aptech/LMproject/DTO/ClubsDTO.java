/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.DTO;

import fpt.aptech.LMproject.entites.Stadiums;

/**
 *
 * @author Minh Trung
 */
public class ClubsDTO {

    private Integer id;
    private String codeClub;
    private String name;
    private String image;
    private String logo;

  
    private Integer active;
    private String linkclub;
    private Stadiums stadiumid;

    public ClubsDTO() {
    }

    ;

    public ClubsDTO(Integer id, String codeClub, String name, String image, Integer active, String linkclub, String logo, Stadiums stadiumid) {
        this.id = id;
        this.codeClub = codeClub;
        this.name = name;
        this.image = image;
        this.logo = logo;
        this.active = active;
        this.linkclub = linkclub;
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

    public Stadiums getStadiumid() {
        return stadiumid;
    }

    public void setStadiumid(Stadiums stadiumid) {
        this.stadiumid = stadiumid;
    }
    
      public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
