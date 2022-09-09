package com.primobox.eventdrivenarchitecture.rencontres.domaine;

import com.primobox.eventdrivenarchitecture.commun.domaine.Evenement;
import com.primobox.eventdrivenarchitecture.commun.infrastructure.mom.EvenementsDuDomaineEmisAsserter;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import java.util.Optional;

public class RencontreAsserter extends AbstractAssert<RencontreAsserter, Optional<Rencontre>> {

    private RencontreAsserter(Optional<Rencontre> rencontre) {
        super(rencontre, RencontreAsserter.class);
    }

    public static RencontreAsserter assertThat(Optional<Rencontre> rencontre) {
        return new RencontreAsserter(rencontre);
    }

    public RencontreAsserter estOrganisee() {
        Assertions.assertThat(actual).isNotEmpty();
        Assertions.assertThat(actual.get().estOrganisee()).isTrue();
        return this;
    }
}
