package test;


import java.util.List;
import java.util.Set;

import datos.Empleado;
import datos.Cliente;
import datos.Domicilio;
import datos.Persona;
import negocio.ClienteABM;
import negocio.DomicilioABM;
import negocio.EmpleadoABM;
import negocio.PersonaABM;;



public class TestPersona {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DomicilioABM abm = new DomicilioABM();
		abm.agregar("Azara", 2069, "Buenos Aires", "Banfield");
		Domicilio dom = abm.traerDomicilio(1);
		PersonaABM.getInstance().agregar(39666566, "juju", "yoyo", null);
		ClienteABM.getInstance().agregar(3333333, "lulu", "hh", null, 222222, null);
		EmpleadoABM.getInstance().agregar(4444, "eee", "San", null, 1111111, 222111, null, null);
	/*	System.out.println("traer1=\n");
		System.out.println(PersonaABM.getInstance().traer(1));
		System.out.println("traer2=\n");
		System.out.println(PersonaABM.getInstance().traer(2));
		System.out.println("traer3=\n");
		System.out.println(PersonaABM.getInstance().traer(3));
		System.out.println("traer4=\n");
		System.out.println(PersonaABM.getInstance().traer(4));
		System.out.println("traer5=\n");
		System.out.println(PersonaABM.getInstance().traer(5));
		System.out.println("traer all=\n");
		System.out.println(PersonaABM.getInstance().traer());
		System.out.println("traer all clientes=\n");
		System.out.println(ClienteABM.getInstance().traerClientes());
		System.out.println("traer all empleados=\n");
		System.out.println(EmpleadoABM.getInstance().traerEmpleados());*/

		
		
		
		
	}

}
