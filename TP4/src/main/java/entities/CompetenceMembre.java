package entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity
@ToString
public class CompetenceMembre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ToString.Exclude

    @ManyToOne
    Membre declareePar;

    @ManyToOne
    Competence deType;
    int niveau;
    String commentaire;

    // Constructeurs

    public CompetenceMembre(Membre declareePar, Competence deType, int niveau, String commentaire) {
        this.declareePar = declareePar;
        this.deType = deType;
        this.niveau = niveau;
        this.commentaire = commentaire;
    }

    // Getters et setters


}
