package com.homefixer.valoraciones.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "valoraciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idValoracion;

    @Column(nullable = false)
    private Long idSolicitud;

    @Column(nullable = false)
    private Long idCliente;

    @Column(nullable = false)
    private Long idTecnico;

    @Column(nullable = false)
    private Integer calificacion;

    @Column(length = 500)
    private String comentario;

    private LocalDateTime fechaValoracion;
    private Integer calificacionPuntualidad;
    private Integer calificacionCalidad;
    private Integer calificacionComunicacion;
    private Boolean recomendaria;
}
