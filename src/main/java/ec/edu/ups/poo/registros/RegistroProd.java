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
        try {
            String codigo = txtCodigo.getText();
            String nombre = txtNombre.getText();
            String descripcion = txtDescripcion.getText();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            double iva = Double.parseDouble(txtIva.getText().trim());
            double descuento = Double.parseDouble(txtDescuento.getText().trim());

            ValorProducto valor = new ValorProducto(iva, descuento);
            Producto producto = new Producto(codigo, nombre, descripcion, precio, valor);
            productos.add(producto);

            // No limpiar campos según tu pedido

        } catch (NumberFormatException ex) {
            // Puedes agregar mensaje de error aquí si quieres
        }
    }
}
