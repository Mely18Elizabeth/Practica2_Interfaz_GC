package ec.edu.ups.poo.opciones;

import ec.edu.ups.poo.clases.Proveedor;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class BusqProv extends Frame {

    public BusqProv(List<Proveedor> proveedores) {
        setTitle("Buscar Proveedor por ID");
        setSize(350, 200);
        setLayout(new GridLayout(3, 1));

        Panel panelInput = new Panel(new FlowLayout());
        panelInput.add(new Label("ID del Proveedor:"));
        TextField txtId = new TextField(10);
        panelInput.add(txtId);

        TextArea resultado = new TextArea(3, 40);
        resultado.setEditable(false);

        Button btnBuscar = new Button("Buscar");
        btnBuscar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText().trim());
                boolean encontrado = false;

                for (Proveedor p : proveedores) {
                    if (p.getId() == id) {
                        resultado.setText(p.toString());
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    resultado.setText("Proveedor con ID " + id + " no encontrado.");
                }
            } catch (NumberFormatException ex) {
                resultado.setText("ID inválido. Ingrese un número entero.");
            }
        });

        add(panelInput);
        add(btnBuscar);
        add(resultado);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}
