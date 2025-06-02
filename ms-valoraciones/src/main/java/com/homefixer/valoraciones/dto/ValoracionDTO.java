package com.homefixer.valoraciones.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValoracionDTO {
    private Long idSolicitud;
    private Long idCliente;
    private Long idTecnico;
    private Integer calificacion;
    private String comentario;
    private Integer calificacionPuntualidad;
    private Integer calificacionCalidad;
    private Integer calificacionComunicacion;
    private Boolean recomendaria;
}
