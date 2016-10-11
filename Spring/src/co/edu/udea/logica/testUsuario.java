package co.edu.udea.logica;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.dao.UsuarioDao;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring_config.xml"})

public class testUsuario {
	
private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	UsuarioDao dao;
    

    public Boolean validar(String login,String pass){
		try {
			Usuario user = new Usuario();
			user = dao.obtener(login);
			if (user!=null && user.getContrasena().equals(pass)){
				return true;
			}

		} catch (MyDaoException e) {
			e.printStackTrace();
		}
		return false;
    }	

	

}
