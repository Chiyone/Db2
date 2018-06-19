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
		
		
		//1-Detalle y totales de ventas para la cadena completa y por sucursal, entre fechas.
		
		//info.totalVentas();
		//info.totalVentas(fecha1,fecha2);
			
		//	info.totalVentasSuc();
		//info.totalVentasSuc(fecha1, fecha2);
	
		 //2-Detalle y totales de ventas para la cadena completa y por sucursal, por obra social o privados entre fechas. 
		
		//info.totalVentasSocial(fecha1,fecha2);
		//info.totalVentasSocialSuc(fecha1,fecha2);
		//info.totalVentasSocialSuc();
		//info.totalVentasSocial();
		
		
		//3-Detalle y totales de cobranza para la cadena completa y por sucursal, por medio de  pago y entre fechas
		
		//info.detalleCobranza(fecha3,fecha2);
		//info.detalleCobranzaSuc(fecha3, fecha2);
		//4-Detalle y totales de ventas de productos, total de la cadena y por sucursal, entre fechas, diferenciados entre farmacia y perfumería. 
		
		//info.totalVentasProductoSuc(fecha1,fecha2);
		//info.totalVentasProducto(fecha1,fecha2);
		
		//5-Ranking de ventas de productos, total de la cadena y por sucursal, entre fechas, por monto
		
		
		
		//info.rankingValor(fecha3, fecha2);
		//info.rankingValorSuc(fecha3, fecha2);
		//6-Ranking de ventas de productos, total de la cadena y por sucursal, entre fechas, por cantidad vendida
		
		//info.rankingCantidad(fecha3,fecha2);
		//info.rankingCantidadSuc(fecha3,fecha2);
		// 7-Ranking de clientes por compras, total de la cadena y por sucursal, entre fechas, por monto
		//info.rankingClienteMonto(fecha3,fecha2);
		//info.rankingClienteMontoSuc(fecha3, fecha2);
		// 8-Ranking de clientes por compras, total de la cadena y por sucursal, entre fechas, porcantidad vendida. 
		//info.rankingClienteCantidadSuc(fecha3, fecha2);
		//info.rankingClienteCantidad(fecha3, fecha2);
	}
	
}
