package Modulos;

import java.util.Locale;
import java.util.Scanner;

import static Modulos.Clientes.clientes;
import static Modulos.Productos.*;
import static Modulos.almacen.almacenPrincipal;
import static Modulos.ventas.ventasPrincipal;

public class Principal {
    public static void main(String[] args) {
        clientes.add(new Clientes("Marcelo", "76282422"));
        clientes.add(new Clientes("John", "12345678"));

        productos.add(new Productos("JABON", 70, estado3));
        productos.add(new Productos("ABONO", 60, estado3));
        productos.add(new Productos("LAVAVAJILLA", 40, estado4));
        productos.add(new Productos("SHAMPOO", 15, estado4));
        productos.add(new Productos("ENERGIZANTES", 80, estado3));
        productos.add(new Productos("VITAMINA-C", 35, estado4));

        boolean termino = false;

        while (termino == false){
            System.out.println("");
            System.out.println("------------------------- Bienvenido -------------------------");
            System.out.println("---------------------- Ventas ||  Almacén --------------------");
            Scanner sc = new Scanner(System.in);
            System.out.print("A qué modulo desea ingresar? ");
            String modulo = sc.next();
            modulo = modulo.toUpperCase(Locale.ROOT);
            if(modulo.equals("VENTAS")){
                ventasPrincipal();
            }else if(modulo.equals("ALMACEN") || modulo.equals("ALMACÉN")){
                almacenPrincipal();
            }else{
                System.out.println("Módulo erróneo.");
            }
            System.out.println("");
            System.out.print("Desea salir del programa? ");
            String confirma = sc.next();
            if (confirma.equals("si") || confirma.equals("sí") || confirma.equals("SI") || confirma.equals("SÍ")){
                termino = true;
            }
        }
    }
}
