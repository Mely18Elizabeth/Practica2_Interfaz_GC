package ec.edu.ups.poo.registros;

import ec.edu.ups.poo.Enums.*;
import ec.edu.ups.poo.clases.*;
import ec.edu.ups.poo.opciones.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class RegistroSolic extends Frame {

    private TextField txtNumero, txtFecha, txtCantidad;
    private Choice choiceProducto;
    private Button btnGuardar, btnListar, btnBuscar, btnCambiarEstado;
    private List<Solicitud> solicitudes;
    private List<Producto> productosDisponibles;
    private Choice choiceEstado;




    public RegistroSolic(List<Solicitud> solicitudes, List<Empleado> empleados, List<Producto> productos) {
        this.productosDisponibles = productos;
        this.solicitudes = solicitudes;

        setTitle("Registro de Solicitudes");
        setSize(400, 350);
        setLayout(new GridLayout(6, 2, 5, 5));
        setLocationRelativeTo(null);

        add(new Label("Número de Solicitud:"));
        txtNumero = new TextField();
        add(txtNumero);

        add(new Label("Fecha (dd/MM/yyyy):"));
        txtFecha = new TextField();
        txtFecha.setEditable(true);
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

        btnGuardar = new Button("Guardar Solicitud");
        add(btnGuardar);
        btnGuardar.addActionListener(e -> guardarSolicitud());

        btnListar = new Button("Listar Solicitudes");
        add(btnListar);
        btnListar.addActionListener(e -> new ListaSolic(solicitudes));

        btnBuscar = new Button("Buscar Solicitud");
        add(btnBuscar);
        btnBuscar.addActionListener(e -> new BusqSolic(solicitudes));

        // Botón para cambiar estado
        btnCambiarEstado = new Button("Cambiar Estado");
        add(btnCambiarEstado);
        btnCambiarEstado.addActionListener(e -> new EstadoSolic(solicitudes));

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

            String estadoStr = choiceEstado.getSelectedItem();
            Estado estado = Estado.valueOf(estadoStr);

            Solicitud solicitud = new Solicitud(numero, fecha, estado);
            solicitud.setItems(items);

            solicitudes.add(solicitud);


        } catch (NumberFormatException ex) {
        }
    }
}
