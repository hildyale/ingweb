package dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import Exception.MyDaoException;
import dao.DataSource;
import dao.UsuarioDao;
import dto.Usuario;

public class UsuarioDaoImp implements UsuarioDao {

	@Override
	public List<Usuario> obtener() throws MyDaoException {
		Session session = null;
		List<Usuario> resultado = null;
		
		try{
			session = DataSource.getInstance().getSession();
			Criteria crit = session.createCriteria(Usuario.class);
			
			resultado = crit.list();
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
		return resultado;
	}

}
