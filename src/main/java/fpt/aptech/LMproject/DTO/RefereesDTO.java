/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.DTO;

import fpt.aptech.LMproject.entites.Flags;

/**
 *
 * @author Minh Trung
 */
public class RefereesDTO {
    
    private Integer id;
    private String name;
    private Flags nationality;

    public RefereesDTO() {

    }

    public RefereesDTO(Integer id, String name, Flags nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
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

    public Flags getNationality() {
        return nationality;
    }

    public void setNationality(Flags nationality) {
        this.nationality = nationality;
    }

    
}
