package com.example.Supermercado.spring.exceptions;

public class NomeAlreadyExistsException extends RuntimeException {

    public NomeAlreadyExistsException() { super("Nome da Empresa em Uso"); }

    public NomeAlreadyExistsException(String message) { super(message); }
}
