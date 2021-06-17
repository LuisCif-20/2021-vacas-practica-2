package src.peliculas;

import java.util.*;

import src.tienda.IngresoDatos;

public class VectorPelicula {

    // Atributos
    private int limite = 50;
    private Pelicula[] peliculas = new Pelicula[limite];
    private int banderasiguiente;

    // Constructor

    public VectorPelicula() {
        banderasiguiente = 1;
    }

    // Metodos

    public void agregarPelicula(String nombre, int anio, String categoria) {
        if (banderasiguiente > limite) {
            System.out.println("Ya no hay más espacio para agregar Peliculas");
        } else {
            peliculas[(banderasiguiente - 1)] = new Pelicula(banderasiguiente, nombre, anio, categoria);
        }
        banderasiguiente++;
    }

    public void agregarPelicula() {
        String nombre = IngresoDatos.getTexto("Ingresa el nombre de la Pelicula");
        int anio = IngresoDatos.getEntero("Ingresa el año en el que se estreno la pelicula", false);
        String categoria = IngresoDatos.getTexto("Ingresa el tipo de categoria a la que pertenece la Pelicula");
        agregarPelicula(nombre, anio, categoria);

    }

    public void mostrarPeliculas() {
        System.out.println("Peliculas de Memorabilia");
        for (int i = 0; i < (banderasiguiente - 1); i++) {
            System.out.println(peliculas[i].getInformacion());
        }
    }

    public void ordenarPorNombre() {
        Pelicula seleccion;
        int posicion;
        for (int i = 0; i < (banderasiguiente - 1); i++) {
            seleccion = peliculas[i];
            posicion = i;
            for (int j = i + 1; j < (banderasiguiente - 1); j++) {
                if (seleccion.getNombre().compareTo(peliculas[j].getNombre()) > 0) {
                    seleccion = peliculas[j];
                    posicion = j;
                }
            }
            peliculas[posicion] = peliculas[i];
            peliculas[i] = seleccion;
        }
    }

    public void ordenarId() {
        int seleccion;
        int posicion;
        for (int i = 0; i < (banderasiguiente - 1); i++) {
            seleccion = peliculas[i].getId();
            posicion = i;
            for (int j = i + 1; j < (banderasiguiente - 1); j++) {
                if (peliculas[j].getId() <= seleccion) {
                    seleccion = peliculas[j].getId();
                    posicion = j;
                }
            }
            peliculas[posicion].setId(peliculas[i].getId());
            peliculas[i].setId(seleccion);
        }
    }

    public void modificarInformacion() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nQue caracteristica de la pelicula deseas modificar");
        System.out.println("1) Cambiar Nombre");
        System.out.println("2) Cambiar Año");
        System.out.println("4) Cambiar Categoria");
        int opcion = Integer.parseInt(scan.nextLine());
        if (opcion == 1) {
            int id = buscarId();
            if (id != 0) {
                peliculas[id].setNombre(IngresoDatos.getTexto("Ingrese el nuevo nombre de la Pelicula"));
            } else {
                System.out.println("La pelicula no existe");
            }
        } else if (opcion == 2) {
            int id = buscarId();
            if (id != 0) {
                peliculas[id].setAnio(IngresoDatos.getEntero("Ingrese el nuevo año de la pelicula", true));
            } else {
                System.out.println("La pelicula no existe");
            }
        } else {
            int id = buscarId();
            if (id != 0) {
                peliculas[id].setCategoria(IngresoDatos.getTexto("Ingrese la nueva categoria de la Pelicula"));
            } else {
                System.out.println("La pelicula no existe");
            }
        }
    }

    public int buscarId() {
        int id = IngresoDatos.getEntero("Ingrese el Id de la pelicula", true);
        for (int i = 0; i < banderasiguiente - 1; i++) {
            if (id == peliculas[i].getId()) {
                return i;
            }
        }

        return 0;
    }

    public void eliminarPelicula(){
        int espacio = buscarId();
        if (espacio != 0) {
            for (int i = espacio; i < banderasiguiente-2; i++) {
                peliculas[i] = peliculas[i+1];
            }
            banderasiguiente--;
        } else {
            System.out.println("La pelicula no exite");
        }
    }

    public int getBanderasiguiente() {
        return banderasiguiente;
    }

}