package com.primobox.eventdrivenarchitecture.commun.infrastructure.mom;

import com.primobox.eventdrivenarchitecture.commun.domaine.Evenement;
import org.assertj.core.api.AbstractAssert;

import java.time.LocalDate;
import java.util.UUID;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static uk.org.webcompere.modelassert.json.JsonAssertions.assertJson;

public class EvenementsDuDomaineEmisAsserter extends AbstractAssert<EvenementsDuDomaineEmisAsserter, Class<? extends Evenement>> {

    private String message = "";
    private static final String JSON_DELIMITER = "/";

    private EvenementsDuDomaineEmisAsserter(Class<? extends Evenement> aClass) {
        super(aClass, EvenementsDuDomaineEmisAsserter.class);
    }

    public static EvenementsDuDomaineEmisAsserter assertThatEventOfType(Class<? extends Evenement> evenementClass) {
        return new EvenementsDuDomaineEmisAsserter(evenementClass);
    }

    public EvenementsDuDomaineEmisAsserter wasEmittedTimes(int times) throws InterruptedException {
        assertThat(EvenementsEmisListener.eventsCount.get(actual.getName())).isEqualTo(times);
        this.wasEmitted();
        return this;
    }

    public EvenementsDuDomaineEmisAsserter wasEmitted() throws InterruptedException {
        sleep(200);
        if (!EvenementsEmisListener.events.containsKey(actual.getName())) {
            failWithMessage("Expected emission of a message of type " + actual.getName() + ", but no message of that type was emitted. Actual messages : " + EvenementsEmisListener.events.keySet());
        }
        this.message = EvenementsEmisListener.events.get(actual.getName());
        return this;
    }

    public EvenementsDuDomaineEmisAsserter withValue(String eventProperty, String expectedValue) {
        assertJson(message).at(buildJsonPath(eventProperty)).isText(expectedValue);
        return this;
    }

    public EvenementsDuDomaineEmisAsserter withValue(String eventProperty, UUID expectedValue) {
        assertJson(message).at(buildJsonPath(eventProperty)).isEqualTo(expectedValue);
        return this;
    }

    public EvenementsDuDomaineEmisAsserter withValue(String eventProperty, LocalDate expectedValue) {
        assertJson(message).at(buildJsonPath(eventProperty)).isText(expectedValue.toString());
        return this;
    }

    public EvenementsDuDomaineEmisAsserter withValueNotEmpty(String eventProperty) {
        assertJson(message).at(buildJsonPath(eventProperty)).isNotEmptyText();
        return this;
    }

    private String buildJsonPath(String eventProperty) {
        return JSON_DELIMITER + eventProperty.replace(".", JSON_DELIMITER);
    }
}
