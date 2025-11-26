
package com.usil.model.productos;

import com.usil.model.Producto;

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
