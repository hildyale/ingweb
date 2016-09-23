package ejemplodbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ejemplodbc.dao.DataSource;
import ejemplodbc.dao.ciudadDao;
import ejemplodbc.dto.Ciudad;
import ejemplodbc.exception.ClaseExceptionDao;

public class CiudadDaoImpl implements ciudadDao {

	@Override
	public List<Ciudad> obtener() throws ClaseExceptionDao {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Ciudad> resultado = new ArrayList<Ciudad>();
		
		try{
		connection = DataSource.getInstance().getConnection();
        ps = connection.prepareStatement("select * from ciudades");
		
		rs = ps.executeQuery();
		
		while (rs.next()){
			Ciudad ciudad = new Ciudad();
			ciudad.setCodigo(rs.getString("Codigo"));
			ciudad.setNombre(rs.getString("Nombre"));
			ciudad.setCodigoArea(rs.getString("CodigoArea"));
			
			resultado.add(ciudad);
		}
		
	
		}catch(SQLException e){
			throw new ClaseExceptionDao(e);
		}finally{
			try{
			if(rs !=null){
			rs.close();
			}
			if(ps != null){
			ps.close();
			}
			if(connection != null){
			connection.close();
			}
			}catch(SQLException e){
				throw new ClaseExceptionDao();
				
			}
		}
		
		return resultado;
	}

	@Override
	public Ciudad obtener(int codigo) throws ClaseExceptionDao {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Ciudad resultado = null;
		
		try{
		connection = DataSource.getInstance().getConnection();
        ps = connection.prepareStatement("select * from ciudades where codigo=?");
        ps.setInt(1, codigo);
		
		rs = ps.executeQuery();
		
		if (rs.next()){
			
			resultado = new Ciudad();
			resultado.setCodigo(rs.getString("Codigo"));
			resultado.setNombre(rs.getString("Nombre"));
			resultado.setCodigoArea(rs.getString("CodigoArea"));
			
		}
		
	
		}catch(SQLException e){
			throw new ClaseExceptionDao(e);
		}finally{
			try{
			if(rs !=null){
			rs.close();
			}
			if(ps != null){
			ps.close();
			}
			if(connection != null){
			connection.close();
			}
			}catch(SQLException e){
				throw new ClaseExceptionDao();
				
			}
		}
		
		return resultado;
	}
	
	@Override 
	public void guardar(Ciudad ciudad) throws ClaseExceptionDao{
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			c = DataSource.getInstance().getConnection();
			//meter en ps param codigo puede provocar sql injection
			ps = c.prepareStatement("INSERT INTO ciudades (codigo, Nombre,CodigoArea) VALUES(?,?,?)");
			//esto evita el sqlinjection
			ps.setString(1, ciudad.getCodigo());
			ps.setString(2, ciudad.getNombre());
			ps.setString(3, ciudad.getCodigoArea());
			
			ps.execute();
			
		}catch(SQLException e){
			throw new ClaseExceptionDao(e);
		}finally {
			//Se cierran todas las conexiones solo si no son nulas
			try {	
				if(ps!=null)
					ps.close();
				
				if(c != null)
					c.close();
			} catch (SQLException e2) {
			throw new ClaseExceptionDao(e2);					
			}
		}
		
		
	}

}


