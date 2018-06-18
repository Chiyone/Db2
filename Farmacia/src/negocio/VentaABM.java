package negocio;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import dao.VentaDao;
import datos.Empleado;
import datos.ItemVenta;
import datos.Pago;
import datos.Persona;
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

	/*
	public int agregar(String numTicket, double totalVenta, GregorianCalendar fecha, Empleado eAtendio, Empleado eCobro,
			Sucursal sucursal) {
		Venta s=new Venta( numTicket, totalVenta, fecha,eAtendio, eCobro,sucursal);
		return dao.agregar(s);
		
	}*/
	public int agregar( double totalVenta, GregorianCalendar fecha, Empleado eAtendio, Persona eCobro,
			Sucursal sucursal) {
	
		
		String numTicket=agregarNumTicket(sucursal);
		
		
		Venta s=new Venta( numTicket, fecha,eAtendio, eCobro,sucursal);
		return dao.agregar(s);
		
	}
	
	public String agregarNumTicket(Sucursal sucursal) {
		String idVenta =traerIdVenta()+"";
		String ptoVenta=sucursal.getIdSucursal()+"";
		ptoVenta=cuatroDigitos(ptoVenta);
		idVenta=ochoDigitos(idVenta);	
		
		String numTicket=""+ptoVenta+"-"+idVenta+"";
		
		return numTicket;
	}

	public void modificar(Venta s) throws Exception{
		if((dao.traerVenta(s.getIdVenta()))!=null){
			dao.actualizar(s);
		}else throw new Exception ("ID repetido en la actualizaci�n");
	}
	
	public void eliminar(long idVenta) throws Exception{
		Venta c=dao.traerVenta(idVenta);
		if(c!=null){
		dao.eliminar(c);
		}else throw new Exception ("Venta no existe para eliminar");
	}
	
	
	public List<Venta> traerVenta() throws Exception{
		
		return dao.traerVenta();
		
	}

	public List<Venta> traerVentaF() throws Exception{
		if(dao.traerVentaF()!=null){
		return dao.traerVentaF();
		}else throw new Exception ("No hay Ventas en la base de datos");
	}
	public long traerIdVenta() {
		List <Venta> ventas =dao.traerVenta();
		
		long c=0;
		if(ventas.isEmpty())
			c=0;
		else {
		for(Venta v :ventas) {
			
			if(v.getIdVenta()>=c)
				c=v.getIdVenta();
			}
		}
		
		return c+1;
	}
	static String ochoDigitos(String string) {
		if (string.length()==1)
			string="0000000"+string;
		if (string.length()==2)
			string="000000"+string;
		if (string.length()==3)
			string="00000"+string;
		if (string.length()==4)
			string="0000"+string;
		if (string.length()==5)
			string="000"+string;
		if (string.length()==6)
			string="00"+string;
		if (string.length()==7)
			string="0"+string;
		
		
		
		return string;
	}
	static String cuatroDigitos(String string) {
	
		if (string.length()==1)
			string="000"+string;
		if (string.length()==2)
			string="00"+string;
		if (string.length()==3)
			string="0"+string;
		
		
		
		return string;
	}

	public List<Venta> traerVenta(GregorianCalendar fecha1, GregorianCalendar fecha2) throws Exception {
		if(dao.traerVenta(fecha1,fecha2)!=null){
			return dao.traerVenta(fecha1,fecha2);
			}else throw new Exception ("En estas fechas no hay Ventas en la base de datos");
		}
	}

