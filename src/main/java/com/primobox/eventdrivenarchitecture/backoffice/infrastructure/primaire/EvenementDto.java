package com.primobox.eventdrivenarchitecture.backoffice.infrastructure.primaire;

import com.primobox.eventdrivenarchitecture.commun.domaine.Evenement;

import java.time.LocalDateTime;

public record EvenementDto(Evenement payload, LocalDateTime date, String type) {
}
