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
public class Livreur implements Serializable {

    @OneToMany(mappedBy = "livreur")
    private List<Recrutement> recrutements;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String adresseMail;
    private String telephone;
    private String cv;
    @ManyToOne
    private Ville ville;

    public Livreur() {
    }

    public Livreur(List<Recrutement> recrutements) {
        this.recrutements = recrutements;
    }

    
    public Livreur(List<Recrutement> recrutements, Long id, String nom, String prenom, String adresseMail, String telephone, String cv, Ville ville) {
        this.recrutements = recrutements;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.telephone = telephone;
        this.cv = cv;
        this.ville = ville;
    }
    

    
    public List<Recrutement> getRecrutements() {
        return recrutements;
    }

    public void setRecrutements(List<Recrutement> recrutements) {
        this.recrutements = recrutements;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
    
    

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
        if (!(object instanceof Livreur)) {
            return false;
        }
        Livreur other = (Livreur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Livreur[ id=" + id + " ]";
    }
    
}
