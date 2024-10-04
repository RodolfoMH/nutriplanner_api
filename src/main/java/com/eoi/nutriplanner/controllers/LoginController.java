package com.eoi.nutriplanner.controllers;

import com.eoi.nutriplanner.dto.AuthResponseDTO;
import com.eoi.nutriplanner.models.Usuario;
import com.eoi.nutriplanner.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public AuthResponseDTO login(@RequestBody Usuario usuario) {
        Usuario user = usuarioService.autenticarUsuario(usuario.getEmail(), usuario.getPassword());
        if (user != null) {
            return new AuthResponseDTO(user,"Login exitoso", true);
        } else {
            return new AuthResponseDTO(usuario, "Usuario o contraseña incorrectos", false);
        }
    }
}

