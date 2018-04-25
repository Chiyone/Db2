/**
 * 
 */
package datos;

/**
 * @author Juan
 *
 */
public class Empleado extends Persona {
	private long cuil;
	private long numAfiliado;
	private ObraSocial obraSoc;
	private Sucursal sucursal;
	
	

	
	/**
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param domicilio
	 * @param cuil
	 * @param numAfiliado
	 * @param obraSoc
	 * @param sucursal
	 */
	public Empleado(long dni, String nombre, String apellido, Domicilio domicilio, long cuil, long numAfiliado,
			ObraSocial obraSoc, Sucursal sucursal) {
		super(dni, nombre, apellido, domicilio);
		this.cuil = cuil;
		this.numAfiliado = numAfiliado;
		this.obraSoc = obraSoc;
		this.sucursal = sucursal;
	}

	
	public Empleado(long dni, String nombre, String apellido, Domicilio domicilio) {
		super(dni, nombre, apellido, domicilio);
		// TODO Auto-generated constructor stub
	}

	
	
	/**
	 * @return the cuil
	 */
	public long getCuil() {
		return cuil;
	}

	/**
	 * @param cuil the cuil to set
	 */
	public void setCuil(long cuil) {
		this.cuil = cuil;
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

	/**
	 * @return the sucursal
	 */
	public Sucursal getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Empleado [cuil=" + cuil + ", numAfiliado=" + numAfiliado + ", obraSoc=" + obraSoc + ", sucursal="
				+ sucursal + "]";
	}
	


	
}
