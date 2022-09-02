package com.primobox.eventdrivenarchitecture.rencontres.usecases;

import com.primobox.eventdrivenarchitecture.IntegrationTest;
import com.primobox.eventdrivenarchitecture.commun.domaine.EmetteurDEvenementsDuDomaine;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.Celibataire;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.Celibataires;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.evenements.InscriptionRealisee;
import com.primobox.eventdrivenarchitecture.rencontres.domaine.Rencontres;
import com.primobox.eventdrivenarchitecture.rencontres.domaine.evenements.UneRencontreAEteOrganisee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.primobox.eventdrivenarchitecture.commun.infrastructure.mom.EvenementsDuDomaineEmisAsserter.assertThatEventOfType;
import static com.primobox.eventdrivenarchitecture.rencontres.domaine.RencontreAsserter.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@IntegrationTest
public class EntremettageTest {

    @Autowired
    private EmetteurDEvenementsDuDomaine emetteurDEvenementsDuDomaine;

    @Autowired
    private Rencontres rencontres;

    @Autowired
    private Celibataires celibataires;

    @Test
    void doit_creer_une_rencontre_avec_tous_les_celibataires_de_la_plateforme_lors_de_l_inscription() throws InterruptedException {
        ilExisteDejaLesCelibataires("tartampionDu24", "choupinou28", "tonton33", "zouzoudumedoc", "damidoudu64");

        emetteurDEvenementsDuDomaine.emettre(new InscriptionRealisee("grosdoudou33"));

        assertAll(
                () -> assertThatEventOfType(UneRencontreAEteOrganisee.class).wasEmittedTimes(5),
                () -> assertThat(rencontres.entre("tartampionDu24", "grosdoudou33")).estOrganisee(),
                () -> assertThat(rencontres.entre("choupinou28", "grosdoudou33")).estOrganisee(),
                () -> assertThat(rencontres.entre("tonton33", "grosdoudou33")).estOrganisee(),
                () -> assertThat(rencontres.entre("zouzoudumedoc", "grosdoudou33")).estOrganisee(),
                () -> assertThat(rencontres.entre("damidoudu64", "grosdoudou33")).estOrganisee()
        );
    }

    private void ilExisteDejaLesCelibataires(String... loginsDesCelibataires) {
        for (String loginDuCelibataire : loginsDesCelibataires) {
            celibataires.ajouter(new Celibataire(loginDuCelibataire));
        }
    }
}
