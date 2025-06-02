package com.homefixer.notificaciones.repository;

import com.homefixer.notificaciones.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    List<Notificacion> findByIdUsuario(Long id);
    List<Notificacion> findByIdUsuarioAndLeidaFalse(Long id);
}
