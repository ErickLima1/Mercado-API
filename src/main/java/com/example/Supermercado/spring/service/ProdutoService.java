package com.example.Supermercado.spring.service;

import com.example.Supermercado.spring.dto.CreateProdutoDto;
import com.example.Supermercado.spring.dto.ProdutoResponseDto;
import com.example.Supermercado.spring.dto.SupermercadoResponseDto;
import com.example.Supermercado.spring.entity.Produto;
import com.example.Supermercado.spring.exceptions.InvalidSupermercadoIdException;
import com.example.Supermercado.spring.exceptions.NoProductsFoundException;
import com.example.Supermercado.spring.exceptions.idNotExistsException;
import com.example.Supermercado.spring.repository.ProdutoRepository;
import com.example.Supermercado.spring.repository.SupermercadoRepository;
import lombok.AllArgsConstructor;
import org.hibernate.sql.Delete;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final SupermercadoRepository supermercadoRepository;

    private final ProdutoRepository produtoRepository;

    public Long createProduto(CreateProdutoDto createProdutoDto) {
        var supermercado = supermercadoRepository.findById(createProdutoDto.supermercadoId())
                .orElseThrow(idNotExistsException::new);

        var produto = new Produto(
                null,
                createProdutoDto.nome(),
                createProdutoDto.valor(),
                Instant.now(),
                null,
                supermercado
        );
        produto = produtoRepository.save(produto);
        return produto.getId();
    }

    public Optional<ProdutoResponseDto> getAllProdutoByMercado(Long id) {
        return produtoRepository.findById(id).map(this::convertToDto);

    }

    private ProdutoResponseDto convertToDto(Produto produto) {
        SupermercadoResponseDto supermercadoDto = new SupermercadoResponseDto(
                produto.getSupermercado().getId(),
                produto.getSupermercado().getNome()
        );
        return new ProdutoResponseDto(produto.getId(), produto.getNome(), produto.getValor(), supermercadoDto);
    }

    public List<Produto> getAllProdutos() {
        List<Produto> produtos = produtoRepository.findAll();

        if(produtos.isEmpty()) {
            throw new NoProductsFoundException();
        }

        return produtos;
    }

    public void updateProduto(String id, CreateProdutoDto updateProduto) {
        Long produtoId = Long.parseLong(id);
        Produto produto =  produtoRepository.findById(produtoId)
                .orElseThrow(idNotExistsException::new);

        if(!produto.getSupermercado().getId().equals(updateProduto.supermercadoId())) {
            throw new InvalidSupermercadoIdException();
        }

        BeanUtils.copyProperties(updateProduto, produto);
        produtoRepository.save(produto);

    }

    public void deleteProdutoById(String id) {
        Long produtoId = Long.parseLong(id);
        boolean produtoExists = produtoRepository.existsById(produtoId);

        if(produtoExists) {
            produtoRepository.deleteById(produtoId);

        } else {
            throw new idNotExistsException();
        }

    }

}
