package com.eoi.nutriplanner.repository;

import com.eoi.nutriplanner.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<Menu> findByCompraId(Long compraId);
}

