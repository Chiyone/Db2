package dao;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.ItemVenta;
import datos.Pago;
import datos.PagoCheque;
import datos.PagoTarjeta;
import datos.Persona;
import datos.Venta;
public class PagoDao {
	private static Session session ;
	private Transaction tx ;
	private static PagoDao instancia = null ; // Patrón Singleton
	protected PagoDao() {}
	public static PagoDao getInstance(){
		if ( instancia == null )
			instancia = new PagoDao();
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
	public Pago traer( long idPago ){
		Pago objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Pago) session .createQuery( "from Pago c  join fetch c.Venta join fetch c.cliente where c.idPago =" + idPago ).uniqueResult();
		} finally {
			session .close();
		}
		return objeto ;
	}
	@SuppressWarnings ( "unchecked" )
	public List<Pago> traer() throws HibernateException {
		List<Pago> lista = null ;
		try {
			iniciaOperacion();
			lista = session .createQuery( "from Pago p join fetch p.cliente join fetch p.Venta as v join fetch v.eCobro join fetch v.eAtendio join fetch v.Sucursal" ).list();
		} finally {
			session .close();
		}
		return lista ;
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
		@SuppressWarnings ( "unchecked" )
		public List<PagoCheque> traerPagosCheque() throws HibernateException {
			List<PagoCheque> lista= null ;
			try {
				iniciaOperacion();
				lista= session.createQuery( "from PagoCheque p join fetch p.cliente").list();
			} 	finally {
				session.close();
				}
			return lista;
		}
	
		@SuppressWarnings ( "unchecked" )
		public List<PagoTarjeta> traerPagosTarjeta() throws HibernateException {
			List<PagoTarjeta> lista= null ;
			try {
				iniciaOperacion();
				lista= session.createQuery( "from PagoTarjeta p join fetch p.cliente").list();
			} 	finally {
				session.close();
				}
			return lista;
		}
		@SuppressWarnings ( "unchecked" )
		public List<Pago> traerPagosEfectivo() throws HibernateException {
			List<Pago> lista= null ;
			try {
				iniciaOperacion();
				lista= session.createQuery( "from Pago p join fetch p.cliente where p.tpoPago=:tipo ").setString("tipo", "Efectivo").list();
				
			} 	finally {
				session.close();
				}
			return lista;
		}
		public List<ItemVenta> traerItemsVenta(Venta venta) {
			List<ItemVenta> lista= null ;
			long id=venta.getIdVenta();
			try {
				iniciaOperacion();
				lista= session.createQuery( " from ItemVenta i join fetch i.Venta v where v.idVenta="+id).list();
			} 	finally {
				session.close();
				}
			return lista;
		}
}