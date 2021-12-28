/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fall.lampdevs.rest_meteo.services.facades;

import fall.lampdevs.rest_meteo.entities.Localite;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author CLASS LAMP
 */
@Stateless
public class LocaliteFacade extends AbstractFacade<Localite> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocaliteFacade() {
        super(Localite.class);
    }
    
}
