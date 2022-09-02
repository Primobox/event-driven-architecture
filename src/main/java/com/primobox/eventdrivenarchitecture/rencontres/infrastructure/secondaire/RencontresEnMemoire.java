package com.primobox.eventdrivenarchitecture.rencontres.infrastructure.secondaire;

import com.primobox.eventdrivenarchitecture.rencontres.domaine.Rencontre;
import com.primobox.eventdrivenarchitecture.rencontres.domaine.Rencontres;
import org.springframework.stereotype.Repository;

@Repository
public class RencontresEnMemoire implements Rencontres {

    @Override
    public Rencontre entre(String celibataire1, String celibataire2) {
        return null;
    }
}
