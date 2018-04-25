package datos;

public class PagoTarjeta extends Pago{
	private long tarjeta;
	private int cantCuotas;
	private double precioCuota;
	
	
	/**
	 * 
	 */
	public PagoTarjeta() {
		super();
	}


	/**
	 * @param monto
	 * @param cliente
	 * @param tpoPago
	 * @param tarjeta
	 * @param cantCuotas
	 * @param precioCuota
	 */
	public PagoTarjeta(double monto, Cliente cliente, String tpoPago, long tarjeta, int cantCuotas,
			double precioCuota) {
		super(monto, cliente, tpoPago);
		this.tarjeta = tarjeta;
		this.cantCuotas = cantCuotas;
		this.precioCuota = precioCuota;
	}


	/**
	 * @return the tarjeta
	 */
	public long getTarjeta() {
		return tarjeta;
	}


	/**
	 * @param tarjeta the tarjeta to set
	 */
	public void setTarjeta(long tarjeta) {
		this.tarjeta = tarjeta;
	}


	/**
	 * @return the cantCuotas
	 */
	public int getCantCuotas() {
		return cantCuotas;
	}


	/**
	 * @param cantCuotas the cantCuotas to set
	 */
	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}


	/**
	 * @return the precioCuota
	 */
	public double getPrecioCuota() {
		return precioCuota;
	}


	/**
	 * @param precioCuota the precioCuota to set
	 */
	public void setPrecioCuota(double precioCuota) {
		this.precioCuota = precioCuota;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PagoTarjeta [tarjeta=" + tarjeta + ", cantCuotas=" + cantCuotas + ", precioCuota=" + precioCuota + "]";
	}
	
	
}
