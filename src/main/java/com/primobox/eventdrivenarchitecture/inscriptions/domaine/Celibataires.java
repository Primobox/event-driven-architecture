package com.primobox.eventdrivenarchitecture.inscriptions.domaine;

import java.util.Set;

public interface Celibataires {

    void ajouter(Celibataire celibataire);

    Set<Celibataire> inscrits();
}
