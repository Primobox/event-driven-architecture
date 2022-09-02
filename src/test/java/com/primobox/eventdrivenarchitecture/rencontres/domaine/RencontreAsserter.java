package com.primobox.eventdrivenarchitecture.rencontres.domaine;

import com.primobox.eventdrivenarchitecture.commun.domaine.Evenement;
import com.primobox.eventdrivenarchitecture.commun.infrastructure.mom.EvenementsDuDomaineEmisAsserter;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class RencontreAsserter extends AbstractAssert<RencontreAsserter, Rencontre> {

    private RencontreAsserter(Rencontre rencontre) {
        super(rencontre, RencontreAsserter.class);
    }

    public static RencontreAsserter assertThat(Rencontre rencontre) {
        return new RencontreAsserter(rencontre);
    }

    public RencontreAsserter estOrganisee() {
        Assertions.assertThat(actual.estOrganisee()).isTrue();
        return this;
    }
}
