import java.util.Scanner;

public class Tarea2 {

    //Se hace uso de recursion aqui proponiendo un caso base en primer lugar para evitar una recursion infinita
    static int fibonacci(int n){
        if(n == 1){
            return 0;
        }
        else if(n == 2){
            return 1;
        }
    // aplicamos la recursion con la formula de fibonacci f(n) = fn-1 + fn-2
        return fibonacci(n-1) + fibonacci(n-2);
        }

    //esta es una prueba que hice pero me salio de forma no recursiva
     static boolean esPalindromoNoRecursivo(String palabra){

        StringBuilder xd = new StringBuilder(palabra);
        if(palabra.equals(xd.reverse().toString())){
            return true;
        }
        else
            return false;


     }

     static boolean esPalindromoRecursivo(String palabra) {
         //Estuve practicando y me salio de forma no recursiva, a continuacion lo intentaré de hacer de forma recursiva D:


         // La manera de hacer que se ignoren espacios y signos de puntuacion reemplazando el string con el artificio [^a-z0-9]
         // esto nos dara la palabra sin lo ya comentado, ejm: hola como estas ---->  holacomoestas ESTO FACILITARÁ LAS COMPARACIONES Y VALIDACIONES.
         String palabraModificada = palabra.toLowerCase().replace("[^a-z0-9]", "");
         if (palabra.length() <= 1) {
             return true;
         }
         if (palabra.charAt(0) != palabra.charAt(palabra.length()-1) ) { // SE HICIERON DOS CASOS BASES, EN CASO DE QUE EL USUARIO INGRESE 1 Y 0 LETRAS, AUTOMATICAMENTE SERÁ UN PALINDROMO

             return false;
         }
         return esPalindromoRecursivo(palabra.substring(1,palabra.length()-1)); // LUEGO SE HIZO DE FORMA RECURSIVA LAS COMPARACIONES DEL STRING PARA QUE SE COMPARE CADA CARACTER DE ATRAS PARA ADELANTE

     }








    public static void main(String[] args) {

        // EJERCICIO 1: FIBONACCI RECURSIVO

        System.out.println("\nEJERCICIO 1: FIBONACCI RECURSIVO");

        System.out.println("El termino 10 de la sucesion de fibonacci es : "+fibonacci(10)+"\n");

        // EJERCICIO 1: Determinar si una Cadena es Palindromo

        System.out.println("EJERCICIO 2: Determinar si una Cadena es Palindromo:\n");

    // HACEMOS USO DEL SCANNER PARA QUE EL USUARIO SEA EL QUE DECIDA QUE PALABRA VERIFICAR SI ES PALINDROMO
            Scanner scanner = new Scanner(System.in);
            String palabra = scanner.nextLine();
        System.out.println("La palabra "+palabra+" ¿Es palindromo?: "+esPalindromoNoRecursivo(palabra));

        System.out.println("La palabra "+palabra+" ¿Es palindromo?: "+esPalindromoRecursivo(palabra));
    }
}
