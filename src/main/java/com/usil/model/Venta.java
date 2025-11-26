package com.usil.model;

import com.usil.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Date; // Necesario para registrar la fecha

public class Venta {
    private int id; // Identificador de la venta
    private Date fecha; // Fecha de la venta
    private Usuario cliente; // El vendedor o cliente
    
    // ASOCIACIÓN CRUCIAL 1:N: Reemplaza el HashMap
    private List<DetalleVenta> detalles; 

    public Venta(Usuario cliente) {
        this.id = (int) (Math.random() * 100000); // Generación simple de ID
        this.fecha = new Date();
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
    }

    // Método para agregar la línea de venta (llamado por VentaService)
    // ESTE MÉTODO REEMPLAZA a tu antiguo agregarProducto
    public void agregarDetalle(DetalleVenta detalle) {
        this.detalles.add(detalle);
    }
    
    // Funcionalidad 8: Calcular el total de la venta
    // Este método usa los DetalleVenta para calcular el total
    public double calcularTotal() {
        double total = 0;
        for (DetalleVenta detalle : detalles) {
            total += detalle.calcularSubtotal();
        }
        return total;
    }

    // ELIMINADO: El método 'agregarProducto' (con lógica de Inventario) se movió a VentaService.

    // ELIMINADO: El método 'mostrarVenta' debe moverse a la capa UI o simplificarse.
    // Aunque puedes mantenerlo por ahora, la práctica es que la UI haga la presentación.
    public void mostrarVenta() {
        System.out.println("\n--- Venta ID " + this.id + " ---");
        System.out.println("Vendedor: " + cliente.getNombre());
        System.out.println("Fecha: " + this.fecha);
        double total = 0;

        for (DetalleVenta detalle : detalles) {
            // Usamos los getters de DetalleVenta
            double subtotal = detalle.calcularSubtotal();
            total += subtotal;
            System.out.println(detalle.getProducto().getNombre() + " x" + detalle.getCantidad() + " -> S/." + subtotal);
        }

        System.out.println("Total a pagar: S/." + total);
        System.out.println("------------------------------");
    }
    
    // Getters
    public int getId() { return id; }
    public Date getFecha() { return fecha; }
    public Usuario getCliente() { return cliente; }
    public List<DetalleVenta> getDetalles() { return detalles; }
}
