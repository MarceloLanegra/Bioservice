package Modulos;

public class Validaciones {
    public static boolean validarDni(String dni){
        boolean valido = true;

        if (dni.length() > 8){
            valido = false;
        }
        return valido;
    }
}
