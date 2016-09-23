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
	
	@Test
	public void testGuardarCiudad(){
		ciudadDao ciudadDao = null;
		Ciudad ciudad = null;
		
		try{
			
			ciudad = new Ciudad();
			ciudad.setCodigo("12");
			ciudad.setNombre("Venecia");
			ciudad.setCodigoArea("071");
			
			ciudadDao = new CiudadDaoImpl();	
			ciudadDao.guardar(ciudad);		
			//Establece si la prueba fue satisfactoria
			assertTrue(true);
		}catch(ClaseExceptionDao e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
}
