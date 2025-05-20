package ec.edu.ups.poo.opciones;

import ec.edu.ups.poo.clases.Empleado;
import ec.edu.ups.poo.clases.Direccion;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class BusqEmpleado extends Frame {

    private TextField txtBuscar;
    private Button btnBuscar;
    private List<Empleado> empleados;

    public BusqEmpleado(List<Empleado> empleados) {
        this.empleados = empleados;

        setTitle("Buscar Empleado");
        setSize(350, 150);
        setLayout(new GridLayout(3, 2, 5, 5));
        setLocationRelativeTo(null);

        add(new Label("Ingrese nombre del empleado:"));
        txtBuscar = new TextField();
        add(txtBuscar);

        btnBuscar = new Button("Buscar");
        add(btnBuscar);

        add(new Label());

        btnBuscar.addActionListener(e -> buscarEmpleado());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void buscarEmpleado() {
        String nombreBuscado = txtBuscar.getText().trim();

        if (nombreBuscado.isEmpty()) {
            mostrarDialogo("Ingresa un nombre para buscar.");
            return;
        }

        Empleado encontrado = null;
        for (Empleado emp : empleados) {
            if (emp.getNombre().equalsIgnoreCase(nombreBuscado)) {
                encontrado = emp;
                break;
            }
        }

        if (encontrado != null) {
            mostrarDatosEmpleado(encontrado);
        } else {
            mostrarDialogo("Empleado no encontrado.");
        }
    }

    private void mostrarDatosEmpleado(Empleado empleado) {
        Dialog dialog = new Dialog(this, "Datos del Empleado", true);
        dialog.setLayout(new GridLayout(0, 1, 5, 5));
        dialog.setSize(300, 250);
        dialog.setLocationRelativeTo(this);

        dialog.add(new Label("ID: " + empleado.getId()));
        dialog.add(new Label("Nombre: " + empleado.getNombre()));
        dialog.add(new Label("Apellido: " + empleado.getApellido()));
        dialog.add(new Label("Correo: " + empleado.getCorreo()));
        dialog.add(new Label("Departamento: " + empleado.getDepartamento().getRol().name()));

        if (!empleado.getDireccion().isEmpty()) {
            Direccion dir = empleado.getDireccion().get(0);
            dialog.add(new Label("Ciudad: " + dir.getCiudad()));
            dialog.add(new Label("Calle Principal: " + dir.getCallePrincipal()));
            dialog.add(new Label("Calle Secundaria: " + dir.getCalleSecundario()));
        }

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.setVisible(true);
    }

    private void mostrarDialogo(String mensaje) {
        Dialog dialog = new Dialog(this, "Aviso", true);
        dialog.setLayout(new FlowLayout());
        dialog.setSize(250, 100);
        dialog.setLocationRelativeTo(this);

        dialog.add(new Label(mensaje));

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dialog.dispose();
            }
        });

        dialog.setVisible(true);
    }


}
