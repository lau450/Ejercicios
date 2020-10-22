/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedabinaria;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lauta
 */
public class Solucion {

    static int contador = 0;
    static int acumulador = 0;

    public static void main(String[] args) {

        Random r = new Random();
        int base = 0;

        // genero intancia de array de 10 elementos, por defecto serán todos 0
        int[] arrayNumeros = new int[1000];

        // asigno a cada posición un valor aleatorio creciente
        for (int i = 0; i < arrayNumeros.length; i++) {
            arrayNumeros[i] = base + r.nextInt(1000) + 1;
            base = arrayNumeros[i];
        }

        // llamo al método para imprimir el array
        imprimirArray(arrayNumeros);

        Scanner s = new Scanner(System.in);
        String ingresoUsuario;

        do {
            System.out.println("Ingrese un número para buscar o q para salir:");
            ingresoUsuario = s.nextLine();

            if (!ingresoUsuario.equals("q")) {
                try {
                    int numero = Integer.parseInt(ingresoUsuario);

                    int indicem1 = busquedaBinaria(arrayNumeros, numero);
                    int indicem2 = busquedaSecuencial(arrayNumeros, numero);

                    Instant iInicio = Instant.now();
                    int indicem10 = busquedaBinaria(arrayNumeros, numero);
                    Instant iFin = Instant.now();
                    System.out.println("Busqueda binaria tardo: " + Duration.between(iInicio, iFin));

                    iInicio = Instant.now();
                    int indicem20 = busquedaSecuencial(arrayNumeros, numero);
                    iFin = Instant.now();
                    System.out.println("Busqueda secuencial tardo: " + Duration.between(iInicio, iFin));

                    if (indicem1 != indicem2) // algo no está bien
                    {
                        System.out.println("Chequear algoritmos!!!");
                    } else if (indicem1 != -1) // el número no está en el array
                    {
                        System.out.println("El número " + numero + " se encuentra en la posición: " + indicem1);
                    } else // el número está en el array
                    {
                        System.out.println("El número " + numero + " no se encuentra en el array.");
                    }

                } catch (Exception e) {
                    System.out.println("No es una opción valida...");
                }
            }
        } while (!ingresoUsuario.equals("q"));

        s.close();
        System.out.println("Bye!");

    }

    /**
     * Método que imprime por consola el array para visualizar los números
     * generados aleatoriamente en cada posición.
     *
     * @param array el array a imprimir
     */
    public static void imprimirArray(int[] array) {
        System.out.println("Array generado:");
        System.out.println("[");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Posición " + i + ": " + array[i] + ",");
        }
        System.out.println("]");
    }

    /**
     * Método que búsca un valor dentro de un array iterando secuencialmente en
     * el array desde 0 a n-1
     *
     * @param array
     * @param valor
     * @return devuelve la posición en en array donde se encuentra valor o -1 si
     * valor no se encuentra en el array
     */
    public static int busquedaSecuencial(int[] array, int valor) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                return i;
            }
            contadorSecuencial(valor);
        }
        return -1;
    }

    /**
     * Método que búsca un valor dentro de un array implementando el algoritmo
     * de búsqueda binaria
     *
     * @param array
     * @param valor
     * @return devuelve la posición en en array donde se encuentra valor o -1 si
     * valor no se encuentra en el array
     */
    public static int busquedaBinaria(int[] array, int valor) {

        int desde = 0;
        int hasta = array.length - 1;
        int medio;

        while (desde <= hasta) {
            medio = (desde + hasta) / 2;
            System.out.println(
                    "Desde: " + desde + " Hasta: " + hasta + " Medio: " + medio + " Valor medio:" + array[medio]);

            if (array[medio] == valor) {
                return medio;
            } else if (array[medio] > valor) {
                // buscar a la izquierda, modificamos hasta = medio -1 (desde queda igual)
                hasta = medio - 1;
            } else {
                // buscar a la derecha, modificamos desde=medio +1 (hasta queda igual)
                desde = medio + 1;
            }
            contadorBinario(valor);
        }
        return -1;

    }

    public static void contadorBinario(int a) {
        
        if (a != 0) {
            contador++;
            acumulador = acumulador + contador;
            System.out.println("Veces que se hizo la comparacion de manera binaria " + acumulador);

        }

    }

    public static void contadorSecuencial(int a) {

        if (a != 0) {
            contador = contador + 1;
            acumulador = acumulador + contador;
            System.out.println("Veces que se hizo la comparacion de manera secuencial " + acumulador);
        }

    }
}
