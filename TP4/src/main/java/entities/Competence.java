package entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.HashSet;


@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Competence {

    @Id
    String intituleC;
    String descriptionC;
    @ManyToMany(mappedBy = "competencesRequises")
    Collection<Projet> requisePour = new HashSet<>();

    //@OneToMany(mappedBy = "deType")
    //Collection<CompetenceMembre> compMembre = new ArrayList<>();

    public Competence(String intituleC, String descriptionC) {
        this();
        this.intituleC = intituleC;
        this.descriptionC = descriptionC;
    }

}
