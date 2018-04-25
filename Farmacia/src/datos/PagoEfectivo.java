package datos;

public class PagoEfectivo extends Pago{
	
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
