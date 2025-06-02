package com.homefixer.valoraciones.repository;

import com.homefixer.valoraciones.model.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValoracionRepository extends JpaRepository<Valoracion, Long> {
    List<Valoracion> findByIdTecnico(Long id);
    List<Valoracion> findByIdCliente(Long id);
}
