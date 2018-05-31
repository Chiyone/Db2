package test;

import negocio.ProductoABM;

public class TestProducto {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		ProductoABM abm=new ProductoABM();
		abm.agregar(1222, "amoxilina", "pastillas", 20, "Vanier");
		System.out.println(abm.traerProducto(1));
		
		
	}

}