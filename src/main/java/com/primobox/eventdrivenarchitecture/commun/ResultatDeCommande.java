package com.primobox.eventdrivenarchitecture.commun;

import static java.util.Collections.emptyList;

import com.primobox.eventdrivenarchitecture.commun.domaine.Evenement;
import java.util.Collection;
import java.util.List;

public record ResultatDeCommande<T, E>(Result<T, E> resultat, Collection<Evenement> evenementsProduits) {

    public ResultatDeCommande {
        assert resultat != null : "Un résultat de commande ne peut pas avoir un résultat null";
        assert evenementsProduits != null : "Un résultat de commande ne peut pas avoir une liste d'événements produits null";
    }

    public static <E> ResultatDeCommande<Evenement, E> succes(Evenement evenementProduit) {
        return succes(evenementProduit, evenementProduit);
    }

    public static <T, E> ResultatDeCommande<T, E> succes(T value, Evenement evenementProduit) {
        return succes(value, List.of(evenementProduit));
    }

    public static <T, E> ResultatDeCommande<T, E> succes(T value, Collection<Evenement> evenementsProduits) {
        return new ResultatDeCommande<>(Result.success(value), evenementsProduits);
    }

    public static <T> ResultatDeCommande<T, Evenement> echec(Evenement evenementProduit) {
        return echec(evenementProduit, evenementProduit);
    }

    public static <T, E> ResultatDeCommande<T, E> echec(E irregularite) {
        return echec(irregularite, emptyList());
    }

    public static <T, E> ResultatDeCommande<T, E> echec(E irregularite, Evenement evenementProduit) {
        return echec(irregularite, List.of(evenementProduit));
    }

    public static <T, E> ResultatDeCommande<T, E> echec(E irregularite, Collection<Evenement> evenementsProduits) {
        return new ResultatDeCommande<>(Result.failure(irregularite), evenementsProduits);
    }

    public boolean isSuccess() {
        return resultat.isSuccess();
    }

    public boolean isFailure() {
        return resultat.isFailure();
    }

    public E error() {
        return resultat.error();
    }

    public T value() {
        return resultat.value();
    }

    public Evenement evenementProduit() {
        return this.evenementsProduits.stream().toList().get(0);
    }
}
