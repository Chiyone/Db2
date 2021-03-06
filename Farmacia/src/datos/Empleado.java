/**
 * 
 */
package datos;

import java.util.Set;

/**
 * @author Juan
 *
 */
public class Empleado extends Persona {
	private long idEmpleado;
	private long cuil;
	
	private Sucursal sucursal;
	private String tipoEmpleado;
	private Set<Venta> cobros;
	

	
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
public Empleado(long dni, String nombre, String apellido, Domicilio domicilio, long cuil, Sucursal sucursal,String tipoEmpleado) {
		super(dni, nombre, apellido, domicilio);
		this.cuil = cuil;
		
		this.sucursal = sucursal;
		this.tipoEmpleado=tipoEmpleado;
	}
	/*public Empleado(long dni, String nombre, String apellido, long cuil, long numAfiliado
			) {
		super(dni, nombre, apellido,null);
		this.cuil = cuil;
		this.numAfiliado = numAfiliado;
		
	}*/

	
	public Empleado(long dni, String nombre, String apellido, Domicilio domicilio,String tipoEmpleado) {
		super(dni, nombre, apellido, domicilio);
		// TODO Auto-generated constructor stub
	}
	public Empleado() {
		
	}
	
	
	
	public String getTipoEmpleado() {
		return tipoEmpleado;
	}


	public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}


	public long getIdEmpleado() {
		return idEmpleado;
	}


	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
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

	@Override
	public String toString() {
		return "Empleado [cuil=" + cuil + ", sucursal=" + sucursal.getIdSucursal() + ", tipoEmpleado=" + tipoEmpleado + "]";
	}
	


	
}
