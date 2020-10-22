/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedabinaria;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lauta
 */
public class BusquedaBinaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Random r = new Random();
        int base = 0;

        // genero intancia de array de 10 elementos, por defecto serán todos 0
        int[] arrayNumeros = new int[10];

        // asigno a cada posición un valor aleatorio creciente
        for (int i = 0; i < arrayNumeros.length; i++) {
            arrayNumeros[i] = base + r.nextInt(10) + 1;
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
        for (int i = 0; i < array.length; i++) {
            System.out.println(" | " + Arrays.toString(array) + " | ");
        }

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
    public static int busquedaBinaria(int[] array, int valor) {

        int total = array.length;
        int medio = total / 2;
        int desde = 0;
        int hasta = total;

        while (desde <= hasta) {
            if (array[medio] == valor) {
                return medio;
            } else if (array[medio] < valor) {
                desde = medio + 1;

            } else if (array[medio] > valor) {
                hasta = medio - 1;

            }

            return -1;
        }
        /**
         * Método que búsca un valor dentro de un array implementando el
         * algoritmo de búsqueda binaria
         *
         * @param array
         * @param valor
         * @return devuelve la posición en en array donde se encuentra valor o
         * -1 si valor no se encuentra en el array
         */
        
    public static int busquedaSecuencial(int[] array, int valor) {

        for (int i = 0; i < array.length; i++) {
            if (valor == i) {
                return valor;
            } else {
                return -1;
            }
        }

        return -1;

    }

}
