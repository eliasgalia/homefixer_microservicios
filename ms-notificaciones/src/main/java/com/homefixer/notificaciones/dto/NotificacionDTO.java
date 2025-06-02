package com.homefixer.notificaciones.dto;

import com.homefixer.notificaciones.model.Notificacion.TipoNotificacion;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificacionDTO {
    private Long idUsuario;
    private String titulo;
    private String mensaje;
    private TipoNotificacion tipo;
    private String canal;
}