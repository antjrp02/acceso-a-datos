package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Clase que crea la conexión con la base de datos
 * 
 * @author Antonio
 *
 */
public class DatabaseConnection {
	/**
	 * Variable de tipo Connection que representa la conexión
	 */
	Connection connection;
	/**
	 * Función que establece la conexión con la base de datos
	 * @return Devuelve la conexión
	 */
	public Connection getConnection () {
		String dbName = "bd_tienda";
		String userName = "root";
		String password = "admin";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/" + dbName,
					userName,
					password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
}