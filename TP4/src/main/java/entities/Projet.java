package entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Projet {


    @Id
    String intitule;
    String description;

    @ManyToOne
    Membre directeur;

    @ManyToMany
    Set<Membre> participants = new HashSet<>();
    @ManyToMany
    Set<Competence> competencesRequises = new HashSet<>();


    public Projet(String intitule, String description) {
        this();
        this.intitule = intitule;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projet projet = (Projet) o;
        return getIntitule().equals(projet.getIntitule());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIntitule());
    }
}
