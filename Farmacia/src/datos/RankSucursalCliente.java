package datos;
import java.util.List;

public class RankSucursalCliente {
	private Sucursal s;
	private List<RankCliente> ranks;
	
	
	
	
	
	public RankSucursalCliente() {
		super();
	}
	public RankSucursalCliente(Sucursal s, List<RankCliente> ranks) {
		super();
		this.s = s;
		this.ranks = ranks;
	}
	public Sucursal getS() {
		return s;
	}
	public void setS(Sucursal s) {
		this.s = s;
	}
	public List<RankCliente> getRanks() {
		return ranks;
	}
	public void setRanks(List<RankCliente> ranks) {
		this.ranks = ranks;
	}
	@Override
	public String toString() {
		return "\nSucursal [s=" + s.getIdSucursal() +" "+s.getSucursal()+ ", ranks=" + ranks + "]\n";
	}
	
	
}
