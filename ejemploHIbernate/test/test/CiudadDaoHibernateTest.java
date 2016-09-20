package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import Exception.MyDaoException;
import dao.CiudadDao;
import dao.hibernate.CiudadDaoImp;
import dto.Ciudad;

public class CiudadDaoHibernateTest {

	@Test
	public void testObtener() {
			
			CiudadDao ciudad = null;
			List<Ciudad> ciudades = null;
			
			
			try{
				ciudad = new CiudadDaoImp();
				ciudades = ciudad.obtener();
				assertTrue(ciudades.size() > 0);
				
			}catch(MyDaoException e){
				fail(e.getMessage());
				
			}
			
		}

}
