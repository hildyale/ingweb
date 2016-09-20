package ejemplodbc.iw;


import java.util.List;

import ejemplodbc.dao.ciudadDao;
import ejemplodbc.dao.impl.CiudadDaoImpl;
import ejemplodbc.dto.Ciudad;
import ejemplodbc.exception.ClaseExceptionDao;

/**
 * Clase para consultar las ciudades
 * 
 * @author alejandro.isazad
 *
 */
public class consultarCiudades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ciudadDao ciudad = new CiudadDaoImpl();
		try{
			
			List<Ciudad> ciudades = ciudad.obtener();
			int size = ciudades.size();
			Ciudad ciu;
		    for(int x=0;x<size;x++) {
		        ciu = (Ciudad)ciudades.get(x);
		        System.out.println("/**********************/");
		        System.out.println(ciu.getNombre());
		        System.out.println(ciu.getCodigo());
                System.out.println(ciu.getCodigoArea());
		    }
		}catch(ClaseExceptionDao e){
			
			e.getMessage();
		}
		
	}

}
