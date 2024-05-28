package com.example.Supermercado.spring.exceptions;

public class InvalidSupermercadoIdException extends RuntimeException {
    public InvalidSupermercadoIdException() {super("Supermercado ID inválido."); }

    public InvalidSupermercadoIdException(String message) {super(message); }
}
