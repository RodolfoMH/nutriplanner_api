package com.eoi.nutriplanner.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compra_id")
    private Long id;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "fecha_compra")
    private LocalDateTime fechaCompra;

    @Column(name = "estado")
    private String estado;

}
