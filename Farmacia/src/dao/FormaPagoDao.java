package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.FormaPago;
public class FormaPagoDao {
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
		
		
		public int agregar(FormaPago objeto) {
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
		
		
		public void actualizar(FormaPago objeto) throws HibernateException {
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
		
		
		public void eliminar(FormaPago objeto) throws HibernateException {
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
		
		public FormaPago traerFormaPago( long idFormaPago) throws HibernateException {
			FormaPago objeto = null ;
			try {
				iniciaOperacion();
				objeto = (FormaPago) session.get(FormaPago.class , idFormaPago);
			} 
			finally {
				session.close();
				}
				return objeto;
		}
		
		
		public FormaPago traerFormaPago( String formaPago) throws HibernateException {
			FormaPago objeto = null ;
			try {
				iniciaOperacion();
				objeto = (FormaPago) session.createQuery( "from FormaPago f where f.formaPago="+(formaPago)).uniqueResult();
			} 
			finally {
				session.close();
			}
			return objeto;
		}
		
		
		@SuppressWarnings ( "unchecked" )
		public List<FormaPago> traerFormaPago() throws HibernateException {
			List<FormaPago> lista= null ;
			try {
				iniciaOperacion();
				lista= session.createQuery( "from FormaPago f order by f.formaPago asc ").list();
			} 	finally {
				session.close();
				}
			return lista;
		}
	
}