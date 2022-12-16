package pojo;

import java.sql.Date;

public class Producto {
	private int id;
	private String nombre;
	private float precio;
	private String categoria;
	private Date fecha_caducidad;
	private Tienda tienda;

	/**
	 * 
	 * @param id              int que referencia al id en la base de datos
	 * @param nombre          String que referencia al nombre delproducto en la base
	 *                        de datos
	 * @param precio          float que referencia al precio del producto en la base
	 *                        de datos
	 * @param categoria       String que referencia a la categoria del producto en
	 *                        la base de datos
	 * @param fecha_caducidad Date el cual rederencia a la fecha de caducidad en el
	 *                        producto en la base de datos
	 * @param tienda          de tipo Tienda el cual referencia a la tienda la que
	 *                        pertenece el producto
	 */
	public Producto(int id, String nombre, float precio, String categoria, Date fecha_caducidad, Tienda tienda) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.fecha_caducidad = fecha_caducidad;
		this.tienda = tienda;
	}

	/**
	 * 
	 *
	 * @param nombre          String que referencia al nombre delproducto en la base
	 *                        de datos
	 * @param precio          float que referencia al precio del producto en la base
	 *                        de datos
	 * @param categoria       String que referencia a la categoria del producto en
	 *                        la base de datos
	 * @param fecha_caducidad Date el cual rederencia a la fecha de caducidad en el
	 *                        producto en la base de datos
	 * 
	 */
	public Producto(String nombre, float precio, String categoria, Date fecha_caducidad, Tienda tienda) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.fecha_caducidad = fecha_caducidad;
		this.tienda = tienda;
	}

	/**
	 * 
	 * @param id              int que referencia al id en la base de datos
	 * @param nombre          String que referencia al nombre delproducto en la base
	 *                        de datos
	 * @param precio          float que referencia al precio del producto en la base
	 *                        de datos
	 * @param categoria       String que referencia a la categoria del producto en
	 *                        la base de datos
	 * @param fecha_caducidad Date el cual rederencia a la fecha de caducidad en el
	 *                        producto en la base de datos
	 * 
	 */
	public Producto(int id, String nombre, float precio, String categoria, Date fecha_caducidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.fecha_caducidad = fecha_caducidad;
	}

	/**
	 * getter de id
	 * 
	 * @return int de id, devuelve el id del producto
	 */
	public int getId() {
		return id;
	}

	/**
	 * getter de nombre
	 * 
	 * @return String que devuelve el nombre del producto
	 */
	public String getNombre() {
		return nombre;

	}

	/**
	 * Setter de nombre
	 * 
	 * @param nombre el cual le pasamos un string con el nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * getter de precio
	 * 
	 * @return de float el cual devuelve el precio dle producto
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * setter de precio
	 * 
	 * @param precio le pasamos el float del precio del producto
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * getter de categoria
	 * @return devuelve un String de la categoria del producto
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * setter de categoria
	 * @param categoria el cual le pasamos por parametros la categoria del producto
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	/**
	 * getter de fecha de caducidad
	 * @return devuelve la fecha de caducidad delproductos
	 */
	public Date getFecha_caducidad() {
		return fecha_caducidad;
	}
	/**
	 * setter de fecha de caducidad
	 * @param fecha_caducidad de tipo Date el cual le pasamos por parametros la fecha de caducidad del producto
	 */
	public void setFecha_caducidad(Date fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}
	/**
	 * getter de tienda
	 * @return de tipo Tienda, devuelve la tienda a al que pertenece el producto
	 */
	public Tienda getTienda() {
		return tienda;
	}
	/**
	 * setter de tienda
	 * @param tienda le pasamos por parametros un objeto tienda al que pertenece el producto
	 */
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria
				+ ", fecha_caducidad=" + fecha_caducidad + ", ID Tienda=" + tienda.getId() + "]";
	}

}
