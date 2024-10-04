package com.eoi.nutriplanner.dto;

import com.eoi.nutriplanner.models.Compra;
import com.eoi.nutriplanner.models.DetalleCompra;
import com.eoi.nutriplanner.models.Menu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ListaCompraDTO {

    private Compra compra;
    private List<DetalleCompra> detalles;

    private Menu menu;
}
