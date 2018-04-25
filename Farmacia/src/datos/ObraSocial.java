package datos;

public class ObraSocial {
	
	private long idObraSoc;
	private String nombre;
	public ObraSocial() {
		super();
	}
	public ObraSocial(long idObraSoc, String nombre) {
		super();
		this.idObraSoc = idObraSoc;
		this.nombre = nombre;
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
