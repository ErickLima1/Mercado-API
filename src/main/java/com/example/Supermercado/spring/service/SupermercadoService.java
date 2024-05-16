package com.example.Supermercado.spring.service;

import com.example.Supermercado.spring.dto.CreateSupermercadoDto;
import com.example.Supermercado.spring.entity.Supermercado;
import com.example.Supermercado.spring.exceptions.NomeAlreadyExistsException;
import com.example.Supermercado.spring.repository.SupermercadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupermercadoService {

    private final SupermercadoRepository supermercadoRepository;

    public Long createMercado(CreateSupermercadoDto createSupermercadoDto) {

        if(supermercadoRepository.existsByNome(createSupermercadoDto.nome())) {
            throw new NomeAlreadyExistsException();
        }

        var entity = new Supermercado(
                null,
                createSupermercadoDto.nome(), //Adicionar validation para não ter nome igual
                createSupermercadoDto.descricao(),
                createSupermercadoDto.quantidade(),
                Instant.now(),
                null

        );
        var mercadoSaved = supermercadoRepository.save(entity);

        return mercadoSaved.getId();
    }
    public Optional<Supermercado> getMercadoById(String id) {
        return supermercadoRepository.findById(Long.parseLong(id));
    }

    public List<Supermercado> getAllMercados() {
        return supermercadoRepository.findAll();
    }

    public void deleteMercado(String id) {
        Long mercadoId = Long.parseLong(id);
        supermercadoRepository.deleteById(mercadoId);
    }
}
