
package com.usil.model.productos;

import com.usil.model.Producto;

public class Papel extends Producto {

    public Papel(String nombre, double precio, int stock) {
        super(nombre, precio, stock);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Categoría: Papeles");
        super.mostrarInfo();
    }
}
