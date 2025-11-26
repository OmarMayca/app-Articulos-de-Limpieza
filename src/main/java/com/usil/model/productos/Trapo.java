
package com.usil.model.productos;


import com.usil.model.Producto;

public class Trapo extends Producto {

    public Trapo(String nombre, double precio, int stock) {
        super(nombre, precio, stock);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Categoría: Trapos");
        super.mostrarInfo();
    }
}