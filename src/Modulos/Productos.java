package Modulos;

import java.util.LinkedList;
import java.util.List;

public class Productos {
    private String nombreProducto;
    private int stock;
    private String estado;

    public Productos(String nombreProducto, int stock, String estado) {
        this.nombreProducto = nombreProducto;
        this.stock = stock;
        this.estado = estado;
    }

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

    static List<Productos> productos = new LinkedList<Productos>();

    public static void actualizarStock(String nombre, int stockActu){
        for (Productos p: productos){
            if (p.getNombreProducto().equals(nombre)){
                p.setStock(stockActu);
            }
        }
    }
}
