package model;

import lombok.*;
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
@ToString
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

    public Client(long id, String nom, String prenom, String ville) {
        this(prenom, nom, ville);
        this.id = id;
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

