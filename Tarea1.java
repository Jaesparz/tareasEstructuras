import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//EJERCICIO 1
//Se hizo la clase generica caja de acuerdo a lo especificado en la tarea con su set y get

class Caja<T>{
 T objeto;

    public T getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }

    public void mostrarTipo() {
        String tipo = objeto.getClass().getName();
        System.out.println("El tipo de dato es: " + tipo);

    }
}
//Custom Class para probar la clase generica con este tipo de objeto
class Carro{

    String nombre;
    int anio;

    public Carro(String nombre, int anio){
        this.nombre = nombre;
        this.anio = anio;
    }

}

//EJERCICIO 2

class ListaPersonalizada<T>{

    //Hago uso de un ArrayList para que se me haga comoda la manera de agregar/eliminar/buscar elementos en una lista
    List<T> listaCosas = new ArrayList<>();

    public void agregar(T elemento){
        listaCosas.add(elemento); //add agrega el elemento a la lista
    }
    public void eliminar (T elemento){
        listaCosas.remove(elemento);// remove elimina el elemento especificado de la lista
    }
    public void buscar (T elemento){
        if(listaCosas.contains(elemento)){  //Contains verifica que un elemento esta en la lista
            System.out.println("El elemento esta en la lista :D");
        }
        else
            System.out.println("Elemento no en lista");
    }
    public void tamanio(){
        System.out.println("La lista tiene: "+listaCosas.size()+ " elementos");
    }
}

//EJERCICIO 3
class gestorDeListas{

    static <T> void agregarElementoALista(List<T> lista, T elemento){  // SE USA METODOS STATICS GENERICOS PARA HACER USO DE UN PARAMETRO LISTA PARA AGREGAR/REMOVER/IMPRIMIR LA COLECCION
        lista.add(elemento);
    }
    static <T> void removerElementoDeLista(List<T> lista, T elemento){
        lista.remove(elemento);
    }
    static <T> void imprimirLista(List<T> lista){ //ESTO NOS DEJARA USAR LOS METODOS SIN NECESIDAD DE INSTANCIAR UN OBJETO
        for (T t : lista){
            System.out.println(t);
        }
    }

}

//EJERCICIO 4

// SE HIZO USO DE UNA CLASE ABSTRACTA QUE LA VAMOS A USAR COMO PADRE PARA IMPLEMETAR 2 CLASES HIJAS, IMPLEMENTAREMOS SUS METODOS
abstract class Vehiculo<T>{

    T propiedad;

    public Vehiculo(T propiedad){
        this.propiedad = propiedad;
    }

    abstract void encender();

    void mostrarDatos(){
        System.out.println("Datos: " + propiedad);
    }
}

// AQUI VIENEN LOS HIJOS
class Carrito<T> extends Vehiculo{

    public Carrito(T propiedad) {
        super(propiedad);
    }

    @Override
    void encender() {
        System.out.println("El carro esta encendido");
    }

    void mostrarDatos(){
        System.out.println("Datos del carrito: "+propiedad);
    }
}
class Moto<T> extends Vehiculo{

    public Moto(T propiedad){
        super(propiedad);


    }

    void encender(){
        System.out.println("La moto esta encendida");
    }

    void mostrarDatos(){
        System.out.println("Datos de la moto: "+propiedad);
    }


}

//EJERCICIO 5
class Utilidad{

    // HACEMOS USO DEL COMODO ? EXTENDS NUMBER PARA QUE SE PUEDA RECIBIR CUALQUIER TIPO DE DATOS NUMERICOS PARA HACER UN METODO QUE SUMA
    static void sumarElementos(List<? extends Number> lista){
        double suma = 0;
        for(Number numer : lista){
            suma += numer.doubleValue();
        }
        System.out.println("El resultado de la suma es: "+suma);
    }

}

//EJERCICIO 6

//HACEMOS USO DE UNA CLASE GENERICA CON 3 TIPOS
class GenericTriple<S,U,V>{
    S tipo1;
    U tipo2;
    V tipo3;

    public GenericTriple(S tipo1,U tipo2,V tipo3){
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.tipo3 = tipo3;
    }

