package negocio;

import java.util.List;

import dao.PagoDao;
import dao.PersonaDao;
import datos.Cliente;
import datos.Pago;
import datos.PagoCheque;
import datos.PagoEfectivo;
import datos.Venta;


public class PagoEfectivoABM {
	private static PagoEfectivoABM instancia = null ; // Patr�n Singleton
	public PagoEfectivoABM() {}
	public static PagoEfectivoABM getInstance(){
		if ( instancia == null )
			instancia = new PagoEfectivoABM();
		return instancia ;
	}

	

	public int agregar(double monto, Cliente cliente, String tpoPago,Venta venta, double vuelto) {
		PagoEfectivo d=new PagoEfectivo( monto,  cliente, tpoPago,venta, vuelto);
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
		}else throw new Exception ("ID repetido en la actualizaci�n");
	}
	
	public void eliminar(long idPagoEfectivo) throws Exception{
		Pago c=PagoDao.getInstance().traer(idPagoEfectivo);
		if(c!=null){
			PagoDao.getInstance().eliminar(c);
		}else throw new Exception ("Pago no existe para eliminar");
	}

}