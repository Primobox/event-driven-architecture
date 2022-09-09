package com.primobox.eventdrivenarchitecture.rencontres.usecases;

import com.primobox.eventdrivenarchitecture.commun.ResultatDeCommande;
import com.primobox.eventdrivenarchitecture.commun.domaine.Evenement;
import com.primobox.eventdrivenarchitecture.commun.usecases.Commande;
import com.primobox.eventdrivenarchitecture.commun.usecases.UseCase;
import com.primobox.eventdrivenarchitecture.rencontres.domaine.Rencontres;
import com.primobox.eventdrivenarchitecture.rencontres.domaine.evenements.UneRencontreAEteOrganisee;
import com.primobox.eventdrivenarchitecture.rencontres.domaine.irregularites.ImpossibleDOrganiserUneRencontreQuiExisteDeja;

import static com.primobox.eventdrivenarchitecture.rencontres.usecases.Entremettage.EntremettreDeuxCelibataires;

public class Entremettage implements UseCase<EntremettreDeuxCelibataires, ResultatDeCommande<Evenement, ImpossibleDOrganiserUneRencontreQuiExisteDeja>> {

    private final Rencontres rencontres;

    public Entremettage(Rencontres rencontres) {
        this.rencontres = rencontres;
    }

    @Override
    public ResultatDeCommande<Evenement, ImpossibleDOrganiserUneRencontreQuiExisteDeja> executer(EntremettreDeuxCelibataires commande) {
        if (rencontres.entre(commande.celibataire1(), commande.celibataire2()).isEmpty()) {
            var rencontre = Rencontres.organiser(commande.celibataire1(), commande.celibataire2());
            rencontres.ajouter(rencontre);
            return ResultatDeCommande.succes(new UneRencontreAEteOrganisee(commande.celibataire1(), commande.celibataire2()));
        }
        return ResultatDeCommande.echec(new ImpossibleDOrganiserUneRencontreQuiExisteDeja());
    }

    public record EntremettreDeuxCelibataires(String celibataire1, String celibataire2) implements Commande {
    }
}