    //PONEMOS SUS GETTERS

    public S getTipo1(){
        return tipo1;
    }
    public U getTipo2(){
        return tipo2;
    }

    public V getTipo3(){
        return tipo3;
    }

}


// ESTE ES EL MAIN

// AQUI SE HARÁN LAS PRUEBAS DE CADA UNO DE LOS EJERCICIOS

public class Tarea1 {

    public static void main(String[]args){


        //EJERCICIO 1
        System.out.println("\n EJERCICIO 1 \n");

        //INSTANCIAMOS LAS "CAJAS"

        Caja<String> cajaString = new Caja<>();
        Caja<Integer> cajaInteger = new Caja<>();
        Caja<Carro> cajaCarros = new Caja<>();

        //PROBAMOS LOS METODOS

        cajaString.setObjeto("Hola");
        cajaInteger.setObjeto(2);
        cajaCarros.setObjeto(new Carro("Mazda",2010));

        cajaString.mostrarTipo();
        cajaInteger.mostrarTipo();
        cajaCarros.mostrarTipo();


        //EJERCICIO 2
        System.out.println("\n EJERCICIO 2 \n");

        //INSTANCIAMOS NUESTRAS LISTAS GENERICAS

        ListaPersonalizada<String> listaString = new ListaPersonalizada<>();
        ListaPersonalizada<Integer> listaInteger = new ListaPersonalizada<>();

        //PROBAMOS
        listaString.agregar("Hola");
        listaInteger.agregar(2);
        listaString.agregar("Mundo");
        listaInteger.agregar(3);
        listaString.eliminar("Mundo");
        listaInteger.eliminar(3);
        listaString.buscar("Hola");
        listaInteger.buscar(3);
        listaString.tamanio();
        listaInteger.tamanio();

        //EJERCICIO 3
        System.out.println("\n EJERCICIO 3 \n");

        //INSTANCIAMOS NUESTRAS COLECCIONES

        List<String> listaString2 = new ArrayList<>();
        List<Integer> listaInteger2 = new ArrayList<>();

        //LLAMAMOS A LOS METODOS DE GESTORDELISTAS SIN NECESIDAD DE INSTACIAR YA QUE SON STATICS

        gestorDeListas.agregarElementoALista(listaString2,"ola");
        gestorDeListas.agregarElementoALista(listaString2,"mundo");
        gestorDeListas.removerElementoDeLista(listaString2,"ola");
        gestorDeListas.agregarElementoALista(listaInteger2,1);
        gestorDeListas.imprimirLista(listaString2);
        gestorDeListas.imprimirLista(listaInteger2);

        //EJERCICIO 4
        System.out.println("\n EJERCICIO 4 \n");

        //INSTANCIAMOS NUESTRAS CLASES GENERICAS
        Carrito<String> carrito = new Carrito<>("Mazda");
        Moto<String> moto = new Moto<>("Honda");

        //PROBAMOS

        carrito.encender();
        moto.encender();
        carrito.mostrarDatos();
        moto.mostrarDatos();

        //EJERCICIO 5
        System.out.println("\n EJERCICIO 5 \n");


        //INICIALIZAMOS NUESTRAS LISTAS DE PRUEBA
        List<Integer> listaEnteros = Arrays.asList(1,2,5,10);
        List<Double> listaDouble = Arrays.asList(2.0,2.5,6.5,7.5);
        //PROBAMOS QUE FUNCIONE LA SUMA DE ELEMENTOS
        Utilidad.sumarElementos(listaEnteros);
        Utilidad.sumarElementos(listaDouble);

        //EJERCICIO 6
        System.out.println("\n EJERCICIO 6 \n");

        //INICIALIZAMOS NUESTRA CLASE DE TRIPLE TIPO
        GenericTriple<String,Integer,Double> listaTest = new GenericTriple<>("Hola",2,2.8);

        //CHECAMOS QUE FUNCIONE TODO BIEN

        System.out.println("S: "+listaTest.getTipo1());
        System.out.println("U: "+listaTest.getTipo2());
        System.out.println("V: "+listaTest.getTipo3());

        //Si
        System.out.println("\nLo quiero mucho profe");

    }
}
