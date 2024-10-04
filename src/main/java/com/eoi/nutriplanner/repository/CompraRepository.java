package com.eoi.nutriplanner.repository;

import com.eoi.nutriplanner.models.Compra;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findByUsuarioId(Long usuarioId);

    @Query("SELECT c FROM Compra c WHERE c.usuarioId = :usuarioId ORDER BY c.id DESC")
    List<Compra> findUltimaCompraByUsuarioId(Long usuarioId, Pageable pageable);
}
