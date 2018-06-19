package negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

import java.util.List;

import datos.Afiliado;
import datos.Funciones;
import datos.ItemVenta;
import datos.ObraSocial;
import datos.Pago;
import datos.PagoCheque;
import datos.PagoTarjeta;
import datos.Persona;
import datos.Producto;
import datos.Rank;
import datos.RankCliente;
import datos.RankSucursal;
import datos.RankSucursalCliente;
import datos.Sucursal;
import datos.Venta;
import negocio.VentaABM;




public class GeneradorDeInformes {

	
	//Detalle y totales de ventas para la cadena completa y por sucursal, entre fechas. 
	public void ventasFechasImpresas(GregorianCalendar fecha1,GregorianCalendar fecha2 ) throws Exception {
	VentaABM ventaABM = new VentaABM();
	
	List<Venta> ventas=ventaABM.traerVenta( fecha1, fecha2);
	ItemVentaABM itemventaABM = new ItemVentaABM();
	List<ItemVenta> items=itemventaABM.traerItemVenta();
	System.out.println("Ventas entre "+Funciones.traerFechaCorta(fecha1)+ " y "+Funciones.traerFechaCorta(fecha2));
	String detalles="";
	for(Venta v:ventas) {
		for(ItemVenta it:items) {
			if(it.getVenta().getIdVenta()==v.getIdVenta()) {
				
				
					 detalles=detalles+" "+it+"\n";
			}
				
		
			}
			System.out.println(v.ventaYdetalle(detalles));
			detalles="";
		
	}
	}
	
	public void ventasTotalesImpresas() throws Exception {
	VentaABM ventaABM = new VentaABM();
	
	List<Venta> ventas=ventaABM.traerVentaF();
	ItemVentaABM itemventaABM = new ItemVentaABM();
	List<ItemVenta> items=itemventaABM.traerItemVenta();
	System.out.println("Ventas Totales\n");
	;String detalles="";
	for(Venta v:ventas) {
		for(ItemVenta it:items) {
			if(it.getVenta().getIdVenta()==v.getIdVenta()) {
				
				
					 detalles=detalles+" "+it+"\n";
			}
				
		
		
		
			}
			System.out.println(v.ventaYdetalle(detalles));
			detalles="";
		
	}
	}
	public void totalVentas(GregorianCalendar fecha1,GregorianCalendar fecha2 ) throws Exception {
		VentaABM ventaABM = new VentaABM();
		List<Venta> ventas=ventaABM.traerVenta();
	//	List<Venta> ventas=ventaABM.traerVentaF();
		System.out.println("Ventas Totales entre "+Funciones.traerFechaCorta(fecha1)+ " y "+Funciones.traerFechaCorta(fecha2));
		double sum=0;
		int count=0;
		
		int i=1;
		
		System.out.println(ventaABM.traerVenta().size());
		for (Venta v:ventas) {
		if(fecha1.before(v.getFecha())&&fecha2.after(v.getFecha())) {
		System.out.println(v.ventasGenerales());
			sum=sum+v.getTotalVenta();
			count=count+1;
		}
		}
		System.out.println("\nCantidad de Ventas= "+count+"\t Total = $"+sum );
		
		}
	
	public void totalVentasSuc(GregorianCalendar fecha1,GregorianCalendar fecha2 ) throws Exception {
		VentaABM ventaABM = new VentaABM();
		List<Venta> ventas=ventaABM.traerVenta();
		SucursalABM sucabm=new SucursalABM();
		List<Sucursal> sucursales=sucabm.traerSucursal();
		System.out.println("Ventas Totales entre "+Funciones.traerFechaCorta(fecha1)+ " y "+Funciones.traerFechaCorta(fecha2));
		double sum=0;
		int count=0;
		
		
		for(Sucursal s:sucursales) {
			System.out.println("\nSucursal:\t"+s.getIdSucursal()+"\t"+s.getSucursal());
			for (Venta v:ventas) {
				
				
				if(fecha1.before(v.getFecha())&&fecha2.after(v.getFecha())) {
			
					if(s.getIdSucursal()==v.getSucursal().getIdSucursal()) {
								System.out.println(v.ventasGenerales());
								sum=sum+v.getTotalVenta();
								count=count+1;}
							}
						}
			System.out.println("\nCantidad de Ventas= "+count+"\t Total = $"+sum );
			
			sum=0;
			count=0;
			}
		}
	public void totalVentasSuc() throws Exception {
		VentaABM ventaABM = new VentaABM();
		List<Venta> ventas=ventaABM.traerVenta();
		SucursalABM sucabm=new SucursalABM();
		List<Sucursal> sucursales=sucabm.traerSucursal();
	
		double sum=0;
		int count=0;
		//int cantProducctos=0;
		
		for(Sucursal s:sucursales) {
			System.out.println("\nSucursal:\t"+s.getIdSucursal()+"\t"+s.getSucursal());
			for (Venta v:ventas) {
				
				
				
			
					if(s.getIdSucursal()==v.getSucursal().getIdSucursal()) {
								System.out.println(v.ventasGenerales());
								sum=sum+v.getTotalVenta();
								count=count+1;
								}
					}
			System.out.println("\nCantidad de Ventas= "+count+"\t Total = $"+sum );
			sum=0;
			count=0;
			}
		}
	
	
	public void totalVentas() throws Exception {
		VentaABM ventaABM = new VentaABM();
		List<Venta> ventas=ventaABM.traerVenta();
		System.out.println("Ventas Totales =");
		double sum=0;
		int count=0;
		for (Venta v:ventas) {
				System.out.println(v.ventasGenerales());
				sum=sum+v.getTotalVenta();
				count=count+1;
		}
			System.out.println("\nCantidad de Ventas= "+count+"\t Total = $"+sum );
			}
	
	

