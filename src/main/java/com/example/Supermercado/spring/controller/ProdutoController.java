package com.example.Supermercado.spring.controller;

import com.example.Supermercado.spring.dto.CreateProdutoDto;
import com.example.Supermercado.spring.dto.CreateSupermercadoDto;
import com.example.Supermercado.spring.dto.ProdutoResponseDto;
import com.example.Supermercado.spring.entity.Produto;
import com.example.Supermercado.spring.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<String> createProduto(@RequestBody @Valid CreateProdutoDto createProduto) {
        produtoService.createProduto(createProduto);
        return ResponseEntity.ok("Produto Criado Com Sucesso !");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> getAllProdutoByMercado(@PathVariable Long id) {
        return produtoService.getAllProdutoByMercado(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        var produtos = produtoService.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduto(@PathVariable String id, @RequestBody @Valid CreateProdutoDto updateProdutoDto) {
        produtoService.updateProduto(id, updateProdutoDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdutoById(@PathVariable("id") String id) {
        produtoService.deleteProdutoById(id);
        return ResponseEntity.noContent().build();

    }
}
