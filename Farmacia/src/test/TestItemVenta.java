package test;

import datos.Producto;
import datos.Venta;
import negocio.DomicilioABM;
import negocio.EmpleadoABM;
import negocio.ItemVentaABM;
import negocio.PersonaABM;
import negocio.ProductoABM;
import negocio.SucursalABM;
import negocio.VentaABM;

public class TestItemVenta {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		
	
		SucursalABM sucAbm=new SucursalABM();
		VentaABM abm=new VentaABM();
		DomicilioABM abmdom = new DomicilioABM();
		abmdom.agregar("Azara", 2069, "Buenos Aires", "Banfield");
		sucAbm.agregar("baradero", abmdom.traerDomicilio(1));
	
		EmpleadoABM.getInstance().agregar(4444, "eee", "Son",abmdom.traerDomicilio(1), 1111111, 111, null, sucAbm.traerSucursal(1),"Encargado");
		
		System.out.println(EmpleadoABM.getInstance().traer(1));
		abm.agregar( 15.0, null, EmpleadoABM.getInstance().traer(1), PersonaABM.getInstance().traer(1), sucAbm.traerSucursal(1));
		abm.traerVenta(1);
		
		
		ItemVentaABM abm2=new ItemVentaABM();
		ProductoABM prodAbm = new ProductoABM();
		prodAbm.agregar(10, "asd", "tipo", 53, "cofaloza");
		
		Producto prod = prodAbm.traerProducto(1);
		Venta ven=abm.traerVenta(1);
		abm2.agregar(prod, 4,  ven);
		System.out.println(abm2.traerItemVenta(1));
		System.out.println("\n"+abm.traerVenta(1));
		System.out.println("\n"+abm.traerVenta(1).getItemsVenta());
	}

}
