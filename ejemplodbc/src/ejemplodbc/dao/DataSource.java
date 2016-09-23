package ejemplodbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ejemplodbc.exception.ClaseExceptionDao;

/**
 * fuente de conexion para acceder a la base de datos de ejemplo clase
 * @author alejandro.isazad
 *
 */
public class DataSource {
	
	private  static DataSource instancia;
	
private DataSource(){
		
	}
	
	public static DataSource getInstance(){
		if (instancia == null) {
			instancia = new DataSource();
		}
		return instancia;
	}
	
	public Connection getConnection() throws ClaseExceptionDao{
		
		Connection connection = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clase","root","");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ClaseExceptionDao("No se encontro el driver de la base de datos");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	

}
