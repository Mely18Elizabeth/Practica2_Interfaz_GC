package ec.edu.ups.poo.clases;

import java.util.List;

public class Empleado extends Persona {

    private Departamento departamento;

    public Empleado() {}

    public Empleado(int id, String nombre, String apellido, String correo, List<Direccion> direccion, Departamento departamento) {
        super(id, nombre, apellido, correo, direccion);
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /*@Override
    public String toString() {
        return "ID= " + getId() +
                "  Nombre= " + getNombre()  +
                "  Apellido=" + getApellido()  +
                "  correo='" + getCorreo() +
                "  Direccion=" + getDireccion() +
                "  Departamento=" + departamento;*/
    }
}
