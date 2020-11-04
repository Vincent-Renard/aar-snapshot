package entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Membre {
    @Id
    String login;
    String motdepasse;
    String surnom;


    @OneToMany(mappedBy = "directeur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<Projet> responsable = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "participants")
    Set<Projet> participe = new HashSet<>();


    //@OneToMany(mappedBy = "declareePar", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //Collection<CompetenceMembre> competences = new HashSet<>();

    @ElementCollection
    Map<Competence, Integer> competences = new HashMap<>();


    @CreationTimestamp
    LocalDateTime dateInscription;


    public Membre(String login, String motdepasse, String surnom) {
        this();
        this.login = login;
        this.motdepasse = motdepasse;
        this.surnom = surnom;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membre membre = (Membre) o;
        return getLogin().equals(membre.getLogin());
    }

    public void addCompetence(Competence competence, int niveau) {
        competences.put(competence, niveau);
    }
}
