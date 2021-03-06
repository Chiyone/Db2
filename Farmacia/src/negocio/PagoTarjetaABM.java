package negocio;

import java.util.List;

import dao.PagoDao;
import dao.PersonaDao;
 
import datos.Pago;
import datos.PagoEfectivo;
import datos.PagoTarjeta;
import datos.Persona;
import datos.Venta;


public class PagoTarjetaABM {
	private static PagoTarjetaABM instancia = null ; // Patr�n Singleton
	public PagoTarjetaABM() {}
	public static PagoTarjetaABM getInstance(){
		if ( instancia == null )
			instancia = new PagoTarjetaABM();
		return instancia ;
	}

	

	public int agregar( Persona cliente,Venta venta,  long tarjeta, int cantCuotas
			) {
		String tpoPago="Tarjeta";
		double monto=venta.getTotalVenta();
		double precioCuota=monto/cantCuotas;
		PagoTarjeta d=new PagoTarjeta( monto,  cliente, tpoPago, venta ,tarjeta, cantCuotas,precioCuota);
		return PagoDao.getInstance().agregar(d);
		
	}
	public List<PagoTarjeta> traerPagosTarjeta() throws Exception{
		if(PagoDao.getInstance().traerPagosTarjeta()!=null){
		return PagoDao.getInstance().traerPagosTarjeta();
		}else throw new Exception ("No hay Pagos en la base de datos");
	}

	public void modificar(PagoTarjeta s) throws Exception{
		if((PagoDao.getInstance().traer(s.getIdPagoTarjeta()))==null){
			PagoDao.getInstance().actualizar(s);
		}else throw new Exception ("ID repetido en la actualizaci�n");
	}
	
	public void eliminar(long idPagoTarjeta) throws Exception{
		Pago c=PagoDao.getInstance().traer(idPagoTarjeta);
		if(c!=null){
			PagoDao.getInstance().eliminar(c);
		}else throw new Exception ("Pago no existe para eliminar");
	}
	
}