package presentacion;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasLista;
import servicio.ServiciosPeliculasArchivo;

import java.util.Scanner;

public class CatalogoPeliculasApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        //Agregamos la implementacion del servicio
        //IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        IServicioPeliculas servicioPeliculas = new ServiciosPeliculasArchivo();
        while (!salir){
            try {
                mostrarMenu();

               salir = ejecutarOpciones(consola, servicioPeliculas);

            } catch (Exception e) {
                System.out.println("Ocurrio un error");
            }
            System.out.println();
        }// fin del while

    }
    private static void mostrarMenu (){
        System.out.print("""
                 *** Catalogo de Peliculas ***
                 1. Agregar pelicula
                 2. Listar Peliculas
                 3. Buscar Peliculas
                 4. Salir
                 Introduce una de las opciones: 
                 """);

    }

    private static boolean ejecutarOpciones (Scanner consola, IServicioPeliculas iservicioPeliculas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 -> {
                System.out.println("Introduce el nombre de la pelicula: ");
                var nombrePelicula = consola.nextLine();
                iservicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));
            }
            case 2 -> {
                iservicioPeliculas.listarPeliculas();
            }
            case 3 -> {
                System.out.println("Introduce la pelicula a buscar: ");
                var buscar = consola.nextLine();
                iservicioPeliculas.buscarPelicula(new Pelicula(buscar));
            }
            case 4 -> {
                System.out.println("Hasta pronto");
                salir = true;
            }
            default -> System.out.println("Opcion no válida");
        }
        return salir;
    }
}
