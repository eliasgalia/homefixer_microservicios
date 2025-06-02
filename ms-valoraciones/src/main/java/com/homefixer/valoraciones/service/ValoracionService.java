package com.homefixer.valoraciones.service;

import com.homefixer.valoraciones.dto.ValoracionDTO;
import com.homefixer.valoraciones.model.Valoracion;
import com.homefixer.valoraciones.repository.ValoracionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.OptionalDouble;

@Service
@RequiredArgsConstructor
@Slf4j
public class ValoracionService {

    private final ValoracionRepository repository;

    public Valoracion crearValoracion(ValoracionDTO dto) {
        log.info("✅ Registrando nueva valoración para solicitud {}", dto.getIdSolicitud());

        Valoracion v = Valoracion.builder()
                .idSolicitud(dto.getIdSolicitud())
                .idCliente(dto.getIdCliente())
                .idTecnico(dto.getIdTecnico())
                .calificacion(dto.getCalificacion())
                .comentario(dto.getComentario())
                .fechaValoracion(LocalDateTime.now())
                .calificacionPuntualidad(dto.getCalificacionPuntualidad())
                .calificacionCalidad(dto.getCalificacionCalidad())
                .calificacionComunicacion(dto.getCalificacionComunicacion())
                .recomendaria(dto.getRecomendaria())
                .build();

        return repository.save(v);
    }

    public List<Valoracion> listarPorTecnico(Long id) {
        return repository.findByIdTecnico(id);
    }

    public List<Valoracion> listarPorCliente(Long id) {
        return repository.findByIdCliente(id);
    }

    public double promedioTecnico(Long idTecnico) {
        List<Valoracion> lista = repository.findByIdTecnico(idTecnico);
        OptionalDouble promedio = lista.stream().mapToInt(Valoracion::getCalificacion).average();
        return promedio.orElse(0);
    }
}
