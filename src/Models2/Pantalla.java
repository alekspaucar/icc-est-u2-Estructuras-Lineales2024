package Models2;

public class Pantalla {
    private int id;
    private String nombre;
    private String ruta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void Pantalla(){

    }

    public Pantalla(int id, String nombre, String ruta){
        this.id = id;
        this.nombre = nombre;
        this.ruta = ruta;
    }

    
    @Override
    public String toString() {
        return "Pantalla [ruta=" + ruta + "]";
    }
    
}