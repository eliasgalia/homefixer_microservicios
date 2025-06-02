package com.homefixer.notificaciones.controller;

import com.homefixer.notificaciones.dto.NotificacionDTO;
import com.homefixer.notificaciones.model.Notificacion;
import com.homefixer.notificaciones.service.NotificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@RequiredArgsConstructor
public class NotificacionController {

    private final NotificacionService service;

    @PostMapping("/enviar")
    public ResponseEntity<Notificacion> enviar(@RequestBody NotificacionDTO dto) {
        return ResponseEntity.ok(service.enviar(dto));
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Notificacion>> porUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(service.porUsuario(id));
    }

    @GetMapping("/no-leidas/{id}")
    public ResponseEntity<List<Notificacion>> noLeidas(@PathVariable Long id) {
        return ResponseEntity.ok(service.noLeidas(id));
    }

    @PutMapping("/{id}/marcar-leida")
    public ResponseEntity<Notificacion> marcarLeida(@PathVariable Long id) {
        return ResponseEntity.ok(service.marcarLeida(id));
    }
}
