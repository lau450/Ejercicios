/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio14_agenda;

/**
 *
 * @author lauta
 */
public class Test_Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Agenda ");
        
        Agenda agenda = new Agenda();
        
        Contacto a1 = new Contacto("Horacio", "22555");
        
        agenda.agregarContacto(a1);
        agenda.agregarContacto(a1);
        
    }
    
}
