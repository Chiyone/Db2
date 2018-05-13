package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;
public class ClienteDao {
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
		
		
		public int agregar(Cliente objeto) {
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
		
		
		public void actualizar(Cliente objeto) throws HibernateException {
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
		
		
		public void eliminar(Cliente objeto) throws HibernateException {
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
		
		public Cliente traerCliente( long dni) throws HibernateException {
			Cliente objeto = null ;
			try {
				iniciaOperacion();
				objeto = (Cliente) session.get(Cliente.class , dni);
			} 
			finally {
				session.close();
				}
				return objeto;
		}
		
		
		public Cliente traerCliente( String cliente) throws HibernateException {
			Cliente objeto = null ;
			try {
				iniciaOperacion();
				objeto = (Cliente) session.createQuery( "from Cliente c where c.cliente="+(cliente)).uniqueResult();
			} 
			finally {
				session.close();
			}
			return objeto;
		}
		
		
		@SuppressWarnings ( "unchecked" )
		public List<Cliente> traerCliente() throws HibernateException {
			List<Cliente> lista= null ;
			try {
				iniciaOperacion();
				lista= session.createQuery( "from Cliente c order by c.cliente asc ").list();
			} 	finally {
				session.close();
				}
			return lista;
		}
	
}