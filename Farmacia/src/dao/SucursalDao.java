package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Sucursal;
public class SucursalDao {
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
		
		
		public int agregar(Sucursal objeto) {
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
		
		
		public void actualizar(Sucursal objeto) throws HibernateException {
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
		
		
		public void eliminar(Sucursal objeto) throws HibernateException {
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
		
	/*	public Sucursal traerSucursal( long idSucursal) throws HibernateException {
			Sucursal objeto = null ;
			try {
				iniciaOperacion();
				objeto = (Sucursal) session.get(Sucursal.class , idSucursal);
			} 
			finally {
				session.close();
				}
				return objeto;
		}*/
		public Sucursal traerSucursal(long idSucursal) throws HibernateException {
			Sucursal objeto = null ;
			try {
				iniciaOperacion();
				objeto = (Sucursal) session.createQuery( "from Sucursal s join fetch s.Domicilio where s.idSucursal="+idSucursal).uniqueResult();
			} 
			finally {
				session.close();
			}
			return objeto;
		}
		
		
		public Sucursal traerSucursal( String sucursal) throws HibernateException {
			Sucursal objeto = null ;
			try {
				iniciaOperacion();
				objeto = (Sucursal) session.createQuery( "from Sucursal s join fetch s.Domicilio where s.sucursal="+(sucursal)).uniqueResult();
			} 
			finally {
				session.close();
			}
			return objeto;
		}
		
		
		@SuppressWarnings ( "unchecked" )
		public List<Sucursal> traerSucursal() throws HibernateException {
			List<Sucursal> lista= null ;
			try {
				iniciaOperacion();
				lista= session.createQuery( "from Sucursal s order by s.sucursal asc ").list();
			} 	finally {
				session.close();
				}
			return lista;
		}
	
}