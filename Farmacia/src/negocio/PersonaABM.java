package negocio;
import java.util.List;
import dao.PersonaDao;
 
import datos.Domicilio;
import datos.Pago;
import datos.Persona;
public class PersonaABM {
	
	private static PersonaABM instancia = null ; // Patrón Singleton
	public PersonaABM() {}
	public static PersonaABM getInstance(){
		if ( instancia == null )
			instancia = new PersonaABM();
		return instancia ;
	}

	public Persona traer( int idPersona ){
		return PersonaDao.getInstance().traer(idPersona);
	}
	public List<Persona> traer(){
		return PersonaDao.getInstance().traer();
	}
	public int agregar(long dni, String nombre, String apellido, Domicilio domicilio) {
		Persona s=new Persona( dni, nombre,apellido, domicilio);
		return PersonaDao.getInstance().agregar(s);
		
	}
	
	public void modificar(Persona s) throws Exception{
		if((PersonaDao.getInstance().traer(s.getIdPersona()))==null){
			PersonaDao.getInstance().actualizar(s);
		}else throw new Exception ("ID repetido en la actualización");
	}
	
	public void eliminar(long idPersona) throws Exception{
		Persona c=PersonaDao.getInstance().traer(idPersona);
		if(c!=null){
		PersonaDao.getInstance().eliminar(c);
		}else throw new Exception ("persona no existe para eliminar");
	}
	public List<Persona> traerClientes() throws Exception{
		if(PersonaDao.getInstance().traerClientes()!=null){
		return PersonaDao.getInstance().traerClientes();
		}else throw new Exception ("No hay Clientes en la base de datos");
	}
}