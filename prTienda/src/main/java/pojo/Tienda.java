package pojo;

import java.util.ArrayList;

public class Tienda {

	private int id;
	private int horas_abiertas;
	private String direccion;
	private int metros_cuadrados;
	private int ingresos_mensuales;
	private ArrayList<Producto> productos;

	
	/**
	 * 
	 * @param horas_abiertas de tipo int referencia al numero de horas al mes que abre la tienda en la base de datos
	 * @param direccion de tipo String que referencia a la direccion de la tienda en la base de datos
	 * @param metros_cuadrados de tipo int que referencia a los metros cuadrados que tiene la tienda en la base de datos
	 * @param ingresos_mensuales de tipo int el cual referencia a los ingresos mensuales que tiene la tienda en la base de datos
	 */
	public Tienda(int horas_abiertas, String direccion, int metros_cuadrados, int ingresos_mensuales) {
		super();
		this.horas_abiertas = horas_abiertas;
		this.direccion = direccion;
		this.metros_cuadrados = metros_cuadrados;
		this.ingresos_mensuales = ingresos_mensuales;
	}
	public Tienda(int id,int horas_abiertas, String direccion, int metros_cuadrados, int ingresos_mensuales) {
		super();
		this.id = id;
		this.horas_abiertas = horas_abiertas;
		this.direccion = direccion;
		this.metros_cuadrados = metros_cuadrados;
		this.ingresos_mensuales = ingresos_mensuales;
	}
	/**
	 * @param id de tipo int que referencia al id de la tienda en la base de datos
	 * @param horas_abiertas de tipo int referencia al numero de horas al mes que abre la tienda en la base de datos
	 * @param direccion de tipo String que referencia a la direccion de la tienda en la base de datos
	 * @param metros_cuadrados de tipo int que referencia a los metros cuadrados que tiene la tienda en la base de datos
	 * @param ingresos_mensuales de tipo int el cual referencia a los ingresos mensuales que tiene la tienda en la base de datos
	 */
	public Tienda(int id, int horas_abiertas, String direccion, int metros_cuadrados, int ingresos_mensuales,
			ArrayList<Producto> productos) {
		super();
		this.id = id;
		this.horas_abiertas = horas_abiertas;
		this.direccion = direccion;
		this.metros_cuadrados = metros_cuadrados;
		this.ingresos_mensuales = ingresos_mensuales;
		this.productos = productos;
	}
	/**
	 * getter de id
	 * @return devuelve el id de la tienda
	 */
	public int getId() {
		return id;
	}
	/**
	 * getter de horas abiertas
	 * @return de tipo int que devuelve las horas de la tienda
	 */
	public int getHoras_abiertas() {
		return horas_abiertas;
	}
	/**
	 * setter de horas abiertas
	 * @param horas_abiertas que le pasamos el numero de horas que abre la tienda en la base de datos
	 */
	public void setHoras_abiertas(int horas_abiertas) {
		this.horas_abiertas = horas_abiertas;
	}
	/**
	 * getter de direccion
	 * @return de tipo String el cual devuelve la direccion de la base de datos
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * setter de direccion al cual le pasamos el campo direccion de la tienda en la base de datos
	 * @param direccion que rellena el campo direccion de la tienda
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * getter de metros cuadrados
	 * @return de tipo int que devuelve los metos cuadrados de la tienda
	 */
	public int getMetros_cuadrados() {
		return metros_cuadrados;
	}	
	/**
	 * setter de metros cuadrados
	 * @param metros_cuadrados qe referencia a los metros cuadrados de la tienda
	 */

	public void setMetros_cuadrados(int metros_cuadrados) {
		this.metros_cuadrados = metros_cuadrados;
	}
	/**
	 * getter de ingresos mensuales
	 * @return de tipo int que devuelve los ingresos mensuales de la tienda
	 */
	public int getIngresos_mensuales() {
		return ingresos_mensuales;
	}
	/**
	 * setter de ingresos mensuales 
	 * @param ingresos_mensuales para añadirle los ingresos mensuales a la tienda
	 */
	public void setIngresos_mensuales(int ingresos_mensuales) {
		this.ingresos_mensuales = ingresos_mensuales;
	}
	/**
	 * getter de prodcutos 
	 * @return Array de productos el cual devuelve todos los productos de la tienda
	 */
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	/**
	 * setter de profuctos
	 * @param productos de tipo ArrayList de productos le cual le pasamos por parametros el array de productos de la tienda
	 */

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Tienda [id=" + id + ", horas_abiertas=" + horas_abiertas + ", direccion=" + direccion
				+ ", metros_cuadrados=" + metros_cuadrados + ", ingresos_mensuales=" + ingresos_mensuales
				+ ", productos=" + productos + "]";
	}

}
