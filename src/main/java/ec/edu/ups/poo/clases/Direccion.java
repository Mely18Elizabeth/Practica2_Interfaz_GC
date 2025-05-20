package ec.edu.ups.poo.clases;

public class Direccion {
    private String callePrincipal;
    private String calleSecundario;
    private String ciudad;

    public Direccion(String callePrincipal, String calleSecundario, String ciudad) {
        this.callePrincipal = callePrincipal;
        this.calleSecundario = calleSecundario;
        this.ciudad = ciudad;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getCalleSecundario() {
        return calleSecundario;
    }

    public void setCalleSecundario(String calleSecundario) {
        this.calleSecundario = calleSecundario;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCuenca(String cuenca) {
        ciudad = cuenca;
    }

    @Override
    public String toString() {
        return "callePrincipal= " + callePrincipal +
                "  calleSecundario= " + calleSecundario  +
                "  Cuenca= " + ciudad;
    }
}
