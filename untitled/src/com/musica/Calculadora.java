package com.musica;

import java.util.Scanner;

/**
 * Clase que representa una calculadora simple.
 * Permite realizar operaciones de suma, resta, multiplicación y división.
 * @author Miguel
 */
public class Calculadora {

    private static final String ERROR_DIVISION_CERO = "División por cero";
    private static final String ERROR_OPERACION_INVALIDA = "⚠️ Error: Operación no válida";

    /**
     * Método principal que ejecuta la calculadora.
     * @param args argumentos linea de comandos
     * @author Miguel
     */
    public static void main(String[] args) {
        // Crear una instancia de la calculadora
        Calculadora calc = new Calculadora();
        // Crear un escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // Mensaje de bienvenida
        String nombre = "Miguel";
        System.out.println("Bienvenido a la Calculadora de " + nombre);
        // Solicitar al usuario la operación a realizar
        System.out.print("Introduce la operación (sumar, restar, multiplicar, dividir): ");
        String operador = scanner.nextLine();
        // Introducir los números a operar
        System.out.print("Introduce el primer número: ");
        int a = scanner.nextInt();

        System.out.print("Introduce el segundo número: ");
        int b = scanner.nextInt();

        try {
            // Realizar la operación
            int resultado = calc.operar(operador, a, b);
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("️Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("️Error: " + e.getMessage());
        }
    }


    /**
     * Realiza la operación indicada entre los dos números dados.
     * @param operador String definido por el usuario que indica la operación a realizar.
     * @param a Número entero a.
     * @param b Número entero b.
     * @return Resultado de la operación.
     * @author Miguel
     */
    public int operar(String operador, int a, int b) {
        // Validar el operador
        Operacion operacion;
        try {
            operacion = Operacion.valueOf(operador.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_OPERACION_INVALIDA);
        }

        // Realizar la operación

        switch (operacion) {
            case SUMAR:
                return a + b;
            case RESTAR:
                return a - b;
            case MULTIPLICAR:
                return a * b;
            case DIVIDIR:
                // Validar división por cero
                if (b == 0) {
                    throw new ArithmeticException(ERROR_DIVISION_CERO);
                }
                return a / b;
            default:
                // Este caso no debería ocurrir debido a la validación anterior
                throw new IllegalArgumentException(ERROR_OPERACION_INVALIDA);
        }
    }
    /**
     * Enum que define las operaciones soportadas por la calculadora.
     */
    private enum Operacion {
        SUMAR, RESTAR, MULTIPLICAR, DIVIDIR
    }
}