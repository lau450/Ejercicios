/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lauta
 */
public class Main {

    public static void main(String[] args) {
        
        Personas p1 = new Personas("Sol", 37635592, 26);
        Personas p2 = new Personas("Rami", 37652592, 28);
        Personas p3 = new Personas("Lauti", 312135592, 70);
        Personas p5 = new Personas("Gonza", 13217592, 56);

        Recital r1 = new Recital("LollaPaloza", "La Mona Jimenez", 3000, 2500);
        r1.CobrarEntrada(p1);
        r1.CobrarEntrada(p2);
        r1.CobrarEntrada(p5);
        r1.CobrarEntrada(p3);
        r1.personasMayores(40);
        r1.reporteDelRecital();

    }
}
