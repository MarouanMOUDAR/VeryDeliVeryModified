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
public class Favoris implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private RepasRestaurant repasRestaurant;
    @ManyToOne
    private Client client;

    public Favoris() {
    }

    public Favoris(Long id) {
        this.id = id;
    }

    
    public Favoris(Long id, RepasRestaurant repasRestaurant, Client client) {
        this.id = id;
        this.repasRestaurant = repasRestaurant;
        this.client = client;
    }

    
    public RepasRestaurant getRepasRestaurant() {
        return repasRestaurant;
    }

    public void setRepasRestaurant(RepasRestaurant repasRestaurant) {
        this.repasRestaurant = repasRestaurant;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        if (!(object instanceof Favoris)) {
            return false;
        }
        Favoris other = (Favoris) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Favoris[ id=" + id + " ]";
    }
    
}
