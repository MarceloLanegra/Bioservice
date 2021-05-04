package Modulos;
import java.util.Scanner;

//import static Modulos.Clientes.agregarCliente;
//import static Modulos.Clientes.agregarCliente;
import static Modulos.Clientes.clientes;


public class ventas {


    public static void main(String[] args) {
        clientes.add(new Clientes("Marcelo", "76282422"));
        clientes.add(new Clientes("John", "000000"));

        /*for(Clientes c : clientes) {
            System.out.println(c.getNombre() + " committed " + c.getDni());
        }*/

        System.out.println("------------------------- Bienvenido -------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese dni del cliente: ");
        String dni = sc.next();
        /*if (Validaciones.validarDni(dni) == false){
            System.out.print("Ingrese dni del cliente: ");
        }*/

        System.out.println(bienvenida(dni));
    }

    public static String bienvenida(String dni){
        String bienvenida = "";

        for (Clientes c : clientes){
            if(dni.equals(c.getDni())){
                bienvenida = "Bienvenido " +c.getNombre();
            }else {
                System.out.println("Cliente no registrado");
                /*Scanner sc = new Scanner(System.in);
                System.out.print("Ingrese nombre y apellido del nuevo cliente: ");
                String nombre = sc.next();
                agregarCliente(nombre,dni);
                bienvenida = "Hola";*/
            }
        }

        return bienvenida;
    }
}
