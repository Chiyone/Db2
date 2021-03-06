package datos;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import datos.Funciones;

public class Venta {
	protected long idVenta;
	private String numTicket;
	private double totalVenta ;
	private GregorianCalendar fecha ;
	private Empleado eAtendio;
	//private Empleado eCobro;
	private Persona eCobro;
	private Sucursal sucursal;
	private Set<ItemVenta> itemsVenta;
	private Pago pago;
	/**
	 * @param numTicket
	 * @param totalVenta
	 * @param fecha
	 * @param eAtendio
	 * @param eCobro
	 * @param sucursal
	 * @param itemsVenta
	 * @param pago
	
	public Venta(String numTicket, double totalVenta, GregorianCalendar fecha, Empleado eAtendio, Empleado eCobro,
			Sucursal sucursal) {
		super();
		this.numTicket = numTicket;
		this.totalVenta = totalVenta;
		this.fecha = fecha;
		this.eAtendio = eAtendio;
		this.eCobro = eCobro;
		this.sucursal = sucursal;

	}
	/**
	 * 
	 */
	
	
	public Venta() {
		super();
	}
	
	public Venta(String numTicket,  GregorianCalendar fecha, Empleado eAtendio, Persona eCobro,
			Sucursal sucursal) {
		super();
		this.numTicket = numTicket;
		this.totalVenta = 0;
		this.fecha = fecha;
		this.eAtendio = eAtendio;
		this.eCobro = eCobro;
		this.sucursal = sucursal;
		
	}

	public long getIdVenta() {
		return idVenta;
	}
	
	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}
	/**
	 * @return the numTicket
	 */
	public String getNumTicket() {
		return numTicket;
	}
	/**
	 * @param numTicket the numTicket to set
	 */
	public void setNumTicket(String numTicket) {
		this.numTicket = numTicket;
	}
	/**
	 * @return the totalVenta
	 */
	public double getTotalVenta() {
		
		return totalVenta;
	}
	
	/**
	 * @param totalVenta the totalVenta to set
	 */
	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}
	/**
	 * @return the fecha
	 */
	public GregorianCalendar getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the eAtendio
	 */
	public Empleado geteAtendio() {
		return eAtendio;
	}
	/**
	 * @param eAtendio the eAtendio to set
	 */
	public void seteAtendio(Empleado eAtendio) {
		this.eAtendio = eAtendio;
	}
	/**
	 * @return the eCobro
	 
	public Empleado geteCobro() {
		return eCobro;
	}
	/**
	 * @param eCobro the eCobro to set
	 *
	public void seteCobro(Empleado eCobro) {
		this.eCobro = eCobro;
	}
	/**
	 * @return the sucursal
	 
	public Sucursal getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return the itemsVenta
	 */
	public Set<ItemVenta> getItemsVenta() {
		return itemsVenta;
	}
	/**
	 * @param itemsVenta the itemsVenta to set
	 */
	public void setItemsVenta(Set<ItemVenta> itemsVenta) {
		this.itemsVenta = itemsVenta;
	}
	/**
	 * @return the pago
	 */
	public Pago getPago() {
		return pago;
	}
	/**
	 * @param pago the pago to set
	 */
	public void setPago(Pago pago) {
		this.pago = pago;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Venta [\nnumTicket=" + numTicket + "\ntotalVenta=" + totalVenta + "\nfecha=" + Funciones.traerFechaCorta(fecha) + "\neAtendio="
				+ eAtendio + "\neCobro=" + eCobro+ "\nsucursal=" + sucursal + "]";
	}
	
	public String ventaYdetalle(String detalles) {
		/*String detalles="";
		Set<ItemVenta>lst = itemsVenta;
		for(ItemVenta i:lst) {
			 detalles=detalles+" "+i+"\n";
		}
		 detalles=detalles+" "+it+"\n";*/
		
		
		return "\nVenta:\nnumTicket=" + numTicket + 
				"\nFecha=" + Funciones.traerFechaCorta(fecha) + 
				"\nDetalles:\n"+detalles+
				"\nTotal Venta=" + totalVenta + 
				"\nAtendio="+ eAtendio.getNombre()+" "+eAtendio.getApellido() +
				"\nCobro=" + eCobro.getNombre()+" "+eCobro.getApellido() + 
				"\nSucursal=" + sucursal.getSucursal() + "\n";
	}
	public String ventasGenerales() {
		
		
		return "Venta=" + idVenta + 
				"\tTotal Venta=" + totalVenta + 
				"\tAtendio="+ eAtendio.getNombre()+" "+eAtendio.getApellido() +
				"\tCobro=" + eCobro.getNombre()+" "+eCobro.getApellido() +
				"\tFecha=" + Funciones.traerFechaCorta(fecha)
				;
				
	}
	

	public Persona geteCobro() {
		return eCobro;
	}

	public void seteCobro(Persona eCobro) {
		this.eCobro = eCobro;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}
	public double calcularTotalVenta() {
		double total=0;
		
		Set<ItemVenta>lst = itemsVenta;
		for(ItemVenta i:lst) {
			 total=total+i.getPrecioTotal();
		}
		return total;
		
		
	}
	
	
}
