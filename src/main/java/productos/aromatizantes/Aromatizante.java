
package productos.aromatizantes;


import productos.Producto;

public class Aromatizante extends Producto {

    public Aromatizante(String nombre, double precio, int stock) {
        super(nombre, precio, stock);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Categoría: Aromatizantes");
        super.mostrarInfo();
    }
}
