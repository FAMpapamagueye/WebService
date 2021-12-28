/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fall.lampdevs.rest_meteo.services.facades;

import fall.lampdevs.rest_meteo.entities.Meteo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CLASS LAMP
 */
@Stateless
public class MeteoFacade extends AbstractFacade<Meteo> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MeteoFacade() {
        super(Meteo.class);
    }
    
}
