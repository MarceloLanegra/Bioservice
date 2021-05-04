package Modulos;

public class almacen {

    public static void main(String[] args) {
    	  
        String[] productos = {"JABON LIQUIDO", "ABONO", "LAVAVAJILLA NATURAL", "SHAMPOO NATURAL"};
        int[] cantidad = {70, 60, 40, 15};

        String nombreProductos;
        int mayorCantidad;

    	System.out.println("Estos son los productos que se encuentran menos del limite del Stock: ");
    	
        for (int i = 0; i < productos.length; i++) {
            if (cantidad[i] < 50) {
            	nombreProductos = productos[i];
            	mayorCantidad = cantidad[i];
            	System.out.println("Codigo de producto: " + i + ".");
            	System.out.println("Nombre del produto: " + nombreProductos + ".");
            	System.out.println("Cantidad del producto: " + mayorCantidad + ".");
            }
        }
    }

}
