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

}
