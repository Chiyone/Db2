package datos;

public class RankCliente {
	
	private String nombre;
	private String apellido;
	private double monto;
	private int cantidad;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public RankCliente(String nombre, String apellido, double monto, int cantidad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.monto = monto;
		this.cantidad = cantidad;
	}
	public RankCliente() {
		super();
	}
	@Override
	public String toString() {
		return "\nCliente [nombre=" + nombre + " " + apellido + " monto= $" + monto + " cantidad= "
				+ cantidad + " ]";
	}
	
}
