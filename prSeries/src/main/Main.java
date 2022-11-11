package main;

import java.util.ArrayList;

import dao.SerieDao;
import dao.TemporadaDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		//Serie serie = new Serie("Los simpsons",7,"Disney plus");
		SerieDao serieDao = new SerieDao();
		//Serie serie=serieDao.buscarPor(1);
		//serieDao.insertar(serie);
		//Temporada t = new Temporada(2, "Barto", serie);
		//TemporadaDao tD = new TemporadaDao();
		//tD.insertar(t);
		//Serie s = new Serie("The Mandalorian",12,"Disney Plus");
		//serieDao.insertar(s);
		
		/**Serie los_simpsons = serieDao.buscarPor(1);
		
		ArrayList<Temporada>temporadas = serieDao.obtenerTemporadas(los_simpsons);
		for(Temporada temporada: temporadas) {
			System.out.println(temporada);
		}
		los_simpsons.setPlataforma("Netflix");
		serieDao.modificar(los_simpsons);
		ArrayList<Serie>series = serieDao.buscarTodos();
		for(Serie serie: series) {
			System.out.println(serie);
		}
		*/
		//System.out.println(serieDao.buscarPor(2));
		
		TemporadaDao temporadaDao = new TemporadaDao();
		/**
		Serie s = serieDao.buscarPor(1);
		Temporada t1 = new Temporada(1,"The mandalorian Season 1",s);
		Temporada t2 = new Temporada(1,"The mandalorian Season 2",s);
		Temporada t3 = new Temporada(1,"The mandalorian Season 3",s);
		temporadaDao.insertar(t1);
		temporadaDao.insertar(t2);
		temporadaDao.insertar(t3);
		*/
		
		temporadaDao.borrarPorSerie(8);
	}

}
