package dao;

import java.util.List;

import Exception.MyDaoException;
import dto.Usuario;

/**
 * define los metodos para acceder a los usuarios
 * @author alejandro.isazad
 *
 */
public interface UsuarioDao {
	
	public List<Usuario> obtener() throws MyDaoException;

}
