package datos;

public class ItemVenta {
	private long idItemVenta;
	private Producto producto;
	private int cantidad;
	private double precioTotal;
	private double precioUnitario;
	public ItemVenta(Producto producto, int cantidad, double precioTotal, double precioUnitario) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
		this.precioUnitario = precioUnitario;
	}
	public ItemVenta() {
		super();
	}
	public long getIdItemVenta() {
		return idItemVenta;
	}
	public void setIdItemVenta(long idItemVenta) {
		this.idItemVenta = idItemVenta;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	@Override
	public String toString() {
		return "ItemVenta [idItemVenta=" + idItemVenta + ", producto=" + producto + ", cantidad=" + cantidad
				+ ", precioTotal=" + precioTotal + ", precioUnitario=" + precioUnitario + "]";
	}
	

}
