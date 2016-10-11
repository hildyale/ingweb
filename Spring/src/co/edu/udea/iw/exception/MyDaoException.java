package co.edu.udea.iw.exception;

import org.apache.log4j.Logger;

public class MyDaoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(this.getClass());

	public MyDaoException(String message) {
		super(message);
		log.error(message);
	}

	public MyDaoException(Throwable cause) {
		super(cause);
		log.error(cause.getMessage());
	}
	
	

}
