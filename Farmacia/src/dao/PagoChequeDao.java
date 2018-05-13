package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.PagoCheque;
public class PagoChequeDao {
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
		
		
		public int agregar(PagoCheque objeto) {
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
		
		
		public void actualizar(PagoCheque objeto) throws HibernateException {
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
		
		
		public void eliminar(PagoCheque objeto) throws HibernateException {
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
		
		public PagoCheque traerPagoCheque( long numCuenta) throws HibernateException {
			PagoCheque objeto = null ;
			try {
				iniciaOperacion();
				objeto = (PagoCheque) session.get(PagoCheque.class , numCuenta);
			} 
			finally {
				session.close();
				}
				return objeto;
		}
		
		
		public PagoCheque traerPagoCheque( String pagoCheque) throws HibernateException {
			PagoCheque objeto = null ;
			try {
				iniciaOperacion();
				objeto = (PagoCheque) session.createQuery( "from PagoCheque p where p.pagoCheque="+(pagoCheque)).uniqueResult();
			} 
			finally {
				session.close();
			}
			return objeto;
		}
		
		
		@SuppressWarnings ( "unchecked" )
		public List<PagoCheque> traerPagoCheque() throws HibernateException {
			List<PagoCheque> lista= null ;
			try {
				iniciaOperacion();
				lista= session.createQuery( "from PagoCheque p order by p.pagoCheque asc ").list();
			} 	finally {
				session.close();
				}
			return lista;
		}
	
}