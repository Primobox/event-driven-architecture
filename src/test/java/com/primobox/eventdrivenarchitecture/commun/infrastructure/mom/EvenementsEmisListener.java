package com.primobox.eventdrivenarchitecture.commun.infrastructure.mom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class EvenementsEmisListener {

    private static final Logger logger = LoggerFactory.getLogger(EvenementsEmisListener.class);

    public static final Map<String, String> events = new HashMap<>();
    public static final Map<String, Integer> eventsCount = new HashMap<>();
}
