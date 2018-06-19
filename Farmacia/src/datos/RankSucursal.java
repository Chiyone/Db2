package datos;

import java.util.List;

public class RankSucursal {
	private Sucursal s;
	private List<Rank> ranks;
	
	
	
	
	
	public RankSucursal() {
		super();
	}
	public RankSucursal(Sucursal s, List<Rank> ranks) {
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
	public List<Rank> getRanks() {
		return ranks;
	}
	public void setRanks(List<Rank> ranks) {
		this.ranks = ranks;
	}
	@Override
	public String toString() {
		return "\nRankSucursal [Sucursal=" + s.getIdSucursal() + "\t "+s.getSucursal()+"\n" + ranks + "]\n";
	}
	
	
	
	
}
