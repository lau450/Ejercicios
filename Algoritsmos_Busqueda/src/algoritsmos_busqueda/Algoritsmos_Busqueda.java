/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritsmos_busqueda;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lauta
 */
public class Algoritsmos_Busqueda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Random r = new Random();
        int base = 0;
        int n = 500000;
        // genero intancia de array de 10 elementos, por defecto serán todos 0
        int[] arrayNumeros = new int[n];
        int[] prueba = new int[5];

        prueba[0] = 20;
        prueba[1] = 4;
        prueba[2] = 1;
        prueba[3] = 8;
        prueba[4] = 12;
        prueba[5] = 10;

        System.out.println(prueba);

        // asigno a cada posición un valor aleatorio creciente
        /*
         * for (int i = 0; i < arrayNumeros.length; i++) { arrayNumeros[i] = base +
         * r.nextInt(10) + 1; base = arrayNumeros[i]; }
         */
        // cambio a asignarlos desordenados para usar los métodos de ordenamiento
        // implementados
        for (int i = 0; i < arrayNumeros.length; i++) {
            arrayNumeros[i] = r.nextInt(1000000) + 1;

        }
        // llamo al método para imprimir el array
        // imprimirArray(arrayNumeros);

        Instant iInicio;
        Instant iFin;

        System.out.println("Ordenando " + n + " elementos...");

        // SELECTION SORT
        int array[] = arrayNumeros.clone();
        System.out.println("ORDENAMIENTO POR SELECCION");
        iInicio = Instant.now();
        ordenarPorSeleccion(array);
        iFin = Instant.now();
        System.out.println("-> ORDENAMIENTO POR SELECCION tardó : " + Duration.between(iInicio, iFin));
        System.out.println();
        System.out.println();

        // INSERTION SORT
        array = arrayNumeros.clone();
        System.out.println("ORDENAMIENTO POR INSERCIÓN");
        iInicio = Instant.now();
        ordenarPorInsercion(array);
        iFin = Instant.now();
        System.out.println("-> ORDENAMIENTO POR INSERCIÓN tardó : " + Duration.between(iInicio, iFin));
        System.out.println();
        System.out.println();

        // BUBBlE SORT
        array = arrayNumeros.clone();
        System.out.println("ORDENAMIENTO POR BURBUJA");
        iInicio = Instant.now();
        ordenarBubble(array);
        iFin = Instant.now();
        System.out.println("-> ORDENAMIENTO POR BURBUJA tardó : " + Duration.between(iInicio, iFin));
        System.out.println();
        System.out.println();

        // BUBBlE SORT
        array = arrayNumeros.clone();
        System.out.println("ORDENAMIENTO POR BURBUJA con bandera");
        iInicio = Instant.now();
        ordenarBubbleBandera(array);
        iFin = Instant.now();
        System.out.println("-> ORDENAMIENTO POR BURBUJA con bandera tardó : " + Duration.between(iInicio, iFin));
        System.out.println();
        System.out.println();

        // QUICK SORT
        array = arrayNumeros.clone();
        System.out.println("ORDENAMIENTO RÁPIDO");
        iInicio = Instant.now();
        quicksort(array, 0, array.length - 1);
        iFin = Instant.now();
        System.out.println("-> ORDENAMIENTO RÁPIDO : " + Duration.between(iInicio, iFin));
        System.out.println();
        System.out.println();

        Scanner s = new Scanner(System.in);
        String ingresoUsuario;

        do {
            System.out.println("Ingrese un número para buscar o q para salir:");
            ingresoUsuario = s.nextLine();

            if (!ingresoUsuario.equals("q")) {
                try {
                    int numero = Integer.parseInt(ingresoUsuario);

                    iInicio = Instant.now();
                    int indicem1 = busquedaBinaria(arrayNumeros, numero);
                    iFin = Instant.now();
                    System.out.println("Búsqueda binaria tardó : " + Duration.between(iInicio, iFin));

                    iInicio = Instant.now();
                    int indicem2 = busquedaSecuencial(arrayNumeros, numero);
                    iFin = Instant.now();
                    System.out.println("Búsqueda secuencial tardó : " + Duration.between(iInicio, iFin));

                    if (indicem1 != indicem2) {
                        System.out.println("Los índices devueltos son diferentes!!!");
                    }

                    if (indicem1 == -1) // el número no está en el array
                    {
                        System.out.println("El número " + numero + " no se encuentra en el array.");
                    } else {
                        System.out.println("En búsqueda secuencial se encuentra " + numero + " en la posición: " + indicem1);
                        System.out.println("En búsqueda binaria se encuentra " + numero + " en la posición: " + indicem2);

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
    public static void imprimirArray(int[] arrayNumeros) {
        for (int i = 0; i < arrayNumeros.length; i++) {
            System.out.println("Posición " + i + ": " + arrayNumeros[i] + " ");

        }
        System.out.println();

    }

    /**
     * Método que busca un valor dentro de un array iterando secuencialmente en
     * el array desde 0 a n-1
     *
     * @param array
     * @param valor
     * @return devuelve la posiciÃ³n en en array donde se encuentra valor o -1
     * si valor no se encuentra en el array
     */
    public static int busquedaSecuencial(int[] array, int valor) {

        for (int i = 0; i < array.length; i++) {

            if (array[i] == valor) {
                return i;
            }

        }

        return -1;
    }

    /**
     * Método que busca un valor dentro de un array implementando el algoritmo
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

            if (array[medio] == valor) {
                return medio;
            } else if (array[medio] < valor) {
                desde = medio + 1;
            } else {
                hasta = medio - 1;

            }

        }

        return -1;
    }

    /**
     * Método que busca un valor dentro de un array implementando el algoritmo
     * de búsqueda binaria de manera recursiva
     *
     * @param array
     * @param valor
     * @return devuelve la posición en en array donde se encuentra valor o -1 si
     * valor no se encuentra en el array
     */
    public static int busquedaBinariaRecursiva(int[] array, int valor, int desde, int hasta) {

        if (desde <= hasta) {
            int medio = (desde + hasta) / 2;
            if (array[medio] == valor) {
                return medio;
            } else if (array[medio] > valor) {
                return busquedaBinariaRecursiva(array, valor, desde, medio - 1);
            } else {
                desde = medio + 1;
                return busquedaBinariaRecursiva(array, valor, medio + 1, hasta);
            }
        }
        return -1;

    }

    /**
     * SELECTION SORT
     */
    public static void ordenarPorSeleccion(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMin = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[indiceMin]) {
                    indiceMin = j;
                }
            }

            int aux = arr[indiceMin];
            arr[indiceMin] = arr[i];
            arr[i] = aux;

        }
    }

    /**
     * INSERTION SORT
     */
    public static void ordenarPorInsercion(int arr[]) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int valor = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > valor) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = valor;
        }
    }

    /**
     * BUBBLE SORT
     */
    public static void ordenarBubble(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    int aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }

        }

    }

    /**
     * BUBBLE SORT V2
     */
    public static void ordenarBubbleBandera(int[] arr) {
        int n = arr.length;

        boolean huboIntercambio;

        for (int i = 0; i < n - 1; i++) {

            huboIntercambio = false;

            for (int j = 0; j < n - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    int aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                    huboIntercambio = true;
                }
            }

            if (!huboIntercambio) {
                break;
            }
        }

    }

    /**
     * QUICKSORT
     */
    public static void quicksort(int arr[], int desde, int hasta) {
        if (desde < hasta) {

            int pi = particionar(arr, desde, hasta);

            quicksort(arr, desde, pi - 1);
            quicksort(arr, pi + 1, hasta);
        }
    }

    static int particionar(int arr[], int desde, int hasta) {
        int pivote = arr[desde];
        int primeroMayor = desde + 1;

        for (int i = desde + 1; i <= hasta; i++) {

            if (arr[i] < pivote) {
                int temp = arr[i];
                arr[i] = arr[primeroMayor];
                arr[primeroMayor] = temp;
                primeroMayor++;
            }
        }
        int temp = arr[primeroMayor - 1];
        arr[primeroMayor - 1] = arr[desde];
        arr[desde] = temp;

        return primeroMayor - 1;
    }



    
  
} 


