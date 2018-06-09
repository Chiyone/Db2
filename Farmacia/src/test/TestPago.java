package test;


import negocio.DomicilioABM;
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
		abm.agregar("abc123", 15.0, null, null, null, sucAbm.traerSucursal(1));
		System.out.println(abm.traerVenta(1));
		abm.agregar("abc111", 15.0, null, null, null, sucAbm.traerSucursal(1));
		System.out.println(abm.traerVenta(2));
		abm.agregar("abc222", 15.0, null, null, null, sucAbm.traerSucursal(1));
		System.out.println(abm.traerVenta(3));
		abm.agregar("abc333", 15.0, null, null, null, sucAbm.traerSucursal(1));
		System.out.println(abm.traerVenta(4));
		abm.agregar("abc444", 15.0, null, null, null, sucAbm.traerSucursal(1));
		System.out.println(abm.traerVenta(5));
		abm.agregar("abc555", 15.0, null, null, null, sucAbm.traerSucursal(1));
		System.out.println(abm.traerVenta(6));
		
		
		PagoABM.getInstance().agregar(55, null, "qti",abm.traerVenta(6));
		
		PagoChequeABM.getInstance().agregar(33, null, "cheque",abm.traerVenta(2), 111111, "cabal");
		PagoEfectivoABM.getInstance().agregar(44, null, "efectivo",abm.traerVenta(3), 4);
		PagoTarjetaABM.getInstance().agregar(80, null, "tarjeta",abm.traerVenta(4), 444433333, 4, 20);
		System.out.println("traer1=\n");
		System.out.println(PagoABM.getInstance().traer(1));
		
		System.out.println("traer2=\n");
		System.out.println(PagoABM.getInstance().traer(2));
		
		System.out.println("traer3=\n");
		System.out.println(PagoABM.getInstance().traer(3));
		
		System.out.println("traer4=\n");
		System.out.println(PagoABM.getInstance().traer(4));
		
		System.out.println("traer all pagos=\n");
		System.out.println(PagoABM.getInstance().traer());
		
		System.out.println("traer all pagosCheque=\n");
		System.out.println(PagoChequeABM.getInstance().traerPagosCheque());
		
		System.out.println("traer all pagosEfectivo=\n");
		System.out.println(PagoEfectivoABM.getInstance().traerPagosEfectivo());
		
		System.out.println("traer all pagosTarjeta=\n");
		System.out.println(PagoTarjetaABM.getInstance().traerPagosTarjeta());
		
		
	}

}
