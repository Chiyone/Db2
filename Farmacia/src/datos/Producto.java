package datos;

import java.util.Set;

public class Producto {
	protected int idProducto;
	private long codNum;
	private String descripcion;
	private String tipo ;
	private float precio;
	private String laboratorio;
	private Set<ItemVenta> lstItemVenta;
	
	public Producto(long codNum, String descripcion, String tipo, float precio, String laboratorio) {
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

	public int getIdProducto() {
		return idProducto;
	}
	
	public void setIdProducto(int idProducto) {
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	
	
	public Set<ItemVenta> getLstItemVenta() {
		return lstItemVenta;
	}

	public void setLstItemVenta(Set<ItemVenta> lstItemVenta) {
		this.lstItemVenta = lstItemVenta;
	}

	@Override
	public String toString() {
		return "Producto [codNum=" + codNum + ", descripcion=" + descripcion + ", tipo=" + tipo + ", precio=" + precio
				+ ", laboratorio=" + laboratorio + "]";
	}
	
	

}
