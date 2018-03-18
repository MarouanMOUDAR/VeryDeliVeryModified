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
import javax.persistence.OneToMany;

/**
 *
 * @author HP
 */
@Entity
public class Ville implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "ville")
    private List<StoreOwner> storeOwners;

    @OneToMany(mappedBy = "ville")
    private List<Quartier> quartiers;

    @OneToMany(mappedBy = "ville")
    private List<Livreur> livreurs;

    @OneToMany(mappedBy = "ville")
    private List<Client> clients;

    public Ville() {
    }

    public Ville(Long id) {
        this.id = id;
    }

    public Ville(Long id, String nom, List<StoreOwner> storeOwners, List<Quartier> quartiers, List<Livreur> livreurs, List<Client> clients) {
        this.id = id;
        this.nom = nom;
        this.storeOwners = storeOwners;
        this.quartiers = quartiers;
        this.livreurs = livreurs;
        this.clients = clients;
    }

    public List<StoreOwner> getStoreOwners() {
        return storeOwners;
    }

    public void setStoreOwners(List<StoreOwner> storeOwners) {
        this.storeOwners = storeOwners;
    }

    public List<Quartier> getQuartiers() {
        return quartiers;
    }

    public void setQuartiers(List<Quartier> quartiers) {
        this.quartiers = quartiers;
    }

    public List<Livreur> getLivreurs() {
        return livreurs;
    }

    public void setLivreurs(List<Livreur> livreurs) {
        this.livreurs = livreurs;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }



    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        if (!(object instanceof Ville)) {
            return false;
        }
        Ville other = (Ville) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom;
    }
    
}
