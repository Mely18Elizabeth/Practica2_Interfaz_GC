package ec.edu.ups.poo.registros;

import ec.edu.ups.poo.clases.Producto;
import ec.edu.ups.poo.clases.ValorProducto;
import ec.edu.ups.poo.opciones.BusqProduc;
import ec.edu.ups.poo.opciones.ListaProd;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class RegistroProd extends Frame {
    private TextField txtCodigo, txtNombre, txtDescripcion, txtPrecio, txtIva, txtDescuento;
    private Button btnGuardar, btnListar, btnBuscar;
    private List<Producto> productos;

    public RegistroProd(List<Producto> productos) {
        this.productos = productos;

        setTitle("Registro de Productos");
        setSize(400, 400);
        setLayout(new GridLayout(8, 2, 5, 5));
        setLocationRelativeTo(null);

        add(new Label("Código:"));
        txtCodigo = new TextField();
        add(txtCodigo);

        add(new Label("Nombre:"));
        txtNombre = new TextField();
        add(txtNombre);

        add(new Label("Descripción:"));
        txtDescripcion = new TextField();
        add(txtDescripcion);

        add(new Label("Precio:"));
        txtPrecio = new TextField();
        add(txtPrecio);

        add(new Label("IVA (%):"));
        txtIva = new TextField();
        add(txtIva);

        add(new Label("Descuento (%):"));
        txtDescuento = new TextField();
        add(txtDescuento);

        btnGuardar = new Button("Guardar");
        add(btnGuardar);

        btnListar = new Button("Listar");
        add(btnListar);

        btnBuscar = new Button("Buscar Producto");
        add(btnBuscar);

        btnBuscar.addActionListener(e -> new BusqProduc(productos));
        btnGuardar.addActionListener(e -> guardarProducto());
        btnListar.addActionListener(e -> new ListaProd(productos));

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void guardarProducto() {
        String codigo = txtCodigo.getText().trim();
        String nombre = txtNombre.getText().trim();
        String descripcion = txtDescripcion.getText().trim();

        double precio = 0.0;
        double iva = 0.0;
        double descuento = 0.0;

        try {
            precio = Double.parseDouble(txtPrecio.getText().trim());
        } catch (NumberFormatException e) {
        }

        try {
            iva = Double.parseDouble(txtIva.getText().trim());
        } catch (NumberFormatException e) {
        }

        try {
            descuento = Double.parseDouble(txtDescuento.getText().trim());
        } catch (NumberFormatException e) {
        }

        ValorProducto valor = new ValorProducto(iva, descuento);
        Producto producto = new Producto(codigo, nombre, descripcion, precio, valor);
        productos.add(producto);
    }

}
