package com.primobox.eventdrivenarchitecture.rencontres.domaine.evenements;

import com.primobox.eventdrivenarchitecture.commun.domaine.Evenement;

public record UneRencontreAEteOrganisee(String celibataire1, String celibataire2) implements Evenement {
}
