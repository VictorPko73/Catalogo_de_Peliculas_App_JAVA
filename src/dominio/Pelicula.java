package dominio;

import java.util.Objects;

public class Pelicula {
    private String nombre;
    // Agregamos un constructor vacio para poder agragar peliculas sin necesidad de que reciba ningun argumento

    public Pelicula(){}

    // Contructor que recibe el nombre de la pelicula
    public Pelicula(String nombre){
        this.nombre= nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Agregamos los metodo to String y hashcode


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(nombre, pelicula.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    @Override
    public String toString() {
        return  this.nombre;
    }

    public static void main(String[] args) {
        var pelicula1 = new Pelicula("Batman");
        var pelicula2 = new Pelicula("Superman");
        System.out.println(pelicula1);
        System.out.println(pelicula2);
    }
}
