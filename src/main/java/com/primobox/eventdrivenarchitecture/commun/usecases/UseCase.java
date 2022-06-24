package com.primobox.eventdrivenarchitecture.commun.usecases;

import com.primobox.eventdrivenarchitecture.commun.ResultatDeCommande;

public interface UseCase<T extends Commande, R extends ResultatDeCommande<?, ?>> {
    R executer(T commande);
}
