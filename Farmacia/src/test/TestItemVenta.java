package test;

import datos.Producto;
import datos.Venta;
import negocio.ItemVentaABM;
import negocio.ProductoABM;
import negocio.VentaABM;

public class TestItemVenta {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		ItemVentaABM abm=new ItemVentaABM();
		/*abm.agregar(null, 5, 55, 11,null);*/
		ItemVentaABM abm2=new ItemVentaABM();
		ProductoABM prodAbm = new ProductoABM();
		prodAbm.agregar(10, "asd", "tipo", 53, "cofaloza");
		
		VentaABM venAbm=new VentaABM();
		venAbm.agregar("1233",40, null, null, null, null, null);
		
		System.out.println(prodAbm.traerProducto(1));
		System.out.println(venAbm.traerVenta(1));
		
		Producto prod = prodAbm.traerProducto(1);
		Venta ven=venAbm.traerVenta(1);
		abm2.agregar(prod, 4, 44, 44, ven);
		System.out.println(abm2.traerItemVenta(1));
	}

}
