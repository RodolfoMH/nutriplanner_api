package com.eoi.nutriplanner.services;

import com.eoi.nutriplanner.models.Compra;
import com.eoi.nutriplanner.models.DetalleCompra;
import com.eoi.nutriplanner.models.Menu;
import com.eoi.nutriplanner.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Autowired
    private AIService aiService;

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UnidadRepository unidadRepository;

    public Menu obtenerMenuPorCompra(Long compraId) {
        return menuRepository.findByCompraId(compraId).orElse(null);
    }

    public Menu obtenerUltimoMenuUsuario(Long usuarioId){
        List<Compra> compras = compraRepository.findUltimaCompraByUsuarioId(usuarioId, PageRequest.of(0,1));

        System.out.println(compras);

        if(Objects.nonNull(compras) && !compras.isEmpty()){
            System.out.println(compras.get(0).getId());
            return obtenerMenuPorCompra(compras.get(0).getId());
        }

        return null;
    }

    public Menu guardarMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu generarMenuCompra(Long compraId){

        List<DetalleCompra> detalles = detalleCompraRepository.findByCompraId(compraId);
        System.out.println("detalles"+detalles);
        String prompt = createPrompt(detalles);
        System.out.println("Promp=> "+prompt);
        String output = aiService.generate(prompt);

        Menu menuGuardar = new Menu();
        menuGuardar.setCompraId(compraId);
        menuGuardar.setJsonResultado(output);
        menuGuardar.setPromptGenerado(prompt);

        return  guardarMenu(menuGuardar);

    }

    public String createPrompt(List<DetalleCompra> detalles){
        StringBuilder builder = new StringBuilder();

        builder.append("Necesito generar un menú para esta semana basado en los ingredientes que te paso a continuación:");
        builder.append("[");

        for (DetalleCompra detalle:detalles) {
            var producto = productoRepository.findById(detalle.getProductoId()).get();
            var unidad = unidadRepository.findById(detalle.getUnidadId()).get();

            builder.append(
                    """
                    {"Ingrediente":"%s (%s)", "cantidad":"%f %s"},
                    """.formatted(
                            producto.getNombre(),
                            producto.getDescripcion(),
                            detalle.getCantidad(),
                            unidad.getDescripcion()
                    ));
        }
        builder.append("]");

        builder.append("La lista suministrada en formato JSON contiene lo siguiente el nombre del ingrediente ‘ingrediente’ y la cantidad del ingrediente, basado en estos ingredientes quiero que generes un menú para 5 días que abarque el desayuno el almuerzo y la cena, al generar los platos dales prioridad a los ingredientes con una fecha de caducidad mas corta para evitar el desperdicio de estos alimentos agregándolos a los primeros platos de la semana.");

        builder.append("Como salida quiero que el menú de la semana resultante sea devuelto como un JSON con el siguiente formato: ");

        builder.append("""
                [
                    {
                        "dia": "Lunes",
                        "desayuno": {
                            "descripcion": "Nombre de la receta",
                            "ingredientes": ["ingrediente A", "ingrediente B"],
                            "preparacion": "Instrucciones de cómo preparar el plato"
                        },
                        "almuerzo": {
                            "descripcion": "Nombre de la receta",
                            "ingredientes": ["ingrediente A", "ingrediente B"],
                            "preparacion": "Instrucciones de cómo preparar el plato"
                        },
                       "cena": {
                            "descripcion": "Nombre de la receta",
                            "ingredientes": ["ingrediente A", "ingrediente B"],
                            "preparacion": "Instrucciones de cómo preparar el plato"  
                        }
                    },
                    {
                        "dia": "Martes",
                        "desayuno": {
                            "descripcion": "Nombre de la receta",
                            "ingredientes": ["ingrediente A", "ingrediente B"],
                            "preparacion": "Instrucciones de cómo preparar el plato"
                        },
                        "almuerzo": {
                            "descripcion": "Nombre de la receta",
                            "ingredientes": ["ingrediente A", "ingrediente B"],
                            "preparacion": "Instrucciones de cómo preparar el plato"
                        },
                       "cena": {
                            "descripcion": "Nombre de la receta",
                            "ingredientes": ["ingrediente A", "ingrediente B"],
                            "preparacion": "Instrucciones de cómo preparar el plato"
                        
                        }
                    },
                    {
                        "dia": "Miércoles",
                        "desayuno": {
                            "descripcion": "Nombre de la receta",
                            "ingredientes": ["ingrediente A", "ingrediente B"],
                            "preparacion": "Instrucciones de cómo preparar el plato"
                        },
                        "almuerzo": {
                            "descripcion": "Nombre de la receta",
                            "ingredientes": ["ingrediente A", "ingrediente B"],
                            "preparacion": "Instrucciones de cómo preparar el plato"
                        },
                       "cena": {
                            "descripcion": "Nombre de la receta",
                            "ingredientes": ["ingrediente A", "ingrediente B"],
                            "preparacion": "Instrucciones de cómo preparar el plato"
                        
                        }
                    },
                    {
                        "dia": "Jueves",
                        "desayuno": {
                            "descripcion": "Nombre de la receta",
                            "ingredientes": ["ingrediente A", "ingrediente B"],
                            "preparacion": "Instrucciones de cómo preparar el plato"
                        },
                        "almuerzo": {
                            "descripcion": "Nombre de la receta",
                            "ingredientes": ["ingrediente A", "ingrediente B"],
                            "preparacion": "Instrucciones de cómo preparar el plato"
                        },
                       "cena": {
                            "descripcion": "Nombre de la receta",
                            "ingredientes": ["ingrediente A", "ingrediente B"],
                            "preparacion": "Instrucciones de cómo preparar el plato"
                        
                        }
                    },
                    {
                        "dia": "Viernes",
                        "desayuno": {
                            "descripcion": "Nombre de la receta",
                            "ingredientes": ["ingrediente A", "ingrediente B"],
                            "preparacion": "Instrucciones de cómo preparar el plato"
                        },
                        "almuerzo": {
                            "descripcion": "Nombre de la receta",
                            "ingredientes": ["ingrediente A", "ingrediente B"],
                            "preparacion": "Instrucciones de cómo preparar el plato"
                        },
                       "cena": {
                            "descripcion": "Nombre de la receta",
                            "ingredientes": ["ingrediente A", "ingrediente B"],
                            "preparacion": "Instrucciones de cómo preparar el plato"
                        
                        }
                    }
                ]
                                
                """);

        return builder.toString();
    }
}

