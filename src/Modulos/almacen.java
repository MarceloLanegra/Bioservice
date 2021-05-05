package Modulos;

import static Modulos.PedidosCompra.pedidosCompras;
import static Modulos.Productos.productos;

public class almacen {

    public static void almacenPrincipal() {
        System.out.println("--------------------- Módulo de almacén ----------------------");
        System.out.println("Visualizar y atender Pedidos de compra");
        //verAtenderPC();
        System.out.println("Visualizar productos y su stock");
    }

    public static void verAtenderPC(){
        String estado = "";
        for (PedidosCompra pc : pedidosCompras){
            System.out.println("ID PC "+pc.getIdPedido()+" || DNI "+pc.getDniCli()+"   Nombre cliente: "+pc.getNomCli()+" || Producto: "+pc.getProd()+"   Cant: "+ pc.getCant()+" || Estado: "+pc.getEstado());
        }
    }
}
