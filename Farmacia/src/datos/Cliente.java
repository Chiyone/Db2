package datos;

public class Cliente extends Persona  {

	private long numAfiliado;
	private ObraSocial obraSoc;
	/**
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param domicilio
	 */
	public Cliente(long dni, String nombre, String apellido, Domicilio domicilio) {
		super(dni, nombre, apellido, domicilio);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param domicilio
	 * @param numAfiliado
	 * @param obraSoc
	 */
	public Cliente(long dni, String nombre, String apellido, Domicilio domicilio, long numAfiliado,
			ObraSocial obraSoc) {
		super(dni, nombre, apellido, domicilio);
		this.numAfiliado = numAfiliado;
		this.obraSoc = obraSoc;
	}


	/**
	 * @return the numAfiliado
	 */
	public long getNumAfiliado() {
		return numAfiliado;
	}


	/**
	 * @param numAfiliado the numAfiliado to set
	 */
	public void setNumAfiliado(long numAfiliado) {
		this.numAfiliado = numAfiliado;
	}


	/**
	 * @return the obraSoc
	 */
	public ObraSocial getObraSoc() {
		return obraSoc;
	}


	/**
	 * @param obraSoc the obraSoc to set
	 */
	public void setObraSoc(ObraSocial obraSoc) {
		this.obraSoc = obraSoc;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cliente [numAfiliado=" + numAfiliado + ", obraSoc=" + obraSoc + "]";
	}
	
	
	
	
	
}
