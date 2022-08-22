package com.primobox.eventdrivenarchitecture.inscriptions.usecases;

import com.primobox.eventdrivenarchitecture.commun.ResultatDeCommande;
import com.primobox.eventdrivenarchitecture.commun.domaine.Evenement;
import com.primobox.eventdrivenarchitecture.commun.usecases.Commande;
import com.primobox.eventdrivenarchitecture.commun.usecases.UseCase;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.Celibataire;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.Celibataires;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.evenements.InscriptionRealisee;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.irregularites.CelibataireDejaInscrit;

import static com.primobox.eventdrivenarchitecture.inscriptions.usecases.Inscription.SInscrire;

public class Inscription implements UseCase<SInscrire, ResultatDeCommande<Evenement, CelibataireDejaInscrit>> {

    private Celibataires celibataires;

    public Inscription(Celibataires celibataires) {
        this.celibataires = celibataires;
    }

    @Override
    public ResultatDeCommande<Evenement, CelibataireDejaInscrit> executer(SInscrire commande) {
        try {
            celibataires.ajouter(new Celibataire(commande.login()));
            return ResultatDeCommande.succes(new InscriptionRealisee(commande.login()));
        } catch (CelibataireDejaInscrit exception) {
            return ResultatDeCommande.echec(exception);
        }
    }

    public record SInscrire(String login) implements Commande {
    }
}
