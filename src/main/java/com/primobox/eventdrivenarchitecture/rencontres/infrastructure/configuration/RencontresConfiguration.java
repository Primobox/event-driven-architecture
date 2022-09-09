package com.primobox.eventdrivenarchitecture.rencontres.infrastructure.configuration;

import com.primobox.eventdrivenarchitecture.commun.domaine.EmetteurDEvenementsDuDomaine;
import com.primobox.eventdrivenarchitecture.commun.usecases.UseCase;
import com.primobox.eventdrivenarchitecture.commun.usecases.UseCaseEvenementiel;
import com.primobox.eventdrivenarchitecture.rencontres.domaine.Rencontres;
import com.primobox.eventdrivenarchitecture.rencontres.usecases.Entremettage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RencontresConfiguration {

    @Bean
    public UseCase entremettage(Rencontres rencontres, EmetteurDEvenementsDuDomaine emetteurDEvenementsDuDomaine) {
        return new UseCaseEvenementiel(new Entremettage(rencontres), emetteurDEvenementsDuDomaine);
    }
}
