package ec.edu.ups.poo.clases;

import java.util.List;

public class Proveedor extends Persona {

    public Proveedor(int id, String nombre, String apellido, String correo, List<Direccion> direccion) {
        super(id, nombre, apellido, correo, direccion);
    }

    @Override
    public String toString() {
        return "Proveedor( " +
                "ID=" + getId() +
                ", Nombre='" + getNombre() + '\'' +
                ", Apellido='" + getApellido() + '\'' +
                ", Email='" + getCorreo() + '\'' +
                ", Direccion=" + getDireccion() +
                '}';
    }
}
