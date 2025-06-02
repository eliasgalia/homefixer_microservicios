package com.homefixer.valoraciones.controller;

import com.homefixer.valoraciones.dto.ValoracionDTO;
import com.homefixer.valoraciones.model.Valoracion;
import com.homefixer.valoraciones.service.ValoracionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/valoraciones")
@RequiredArgsConstructor
public class ValoracionController {

    private final ValoracionService service;

    @PostMapping
    public ResponseEntity<Valoracion> crear(@RequestBody ValoracionDTO dto) {
        return ResponseEntity.ok(service.crearValoracion(dto));
    }

    @GetMapping("/tecnico/{id}")
    public ResponseEntity<List<Valoracion>> porTecnico(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarPorTecnico(id));
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Valoracion>> porCliente(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarPorCliente(id));
    }

    @GetMapping("/promedio/{idTecnico}")
    public ResponseEntity<Double> promedio(@PathVariable Long idTecnico) {
        return ResponseEntity.ok(service.promedioTecnico(idTecnico));
    }
}
