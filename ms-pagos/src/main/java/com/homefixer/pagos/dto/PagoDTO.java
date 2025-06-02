package com.homefixer.pagos.dto;

import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoDTO {
    private Long idSolicitud;
    private Long idCliente;
    private Long idTecnico;
    private BigDecimal montoTotal;
    private String metodoPago;
}
