package com.primobox.eventdrivenarchitecture.rencontres.domaine;

import java.util.Optional;

public interface Rencontres {
    Optional<Rencontre> entre(String celibataire1, String celibataire2);

    static Rencontre organiser(String celibataire1, String celibataire2) {
        return new RencontreOrganisee(celibataire1, celibataire2);
    }

    void ajouter(Rencontre rencontre);
}
