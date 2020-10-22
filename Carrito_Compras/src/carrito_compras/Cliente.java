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
public class Cliente {
    private int id;
	private String nombre;
	private String categoria;

	public Cliente(int id, String nombre, String categoria) {
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;

	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCategoria() {
		return categoria;
	}
    
}
