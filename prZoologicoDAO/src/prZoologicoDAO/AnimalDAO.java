package prZoologicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AnimalDAO {

	private static Connection connection;

	public static Animal findById(int id) {
		connection = openConnection();

		String query = "select * from animales where id = ?";
		Animal animal=null;

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				animal = new Animal(rs.getInt("id"),rs.getString("nombre"),rs.getString("habitat"),rs.getDouble("peso_aproximado")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return animal;
	}

	public static void deleteAnimalByNombre(String nombre) {
		connection = openConnection();

		String query = "delete from animales where nombre = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, nombre);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	public static void deleteAnimal() {
		connection = openConnection();
		String query = "delete from animales";
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection();
	}

	public static void insertarAnimal(Animal a) {
		connection = openConnection();

		String query = "insert into animales(nombre,habitat,peso_aproximado) values(?,?,?); ";
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

	private static Connection openConnection() {
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection = dbConnection.getConnection();
		return connection;

	}

	private static Connection closeConnection() {

		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

}
