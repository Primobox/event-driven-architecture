package com.primobox.eventdrivenarchitecture.commun.infrastructure.mom;

import com.primobox.eventdrivenarchitecture.commun.domaine.Evenement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EvenementsEmisListener {

    private static final Logger logger = LoggerFactory.getLogger(EvenementsEmisListener.class);

    public static final Map<String, String> events = new HashMap<>();
    public static final Map<String, Integer> eventsCount = new HashMap<>();

    @EventListener
    public void ecouter(Evenement evenement) {
        var typeDeLEvenement = evenement.getClass().getName();
        logger.info(typeDeLEvenement + " -> " + evenement);
        events.put(typeDeLEvenement, evenement.toString());
        eventsCount.put(typeDeLEvenement, eventsCount.getOrDefault(typeDeLEvenement, 0) + 1);
    }
}
