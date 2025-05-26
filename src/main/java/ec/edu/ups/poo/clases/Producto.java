package ec.edu.ups.poo.clases;

import java.io.Serializable;

public class Producto implements Serializable {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private ValorProducto valor;

    public Producto(String codigo, String nombre, String descripcion, double precio, ValorProducto valor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ValorProducto getValor() {
        return valor;
    }

    public void setValor(ValorProducto valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Producto( " +
                "codigo= " + codigo  +
                ", nombre= " + nombre +
                ", descripcion= " + descripcion +
                ", precio= " + precio +
                ", valor= " + valor +
                ')';
    }
}
