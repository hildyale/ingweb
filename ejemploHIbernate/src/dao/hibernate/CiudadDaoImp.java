package dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import Exception.MyDaoException;
import dao.CiudadDao;
import dao.DataSource;
import dto.Ciudad;

public class CiudadDaoImp implements CiudadDao {

	@Override
	public List<Ciudad> obtener() throws MyDaoException {
		Session session = null;
		List<Ciudad> resultado = null;
		
		try{
			session = DataSource.getInstance().getSession();
			Criteria crit = session.createCriteria(Ciudad.class);
			
			resultado = crit.list();
			
		}catch(HibernateException e){
			throw new MyDaoException(e);
		}
		return resultado;
	}

}
