package com.primobox.eventdrivenarchitecture.commun.domaine;

import java.util.ArrayList;
import java.util.Collection;

public interface EmetteurDEvenementsDuDomaine {
    void emettre(Evenement evenement);

    class Fake implements EmetteurDEvenementsDuDomaine {

        private final Collection<Evenement> evenements = new ArrayList<>();

        @Override
        public void emettre(Evenement evenement) {
            evenements.add(evenement);
        }
    }
}
