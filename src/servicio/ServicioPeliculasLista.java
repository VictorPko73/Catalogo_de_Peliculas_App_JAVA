package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas {

    private final List<Pelicula> peliculas;

    public ServicioPeliculasLista(){
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado de Peliculas...");
        peliculas.forEach(System.out::println);

    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: " + pelicula);

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        // Nos muestra el indice de la pelicula encontrada en la lista
        var indice = peliculas.indexOf(pelicula);
        if (indice == -1){
            System.out.println("No se encotro la película" + pelicula);
        }else
            System.out.println("Pelicula encontrada en el indice: "  + indice);
    }

    public static void main(String[] args) {
        //Creamos objetos de tipo pelicula
        var pelicula1 = new Pelicula("Batman");
        var pelicula2 = new Pelicula("Iron Man");

        //Creamos el servicio (patron de disño service)
        IServicioPeliculas iservicioPeliculas = new ServicioPeliculasLista();

        //Agregamos las peliculas a la lista
        iservicioPeliculas.agregarPelicula(pelicula1);
        iservicioPeliculas.agregarPelicula(pelicula2);

        //Listamos peliculas
        iservicioPeliculas.listarPeliculas();

        //Buscamos una pelicula
        //Se debe implementar el metodo equals y hashCode
        iservicioPeliculas.buscarPelicula(pelicula1);
        iservicioPeliculas.buscarPelicula(new Pelicula("Rambo"));
        iservicioPeliculas.buscarPelicula(new Pelicula("Iron Man"));
    }
}
