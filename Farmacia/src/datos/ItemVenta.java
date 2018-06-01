package datos;

public class ItemVenta {
	private long idItemVenta;

	private int cantidad;
	private double precioTotal;
	private double precioUnitario;
	
	private Producto producto;
	private Venta venta;
	
	/*public ItemVenta(int cantidad, double precioTotal, double precioUnitario) {
		super();
		
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
		this.precioUnitario = precioUnitario;
		
	}*/
	public ItemVenta(Producto producto, int cantidad, double precioTotal, double precioUnitario,Venta venta) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
		this.precioUnitario = precioUnitario;
		this.venta=venta;
	}
	public ItemVenta() {
		
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
	/**
	 * @return the venta
	 */
	public Venta getVenta() {
		return venta;
	}
	/**
	 * @param venta the venta to set
	 */
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemVenta [idItemVenta=" + idItemVenta + ", producto=" + producto + ", cantidad=" + cantidad
				+ ", precioTotal=" + precioTotal + ", precioUnitario=" + precioUnitario + ", venta=" + venta + "]";
	}
	

}
