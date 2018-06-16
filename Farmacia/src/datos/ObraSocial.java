package datos;

import java.util.Set;

public class ObraSocial {
	
	private long idObraSoc;
	private String nombre;
	private Set<Afiliado> afiliados;
	public ObraSocial() {
		super();
	}
	public ObraSocial(String nombre) {
		super();
		
		this.nombre = nombre;
	}
	
	
	public Set<Afiliado> getAfiliados() {
		return afiliados;
	}
	public void setAfiliados(Set<Afiliado> afiliados) {
		this.afiliados = afiliados;
	}
	/**
	 * @return the idObraSoc
	 */
	public long getIdObraSoc() {
		return idObraSoc;
	}
	/**
	 * @param idObraSoc the idObraSoc to set
	 */
	public void setIdObraSoc(long idObraSoc) {
		this.idObraSoc = idObraSoc;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ObraSocial [nombre=" + nombre + "]";
	}
	
	

}
