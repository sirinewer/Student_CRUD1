package com.demo.td.Entity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name ="Student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String prenom;
    private String cin;
    private Date date_de_naissance;
    private String num_carte_etudiant;
    private String classe;
    public Student() {

    }

    public Student (String nom, String prenom, String cin, String num_carte_etudiant, Date date_de_naissance, String classe) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.num_carte_etudiant = num_carte_etudiant;
        this.date_de_naissance = date_de_naissance;
        this.classe = classe;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNum_carte_etudiant() {
        return num_carte_etudiant;
    }

    public void setNum_carte_etudiant(String num_carte_etudiant) {
        this.num_carte_etudiant = num_carte_etudiant;
    }

    public Date getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(Date date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
}


