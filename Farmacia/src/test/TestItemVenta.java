package test;

import datos.Producto;
import negocio.ItemVentaABM;
import negocio.ProductoABM;

public class TestItemVenta {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		ItemVentaABM abm=new ItemVentaABM();
		/*abm.agregar(null, 5, 55, 11,null);*/
		ItemVentaABM abm2=new ItemVentaABM();
		ProductoABM prodAbm = new ProductoABM();
		prodAbm.agregar(10, "asd", "tipo", 53, "cofaloza");
		System.out.println(prodAbm.traerProducto(1));
		Producto prod = prodAbm.traerProducto(1);
		abm2.agregar(prod, 4, 44, 44, null);
	}

}
