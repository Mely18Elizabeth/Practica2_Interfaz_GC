package ec.edu.ups.poo.registros;

import ec.edu.ups.poo.clases.Direccion;
import ec.edu.ups.poo.clases.Proveedor;
import ec.edu.ups.poo.opciones.BusqProv;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class RegistroProv extends Frame {
    private TextField txtNombre, txtApellido, txtCorreo;
    private TextField txtCallePrincipal, txtCalleSecundaria, txtCiudad;
    private TextField txtId;
    private Button btnGuardar, btnListar, btnBuscar;
    private List<Proveedor> proveedores;

    public RegistroProv(List<Proveedor> proveedores) {
        this.proveedores = proveedores;

        setTitle("Registro de Proveedores");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10, 2, 5, 5));

        add(new Label("ID:"));
        txtId = new TextField();
        add(txtId);

        add(new Label("Nombre:"));
        txtNombre = new TextField();
        add(txtNombre);

        add(new Label("Apellido:"));
        txtApellido = new TextField();
        add(txtApellido);

        add(new Label("Correo:"));
        txtCorreo = new TextField();
        add(txtCorreo);

        add(new Label("Calle Principal:"));
        txtCallePrincipal = new TextField();
        add(txtCallePrincipal);

        add(new Label("Calle Secundaria:"));
        txtCalleSecundaria = new TextField();
        add(txtCalleSecundaria);

        add(new Label("Ciudad:"));
        txtCiudad = new TextField();
        add(txtCiudad);

        btnGuardar = new Button("Guardar");
        add(btnGuardar);

        btnListar = new Button("Listar");
        add(btnListar);

        btnBuscar = new Button("Buscar por ID");
        add(btnBuscar);

        btnBuscar.addActionListener(e -> new BusqProv(proveedores));
        btnGuardar.addActionListener(e -> guardarProveedor());
        btnListar.addActionListener(e -> listarProveedores());

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void guardarProveedor() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String correo = txtCorreo.getText();

            String callePrincipal = txtCallePrincipal.getText();
            String calleSecundaria = txtCalleSecundaria.getText();
            String ciudad = txtCiudad.getText();

            Direccion direccion = new Direccion(callePrincipal, calleSecundaria, ciudad);
            Proveedor proveedor = new Proveedor(id, nombre, apellido, correo, java.util.Collections.singletonList(direccion));
            proveedores.add(proveedor);


        } catch (NumberFormatException e) {
        }
    }

    private void listarProveedores() {
        Frame ventana = new Frame("Lista de Proveedores");
        ventana.setSize(400, 300);
        ventana.setLayout(new BorderLayout());

        TextArea area = new TextArea();
        for (Proveedor p : proveedores) {
            area.append(p.toString() + "\n\n");
        }

        ventana.add(area, BorderLayout.CENTER);
        ventana.setVisible(true);

        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ventana.dispose();
            }
        });
    }
}
