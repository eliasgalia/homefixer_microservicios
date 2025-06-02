package com.homefixer.pagos.service;

import com.homefixer.pagos.dto.PagoDTO;
import com.homefixer.pagos.model.Pago;
import com.homefixer.pagos.model.Pago.EstadoPago;
import com.homefixer.pagos.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PagoService {
    private final PagoRepository repository;

    public Pago procesarPago(PagoDTO dto) {
        log.info("✅ Procesando pago para solicitud {}", dto.getIdSolicitud());

        BigDecimal comision = dto.getMontoTotal().multiply(new BigDecimal("0.10"));
        BigDecimal pagoTecnico = dto.getMontoTotal().subtract(comision);

        Pago pago = Pago.builder()
                .idSolicitud(dto.getIdSolicitud())
                .idCliente(dto.getIdCliente())
                .idTecnico(dto.getIdTecnico())
                .montoTotal(dto.getMontoTotal())
                .comisionPlataforma(comision)
                .pagoTecnico(pagoTecnico)
                .estado(EstadoPago.PROCESADO)
                .metodoPago(dto.getMetodoPago())
                .fechaPago(LocalDateTime.now())
                .build();

        return repository.save(pago);
    }

    public List<Pago> historialCliente(Long idCliente) {
        return repository.findByIdCliente(idCliente);
    }

    public List<Pago> ingresosTecnico(Long idTecnico) {
        return repository.findByIdTecnico(idTecnico);
    }

    public List<Pago> listar() {
        return repository.findAll();
    }
}
