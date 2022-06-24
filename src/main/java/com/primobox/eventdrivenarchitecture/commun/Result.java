package com.primobox.eventdrivenarchitecture.commun;

public class Result<T, E> {

    private final boolean isSuccess;

    private final boolean isFailure;

    private final T value;

    private final E error;

    private Result(T value, E error) {
        this.value = value;
        this.error = error;
        this.isSuccess = value != null;
        this.isFailure = error != null;
    }

    public static <T, E> Result<T, E> success(T value) {
        return new Result<>(value, null);
    }

    public static <T, E> Result<T, E> failure(E error) {
        return new Result<>(null, error);
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isFailure() {
        return isFailure;
    }

    public T value() {
        return value;
    }

    public E error() {
        return error;
    }
}
