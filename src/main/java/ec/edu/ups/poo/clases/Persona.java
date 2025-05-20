package ec.edu.ups.poo.clases;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private List<Direccion> direccion;

    public Persona(){
        direccion = new ArrayList<>();
    }

    public Persona(int id, String nombre, String apellido, String correo, List<Direccion> direccion){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Direccion> getDireccion() {
        return direccion;
    }

    public void setDireccion(List<Direccion> direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "id= " + id +
                "  nombre= " + nombre +
                "  apellido= " + apellido +
                "  correo= " + correo  +
                "  direccion= " + direccion;
    }
}
