/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Facture;
import bean.Restaurant;
import bean.StoreOwner;
import controler.util.DateUtil;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
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
    @EJB
    private FactureFacade factureFacade;

    public List<Restaurant> findRestoByStoreOwner(StoreOwner storeOwner) {
        System.out.println("ha store owner====>" + storeOwner);
        List<Restaurant> res = em.createQuery("SELECT r FROM Restaurant r WHERE r.storeOwner.id=" + storeOwner.getId()).getResultList();
        System.out.println("ha res====>" + res);
        return res;
    }

    public int save(Restaurant restaurant) {
        restaurant.setId(generate("Restaurant", "id"));
        Facture facture = new Facture();
        facture.setDatePaiement(new Date());
        facture.setMontant(new Double(10000));
        facture.setRestaurant(restaurant);
        create(restaurant);
        factureFacade.create(facture);
        System.out.println("ha la facture===>" + facture);
        System.out.println("ha le resto===>" + restaurant);
        return 1;
    }

    public List<Restaurant> findRestoPaiement() {
        List<Restaurant> r = em.createQuery("SELECT r FROM Restaurant r WHERE r.status=0").getResultList();
        System.out.println("ha la list restaurant===>" + r);
        return r;
    }

    public int valideeRestaurant(Restaurant restaurant) {
        Facture facture = factureFacade.findNonPayer(restaurant).get(0);
        Date d = new Date();
        
        facture.setDateExpedition(DateUtil.addDays(d, 356));
        restaurant.setStatus(1);
        edit(restaurant);
        return 1;
    }
    
}
