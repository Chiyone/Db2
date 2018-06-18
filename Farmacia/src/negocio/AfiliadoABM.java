package negocio;

import java.util.List;

import dao.AfiliadoDao;
import datos.Afiliado;
import datos.ItemVenta;
import datos.ObraSocial;
import datos.Persona;
import datos.Producto;
import datos.Venta;

public class AfiliadoABM {
	AfiliadoDao dao = new AfiliadoDao();

	public Afiliado traerDomicilio(long idAfiliado) throws Exception {
		Afiliado c = dao.traerAfiliado(idAfiliado);
			if(c==null)
				throw new Exception ("Id incorrecto: el afiliado no existe");
		return c;
	}


public int agregar(int n, ObraSocial o ,Persona p) {
		Afiliado s=new Afiliado(n,o,p);
		return dao.agregar(s);
		
	}

	public void modificar(Afiliado s) throws Exception{
		if((dao.traerAfiliado(s.getIdAfiliado()))==null){
			dao.actualizar(s);
		}else throw new Exception ("ID repetido en la actualización");
	}

	public void eliminar(long idAfiliado) throws Exception{
		Afiliado c=dao.traerAfiliado(idAfiliado);
		if(c!=null){
		dao.eliminar(c);
		}else throw new Exception ("Afiliado no existe para eliminar");
	}


	public List<Afiliado> traerAfiliado() throws Exception{
		if(dao.traerAfiliado()!=null){
		return dao.traerAfiliado();
		}else throw new Exception ("No hay Afiliados en la base de datos");
	}


	}