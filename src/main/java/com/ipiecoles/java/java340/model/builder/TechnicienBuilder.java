package com.ipiecoles.java.java340.model.builder;

import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.model.Entreprise;
import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Technicien;
import org.joda.time.LocalDate;

public final class TechnicienBuilder {
    //@JsonBackReference
    private Manager manager;
    private Integer grade;
    private Long id;
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire = Entreprise.SALAIRE_BASE;

    private TechnicienBuilder() {
    }

    public static TechnicienBuilder aTechnicien() {
        return new TechnicienBuilder();
    }

    public TechnicienBuilder withManager(Manager manager) {
        this.manager = manager;
        return this;
    }

    public TechnicienBuilder withGrade(Integer grade) {
        this.grade = grade;
        return this;
    }

    public TechnicienBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public TechnicienBuilder withNom(String nom) {
        this.nom = nom;
        return this;
    }

    public TechnicienBuilder withPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public TechnicienBuilder withMatricule(String matricule) {
        this.matricule = matricule;
        return this;
    }

    public TechnicienBuilder withDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
        return this;
    }

    public TechnicienBuilder withSalaire(Double salaire) {
        this.salaire = salaire;
        return this;
    }

    public Technicien build() throws EmployeException {
        Technicien technicien = new Technicien();
        technicien.setManager(manager);
        technicien.setGrade(grade);
        technicien.setId(id);
        technicien.setNom(nom);
        technicien.setPrenom(prenom);
        technicien.setMatricule(matricule);
        technicien.setDateEmbauche(dateEmbauche);
        technicien.setSalaire(salaire);
        return technicien;
    }
}
