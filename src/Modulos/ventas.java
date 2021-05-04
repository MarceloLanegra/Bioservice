package Modulos;
import java.util.Scanner;

import static Modulos.Clientes.agregarCliente;
import static Modulos.Clientes.clientes;


public class ventas {


    public static void main(String[] args) {
        clientes.add(new Clientes("Marcelo", "76282422"));
        clientes.add(new Clientes("John", "000000"));

        /*for(Clientes c : clientes) {
            System.out.println(c.getNombre() + " committed " + c.getDni());
        }*/
        boolean termino = false;

        while (termino == false){
            System.out.println("------------------------- Bienvenido -------------------------");
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese dni del cliente: ");
            String dni = sc.next();

            System.out.println(bienvenida(dni));

            System.out.print("Nombre del producto? ");
            String prodNombre = sc.next();
            System.out.println(consultarProducto(prodNombre););

            System.out.print("Desea salir del programa? ");
            String confirma = sc.next();
            if (confirma.equals("si")){
                termino = true;
            }
        }

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

    public static void consultarProducto(String nombre){

    }
}
