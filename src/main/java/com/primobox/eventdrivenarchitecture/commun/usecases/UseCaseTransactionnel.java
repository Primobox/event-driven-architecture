package com.primobox.eventdrivenarchitecture.commun.usecases;

import com.primobox.eventdrivenarchitecture.commun.ResultatDeCommande;
import org.springframework.transaction.support.TransactionTemplate;

public class UseCaseTransactionnel<T extends Commande, R extends ResultatDeCommande<?, ?>> implements UseCase<T, R> {

    private final UseCase<T, R> useCase;
    private final TransactionTemplate transactionTemplate;

    public UseCaseTransactionnel(
            UseCase<T, R> useCase,
            TransactionTemplate transactionTemplate) {
        this.useCase = useCase;
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public R executer(T parametre) {
        return transactionTemplate.execute(status -> useCase.executer(parametre));
    }
}
