package ec.edu.ups.poo.opciones;

import ec.edu.ups.poo.clases.Producto;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class BusqProduc extends Frame {
    private TextField txtBusqueda;
    private Button btnBuscar;
    private TextArea areaResultados;
    private List<Producto> productos;

    public BusqProduc(List<Producto> productos) {
        this.productos = productos;

        setTitle("Buscar Producto");
        setSize(400, 300);
        setLayout(new BorderLayout(5,5));
        setLocationRelativeTo(null);

        Panel panelTop = new Panel(new FlowLayout());
        panelTop.add(new Label("Código o Nombre:"));
        txtBusqueda = new TextField(20);
        panelTop.add(txtBusqueda);
        btnBuscar = new Button("Buscar");
        panelTop.add(btnBuscar);

        add(panelTop, BorderLayout.NORTH);

        areaResultados = new TextArea();
        areaResultados.setEditable(false);
        add(areaResultados, BorderLayout.CENTER);

        btnBuscar.addActionListener(e -> buscarProducto());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void buscarProducto() {
        String criterio = txtBusqueda.getText().trim().toLowerCase();
        areaResultados.setText("");

        if (criterio.isEmpty()) {
            areaResultados.setText("Ingrese un código o nombre para buscar.");
            return;
        }

        boolean encontrado = false;
        for (Producto p : productos) {
            if (p.getCodigo().toLowerCase().contains(criterio) ||
                    p.getNombre().toLowerCase().contains(criterio)) {
                areaResultados.append(p.toString() + "\n\n");
                encontrado = true;
            }
        }
        if (!encontrado) {
            areaResultados.setText("No se encontraron productos para: " + criterio);
        }
    }
}
