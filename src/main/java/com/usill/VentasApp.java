package com.usil;

import com.usil.service.ProductoService;
import com.usil.service.VentaService;
import com.usil.service.UsuarioService;
import com.usil.model.productos.*; 

public class VentasApp {
    
    public static void main(String[] args) {
        
        System.out.println("=====================================");
        System.out.println("    INICIANDO SISTEMA DE VENTAS USIL ");
        System.out.println("=====================================");

        // 1. Instanciar Servicios (Capa de Lógica de Negocio)
        ProductoService productoService = new ProductoService();
        // VentaService es dependiente de ProductoService (necesita acceso al inventario).
        VentaService ventaService = new VentaService(productoService); 
        UsuarioService usuarioService = new UsuarioService(); 

        // 2. Inicializar Datos (Cargar productos iniciales)
        inicializarDatos(productoService);
        
        System.out.println("\nSistema listo. Llamando al Menú Principal...");
        
        // 3. Ejecutar la UI
        // FrmMenuPrincipal menu = new FrmMenuPrincipal(productoService, ventaService, usuarioService);
        // menu.iniciar(); 
    }

    /**
     * Carga todos los productos iniciales en el ProductoService.
     */
    private static void inicializarDatos(ProductoService ps) {
        
        // --- PAPEL HIGIÉNICO ---
        ps.agregarProducto(new PapelNoble());
        ps.agregarProducto(new PapelElite());
        ps.agregarProducto(new PapelParacas());
        ps.agregarProducto(new PapelSuave());

        // --- TRAPOS ---
        ps.agregarProducto(new TrapoGrande());
        ps.agregarProducto(new TrapoPequeno());

        // --- SPRAYS ---
        ps.agregarProducto(new SprayMataArania());
        ps.agregarProducto(new SprayMataCucaracha());
        ps.agregarProducto(new SprayMataPolilla());
        ps.agregarProducto(new SprayMataPulga());

        // --- AROMATIZANTES ---
        ps.agregarProducto(new AromatizanteGlade());
        ps.agregarProducto(new AromatizanteSapolio());

        // --- DETERGENTES ---
        ps.agregarProducto(new DetergenteBolivar());
        ps.agregarProducto(new DetergenteOpal());
        ps.agregarProducto(new DetergentePatito());
        ps.agregarProducto(new DetergenteSapolio());

        // --- JABONES ---
        ps.agregarProducto(new JabonNeko());
        ps.agregarProducto(new JabonPalmolive());
        ps.agregarProducto(new JabonRomeo());
        ps.agregarProducto(new JabonSpa());
        
        System.out.println("Inventario cargado con " + ps.obtenerTodos().size() + " productos.");
    }
}
