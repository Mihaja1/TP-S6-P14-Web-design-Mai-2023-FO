package com.project.iacontentfrontoffice.model;

import com.project.iacontentfrontoffice.utils.Utils;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "contenu")
public class Contenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "contenu")
    private String contenu;

    @Column(name = "dateajout")
    private Timestamp dateAjout;


    @ManyToOne
    @JoinColumn(name = "idadmin")
    private Admin admin;


    @ManyToOne
    @JoinColumn(name = "idcategorie")
    private Categorie categorie;

    @Transient
    private Integer idCategorie;

    @Transient
    private Integer idAdmin;

    public Integer getIdAdmin() {
        return idAdmin;
    }

    @Override
    public String toString() {
        return "Contenu{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", contenu='" + contenu + '\'' +
                ", dateAjout=" + dateAjout +
                ", admin=" + admin +
                ", categorie=" + categorie +
                ", idCategorie=" + idCategorie +
                ", idAdmin=" + idAdmin +
                '}';
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Contenu() {
    }

    public Contenu(Integer id, String titre, String contenu, Timestamp dateAjout, Admin admin, Categorie categorie) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.dateAjout = dateAjout;
        this.admin = admin;
        this.categorie = categorie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Timestamp getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Timestamp dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getUrl(){
        return Utils.createSlug(this.getTitre())+".html";
    }
}
