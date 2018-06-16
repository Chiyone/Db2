package datos;

public class Afiliado {
	protected long idAfiliado;
	private long numAfiliado;
	private ObraSocial obraSocial;
	private Persona persona;
	
	public Afiliado() {}
	
	
	public Afiliado(long numAfiliado, ObraSocial obraSocial, Persona persona) {
		super();
		this.numAfiliado = numAfiliado;
		this.obraSocial = obraSocial;
		this.persona = persona;
	}
	public long getIdAfiliado() {
		return idAfiliado;
	}
	public void setIdAfiliado(long idAfiliado) {
		this.idAfiliado = idAfiliado;
	}
	public long getNumAfiliado() {
		return numAfiliado;
	}
	public void setNumAfiliado(long numAfiliado) {
		this.numAfiliado = numAfiliado;
	}
	public ObraSocial getObraSocial() {
		return obraSocial;
	}
	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	@Override
	public String toString() {
		return "Afiliado [idAfiliado=" + idAfiliado + ", numAfiliado=" + numAfiliado + ", obraSocial=" + obraSocial
				+ ", persona=" + persona + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
