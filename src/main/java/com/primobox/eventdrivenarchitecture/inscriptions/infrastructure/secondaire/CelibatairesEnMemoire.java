package com.primobox.eventdrivenarchitecture.inscriptions.infrastructure.secondaire;

import com.primobox.eventdrivenarchitecture.inscriptions.domaine.Celibataire;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.Celibataires;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.irregularites.CelibataireDejaInscrit;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Override
    public Set<Celibataire> inscrits() {
        return this.celibataires
                .stream()
                .map(Celibataire::new)
                .collect(Collectors.toSet());
    }
}
