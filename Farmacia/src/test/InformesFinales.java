package test;

import java.util.GregorianCalendar;

import negocio.GeneradorDeInformes;

public class InformesFinales {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		GeneradorDeInformes info=new GeneradorDeInformes();
		
		//info.ventasTotalesImpresas();
		
		GregorianCalendar fecha1= new GregorianCalendar(2018,5,9);
		GregorianCalendar fecha2= new GregorianCalendar(2018,5,11);

		GregorianCalendar fecha3= new GregorianCalendar(2018,1,4);

		//info.ventasFechasImpresas(fecha1, fecha2);
		
		
		//Detalle y totales de ventas para la cadena completa y por sucursal, entre fechas.
		
		//info.totalVentas();
		//info.totalVentas(fecha1,fecha2);
			
		//	info.totalVentasSuc();
		//info.totalVentasSuc(fecha1, fecha2);
	
		 //Detalle y totales de ventas para la cadena completa y por sucursal, por obra social o privados entre fechas. 
		
		
		//info.totalVentasSocialSuc(fecha1,fecha2);
		//info.totalVentasSocialSuc();
		//info.totalVentasSocial();
		//info.totalVentasSocial(fecha1,fecha2);
		
		//Detalle y totales de cobranza para la cadena completa y por sucursal, por medio de  pago y entre fechas
		
		//info.totalVentasProductoSuc(fecha1,fecha2);
		//info.totalVentasProducto(fecha1,fecha2);
		
		// Ranking de ventas de productos, total de la cadena y por sucursal, entre fechas, por monto
		
		//info.rankingMonto(fecha3,fecha2);
		//info.rankingValorSuc(fecha3, fecha2);
		 
		
		//Ranking de ventas de productos, total de la cadena y por sucursal, entre fechas, por cantidad vendida
		
		//info.rankingValor(fecha3, fecha2);
		info.rankingMontoSuc(fecha3,fecha2);
		
	}
	
}
