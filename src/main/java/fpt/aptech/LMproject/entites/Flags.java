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
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "Flags.findByImages", query = "SELECT f FROM Flags f WHERE f.images = :images")})
public class Flags implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 225)
    @Column(name = "images")
    private String images;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nationality")
    private List<Players> playersList;

    public Flags() {
    }

    public Flags(Integer id) {
        this.id = id;
    }

    public Flags(Integer id, String name, String images) {
        this.id = id;
        this.name = name;
        this.images = images;
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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @XmlTransient
    public List<Players> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<Players> playersList) {
        this.playersList = playersList;
    }


}
