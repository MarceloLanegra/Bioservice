package Modulos;

import java.util.LinkedList;
import java.util.List;

public class Clientes {
    private String nombre;
    private String dni;

    public Clientes(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    static List<Clientes> clientes = new LinkedList<Clientes>();

    public static void agregarCliente(String nombre, String dni){
        clientes.add(new Clientes(nombre, dni));
    }

}
