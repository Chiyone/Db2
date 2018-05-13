package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Pago;
public class PagoDao {
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
		
		
		public int agregar(Pago objeto) {
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
		
		
		public void actualizar(Pago objeto) throws HibernateException {
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
		
		
		public void eliminar(Pago objeto) throws HibernateException {
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
		
		public Pago traerPago( long idPago) throws HibernateException {
			Pago objeto = null ;
			try {
				iniciaOperacion();
				objeto = (Pago) session.get(Pago.class , idPago);
			} 
			finally {
				session.close();
				}
				return objeto;
		}
		
		
		public Pago traerPago( String pago) throws HibernateException {
			Pago objeto = null ;
			try {
				iniciaOperacion();
				objeto = (Pago) session.createQuery( "from Pago p where p.pago="+(pago)).uniqueResult();
			} 
			finally {
				session.close();
			}
			return objeto;
		}
		
		
		@SuppressWarnings ( "unchecked" )
		public List<Pago> traerPago() throws HibernateException {
			List<Pago> lista= null ;
			try {
				iniciaOperacion();
				lista= session.createQuery( "from Pago p order by p.pago asc ").list();
			} 	finally {
				session.close();
				}
			return lista;
		}
	
}