package com.primobox.eventdrivenarchitecture.backoffice.infrastructure.primaire;

import com.primobox.eventdrivenarchitecture.commun.domaine.EmetteurDEvenementsDuDomaine;
import com.primobox.eventdrivenarchitecture.commun.domaine.EvenementEmis;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/backoffice")
public class BackofficeRestController {

    private final EmetteurDEvenementsDuDomaine emetteurDEvenementsDuDomaine;

    public BackofficeRestController(EmetteurDEvenementsDuDomaine emetteurDEvenementsDuDomaine) {
        this.emetteurDEvenementsDuDomaine = emetteurDEvenementsDuDomaine;
    }

    @GetMapping("/login")
    public ResponseEntity<Void> login() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/evenements")
    public ResponseEntity<List<EvenementEmis>> evenements() {
        return ResponseEntity.ok(emetteurDEvenementsDuDomaine.evenementsEmis());
    }
}
