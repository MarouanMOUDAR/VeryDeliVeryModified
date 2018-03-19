/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Reclamation;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HP
 */
@Stateless
public class ReclamationFacade extends AbstractFacade<Reclamation> {

    @PersistenceContext(unitName = "VeryDeliVery2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReclamationFacade() {
        super(Reclamation.class);
    }
     public List<Reclamation> findReclamationNonTraiter(){
        List<Reclamation> req = em.createQuery("SELECT r FROM Reclamation r WHERE r.dateTraitement IS NULL").getResultList();
        System.out.println("ha la list ===>"+req);
        return req;
    }
    
}
