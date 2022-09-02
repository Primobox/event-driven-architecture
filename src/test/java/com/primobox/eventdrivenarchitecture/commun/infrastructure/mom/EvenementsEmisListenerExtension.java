package com.primobox.eventdrivenarchitecture.commun.infrastructure.mom;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class EvenementsEmisListenerExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        EvenementsEmisListener.events.clear();
        EvenementsEmisListener.eventsCount.clear();
    }
}
