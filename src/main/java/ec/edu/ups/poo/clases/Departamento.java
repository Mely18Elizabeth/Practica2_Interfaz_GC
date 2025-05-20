package ec.edu.ups.poo.clases;

import ec.edu.ups.poo.Enums.Rol;

public class Departamento {
    private Rol rol;

    public Departamento(Rol rol) {
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "rol=" + rol +
                '}';
    }
}
