/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.DTO;

/**
 *
 * @author Minh Trung
 */
public class StadiumsDTO {

    private Integer id;
    private String name;
    private String image;
    private Integer active;
    private String capacity;
    private String address;
    private String pitchSize;
    private String description;

    public StadiumsDTO() {
    }

    public StadiumsDTO(Integer id, String name, String image, Integer active, String capacity, String address, String pitchSize, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.active = active;
        this.capacity = capacity;
        this.address = address;
        this.pitchSize = pitchSize;
        this.description = description;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPitchSize() {
        return pitchSize;
    }

    public void setPitchSize(String pitchSize) {
        this.pitchSize = pitchSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

}
