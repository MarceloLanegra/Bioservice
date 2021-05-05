package Modulos;
import java.util.Locale;
import java.util.Scanner;

import static Modulos.Clientes.agregarCliente;
import static Modulos.Clientes.clientes;
import static Modulos.PedidosCompra.pedidosCompras;
import static Modulos.Productos.*;
import static Modulos.PedidosCompra.agregarPedidoCompra;

public class ventas {


    //public static void main(String[] args) {
    public static void ventasPrincipal(){


        //boolean termino = false;

        /*while (termino == false){
            System.out.println("");
            System.out.println("------------------------- Bienvenido -------------------------");
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese dni del cliente: ");
            String dni = sc.next();

            System.out.println("");
            System.out.println(bienvenida(dni));
            System.out.println("");

            System.out.print("Nombre del producto? ");
            String prodNombre = sc.next();
            consultarProducto(prodNombre,dni);

            System.out.print("Desea salir del programa? ");
            String confirma = sc.next();
            if (confirma.equals("si")){
                termino = true;
            }
        }*/

        System.out.println("---------------------- Módulo de ventas ----------------------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese dni del cliente: ");
        String dni = sc.next();

        System.out.println("");
        System.out.println(bienvenida(dni));
        System.out.println("");

        System.out.print("Nombre del producto? ");
        String prodNombre = sc.next();
        consultarProducto(prodNombre,dni);


        /*for (Clientes d : clientes){
            System.out.println(d.getNombre()+" "+d.getDni());
        }*/
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
            System.out.print("Ingrese nombre y apellido del nuevo cliente: ");
            String nombre = sc.next();
            agregarCliente(nombre,dni);
        }

        return bienvenida;
    }

    public static void consultarProducto(String nombre, String dni){
        nombre = nombre.toUpperCase(Locale.ROOT);

        for (Productos p : productos){
            if(nombre.equals(p.getNombreProducto())){
                int idx = productos.indexOf(p);
                //System.out.println(idx);
                if (p.getStock()>50) {
                    System.out.println("Producto disponible");
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Cantidad a comprar: ");
                    int cant = sc.nextInt();
                    int cantActu = p.getStock() - cant;
                    actualizarStock(nombre,cantActu);
                    agregarPedidoCompra(dni,nombre, cant,"Por despachar");
                    System.out.println("");
                    System.out.println("Pedido de compra creado.");
                    System.out.println("Enviado a almacén para su despacho.");
                    System.out.println("Gracias por su compra.");
                }
            }
        }

        /*for (PedidosCompra pc : pedidosCompras){
            System.out.println("ID PC "+pc.getIdPedido()+" || DNI "+pc.getDniCli()+"   Nombre cliente: "+pc.getNomCli()+" || Producto: "+pc.getProd()+"   Cant: "+ pc.getCant()+" || Estado: "+pc.getEstado());
        }*/

        /*for (Productos pr : productos){
            System.out.println(pr.getNombreProducto()+" "+pr.getStock()+" "+pr.getEstado());
        }*/
    }
}
