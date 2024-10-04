package com.eoi.nutriplanner.dto;

import com.eoi.nutriplanner.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AuthResponseDTO {
    private Usuario usuario;
    private String mensaje;
    private Boolean success;
}
