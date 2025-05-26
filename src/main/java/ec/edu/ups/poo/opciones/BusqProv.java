package ec.edu.ups.poo.opciones;

import ec.edu.ups.poo.clases.Proveedor;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class BusqProv extends Frame {

    private TextField txtId;
    private Button btnBuscar;
    private TextArea areaResultado;
    private List<Proveedor> proveedores;

    public BusqProv(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
        setBackground(new Color(188, 204, 220));
        setTitle("Buscar Proveedor por ID");
        setSize(400, 300);
        setLayout(new BorderLayout(5, 5));
        setLocationRelativeTo(null);

        Panel panelTop = new Panel(new FlowLayout());
        panelTop.add(new Label("ID del Proveedor:"));
        txtId = new TextField(10);
        panelTop.add(txtId);
        btnBuscar = new Button("Buscar");
        btnBuscar.setBackground(new Color(204, 196, 184));
        panelTop.add(btnBuscar);

        add(panelTop, BorderLayout.NORTH);

        areaResultado = new TextArea();
        areaResultado.setEditable(false);
        add(areaResultado, BorderLayout.CENTER);
        btnBuscar.setBackground(new Color(204, 196, 184));

        btnBuscar.addActionListener(e -> buscarProveedor());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void buscarProveedor() {
        areaResultado.setText("");
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            boolean encontrado = false;

            for (Proveedor p : proveedores) {
                if (p.getId() == id) {
                    areaResultado.setText(p.toString());
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                areaResultado.setText("No encontrado" + id );
            }

        } catch (NumberFormatException ex) {
            areaResultado.setText("ID inválido");
        }
    }
}
