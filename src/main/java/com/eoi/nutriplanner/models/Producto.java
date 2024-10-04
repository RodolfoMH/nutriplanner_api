package com.eoi.nutriplanner.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "productos")
@Getter
@Setter
@ToString
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Long id;

    @Column(name = "nombre_producto")
    private String nombre;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "descripcion_producto")
    private  String descripcion;

    @Column(name = "fuente")
    private String fuente;

}

