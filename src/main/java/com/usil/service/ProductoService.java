package com.usil.service;

import com.usil.model.Producto; // Importamos la entidad (Model)
import java.util.ArrayList;
import java.util.List;

public class ProductoService {
    
    // Lista de productos: El inventario reside aquí.
    private List<Producto> productos; 

    public ProductoService() {
        this.productos = new ArrayList<>();
    }

    // Funcionalidad 1: Registrar un nuevo producto
    public void agregarProducto(Producto p) {
        productos.add(p);
        // En una aplicación real, agregarías validaciones aquí (ej: código único).
    }
    
    // Funcionalidad 4: Listar todos los productos
    public List<Producto> obtenerTodos() {
        return productos;
    }
    
    // Funcionalidad 6: Consultar producto por nombre
    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null; // no encontrado
    }
    
    // Funcionalidad 5: Actualizar el stock (usado en las ventas)
    public boolean actualizarStock(String nombre, int cantidad) {
        Producto p = buscarProductoPorNombre(nombre);
        if (p != null) {
            if (p.getStock() >= cantidad) {
                p.setStock(p.getStock() - cantidad);
                return true; // Venta exitosa (stock actualizado)
            } else {
                System.out.println("⚠️ Error: Stock insuficiente para " + nombre);
                return false;
            }
        } else {
            System.out.println("❌ Error: Producto no encontrado: " + nombre);
            return false;
        }
    }
    
    // ... Agregar aquí eliminarProducto y editarProducto (Func. 2 y 3)
}
