package test;

import java.util.Set;

import datos.Domicilio;
import negocio.DomicilioABM;



public class TestDomicilio {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		DomicilioABM abm=new DomicilioABM();
		Domicilio dom=new Domicilio("san ignacio", 390, "Buenos Aires", "Longchamps");
		abm.agregar(dom);
		abm.traerDomicilio(1);
		
		
	}

}
