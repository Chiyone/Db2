package test;


import java.util.List;
import java.util.Set;

import datos.Empleado;
import datos.Cliente;
import datos.Domicilio;
import datos.Persona;
import datos.Sucursal;
import negocio.ClienteABM;
import negocio.DomicilioABM;
import negocio.EmpleadoABM;
import negocio.PersonaABM;
import negocio.SucursalABM;;



public class TestPersona {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DomicilioABM abm = new DomicilioABM();
		abm.agregar("San ignacio", 2069, "Buenos Aires", "Banfield");
		abm.agregar("Azara", 2069, "Buenos Aires", "Banfield");
		abm.agregar("Alsina", 2069, "Buenos Aires", "Banfield");
		Domicilio dom1 = abm.traerDomicilio(2);
		Domicilio dom2 = abm.traerDomicilio(1);
		Domicilio dom3 = abm.traerDomicilio(3);
		
		SucursalABM sucAbm=new SucursalABM();
		SucursalABM sucAbm2=new SucursalABM();
		DomicilioABM domSuc = new DomicilioABM();
		abm.agregar("Azara", 2069, "Buenos Aires", "Banfield");
		
		sucAbm.agregar("baradero", abm.traerDomicilio(1));
		sucAbm2.agregar("marmol", abm.traerDomicilio(2));
		Sucursal suc=sucAbm.traerSucursal(1);	
	
		
		PersonaABM.getInstance().agregar(39666566, "juju", "yoyo", dom1);
		ClienteABM.getInstance().agregar(3333333, "lulu", "hh", dom2, 222222, null);
		EmpleadoABM.getInstance().agregar(4444, "eee", "Son", dom3, 1111111, 111, null, suc,"Encargado");
		EmpleadoABM.getInstance().agregar(4444, "eaa", "Sun", dom1, 2222222, 222, null, suc,"Empleado");
		EmpleadoABM.getInstance().agregar(4444, "eii", "Sin", dom2, 3333333, 333, null, suc,"Empleado");
		EmpleadoABM.getInstance().agregar(4444, "euu", "Sen", dom3, 4444444, 444, null, sucAbm2.traerSucursal(2),"Empleado");
		EmpleadoABM.getInstance().agregar(4444, "eoo", "San", dom3, 5555555, 555, null, suc,"Empleado");
		EmpleadoABM.getInstance().agregar(4444, "eea", "Saon", dom3, 6666666, 666, null, suc,"Empleado");
		
		
		System.out.println("traer1=\n");
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
		System.out.println(EmpleadoABM.getInstance().traerEmpleados());
		EmpleadoABM abmEmp=new EmpleadoABM();
		
		System.out.println(abmEmp.traerEmpleadosSucursal(1));
		
		
		
		
		
	}

}
