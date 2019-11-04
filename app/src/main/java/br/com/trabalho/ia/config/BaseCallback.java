package br.com.trabalho.ia.config;

public interface BaseCallback<T> {
    void onSuccessful(T value);
    void onUnsuccessful(String error);
}
