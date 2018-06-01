package negocio;

import java.util.List;

import dao.PersonaDao;
import datos.Domicilio;
import datos.Empleado;
import datos.ObraSocial;
import datos.Persona;
import datos.Sucursal;

public class EmpleadoABM {
	private static EmpleadoABM instancia = null ; // Patrón Singleton
	public EmpleadoABM() {}
	public static EmpleadoABM getInstance(){
		if ( instancia == null )
			instancia = new EmpleadoABM();
		return instancia ;
	}

	

	public int agregar(long dni, String nombre, String apellido, Domicilio domicilio, long cuil, long numAfiliado,
			ObraSocial obraSoc, Sucursal sucursal) {
		Empleado d=new Empleado( dni, nombre, apellido,  domicilio, cuil, numAfiliado,
				 obraSoc,  sucursal);
		return PersonaDao.getInstance().agregar(d);
		
	}

	public void modificar(Empleado s) throws Exception{
		if((PersonaDao.getInstance().traer(s.getIdEmpleado()))==null){
			PersonaDao.getInstance().actualizar(s);
		}else throw new Exception ("ID repetido en la actualización");
	}

	public void eliminar(long idEmpleado ) throws Exception{
		Persona c=PersonaDao.getInstance().traer(idEmpleado );
		if(c!=null){
			PersonaDao.getInstance().eliminar(c);
		}else throw new Exception ("Empleado no existe para eliminar");
	}


	public List<Persona> traerEmpleados() throws Exception{
		if(PersonaDao.getInstance().traerEmpleados()!=null){
		return PersonaDao.getInstance().traerEmpleados();
		}else throw new Exception ("No hay Clientes en la base de datos");
	}


	}


