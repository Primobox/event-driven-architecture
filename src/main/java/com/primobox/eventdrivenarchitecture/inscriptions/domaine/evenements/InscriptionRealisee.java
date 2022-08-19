package com.primobox.eventdrivenarchitecture.inscriptions.domaine.evenements;

import com.primobox.eventdrivenarchitecture.commun.domaine.Evenement;

public record InscriptionRealisee(String login) implements Evenement {
}
