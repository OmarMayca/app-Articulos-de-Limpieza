package app;

import java.util.Scanner;
import inventario.Inventario;
import usuario.Usuario;
import ventas.Venta;
import productos.Producto;

// Importar todos los productos (se asume que existen, solo incluimos un ejemplo)
import productos.papeles.PapelNoble;
// ... (Otras clases de producto deben existir en sus respectivos paquetes)

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Solicitud de datos del usuario (Nuevo código) ---
        System.out.println("=====================================");
        System.out.println("         INICIO DE SISTEMA           ");
        System.out.println("=====================================");
        
        System.out.print("Ingrese su Nombre Completo: ");
        String nombreCliente = sc.nextLine();

        System.out.print("Ingrese su DNI: ");
        String dniCliente = sc.nextLine();

        // --- Crear el objeto Usuario con los datos ingresados ---
        Usuario cliente = new Usuario(nombreCliente, dniCliente);
        System.out.println("\nBienvenido al sistema, " + cliente.getNombre() + "!");
        
        // --- Crear inventario y agregar productos ---
        Inventario inventario = new Inventario();

        // Papeles
        inventario.agregarProducto(new PapelNoble());
        // Puedes agregar más productos aquí si creas sus clases correspondientes, e.g.:
        // inventario.agregarProducto(new JabonPalmolive()); 
        // inventario.agregarProducto(new DetergenteBolivar()); 
        // inventario.agregarProducto(new TrapoGrande()); 

        // --- Menú interactivo ---
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Mostrar inventario completo");
            System.out.println("2. Consultar producto por nombre");
            System.out.println("3. Realizar venta");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            
            int opcion = -1;
            try {
                opcion = sc.nextInt();
            } catch (Exception e) {
                // Manejar error si el usuario no ingresa un número
                System.out.println("Error: Por favor, ingrese un número válido.");
            }
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
                    System.out.println("\n--- INICIANDO VENTA PARA " + cliente.getNombre() + " ---");
                    boolean seguir = true;
                    
                    while (seguir) {
                        System.out.print("Producto a vender (o 'fin' para terminar): ");
                        String nomVenta = sc.nextLine();
                        
                        if (nomVenta.equalsIgnoreCase("fin")) {
                            seguir = false;
                            continue;
                        }

                        System.out.print("Cantidad: ");
                        int cantidad = -1;
                        try {
                            cantidad = sc.nextInt();
                        } catch (Exception e) {
                             System.out.println("Error: Por favor, ingrese una cantidad válida.");
                        }
                        sc.nextLine(); // limpiar buffer

                        if (cantidad > 0) {
                            venta.agregarProducto(inventario, nomVenta, cantidad);
                        }
                        
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
                    if(opcion != -1) {
                         System.out.println("Opción inválida");
                    }
            }
        }

        sc.close();
    }
}

