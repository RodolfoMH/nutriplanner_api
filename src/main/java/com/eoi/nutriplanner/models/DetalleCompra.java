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
@Table(name = "detalle_compras")
public class DetalleCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_id")
    private Long id;

    @Column(name = "compra_id")
    private Long compraId;

    @Column(name = "producto_id")
    private Long productoId;

    @Column(name = "fecha_vencimiento")
    private LocalDateTime fechaVencimiento;

    @Column(name = "cantidad")
    private Double cantidad;

    @Column(name = "unidad_id")
    private Long unidadId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unidad_id", referencedColumnName = "unidad_id", updatable = false, insertable = false)
    private Unidad unidad;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id", referencedColumnName = "producto_id", updatable = false, insertable = false)
    private Producto producto;

}
