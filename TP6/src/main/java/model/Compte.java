package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

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
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    @ManyToOne
    Client titulaire;
    double solde;

    LocalDate dateOuverture;

    public Compte(double solde) {
        this.solde = solde;
        this.dateOuverture = LocalDate.now();
    }

    public Compte(long id, Client client, double depotInitial, LocalDate dateOuverture) {
        this(depotInitial);
        setDateOuverture(dateOuverture);
        titulaire = client;
        setId(id);
    }
}
