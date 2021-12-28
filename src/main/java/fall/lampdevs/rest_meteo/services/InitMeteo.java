/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package fall.lampdevs.rest_meteo.services;

import fall.lampdevs.rest_meteo.entities.Meteo;
import fall.lampdevs.rest_meteo.services.facades.LocaliteFacade;
import fall.lampdevs.rest_meteo.services.facades.MeteoFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author CLASS LAMP
 */
@Singleton
//@Startup
public class InitMeteo {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    public MeteoFacade meteofacade;
    public LocaliteFacade localitefacade;
     @PostConstruct
    public void init(){
         System.out.println("##############################initialisation de l'application");
        int nbrDonne=meteofacade.count();
        
        if(nbrDonne==0){
            
            System.out.println("##############################creation des filiere");
        
            
            
        }
    }
}
