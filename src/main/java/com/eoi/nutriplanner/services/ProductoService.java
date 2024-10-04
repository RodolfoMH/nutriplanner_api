package com.eoi.nutriplanner.services;

import com.eoi.nutriplanner.models.Producto;
import com.eoi.nutriplanner.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto findByCodigoBarras(String codigoBarras){
        return  productoRepository.findByCodigoBarras(codigoBarras);
    }
}
