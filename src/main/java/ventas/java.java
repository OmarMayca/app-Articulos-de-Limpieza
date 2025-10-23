package ventas;

import productos.Producto;
import usuario.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private Usuario cliente;
    private List<Producto> productos;
    private double total;

    public Venta(Usuario cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.total = 0;
    }

    // Agregar producto a la venta
    public void agregarProducto(Producto p, int cantidad) {
        if (p.getStock() >= cantidad) {
            p.setStock(p.getStock() - cantidad);  // ⚡ Descontar del stock automáticamente
            Producto copia = new Producto(p.getNombre(), p.getPrecio(), cantidad);
            productos.add(copia);
            total += p.getPrecio() * cantidad;
        } else {
            System.out.println("No hay suficiente stock de " + p.getNombre());
        }
    }

    public double getTotal() { return total; }

    public void mostrarVenta() {
        System.out.println("Cliente: " + cliente);
        System.out.println("Productos vendidos:");
        for (Producto p : productos) {
            System.out.println("- " + p.getNombre() + " x " + p.getStock() + " -> S/. " + p.getPrecio());
        }
        System.out.println("TOTAL: S/. " + total);
    }
}
