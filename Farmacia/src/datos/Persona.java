package datos;


//import org.hibernate.mapping.Set;
import java.util.Set;

public class Persona {
	protected long idPersona;
	private long dni;
	private String nombre;
	private String apellido;
	private Domicilio domicilio;
//	private ObraSocial obraSocial;
	private Set<Pago> pagos;
	private Set<Venta> cobros;
	private Afiliado afiliado;
	
	/**
	 * 
	 */
	/*public Persona() {
	}
	/**
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param domicilio
	 */
	/*
	public Persona(long dni, String nombre, String apellido, Domicilio domicilio) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
	}*/
	public Persona() {
	}
	
	public Persona(long dni, String nombre, String apellido, Domicilio domicilio) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio=domicilio;
		
	}
	public long getIdPersona() {
		return idPersona;
	}
	public Set<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(Set<Pago> pagos) {
		this.pagos = pagos;
	}

	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}
	
	/**
	 * @return the dni
	 */
	public long getDni() {
		return dni;
	}
	/**
	 * @param dni the dni to set
	 */
	public void setDni(long dni) {
		this.dni = dni;
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
	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" +domicilio.getIdDomicilio()+ "]";
	}

	public Set<Venta> getCobros() {
		return cobros;
	}

	public void setCobros(Set<Venta> cobros) {
		this.cobros = cobros;
	}

	public Afiliado getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}
	

	
	public String afiliados() {
		return "Persona [ nombre=" + nombre + ", apellido=" + apellido + "obraSoc="+afiliado.getObraSocial().getNombre()+ "]";
	}
	public String noAfiliados() {
		return "Persona [ nombre=" + nombre + ", apellido=" + apellido + "obraSoc= Privado ]";
	}
	
	
}
