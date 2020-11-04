package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Collection;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Competence {

    String intituleC;
    String descriptionC;

    Collection<Projet> requisePour = new ArrayList<>();
    Collection<CompetenceMembre> competencesMembre = new ArrayList<>();


    public Competence(String intituleC, String descriptionC) {
        this();
        this.intituleC = intituleC;
        this.descriptionC = descriptionC;
    }

}
