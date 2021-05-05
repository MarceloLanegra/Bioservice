package Modulos;

import java.util.Scanner;

import static Modulos.Clientes.clientes;
import static Modulos.Productos.productos;
import static Modulos.almacen.almacenPrincipal;
import static Modulos.ventas.ventasPrincipal;

public class Principal {
    public static void main(String[] args) {
        clientes.add(new Clientes("Marcelo", "76282422"));
        clientes.add(new Clientes("John", "12345678"));

        productos.add(new Productos("JABON", 70, "Disponible"));
        productos.add(new Productos("ABONO", 60, "Disponible"));
        productos.add(new Productos("LAVAVAJILLA", 40, "No disponible"));
        productos.add(new Productos("SHAMPOO", 15, "No disponible"));
        productos.add(new Productos("ENERGIZANTES", 80, "Disponible"));
        productos.add(new Productos("VITAMINA-C", 35, "No disponible"));

        boolean termino = false;

        while (termino == false){
            System.out.println("");
            System.out.println("------------------------- Bienvenido -------------------------");
            Scanner sc = new Scanner(System.in);
            System.out.print("A qué modulo desea ingresar? ");
            String modulo = sc.next();
            if(modulo.equals("ventas")){
                ventasPrincipal();
            }else {
                almacenPrincipal();
            }

            System.out.print("Desea salir del programa? ");
            String confirma = sc.next();
            if (confirma.equals("si")){
                termino = true;
            }
        }

    }
}
