package inventario;

import modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    // Agregar producto al inventario
    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    // Mostrar todos los productos
    public void mostrarProductos() {
        System.out.println("Inventario:");
        for (Producto p : productos) {
            p.mostrarInfo();
        }
    }

    // Buscar producto por nombre
    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    // Descontar stock al vender
    public boolean venderProducto(String nombre, int cantidad) {
        Producto p = buscarProducto(nombre);
        if (p != null && p.getStock() >= cantidad) {
            p.setStock(p.getStock() - cantidad);
            return true;
        } else {
            System.out.println("No hay suficiente stock de " + nombre);
            return false;
        }
    }
}
