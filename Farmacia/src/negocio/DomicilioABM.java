package negocio;

import java.util.List;
import java.util.Set;

import dao.DomicilioDao;
import datos.Domicilio;

public class DomicilioABM {
	DomicilioDao dao = new DomicilioDao();

public Domicilio traerDomicilio(long idDomicilio) throws Exception {
	Domicilio c = dao.traerDomicilio(idDomicilio);
		if(c==null)
			throw new Exception ("Id incorrecto: el Domicilio no existe");
	return c;
}


public int agregar(Domicilio d) {
	//Domicilio d=new Domicilio( calle, numero, provincia, localidad);
	return dao.agregar(d);
	
}

public void modificar(Domicilio s) throws Exception{
	if((dao.traerDomicilio(s.getIdDomicilio()))==null){
		dao.actualizar(s);
	}else throw new Exception ("ID repetido en la actualización");
}

public void eliminar(long idDomicilio) throws Exception{
	Domicilio c=dao.traerDomicilio(idDomicilio);
	if(c!=null){
	dao.eliminar(c);
	}else throw new Exception ("Domicilio no existe para eliminar");
}


public List<Domicilio> traerDomicilio() throws Exception{
	if(dao.traerDomicilio()!=null){
	return dao.traerDomicilio();
	}else throw new Exception ("No hay Domicilios en la base de datos");
}


}