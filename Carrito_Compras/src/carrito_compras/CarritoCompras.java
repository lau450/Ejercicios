/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito_compras;

import java.util.ArrayList;

/**
 *
 * @author lauta
 */
public class CarritoCompras {
    
    private int id;
	private Cliente cliente;
	private ArrayList<ItemCompra> itemsComprados;
	private double total;

	/**
	 * @param id      El id del carrito de compras
	 * @param cliente El cliente que realiza la compra
	 */
	public CarritoCompras(int id, Cliente cliente) {
		cliente = cliente;
		this.itemsComprados = null;
		this.total = 0;

	}

	/**
	 * Agrega un producto al carrito. Si el producto ya estaba agregado actualiza la cantidad.
	 * 
	 * @param p        El Producto a agregar en el carrito
	 * @param cantidad La cantidad del Producto p que se desea agregar
	 */
	public void agregarProducto(Producto p, int cantidad) {

		boolean productoYaCargado ; // valor por defecto es false
                productoYaCargado = false;
                

		for (ItemCompra ic : itemsComprados) {
			if (ic.getProducto().getId() == p.getId()) {
				int cantidadFinal = ic.getCantidad() + cantidad;
				ic.setCantidad(cantidadFinal); 
				ic.setTotalItem(cantidadFinal * p.getPrecio()); 
				productoYaCargado = true;
				break;
			}
		}

		if (productoYaCargado == false) {
			ItemCompra nuevoItem = new ItemCompra(p, cantidad);
			itemsComprados.add(nuevoItem);

		}

		total = total + (p.getPrecio() * cantidad);

	}

	/**
	 * El método método cambia la cantidad para el producto en el carrito
	 * 
	 * @param p             El producto que se desea cambiar la cantidad
	 * @param nuevaCantidad La nueva cantidad deseada del Producto p
	 */
	public void cambiarCantidad(Producto p, int nuevaCantidad) {

		ItemCompra auxItemCompra = null;
		for (ItemCompra ic : itemsComprados) {
			if (ic.getProducto().getId() == p.getId()) {
				auxItemCompra = ic;
				break;
			}
		}

		total = 0;
		if (auxItemCompra != null) {
			if (nuevaCantidad == 0) {
				total = total - auxItemCompra.getTotalItem();
				itemsComprados.remove(auxItemCompra);
			} else {
				double nuevoMontoTotalItem = nuevaCantidad * auxItemCompra.getProducto().getPrecio();
				total = total - auxItemCompra.getTotalItem() + nuevoMontoTotalItem;

			}
		}

	}

	/**
	 * @return la cantidad de items en la compra
	 */
	public int getCantidadItems() {
		return 0;
	}

	/**
	 * Vacía el carrito de compras.
	 */
	public void vaciarCarrito() {
		itemsComprados.clear();

	}

	/**
	 * Borra un producto del carrito de compras.
	 * 
	 * @param p Producto a ser borrado
	 */
	public void borrarProducto(Producto p) {
		cambiarCantidad(p, 0);
	}

	/**
	 * @return el Cliente asignado al carrito
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @return Los items cargados en el carrito
	 */
	public ArrayList<ItemCompra> getItemsComprados() {
		return itemsComprados;
	}

	/**
	 * @return el total de la compra
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * Imprime por consola el detalle de la compra realizada
	 */
	public void finalizarCompra() {
		System.out.println("Id de carrito: " + id);
		System.out.println("Cliente: " + cliente.toString());
		System.out.println("Cantidad de items: " + getCantidadItems());
		System.out.println("Detalle items carrito: ");

		for (ItemCompra ic : itemsComprados) {
			System.out.println("Producto: " + ic.toString());
		}

		System.out.println("Total: $" + total);
		System.out.println();
	}
    
}
