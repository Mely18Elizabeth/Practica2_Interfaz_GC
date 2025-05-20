package ec.edu.ups.poo.opciones;

import ec.edu.ups.poo.clases.Proveedor;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ListaProv extends Frame {

    public ListaProv(List<Proveedor> proveedores) {
        setTitle("Lista de Proveedores");
        setSize(500, 400);
        setLayout(new BorderLayout());

        TextArea area = new TextArea();
        for (Proveedor p : proveedores) {
            area.append(p.toString() + "\n\n");
        }

        add(area, BorderLayout.CENTER);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}
