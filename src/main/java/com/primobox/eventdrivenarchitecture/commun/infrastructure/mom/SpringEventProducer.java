package com.primobox.eventdrivenarchitecture.commun.infrastructure.mom;

import com.primobox.eventdrivenarchitecture.commun.domaine.EmetteurDEvenementsDuDomaine;
import com.primobox.eventdrivenarchitecture.commun.domaine.Evenement;
import com.primobox.eventdrivenarchitecture.commun.domaine.EvenementEmis;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpringEventProducer implements EmetteurDEvenementsDuDomaine {

    private final List<EvenementEmis> evenements = new ArrayList<>();

    private final ApplicationEventPublisher eventPublisher;

    public SpringEventProducer(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public List<EvenementEmis> evenementsEmis() {
        return evenements;
    }

    @Override
    public void emettre(Evenement evenement) {
        eventPublisher.publishEvent(evenement);
        evenements.add(new EvenementEmis(evenement, LocalDateTime.now(), evenement.getClass().getName()));
    }
}
