/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fall.lampdevs.rest_meteo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author CLASS LAMP
 */

@Entity
public class Meteo implements Serializable {

  
     @Id
      private int jourDate;
    
    private Double temperature ;
    private Double humidite;
    @Column(name="vitesse")
    private Double vitesseVent;

    @OneToOne
    @JoinColumn(name = "localite_id")
     private Localite localite;
  

    public Meteo() {
    }

  

    public Meteo(int jourDate, Double temperature, Double humidite, Double vitesseVent, Localite localite) {
        this.jourDate = jourDate;
        this.temperature = temperature;
        this.humidite = humidite;
        this.vitesseVent = vitesseVent;
        this.localite = localite;
    }
    
    

    public Localite getLocalite() {
        return localite;
    }

    public void setLocalite(Localite localite) {
        this.localite = localite;
    }

    

   

   

  

    public int getJourDate() {
        return jourDate;
    }

    public void setJourDate(int jourDate) {
        this.jourDate = jourDate;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidite() {
        return humidite;
    }

    public void setHumidite(Double humidite) {
        this.humidite = humidite;
    }

    public Double getVitesseVent() {
        return vitesseVent;
    }

    public void setVitesseVent(Double vitesseVent) {
        this.vitesseVent = vitesseVent;
    }

  
     
}

 

  
