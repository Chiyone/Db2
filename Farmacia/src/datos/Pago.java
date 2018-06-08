package datos;

public class Pago {

	private long idPago;
	private  double monto;
	private Cliente cliente;
	private String tpoPago;
	private Venta venta;
	public Pago() {
		super();
	}
	/**
	 * @param monto
	 * @param cliente
	 * @param tpoPago
	 */
	public Pago(double monto, Cliente cliente, String tpoPago) {
		super();
		this.monto = monto;
		this.cliente = cliente;
		this.tpoPago = tpoPago;
	}
	/**
	 * @return the idPago
	 */
	public long getIdPago() {
		return idPago;
	}
	/**
	 * @param idPago the idPago to set
	 */
	public void setIdPago(long idPago) {
		this.idPago = idPago;
	}
	/**
	 * @return the monto
	 */
	public double getMonto() {
		return monto;
	}
	/**
	 * @param monto the monto to set
	 */
	public void setMonto(double monto) {
		this.monto = monto;
	}
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the tpoPago
	 */
	public String getTpoPago() {
		return tpoPago;
	}
	/**
	 * @param tpoPago the tpoPago to set
	 */
	public void setTpoPago(String tpoPago) {
		this.tpoPago = tpoPago;
	}
	
	
	
	
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pago [idPago=" + idPago + ", monto=" + monto + ", cliente=" + cliente + ", tpoPago=" + tpoPago + "]";
	}
	
	
	
	
	
	
	
}
