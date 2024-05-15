package com.example.Supermercado.spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateSupermercadoDto(@NotBlank(message = "Nome da empresa obrigatória") String nome,
                                    @NotBlank(message = "Descrição é obrigatória") String descricao,
                                    @Positive(message = "Quantidade deve ser maior que zero") int quantidade) {
}
