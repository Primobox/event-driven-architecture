package com.primobox.eventdrivenarchitecture.rencontres.infrastructure.primaire;

import com.primobox.eventdrivenarchitecture.commun.usecases.UseCase;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.Celibataires;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.evenements.InscriptionRealisee;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static com.primobox.eventdrivenarchitecture.rencontres.usecases.Entremettage.EntremettreDeuxCelibataires;

@Component
public class GestionnaireDInscriptionRealisee {

    private final Celibataires celibataires;

    private final UseCase entremettage;

    public GestionnaireDInscriptionRealisee(Celibataires celibataires, UseCase entremettage) {
        this.celibataires = celibataires;
        this.entremettage = entremettage;
    }

    @EventListener
    void gerer(InscriptionRealisee inscriptionRealisee) {
        var celibatairesInscrits = celibataires.inscrits();
        var autresCelibatairesInscrits = celibatairesInscrits.stream()
                .filter(celibataire -> !celibataire.login().equals(inscriptionRealisee.login()))
                .collect(Collectors.toSet());
        autresCelibatairesInscrits.forEach(celibataire -> {
            var commande = new EntremettreDeuxCelibataires(inscriptionRealisee.login(), celibataire.login());
            entremettage.executer(commande);
        });
    }
}
