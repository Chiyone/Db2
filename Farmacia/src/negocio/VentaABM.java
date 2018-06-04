package negocio;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import dao.VentaDao;
import datos.Empleado;
import datos.ItemVenta;
import datos.Pago;
import datos.Sucursal;
import datos.Venta;



public class VentaABM {
	VentaDao dao = new VentaDao();

	public Venta traerVenta(long idVenta) throws Exception {
		Venta c = dao.traerVenta(idVenta);
			if(c==null)
				throw new Exception ("Id incorrecto: la Venta no existe");
		return c;
	}
	
	
	public int agregar(String numTicket, double totalVenta, GregorianCalendar fecha, Empleado eAtendio, Empleado eCobro,
			Sucursal sucursal, Pago pago) {
		Venta s=new Venta( numTicket, totalVenta, fecha,eAtendio, eCobro,sucursal,pago);
		return dao.agregar(s);
		
	}
	
	public void modificar(Venta s) throws Exception{
		if((dao.traerVenta(s.getIdVenta()))==null){
			dao.actualizar(s);
		}else throw new Exception ("ID repetido en la actualización");
	}
	
	public void eliminar(long idVenta) throws Exception{
		Venta c=dao.traerVenta(idVenta);
		if(c!=null){
		dao.eliminar(c);
		}else throw new Exception ("Venta no existe para eliminar");
	}
	
	
	public List<Venta> traerVenta() throws Exception{
		if(dao.traerVenta()!=null){
		return dao.traerVenta();
		}else throw new Exception ("No hay Ventas en la base de datos");
	}


}