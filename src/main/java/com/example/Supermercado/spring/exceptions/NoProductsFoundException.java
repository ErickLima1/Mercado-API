package com.example.Supermercado.spring.exceptions;

public class NoProductsFoundException extends RuntimeException {

    public NoProductsFoundException() {super("Não Existe Produtos Cadastrado!"); }

    public NoProductsFoundException(String message) {super(message); }

}
