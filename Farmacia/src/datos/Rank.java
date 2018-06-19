package datos;

public class Rank {
	
		
		private String producto;
		private int cantidad;
		private double totalVendido;
		private String tipo;
		private RankSucursal suc;
		
		public Rank(String producto, int cantidad, double totalVendido, String tipo) {
			super();
			this.producto = producto;
			this.cantidad = cantidad;
			this.totalVendido = totalVendido;
			this.tipo = tipo;
		}
		
		public String getProducto() {
			return producto;
		}
		public void setProducto(String producto) {
			this.producto = producto;
		}
		public int getCantidad() {
			return cantidad;
		}
		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
		public double getTotalVendido() {
			return totalVendido;
		}
		public void setTotalVendido(double totalVendido) {
			this.totalVendido = totalVendido;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		
		public Rank() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "\nRank [producto=" + producto + ", cantidad=" + cantidad + ", totalVendido=" + totalVendido
					+ ", tipo=" + tipo + "]";
		}

		public RankSucursal getSuc() {
			return suc;
		}

		public void setSuc(RankSucursal suc) {
			this.suc = suc;
		}
		
	
}
