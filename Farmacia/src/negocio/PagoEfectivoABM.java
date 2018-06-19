package negocio;

import java.util.List;

import dao.PagoDao;
import dao.PersonaDao;
 
import datos.Pago;
import datos.PagoCheque;
import datos.PagoEfectivo;
import datos.Persona;
import datos.Venta;


public class PagoEfectivoABM {
	private static PagoEfectivoABM instancia = null ; // Patrón Singleton
	public PagoEfectivoABM() {}
	public static PagoEfectivoABM getInstance(){
		if ( instancia == null )
			instancia = new PagoEfectivoABM();
		return instancia ;
	}

	

	public int agregar( Persona cliente,Venta venta) {
		 String tpoPago="Efectivo";
		
			double monto=venta.getTotalVenta();
			
		Pago d=new Pago( monto,  cliente, tpoPago,venta);
		return PagoDao.getInstance().agregar(d);
		
		
	}
	
	public List<Pago> traerPagosEfectivo() throws Exception{
		if(PagoDao.getInstance().traerPagosEfectivo()!=null){
		return PagoDao.getInstance().traerPagosEfectivo();
		}else throw new Exception ("No hay Pagos en la base de datos");
	}
	
	public void modificar(PagoEfectivo s) throws Exception{
		if((PagoDao.getInstance().traer(s.getIdPagoEfectivo()))==null){
			PagoDao.getInstance().actualizar(s);
		}else throw new Exception ("ID repetido en la actualización");
	}
	
	public void eliminar(long idPagoEfectivo) throws Exception{
		Pago c=PagoDao.getInstance().traer(idPagoEfectivo);
		if(c!=null){
			PagoDao.getInstance().eliminar(c);
		}else throw new Exception ("Pago no existe para eliminar");
	}

}