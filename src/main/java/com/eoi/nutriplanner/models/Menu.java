package com.eoi.nutriplanner.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity(name = "menus")
@Setter
@Getter
@ToString
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long id;

    @Column(name = "compra_id")
    private Long compraId;

    @Column(name="prompt_generado")
    private String promptGenerado;

    @Column(name = "json_resultado")
    private String jsonResultado;
}
