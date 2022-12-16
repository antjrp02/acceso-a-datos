package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Producto;
import pojo.Tienda;
/**
 * Clase TiendaDao, la cual representa un dao de la clase Tienda e implementa la interfazDao<Tienda>
 * @author Antonio
 *
 */
public class TiendaDao extends ObjetoDao implements InterfazDao<Tienda> {
	/**
	 * Variable privada De tipo Connection que representa la conexión.
	 */
	private static Connection connection;
	/**
	 * Constructor de la clase vacío.
	 */
	public TiendaDao() {

	}
	/**
	 * clase buscarTodos la cual crea un arrayList de las tiendas las cuales estan en la base de datos
	 */public ArrayList<Tienda> buscarTodos() {
		ArrayList<Tienda> tiendas = new ArrayList<>();
		
			connection = openConnection();

			String query = "SELECT * FROM Tiendas";
			try {
			PreparedStatement ps = connection.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ArrayList<Producto> productos = new ArrayList<Producto>();

				Tienda tienda = new Tienda(rs.getInt("id"), rs.getInt("horas_abiertas"), rs.getString("direccion"),
						rs.getInt("metros_cuadrados"), rs.getInt("ingresos_mensuales"), null);

				String query_Productos = "select * from Productos where id_Tienda = ?";
				PreparedStatement ps_Productos = connection.prepareStatement(query_Productos);
				ps_Productos.setInt(1, rs.getInt("id"));
				ResultSet rs_Productos = ps_Productos.executeQuery();

				while (rs_Productos.next()) {
					Producto producto = new Producto(rs_Productos.getInt("id"), rs_Productos.getString("nombre"),
							rs_Productos.getFloat("Precio"), rs_Productos.getString("categoria"),
							rs_Productos.getDate("Fecha_caducidad")

					);
					productos.add(producto);
				}

				tienda.setProductos(productos);

				tiendas.add(tienda);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tiendas;
	}
	 /**
		 * Funcion buscarPorId la cual le pasamos un id y nos devuelve la tienda en la base de datos con esa id
		 * @param id es la id a buscar en la base de datos 
		 * @return de tipo Tienda te devuelve una tienda
		 */
	public Tienda buscarPorId(int id) {
		// TODO Auto-generated method stub
		connection = openConnection();

		Tienda tienda = null;

		String query = "select * from tiendas where id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				tienda = new Tienda(rs.getInt("id"), rs.getInt("horas_abiertas"), rs.getString("direccion"),
						rs.getInt("metros_cuadrados"), rs.getInt("ingresos_mensuales"), null);
				tienda.setProductos(obtenerProductos(tienda));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		return tienda;
	}
	public Tienda buscarPorHoras(int horas) {
		// TODO Auto-generated method stub
		connection = openConnection();

		Tienda tienda = null;

		String query = "select * from tiendas where horas_abiertas = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, horas);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				tienda = new Tienda(rs.getInt("id"), rs.getInt("horas_abiertas"), rs.getString("direccion"),
						rs.getInt("metros_cuadrados"), rs.getInt("ingresos_mensuales"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		return tienda;
	}
	/**
	 * funcion obtenerProductos la cual devuelve un arrayList de productos los cuales le corresponden a la tienda pasada por parametros
	 * @param tienda la tienda de la cual queremos ver todos los productos
	 * @return ArrayList de productos los cuales pertenecen a la tienda pasada por parameteos
	 */
	public ArrayList<Producto> obtenerProductos(Tienda tienda) {
		ArrayList<Producto> productos = new ArrayList<>();

		connection = openConnection();

		String query = "SELECT * FROM Productos WHERE id_tienda = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, tienda.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Producto producto = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getFloat("Precio"),
						rs.getString("categoria"), rs.getDate("Fecha_caducidad")

				);
				productos.add(producto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// closeConnection();

		return productos;
	}
	/**
	 * Función que inserta una Tienda en la base de datos
	 * @param Se le pasa por parametros la tienda a insertar
	 */
	public void insertar(Tienda t) {
		// TODO Auto-generated method stub
		connection = openConnection();

		String query = "insert into tiendas (horas_abiertas, direccion,metros_cuadrados,ingresos_mensuales)"
				+ " values (?, ?, ? , ?)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, t.getHoras_abiertas());
			ps.setString(2, t.getDireccion());
			ps.setInt(3, t.getMetros_cuadrados());
			ps.setInt(4, t.getIngresos_mensuales());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}
	/**
	 * funcion modificar, la cual modifica en la base de datos una tienda que el pasamos por parametros
	 * @param t es la tienda a modificar en la abse de datos
	 */
	@Override
	public void modificar(Tienda t) {
		int id = t.getId();
		int horas_abiertas = t.getHoras_abiertas();
		String direccion = t.getDireccion();
		int metros_cuadrados = t.getMetros_cuadrados();
		int ingresos_mensuales = t.getIngresos_mensuales();
		

		connection = openConnection();

		String query = "UPDATE tiendas SET horas_abiertas = ?, direccion = ?, metros_cuadrados = ?, ingresos_mensuales = ? "
				+ " WHERE id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, horas_abiertas);
			ps.setString(2, direccion);
			ps.setInt(3, metros_cuadrados);
			ps.setInt(4, ingresos_mensuales);
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	/**
	 * funcion borrar la cual borra una tabla de la base de datos.
	 * @param t es la tienda a borrar de la base de datos.
	 */
	public void borrar(Tienda t) {
		int id_Tienda = t.getId();

		ProductoDao productoDao = new ProductoDao();
		productoDao.borrarPorTienda(id_Tienda);

		connection = openConnection();

		String query = "DELETE FROM tiendas WHERE id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id_Tienda);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}
	/**
	 * funcion Reset la cual desactiva todas las claves foraneas y borra todos los datos de la tabla Tienda
	 */
	public void Reset() {
		connection = openConnection();

		

		String queryFK = "SET FOREIGN_KEY_CHECKS = 0";
		String query = "truncate table Tiendas";

		try {
			PreparedStatement ps = connection.prepareStatement(queryFK);
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement(query);
			ps2.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		
	}

}
