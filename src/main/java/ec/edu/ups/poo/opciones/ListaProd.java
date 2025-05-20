package ec.edu.ups.poo.opciones;

import ec.edu.ups.poo.clases.Producto;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ListaProd extends Frame {
    private List<Producto> productos;

    public ListaProd(List<Producto> productos) {
        this.productos = productos;

        setTitle("Lista de Productos");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        TextArea area = new TextArea();
        area.setEditable(false);

        for (Producto p : productos) {
            area.append(p.toString() + "\n\n");
        }

        add(area, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
