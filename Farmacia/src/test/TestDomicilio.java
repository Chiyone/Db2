package test;

import java.util.Set;

import negocio.DomicilioABM;



public class TestDomicilio {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		DomicilioABM abm=new DomicilioABM();
		abm.agregar("san ignacio", 390, "Buenos Aires", "Longchamps");
		abm.traerDomicilio(1);
		
		
	}

}
