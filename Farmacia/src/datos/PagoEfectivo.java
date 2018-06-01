package datos;

public class PagoEfectivo extends Pago{
	private long idPagoEfectivo;
	private double vuelto;

	/**
	 * 
	 */
	public PagoEfectivo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param monto
	 * @param cliente
	 * @param tpoPago
	 * @param vuelto
	 */
	public PagoEfectivo(double monto, Cliente cliente, String tpoPago, double vuelto) {
		super(monto, cliente, tpoPago);
		this.vuelto = vuelto;
	}
	
	

	/**
	 * @return the vuelto
	 */
	
	
	
	
	
	public double getVuelto() {
		return vuelto;
	}

	public long getIdPagoEfectivo() {
		return idPagoEfectivo;
	}

	public void setIdPagoEfectivo(long idPagoEfectivo) {
		this.idPagoEfectivo = idPagoEfectivo;
	}

	public long getIdPagoCheque() {
		return idPagoEfectivo;
	}

	public void setIdPagoCheque(long idPagoCheque) {
		this.idPagoEfectivo = idPagoCheque;
	}

	/**
	 * @param vuelto the vuelto to set
	 */
	public void setVuelto(double vuelto) {
		this.vuelto = vuelto;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PagoEfectivo [vuelto=" + vuelto + "]";
	}

	

}
