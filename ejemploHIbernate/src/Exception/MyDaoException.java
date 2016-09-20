package Exception;

import org.apache.log4j.Logger;

public class MyDaoException extends Exception {
	
	Logger Log = Logger.getLogger(this.getClass());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyDaoException(String message, Throwable cause) {
		super(message, cause);
		Log.error(message);
	}

	public MyDaoException(Throwable cause) {
		super(cause);
		Log.error(cause.getMessage());
	}
	

}
