package negocio;

import java.util.List;

import dao.AfiliadoDao;
import datos.Afiliado;

public class AfiliadoABM {
	AfiliadoDao dao = new AfiliadoDao();

	public Afiliado traerDomicilio(long idAfiliado) throws Exception {
		Afiliado c = dao.traerAfiliado(idAfiliado);
			if(c==null)
				throw new Exception ("Id incorrecto: el Domicilio no existe");
		return c;
	}


	public int agregar(Afiliado a) {
		//Domicilio d=new Domicilio( calle, numero, provincia, localidad);
		return dao.agregar(a);
		
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


	public List<Afiliado> traerDomicilio() throws Exception{
		if(dao.traerAfiliado()!=null){
		return dao.traerAfiliado();
		}else throw new Exception ("No hay Afiliados en la base de datos");
	}


	}