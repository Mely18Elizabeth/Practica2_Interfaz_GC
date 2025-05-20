package ec.edu.ups.poo.registros;

import ec.edu.ups.poo.Enums.Estado;
import ec.edu.ups.poo.clases.ItemSolicitud;
import ec.edu.ups.poo.clases.Producto;
import ec.edu.ups.poo.clases.Solicitud;
import ec.edu.ups.poo.opciones.BusqSolic;
import ec.edu.ups.poo.opciones.ListaSolic;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

public class RegistroSolic extends Frame {

    private TextField txtNumero, txtFecha, txtCantidad;
    private Choice choiceProducto;
    private Button btnGuardar, btnListar, btnBuscar;
    private List<Solicitud> solicitudes;
    private List<Producto> productosDisponibles;

    public RegistroSolic(List<Producto> productos) {
        this.productosDisponibles = productos;
        this.solicitudes = new ArrayList<>();

        setTitle("Registro de Solicitudes");
        setSize(400, 350);
        setLayout(new GridLayout(6, 2, 5, 5));
        setLocationRelativeTo(null);

        add(new Label("Número de Solicitud:"));
        txtNumero = new TextField();
        add(txtNumero);

        add(new Label("Fecha (auto):"));
        txtFecha = new TextField(new GregorianCalendar().getTime().toString());
        txtFecha.setEditable(false);
        add(txtFecha);

        add(new Label("Producto:"));
        choiceProducto = new Choice();
        for (Producto p : productosDisponibles) {
            choiceProducto.add(p.getCodigo() + " - " + p.getNombre());
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

        if (numero.isEmpty() || cantidadStr.isEmpty()) {
            showMessage("Por favor complete todos los campos.");
            return;
        }

        try {
            double cantidad = Double.parseDouble(cantidadStr);
            int selectedIndex = choiceProducto.getSelectedIndex();
            Producto producto = productosDisponibles.get(selectedIndex);

            ItemSolicitud item = new ItemSolicitud(cantidad, producto);
            List<ItemSolicitud> items = new ArrayList<>();
            items.add(item);

            Solicitud solicitud = new Solicitud(numero, new GregorianCalendar(), Estado.Solicitado);
            solicitud.setItems(items);

            solicitudes.add(solicitud);

            txtNumero.setText("");
            txtCantidad.setText("");
            showMessage("Solicitud guardada exitosamente.");

        } catch (NumberFormatException ex) {
            showMessage("Cantidad inválida.");
        }
    }

    private void showMessage(String mensaje) {
        Dialog dialog = new Dialog(this, "Mensaje", true);
        dialog.setLayout(new FlowLayout());
        dialog.setSize(300, 100);
        dialog.add(new Label(mensaje));
        Button btnCerrar = new Button("Cerrar");
        btnCerrar.addActionListener(e -> dialog.dispose());
        dialog.add(btnCerrar);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
}
