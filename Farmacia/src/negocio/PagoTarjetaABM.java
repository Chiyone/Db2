package negocio;

import java.util.List;

import dao.PagoDao;
import dao.PersonaDao;
import datos.Cliente;
import datos.Pago;
import datos.PagoEfectivo;
import datos.PagoTarjeta;
import datos.Venta;


public class PagoTarjetaABM {
	private static PagoTarjetaABM instancia = null ; // Patrón Singleton
	public PagoTarjetaABM() {}
	public static PagoTarjetaABM getInstance(){
		if ( instancia == null )
			instancia = new PagoTarjetaABM();
		return instancia ;
	}

	

	public int agregar(double monto, Cliente cliente, String tpoPago,Venta venta,  long tarjeta, int cantCuotas,
			double precioCuota) {
		PagoTarjeta d=new PagoTarjeta( monto,  cliente, tpoPago, venta ,tarjeta, cantCuotas,precioCuota);
		return PagoDao.getInstance().agregar(d);
		
	}
	public List<Pago> traerPagosTarjeta() throws Exception{
		if(PagoDao.getInstance().traerPagosTarjeta()!=null){
		return PagoDao.getInstance().traerPagosTarjeta();
		}else throw new Exception ("No hay Pagos en la base de datos");
	}

	public void modificar(PagoTarjeta s) throws Exception{
		if((PagoDao.getInstance().traer(s.getIdPagoTarjeta()))==null){
			PagoDao.getInstance().actualizar(s);
		}else throw new Exception ("ID repetido en la actualización");
	}
	
	public void eliminar(long idPagoTarjeta) throws Exception{
		Pago c=PagoDao.getInstance().traer(idPagoTarjeta);
		if(c!=null){
			PagoDao.getInstance().eliminar(c);
		}else throw new Exception ("Pago no existe para eliminar");
	}
	
}