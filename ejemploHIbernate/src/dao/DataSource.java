package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Exception.MyDaoException;

/**
 * para entregar sessiones activas a la base de datos
 * @author alejandro.isazad
 *
 */
public class DataSource {
	
	private static DataSource instancia;
	private SessionFactory sessionFactory;
	
	private DataSource(){
		
	}
	
	/**
	 * entrega una instancia del datasource siguiento el patron singleton
	 * @return
	 */
    public static DataSource getInstance() {
    	if (instancia == null){
    		instancia = new DataSource();
    	}
		return instancia;
	}
    
    public Session getSession() throws MyDaoException {
    	try{
    	
    	if(sessionFactory == null){
    		Configuration config = new Configuration();
    		config.configure("hibernate.cfg.xml");
    		sessionFactory = config.buildSessionFactory();
    		
    	}
    	return sessionFactory.openSession();
    	
    	}catch (HibernateException e){
    		throw new MyDaoException(e);
    	}
    }
    
    

}
