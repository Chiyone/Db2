package negocio;

import java.util.List;

import dao.PagoDao;
import dao.PersonaDao;
 
import datos.Pago;
import datos.PagoCheque;
import datos.Persona;
import datos.Venta;

public class PagoChequeABM {
	private static PagoChequeABM instancia = null ; // Patrón Singleton
	public PagoChequeABM() {}
	public static PagoChequeABM getInstance(){
		if ( instancia == null )
			instancia = new PagoChequeABM();
		return instancia ;
	}

	

	public int agregar(double monto, Persona cliente, String tpoPago,Venta venta ,long numCuenta, String banco) {
		PagoCheque d=new PagoCheque( monto,  cliente, tpoPago,venta,  numCuenta, banco);
		return PagoDao.getInstance().agregar(d);
		
	}
	
	public List<PagoCheque> traerPagosCheque() throws Exception{
		if(PagoDao.getInstance().traerPagosCheque()!=null){
		return PagoDao.getInstance().traerPagosCheque();
		}else throw new Exception ("No hay Clientes en la base de datos");
	}
	public void modificar(PagoCheque s) throws Exception{
		if((PagoDao.getInstance().traer(s.getIdPagoCheque()))==null){
			PagoDao.getInstance().actualizar(s);
		}else throw new Exception ("ID repetido en la actualización");
	}
	
	public void eliminar(long idPagoCheque) throws Exception{
		Pago c=PagoDao.getInstance().traer(idPagoCheque);
		if(c!=null){
			PagoDao.getInstance().eliminar(c);
		}else throw new Exception ("Pago no existe para eliminar");
	}
	

}
