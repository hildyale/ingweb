package co.edu.udea.logica.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.exception.MyDaoException;
import co.edu.udea.logica.Clienteb1;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring_config.xml"})
public class ClienteB1implTest {

	@Autowired
	Clienteb1 clienteb1;
	
	@Test
	public void testCrearCliente() {
		try{
			String a = "alejo";
			String b = "alejo";
			String c = "alejo";
			String d = "alejo";
			String e = "alejo";
			
			clienteb1.crearCliente(a,b,c,d,e);
			
		}catch(MyDaoException | NullPointerException e){
			fail(e.getMessage());
		}
		
	}

}
