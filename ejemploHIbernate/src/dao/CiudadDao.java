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

}
