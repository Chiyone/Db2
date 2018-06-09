package test;

import datos.Domicilio;
import datos.Sucursal;
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

public class TestVenta {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
	
	
		
		
		
		
		SucursalABM sucAbm=new SucursalABM();
		VentaABM abm=new VentaABM();
		DomicilioABM abmdom = new DomicilioABM();
		abmdom.agregar("Azara", 2069, "Buenos Aires", "Banfield");
		sucAbm.agregar("baradero", abmdom.traerDomicilio(1));
		EmpleadoABM.getInstance().agregar(4444, "eee", "Son",abmdom.traerDomicilio(1), 1111111, 111, null, sucAbm.traerSucursal(1),"Encargado");
		
		System.out.println(EmpleadoABM.getInstance().traer(1));
		abm.agregar("abc123", 15.0, null, EmpleadoABM.getInstance().traer(1), PersonaABM.getInstance().traer(1), sucAbm.traerSucursal(1));
		abm.traerVenta(1);
		System.out.println(abm.traerVenta(1));
		
	//+traer ventas cuando pago= null
		
		
	}

}
