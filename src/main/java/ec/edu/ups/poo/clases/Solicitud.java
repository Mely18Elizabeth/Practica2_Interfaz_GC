package ec.edu.ups.poo.clases;
import ec.edu.ups.poo.Enums.*;
import java.util.GregorianCalendar;
import java.util.List;

public class Solicitud {
    private String numero;
    private GregorianCalendar fechaInicio;
    private Estado estado;
    private List<ItemSolicitud> items;

    public Solicitud(String numero, GregorianCalendar fechaInicio, Estado estado) {}

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public GregorianCalendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(GregorianCalendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<ItemSolicitud> getItems() {
        return items;
    }

    public void setItems(List<ItemSolicitud> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "numero='" + numero + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", estado=" + estado +
                ", items=" + items +
                '}';
    }
}
