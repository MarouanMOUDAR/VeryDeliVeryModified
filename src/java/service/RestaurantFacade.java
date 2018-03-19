/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Restaurant;
import bean.StoreOwner;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ouss
 */
@Stateless
public class RestaurantFacade extends AbstractFacade<Restaurant> {

    @PersistenceContext(unitName = "VeryDeliVery2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RestaurantFacade() {
        super(Restaurant.class);
    }
     public List<Restaurant> findRestoByStoreOwner(StoreOwner storeOwner){
        System.out.println("ha store owner====>"+storeOwner);
        List<Restaurant> res =  em.createQuery("SELECT r FROM Restaurant r WHERE r.storeOwner.id="+storeOwner.getId()).getResultList();
        System.out.println("ha res====>"+res);
        return  res;
    }
    
}
