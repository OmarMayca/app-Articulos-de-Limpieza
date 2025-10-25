package ventas;

import inventario.Inventario;
import productos.Producto;
import usuario.Usuario;
import java.util.ArrayList;
import java.util.HashMap;

public class Venta {
    private Usuario cliente;
    private HashMap<Producto, Integer> productosVendidos; 

    public Venta(Usuario cliente) {
        this.cliente = cliente;
        this.productosVendidos = new HashMap<>();
    }

    // Agregar producto a la venta
    public void agregarProducto(Inventario inventario, String nombreProducto, int cantidad) {
        Producto p = inventario.buscarProducto(nombreProducto);
        if (p != null) {
            if (inventario.actualizarStock(nombreProducto, cantidad)) {
                
                productosVendidos.put(p, productosVendidos.getOrDefault(p, 0) + cantidad);
                System.out.println("Producto agregado: " + nombreProducto + " x" + cantidad);
            } else {
                System.out.println("No se pudo agregar el producto. Stock insuficiente.");
            }
        } else {
            System.out.println("Producto no encontrado: " + nombreProducto);
        }
    }

    // Mostrar detalles de la venta
    public void mostrarVenta() {
        System.out.println("\n--- Venta de " + cliente.getNombre() + " ---");
        double total = 0;

        for (Producto p : productosVendidos.keySet()) {
            int cantidad = productosVendidos.get(p);
            double subtotal = p.getPrecio() * cantidad;
            total += subtotal;
            System.out.println(p.getNombre() + " x" + cantidad + " -> S/." + subtotal);
        }

        System.out.println("Total a pagar: S/." + total);
        System.out.println("------------------------------");
    }
}
