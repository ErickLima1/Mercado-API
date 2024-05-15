package com.example.Supermercado.spring.dto;

import jakarta.validation.constraints.NotNull;

public record CreateProdutoDto(@NotNull(message = "Nome do Produto obrigatória") String nome,
                               @NotNull(message = "Valor do Produto obrigatória") String valor){

}
