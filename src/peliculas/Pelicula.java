package src.peliculas;

public class Pelicula {
    
    //Atributos

    private int id;
    private String nombre;
    private int anio;
    private String categoria;

    //Constructores

    public Pelicula(int id, String nombre, int anio, String categoria){
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
        this.categoria = categoria;
    }

    public Pelicula(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    //Getter y Setter
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnio() {
        return anio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getInformacion(){
        String resultado = "Id: " + id + " Nombre: " + nombre + " Año: " + anio + " Categoria: " + categoria;
        return resultado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    //Fin Getter y Setter

}
