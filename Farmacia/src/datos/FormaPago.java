package datos;

public class FormaPago {

	private long idFormapago;
	private String formaPago;
	
	public FormaPago() {
	}
	
	public FormaPago(long idFormapago, String formaPago) {
		super();
		this.idFormapago = idFormapago;
		this.formaPago = formaPago;
	}

	public long getIdFormapago() {
		return idFormapago;
	}

	public void setIdFormapago(long idFormapago) {
		this.idFormapago = idFormapago;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	@Override
	public String toString() {
		return "FormaPago [idFormapago=" + idFormapago + ", formaPago=" + formaPago + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formaPago == null) ? 0 : formaPago.hashCode());
		result = prime * result + (int) (idFormapago ^ (idFormapago >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormaPago other = (FormaPago) obj;
		if (formaPago == null) {
			if (other.formaPago != null)
				return false;
		} else if (!formaPago.equals(other.formaPago))
			return false;
		if (idFormapago != other.idFormapago)
			return false;
		return true;
	}
	
	
	
}
