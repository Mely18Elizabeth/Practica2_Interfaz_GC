package ec.edu.ups.poo.clases;
import ec.edu.ups.poo.Enums.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Solicitud {
    private String numero;
    private GregorianCalendar fechaInicio;
    private Estado estado;
    private List<ItemSolicitud> items;

    public Solicitud(String numero, GregorianCalendar fechaInicio, Estado estado) {
        this.numero = numero;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
        this.items = new ArrayList<>(); // Inicializa lista
    }

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
        // Formatear la fecha legible
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        String fechaStr = (fechaInicio != null) ? sdf.format(fechaInicio.getTime()) : "Sin fecha";

        // Construir string de items separados por comas
        StringBuilder itemsStr = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            itemsStr.append(items.get(i).toString());
            if (i < items.size() - 1) {
                itemsStr.append(", ");
            }
        }

        return "Solicitud[numero=" + numero +
                ", fechaInicio=" + fechaStr +
                ", estado=" + estado +
                ", items=[" + itemsStr.toString() + "]]";
    }

}
