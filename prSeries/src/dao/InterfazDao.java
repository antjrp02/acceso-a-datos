package dao;

import java.util.ArrayList;
/**
 * 
 * @author Usuario
 *
 * @param <T>
 */
public interface InterfazDao<T> {
	/**
	 * Muestra todos los objetos T de la base de datos
	 * 
	 * @return un ArrayList de objetos T
	 */
	public ArrayList<T> buscarTodos();
	/**
	 * Muestra el objeto T con el id especificado
	 * 
	 * @param T un objeto T
	 * param i id del objeto T
	 * @return
	 */
	
	public T buscarPor(int i);
	/**
	 * inserta un objeto T en la base de datos
	 * @param t un objeto T
	 */
	
	public void insertar(T t);
	/**
	 * Actualiza un objeto T en la base de datos
	 * @param t un objeto T
	 */
	
	public void modificar(T t);
	/**
	 *Elimina un objeto T de la base de datos
	 *@param t un objeto T 
	 */
	public void borrar(T t);
}
