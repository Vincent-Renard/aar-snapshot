package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Collection;
@FieldDefaults(level = AccessLevel.PRIVATE)@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
@Getter@ToString
public class Membre {
     String login;

     @ToString.Exclude
     String motdepasse;
     String surnom;
     Collection<Projet> responsable=new ArrayList<>();
     Collection<Projet> participe=new ArrayList<>();

    Collection<CompetenceMembre> declare;

    public Membre(String login, String motdepasse, String surnom) {
        this();
        this.login = login;
        this.motdepasse = motdepasse;
        this.surnom = surnom;
    }

}
