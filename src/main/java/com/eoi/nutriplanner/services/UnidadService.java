package com.eoi.nutriplanner.services;

import com.eoi.nutriplanner.models.Producto;
import com.eoi.nutriplanner.models.Unidad;
import com.eoi.nutriplanner.repository.UnidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnidadService {

    private final UnidadRepository unidadRepository;

    public List<Unidad> obtenerTodasLasUnidades() {
        return unidadRepository.findAll();
    }

    public Unidad guardarUnidad(Unidad unidad) {
        return unidadRepository.save(unidad);
    }

}
