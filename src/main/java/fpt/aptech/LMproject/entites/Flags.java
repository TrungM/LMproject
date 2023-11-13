/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "Flags")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flags.findAll", query = "SELECT f FROM Flags f"),
    @NamedQuery(name = "Flags.findById", query = "SELECT f FROM Flags f WHERE f.id = :id"),
    @NamedQuery(name = "Flags.findByName", query = "SELECT f FROM Flags f WHERE f.name = :name"),
    @NamedQuery(name = "Flags.findByImages", query = "SELECT f FROM Flags f WHERE f.image = :image")})
public class Flags implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(max = 30)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(max = 225)
    @Column(name = "image")
    private String image;
    @OneToMany(mappedBy = "nationality")
    private List<Players> playerList;

    @OneToMany(mappedBy = "nationality")
    private List<Referees> refereeList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Flags() {
    }

    public Flags(Integer id) {
        this.id = id;
    }

    public Flags(Integer id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
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
}
