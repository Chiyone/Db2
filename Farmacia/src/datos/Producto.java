package datos;

public class Producto {
	protected long idProducto;
	private long codNum;
	private String descripcion;
	private String tipo ;
	private double precio;
	private String laboratorio;
	
	public Producto(long codNum, String descripcion, String tipo, double precio, String laboratorio) {
		super();
		this.codNum = codNum;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.precio = precio;
		this.laboratorio = laboratorio;
	}

	public Producto() {
		super();
	}

	public long getIdProducto() {
		return idProducto;
	}
	
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	
	public long getCodNum() {
		return codNum;
	}

	public void setCodNum(long codNum) {
		this.codNum = codNum;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	@Override
	public String toString() {
		return "Producto [codNum=" + codNum + ", descripcion=" + descripcion + ", tipo=" + tipo + ", precio=" + precio
				+ ", laboratorio=" + laboratorio + "]";
	}
	
	

}
