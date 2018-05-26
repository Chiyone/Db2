package test;
import negocio.SucursalABM;

import java.util.List;
import java.util.Set;

import datos.Domicilio;
import datos.Empleado;
import datos.Sucursal;



public class TestSucursal {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Domicilio domicilio=null;
		Empleado encargado=null; 
		Set<Empleado> lstEmpleados=null;
		SucursalABM suc=new SucursalABM();
		suc.agregar("baradero", domicilio, encargado, lstEmpleados);
		suc.traerSucursal(1);
		
		
		
	}

}
