package test;

import negocio.DomicilioABM;
import negocio.PagoABM;
import negocio.PagoChequeABM;
import negocio.PagoEfectivoABM;
import negocio.PagoTarjetaABM;
import negocio.SucursalABM;
import negocio.VentaABM;

public class TestVenta {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		SucursalABM sucAbm=new SucursalABM();
		VentaABM abm=new VentaABM();
		DomicilioABM abmdom = new DomicilioABM();
		abmdom.agregar("Azara", 2069, "Buenos Aires", "Banfield");
		sucAbm.agregar("baradero", abmdom.traerDomicilio(1));
		
		PagoABM.getInstance().agregar(55, null, "qti");
		PagoChequeABM.getInstance().agregar(33, null, "cheque", 111111, "cabal");
		PagoEfectivoABM.getInstance().agregar(44, null, "efectivo", 4);
		PagoTarjetaABM.getInstance().agregar(80, null, "tarjeta", 444433333, 4, 20);
		System.out.println("traer1=\n");
		System.out.println(PagoABM.getInstance().traer(1));
		
		System.out.println("traer2=\n");
		System.out.println(PagoABM.getInstance().traer(2));
		
		System.out.println("traer3=\n");
		System.out.println(PagoABM.getInstance().traer(3));
		
		System.out.println("traer4=\n");
		System.out.println(PagoABM.getInstance().traer(4));
		
		
		abm.agregar("abc123", 15.0, null, null, null, sucAbm.traerSucursal(1),PagoABM.getInstance().traer(3));
		abm.traerVenta(3);
		System.out.println(abm.traerVenta(3));
		//eliminar foreing de mapeo de venta 
		//agregar forening al mapeo de pago
		//agregar constructor a pago.venta
		//eliminar constructor de venta.pago
		
	}

}
