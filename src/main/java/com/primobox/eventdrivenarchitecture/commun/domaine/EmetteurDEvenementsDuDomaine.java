package com.primobox.eventdrivenarchitecture.commun.domaine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface EmetteurDEvenementsDuDomaine {

    List<EvenementEmis> evenementsEmis();

    void emettre(Evenement evenement);

    class Fake implements EmetteurDEvenementsDuDomaine {

        private final List<EvenementEmis> evenements = new ArrayList<>();

        @Override
        public List<EvenementEmis> evenementsEmis() {
            return evenements;
        }

        @Override
        public void emettre(Evenement evenement) {
            evenements.add(new EvenementEmis(evenement, LocalDateTime.now(), evenement.getClass().getName()));
        }
    }
}
