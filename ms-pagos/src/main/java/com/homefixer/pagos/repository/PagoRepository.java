package com.homefixer.pagos.repository;

import com.homefixer.pagos.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByIdCliente(Long idCliente);
    List<Pago> findByIdTecnico(Long idTecnico);
}
