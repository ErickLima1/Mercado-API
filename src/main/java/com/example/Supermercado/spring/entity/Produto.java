package com.example.Supermercado.spring.entity;

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
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private double valor;

    @CreationTimestamp
    private Instant creationTimestamp;

    @UpdateTimestamp
    private Instant updateTimestamp;

    @ManyToOne
    @JoinColumn(name = "supermercado_id", referencedColumnName = "id")
    private Supermercado supermercado;

}
