package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

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
public class Service {

    Map<String,Membre> membres = new HashMap<>();
    Map<String,Competence> competences = new HashMap<>();
    Map<String,Projet> projets = new HashMap<>();

    public  Membre addMembre(String login,String motdepasse,String surnom){
        if (membres.containsKey(login)){
            return null;
        }else {
            Membre m = new Membre(login, motdepasse, surnom);
            membres.put(login,m);
            return m;
        }

    }
    public Optional<Membre> findMembreByLogin(String login){
        return Optional.ofNullable(membres.get(login));
    }

    public Projet addProjet(String intituleP,String descriptionP){
        if (projets.containsKey(intituleP)){
            return null;
        }else {
            Projet p = new Projet(intituleP, descriptionP);
            projets.put(intituleP,p);
            return p;
        }
    }
    public  Optional<Projet> findProjetByIntituleP(String intituleP) {
        return  Optional.ofNullable(projets.get(intituleP));
    }
    public Competence addCompetence(String intituleC,String descriptionC){
        if (projets.containsKey(intituleC)){
            return null;
        }else {
            Competence c = new Competence(intituleC, descriptionC);
            competences.put(intituleC,c);
            return c;
        }
    }
    public  Optional<Competence> findCompetence(String intituleC) {
        return  Optional.ofNullable(competences.get(intituleC));
    }

}
