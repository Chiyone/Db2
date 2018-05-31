package negocio;

import java.util.List;


import dao.ObraSocialDao;
import datos.ObraSocial;



public class ObraSocialABM {
	ObraSocialDao dao = new ObraSocialDao();

	public ObraSocial traerObraSocial(long idObraSocial) throws Exception {
		ObraSocial c = dao.traerObraSocial(idObraSocial);
			if(dao.traerObraSocial(idObraSocial)==null)
				throw new Exception ("Id incorrecto: la ObraSocial no existe");
		return c;
	}
	
	
	public int agregar(String nombre) {
		ObraSocial s=new ObraSocial(  nombre);
		return dao.agregar(s);
		
	}
	
	public void modificar(ObraSocial s) throws Exception{
		if((dao.traerObraSocial(s.getIdObraSoc()))==null){
			dao.actualizar(s);
		}else throw new Exception ("ID repetido en la actualización");
	}
	
	public void eliminar(long idObraSocial) throws Exception{
		ObraSocial c=dao.traerObraSocial(idObraSocial);
		if(c!=null){
		dao.eliminar(c);
		}else throw new Exception ("ObraSocial no existe para eliminar");
	}
	
	
	public List<ObraSocial> traerSucursal() throws Exception{
		if(dao.traerObraSocial()!=null){
		return dao.traerObraSocial();
		}else throw new Exception ("No hay ObraSociales en la base de datos");
	}


}