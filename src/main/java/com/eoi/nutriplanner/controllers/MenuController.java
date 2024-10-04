package com.eoi.nutriplanner.controllers;

import com.eoi.nutriplanner.models.Menu;
import com.eoi.nutriplanner.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/{compraId}")
    public Menu obtenerMenusPorCompra(@PathVariable Long compraId) {
        return menuService.obtenerMenuPorCompra(compraId);
    }

    @GetMapping("/ultimomenu/{usuarioId}")
    public Menu obtenerUltimoMenuPorUsuario(@PathVariable Long usuarioId) {
        return menuService.obtenerUltimoMenuUsuario(usuarioId);
    }

    @PostMapping
    public Menu guardarMenu(@RequestBody Menu menu) {
        return menuService.guardarMenu(menu);
    }
}

