package com.usil.util;

import java.io.*;
import java.util.List;
import java.util.function.Function;

/**
 * Gestor genérico para lectura/escritura de archivos con separador ";"
 * Funciona con cualquier tipo de dato
 */
public class GestorArchivos {

    private static final String DIRECTORIO_DATA = "data";

    /**
     * Método GENÉRICO para guardar cualquier tipo de objeto en archivo
     * @param <T> Tipo de objeto a guardar
     * @param nombreArchivo Nombre del archivo (ej: "departamentos.txt")
     * @param lista Lista de objetos a guardar
     * @param serializer Función que convierte objeto a String con formato "campo1;campo2;..."
     */
    public <T> void guardar(String nombreArchivo, List<T> lista, Function<T, String> serializer) {
        try {
            new File(DIRECTORIO_DATA).mkdirs();
            String rutaCompleta = DIRECTORIO_DATA + File.separator + nombreArchivo;

            try (PrintWriter pw = new PrintWriter(new FileWriter(rutaCompleta))) {
                for (T objeto : lista) {
                    String linea = serializer.apply(objeto);
                    pw.println(linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al guardar " + nombreArchivo + ": " + e.getMessage());
        }
    }

    /**
     * Método GENÉRICO para cargar cualquier tipo de objeto desde archivo
     * @param <T> Tipo de objeto a crear
     * @param nombreArchivo Nombre del archivo (ej: "departamentos.txt")
     * @param parser Función que convierte una línea a un objeto
     *               Debe manejar el split por ";" y retornar el objeto creado
     */
    public <T> void cargar(String nombreArchivo, LineParser<T> parser) {
        String rutaCompleta = DIRECTORIO_DATA + File.separator + nombreArchivo;
        File archivo = new File(rutaCompleta);

        if (!archivo.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    T objeto = parser.parse(linea);
                    // El parser se encarga de registrar el objeto en el servicio
                }
            }
        } catch (Exception e) {
            System.err.println("Error al cargar " + nombreArchivo + ": " + e.getMessage());
        }
    }

    /**
     * Sobrecarga para objetos que implementan ArchivoSerializable
     * @param <T> Tipo de objeto que implementa ArchivoSerializable
     * @param nombreArchivo Nombre del archivo
     * @param lista Lista de objetos a guardar
     */
    public <T extends ArchivoSerializable> void guardar(String nombreArchivo, List<T> lista) {
        guardar(nombreArchivo, lista, ArchivoSerializable::toFileLine);
    }
}
