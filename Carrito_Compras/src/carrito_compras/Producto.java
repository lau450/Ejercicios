/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito_compras;

/**
 *
 * @author lauta
 */
public class Producto {
    private int id;
	private String nombre;
	private double precio;

	public Producto(int id, String nombre, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;

	}

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
        
        

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "[id: " + id + ", nombre: " + nombre + ", precio unitario: " + precio + "]";
	}
    
    
}
