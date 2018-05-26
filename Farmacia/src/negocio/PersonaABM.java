package negocio;
import java.util.List;
import dao.PersonaDao;
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
}