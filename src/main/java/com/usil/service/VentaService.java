package com.usil.service;

import com.usil.model.Venta;
import com.usil.model.DetalleVenta;
import com.usil.model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class VentaService {
    private List<Venta> registroVentas;
    
    // Dependencia: VentaService necesita usar ProductoService para el stock.
    private ProductoService productoService; 

    public VentaService(ProductoService ps) {
        this.registroVentas = new ArrayList<>();
        this.productoService = ps; 
    }

    // Funcionalidad 7: Registrar una Venta completa
    public Venta registrarVenta(List<DetalleVenta> detallesVenta, Usuario vendedor) {
        Venta nuevaVenta = new Venta(vendedor);
        
        for (DetalleVenta detalle : detallesVenta) {
            
            // Lógica de negocio: VentaService llama a ProductoService para actualizar stock
            boolean stockActualizado = productoService.actualizarStock(
                detalle.getProducto().getNombre(), detalle.getCantidad());
            
            if (stockActualizado) {
                // Si el stock fue actualizado, agregamos el detalle a la venta
                nuevaVenta.agregarDetalle(detalle);
            }
        }

        // Si se pudo registrar al menos un producto, la venta es válida.
        if (!nuevaVenta.getDetalles().isEmpty()) {
            registroVentas.add(nuevaVenta);
            return nuevaVenta;
        }
        return null; 
    }
    
    // ... Aquí irían los métodos de reportes (Funcionalidades 10 y 11)
    public List<Venta> obtenerTodasLasVentas() {
        return registroVentas;
    }
}
