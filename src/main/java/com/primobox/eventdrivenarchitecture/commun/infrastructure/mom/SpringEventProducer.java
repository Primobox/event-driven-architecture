package com.primobox.eventdrivenarchitecture.commun.infrastructure.mom;

import com.primobox.eventdrivenarchitecture.commun.domaine.EmetteurDEvenementsDuDomaine;
import com.primobox.eventdrivenarchitecture.commun.domaine.Evenement;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class SpringEventProducer implements EmetteurDEvenementsDuDomaine {
    private final ApplicationEventPublisher eventPublisher;

    public SpringEventProducer(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void emettre(Evenement evenement) {
        eventPublisher.publishEvent(evenement);
    }
}
