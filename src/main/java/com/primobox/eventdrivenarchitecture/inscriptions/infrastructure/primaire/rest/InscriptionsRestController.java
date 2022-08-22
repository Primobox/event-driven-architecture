package com.primobox.eventdrivenarchitecture.inscriptions.infrastructure.primaire.rest;

import com.primobox.eventdrivenarchitecture.commun.ResultatDeCommande;
import com.primobox.eventdrivenarchitecture.commun.domaine.Evenement;
import com.primobox.eventdrivenarchitecture.commun.usecases.UseCase;
import com.primobox.eventdrivenarchitecture.inscriptions.domaine.irregularites.CelibataireDejaInscrit;
import com.primobox.eventdrivenarchitecture.inscriptions.usecases.Inscription;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.MessageFormat;

import static com.primobox.eventdrivenarchitecture.inscriptions.usecases.Inscription.*;
import static java.text.MessageFormat.format;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionsRestController {

    private final UseCase<SInscrire, ResultatDeCommande<Evenement, CelibataireDejaInscrit>> inscription;

    public InscriptionsRestController(UseCase inscription) {
        this.inscription = inscription;
    }

    @PostMapping
    public ResponseEntity<String> sinscrire(@RequestBody CelibataireDto celibataire, UriComponentsBuilder uriComponentsBuilder) {
        var resultatDeLInscription = this.inscription.executer(new SInscrire(celibataire.login()));
        if (resultatDeLInscription.isFailure()) {
            return ResponseEntity.badRequest().body(format("Le login {0} est déjà inscrit", celibataire.login()));
        }
        var locationURI = uriComponentsBuilder
                .path("/{id}")
                .buildAndExpand(celibataire.login())
                .toUri();
        return ResponseEntity.created(locationURI).build();
    }
}
