package ec.edu.ups.poo.opciones;

import ec.edu.ups.poo.clases.Empleado;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class BusqEmpleado extends Frame {

    private TextField txtBuscar;
    private Button btnBuscar;
    private TextArea areaResultados;
    private List<Empleado> empleados;

    public BusqEmpleado(List<Empleado> empleados) {
        this.empleados = empleados;
        setBackground(new Color(188, 204, 220));
        setTitle("Buscar Empleado");
        setSize(400, 300);
        setLayout(new BorderLayout(5, 5));
        setLocationRelativeTo(null);

        Panel panelTop = new Panel(new FlowLayout());
        panelTop.add(new Label("Nombre del empleado:"));
        txtBuscar = new TextField(20);
        panelTop.add(txtBuscar);
        btnBuscar = new Button("Buscar");
        panelTop.add(btnBuscar);

        add(panelTop, BorderLayout.NORTH);

        areaResultados = new TextArea();
        areaResultados.setEditable(false);
        add(areaResultados, BorderLayout.CENTER);

        btnBuscar.setBackground(new Color(204, 196, 184));

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
        String nombreBuscado = txtBuscar.getText().trim().toLowerCase();
        areaResultados.setText("");

        if (nombreBuscado.isEmpty()) {
            areaResultados.setText("Ingrese un nombre");
            return;
        }

        boolean encontrado = false;
        for (Empleado emp : empleados) {
            if (emp.getNombre().toLowerCase().contains(nombreBuscado)) {
                areaResultados.append(emp.toString() + "\n\n");
                encontrado = true;
            }
        }

        if (!encontrado) {
            areaResultados.setText("No se encontro");
        }
    }
}
