package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.ObraSocial;
public class ObraSocialDao {
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
		
		
		public int agregar(ObraSocial objeto) {
			int id = 0;
			try {
				iniciaOperacion();
				id = Integer.parseInt(session.save(objeto).toString());
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
		
		
		public void actualizar(ObraSocial objeto) throws HibernateException {
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
		
		
		public void eliminar(ObraSocial objeto) throws HibernateException {
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
		
		public ObraSocial traerObraSocial( long idObraSocial) throws HibernateException {
			ObraSocial objeto = null ;
			try {
				iniciaOperacion();
				objeto = (ObraSocial) session.get(ObraSocial.class , idObraSocial);
			} 
			finally {
				session.close();
				}
				return objeto;
		}
		
		
		public ObraSocial traerObraSocial( String obraSocial) throws HibernateException {
			ObraSocial objeto = null ;
			try {
				iniciaOperacion();
				objeto = (ObraSocial) session.createQuery( "from ObraSocial o where o.obraSocial="+(obraSocial)).uniqueResult();
			} 
			finally {
				session.close();
			}
			return objeto;
		}
		
		
		@SuppressWarnings ( "unchecked" )
		public List<ObraSocial> traerObraSocial() throws HibernateException {
			List<ObraSocial> lista= null ;
			try {
				iniciaOperacion();
				lista= session.createQuery( "from ObraSocial o order by o.obraSocial asc ").list();
			} 	finally {
				session.close();
				}
			return lista;
		}
	
}