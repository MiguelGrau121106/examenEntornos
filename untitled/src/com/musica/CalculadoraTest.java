package com.musica;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class CalculadoraTest {


    @Test
    public void probarSuma(){
        String operacion = "sumar";
        int a = 2;
        int b = 3;
        Calculadora calculadora = new Calculadora();
        assertEquals(5, calculadora.operar(operacion, a, b));
    }

    @Test
    public void probarResta(){
        String operacion = "restar";
        int a = 5;
        int b = 3;
        Calculadora calculadora = new Calculadora();
        assertEquals(2, calculadora.operar(operacion, a, b));
    }

    @Test
    public void probarMultiplicacion(){
        String operacion = "multiplicar";
        int a = 2;
        int b = 3;
        Calculadora calculadora = new Calculadora();
        assertEquals(6, calculadora.operar(operacion, a, b));
    }

    @Test
    public void probarDivision(){
        String operacion = "dividir";
        int a = 6;
        int b = 3;
        Calculadora calculadora = new Calculadora();
        assertEquals(2, calculadora.operar(operacion, a, b));
    }

    @Test
    public void probarDivisionPorCero(){
        String operacion = "dividir";
        int a = 6;
        int b = 0;
        Calculadora calculadora = new Calculadora();
        try {
            calculadora.operar(operacion, a, b);
        } catch (ArithmeticException e) {
            assertEquals("División por cero", e.getMessage());
        }
    }

    @Test
    public void probarOperacionInvalida(){
        String operacion = "aaaa";
        int a = 6;
        int b = 3;
        Calculadora calculadora = new Calculadora();
        assertEquals(0, calculadora.operar(operacion, a, b));
    }

}
