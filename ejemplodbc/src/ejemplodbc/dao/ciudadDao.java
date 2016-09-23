package ejemplodbc.dao;

import java.util.List;

import ejemplodbc.dto.Ciudad;
import ejemplodbc.exception.ClaseExceptionDao;

/**
 * define la funcionalidad que proveera el dao de ciudades
 * @author alejandro.isazad
 *
 */
public interface ciudadDao {
	
	/**
	 * Entrega la lista de ciudades que tiene el sistema ordenado por nombre
	 * @return
	 * @throws ClaseExceptionDao
	 */
	public List<Ciudad> obtener() throws ClaseExceptionDao;
	
	public Ciudad obtener(int codigo) throws ClaseExceptionDao;

	void guardar(Ciudad ciudad) throws ClaseExceptionDao;

}
