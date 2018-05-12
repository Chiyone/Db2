package datos;


import java.util.Set;

public class Sucursal {

	protected long idSucursal;
	private String sucursal;
	private Domicilio domicilio;
	private Empleado encargado;
	private Set<Empleado> lstEmpleados;
	/**
	 * 
	 */
	public Sucursal() {
		super();
	}
	/**
	 * @param sucursal
	 * @param domicilio
	 * @param encargado
	 * @param lstEmpleados
	 */
	public Sucursal(String sucursal, Domicilio domicilio, Empleado encargado, Set<Empleado> lstEmpleados) {
		super();
		this.sucursal = sucursal;
		this.domicilio = domicilio;
		this.encargado = encargado;
		this.lstEmpleados = lstEmpleados;
	}
	/**
	 * @return the idSucursal
	 */
	public long getIdSucursal() {
		return idSucursal;
	}
	/**
	 * @param idSucursal the idSucursal to set
	 */
	public void setIdSucursal(long idSucursal) {
		this.idSucursal = idSucursal;
	}
	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return the domicilio
	 */
	public Domicilio getDomicilio() {
		return domicilio;
	}
	/**
	 * @param domicilio the domicilio to set
	 */
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	/**
	 * @return the encargado
	 */
	public Empleado getEncargado() {
		return encargado;
	}
	/**
	 * @param encargado the encargado to set
	 */
	public void setEncargado(Empleado encargado) {
		this.encargado = encargado;
	}
	/**
	 * @return the lstEmpleados
	 */
	public Set<Empleado> getLstEmpleados() {
		return lstEmpleados;
	}
	/**
	 * @param lstEmpleados the lstEmpleados to set
	 */
	public void setLstEmpleados(Set<Empleado> lstEmpleados) {
		this.lstEmpleados = lstEmpleados;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sucursal [sucursal=" + sucursal + ", domicilio=" + domicilio + ", encargado=" + encargado
				+ ", lstEmpleados=" + lstEmpleados + "]";
	}
	
	
}
