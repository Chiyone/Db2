package test;

import negocio.VentaABM;

public class TestVenta {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		VentaABM abm=new VentaABM();
		abm.agregar("abc123", 15.0, null, null, null, null, null, null);
		abm.traerVenta(1);
		
		
	}

}
