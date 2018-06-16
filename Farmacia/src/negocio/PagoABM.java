package negocio;

import java.util.List;
import java.util.Set;

import dao.PagoDao;
import dao.PersonaDao;

import datos.Domicilio;
import datos.ItemVenta;
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
	public int agregar( Persona cliente, String tpoPago,Venta venta) {
		double monto=calcularMonto(venta);
		
		Pago s=new Pago( monto, cliente, tpoPago,venta);
		return PagoDao.getInstance().agregar(s);
		
	}
	
	static double calcularMonto(Venta venta) {
		double precio=0;
		List <ItemVenta> ventas=PagoDao.getInstance().traerItemsVenta(venta);
		for(ItemVenta i:ventas)
			precio=i.getPrecioTotal()+precio;
			
			
		System.out.println(ventas);
		
		return precio;
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