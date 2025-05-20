package ec.edu.ups.poo.clases;

public class ItemSolicitud {

    private double cantidad;
    private Producto producto;

    public ItemSolicitud(double cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Items( " +
                "cantidad= " + cantidad +
                ", producto= " + producto +
                ')';
    }
}
