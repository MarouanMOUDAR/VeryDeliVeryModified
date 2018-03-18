/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.RestaurantSupplement;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class RestaurantSupplementFacade extends AbstractFacade<RestaurantSupplement> {

    @PersistenceContext(unitName = "VeryDeliVery2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RestaurantSupplementFacade() {
        super(RestaurantSupplement.class);
    }
    
}
