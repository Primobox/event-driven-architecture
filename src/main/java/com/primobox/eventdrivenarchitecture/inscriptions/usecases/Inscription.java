package com.primobox.eventdrivenarchitecture.inscriptions.usecases;

import com.primobox.eventdrivenarchitecture.commun.ResultatDeCommande;
import com.primobox.eventdrivenarchitecture.commun.domaine.Evenement;
import com.primobox.eventdrivenarchitecture.commun.usecases.Commande;
import com.primobox.eventdrivenarchitecture.commun.usecases.UseCase;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.Celibataire;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.Celibataires;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.evenements.InscriptionRealisee;
import org.springframework.stereotype.Component;

@Component
public class Inscription implements UseCase<Inscription.SInscrire, ResultatDeCommande<Evenement, Exception>> {

    private Celibataires celibataires;

    public Inscription(Celibataires celibataires) {
        this.celibataires = celibataires;
    }

    @Override
    public ResultatDeCommande<Evenement, Exception> executer(SInscrire commande) {
        try {
            celibataires.ajouter(new Celibataire(commande.login()));
            return ResultatDeCommande.succes(new InscriptionRealisee(commande.login()));
        } catch (Exception exception) {
            return ResultatDeCommande.echec(exception);
        }
    }

    public record SInscrire(String login) implements Commande {
    }
}
