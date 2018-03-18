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
public class RepasRestaurant implements Serializable {
 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double prix;
    private String nom;
    @ManyToOne
    private Repas repas;
    
    @ManyToOne
    private Specialite specialite;
    @OneToMany(mappedBy = "repasRestaurant")
    private List<Favoris> favoriss;

    @OneToMany(mappedBy = "repasRestaurant")
    private List<CommandeItem> commandeItems;

    public RepasRestaurant() {
    }

    public RepasRestaurant(Long id) {
        this.id = id;
    }

    public RepasRestaurant(Long id, double prix, String nom, Repas repas, Specialite specialite, List<Favoris> favoriss, List<CommandeItem> commandeItems) {
        this.id = id;
        this.prix = prix;
        this.nom = nom;
        this.repas = repas;
        this.specialite = specialite;
        this.favoriss = favoriss;
        this.commandeItems = commandeItems;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Repas getRepas() {
        return repas;
    }

    public void setRepas(Repas repas) {
        this.repas = repas;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public List<Favoris> getFavoriss() {
        return favoriss;
    }

    public void setFavoriss(List<Favoris> favoriss) {
        this.favoriss = favoriss;
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
        if (!(object instanceof RepasRestaurant)) {
            return false;
        }
        RepasRestaurant other = (RepasRestaurant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.RepasRestau[ id=" + id + " ]";
    }
    
}
