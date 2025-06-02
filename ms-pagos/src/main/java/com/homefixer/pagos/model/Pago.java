package com.homefixer.pagos.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @Column(nullable = false)
    private Long idSolicitud;

    @Column(nullable = false)
    private Long idCliente;

    @Column(nullable = false)
    private Long idTecnico;

    @Column(precision = 10, scale = 2)
    private BigDecimal montoTotal;

    @Column(precision = 10, scale = 2)
    private BigDecimal comisionPlataforma;

    @Column(precision = 10, scale = 2)
    private BigDecimal pagoTecnico;

    @Enumerated(EnumType.STRING)
    private EstadoPago estado;

    private String metodoPago;
    private LocalDateTime fechaPago;

    public enum EstadoPago {
        PENDIENTE, PROCESADO, COMPLETADO, FALLIDO
    }
}
