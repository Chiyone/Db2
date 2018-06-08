package test;


import negocio.PagoABM;
import negocio.PagoChequeABM;
import negocio.PagoEfectivoABM;
import negocio.PagoTarjetaABM;
import negocio.PersonaABM;

public class TestPago {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		PagoABM.getInstance().agregar(55, null, "qti");
		PagoChequeABM.getInstance().agregar(33, null, "cheque", 111111, "cabal");
		PagoEfectivoABM.getInstance().agregar(44, null, "efectivo", 4);
		PagoTarjetaABM.getInstance().agregar(80, null, "tarjeta", 444433333, 4, 20);
		System.out.println("traer1=\n");
		System.out.println(PagoABM.getInstance().traer(1));
		
		System.out.println("traer2=\n");
		System.out.println(PagoABM.getInstance().traer(2));
		
		System.out.println("traer3=\n");
		System.out.println(PagoABM.getInstance().traer(3));
		
		System.out.println("traer4=\n");
		System.out.println(PagoABM.getInstance().traer(4));
		
		System.out.println("traer all pagos=\n");
		System.out.println(PagoABM.getInstance().traer());
		
		System.out.println("traer all pagosCheque=\n");
		System.out.println(PagoChequeABM.getInstance().traerPagosCheque());
		
		System.out.println("traer all pagosEfectivo=\n");
		System.out.println(PagoEfectivoABM.getInstance().traerPagosEfectivo());
		
		System.out.println("traer all pagosTarjeta=\n");
		System.out.println(PagoTarjetaABM.getInstance().traerPagosTarjeta());
		
		
	}

}
