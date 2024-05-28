package com.example.Supermercado.spring.controller;

import com.example.Supermercado.spring.dto.CreateSupermercadoDto;
import com.example.Supermercado.spring.entity.Supermercado;
import com.example.Supermercado.spring.service.SupermercadoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/createsupermercado")
@AllArgsConstructor
public class SupermercadoController {

    private final SupermercadoService supermercadoService;
    @PostMapping
    public ResponseEntity<String> createMercado(@RequestBody @Valid CreateSupermercadoDto createSupermercadoDto) {
        supermercadoService.createMercado(createSupermercadoDto);
        return ResponseEntity.ok("Dados Do Mercado Salvo !");

    }
    @GetMapping("/{id}")
    public ResponseEntity<Supermercado> getMercadoById(@PathVariable("id") String id) {
        var getByMercado = supermercadoService.getMercadoById(id);
        return getByMercado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Supermercado>> getMercadoByNome(@PathVariable("nome") String nome) {
        List<Supermercado> supermercados = supermercadoService.getMercadoByNome(nome);
        if (supermercados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(supermercados);
    }

    @GetMapping
    public ResponseEntity<List<Supermercado>> getAllMercados() {
        var getMercados = supermercadoService.getAllMercados();
        return ResponseEntity.ok(getMercados);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMercado(@PathVariable String id,
                                              @RequestBody @Valid CreateSupermercadoDto updateSupermercadoDto) {
        supermercadoService.updateMercado(id, updateSupermercadoDto);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMercado(@PathVariable("id") String id) {
        supermercadoService.deleteMercado(id);
        return ResponseEntity.noContent().build();
    }

}
