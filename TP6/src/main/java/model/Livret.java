package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
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
public class Livret extends Compte {
    double tauxInteret;

    public Livret(double solde, double tauxInteret) {
        super(solde);
        this.tauxInteret = tauxInteret;
    }

    public Livret(long id, Client client, double depot, LocalDate date, double taux) {
        super(id, client, depot, date);
        setTauxInteret(taux);

    }
}

