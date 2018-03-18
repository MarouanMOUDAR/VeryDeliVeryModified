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
public class Specialite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    @OneToMany(mappedBy = "specialite")
    private List<RepasRestaurant> repasRestaurants;

    public Specialite() {
    }

    public Specialite(Long id) {
        this.id = id;
    }

    public Specialite(Long id, String nom, List<RepasRestaurant> repasRestaurants) {
        this.id = id;
        this.nom = nom;
        this.repasRestaurants = repasRestaurants;
    }

    public List<RepasRestaurant> getRepasRestaurants() {
        return repasRestaurants;
    }

    public void setRepasRestaurants(List<RepasRestaurant> repasRestaurants) {
        this.repasRestaurants = repasRestaurants;
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
        if (!(object instanceof Specialite)) {
            return false;
        }
        Specialite other = (Specialite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.NationaliteRepas[ id=" + id + " ]";
    }
    
}
