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
@Table(name = "Referees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referees.findAll", query = "SELECT r FROM Referees r"),
    @NamedQuery(name = "Referees.findById", query = "SELECT r FROM Referees r WHERE r.id = :id"),
    @NamedQuery(name = "Referees.findByName", query = "SELECT r FROM Referees r WHERE r.name = :name"),
    @NamedQuery(name = "Referees.findByNationality", query = "SELECT r FROM Referees r WHERE r.nationality = :nationality")})
public class Referees implements Serializable {

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
    @JoinColumn(name = "nationality", referencedColumnName = "id")
    @ManyToOne
    private Flags nationality;

    public Referees() {
    }

    public Referees(Integer id) {
        this.id = id;
    }

    public Referees(Integer id, String name, Flags nationality) {
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
