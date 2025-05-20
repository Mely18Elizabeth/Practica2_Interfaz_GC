package ec.edu.ups.poo.registros;

import ec.edu.ups.poo.Enums.Rol;
import ec.edu.ups.poo.opciones.BusqEmpleado;
import ec.edu.ups.poo.opciones.ListaEmp;
import ec.edu.ups.poo.clases.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.List;

public class RegistroEmp extends Frame {
    private List<Empleado> empleados;

    private TextField txtId, txtNombre, txtApellido, txtCorreo;
    private Choice chDepartamento;
    private TextField txtCallePrincipal, txtCalleSecundaria, txtCiudad;
    private Button btnGuardar, btnListar, btnBuscar;

    public RegistroEmp(List<Empleado> empleados) {
        this.empleados = empleados;

        setTitle("Registro de Empleados");
        setSize(400, 650);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(13, 2, 5, 5));

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

        add(new Label("Departamento:"));
        chDepartamento = new Choice();
        for (Rol rol : Rol.values()) {
            chDepartamento.add(rol.name());
        }
        add(chDepartamento);

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

        btnListar = new Button("Lista");
        add(btnListar);

        btnBuscar = new Button("Buscar");
        add(btnBuscar);

        btnGuardar.addActionListener(e -> guardarEmpleado());

        btnListar.addActionListener(e -> new ListaEmp(empleados));
        btnBuscar.addActionListener(e -> new BusqEmpleado(empleados));

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void guardarEmpleado() {
        String idTexto = txtId.getText().trim();
        if (idTexto.isEmpty()) {
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idTexto);
        } catch (NumberFormatException e) {
            return;
        }

        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String correo = txtCorreo.getText();
        Rol rolSeleccionado = Rol.valueOf(chDepartamento.getSelectedItem());

        String callePrincipal = txtCallePrincipal.getText();
        String calleSecundaria = txtCalleSecundaria.getText();
        String ciudad = txtCiudad.getText();

        Direccion direccion = new Direccion(callePrincipal, calleSecundaria, ciudad);
        Departamento departamento = new Departamento(rolSeleccionado);
        Empleado empleado = new Empleado(id, nombre, apellido, correo, Collections.singletonList(direccion), departamento);

        empleados.add(empleado);
    }
}
