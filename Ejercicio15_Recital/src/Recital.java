/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lauta
 */
import java.util.ArrayList;

public class Recital {

    private String lugar;
    private String nombreBanda;
    private int capacidadMaxima;
    private int valorGeneral;
    private ArrayList<Personas> listadoPersonas = new ArrayList<Personas>();

    public Recital(String lugar, String nombreBanda, int capacidadMaxima, int valorGeneral) {
        this.lugar = lugar;
        this.nombreBanda = nombreBanda;
        this.capacidadMaxima = capacidadMaxima;
        this.valorGeneral = valorGeneral;

    }

    public Recital() {
        this.lugar = "No definido";
        this.nombreBanda = "No definido";
        this.capacidadMaxima = 0;
        this.valorGeneral = 0;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNomreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    public int getValorGeneral() {
        return valorGeneral;
    }

    public void setValorGeneral(int valorGeneral) {
        this.valorGeneral = valorGeneral;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public boolean CobrarEntrada(Personas p) {

        if (listadoPersonas.size() >= capacidadMaxima) {
            return false;
        } else {
            listadoPersonas.add(p);
        }

        if (p.getEdad() > 60) {
            valorGeneral = valorGeneral - (valorGeneral * 10 / 100);
        }

        return true;
    }

    public void personasMayores(int edad) {
        int contadorPersonasMayor = 0;
        for (Personas p : listadoPersonas) {
            if (p.getEdad() >= edad) {
                contadorPersonasMayor++;
            }
        }
        System.out.println("Han pasado: " + contadorPersonasMayor + " personas con la edad " + edad + "años");
        System.out.println("");
    }

    public int totalPersonasIngresadas() {
        int totalPersonas;
        totalPersonas = listadoPersonas.size();
        return totalPersonas;
    }

    public Personas primeraPersona() {
        if (listadoPersonas.size() > 0) {
            return listadoPersonas.get(0);
        }
        return null;
    }

    public Personas ultimaPersona() {
        if (listadoPersonas.size() > 0) {
            return listadoPersonas.get(listadoPersonas.size() - 1);
        }
        return null;
    }

    public void reporteDelRecital() {
        System.out.println("Lugar: " + lugar);
        System.out.println("Capacidad máxima: " + capacidadMaxima);
        System.out.println("Banda: " + nombreBanda);
        System.out.println("Precio de la entrada: " + valorGeneral);
        System.out.println("Total de personas que acudieron: " + totalPersonasIngresadas());
        System.out.println("_________________________________________________________");
        detallePersonas();
    }

    public void detallePersonas() {
        for (Personas p : listadoPersonas) {

            System.out.println("Nombre de la persona: " + p.getNombre());
            System.out.println("DNI: " + p.getDni());
            System.out.println("Edad: " + p.getEdad());
            System.out.println("");
        }
    }
}
