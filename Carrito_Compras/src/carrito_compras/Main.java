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
public class Main {
public static void main(String[] args) {
   Cliente c1 = new Cliente(30, "Mariana", "CAT1");
	
		Producto prod1 = new Producto(101, "Cuaderno rayado 40 hojas", 120);
		Producto prod2 = new Producto(102, "Birome bic azul", 100);
		Producto prod3 = new Producto(103, "Carpeta", 200);

		CarritoCompras cc = new CarritoCompras(1200, c1);

		System.out.println("Prueba 1 agregar 3 items diferentes");
		cc.agregarProducto(prod1, 10);
		cc.agregarProducto(prod2, 5);
		cc.agregarProducto(prod3, 3);
		cc.finalizarCompra();

		System.out.println("Prueba 2 repetir items: prod1 10 + 2");
		cc.vaciarCarrito();
		cc.agregarProducto(prod1, 10);
		cc.agregarProducto(prod2, 5);
		cc.agregarProducto(prod3, 3);
		cc.agregarProducto(prod1, 2);
		cc.finalizarCompra();

		System.out.println("Prueba 3 cambiar cantidad a más: prod2 10 a 50");
		cc.vaciarCarrito();
		cc.agregarProducto(prod2, 10);
		cc.agregarProducto(prod1, 2);
		cc.cambiarCantidad(prod2, 50);
		cc.finalizarCompra();

		System.out.println("Prueba 4 cambiar cantidad a menos: prod2 10 a 2");
		cc.vaciarCarrito();
		cc.agregarProducto(prod2, 10);
		cc.agregarProducto(prod1, 2);
		cc.cambiarCantidad(prod2, 2);
		cc.finalizarCompra();

		System.out.println("Prueba 5 cambiar cantidad a la misma: prod2 10");
		cc.vaciarCarrito();
		cc.agregarProducto(prod2, 10);
		cc.agregarProducto(prod1, 2);
		cc.cambiarCantidad(prod2, 10);
		cc.finalizarCompra();

		System.out.println("Prueba 6 cambiar cantidad a 0: prod2 10 a 0");
		cc.vaciarCarrito();
		cc.agregarProducto(prod2, 10);
		cc.agregarProducto(prod1, 2);
		cc.cambiarCantidad(prod2, 0);
		cc.finalizarCompra();

		System.out.println("Prueba 7 borrar un producto: borrar prod1");
		cc.vaciarCarrito();
		cc.agregarProducto(prod1, 10);
		cc.agregarProducto(prod2, 5);
		cc.agregarProducto(prod3, 3);
		cc.agregarProducto(prod1, 2);
		cc.cambiarCantidad(prod2, 50);
		cc.borrarProducto(prod1);
		cc.finalizarCompra();
		
		System.out.println("Prueba 8 agregar producto con cantidad negativa: prod1 -10");
		cc.vaciarCarrito();
		cc.agregarProducto(prod1, -10);
		cc.agregarProducto(prod2, 5);
		cc.agregarProducto(prod3, 3);
		cc.finalizarCompra();
		
		System.out.println("Prueba 9 cambiar producto a cantidad negativa: prod1 10 a -5");
		cc.vaciarCarrito();
		cc.agregarProducto(prod1, 10);
		cc.cambiarCantidad(prod1, -5);
		cc.finalizarCompra();
  }














    
}
