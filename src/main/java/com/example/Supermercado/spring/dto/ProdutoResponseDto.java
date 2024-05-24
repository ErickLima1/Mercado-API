package com.example.Supermercado.spring.dto;

public record ProdutoResponseDto(Long id, String nome, double valor, SupermercadoResponseDto supermercado) {
}
