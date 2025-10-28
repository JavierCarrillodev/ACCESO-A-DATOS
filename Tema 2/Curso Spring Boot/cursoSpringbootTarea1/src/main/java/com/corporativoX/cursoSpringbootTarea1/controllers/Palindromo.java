package com.corporativoX.cursoSpringbootTarea1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para verificar palíndromos.
 */
@RestController
public class Palindromo {

    /**
     *
     * @param palabra
     * @return
     */
    @GetMapping("/validar-palindromo/{palabra}")
    public String palindromo(@PathVariable String palabra){
        String palabraInvertida = new StringBuilder(palabra).reverse().toString();

        if (palabraInvertida.equalsIgnoreCase(palabra)){
            return "La palabra " + palabra + " es " +  "palindromo";
        }else {
            return "La palabra " + palabra + " no es " +  "palindromo";
        }

    }
}
