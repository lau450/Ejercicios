/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio14_agenda;

import java.util.ArrayList;

/**
 *
 * @author lauta
 */
public class Agenda {

    private ArrayList<Contacto> Array_Agenda;
    private int capacidad = 10;

    public Agenda() {

    }

    public Agenda(int capacidad) {
        Array_Agenda = new ArrayList<Contacto>();
        this.capacidad = capacidad;

    }

    public boolean existeContacto(Contacto c) {
        for (Contacto d : Array_Agenda) { // bucle for each SOLAMENTE de ArrayList
            if (d.getNombre().toLowerCase() == c.getNombre().toLowerCase()) {
                return true;
            }
        }
        return false;
    }

    public void agregarContacto(Contacto c) {
        if (existeContacto(c) == true) {
            System.out.println("Ya existe el usuario");
        } else {
            c.setNombre(c.getNombre());
            c.setTelefono(c.getTelefono());

            if (Array_Agenda.isEmpty() || Array_Agenda.size() < 10) {
                Array_Agenda.add(c);
                System.out.println("Agregando " + c.getNombre());
            } else {
                System.out.println("No se agrego" + c.getNombre());
            }

        }
    }

    public boolean eliminarContacto(Contacto c) {
        System.out.println("Eliminado " + c.getNombre());
        return Array_Agenda.remove(c);
    }

    public ArrayList<Contacto> getArray_Agenda() {
        return Array_Agenda;

    }

    public int lugaresLibres(Contacto c) {
        System.out.println("Lugares Libres " + lugaresLibres(c));
        return capacidad - Array_Agenda.size();
    }

    public int getCapacidadMaxima(Contacto c) {
        System.out.println("Capacidad Maxima "+ getCapacidadMaxima(c));
        return capacidad;
    }

    public Contacto buscar_Nombre(String c) {
        Contacto aux = null; // cuando creo variable objeto siempre en null
        for (Contacto d : Array_Agenda) {
            if (d.getNombre().equalsIgnoreCase(c)) {
                aux = d;
                break;
            }

        }
        return aux;

    }

}
