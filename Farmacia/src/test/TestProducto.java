package test;

import datos.Producto;
import negocio.ProductoABM;

public class TestProducto {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		ProductoABM abm=new ProductoABM();
		
		Producto prod=new Producto("amoxilina", "farmacia", 20, "Vanier");
		Producto prod1=new Producto( "paracetamol", "farmacia", 30, "Vanier");
		Producto prod2=new Producto("metformina", "farmacia", 30, "Vanier");
		Producto prod3=new Producto("crema hidratante", "perfumeria", 40, "Vanier");
		Producto prod4=new Producto( "crema diclofenac", "farmacia", 60, "Vanier");
		Producto prod5=new Producto( "aspirina", "farmacia", 10, "Vanier");
		Producto prod6=new Producto( "perfume Paco", "Perfumeria", 10, "Vanier");
		abm.agregar(prod);
		abm.agregar(prod1);
		abm.agregar(prod2);
		abm.agregar(prod3);
		abm.agregar(prod4);
		abm.agregar(prod5);
		abm.agregar(prod6);
		System.out.println(abm.traerProducto(1));
		System.out.println(abm.traerProducto(2));
		System.out.println(abm.traerProducto(3));
		System.out.println(abm.traerProducto(4));
		System.out.println(abm.traerProducto(5));
		System.out.println(abm.traerProducto(6));
		System.out.println(abm.traerProducto(7));
		
		
	}

}