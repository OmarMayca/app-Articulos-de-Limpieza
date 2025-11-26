package com.usil.model;

public class DetalleVenta {
    
    private Producto producto; 
    private int cantidad;
    private double precioUnitario; 

    public DetalleVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = producto.getPrecio(); 
    }

    public double calcularSubtotal() {
        return this.precioUnitario * this.cantidad;
    }

    // ===================================================
    // Implementación de Getters (lo que faltaba y causaba el error)
    // ===================================================
    public Producto getProducto() { 
        return producto; 
    }
    
    public int getCantidad() { 
        return cantidad; 
    }
    
    public double getPrecioUnitario() { 
        return precioUnitario; 
    }
}