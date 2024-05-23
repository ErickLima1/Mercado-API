package com.example.Supermercado.spring.repository;

import com.example.Supermercado.spring.entity.Supermercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupermercadoRepository extends JpaRepository<Supermercado, Long> {
    boolean existsByNome(String nome);
    List<Supermercado> findByNome(String nome);

}
