/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicionodos;

/**
 *
 * @author lauta
 */
public class EjercicioNodos {

    Nodos cabeza;
    int tamaño;

    public EjercicioNodos() {
        cabeza = null;
    }

    public void addPrimero(Object valor) {
        if (cabeza == null) {
            cabeza = new Nodos(valor);

        } else {
            Nodos auxiliar = cabeza;
            Nodos nuevo = new Nodos(valor);
            nuevo.enlazarSiguiente(auxiliar);
        }
        tamaño++;
    }

    public int tamaño() {
        return tamaño;
    }

    public Object obtener(int index) {
        int contador = 0;
        Nodos temporal = cabeza;
        while (contador < index) {
        temporal = temporal.obtenerSiguiente();
        }
        return temporal.obtenerValor();
    }

    public boolean estaVacia() {
        return (cabeza == null) ? true : false;
    }

    public static void main(String[] args) {

        /* Nodos uno = new Nodos("Rojo");
        Nodos dos = new Nodos("Azul");
        Nodos tres = new Nodos("Amarillo");
        Nodos cuatro = new Nodos("Verde");
        Nodos cinco = new Nodos("Gris");
        Nodos seis = new Nodos("Naranja");

        uno.enlazarSiguiente(dos);
        uno.obtenerSiguiente().enlazarSiguiente(tres);

        System.out.println(uno
                .obtenerSiguiente()
                .obtenerSiguiente()
                .obtenerValor());*/
        
        
        EjercicioNodos lista = new EjercicioNodos();

        System.out.println("Tamaño " + lista.tamaño());
        lista.addPrimero("Rojo");
        lista.addPrimero("Verde");
        lista.addPrimero("Azul");
        lista.addPrimero("Amarillo");

        //primer elemento
        System.out.println("Primer elemento " + lista.obtener(0));
        //ultimo elemento
       System.out.println("Primer elemento " + lista.obtener(lista.tamaño()- 1));
        System.out.println("Index 2 " + lista.obtener(2));
        System.out.println("Esta vacia " + lista.estaVacia());
         System.out.println("Tamaño " + lista.tamaño());
         
         
         
         
        
         
         
         
         
         
         
         
         
         

    }

}
