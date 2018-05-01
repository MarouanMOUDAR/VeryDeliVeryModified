/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Commande;
import bean.CommandeItem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ouss
 */
@Stateless
public class CommandeFacade extends AbstractFacade<Commande> {

    @PersistenceContext(unitName = "VeryDeliVery2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeFacade() {
        super(Commande.class);
    }
    
    public List<CommandeItem> findCom(Commande commande){
        List<CommandeItem> mouk= em.createQuery("SELECT c FROM CommandeItem c WHERE c.commande.id='"+commande.getId()+"'").getResultList();
        return mouk;
    }
    public List<Commande> findNonValider(){
        return em.createQuery("SELECT c FROM Commande c WHERE c.status=0").getResultList();
    }
    public void valider(Commande c){
        c.setStatus(1);
        edit(c);
    }
    
    public List<CommandeItem> findCommandeItem(Commande commande){
        return em.createQuery("SELECT i FROM CommandeItem i WHERE i.commande.id="+commande.getId()).getResultList();
    }
}
