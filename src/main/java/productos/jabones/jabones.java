package productos.jabones;

import productos.Producto;

public class Jabon extends Producto {

    public Jabon(String nombre, double precio, int stock) {
        super(nombre, precio, stock);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Categoría: Jabones");
        super.mostrarInfo();
    }
}

