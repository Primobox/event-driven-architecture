package com.primobox.eventdrivenarchitecture.rencontres.infrastructure.secondaire;

import com.primobox.eventdrivenarchitecture.rencontres.domaine.Rencontre;
import com.primobox.eventdrivenarchitecture.rencontres.domaine.Rencontres;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Repository
public class RencontresEnMemoire implements Rencontres {

    private Map<Cle, Rencontre> rencontres = new HashMap<>();

    @Override
    public Optional<Rencontre> entre(String celibataire1, String celibataire2) {
        var cle = new Cle(celibataire1, celibataire2);
        return Optional.ofNullable(rencontres.get(cle));
    }

    @Override
    public void ajouter(Rencontre rencontre) {
        var cle = new Cle(rencontre.celibataire1(), rencontre.celibataire2());
        rencontres.put(cle, rencontre);
    }

    static class Cle {
        private String celibataire1;
        private String celibataire2;

        Cle(String celibataire1, String celibataire2) {
            this.celibataire1 = celibataire1;
            this.celibataire2 = celibataire2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cle cle = (Cle) o;
            return (celibataire1.equals(cle.celibataire1) && celibataire2.equals(cle.celibataire2)) || (celibataire1.equals(cle.celibataire2) && celibataire2.equals(cle.celibataire1));
        }

        @Override
        public int hashCode() {
            return celibataire1.hashCode() + celibataire2.hashCode();
        }
    }
}
