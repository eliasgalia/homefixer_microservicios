package com.homefixer.notificaciones.service;

import com.homefixer.notificaciones.dto.NotificacionDTO;
import com.homefixer.notificaciones.model.Notificacion;
import com.homefixer.notificaciones.repository.NotificacionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificacionService {

    private final NotificacionRepository repository;

    public Notificacion enviar(NotificacionDTO dto) {
        log.info("✅ Enviando notificación a usuario {}", dto.getIdUsuario());

        Notificacion n = Notificacion.builder()
                .idUsuario(dto.getIdUsuario())
                .titulo(dto.getTitulo())
                .mensaje(dto.getMensaje())
                .tipo(dto.getTipo())
                .leida(false)
                .fechaEnvio(LocalDateTime.now())
                .canal(dto.getCanal())
                .build();

        return repository.save(n);
    }

    public List<Notificacion> porUsuario(Long id) {
        return repository.findByIdUsuario(id);
    }

    public List<Notificacion> noLeidas(Long id) {
        return repository.findByIdUsuarioAndLeidaFalse(id);
    }

    public Notificacion marcarLeida(Long id) {
        Notificacion noti = repository.findById(id).orElseThrow();
        noti.setLeida(true);
        return repository.save(noti);
    }
}