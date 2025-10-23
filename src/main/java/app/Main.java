package app;

import java.util.Scanner;
import inventario.Inventario;
import usuario.Usuario;
import ventas.Venta;
import productos.Producto;

// Importar todos los productos
import productos.papeles.*;
import productos.jabones.*;
import productos.detergentes.*;
import productos.aromatizantes.*;
import productos.sprays.*;
import productos.trapos.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Crear inventario y agregar productos ---
        Inventario inventario = new Inventario();

        // Papeles
        inventario.agregarProducto(new PapelNoble());
        inventario.agregarProducto(new PapelElite());
        inventario.agregarProducto(new PapelParacas());
        inventario.agregarProducto(new PapelSuave());

        // Jabones
        inventario.agregarProducto(new JabonPalmolive());
        inventario.agregarProducto(new JabonNeko());
        inventario.agregarProducto(new JabonRomeo());
        inventario.agregarProducto(new JabonSpa());

        // Detergentes
        inventario.agregarProducto(new DetergenteBolivar());
        inventario.agregarProducto(new DetergenteOpal());
        inventario.agregarProducto(new DetergentePatito());
        inventario.agregarProducto(new DetergenteSapolio());

        // Aromatizantes
        inventario.agregarProducto(new AromatizanteGlade());
        inventario.agregarProducto(new AromatizanteSapolio());

        // Sprays
        inventario.agregarProducto(new SprayMataArania());
        inventario.agregarProducto(new SprayMataCucaracha());
        inventario.agregarProducto(new SprayMataPolilla());
        inventario.agregarProducto(new SprayMataPulga());

        // Trapos
        inventario.agregarProducto(new TrapoGrande());
        inventario.agregarProducto(new TrapoPequeno());

        // --- Crear usuario de prueba ---
        Usuario cliente = new Usuario("Juan Perez", "12345678");

        // --- Menú interactivo ---
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Mostrar inventario completo");
            System.out.println("2. Consultar producto por nombre");
            System.out.println("3. Realizar venta");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    inventario.mostrarProductos();
                    break;

                case 2:
                    System.out.print("Ingrese nombre del producto: ");
                    String nombre = sc.nextLine();
                    Producto p = inventario.buscarProducto(nombre);
                    if (p != null) p.mostrarInfo();
                    else System.out.println("Producto no encontrado");
                    break;

                case 3:
                    Venta venta = new Venta(cliente);
                    boolean seguir = true;
                    while (seguir) {
                        System.out.print("Producto a vender: ");
                        String nomVenta = sc.nextLine();
                        System.out.print("Cantidad: ");
                        int cantidad = sc.nextInt();
                        sc.nextLine();

                        venta.agregarProducto(inventario, nomVenta, cantidad);

                        System.out.print("¿Vender otro producto? (s/n): ");
                        String resp = sc.nextLine();
                        if (!resp.equalsIgnoreCase("s")) seguir = false;
                    }
                    venta.mostrarVenta();
                    break;

                case 4:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }

        sc.close();
    }
}
