package com.eoi.nutriplanner.controllers;

import com.eoi.nutriplanner.models.Producto;
import com.eoi.nutriplanner.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/all")
    public List<Producto> obtenerTodosLosProductos() {
        return productoService.obtenerTodosLosProductos();
    }

    @GetMapping
    public Producto findByBarcode(@RequestParam("barcode") String codigoBarras) {
        return productoService.findByCodigoBarras(codigoBarras);
    }

    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }
}

