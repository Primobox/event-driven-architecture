package com.primobox.eventdrivenarchitecture.commun.usecases;

import com.primobox.eventdrivenarchitecture.commun.ResultatDeCommande;
import com.primobox.eventdrivenarchitecture.commun.domaine.EmetteurDEvenementsDuDomaine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UseCaseEvenementiel<T extends Commande, R extends ResultatDeCommande<?, ?>> implements UseCase<T, R> {

    private static final Logger logger = LoggerFactory.getLogger(UseCaseEvenementiel.class);

    private final UseCase<T, R> useCase;
    private final EmetteurDEvenementsDuDomaine emetteurDEvenementsDuDomaine;

    public UseCaseEvenementiel(
        UseCase<T, R> useCase,
        EmetteurDEvenementsDuDomaine emetteurDEvenementsDuDomaine) {
        this.useCase = useCase;
        this.emetteurDEvenementsDuDomaine = emetteurDEvenementsDuDomaine;
    }

    @Override
    public R executer(T parametre) {
        R resultat = useCase.executer(parametre);
        logger.debug(resultat.evenementsProduits().toString());
        resultat.evenementsProduits().forEach(emetteurDEvenementsDuDomaine::emettre);
        return resultat;
    }
}
