package co.edu.udea.logica;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyDaoException;

/**
 * 
 * @author estudiantelis
 *
 */
public interface Clienteb1 {
	
	public void crearCliente(String cedula,String nombres,String apellidos,String email,String usuarioCrea) throws MyDaoException;

}