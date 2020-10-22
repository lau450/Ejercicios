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
public class ItemCompra {
    	private Producto producto;
	private int cantidad;
	private double totalItem;

	public ItemCompra(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.totalItem = producto.getPrecio() * cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setTotalItem(double totalItem) {
		this.totalItem = totalItem;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotalItem() {
		return totalItem;
	}

	@Override
	public String toString() {
		return this.producto.toString() + " :" + this.cantidad + "-> total item: $" + this.totalItem;
	}

    
    
    
}
