package com.primobox.eventdrivenarchitecture.commun.infrastructure.mom;

import com.primobox.eventdrivenarchitecture.commun.domaine.EmetteurDEvenementsDuDomaine;
import com.primobox.eventdrivenarchitecture.commun.domaine.Evenement;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ArtemisProducer implements EmetteurDEvenementsDuDomaine {
    private final JmsTemplate jmsTemplate;

    public ArtemisProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void emettre(Evenement evenement) {
        jmsTemplate.convertAndSend(evenement.getClass().getName(), evenement);
    }
}
