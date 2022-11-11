package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Serie;
import pojo.Temporada;
import utils.DatabaseConnection;

public class SerieDao extends ObjetoDao implements InterfazDao<Serie>{
	
	private static Connection connection;
	
	public SerieDao() {
		
	}

	@Override
	public ArrayList<Serie> buscarTodos() {
		ArrayList<Serie> series = new ArrayList<>();
		
		connection= openConnection();
		
		String query = "Select * FRom Series";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Serie serie = new Serie(rs.getInt("id"),
						rs.getString("titulo"),
						rs.getInt("edad"),
						rs.getString("plataforma"), 
						null);
				series.add(serie);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return series;
	}

	@Override
	public Serie buscarPor(int i) {
		connection = openConnection();

		String query = "select * from series where id = ?";
		Serie serie=null;
		

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				serie = new Serie(rs.getInt("id"),rs.getString("titulo"),rs.getInt("edad"),rs.getString("plataforma"), null);
				serie.setTemporadas(obtenerTemporadas(serie));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		
		return serie;
	}

	@Override
	public void insertar(Serie serie) {

		connection = openConnection();
		
		String query = "insert into series (titulo,edad,plataforma) values(?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, serie.getTitulo());
			ps.setInt(2, serie.getEdad());
			ps.setString(3, serie.getPlataforma());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
	}

	@Override
	public void modificar(Serie serie) {
		int id=serie.getId();
		String titulo=serie.getTitulo();
		int edad = serie.getEdad();
		String plataforma = serie.getPlataforma();
		
		connection = openConnection();
		
		String query = "UPDATE SERIES SET titulo=?,edad = ? , plataforma=? where id=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, serie.getTitulo());
			ps.setInt(2, serie.getEdad());
			ps.setString(3, serie.getPlataforma());
			ps.setInt(4, serie.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public ArrayList<Temporada> obtenerTemporadas(Serie serie){
		ArrayList<Temporada>temporadas = new ArrayList<>();
		connection = openConnection();
		String query = "Select * from temporadas where serie_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie.getId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Temporada temporada = new Temporada(rs.getInt("id"),rs.getInt("num_temporada"),rs.getString("titulo"),serie);
				temporadas.add(temporada);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//closeConnection();
		return temporadas;
		
	}

	@Override
	public void borrar(Serie t) {
		int serie_id = t.getId();
		TemporadaDao temporada = new TemporadaDao();
		temporada.borrarPorSerie(serie_id);
		
		connection = openConnection();
		
		String query = "Delete from series where id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}
	
	
	
	
}
