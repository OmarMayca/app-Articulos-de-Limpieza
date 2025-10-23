package inventario;

import java.util.ArrayList;
import productos.Producto;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    // Agregar un producto al inventario
    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    // Mostrar todos los productos
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }

        System.out.println("\n--- Inventario ---");
        for (Producto p : productos) {
            p.mostrarInfo();
            System.out.println("------------------");
        }
    }

    // Buscar un producto por nombre
    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null; // no encontrado
    }

    // Actualizar stock al vender
    public boolean actualizarStock(String nombre, int cantidad) {
        Producto p = buscarProducto(nombre);
        if (p != null) {
            if (p.getStock() >= cantidad) {
                p.setStock(p.getStock() - cantidad);
                return true; // venta exitosa
            } else {
                System.out.println("Stock insuficiente para " + nombre);
                return false; // no hay suficiente stock
            }
        } else {
            System.out.println("Producto no encontrado: " + nombre);
            return false; // producto no existe
        }
    }
}