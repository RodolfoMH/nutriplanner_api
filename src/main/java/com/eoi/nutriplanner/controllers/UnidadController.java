package com.eoi.nutriplanner.controllers;

import com.eoi.nutriplanner.models.Unidad;
import com.eoi.nutriplanner.services.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidad")
public class UnidadController {

    @Autowired
    private UnidadService unidadService;

    @GetMapping("/all")
    public List<Unidad> obtenerTodasLasUnidades() {
        return unidadService.obtenerTodasLasUnidades();
    }

    @PostMapping
    public Unidad guardarUnidad(@RequestBody Unidad unidad) {
        return unidadService.guardarUnidad(unidad);
    }
}

