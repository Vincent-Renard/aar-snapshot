package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;

/**
 * @autor Vincent
 * @date 14/10/2020
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Livret extends Compte {
    double tauxInteret;

    public Livret(double solde, double tauxInteret) {
        super(solde);
        this.tauxInteret = tauxInteret;
    }
}

