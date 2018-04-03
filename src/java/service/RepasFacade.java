/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Repas;
//import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ouss
 */
@Stateless
public class RepasFacade extends AbstractFacade<Repas> {

    @PersistenceContext(unitName = "VeryDeliVery2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RepasFacade() {
        super(Repas.class);
    }
//    public List<Repas> findRepasRestau(Long id) {
//        List<Repas> rep = em.createQuery("SELECT r FROM RepasRestaurant r WHERE r.restaurant.id=id").getResultList();
//        System.out.println("ha la list ===>"+rep);
//        return rep;
//    }
    
}
