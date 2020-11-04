package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * @autor Vincent
 * @date 14/10/2020
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String nom;
    String prenom;
    String adresse;

    @OneToMany(mappedBy = "titulaire", cascade = CascadeType.ALL)
    Collection<Compte> comptes = new HashSet<>();

    public Client(String prenom, String nom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public void addCompte(Compte compte) {
        compte.setTitulaire(this);
        this.getComptes().add(compte);
    }

    public void addComptes(Compte... comptes) {
        for (Compte c : comptes) {

            this.addCompte(c);
        }

    }
}

