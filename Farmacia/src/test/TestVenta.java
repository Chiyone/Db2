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
		abm.agregar("abc123", 15.0, null, null, null, sucAbm.traerSucursal(1));
		abm.traerVenta(1);
		System.out.println(abm.traerVenta(1));
		
	//+traer ventas cuando pago= null
		
		
	}

}
