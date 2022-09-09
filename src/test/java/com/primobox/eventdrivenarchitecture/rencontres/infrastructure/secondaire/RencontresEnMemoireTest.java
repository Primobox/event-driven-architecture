package com.primobox.eventdrivenarchitecture.rencontres.infrastructure.secondaire;

import com.primobox.eventdrivenarchitecture.rencontres.infrastructure.secondaire.RencontresEnMemoire.Cle;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RencontresEnMemoireTest {

    @Nested
    class CleTest {

        @Test
        void deux_cles_equivalentes_doivent_etre_egales() {
            assertThat(new Cle("login1", "login2")).isEqualTo(new Cle("login2", "login1"));
        }

        @Test
        void deux_cles_equivalentes_doivent_avoir_le_meme_hash() {
            assertThat(new Cle("login1", "login2").hashCode()).isEqualTo(new Cle("login2", "login1").hashCode());
        }
    }
}