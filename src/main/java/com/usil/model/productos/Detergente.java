
package com.usil.model.productos;


import com.usil.model.Producto;

public class Detergente extends Producto {

    public Detergente(String nombre, double precio, int stock) {
        super(nombre, precio, stock);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Categoría: Detergentes");
        super.mostrarInfo();
    }
}
