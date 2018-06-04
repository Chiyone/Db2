package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Venta;
public class VentaDao {
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
		
		
		public int agregar(Venta objeto) {
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
		
		
		public void actualizar(Venta objeto) throws HibernateException {
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
		
		
		public void eliminar(Venta objeto) throws HibernateException {
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
		
		public Venta traerVenta( long idVenta) throws HibernateException {
			Venta objeto = null ;
			try {
				iniciaOperacion();
				objeto = (Venta) session.createQuery( "from Venta v join fetch v.Sucursal join fetch v.Sucursal.Domicilio where v.idVenta="+(idVenta)).uniqueResult();
				
			} 
			finally {
				session.close();
				}
				return objeto;
		}
		
		
		public Venta traerVenta( String venta) throws HibernateException {
			Venta objeto = null ;
			try {
				iniciaOperacion();
				objeto = (Venta) session.createQuery( "from Venta v where v.venta="+(venta)).uniqueResult();
			} 
			finally {
				session.close();
			}
			return objeto;
		}
		
		
		@SuppressWarnings ( "unchecked" )
		public List<Venta> traerVenta() throws HibernateException {
			List<Venta> lista= null ;
			try {
				iniciaOperacion();
				lista= session.createQuery( "from Venta v order by v.venta asc ").list();
			} 	finally {
				session.close();
				}
			return lista;
		}
	
}