package com.example.Supermercado.spring.exceptions;

public class idNotExistsException extends RuntimeException{

    public idNotExistsException() {super("Código do Mercado Não Existe"); }

    public idNotExistsException(String message) {super(message); }
}
