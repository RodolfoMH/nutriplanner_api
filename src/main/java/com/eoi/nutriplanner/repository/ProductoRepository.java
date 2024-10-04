package com.eoi.nutriplanner.repository;

import com.eoi.nutriplanner.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Producto findByCodigoBarras(String codigoBarras);
}
