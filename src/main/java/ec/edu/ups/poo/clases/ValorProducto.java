package ec.edu.ups.poo.clases;

public class ValorProducto   {
    private double iva;
    private double descuento;

    public ValorProducto(double iva, double descuento) {
        this.iva = iva;
        this.descuento = descuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "ValorProducto( " +
                "iva= " + iva +
                ", descuento= " + descuento +
                ')';
    }
}
