package negocio;

import java.util.List;
import java.util.Set;

import dao.ProductoDao;
import datos.Producto;
import datos.Sucursal;
import datos.Venta;



public class ProductoABM {
	
	ProductoDao dao = new ProductoDao();

	public Producto traerProducto(int idProducto) throws Exception {
		Producto c = dao.traerProducto(idProducto);
			if(c==null)
				throw new Exception ("Id incorrecto: el Producto no existe");
		return c;
	}
	
	
	public int agregar(long codNum, String descripcion, String tipo, float precio, String laboratorio) {
		Producto p=new Producto(codNum,descripcion,tipo,precio, laboratorio);
		return dao.agregar(p);
		
	}
	public int agregar(Producto p) {
		//Producto p=new Producto(codNum,descripcion,tipo,precio, laboratorio);
		long codNum=000000+agregarCodNum();
		p.setCodNum(codNum);
		return dao.agregar(p);
		
	}
	
	

	public void modificar(Producto s) throws Exception{
		if((dao.traerProducto(s.getIdProducto()))==null){
			dao.actualizar(s);
		}else throw new Exception ("ID repetido en la actualización");
	}
	
	public void eliminar(int idProducto) throws Exception{
		Producto c=dao.traerProducto(idProducto);
		if(c!=null){
		dao.eliminar(c);
		}else throw new Exception ("Producto no existe para eliminar");
	}
	
	
	public List<Producto> traerProducto() throws Exception{
		if(dao.traerProducto()!=null){
		return dao.traerProducto();
		}else throw new Exception ("No hay Productos en la base de datos");
	}
	
	public long agregarCodNum(){
		long cod =traerIdProd();
		
		
		return cod;
	}
	public long traerIdProd() {
		List <Producto> productos =dao.traerProducto();
		
		long c=0;
		if(productos.isEmpty())
			c=0;
		else {
		for(Producto p :productos) {
			
			if(p.getIdProducto()>=c)
				c=p.getIdProducto();
			}
		}
		System.out.println(c);
		return c+1;

		}
	}