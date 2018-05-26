package datos;

public class Persona {
	protected long idPersona;
	private long dni;
	private String nombre;
	private String apellido;
	private Domicilio domicilio;
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
		
	}
	public long getIdPersona() {
		return idPersona;
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
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio
				+ "]";
	}
	
}
