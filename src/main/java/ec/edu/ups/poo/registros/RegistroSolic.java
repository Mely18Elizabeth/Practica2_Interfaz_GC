package ec.edu.ups.poo.registros;

import ec.edu.ups.poo.Enums.*;
import ec.edu.ups.poo.clases.*;
import ec.edu.ups.poo.opciones.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class RegistroSolic extends Frame {

    private TextField txtNumero, txtFecha, txtCantidad;
    private Choice choiceProducto, choiceEstado;
    private Button btnGuardar, btnListar, btnBuscar, btnCambiarEstado, btnCalcular;
    private List<Solicitud> solicitudes;
    private List<Producto> productosDisponibles;

    public RegistroSolic(List<Solicitud> solicitudes, List<Empleado> empleados, List<Producto> productos) {
        this.productosDisponibles = productos;
        this.solicitudes = solicitudes;

        setBackground(new Color(239, 234, 221));
        setTitle("Registro de Solicitudes");
        setSize(420, 500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 2, 5, 5));

        add(new Label("Número de Solicitud:"));
        txtNumero = new TextField();
        add(txtNumero);

        add(new Label("Fecha (dd/MM/yyyy):"));
        txtFecha = new TextField();
        add(txtFecha);

        add(new Label("Estado:"));
        choiceEstado = new Choice();
        for (Estado e : Estado.values()) {
            choiceEstado.add(e.name());
        }
        add(choiceEstado);

        add(new Label("Producto:"));
        choiceProducto = new Choice();
        for (Producto p : productosDisponibles) {
            choiceProducto.add(p.getNombre());
        }
        add(choiceProducto);

        add(new Label("Cantidad:"));
        txtCantidad = new TextField();
        add(txtCantidad);

        btnGuardar = new Button("Guardar");
        add(btnGuardar);

        btnListar = new Button("Listar");
        add(btnListar);

        btnBuscar = new Button("Buscar");
        add(btnBuscar);

        btnCambiarEstado = new Button("Cambiar Estado");
        add(btnCambiarEstado);

        btnCalcular = new Button("Calcular Total");
        add(btnCalcular);

        Color colorBoton = new Color(193, 186, 172);
        btnGuardar.setBackground(colorBoton);
        btnListar.setBackground(colorBoton);
        btnBuscar.setBackground(colorBoton);
        btnCambiarEstado.setBackground(colorBoton);
        btnCalcular.setBackground(colorBoton);

        btnGuardar.addActionListener(e -> guardarSolicitud());
        btnListar.addActionListener(e -> new ListaSolic(solicitudes));
        btnBuscar.addActionListener(e -> new BusqSolic(solicitudes));
        btnCambiarEstado.addActionListener(e -> new EstadoSolic(solicitudes));
        btnCalcular.addActionListener(e -> calcularTotal());

        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void guardarSolicitud() {
        String numero = txtNumero.getText().trim();
        String cantidadStr = txtCantidad.getText().trim();
        String fechaStr = txtFecha.getText().trim();

        if (numero.isEmpty() || cantidadStr.isEmpty() || fechaStr.isEmpty()) {
            return;
        }

        GregorianCalendar fecha = new GregorianCalendar();
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaDate = formatoFecha.parse(fechaStr);
            fecha.setTime(fechaDate);
        } catch (ParseException ex) {
            return;
        }

        try {
            double cantidad = Double.parseDouble(cantidadStr);
            int selectedIndex = choiceProducto.getSelectedIndex();
            if (selectedIndex < 0 || selectedIndex >= productosDisponibles.size()) {
                return;
            }

            Producto producto = productosDisponibles.get(selectedIndex);
            ItemSolicitud item = new ItemSolicitud(cantidad, producto);
            List<ItemSolicitud> items = new ArrayList<>();
            items.add(item);

            Estado estado = Estado.valueOf(choiceEstado.getSelectedItem());
            Solicitud solicitud = new Solicitud(numero, fecha, estado);
            solicitud.setItems(items);

            solicitudes.add(solicitud);

        } catch (NumberFormatException ex) {
        }
    }


    private void calcularTotal() {
        try {
            int index = choiceProducto.getSelectedIndex();
            if (index < 0 || index >= productosDisponibles.size()) {
                showMessage("Seleccione un producto válido.");
                return;
            }

            double cantidad = Double.parseDouble(txtCantidad.getText().trim());
            Producto producto = productosDisponibles.get(index);

            double precio = producto.getPrecio();
            double iva = producto.getValor().getIva();
            double descuento = producto.getValor().getDescuento();

            double subtotal = precio * cantidad;
            double montoIva = subtotal * iva;
            double montoDescuento = subtotal * descuento;
            double total = subtotal + montoIva - montoDescuento;

            showMessage("Total de la compra: $" + String.format("%.2f", total));
        } catch (NumberFormatException ex) {
            showMessage("Ingrese una cantidad válida.");
        }
    }


    private void showMessage(String mensaje) {
        Dialog dialog = new Dialog(this, "Mensaje", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(300, 120);
        dialog.setLocationRelativeTo(this);

        Label label = new Label(mensaje, Label.CENTER);
        dialog.add(label, BorderLayout.CENTER);

        Button ok = new Button("Aceptar");
        ok.addActionListener(e -> dialog.dispose());
        Panel panel = new Panel();
        panel.add(ok);
        dialog.add(panel, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }
}
