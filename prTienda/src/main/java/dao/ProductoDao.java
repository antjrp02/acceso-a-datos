package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Producto;
import pojo.Tienda;
import util.DatabaseConnection;
/**
 * Clase Prodcuto dao, la cual representa un dao de la clase Producto e implementa la interfazDao<Producto>
 * @author Antonio
 *
 */
public class ProductoDao extends ObjetoDao implements InterfazDao<Producto> {
	/**
	 * Variable privada De tipo Connection que representa la conexión.
	 */
	private static Connection connection;
	/**
	 * Constructor de la clase vacío.
	 */
	public ProductoDao() {

	}
	/**
	 * clase buscarTodos la cual crea un arrayList de productos los cuales estan en la base de datps
	 */
	public ArrayList<Producto> buscarTodos() {
		ArrayList<Producto> productos = new ArrayList<>();

        connection = openConnection();

        String query = "select * from productos";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Producto producto = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getFloat("precio"),
						rs.getString("categoria"), rs.getDate("fecha_caducidad"), null);

                 String query2 = "select * from tiendas where id = ?";
                 PreparedStatement ps2 = connection.prepareStatement(query2);
                 ps2.setInt(1, rs.getInt("id")); 
                 ResultSet rs2 = ps2.executeQuery();

                 while(rs2.next()) {

                    
                    Tienda tienda = new Tienda(rs2.getInt("id"), rs2.getInt("horas_abiertas"), rs2.getString("direccion"),
							rs2.getInt("metros_cuadrados"), rs2.getInt("ingresos_mensuales"), null);
                     if(rs2.getInt("id") == rs.getInt("id")) {
                         producto.setTienda(tienda);
                     }
                 }

                 productos.add(producto);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return productos;
	}
	
	/**
	 * Funcion buscarPorId la cual le pasamos un id y nos devuelve el producto en la base de datos con esa id
	 * @param id es la id a buscar en la base de datos
	 */
	public Producto buscarPorId(int id) {
		connection = openConnection();

		

		String query = "select * from productos where id = ?";
		Producto producto = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
					int id_tienda = rs.getInt("id_tienda");
					Tienda tienda = null;
					
					String query2 = "select * from tiendas where id = ?";
					PreparedStatement ps2 = connection.prepareStatement(query2);
					ps2.setInt(1, id_tienda); 
					ResultSet rs2 = ps2.executeQuery();
					
					while(rs2.next()) {
						tienda = new Tienda(rs2.getInt("id"), rs2.getInt("horas_abiertas"), rs2.getString("direccion"),
								rs2.getInt("metros_cuadrados"), rs2.getInt("ingresos_mensuales"), null);
					}
					
					producto = producto = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getFloat("precio"),
							rs.getString("categoria"), rs.getDate("fecha_caducidad"),tienda);
			
					
					
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		return producto;
	}
	
	public Producto buscarPorNombre(String nombre) {
		connection = openConnection();

		

		String query = "select * from productos where nombre = ?";
		Producto producto = null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
					int id_tienda = rs.getInt("id_tienda");
					Tienda tienda = null;
					
					String query2 = "select * from tiendas where id = ?";
					PreparedStatement ps2 = connection.prepareStatement(query2);
					ps2.setInt(1, id_tienda); 
					ResultSet rs2 = ps2.executeQuery();
					
					while(rs2.next()) {
						tienda = new Tienda(rs2.getInt("id"), rs2.getInt("horas_abiertas"), rs2.getString("direccion"),
								rs2.getInt("metros_cuadrados"), rs2.getInt("ingresos_mensuales"), null);
					}
					
					producto = producto = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getFloat("precio"),
							rs.getString("categoria"), rs.getDate("fecha_caducidad"),tienda);
			
					
					
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

		return producto;
	}
	/**
	 * Función que inserta un producto en la abse de datos
	 * @param Se le pasa por parametros el producto a insertar
	 */
	public void insertar(Producto t) {
		// TODO Auto-generated method stub
		connection = openConnection();

		String query = "insert into productos (nombre,precio,fecha_caducidad, "
				+ "categoria,id_tienda) values (?, ?, ?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, t.getNombre());
			ps.setFloat(2, t.getPrecio());
			ps.setDate(3, t.getFecha_caducidad());
			ps.setString(4, t.getCategoria());
			ps.setInt(5, t.getTienda().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}
	/**
	 * funcion modificar, la cual modifica en la base de datos un producto que el pasamos por parametros
	 * @param t es el producto a modificar en la abse de datos
	 */
	public void modificar(Producto t) {
		int id = t.getId();
		String nombre = t.getNombre();
		Float precio = t.getPrecio();
		String categoria = t.getCategoria();
		Date  fecha_caducidad = t.getFecha_caducidad();
		Tienda tienda = t.getTienda();
		

		connection = openConnection();

		String query = 
				"UPDATE productos SET nombre = ?, precio = ?, fecha_caducidad = ?, categoria = ?, id_tienda = ?"
						+ " WHERE id = ?";
		

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, t.getNombre());
			ps.setFloat(2, t.getPrecio());
			ps.setDate(3, t.getFecha_caducidad());
			ps.setString(4, t.getCategoria());
			ps.setInt(5, t.getTienda().getId());
			ps.setInt(6, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	
	/**
	 * funcion borrar la cual borra un producto de la base de datos.
	 * @param t es el producto a borrar de la base de datos.
	 */
	public void borrar(Producto t) {
		connection = openConnection();

		int id = t.getId();

		String query = "DELETE FROM prodcutos WHERE id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}
	/**
	 * funcion borrarPorTienda, la cual borra todos los productos que correspondan a una tienda en especifico
	 * @param id_tienda es el id de la tienda la cual queremos dejar sin productos
	 */
	public void borrarPorTienda(int id_tienda) {
		connection = openConnection();

		String query = "DELETE FROM productos WHERE id_tienda = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id_tienda);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}
	/**
	 * funcion Reset la cual borra todos los datos de la tabla Producto
	 */
	public void Reset() {
		connection = openConnection();

		String query = "truncate table Productos";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();

	}

}