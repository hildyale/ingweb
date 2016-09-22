package dao;

import Exception.MyDaoException;
import dto.Ciudad;

import java.util.List;;

/**
 * define los metodos para acceder a las ciudades
 * @author alejandro.isazad
 *
 */
public interface CiudadDao {
	
	public List<Ciudad> obtener() throws MyDaoException;
	
	public Ciudad obtenerUna(String codigo) throws MyDaoException;
	
	public void guardar(Ciudad ciudad) throws MyDaoException;
	
	public void modificar(Ciudad ciudad) throws MyDaoException;
	
	public void eliminar(String codigo) throws MyDaoException;

}
