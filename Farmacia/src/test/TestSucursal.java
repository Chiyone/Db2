package test;
import negocio.DomicilioABM;
import negocio.SucursalABM;

import java.util.List;
import java.util.Set;

import datos.Domicilio;
import datos.Empleado;
import datos.Sucursal;



public class TestSucursal {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

	
		Empleado encargado=null; 
		Set<Empleado> lstEmpleados=null;
		SucursalABM suc=new SucursalABM();
		DomicilioABM abm = new DomicilioABM();
		abm.agregar("Azara", 2069, "Buenos Aires", "Banfield");
		suc.agregar("baradero", abm.traerDomicilio(1), encargado, lstEmpleados);
		suc.traerSucursal(1);	
		System.out.println(suc.traerSucursal(1));
	}

}
