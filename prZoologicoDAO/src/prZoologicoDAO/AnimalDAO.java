package prZoologicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnimalDAO {

	private static Connection connection;
	public static void insertarAnimal(Animal a) {
		connection = oppenConnection();
		
		String query="insert into animales(nombre,habitat,peso_aproximado) values(?,?,?); ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, a.getNombre());
			preparedStatement.setString(2, a.getHabitat());
			preparedStatement.setDouble(3, a.getPeso_aproximado());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private static Connection oppenConnection() {
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection = dbConnection.getConnection();
		return connection;
		
	}
	
	private static Connection closeConnection() {
		
		try {
			connection.close();
			connection=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	
	
}
