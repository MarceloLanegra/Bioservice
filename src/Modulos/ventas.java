package Modulos;
import java.util.Locale;
import java.util.Scanner;

import static Modulos.Clientes.agregarCliente;
import static Modulos.Clientes.clientes;
import static Modulos.Productos.*;
import static Modulos.PedidosCompra.agregarPedidoCompra;

public class ventas {

    public static void ventasPrincipal(){

        System.out.println("---------------------- Módulo de ventas ----------------------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese dni del cliente: ");
        String dni = sc.next();

        if (dni.length()==8){
            System.out.println("");
            System.out.println(bienvenida(dni));
            System.out.println("");

            System.out.print("Nombre del producto? ");
            String prodNombre = sc.next();
            consultarProducto(prodNombre,dni);
        }else{
            System.out.println("DNI incorrecto");
        }
    }

    public static String bienvenida(String dni){
        String bienvenida = "";
        boolean existe = false;

        for (Clientes c : clientes){
            if(dni.equals(c.getDni())){
                existe = true;
                bienvenida = "Bienvenido " +c.getNombre();
            }
        }

        if (existe == false){
            Scanner sc = new Scanner(System.in);
            System.out.println("Cliente no registrado.");
            System.out.print("Ingrese nombre y apellido del nuevo cliente: ");
            String nombre = sc.next();
            agregarCliente(nombre,dni);
        }

        return bienvenida;
    }

    public static void consultarProducto(String nombre, String dni) {
        nombre = nombre.toUpperCase(Locale.ROOT);
        boolean existe = false;

        for (Productos p : productos) {
            if (nombre.equals(p.getNombreProducto())) {
                existe = true;
                int idx = productos.indexOf(p);
                //System.out.println(idx);
                if (p.getStock() > 50) {
                    System.out.println("Producto disponible");
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Cantidad a comprar: ");
                    int cant = sc.nextInt();
                    int cantActu = p.getStock() - cant;
                    actualizarStock(nombre, cantActu);
                    agregarPedidoCompra(dni, nombre, cant);
                    if (p.getStock() <= 50) {
                        p.setEstado(estado4);
                    }
                    System.out.println("");
                    System.out.println("Pedido de compra creado.");
                    System.out.println("Enviado a almacén para su despacho.");
                    System.out.println("Gracias por su compra.");
                } else {
                    System.out.println("Producto no disponible para la venta.");
                }
            }

        }
        if (existe == false) {
            System.out.println("Producto no existe.");
        }
    }
}