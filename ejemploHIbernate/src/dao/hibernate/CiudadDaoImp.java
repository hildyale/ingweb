package dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
	
	
	@Override
	public Ciudad obtenerUna(String codigo) throws MyDaoException {
		Session session = null;
		Ciudad ciudad= null;
		
		try {
			session = DataSource.getInstance().getSession(); 
			Criteria crit = session.createCriteria(Ciudad.class).add(Restrictions.eq("codigo", codigo));
			ciudad = (Ciudad) crit.uniqueResult(); 
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoException(e);
		}
		return ciudad;
	}

	@Override
	public void guardar(Ciudad ciudad) throws MyDaoException {
		Session session = null;
		
		
		try {
			session = DataSource.getInstance().getSession();
			session.save(ciudad);
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoException(e);
		}
		
		
	}

	@Override
	public void modificar(Ciudad ciudad) throws MyDaoException {

		Session session = null;
		
		
		try {
			session = DataSource.getInstance().getSession();
			session.update(ciudad);
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoException(e);
		}
		
	}

	@Override
	public void eliminar(String codigo) throws MyDaoException {

		Session session = null;
		Ciudad ciudad = new Ciudad();
		ciudad.setCodigo(codigo);
		
		
		try {
			session = DataSource.getInstance().getSession();
			session.delete(ciudad);
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoException(e);
		}
	}
	
	
}
