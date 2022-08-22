package com.primobox.eventdrivenarchitecture.inscriptions.infrastructure.secondaire;

import com.primobox.eventdrivenarchitecture.inscriptions.domaine.Celibataire;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.Celibataires;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.irregularites.CelibataireDejaInscrit;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class CelibatairesEnMemoire implements Celibataires {

    private Set<String> celibataires = new HashSet<>();

    @Override
    public void ajouter(Celibataire celibataire) {
        if (celibataires.contains(celibataire.login())) {
            throw new CelibataireDejaInscrit();
        }
        this.celibataires.add(celibataire.login());
    }
}
