package negocio;

import java.util.List;
import java.util.Set;

import dao.PagoDao;
import dao.PersonaDao;
import datos.Cliente;
import datos.Domicilio;
import datos.Pago;
import datos.Persona;
import datos.Venta;



public class PagoABM {

	private static PagoABM instancia = null ; // Patrón Singleton
	public PagoABM() {}
	public static PagoABM getInstance(){
		if ( instancia == null )
			instancia = new PagoABM();
		return instancia ;
	}

	public Pago traer( int idPago ){
		return PagoDao.getInstance().traer(idPago);
	}
	public List<Pago> traer(){
		return PagoDao.getInstance().traer();
	}
	public int agregar(double monto, Cliente cliente, String tpoPago,Venta venta) {
		Pago s=new Pago( monto, cliente, tpoPago,venta);
		return PagoDao.getInstance().agregar(s);
		
	}
	
	public void modificar(Pago s) throws Exception{
		if((PagoDao.getInstance().traer(s.getIdPago()))==null){
			PagoDao.getInstance().actualizar(s);
		}else throw new Exception ("ID repetido en la actualización");
	}
	
	public void eliminar(long idPago) throws Exception{
		Pago c=PagoDao.getInstance().traer(idPago);
		if(c!=null){
			PagoDao.getInstance().eliminar(c);
		}else throw new Exception ("Pago no existe para eliminar");
	}
	
}