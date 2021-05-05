package Modulos;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static Modulos.Clientes.clientes;

public class PedidosCompra {
    private static final AtomicInteger cont = new AtomicInteger(0);
    private int idPedido;
    private String dniCli;
    private String nomCli;
    private String prod;
    private int cant;
    private String estado;

    public PedidosCompra(AtomicInteger cont, String dniCli, String nomCli, String prod, int cant, String estado){
        //this.idPedido = idPedido;
        this.idPedido = cont.incrementAndGet();
        this.dniCli = dniCli;
        this.nomCli = nomCli;
        this.prod = prod;
        this.cant = cant;
        this.estado = estado;
    }

    public int getIdPedido(){
        return idPedido;
    }

    public String getDniCli(){
        return dniCli;
    }

    public String getNomCli(){
        return nomCli;
    }

    public String getProd(){
        return prod;
    }

    public int getCant() {
        return cant;
    }

    public String getEstado(){
        return estado;
    }

    static List<PedidosCompra> pedidosCompras = new LinkedList<>();

    public static void agregarPedidoCompra(String dniCli, String prod, int cant, String estado){

        String nomCli = "";
        for (Clientes c : clientes){
            if(dniCli.equals(c.getDni())){
                nomCli = c.getNombre();
            }
        }

        pedidosCompras.add(new PedidosCompra(cont,dniCli, nomCli, prod, cant, estado));
    }

}