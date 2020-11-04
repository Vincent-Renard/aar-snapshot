package model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @autor Vincent
 * @date 09/09/2020
 */

@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Service
public class Facade {

    Map<String, Membre> membres = new HashMap<>();
    Map<String, Competence> competences = new HashMap<>();
    Map<String, Projet> projets = new HashMap<>();

    @PostConstruct
    public void populate() {
        Membre riri = this.addMembre("Richard", "rduck", "Riri");
        Membre fifi = this.addMembre("Firmin", "fduck", "Fifi");
        Membre loulou = this.addMembre("Louis", "lduck", "Loulou");
        Membre donald = this.addMembre("Donald", "dduck", "Onc");

        Competence java = this.addCompetence("Java", "La base quoi");
        Competence php = this.addCompetence("PHP", "La souffrance quoi");
        Competence c = this.addCompetence("C", "C'est plus plus ce que c'était");
        Competence scrum = this.addCompetence("Scrum", "L'orga de base");
        Competence python = this.addCompetence("Scrum", "L'orga de base");

        Projet p1 = this.addProjet("Projet 1", "Le premier projet (Py)");
        this.addProjet("Projet 2", "Le deuxieme projet");
        this.addProjet("Projet 3", "Le troisieme projet");

        p1.setDirecteur(donald);
        p1.getNecessite().add(python);
        p1.getNecessite().add(scrum);
        p1.getContributionDe().add(riri);
        //System.err.println(this.findProjetByIntitule("Projet 1").get().toString());


    }


    public Membre addMembre(String login, String motdepasse, String surnom) {
        if (membres.containsKey(login)) {
            return null;
        } else {
            Membre m = new Membre(login, motdepasse, surnom);
            membres.put(login, m);
            return m;
        }

    }

    public Optional<Membre> findMembreByLogin(String login) {
        return Optional.ofNullable(membres.get(login));
    }

    public Projet addProjet(String intituleP, String descriptionP) {
        if (projets.containsKey(intituleP)) {
            return null;
        } else {
            Projet p = new Projet(intituleP, descriptionP);
            projets.put(intituleP, p);
            return p;
        }
    }

    public Optional<Projet> findProjetByIntitule(String intituleP) {
        return Optional.ofNullable(projets.get(intituleP));
    }

    public Competence addCompetence(String intituleC, String descriptionC) {
        if (projets.containsKey(intituleC)) {
            return null;
        } else {
            Competence c = new Competence(intituleC, descriptionC);
            competences.put(intituleC, c);
            return c;
        }
    }

    public Optional<Competence> findCompetence(String intituleC) {
        return Optional.ofNullable(competences.get(intituleC));
    }

}
