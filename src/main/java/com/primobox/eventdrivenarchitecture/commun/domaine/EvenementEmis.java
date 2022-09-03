package com.primobox.eventdrivenarchitecture.commun.domaine;

import java.time.LocalDateTime;

public record EvenementEmis(Evenement evenement, LocalDateTime date, String type) {
}
