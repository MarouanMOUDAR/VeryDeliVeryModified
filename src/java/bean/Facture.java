/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author HP
 */
@Entity
public class Facture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //num Facture
    private Double montant;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePaiement;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateExpedition;
    @ManyToOne
    private Restaurant restaurant;

    public Facture() {
    }

    public Facture(Long id) {
        this.id = id;
    }
    

    public Facture(Long id, Double montant, Date datePaiement, Date dateExpedition, Restaurant restaurant) {
        this.id = id;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.dateExpedition = dateExpedition;
        this.restaurant = restaurant;
    }

    
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    
    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public Date getDateExpedition() {
        return dateExpedition;
    }

    public void setDateExpedition(Date dateExpedition) {
        this.dateExpedition = dateExpedition;
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
        if (!(object instanceof Facture)) {
            return false;
        }
        Facture other = (Facture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Facture[ id=" + id + " ]";
    }
    
}
