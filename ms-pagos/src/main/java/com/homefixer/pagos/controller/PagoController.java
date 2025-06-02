package com.homefixer.pagos.controller;

import com.homefixer.pagos.dto.PagoDTO;
import com.homefixer.pagos.model.Pago;
import com.homefixer.pagos.service.PagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {
    private final PagoService service;

    @PostMapping("/procesar")
    public ResponseEntity<Pago> procesar(@RequestBody PagoDTO dto) {
        return ResponseEntity.ok(service.procesarPago(dto));
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Pago>> pagosCliente(@PathVariable Long id) {
        return ResponseEntity.ok(service.historialCliente(id));
    }

    @GetMapping("/tecnico/{id}")
    public ResponseEntity<List<Pago>> pagosTecnico(@PathVariable Long id) {
        return ResponseEntity.ok(service.ingresosTecnico(id));
    }

    @GetMapping("/estadisticas")
    public ResponseEntity<List<Pago>> estadisticas() {
        return ResponseEntity.ok(service.listar());
    }
}
