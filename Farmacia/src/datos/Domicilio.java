package datos;

import java.util.Set;

public class Domicilio {
	private long idDomicilio;
	private String calle;
	private int numero;
	private String provincia;
	private String localidad;
	private Set<Sucursal> lstSucursal;
	private Set<Persona> lstPersona;
	
	public Domicilio() {
		super();
	}
	public Domicilio( String calle, int numero, String provincia, String localidad) {
		super();
		
		this.calle = calle;
		this.numero = numero;
		this.provincia = provincia;
		this.localidad = localidad;
	}
	public long getIdDomicilio() {
		return idDomicilio;
	}
	public void setIdDomicilio(long idDomicilio) {
		this.idDomicilio = idDomicilio;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
	public Set<Sucursal> getLstSucursal() {
		return lstSucursal;
	}
	public void setLstSucursal(Set<Sucursal> lstSucursal) {
		this.lstSucursal = lstSucursal;
	}
	
	
	
	public Set<Persona> getLstPersona() {
		return lstPersona;
	}
	public void setLstPersona(Set<Persona> lstPersona) {
		this.lstPersona = lstPersona;
	}
	@Override
	public String toString() {
		return "Domicilio [idDomicilio=" + idDomicilio + ", calle=" + calle + ", numero=" + numero + ", provincia="
				+ provincia + ", localidad=" + localidad + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + (int) (idDomicilio ^ (idDomicilio >>> 32));
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + numero;
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Domicilio other = (Domicilio) obj;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (idDomicilio != other.idDomicilio)
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (numero != other.numero)
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		return true;
	}
	
	
}
