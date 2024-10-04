package com.eoi.nutriplanner.services;

import com.eoi.nutriplanner.dto.ListaCompraDTO;
import com.eoi.nutriplanner.models.Compra;
import com.eoi.nutriplanner.models.DetalleCompra;
import com.eoi.nutriplanner.repository.CompraRepository;
import com.eoi.nutriplanner.repository.DetalleCompraRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListaCompraService {

    private final CompraRepository compraRepository;
    private final DetalleCompraRepository detalleCompraRepository;

    private final MenuService menuService;

    public List<ListaCompraDTO> obtenerListasComprasUsuario(Long usuarioId){

        List<ListaCompraDTO> listadoCompras = new ArrayList<>();
        List<Compra> compras = compraRepository.findByUsuarioId(usuarioId);

        for (Compra compra:compras){
            var detalles = detalleCompraRepository.findByCompraId(compra.getId());
            var menu = menuService.obtenerMenuPorCompra(compra.getId());
            listadoCompras.add(new ListaCompraDTO(compra,detalles,menu));
        }

        return listadoCompras;
    }

    public ListaCompraDTO guardarListaCompra(ListaCompraDTO listaCompraDTO){
        Compra compraGuardada = compraRepository.save(listaCompraDTO.getCompra());

        for (DetalleCompra detalle:listaCompraDTO.getDetalles()){
            detalle.setCompraId(compraGuardada.getId());
            detalleCompraRepository.save(detalle);
        }

        listaCompraDTO.getCompra().setId(compraGuardada.getId());

        var menu = menuService.generarMenuCompra(compraGuardada.getId());
        System.out.println(menu);

        return listaCompraDTO;
    }

}

