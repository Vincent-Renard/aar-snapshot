package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @autor Vincent
 * @date 09/09/2020
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
public class CompetenceMembre {

    Membre declareePar;
    Competence deType;
    int niveau;
    String commentaire;


    public CompetenceMembre(Membre declareePar, Competence deType) {
        this.declareePar = declareePar;

        this.deType = deType;
    }

    @Override
    public String toString() {
        return "CompetenceMembre{" +
                "declareePar=" + ((declareePar == null) ? "null" : declareePar.toString()) +
                ", deType=" + ((deType == null) ? "null" : deType.toString()) +
                ", niveau=" + niveau +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
