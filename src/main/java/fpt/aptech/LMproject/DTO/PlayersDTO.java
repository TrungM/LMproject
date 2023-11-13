/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.DTO;

import fpt.aptech.LMproject.entites.Clubs;
import fpt.aptech.LMproject.entites.Flags;
import fpt.aptech.LMproject.entites.Positions;

/**
 *
 * @author Minh Trung
 */
public class PlayersDTO {

    private Integer id;
    private String name;
    private String height;
    private String weight;
    private String image;
    private Integer number;
    private String dateOfBirth;
    private Integer status;
    private Clubs clubId;
    private Flags nationality;
    private Positions positionId;

    public PlayersDTO() {

    }

    public PlayersDTO(Integer id, String name, String height, String weight, String image, Integer number, String dateOfBirth, Integer status, Clubs clubId, Flags nationality, Positions positionId) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.image = image;
        this.number = number;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.clubId = clubId;
        this.nationality = nationality;
        this.positionId = positionId;
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
