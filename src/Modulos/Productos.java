package Modulos;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Productos {
    private String nombreProducto;
    private int stock;
    private String estado;

    public Productos(String nombreProducto, int stock, String estado) {
        this.nombreProducto = nombreProducto;
        this.stock = stock;
        this.estado = estado;
    }

    static String estado3 = "Disponible";
    static String estado4 = "No disponible";

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getStock() {
        return stock;
    }

    public String getEstado() { return estado; }

    public void setStock(int stockActu){
        this.stock = stockActu;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    static List<Productos> productos = new LinkedList<Productos>();

    public static void actualizarStock(String nombre, int stockActu){
        for (Productos p: productos){
            if (p.getNombreProducto().equals(nombre)){
                p.setStock(stockActu);
            }
        }
    }

    public static void agregarProducto(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese nombre del nuevo producto: ");
        String nuevoProd = sc.next();
        nuevoProd = nuevoProd.toUpperCase(Locale.ROOT);
        System.out.print("Ingrese stock: ");
        int nuevoStock = sc.nextInt();

        if (nuevoStock > 50){
            productos.add(new Productos(nuevoProd, nuevoStock, estado3));
            System.out.println("Producto ingresado");
            System.out.println();
            System.out.println(nuevoProd+" Stock: "+nuevoStock+" Estado: "+estado3);
        }else {
            productos.add(new Productos(nuevoProd, nuevoStock, estado4));
            System.out.println("Producto ingresado");
            System.out.println();
            System.out.println(nuevoProd+" Stock: "+nuevoStock+" Estado: "+estado4);
        }

    }

}
