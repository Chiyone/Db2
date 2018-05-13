package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.ItemVenta;
public class ItemVentaDao {
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
		
		
		public int agregar(ItemVenta objeto) {
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
		
		
		public void actualizar(ItemVenta objeto) throws HibernateException {
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
		
		
		public void eliminar(ItemVenta objeto) throws HibernateException {
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
		
		public ItemVenta traerItemVenta( long idItemVenta) throws HibernateException {
			ItemVenta objeto = null ;
			try {
				iniciaOperacion();
				objeto = (ItemVenta) session.get(ItemVenta.class , idItemVenta);
			} 
			finally {
				session.close();
				}
				return objeto;
		}
		
		
		public ItemVenta traerItemVenta( String itemVenta) throws HibernateException {
			ItemVenta objeto = null ;
			try {
				iniciaOperacion();
				objeto = (ItemVenta) session.createQuery( "from ItemVenta i where i.itemVenta="+(itemVenta)).uniqueResult();
			} 
			finally {
				session.close();
			}
			return objeto;
		}
		
		
		@SuppressWarnings ( "unchecked" )
		public List<ItemVenta> traerItemVenta() throws HibernateException {
			List<ItemVenta> lista= null ;
			try {
				iniciaOperacion();
				lista= session.createQuery( "from ItemVenta i order by i.itemVenta asc ").list();
			} 	finally {
				session.close();
				}
			return lista;
		}
	
}