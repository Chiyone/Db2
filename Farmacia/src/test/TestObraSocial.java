package test;

import java.util.Set;

import datos.Afiliado;
import datos.Domicilio;
import negocio.AfiliadoABM;
import negocio.DomicilioABM;
import negocio.ObraSocialABM;
import negocio.PersonaABM;



public class TestObraSocial {
	
	public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	
	
	DomicilioABM dabm = new DomicilioABM();
	
	Domicilio dom1 = new Domicilio("San ignacio", 2069, "Buenos Aires", "Banfield");
	dabm.agregar(dom1);
	PersonaABM.getInstance().agregar(39666566, "juju", "yoyo", dom1);
	PersonaABM.getInstance().agregar(39666566, "juju", "yoyo", dom1);
	PersonaABM.getInstance().agregar(39666566, "juju", "yoyo", dom1);
	AfiliadoABM abm=new AfiliadoABM();
	ObraSocialABM sSoc=new ObraSocialABM();
	sSoc.agregar("FATSA");
	Afiliado afi=new Afiliado(1123,sSoc.traerObraSocial(1),PersonaABM.getInstance().traer(1));
	Afiliado afi2=new Afiliado(1123,sSoc.traerObraSocial(1),PersonaABM.getInstance().traer(3));
	/*abm.agregar(afi);
	abm.agregar(afi2);*/
	
	
	
	
	
}

}