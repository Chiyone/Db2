package test;


import datos.Empleado;
import datos.Persona;
import negocio.ClienteABM;
import negocio.DomicilioABM;
import negocio.EmpleadoABM;
import negocio.PagoABM;
import negocio.PagoChequeABM;
import negocio.PagoEfectivoABM;
import negocio.PagoTarjetaABM;
import negocio.PersonaABM;
import negocio.SucursalABM;
import negocio.VentaABM;

public class TestPago {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SucursalABM sucAbm=new SucursalABM();
		
		DomicilioABM abmdom = new DomicilioABM();
		abmdom.agregar("Azara", 2069, "Buenos Aires", "Banfield");
		sucAbm.agregar("baradero", abmdom.traerDomicilio(1));
		VentaABM abm=new VentaABM();
		EmpleadoABM.getInstance().agregar(4444, "eee", "Son",abmdom.traerDomicilio(1), 1111111, 111, null, sucAbm.traerSucursal(1),"Encargado");
		
		Empleado e=EmpleadoABM.getInstance().traer(1);
		Persona p=PersonaABM.getInstance().traer(1);
		abm.agregar("abc123", 15.0, null, EmpleadoABM.getInstance().traer(1), PersonaABM.getInstance().traer(1), sucAbm.traerSucursal(1));
		abm.traerVenta(1);
		System.out.println(abm.traerVenta(1));
		
		
		
		abm.agregar("abc123", 15.0, null, e, p, sucAbm.traerSucursal(1));
		System.out.println(abm.traerVenta(1));
		abm.agregar("abc111", 15.0, null, e, p, sucAbm.traerSucursal(1));
		System.out.println(abm.traerVenta(2));
		abm.agregar("abc222", 15.0, null, e, p, sucAbm.traerSucursal(1));
		System.out.println(abm.traerVenta(3));
		abm.agregar("abc333", 15.0, null, e, p, sucAbm.traerSucursal(1));
		System.out.println(abm.traerVenta(4));
		abm.agregar("abc444", 15.0, null, e, p, sucAbm.traerSucursal(1));
		System.out.println(abm.traerVenta(5));
		abm.agregar("abc555", 15.0, null, e, p, sucAbm.traerSucursal(1));
		System.out.println(abm.traerVenta(6));
		
		EmpleadoABM.getInstance().agregar(4444, "eee", "Son",abmdom.traerDomicilio(1), 1111111, 111, null, sucAbm.traerSucursal(1),"Encargado");
		
		System.out.println(EmpleadoABM.getInstance().traer(1));
		abm.agregar("abc123", 15.0, null, EmpleadoABM.getInstance().traer(1), PersonaABM.getInstance().traer(1), sucAbm.traerSucursal(1));
		abm.traerVenta(1);
		System.out.println(abm.traerVenta(1));
		ClienteABM.getInstance().agregar(3333, "juan", "yone", abmdom.traerDomicilio(1), 11111, null);
		
		PagoABM.getInstance().agregar(55, ClienteABM.getInstance().traer(3), "qti",abm.traerVenta(1));
		
		PagoABM.getInstance().agregar(33, ClienteABM.getInstance().traer(3), "cheque",abm.traerVenta(2));
		PagoABM.getInstance().agregar(44, ClienteABM.getInstance().traer(3), "efectivo",abm.traerVenta(3));
		PagoABM.getInstance().agregar(80, ClienteABM.getInstance().traer(3), "tarjeta",abm.traerVenta(4));
		/*System.out.println("traer1=\n");
		System.out.println(PagoABM.getInstance().traer(1));
		
		System.out.println("traer2=\n");
		System.out.println(PagoABM.getInstance().traer(2));
		
		System.out.println("traer3=\n");
		System.out.println(PagoABM.getInstance().traer(3));
		
		System.out.println("traer4=\n");
		System.out.println(PagoABM.getInstance().traer(4));
		*/
		System.out.println("traer all pagos=\n");
		System.out.println(PagoABM.getInstance().traer());
		
		/*System.out.println("traer all pagosCheque=\n");
		System.out.println(PagoChequeABM.getInstance().traerPagosCheque());
		
		System.out.println("traer all pagosEfectivo=\n");
		System.out.println(PagoEfectivoABM.getInstance().traerPagosEfectivo());
		
		System.out.println("traer all pagosTarjeta=\n");
		System.out.println(PagoTarjetaABM.getInstance().traerPagosTarjeta());
		*/
		
	}

}
