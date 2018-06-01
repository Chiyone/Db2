package negocio;

import java.util.List;

import dao.PersonaDao;
import datos.Cliente;
import datos.Domicilio;
import datos.ObraSocial;
import datos.Persona;



public class ClienteABM {
	
	private static ClienteABM instancia = null ; // Patrón Singleton
	public ClienteABM() {}
	public static ClienteABM getInstance(){
		if ( instancia == null )
			instancia = new ClienteABM();
		return instancia ;
	}

	

	public int agregar(long dni, String nombre, String apellido, Domicilio domicilio, long numAfiliado,
			ObraSocial obraSoc) {
		Cliente d=new Cliente(dni,nombre, apellido, domicilio, numAfiliado,
				 obraSoc);
		return PersonaDao.getInstance().agregar(d);
		
	}

	public void modificar(Cliente s) throws Exception{
		if((PersonaDao.getInstance().traer(s.getIdCliente()))==null){
			PersonaDao.getInstance().actualizar(s);
		}else throw new Exception ("ID repetido en la actualización");
	}

	public void eliminar(long idCliente ) throws Exception{
		Persona c=PersonaDao.getInstance().traer(idCliente );
		if(c!=null){
			PersonaDao.getInstance().eliminar(c);
		}else throw new Exception ("Cliente no existe para eliminar");
	}


	public List<Persona> traerClientes() throws Exception{
		if(PersonaDao.getInstance().traerClientes()!=null){
		return PersonaDao.getInstance().traerClientes();
		}else throw new Exception ("No hay Clientes en la base de datos");
	}


	}