package dao;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import datos.Empleado;
import datos.Pago;
import datos.Persona;
public class PersonaDao {
	private static Session session ;
	private Transaction tx ;
	private static PersonaDao instancia = null ; // Patrón Singleton
	protected PersonaDao() {}
	public static PersonaDao getInstance(){
		if ( instancia == null )
			instancia = new PersonaDao();
		return instancia ;
	}
	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil. getSessionFactory ().openSession();
		tx = session .beginTransaction();
	}
	protected void manejaExcepcion(HibernateException he ) throws HibernateException {
		tx .rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he );
	}
	public Persona traer( long idPersona ){
		Persona objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Persona) session .createQuery( "from Persona p join "+
													"fetch p.Domicilio "+
													"where p.idPersona ="+idPersona ).uniqueResult();
		} finally {
			session .close();
		}
		return objeto ;
	}
	
	public Empleado traerEmpleado( long idEmpleado ){
		Empleado objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Empleado) session.createQuery( " from Empleado e "+
													"where e.idPersona = "+(idEmpleado)).uniqueResult();
		} finally {
			session .close();
		}
		//objeto1=objeto.
		return objeto ;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<Persona> traer() throws HibernateException {
		List<Persona> lista = null ;
		try {
			iniciaOperacion();
			lista = session .createQuery( "from Persona" ).list();
		} finally {
			session .close();
		}
		return lista ;
	}
	
	public int agregar(Persona objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt ( session.save(objeto).toString());
			tx.commit();
			
		} 
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
			
		} finally {
			session.close();
		}
		return id;
	}
	
	
	public void actualizar(Persona objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} 
		catch (HibernateException he) {
	
			manejaExcepcion(he);
			throw he;
		} 
		finally {
			session.close();
		}
		
	}
	
	
	public void eliminar(Persona objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} 
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} 
		finally {
			session.close();
		}
	}
	
		
	public void eliminar(Empleado objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} 
		catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} 
		finally {
			session.close();
		}
	}
	@SuppressWarnings ( "unchecked" )
	public List<Persona> traerClientes() throws HibernateException {
		List<Persona> lista = null ;
		try {
			iniciaOperacion();
			lista = session .createQuery( "from  Persona as p inner join fetch p.pagos group by p.idPersona  " ).list();
			
		} finally {
			session .close();
		}
		return lista ;
	}
	@SuppressWarnings ( "unchecked" )
	public List<Persona> traerEmpleados() throws HibernateException {
		List<Persona> lista = null ;
		try {
			iniciaOperacion();
			lista = session .createQuery( "from  Empleado  " ).list();
		} finally {
			session .close();
		}
		return lista ;
	}
	@SuppressWarnings("unchecked")
	public List<Empleado> traerEmpleadosSucursal(int idSuc) throws HibernateException {
		List<Empleado> lista = null ;
		try {
			iniciaOperacion();
			lista = session .createQuery( "from  Empleado e where  e.Sucursal= "+(idSuc) ).list();
		} finally {
			session .close();
		}
		return lista ;
	}
}
	
	
