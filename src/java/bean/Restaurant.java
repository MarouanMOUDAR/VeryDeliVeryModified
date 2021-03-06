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
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String adresseResto;
    private String heureOuverture;
    private String heureFermeture;
    private String lat;
    private String lng;
    @OneToMany(mappedBy = "restaurant")
    private List<Facture> factures;
    @ManyToOne
    private Quartier quartier;
    @ManyToOne
    private StoreOwner storeOwner;
    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantSupplement> restaurantSupplements;

    public Restaurant() {
    }

    public Restaurant(Long id) {
        this.id = id;
    }

    public Restaurant(Long id, String nom, String adresseResto, String heureOuverture, String heureFermeture, String lat, String lng, List<Facture> factures, Quartier quartier, StoreOwner storeOwner, List<RestaurantSupplement> restaurantSupplements) {
        this.id = id;
        this.nom = nom;
        this.adresseResto = adresseResto;
        this.heureOuverture = heureOuverture;
        this.heureFermeture = heureFermeture;
        this.lat = lat;
        this.lng = lng;
        this.factures = factures;
        this.quartier = quartier;
        this.storeOwner = storeOwner;
        this.restaurantSupplements = restaurantSupplements;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public Quartier getQuartier() {
        return quartier;
    }

    public void setQuartier(Quartier quartier) {
        this.quartier = quartier;
    }

    public StoreOwner getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(StoreOwner storeOwner) {
        this.storeOwner = storeOwner;
    }

    public List<RestaurantSupplement> getRestaurantSupplements() {
        return restaurantSupplements;
    }

    public void setRestaurantSupplements(List<RestaurantSupplement> restaurantSupplements) {
        this.restaurantSupplements = restaurantSupplements;
    }
    

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresseResto() {
        return adresseResto;
    }

    public void setAdresseResto(String adresseResto) {
        this.adresseResto = adresseResto;
    }

    public String getHeureOuverture() {
        return heureOuverture;
    }

    public void setHeureOuverture(String heureOuverture) {
        this.heureOuverture = heureOuverture;
    }

    public String getHeureFermeture() {
        return heureFermeture;
    }

    public void setHeureFermeture(String heureFermeture) {
        this.heureFermeture = heureFermeture;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
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
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Restaurant[ id=" + id + " ]";
    }
    
}
