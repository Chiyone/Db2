package test;
import negocio.DomicilioABM;
import negocio.EmpleadoABM;
import negocio.PersonaABM;
import negocio.SucursalABM;

import java.util.List;
import java.util.Set;

import datos.Domicilio;
import datos.Empleado;
import datos.Sucursal;



public class TestSucursal {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		SucursalABM suc=new SucursalABM();
		DomicilioABM abm = new DomicilioABM();
		//abm.agregar("Azara", 2069, "Buenos Aires", "Banfield");
		
		
		
		//System.out.println(suc.traerSucursal(1));
		//System.out.println(EmpleadoABM.getInstance().traer(1));
		
		Sucursal s=new Sucursal("baradero", abm.traerDomicilio(1));
		suc.agregar(s);
		suc.traerSucursal(1);
		/*EmpleadoABM.getInstance().agregar(4444, "eee", "San", abm.traerDomicilio(1), 1111111, 222111, null, suc.traerSucursal(1),"Encargado");
		EmpleadoABM abmEmp=new EmpleadoABM();
		
		System.out.println(abmEmp.traerEmpleadosSucursal(1));
		
		*/
		
	}

}
