package com.example.Supermercado.spring.repository;

import com.example.Supermercado.spring.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {


}
