package datos;

public class PagoCheque extends Pago{
	private long idPagoCheque;
	
	private long numCuenta;
	private String banco;
	
	
	/**
	 * 
	 */
	
	public PagoCheque() {
		super();
	}


	/**
	 * @param monto
	 * @param cliente
	 * @param tpoPago
	 * @param numCuenta
	 * @param banco
	 */
	public PagoCheque(double monto, Cliente cliente, String tpoPago, long numCuenta, String banco) {
		super(monto, cliente, tpoPago);
		this.numCuenta = numCuenta;
		this.banco = banco;
	}

	

	public long getIdPagoCheque() {
		return idPagoCheque;
	}


	public void setIdPagoCheque(long idPagoCheque) {
		this.idPagoCheque = idPagoCheque;
	}


	/**
	 * @return the numCuenta
	 */
	public long getNumCuenta() {
		return numCuenta;
	}


	/**
	 * @param numCuenta the numCuenta to set
	 */
	public void setNumCuenta(long numCuenta) {
		this.numCuenta = numCuenta;
	}


	/**
	 * @return the banco
	 */
	public String getBanco() {
		return banco;
	}


	/**
	 * @param banco the banco to set
	 */
	public void setBanco(String banco) {
		this.banco = banco;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PagoCheque [numCuenta=" + numCuenta + ", banco=" + banco + "]";
	}
	
	
	
	
	
}