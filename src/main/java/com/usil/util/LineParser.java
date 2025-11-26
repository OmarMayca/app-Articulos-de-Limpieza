package com.usil.util;

/**
 * Interfaz funcional para parsear líneas de archivo a objetos
 * @param <T> Tipo de objeto a crear
 */
@FunctionalInterface
public interface LineParser<T> {

    /**
     * Convierte una línea de texto a un objeto
     * @param line Línea con formato: campo1;campo2;campo3;...
     * @return Objeto creado desde la línea, o null si hay error
     */
    T parse(String line);
}
