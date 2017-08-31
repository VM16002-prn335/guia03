/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.prn335.guia03;

import javax.ejb.LocalBean;

/**
 *
 * @author bryan
 */
@LocalBean
public class Utilities {

    /**
     * Este metodo sirve sirve para hacer un resumen de un texto, retornando las
     * primeras 20 letras.
     *
     * @param texto En esta variable se espera recibir un texto.
     * @return Devolvera las primeras 20 letras de el texto.
     */
    public static String getResume(String texto) {
        String cadena = "";
        if (texto == null) {
            return null;
        } else {
            if (texto.length() > 20) {
                for (int i = 0; i < 20; i++) {
                    cadena += String.valueOf(texto.charAt(i));
                }
                return cadena;
            } else {
                return texto;
            }
        }
    }

    /**
     * Este metodo sirve para convertir los espacios dobles en espacios simples
     * y capitalizar las palabras.
     *
     * @param texto En esta variable se espera recibir un texto.
     * @return Retornara el mismo texto, pero con espacios simples y palabras
     * capitalizadas.
     */
    public static String capitalizar(String texto) {
        String salida;

        if (texto != null) {
            for (int i = 0; i < texto.length(); i++) {
                texto = texto.replaceAll("  ", " ");
            }

            texto = texto.toLowerCase();
            salida = String.valueOf(texto.charAt(0)).toUpperCase();
            for (int i = 1; i < texto.length(); i++) {
                if (texto.charAt(i - 1) == ' ' && texto.charAt(i) != ' ') {
                    salida += String.valueOf(texto.charAt(i)).toUpperCase();
                } else {
                    salida += texto.charAt(i);
                }

            }
            return salida;
        } else {
            return null;
        }
    }

    /**
     * Este metodo sirve para buscar concidencias en un texto.
     *
     * @param frase En esta variable se espera recibir una frase o una palabra
     * para buscar en el texo ingresado.
     * @param texto En esta variable se espera recibir un texto.
     * @return Retornara el numero de veces que aparecera la frase en el texto.
     */
    public static int contarCoincidencias(String frase, String texto) {
        int cantidad = 0, niv = 0, ct1, ct2;
        if (texto != null) {
            String busqueda;
            if (frase.length() < texto.length()) {
                for (ct1 = frase.length(); ct1 <= texto.length(); ct1++, niv++) {
                    busqueda = "";
                    for (ct2 = 0 + niv; ct2 < frase.length() + niv; ct2++) {
                        busqueda += String.valueOf(texto.charAt(ct2));
                    }
                    if (frase.equalsIgnoreCase(busqueda)) {
                        cantidad++;
                    }
                }

            } else {
                cantidad = 0;
            }
            return cantidad;
        } else {
            return 0;
        }
    }
}
