package com.primobox.eventdrivenarchitecture.rencontres.domaine;

public record RencontreOrganisee(String celibataire1, String celibataire2) implements Rencontre {
    @Override
    public boolean estOrganisee() {
        return true;
    }
}
