package Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import ejemplodbc.dto.Ciudad;
import ejemplodbc.dao.ciudadDao;
import ejemplodbc.dao.impl.CiudadDaoImpl;
import ejemplodbc.exception.ClaseExceptionDao;

public class CiudadDaoImplTest {

	@Test
	public void testObtener() {
		
		ciudadDao ciudad = null;
		List<Ciudad> ciudades = null;
		
		
		try{
			ciudad = new CiudadDaoImpl();
			ciudades = ciudad.obtener();
			assertTrue(ciudades.size() > 0);
			
		}catch(ClaseExceptionDao e){
			fail(e.getMessage());
			
		}
		
	}

	@Test
	public void testObtenerUna() {
		
		ciudadDao ciudadDao = null;
		Ciudad ciudad = null;
		
		
		try{
			ciudadDao = new CiudadDaoImpl();
			ciudad = ciudadDao.obtener(1);
			assertTrue(ciudad!=null);
			
		}catch(ClaseExceptionDao e){
			fail(e.getMessage());
			
		}
		
	}
	
	@Test
	public void agregarUna() {
		
		ciudadDao ciudadDao = null;
		Ciudad ciudad = null;
		
		
		try{
			ciudadDao = new CiudadDaoImpl();
			ciudad = ciudadDao.obtener(1);
			assertTrue(ciudad!=null);
			
		}catch(ClaseExceptionDao e){
			fail(e.getMessage());
			
		}
		
	}
	
}
