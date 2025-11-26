package com.usil.util;

/**
 * Interfaz para objetos que pueden ser serializados a archivos de texto
 * con formato delimitado por punto y coma (;)
 */
public interface ArchivoSerializable {

    /**
     * Convierte el objeto a una línea de texto con campos separados por ";"
     * @return String con formato: campo1;campo2;campo3;...
     */
    String toFileLine();
}
