package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Exception.MyDaoException;
import dao.UsuarioDao;
import dao.hibernate.UsuarioDaoImp;
import dto.Usuario;


public class UsuarioDaoImpTest {

	@Test
	public void testObtener() {
		UsuarioDao usuario = null;
		List<Usuario> usuarios = null;
		
		
		try{
			usuario = new UsuarioDaoImp();
			usuarios = usuario.obtener();
			for(Usuario x:usuarios){
				System.out.println("Login : " +x.getLogin());
				System.out.println("Rol : " +x.getRol().getNombre());
			}
			assertTrue(usuarios.size() > 0);
			
		}catch(MyDaoException e){
			fail(e.getMessage());
			
		}
	}

}
