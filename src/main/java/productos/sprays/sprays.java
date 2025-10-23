
package productos.sprays;

import productos.Producto;

public class Spray extends Producto {

    public Spray(String nombre, double precio, int stock) {
        super(nombre, precio, stock);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Categoría: Sprays");
        super.mostrarInfo();
    }
}