	public void totalVentasSocialSuc(GregorianCalendar fecha1, GregorianCalendar fecha2) throws Exception {
		VentaABM ventaABM = new VentaABM();
		ObraSocialABM osabm=new ObraSocialABM();
		SucursalABM sucabm=new SucursalABM();
		AfiliadoABM afiabm=new AfiliadoABM();
		List<Sucursal> sucursales=sucabm.traerSucursal();
		List<Persona> clientes=PersonaABM.getInstance().traerClientes();
		List<Venta> ventas=ventaABM.traerVenta();
		
		List<Pago> pagos=PagoABM.getInstance().traer();
		List<ObraSocial> obras=osabm.traerObraSocial();
		
		System.out.println("Ventas Totales entre  "+Funciones.traerFechaCorta(fecha1) +" y "+Funciones.traerFechaCorta(fecha2));
		boolean flag=false;
		double sum=0;
		int count=0;
		for(Sucursal s:sucursales) {
			System.out.println("\nSucursal:\t"+s.getIdSucursal()+"\t"+s.getSucursal());
			for(ObraSocial o:obras) {
				System.out.println("\n*******"+o.getNombre()+"*******");
				for(Persona a:clientes) {
					if(a.getAfiliado()!=null) {
						if(a.getAfiliado().getObraSocial().getIdObraSoc()==o.getIdObraSoc()) {
							for (Pago p:pagos) {
								if(s.getIdSucursal()==p.getVenta().getSucursal().getIdSucursal()) {
									if(a.getIdPersona()==p.getCliente().getIdPersona()) {
										if(fecha1.before(p.getVenta().getFecha())&&fecha2.after(p.getVenta().getFecha())) {
										System.out.println(p.getVenta().ventasGenerales());
										sum=sum+p.getVenta().getTotalVenta();
										count=count+1;	
										flag=true;}
									}	
								}
							
							}
							if(flag)System.out.println("\n"+o.getNombre()+": Cantidad de Ventas= "+count+"  Total = $"+sum );
							sum=0;
							count=0;
						}	
					}
					
					
				}if(flag==false)System.out.println(" 0");
					flag=false;
						
					
			}
			System.out.println("*******Privados********" );
			for(Persona a:clientes) {
				if(a.getAfiliado()==null) {
					
					for (Pago p:pagos) {
						if(s.getIdSucursal()==p.getVenta().getSucursal().getIdSucursal()) {
							if(a.getIdPersona()==p.getCliente().getIdPersona()) {
								if(fecha1.before(p.getVenta().getFecha())&&fecha2.after(p.getVenta().getFecha())) {
								System.out.println(p.getVenta().ventasGenerales());
								sum=sum+p.getVenta().getTotalVenta();
								count=count+1;	
								flag=true;
								}
							}	
						}
					}
				}
			}if(flag)System.out.println("Privados:Cantidad de Ventas= "+count+"   Total = $"+sum );
					sum=0;
					count=0;
			if(flag==false)System.out.println(" 0");
			flag=false;
		}
	}
				
	
	

		
//if(fecha1.before(p.getVenta().getFecha())&&fecha2.after(p.getVenta().getFecha())) {
public void totalVentasSocialSuc() throws Exception {
	VentaABM ventaABM = new VentaABM();
	ObraSocialABM osabm=new ObraSocialABM();
	SucursalABM sucabm=new SucursalABM();
	AfiliadoABM afiabm=new AfiliadoABM();
	List<Sucursal> sucursales=sucabm.traerSucursal();
	List<Persona> clientes=PersonaABM.getInstance().traerClientes();
	List<Venta> ventas=ventaABM.traerVenta();
	
	List<Pago> pagos=PagoABM.getInstance().traer();
	List<ObraSocial> obras=osabm.traerObraSocial();
	
	System.out.println("Ventas Totales ");
	boolean flag=false;
	double sum=0;
	int count=0;
	for(Sucursal s:sucursales) {
		System.out.println("\nSucursal:\t"+s.getIdSucursal()+"\t"+s.getSucursal());
		for(ObraSocial o:obras) {
			System.out.println("\n"+o.getNombre()+": ");
			for(Persona a:clientes) {
				if(a.getAfiliado()!=null) {
					if(a.getAfiliado().getObraSocial().getIdObraSoc()==o.getIdObraSoc()) {
						for (Pago p:pagos) {
							if(s.getIdSucursal()==p.getVenta().getSucursal().getIdSucursal()) {
								if(a.getIdPersona()==p.getCliente().getIdPersona()) {
									System.out.println(p.getVenta().ventasGenerales());
									sum=sum+p.getVenta().getTotalVenta();
									count=count+1;	
									flag=true;
								}	
							}
						
						}
						if(flag)System.out.println("\nCantidad de Ventas= "+count+"\t Total = $"+sum );
						sum=0;
						count=0;
					}	
				}
				
				
			}if(flag==false)System.out.println(" 0");
				flag=false;
					
				
		}
		System.out.println("Privados:" );
		for(Persona a:clientes) {
			if(a.getAfiliado()==null) {
				
				for (Pago p:pagos) {
					if(s.getIdSucursal()==p.getVenta().getSucursal().getIdSucursal()) {
						if(a.getIdPersona()==p.getCliente().getIdPersona()) {
							System.out.println(p.getVenta().ventasGenerales());
							sum=sum+p.getVenta().getTotalVenta();
							count=count+1;	
							flag=true;
						}	
					}
				}
			}
		}if(flag)System.out.println("\nCantidad de Ventas= "+count+"\t Total = $"+sum );
				sum=0;
				count=0;
		if(flag==false)System.out.println(" 0");
		flag=false;
	}
}
	
public void totalVentasSocial() throws Exception {
	VentaABM ventaABM = new VentaABM();
	ObraSocialABM osabm=new ObraSocialABM();
	SucursalABM sucabm=new SucursalABM();
	AfiliadoABM afiabm=new AfiliadoABM();
	List<Sucursal> sucursales=sucabm.traerSucursal();
	List<Persona> clientes=PersonaABM.getInstance().traerClientes();
	List<Venta> ventas=ventaABM.traerVenta();
	
	List<Pago> pagos=PagoABM.getInstance().traer();
	List<ObraSocial> obras=osabm.traerObraSocial();
	
	System.out.println("Ventas Totales ");
	boolean flag=false;
	double sum=0;
	int count=0;
	
		for(ObraSocial o:obras) {
			System.out.println("\n"+o.getNombre()+": ");
			for(Persona a:clientes) {
				if(a.getAfiliado()!=null) {
					if(a.getAfiliado().getObraSocial().getIdObraSoc()==o.getIdObraSoc()) {
						for (Pago p:pagos) {
							
								if(a.getIdPersona()==p.getCliente().getIdPersona()) {
									System.out.println(p.getVenta().ventasGenerales());
									sum=sum+p.getVenta().getTotalVenta();
									count=count+1;	
									flag=true;
								}	
							
						
						}
						System.out.println("\nCantidad de Ventas "+o.getNombre()+" = "+count+"\t Total = $"+sum );
						sum=0;
						count=0;
					}	
				}
				
				
			}if(flag==false)System.out.println("Cantidad de Ventas "+o.getNombre()+" = "+count+"\t Total = $"+sum );
				flag=false;
					
				
		}
		System.out.println("Privados:" );
		for(Persona a:clientes) {
			if(a.getAfiliado()==null) {
				
				for (Pago p:pagos) {
					
						if(a.getIdPersona()==p.getCliente().getIdPersona()) {
							System.out.println(p.getVenta().ventasGenerales());
							sum=sum+p.getVenta().getTotalVenta();
							count=count+1;	
							flag=true;
						}	
				
				}
			}
		}System.out.println("\nCantidad de Ventas Privados= "+count+" Total = $"+sum );
				sum=0;
				count=0;
		//System.out.println(" 0");
		flag=false;
	}



public void totalVentasSocial(GregorianCalendar fecha1, GregorianCalendar fecha2) throws Exception {
	VentaABM ventaABM = new VentaABM();
	ObraSocialABM osabm=new ObraSocialABM();
	SucursalABM sucabm=new SucursalABM();
	AfiliadoABM afiabm=new AfiliadoABM();
	List<Sucursal> sucursales=sucabm.traerSucursal();
	List<Persona> clientes=PersonaABM.getInstance().traerClientes();
	List<Venta> ventas=ventaABM.traerVenta();
	
	List<Pago> pagos=PagoABM.getInstance().traer();
	List<ObraSocial> obras=osabm.traerObraSocial();
	
	System.out.println("Ventas Totales entre  "+Funciones.traerFechaCorta(fecha1) +" y "+Funciones.traerFechaCorta(fecha2));
	boolean flag=false;
	double sum=0;
	int count=0;
	
		for(ObraSocial o:obras) {
			System.out.println("\n*******"+o.getNombre()+"*******");
			for(Persona a:clientes) {
				if(a.getAfiliado()!=null) {
					if(a.getAfiliado().getObraSocial().getIdObraSoc()==o.getIdObraSoc()) {
						for (Pago p:pagos) {
							
								if(a.getIdPersona()==p.getCliente().getIdPersona()) {
									if(fecha1.before(p.getVenta().getFecha())&&fecha2.after(p.getVenta().getFecha())) {
									System.out.println(p.getVenta().ventasGenerales());
									sum=sum+p.getVenta().getTotalVenta();
									count=count+1;	
									flag=true;}
								}	
							
						
						}
						if(flag)System.out.println("\n"+o.getNombre()+": Cantidad de Ventas= "+count+"  Total = $"+sum );
						sum=0;
						count=0;
					}	
				}
				
				
			}if(flag==false)System.out.println("\n"+o.getNombre()+": Cantidad de Ventas= "+count+"  Total = $"+sum );
				flag=false;
					
				
		}
		System.out.println("*******Privados********" );
		for(Persona a:clientes) {
			if(a.getAfiliado()==null) {
				
				for (Pago p:pagos) {
					
						if(a.getIdPersona()==p.getCliente().getIdPersona()) {
							if(fecha1.before(p.getVenta().getFecha())&&fecha2.after(p.getVenta().getFecha())) {
							System.out.println(p.getVenta().ventasGenerales());
							sum=sum+p.getVenta().getTotalVenta();
							count=count+1;	
							flag=true;
							}
						}	
					
				}
			}
		}System.out.println("Privados:Cantidad de Ventas= "+count+"   Total = $"+sum );
				sum=0;
				count=0;
//		if(flag==false)System.out.println(" 0");
		flag=false;
	}

public void totalVentasProducto(GregorianCalendar fecha1, GregorianCalendar fecha2) throws Exception {
	VentaABM ventaABM = new VentaABM();
	ObraSocialABM osabm=new ObraSocialABM();
	SucursalABM sucabm=new SucursalABM();
	
	List<Persona> clientes=PersonaABM.getInstance().traerClientes();
	List<Venta> ventas=ventaABM.traerVenta();
	
	List<Pago> pagos=PagoABM.getInstance().traer();
	List<ObraSocial> obras=osabm.traerObraSocial();
	ItemVentaABM itemabm=new ItemVentaABM();
	
	List<ItemVenta>  items=itemabm.traerItemVenta();
	ProductoABM prodabm=new ProductoABM();
	List<Producto> productosF=prodabm.traerProductos("Farmacia");
	List<Producto> productosP=prodabm.traerProductos("Perfumeria");
 	System.out.println("Ventas Totales entre  "+Funciones.traerFechaCorta(fecha1) +" y "+Funciones.traerFechaCorta(fecha2));
	boolean flag=false;
	double sum=0;
	int count=0;
	System.out.println("Productos Farmacia ");
		for(Producto pr:productosF) {
			System.out.println("\nProductos= "+pr.getDescripcion()+" Laboratorio= "+pr.getLaboratorio()+" Tipo= Medicamento ");
			for(ItemVenta i:items) {
				if(fecha1.before(i.getVenta().getFecha())&&fecha2.after(i.getVenta().getFecha())) {
					if(i.getProducto().getIdProducto()==pr.getIdProducto()) {
						sum=sum+i.getPrecioTotal();
						count=count+i.getCantidad();
					}	
				 }
			}
			System.out.println("Cantidad vendidos= "+count+" Total vendido= $"+sum+" Precio Unitario= $"+pr.getPrecio());
			sum=0;
			count=0;
		}
		for(Producto pr:productosP) {
			System.out.println("\nProductos= "+pr.getDescripcion()+" Laboratorio= "+pr.getLaboratorio()+" Tipo= Perfumeria ");
			for(ItemVenta i:items) {
				if(fecha1.before(i.getVenta().getFecha())&&fecha2.after(i.getVenta().getFecha())) {
					if(i.getProducto().getIdProducto()==pr.getIdProducto()) {
						sum=sum+i.getPrecioTotal();
						count=count+i.getCantidad();
					}	
				 }
			}
			System.out.println("Cantidad vendidos= "+count+" Total vendido= $"+sum+" Precio Unitario= $"+pr.getPrecio());
			sum=0;
			count=0;
		}
	}


public void totalVentasProductoSuc(GregorianCalendar fecha1, GregorianCalendar fecha2) throws Exception {
	VentaABM ventaABM = new VentaABM();
	ObraSocialABM osabm=new ObraSocialABM();
	SucursalABM sucabm=new SucursalABM();
	
	List<Persona> clientes=PersonaABM.getInstance().traerClientes();
	List<Venta> ventas=ventaABM.traerVenta();
	
	List<Pago> pagos=PagoABM.getInstance().traer();
	List<ObraSocial> obras=osabm.traerObraSocial();
	ItemVentaABM itemabm=new ItemVentaABM();
	List<Sucursal> sucursales=sucabm.traerSucursal();
	List<ItemVenta>  items=itemabm.traerItemVenta();
	ProductoABM prodabm=new ProductoABM();
	List<Producto> productosF=prodabm.traerProductos("Farmacia");
	List<Producto> productosP=prodabm.traerProductos("Perfumeria");
 	System.out.println("Ventas Totales entre  "+Funciones.traerFechaCorta(fecha1) +" y "+Funciones.traerFechaCorta(fecha2));
	boolean flag=false;
	double sum=0;
	int count=0;
	System.out.println("Productos Farmacia ");
	for(Sucursal s:sucursales) {
		System.out.println("\n********Productos  de la sucursal: "+s.getIdSucursal()+"   "+s.getSucursal()+"********");
		for(Producto pr:productosF) {
			System.out.println("\nProductos= "+pr.getDescripcion()+" Laboratorio= "+pr.getLaboratorio()+" Tipo= Medicamento ");
			for(ItemVenta i:items) {
				if(fecha1.before(i.getVenta().getFecha())&&fecha2.after(i.getVenta().getFecha())) {
					if(i.getProducto().getIdProducto()==pr.getIdProducto()) {
						if(s.getIdSucursal()==i.getVenta().getSucursal().getIdSucursal()) {
						sum=sum+i.getPrecioTotal();
						count=count+i.getCantidad();
						}
					}	
				 }
			}
			System.out.println("Cantidad vendidos= "+count+" Total vendido= $"+sum+" Precio Unitario= $"+pr.getPrecio());
			sum=0;
			count=0;
		}
	
			for(Producto pr:productosP) {
				System.out.println("\nProductos= "+pr.getDescripcion()+" Laboratorio= "+pr.getLaboratorio()+" Tipo= Perfumeria ");
				for(ItemVenta i:items) {
					if(fecha1.before(i.getVenta().getFecha())&&fecha2.after(i.getVenta().getFecha())) {
						if(i.getProducto().getIdProducto()==pr.getIdProducto()) {
							if(s.getIdSucursal()==i.getVenta().getSucursal().getIdSucursal()){
							sum=sum+i.getPrecioTotal();
							count=count+i.getCantidad();}
						}	
					 }
				}
				System.out.println("Cantidad vendidos= "+count+" Total vendido= $"+sum+" Precio Unitario= $"+pr.getPrecio());
				sum=0;
				count=0;
			}



	}
}


public void rankingCantidad(GregorianCalendar fecha1, GregorianCalendar fecha2) throws Exception {
	
	ItemVentaABM itemabm=new ItemVentaABM();
	List<ItemVenta>  items=itemabm.traerItemVenta();
	ProductoABM prodabm=new ProductoABM();
	List<Producto> productos=prodabm.traerProducto();
	
	double sum=0;
	int count=0;
	;
	Rank rank=null;
	List<Rank>ranks=new ArrayList<Rank>();
	
		for(Producto pr:productos) {
			for(ItemVenta i:items) {
				if(fecha1.before(i.getVenta().getFecha())&&fecha2.after(i.getVenta().getFecha())) {
					if(i.getProducto().getIdProducto()==pr.getIdProducto()) {
						sum=sum+i.getPrecioTotal();
						count=count+i.getCantidad();
					}	
				 }
			}
				rank=new Rank(pr.getDescripcion(),count,sum,pr.getTipo().toString());
				ranks.add(rank);
				sum=0;
				count=0;
		}
		
	    Collections.sort(ranks, new Comparator<Rank>() {
	    	 
	        @Override
	        public int compare(Rank p1, Rank p2) {
	            return p2.getCantidad()-p1.getCantidad();
	        }
	    });	
			
		
		System.out.println(ranks);
		
	}
@SuppressWarnings("unchecked")
public void rankingValor(GregorianCalendar fecha1, GregorianCalendar fecha2) throws Exception {
	// TODO Auto-generated method stub
	VentaABM ventaABM = new VentaABM();
	ObraSocialABM osabm=new ObraSocialABM();
	SucursalABM sucabm=new SucursalABM();
	List<Sucursal> sucursales=sucabm.traerSucursal();
	
	ItemVentaABM itemabm=new ItemVentaABM();
	
	List<ItemVenta>  items=itemabm.traerItemVenta();
	ProductoABM prodabm=new ProductoABM();
	List<Producto> productos=prodabm.traerProducto();
	double sum=0;
	int count=0;

	Rank rank=null;
	List<Rank>ranks=new ArrayList<Rank>();
		for(Producto pr:productos) {
			for(ItemVenta i:items) {
				if(fecha1.before(i.getVenta().getFecha())&&fecha2.after(i.getVenta().getFecha())) {
					if(i.getProducto().getIdProducto()==pr.getIdProducto()) {
						sum=sum+i.getPrecioTotal();
						count=count+i.getCantidad();
					}	
				 }
			}
		rank=new Rank(pr.getDescripcion(),count,sum,pr.getTipo().toString());
		ranks.add(rank);
		sum=0;
		count=0;
		}
	    Collections.sort(ranks, new Comparator<Rank>() {	 
	        @Override
	        public int compare(Rank p1, Rank p2) {
	            return (int) (p2.getTotalVendido()-p1.getTotalVendido());
	        }});	
			
		
		System.out.println(ranks);
		ranks.clear();
		
	}
	
@SuppressWarnings("unchecked")
public void rankingValorSuc(GregorianCalendar fecha1, GregorianCalendar fecha2) throws Exception {
	// TODO Auto-generated method stub
	VentaABM ventaABM = new VentaABM();
	ObraSocialABM osabm=new ObraSocialABM();
	SucursalABM sucabm=new SucursalABM();
	List<Sucursal> sucursales=sucabm.traerSucursal();
	List<Persona> clientes=PersonaABM.getInstance().traerClientes();
	List<Venta> ventas=ventaABM.traerVenta();
	
	List<Pago> pagos=PagoABM.getInstance().traer();
	List<ObraSocial> obras=osabm.traerObraSocial();
	ItemVentaABM itemabm=new ItemVentaABM();
	
	List<ItemVenta>  items=itemabm.traerItemVenta();
	ProductoABM prodabm=new ProductoABM();
	List<Producto> productos=prodabm.traerProducto();
	
 	//System.out.println("Ventas Totales entre  "+Funciones.traerFechaCorta(fecha1) +" y "+Funciones.traerFechaCorta(fecha2));
	//boolean flag=false;
	double sum=0;
	int count=0;
	int itr=0;
	Rank rank=null;
	List<Rank>ranks=new ArrayList<Rank>();
	RankSucursal rankSuc=null;
	List<RankSucursal>ranksSuc=new ArrayList<RankSucursal>();
	//System.out.println("Productos Farmacia ");
	for(Sucursal s:sucursales) {
		//System.out.println("Sucursal= "+ s.getIdSucursal()+ "  "+s.getSucursal());
		
		for(Producto pr:productos) {
			
			
			//System.out.println("\nProducto= "+pr.getDescripcion()+" Laboratorio= "+pr.getLaboratorio()+" Tipo= "+pr.getTipo());
			for(ItemVenta i:items) {
				if(fecha1.before(i.getVenta().getFecha())&&fecha2.after(i.getVenta().getFecha())) {
					if(i.getProducto().getIdProducto()==pr.getIdProducto()) {
						if(s.getIdSucursal()==i.getVenta().getSucursal().getIdSucursal()) {
						sum=sum+i.getPrecioTotal();
						count=count+i.getCantidad();
						}
					}	
				 }
			}
			 rank=new Rank(pr.getDescripcion(),count,sum,pr.getTipo().toString());
			//System.out.println("Cantidad vendidos= "+count+" Total vendido= $"+sum+" Precio Unitario= $"+pr.getPrecio());
			
			// System.out.println(rank);
			// System.out.println(ranks.add(rank));
			 ranks.add(rank);
			
			
			sum=0;
			count=0;
		}
		int i=1;
		Rank aux=null;
		//ranks=ordenar(ranks);
		//System.out.println(ranks);
		
	    Collections.sort(ranks, new Comparator<Rank>() {
	    	 
	        @Override
	        public int compare(Rank p1, Rank p2) {
	            return (int) (p2.getTotalVendido()-p1.getTotalVendido());
	        }
	    });	
	    rankSuc=new RankSucursal(s,ranks);
		ranksSuc.add(rankSuc);
		//System.out.println(ranks);
		
		//ranks.clear();
		ranks=null;
		ranks=new ArrayList<Rank>();
		//System.out.println(ranks);
	
		}System.out.println(ranksSuc);
	}
			



@SuppressWarnings("unchecked")
public void rankingCantidadSuc(GregorianCalendar fecha1, GregorianCalendar fecha2) throws Exception {
	// TODO Auto-generated method stub
	VentaABM ventaABM = new VentaABM();
	ObraSocialABM osabm=new ObraSocialABM();
	SucursalABM sucabm=new SucursalABM();
	
	List<Persona> clientes=PersonaABM.getInstance().traerClientes();
	List<Venta> ventas=ventaABM.traerVenta();
	
	List<Pago> pagos=PagoABM.getInstance().traer();
	List<ObraSocial> obras=osabm.traerObraSocial();
	ItemVentaABM itemabm=new ItemVentaABM();
	
	List<ItemVenta>  items=itemabm.traerItemVenta();
	ProductoABM prodabm=new ProductoABM();
	List<Producto> productos=prodabm.traerProducto();
	List<Sucursal> sucursales=sucabm.traerSucursal();
 	//System.out.println("Ventas Totales entre  "+Funciones.traerFechaCorta(fecha1) +" y "+Funciones.traerFechaCorta(fecha2));
	//boolean flag=false;
	double sum=0;
	int count=0;
	int itr=0;
	Rank rank=null;
	List<Rank>ranks=new ArrayList<Rank>();
	RankSucursal rankSuc=null;
	List<RankSucursal>ranksSuc=new ArrayList<RankSucursal>();
	
	for(Sucursal s:sucursales) {
		
		//ranksSuc.add(rankSuc);
		//System.out.println("Sucursal= "+ s.getIdSucursal()+ "  "+s.getSucursal());
	//System.out.println("Productos Farmacia ");
		for(Producto pr:productos) {
			//System.out.println("\nProducto= "+pr.getDescripcion()+" Laboratorio= "+pr.getLaboratorio()+" Tipo= "+pr.getTipo());
			for(ItemVenta i:items) {
				if(fecha1.before(i.getVenta().getFecha())&&fecha2.after(i.getVenta().getFecha())) {
					if(i.getProducto().getIdProducto()==pr.getIdProducto()) {
						if(i.getVenta().getSucursal().getIdSucursal()==s.getIdSucursal()) {
						sum=sum+i.getPrecioTotal();
						count=count+i.getCantidad();
						}
					}	
				 }
			}
			 rank=new Rank(pr.getDescripcion(),count,sum,pr.getTipo().toString());
			//System.out.println("Cantidad vendidos= "+count+" Total vendido= $"+sum+" Precio Unitario= $"+pr.getPrecio());
			
			// System.out.println(rank);
			// System.out.println(ranks.add(rank));
			 
			 
			 ranks.add(rank);
			 
			
			
			sum=0;
			count=0;
		}
		int i=1;
		Rank aux=null;
		//ranks=ordenar(ranks);
		//System.out.println(ranks);
		
	    Collections.sort(ranks, new Comparator<Rank>() {
	    	 
	        @Override
	        public int compare(Rank p1, Rank p2) {
	            return p2.getCantidad()-p1.getCantidad();
	        }
	    });	
			
	   rankSuc=new RankSucursal();
	    rankSuc.setRanks(ranks);
	    rankSuc.setS(s);
	    ranksSuc.add(rankSuc);
		//System.out.println(ranks);
		
		ranks=null;
		ranks=new ArrayList<Rank>();
		//ranks.clear();
		}System.out.println(ranksSuc);
	
	}

public void rankingClienteMonto(GregorianCalendar fecha1, GregorianCalendar fecha2) throws Exception {
	// TODO Auto-generated method stub
		VentaABM ventaABM = new VentaABM();
		ObraSocialABM osabm=new ObraSocialABM();
		SucursalABM sucabm=new SucursalABM();
		
		List<Persona> clientes=PersonaABM.getInstance().traer();
		List<Venta> ventas=ventaABM.traerVenta();
		
		List<Pago> pagos=PagoABM.getInstance().traer();
		List<ObraSocial> obras=osabm.traerObraSocial();
		ItemVentaABM itemabm=new ItemVentaABM();
		
		List<ItemVenta>  items=itemabm.traerItemVenta();
		ProductoABM prodabm=new ProductoABM();
		List<Producto> productos=prodabm.traerProducto();
		List<Sucursal> sucursales=sucabm.traerSucursal();
	 	//System.out.println("Ventas Totales entre  "+Funciones.traerFechaCorta(fecha1) +" y "+Funciones.traerFechaCorta(fecha2));
		//boolean flag=false;
		double sum=0;
		int count=0;
		
		RankCliente rank=null;
		List<RankCliente>ranks=new ArrayList<RankCliente>();
		//RankSucursal rankSuc=null;
		//List<RankSucursal>ranksSuc=new ArrayList<RankSucursal>();
		
		for(Persona c:clientes) {
			
			for(Pago p:pagos) {
				for(ItemVenta i:items) {
					if(i.getVenta().getIdVenta()==p.getVenta().getIdVenta()) {
						if(p.getCliente().getIdPersona()==c.getIdPersona()){
							if(fecha1.before(i.getVenta().getFecha())&&fecha2.after(i.getVenta().getFecha())) {
								sum=sum+i.getPrecioTotal();
								count=count+i.getCantidad();
								
							}
						
						}
					}
				}	
				
				
			}if(sum!=0) {rank=new RankCliente(c.getNombre(),c.getApellido(),sum,count);
				ranks.add(rank); }
			
			sum=0;
			count=0;
			
			
		}
			
		
		
		
			//ranks=ordenar(ranks);
			//System.out.println(ranks);
			
		    Collections.sort(ranks, new Comparator<RankCliente>() {
		    	 
		        @Override
		        public int compare(RankCliente p1, RankCliente p2) {
		            return (int) (p2.getMonto()-p1.getMonto());
		        }
		    });	
				
		    //rankSuc=new RankSucursal(s,ranks);
			//ranksSuc.add(rankSuc);
			System.out.println(ranks);
			//System.out.println(ranksSuc);
			ranks.clear();
			
			}
		
		
public void rankingClienteCantidad(GregorianCalendar fecha1, GregorianCalendar fecha2) throws Exception {
	// TODO Auto-generated method stub
		VentaABM ventaABM = new VentaABM();
		ObraSocialABM osabm=new ObraSocialABM();
		SucursalABM sucabm=new SucursalABM();
		
		List<Persona> clientes=PersonaABM.getInstance().traer();
		List<Venta> ventas=ventaABM.traerVenta();
		
		List<Pago> pagos=PagoABM.getInstance().traer();
		List<ObraSocial> obras=osabm.traerObraSocial();
		ItemVentaABM itemabm=new ItemVentaABM();
		
		List<ItemVenta>  items=itemabm.traerItemVenta();
		ProductoABM prodabm=new ProductoABM();
		List<Producto> productos=prodabm.traerProducto();
		List<Sucursal> sucursales=sucabm.traerSucursal();
	 	//System.out.println("Ventas Totales entre  "+Funciones.traerFechaCorta(fecha1) +" y "+Funciones.traerFechaCorta(fecha2));
		//boolean flag=false;
		double sum=0;
		int count=0;
		
		RankCliente rank=null;
		List<RankCliente>ranks=new ArrayList<RankCliente>();
		//RankSucursal rankSuc=null;
		//List<RankSucursal>ranksSuc=new ArrayList<RankSucursal>();
		
		for(Persona c:clientes) {
			
			for(Pago p:pagos) {
				for(ItemVenta i:items) {
					if(i.getVenta().getIdVenta()==p.getVenta().getIdVenta()) {
						if(p.getCliente().getIdPersona()==c.getIdPersona()){
							if(fecha1.before(i.getVenta().getFecha())&&fecha2.after(i.getVenta().getFecha())) {
								sum=sum+i.getPrecioTotal();
								count=count+i.getCantidad();
								
							}
						
						}
					}
				}	
				
				
			}if(sum!=0) {rank=new RankCliente(c.getNombre(),c.getApellido(),sum,count);
				ranks.add(rank);}
			sum=0;
			count=0;
			
			
			
		}
			
		
		
		
			//ranks=ordenar(ranks);
			//System.out.println(ranks);
			
		    Collections.sort(ranks, new Comparator<RankCliente>() {
		    	 
		        @Override
		        public int compare(RankCliente p1, RankCliente p2) {
		            return (int) (p2.getCantidad()-p1.getCantidad());
		        }
		    });	
				
		    //rankSuc=new RankSucursal(s,ranks);
			//ranksSuc.add(rankSuc);
			System.out.println(ranks);
			//System.out.println(ranksSuc);
			ranks.clear();
			
			}

public void rankingClienteCantidadSuc(GregorianCalendar fecha1, GregorianCalendar fecha2) throws Exception {
	// TODO Auto-generated method stub
			VentaABM ventaABM = new VentaABM();
			ObraSocialABM osabm=new ObraSocialABM();
			SucursalABM sucabm=new SucursalABM();
			
			List<Persona> clientes=PersonaABM.getInstance().traer();
			List<Venta> ventas=ventaABM.traerVenta();
			
			List<Pago> pagos=PagoABM.getInstance().traer();
			List<ObraSocial> obras=osabm.traerObraSocial();
			ItemVentaABM itemabm=new ItemVentaABM();
			
			List<ItemVenta>  items=itemabm.traerItemVenta();
			ProductoABM prodabm=new ProductoABM();
			List<Producto> productos=prodabm.traerProducto();
			List<Sucursal> sucursales=sucabm.traerSucursal();
		 	//System.out.println("Ventas Totales entre  "+Funciones.traerFechaCorta(fecha1) +" y "+Funciones.traerFechaCorta(fecha2));
			//boolean flag=false;
			double sum=0;
			int count=0;
			boolean flag=false;
			RankSucursalCliente rankSuc=null;
			RankCliente rank=null;
			//List<RankCliente>ranks=new ArrayList<RankCliente>();
			
			List<RankSucursalCliente>ranksSuc=new ArrayList<RankSucursalCliente>();
			for(Sucursal s: sucursales){
				
				List<RankCliente>ranks=new ArrayList<RankCliente>();
					for(Persona c:clientes) {
						
						for(Pago p:pagos) {
							for(ItemVenta i:items) {
								if(i.getVenta().getIdVenta()==p.getVenta().getIdVenta()) {
									if(p.getCliente().getIdPersona()==c.getIdPersona()){
										if(fecha1.before(i.getVenta().getFecha())&&fecha2.after(i.getVenta().getFecha())) {
											if(s.getIdSucursal()==i.getVenta().getSucursal().getIdSucursal()) {
											sum=sum+i.getPrecioTotal();
											
											count=count+i.getCantidad();
											flag=true;
											
											}
											
										}
									
									}
								}
							}	
							
							
						}
				
					if(flag=true&&sum!=0)	{rank=new RankCliente(c.getNombre(),c.getApellido(),sum,count);
							ranks.add(rank);}
				sum=0;
				count=0;
			
				}
			
			
				//ranks=ordenar(ranks);
				//System.out.println(ranks);
				
			    Collections.sort(ranks, new Comparator<RankCliente>() {
			    	 
			        @Override
			        public int compare(RankCliente p1, RankCliente p2) {
			            return (int) (p2.getCantidad()-p1.getCantidad());
			        }
			    });	
			   /* System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			    List<RankCliente>lst=new ArrayList<RankCliente>();
			    lst=ranks;;*/
			    rankSuc=new RankSucursalCliente();
			    rankSuc.setS(s);
			    rankSuc.setRanks(ranks);
				ranksSuc.add(rankSuc);
				//System.out.println(ranks);
				
				
				//ranks.clear();
				 ranks=null;
				}
				System.out.println(ranksSuc);

}

public void rankingClienteMontoSuc(GregorianCalendar fecha1, GregorianCalendar fecha2) throws Exception {
	// TODO Auto-generated method stub
			VentaABM ventaABM = new VentaABM();
			ObraSocialABM osabm=new ObraSocialABM();
			SucursalABM sucabm=new SucursalABM();
			
			List<Persona> clientes=PersonaABM.getInstance().traer();
			List<Venta> ventas=ventaABM.traerVenta();
			
			List<Pago> pagos=PagoABM.getInstance().traer();
			List<ObraSocial> obras=osabm.traerObraSocial();
			ItemVentaABM itemabm=new ItemVentaABM();
			
			List<ItemVenta>  items=itemabm.traerItemVenta();
			ProductoABM prodabm=new ProductoABM();
			List<Producto> productos=prodabm.traerProducto();
			List<Sucursal> sucursales=sucabm.traerSucursal();
		 	//System.out.println("Ventas Totales entre  "+Funciones.traerFechaCorta(fecha1) +" y "+Funciones.traerFechaCorta(fecha2));
			//boolean flag=false;
			double sum=0;
			int count=0;
			boolean flag=false;
			RankSucursalCliente rankSuc=null;
			RankCliente rank=null;
			//List<RankCliente>ranks=new ArrayList<RankCliente>();
			
			List<RankSucursalCliente>ranksSuc=new ArrayList<RankSucursalCliente>();
			for(Sucursal s: sucursales){
				
				List<RankCliente>ranks=new ArrayList<RankCliente>();
					for(Persona c:clientes) {
						
						for(Pago p:pagos) {
							for(ItemVenta i:items) {
								if(i.getVenta().getIdVenta()==p.getVenta().getIdVenta()) {
									if(p.getCliente().getIdPersona()==c.getIdPersona()){
										if(fecha1.before(i.getVenta().getFecha())&&fecha2.after(i.getVenta().getFecha())) {
											if(s.getIdSucursal()==i.getVenta().getSucursal().getIdSucursal()) {
											sum=sum+i.getPrecioTotal();
											
											count=count+i.getCantidad();
											flag=true;
											
											}
											
										}
									
									}
								}
							}	
							
							
						}
				
					if(flag=true&&sum!=0)	{rank=new RankCliente(c.getNombre(),c.getApellido(),sum,count);
							ranks.add(rank);}
				sum=0;
				count=0;
			
				}
			
			
				//ranks=ordenar(ranks);
				//System.out.println(ranks);
				
			    Collections.sort(ranks, new Comparator<RankCliente>() {
			    	 
			        @Override
			        public int compare(RankCliente p1, RankCliente p2) {
			            return (int) (p2.getMonto()-p1.getMonto());
			        }
			    });	
			   /* System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			    List<RankCliente>lst=new ArrayList<RankCliente>();
			    lst=ranks;;*/
			    rankSuc=new RankSucursalCliente();
			    rankSuc.setS(s);
			    rankSuc.setRanks(ranks);
				ranksSuc.add(rankSuc);
				//System.out.println(ranks);
				
				
				//ranks.clear();
				 ranks=null;
				}
				System.out.println(ranksSuc);

}

public void detalleCobranza(GregorianCalendar fecha1, GregorianCalendar fecha2) throws Exception {
	VentaABM ventaABM = new VentaABM();
	ObraSocialABM osabm=new ObraSocialABM();
	SucursalABM sucabm=new SucursalABM();
	
	List<Persona> clientes=PersonaABM.getInstance().traer();
	List<Venta> ventas=ventaABM.traerVenta();
	
	
	List<ObraSocial> obras=osabm.traerObraSocial();
	ItemVentaABM itemabm=new ItemVentaABM();
	
	List<ItemVenta>  items=itemabm.traerItemVenta();
	ProductoABM prodabm=new ProductoABM();
	List<Producto> productos=prodabm.traerProducto();
	List<Sucursal> sucursales=sucabm.traerSucursal();
 	//System.out.println("Ventas Totales entre  "+Funciones.traerFechaCorta(fecha1) +" y "+Funciones.traerFechaCorta(fecha2));
	//boolean flag=false;
	
	List<Pago> pagosE=PagoEfectivoABM.getInstance().traerPagosEfectivo();
	List<PagoTarjeta> pagosT=PagoTarjetaABM.getInstance().traerPagosTarjeta();
	List<PagoCheque> pagosC=PagoChequeABM.getInstance().traerPagosCheque();
	double sum=0;
	int count=0;
	boolean flag=false;
	System.out.println("\nEfectivo=\n");
	for(Pago p:pagosE) {
			if(fecha1.before(p.getVenta().getFecha())&&fecha2.after(p.getVenta().getFecha())) {
				sum=sum+p.getVenta().getTotalVenta();
				count=count+1;
				System.out.println("IDpago:"+p.getIdPago()+" $"+p.getVenta().getTotalVenta()+"  Cliente: "+p.getCliente().getNombre()+" "+p.getCliente().getApellido() );
			}
	
	}
	System.out.println("Cantidad de Pagos: "+count+" Total de cobranza:"+sum+"\n");
	sum=0;
	count=0;
	System.out.println("\nTarjeta=\n");
	for(PagoTarjeta p:pagosT) {
			if(fecha1.before(p.getVenta().getFecha())&&fecha2.after(p.getVenta().getFecha())) {
				sum=sum+p.getVenta().getTotalVenta();
				count=count+1;
				System.out.println("Pago:"+p.getIdPago()+" $"+p.getVenta().getTotalVenta()+ " Cantidad de cuotas:"
				+p.getCantCuotas()+"  Cliente: "+p.getCliente().getNombre()+" "+p.getCliente().getApellido() );
			}
	
	}
	System.out.println("Cantidad de Pagos: "+count+" Total de cobranza:"+sum+"\n");
	sum=0;
	count=0;
	System.out.println("\nCheque=\n");
	for(PagoCheque p:pagosC) {
			if(fecha1.before(p.getVenta().getFecha())&&fecha2.after(p.getVenta().getFecha())) {
				sum=sum+p.getVenta().getTotalVenta();
				count=count+1;
				System.out.println("Pago:"+p.getIdPago()+" $"+p.getVenta().getTotalVenta()+"  "+p.getBanco()+"  Cliente: "+p.getCliente().getNombre()+" "+p.getCliente().getApellido() );
			}
	
	}
	System.out.println("Cantidad de Pagos: "+count+" Total de cobranza:"+sum+"\n");
	sum=0;
	count=0;
	
}



public void detalleCobranzaSuc(GregorianCalendar fecha1, GregorianCalendar fecha2) throws Exception {
	VentaABM ventaABM = new VentaABM();
	ObraSocialABM osabm=new ObraSocialABM();
	SucursalABM sucabm=new SucursalABM();
	
	List<Persona> clientes=PersonaABM.getInstance().traer();
	List<Venta> ventas=ventaABM.traerVenta();
	
	
	List<ObraSocial> obras=osabm.traerObraSocial();
	ItemVentaABM itemabm=new ItemVentaABM();
	
	List<ItemVenta>  items=itemabm.traerItemVenta();
	ProductoABM prodabm=new ProductoABM();
	List<Producto> productos=prodabm.traerProducto();
	List<Sucursal> sucursales=sucabm.traerSucursal();
 	//System.out.println("Ventas Totales entre  "+Funciones.traerFechaCorta(fecha1) +" y "+Funciones.traerFechaCorta(fecha2));
	//boolean flag=false;
	
	
	List<Pago> pagosE=PagoEfectivoABM.getInstance().traerPagosEfectivo();
	List<PagoTarjeta> pagosT=PagoTarjetaABM.getInstance().traerPagosTarjeta();
	List<PagoCheque> pagosC=PagoChequeABM.getInstance().traerPagosCheque();
	double sum=0;
	int count=0;
	boolean flag=false;
	for(Sucursal s:sucursales) {
	System.out.println("\nSucursal="+s.getIdSucursal()+" "+s.getSucursal()+"\n");	
	System.out.println("\nEfectivo=\n");
	for(Pago p:pagosE) {
		if(s.getIdSucursal()==p.getVenta().getSucursal().getIdSucursal()) {
			if(fecha1.before(p.getVenta().getFecha())&&fecha2.after(p.getVenta().getFecha())) {
				sum=sum+p.getVenta().getTotalVenta();
				count=count+1;
				System.out.println("IDpago:"+p.getIdPago()+" $"+p.getVenta().getTotalVenta()+"  Cliente: "+p.getCliente().getNombre()+" "+p.getCliente().getApellido() );
			}
		}
	}
	System.out.println(s.getSucursal()+": Cantidad de Pagos: "+count+" Total de cobranza:"+sum+"\n");
	sum=0;
	count=0;
	System.out.println("\nTarjeta=\n");
	for(PagoTarjeta p:pagosT) {
		if(s.getIdSucursal()==p.getVenta().getSucursal().getIdSucursal()) {
			if(fecha1.before(p.getVenta().getFecha())&&fecha2.after(p.getVenta().getFecha())) {
				sum=sum+p.getVenta().getTotalVenta();
				count=count+1;
				System.out.println("Pago:"+p.getIdPago()+" $"+p.getVenta().getTotalVenta()+ " Cantidad de cuotas:"
				+p.getCantCuotas()+"  Cliente: "+p.getCliente().getNombre()+" "+p.getCliente().getApellido() );
			}
		}
	}
	System.out.println(s.getSucursal()+": Cantidad de Pagos: "+count+" Total de cobranza:"+sum+"\n");
	sum=0;
	count=0;
	System.out.println("\nCheque=\n");
	for(PagoCheque p:pagosC) {
		if(s.getIdSucursal()==p.getVenta().getSucursal().getIdSucursal()) {
			if(fecha1.before(p.getVenta().getFecha())&&fecha2.after(p.getVenta().getFecha())) {
				sum=sum+p.getVenta().getTotalVenta();
				count=count+1;
				System.out.println("Pago:"+p.getIdPago()+" $"+p.getVenta().getTotalVenta()+"  "+p.getBanco()+"  Cliente: "+p.getCliente().getNombre()+" "+p.getCliente().getApellido() );
			}
		}
	}
	System.out.println(s.getSucursal()+": Cantidad de Pagos: "+count+" Total de cobranza:"+sum+"\n");
	sum=0;
	count=0;
	}
}
















}
	
