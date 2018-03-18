/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author HP
 */
@Entity
public class RestaurantSupplement implements Serializable {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double prix;
    @ManyToOne
    private Restaurant restaurant;
    @ManyToOne
    private Supplement supplement;

    
    @OneToMany(mappedBy = "restaurantSupplement")
    private List<CommandeItem> commandeItems;

    public RestaurantSupplement() {
    }

    public RestaurantSupplement(Long id) {
        this.id = id;
    }

    public RestaurantSupplement(Long id, Double prix, Restaurant restaurant, Supplement supplement, List<CommandeItem> commandeItems) {
        this.id = id;
        this.prix = prix;
        this.restaurant = restaurant;
        this.supplement = supplement;
        this.commandeItems = commandeItems;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Supplement getSupplement() {
        return supplement;
    }

    public void setSupplement(Supplement supplement) {
        this.supplement = supplement;
    }

    public List<CommandeItem> getCommandeItems() {
        return commandeItems;
    }

    public void setCommandeItems(List<CommandeItem> commandeItems) {
        this.commandeItems = commandeItems;
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
        if (!(object instanceof RestaurantSupplement)) {
            return false;
        }
        RestaurantSupplement other = (RestaurantSupplement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.RestaurantSupplement[ id=" + id + " ]";
    }
    
}
