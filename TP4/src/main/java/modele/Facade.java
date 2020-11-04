package modele;

import entities.Competence;
import entities.Membre;
import entities.Projet;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class Facade {

    @PersistenceContext
    EntityManager em;

    public Facade() {

    }

    @Transactional
    //@PostConstruct
    public void init() {
        if (getMembres().isEmpty()) {
            Membre matthieu = new Membre("Matthieu", "Matthieu", "Matthieu");

            matthieu = addMembre(matthieu);


            Membre fred = new Membre("Fred", "Fred", "Fred");

            fred = addMembre(fred);

            Projet allanParson = new Projet("Allan Parson", "Un projet musical");
            allanParson.setDirecteur(matthieu);
            matthieu.getResponsable().add(allanParson);

            allanParson = addProjet(allanParson);
            Projet xion = new Projet("Xion", "Pour partager une vision");
            xion.setDirecteur(fred);
            fred.getResponsable().add(xion);
            xion = addProjet(xion);

            Competence java = new Competence("Java", "POO");
            addCompetence(java);

            Competence management = new Competence("Management", "Gestion d'équipe, résolution de conflits");
            management = addCompetence(management);

            matthieu.addCompetence(java, 4);


            fred.addCompetence(java, 5);
            allanParson.getCompetencesRequises().addAll(getCompetences());
            xion.getCompetencesRequises().addAll(getCompetences());
            java.getRequisePour().addAll(getProjets());
            management.getRequisePour().addAll(getProjets());

        }
    }

    @Transactional
    public Membre addMembre(Membre m) {
        em.persist(m);
        return m;
    }

    @Transactional
    public Projet addProjet(Projet p) {
        em.persist(p);
        return p;
    }

    @Transactional
    public Competence addCompetence(Competence c) {
        em.persist(c);
        return c;
    }

    @Transactional
    public Collection<Membre> getMembres() {
        List ms = em.createQuery("select m from Membre m  LEFT JOIN FETCH m.responsable resp  LEFT JOIN FETCH m.participe part LEFT JOIN FETCH m.competences comp").getResultList();
        return ms;
    }

    @Transactional
    public Membre declareComp(String login, Competence c, int niveau) {
        Optional<Membre> optMembre = findMembreByLogin(login);
        if (optMembre.isPresent()) {
            Membre m = optMembre.get();
            m.addCompetence(c, niveau);
            return addMembre(m);
        }

        return null;
    }

    @Transactional
    public Collection<Projet> getProjets() {
        List ps = em.createQuery("select p from Projet p LEFT JOIN FETCH p.competencesRequises").getResultList();
        return ps;
    }

    @Transactional
    public Collection<Competence> getCompetences() {
        List cs = em.createQuery("select c from Competence c").getResultList();
        return cs;
    }

    public List<Projet> projetCompetent() {

        List lpc = em.createQuery("select p from Projet p ").getResultList();

        return null;
    }

    @Transactional
    public Optional<Membre> findMembreByLogin(String login) {
        Membre membre = (Membre) em.createQuery("SELECT m from Membre m  LEFT JOIN FETCH m.responsable resp  LEFT JOIN FETCH m.participe part  where m.login=:log ")
                .setParameter("log", login)
                .getSingleResult();
        return Optional.ofNullable(membre);
    }

    @Transactional
    public Membre testLM(String log, String mdp) {

        Optional<Membre> optM = findMembreByLogin(log);
        if (optM.isPresent()) {
            Membre m = optM.get();
            if (m.getMotdepasse().equals(mdp)) {
                return m;
            }
        }
        return null;
    }


}
