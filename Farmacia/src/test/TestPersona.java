package test;
import negocio.SucursalABM;

import java.util.List;
import java.util.Set;

import datos.Empleado;
import datos.Cliente;
import datos.Persona;
import negocio.PersonaABM;;



public class TestPersona {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("traer1=\n");
		System.out.println(PersonaABM.getInstance().traer(1));
		System.out.println("traer2=\n");
		System.out.println(PersonaABM.getInstance().traer(2));
		System.out.println("traer3=\n");
		System.out.println(PersonaABM.getInstance().traer(3));
		
		
		
		
	}

}
