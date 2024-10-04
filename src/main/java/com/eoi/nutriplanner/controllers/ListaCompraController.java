package com.eoi.nutriplanner.controllers;

import com.eoi.nutriplanner.dto.ListaCompraDTO;
import com.eoi.nutriplanner.services.AIService;
import com.eoi.nutriplanner.services.ListaCompraService;
import com.eoi.nutriplanner.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listas")
public class ListaCompraController {

    @Autowired
    private ListaCompraService listaCompraService;

    @Autowired
    private AIService aiService;

    @Autowired
    private MenuService menuService;


    @GetMapping("/usuario/{usuarioId}")
    public List<ListaCompraDTO> obtenerListasComprasUsuario(@PathVariable Long usuarioId) {
        return listaCompraService.obtenerListasComprasUsuario(usuarioId);
    }

    @PostMapping
    public ListaCompraDTO guardarLista(@RequestBody ListaCompraDTO listaCompra) {
        return listaCompraService.guardarListaCompra(listaCompra);
    }
}

