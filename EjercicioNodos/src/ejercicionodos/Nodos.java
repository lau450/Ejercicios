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
public class Nodos {
    
    Object valor;
    Nodos siguiente;

    public Nodos(Object valor) {
        this.valor = valor;
    }
   
    public void enlazarSiguiente (Nodos n) {
        siguiente = n;
        
    }
    
    public Nodos obtenerSiguiente(){
        return siguiente;
    }
    
    public Object obtenerValor(){
        return valor;
    }
}
