package com.homefixer.notificaciones.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notificaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacion;

    @Column(nullable = false)
    private Long idUsuario;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 1000)
    private String mensaje;

    @Enumerated(EnumType.STRING)
    private TipoNotificacion tipo;

    private Boolean leida;
    private LocalDateTime fechaEnvio;
    private String canal;

    public enum TipoNotificacion {
        SOLICITUD, PAGO, PROMOCION, EMERGENCIA, VALORACION
    }
}