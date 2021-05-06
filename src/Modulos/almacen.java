package Modulos;

import java.util.Locale;
import java.util.Scanner;

import static Modulos.PedidosCompra.*;
import static Modulos.Productos.*;

public class almacen {

    public static void almacenPrincipal() {
        System.out.println("--------------------- Módulo de almacén ----------------------");
        System.out.println("Visualizar y atender Pedidos de compra      (1)");
        System.out.println("Visualizar productos y su stock             (2)");
        System.out.println("Agregar nuevo producto                      (3)");

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese opción: ");
        int opcion = sc.nextInt();
        System.out.println("");
        if (opcion == 1){
            verAtenderPC();
        }else if(opcion == 2){
            verProductosStock();
        }else if(opcion==3){
            agregarProducto();
        }else {
            System.out.println("Opción incorrecta.");
        }

    }

    public static void verAtenderPC(){
        for (PedidosCompra pc : pedidosCompras){
            System.out.println("ID-PC "+pc.getIdPedido()+" || DNI "+pc.getDniCli()+"   Nombre cliente: "+pc.getNomCli()+" || Producto: "+pc.getProd()+"   Cant: "+ pc.getCant()+" || Estado: "+pc.getEstado());
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.print("Ingrese el número de pedido de compra a atender: ");
        int idPC = sc.nextInt();

        for (PedidosCompra pc: pedidosCompras){
            if (pc.getIdPedido()==idPC && pc.getEstado() == estado1){
                pc.setEstado(estado2);
                System.out.println("Pedido de compra número "+idPC+" atendido.");
            }else if (pc.getIdPedido()==idPC && pc.getEstado() == estado2){
                System.out.println("Pedido de compra número "+idPC+" ya fue atendido");
            }
        }
    }

    public static void verProductosStock(){
        for (Productos pr : productos){
            System.out.println(pr.getNombreProducto()+" Stock: "+pr.getStock()+" Estado: "+pr.getEstado());
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.print("Producto a actualizar stock? ");
        String prod = sc.next();
        prod = prod.toUpperCase(Locale.ROOT);
        for (Productos pr : productos){
            if (prod.equals(pr.getNombreProducto())){
                System.out.print("Stock a ingresar: ");
                int stock  = sc.nextInt();
                int nuevoStock  = pr.getStock() + stock;
                actualizarStock(prod,nuevoStock);
                System.out.println("Stock actualizado");
                if (pr.getStock() > 50){
                    pr.setEstado(estado3);
                }

                System.out.println("");
                System.out.println(pr.getNombreProducto()+" Nuevo stock: "+pr.getStock()+" Estado: "+pr.getEstado());
            }
        }
    }

}

