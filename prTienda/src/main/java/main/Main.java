package main;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import dao.ProductoDao;
import dao.TiendaDao;
import pojo.Producto;
import pojo.Tienda;

public class Main {

	public static void main(String[] args) {
		
		TiendaDao tDao = new TiendaDao();
		ProductoDao pDao = new ProductoDao();
		pDao.Reset();
		tDao.Reset();
		Tienda t = new Tienda(730,"Calle subdelegado 13",60,2500);
		Tienda t2 = new Tienda(60,"Calle 11 13",10,2300);
		tDao.insertar(t);
		tDao.insertar(t2);
		Tienda tienda = new TiendaDao().buscarPorId(1);
		Tienda tienda2 = new TiendaDao().buscarPorId(2);
		
		System.out.println("\n\nTiendas añadidas a la base de datos\n");
		
		System.out.println(tienda);
		System.out.println(tienda2);
		
		Producto p = new Producto("yogurt sin proteina",1.5f,"Lacteo",Date.valueOf("2022-12-2"),tienda);
		Producto p2 = new Producto("Pan Bimbo integral 0%",2.87f,"Panaderia",Date.valueOf("2023-01-15"),tienda2);
		pDao.insertar(p);
		pDao.insertar(p2);
		System.out.println("\n\n Buscar por nombre: ");
		System.out.println(pDao.buscarPorNombre("yogurt sin proteina"));
		System.out.println("\n\n Buscar por horas abiertas");
		System.out.println(tDao.buscarPorHoras(60));
		
		System.out.println("\n\nProductos añadidas a la base de datos");
		
		Producto producto = pDao.buscarPorId(1);
		Producto producto2 = new ProductoDao().buscarPorId(2);
		System.out.println(producto);
		System.out.println(producto2);
		
		System.out.println("\n\nMostrar todas las tiendas de la base de datos");
		ArrayList<Tienda> tiendas = tDao.buscarTodos();
		for (Tienda t1 : tiendas) {
			System.out.println(tienda);
			
			
		}
		System.out.println("\n\nMostrar todos los productos de la base de datos");
		ArrayList<Producto> productos = pDao.buscarTodos();
		for (Producto p1 : productos) {
			System.out.println(p1);
		}
		System.out.println("\n\nModificacion del nombre del producto: ");
		
		producto2.setNombre("pan bimbo con semillas");
		pDao.modificar(producto2);
		System.out.println(producto2);
		
		System.out.println("\n\nModificacion de la direccion de la tienda: ");
		
		tienda.setDireccion("Calle Larios 45");
		tDao.modificar(tienda);
		
		System.out.println(tienda);
		System.out.println("\n\nBorrado productos de la tienda con el id 2 ");
		pDao.borrarPorTienda(2);
		System.out.println("\n\nBorrado de la tienda con id 2");
		tDao.borrar(tienda2);
		System.out.println("Tienda con id : "+tienda2.getId()+" borrada");
		
		
		
	
		
		
		
		
	
			}
		

	

}
