/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fall.lampdevs.rest_meteo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CLASS LAMP
 */
@Entity
@XmlRootElement
public class Localite implements Serializable {

    @Id
     private int id;
    @Column(length = 45,nullable = false)
    private String nom;
    private Double latittude;
    private Double longitude;   
   @OneToMany(mappedBy = "localite")
   private List<Meteo>  meteo;
  

    public Localite() {
    }

    public Localite(int id, String nom, Double latittude, Double longitude) {
        this.id = id;
        this.nom = nom;
        this.latittude = latittude;
        this.longitude = longitude;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getLatittude() {
        return latittude;
    }

    public void setLatittude(Double latittude) {
        this.latittude = latittude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

  

  

   
    
}
