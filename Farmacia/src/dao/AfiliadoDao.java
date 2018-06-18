package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Afiliado;

public class AfiliadoDao {
	private static Session session ;
	private Transaction tx ;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos",he);
	}
	
	
	public int agregar(Afiliado objeto) {
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
	
	
	public void actualizar(Afiliado objeto) throws HibernateException {
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
	
	
	public void eliminar(Afiliado objeto) throws HibernateException {
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
	
	public Afiliado traerAfiliado( long idAfiliado) throws HibernateException {
		Afiliado objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Afiliado) session.get(Afiliado.class , idAfiliado);
		} 
		finally {
			session.close();
			}
			return objeto;
	}
	
	
	
	
	@SuppressWarnings ( "unchecked" )
	public List<Afiliado> traerAfiliado() throws HibernateException {
		List<Afiliado> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery( "from Afiliado a join fetch a.Persona join fetch a.ObraSocial order by a.idAfiliado asc ").list();
		} 	finally {
			session.close();
			}
		return lista;
	}

}