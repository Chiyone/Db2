
package negocio;

import java.util.List;
import java.util.Set;

import dao.SucursalDao;
import datos.Domicilio;
import datos.Empleado;
import datos.Sucursal;
public class SucursalABM {
	
	SucursalDao dao = new SucursalDao();


	public Sucursal traerSucursal(long idSucursal) throws Exception {
		Sucursal c = dao.traerSucursal(idSucursal);
			if(c==null)
				throw new Exception ("Id incorrecto: la Sucursal no existe");
		return c;
	}
	
	
	public int agregar(Sucursal s) {
		//Sucursal s=new Sucursal(sucursal, domicilio);
		return dao.agregar(s);
		
	}
	
	public void modificar(Sucursal s) throws Exception{
		if((dao.traerSucursal(s.getIdSucursal()))==null){
			dao.actualizar(s);
		}else throw new Exception ("ID repetido en la actualización");
	}
	
	public void eliminar(long idSucursal) throws Exception{
		Sucursal c=dao.traerSucursal(idSucursal);
		if(c!=null){
		dao.eliminar(c);
		}else throw new Exception ("Sucursal no existe para eliminar");
	}
	
	
	public List<Sucursal> traerSucursal() throws Exception{
		if(dao.traerSucursal()!=null){
		return dao.traerSucursal();
		}else throw new Exception ("No haySucursales en la base de datos");
	}
	

}