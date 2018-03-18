/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author HP
 */
@Entity
public class CommandeItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double prix;
    private int qte;
    @ManyToOne
    private Commande commande;
    @ManyToOne
    private RestaurantSupplement restaurantSupplement;
    @ManyToOne
    private RepasRestaurant repasRestaurant;

    public CommandeItem() {
    }

    public CommandeItem(Long id) {
        this.id = id;
    }
    

    public CommandeItem(Long id, Double prix, int qte, Commande commande, RestaurantSupplement restaurantSupplement, RepasRestaurant repasRestaurant) {
        this.id = id;
        this.prix = prix;
        this.qte = qte;
        this.commande = commande;
        this.restaurantSupplement = restaurantSupplement;
        this.repasRestaurant = repasRestaurant;
    }

    
    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public RestaurantSupplement getRestaurantSupplement() {
        return restaurantSupplement;
    }

    public void setRestaurantSupplement(RestaurantSupplement restaurantSupplement) {
        this.restaurantSupplement = restaurantSupplement;
    }

    public RepasRestaurant getRepasRestaurant() {
        return repasRestaurant;
    }

    public void setRepasRestaurant(RepasRestaurant repasRestaurant) {
        this.repasRestaurant = repasRestaurant;
    }

    
    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommandeItem)) {
            return false;
        }
        CommandeItem other = (CommandeItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.CommandeItem[ id=" + id + " ]";
    }
    
}