package com.example.Supermercado.spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateProdutoDto(@NotBlank(message = "Nome do Produto obrigatória") String nome,
                               @Positive(message = "Valor do Produto é obrigatório") double valor,
                               @NotNull(message = "ID do Supermercado é obrigatório") Long supermercadoId){

}
