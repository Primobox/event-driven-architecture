package com.primobox.eventdrivenarchitecture.inscriptions.infrastructure.configuration;

import com.primobox.eventdrivenarchitecture.commun.domaine.EmetteurDEvenementsDuDomaine;
import com.primobox.eventdrivenarchitecture.commun.usecases.UseCase;
import com.primobox.eventdrivenarchitecture.commun.usecases.UseCaseEvenementiel;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.Celibataires;
import com.primobox.eventdrivenarchitecture.inscriptions.usecases.Inscription;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InscriptionsConfiguration {

    @Bean
    public UseCase inscriptions(Celibataires celibataires, EmetteurDEvenementsDuDomaine emetteurDEvenementsDuDomaine) {
        return new UseCaseEvenementiel(new Inscription(celibataires), emetteurDEvenementsDuDomaine);
    }
}
