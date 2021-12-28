/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package fall.lampdevs.rest_meteo.services;

import fall.lampdevs.rest_meteo.entities.Localite;
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
@Startup
public class InitLocalite {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @EJB
    public LocaliteFacade localiteFacades;
    @EJB
    public MeteoFacade meteofacade;
    
    @PostConstruct
    public void init(){
         System.out.println("##############################initialisation de l'application");
        int nbrFiliere=localiteFacades.count();
        
        if(nbrFiliere==0){
            System.out.println("##############################creation des filiere");
            Localite l1,l2;
              Meteo m1,m2;
              
              
             l1 = new Localite(10,"thies",12000.12,16546.5);
             l2 = new Localite(11,"Dakar",17000.12,20546.5);
            localiteFacades.create(l1);
            localiteFacades.create(l2);
             m1 = new Meteo(2,1000.90,12000.12,16546.5,l1);
              m2 = new Meteo(4,1890.01,17000.12,20546.5,l2);
            meteofacade.create(m1);
            
            meteofacade.create(m2);
        }
    }
}
