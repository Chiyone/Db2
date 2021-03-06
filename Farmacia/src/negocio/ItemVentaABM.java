package negocio;

import java.util.List;
import java.util.Set;

import dao.ItemVentaDao;
import datos.ItemVenta;
import datos.Producto;
import datos.Venta;

public class ItemVentaABM {
	ItemVentaDao dao = new ItemVentaDao();

	public ItemVenta traerItemVenta(long idItemVenta) throws Exception {
		ItemVenta c = dao.traerItemVenta(idItemVenta);
			if(c==null)
				throw new Exception ("Id incorrecto: ItemVenta no existe");
		return c;
	}
	/*public int agregar( int cantidad, double precioTotal, double precioUnitario) {
		
		ItemVenta s=new ItemVenta(cantidad, precioTotal,precioUnitario);
		return dao.agregar(s);
		
	}*/
	
	public int agregar(Producto producto, int cantidad,Venta venta) throws Exception {
		VentaABM venabm=new VentaABM();
		Venta ven1=venabm.traerVenta(venta.getIdVenta());
		double precioUnitario=calcularPreciounitario(producto);
		double precioTotal=calcularPrecioTotal(cantidad,precioUnitario);
		double total=0;
		total=venta.getTotalVenta()+precioTotal;
		ven1.setTotalVenta(total);
		venabm.modificar(ven1);
		
		ItemVenta s=new ItemVenta(producto,cantidad, precioTotal,precioUnitario,venta);
		
		return dao.agregar(s);
		
	}
	
	static double calcularPrecioTotal(int cantidad, double precioUnitario) {
		double precio=0;
		precio = precioUnitario*cantidad;
		
		
		
		return precio;
	}
	static double calcularPreciounitario(Producto producto ) {
		// TODO Auto-generated method stub
		double precio=0;
		precio = (double) producto.getPrecio();
		
		
		
		return precio;
	}

	public void modificar(ItemVenta s) throws Exception{
		if((dao.traerItemVenta(s.getIdItemVenta()))==null){
			dao.actualizar(s);
		}else throw new Exception ("ID repetido en la actualización");
	}
	
	public void eliminar(long idItemVenta) throws Exception{
		ItemVenta c=dao.traerItemVenta(idItemVenta);
		if(c!=null){
		dao.eliminar(c);
		}else throw new Exception ("ItemVenta no existe para eliminar");
	}
	
	
	public List<ItemVenta> traerItemVenta() throws Exception{
		if(dao.traerItemVenta()!=null){
		return dao.traerItemVenta();
		}else throw new Exception ("No hay ItemVenta en la base de datos");
	}


}