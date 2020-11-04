package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Collection;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter@Getter@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Projet {
     String intituleP;
     String descriptionP;
     Membre dirigePar;
     Collection<Membre> contributionDe=new ArrayList<>();
     Collection<Competence> necessite=new ArrayList<>();



    public Projet(String intituleP, String descriptionP) {
        this();
        this.intituleP = intituleP;
        this.descriptionP = descriptionP;
    }

    @Override
    public String toString() {
        return "Projet{" +
                "intituleP='" + intituleP + '\'' +
                ", descriptionP='" + descriptionP + '\'' +
                ", dirigePar=" + ((dirigePar==null)?"null":dirigePar.toString()) +
                ", contributionDe=" + contributionDe +
                ", necessite=" + necessite +
                '}';
    }
}
