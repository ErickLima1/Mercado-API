package com.example.Supermercado.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private double valor;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;

    public Produto(Long id, String nome, double valor, Instant creationTimestamp, Instant updateTimestamp, Supermercado supermercado) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.creationTimestamp = creationTimestamp;
        this.updateTimestamp = updateTimestamp;
        this.supermercado = supermercado;
    }

    @ManyToOne
    @JoinColumn(name = "supermercado_id", referencedColumnName = "id")
    @JsonBackReference
    private Supermercado supermercado;

}
