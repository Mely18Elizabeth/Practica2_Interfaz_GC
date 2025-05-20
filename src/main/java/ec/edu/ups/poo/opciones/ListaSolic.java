package ec.edu.ups.poo.opciones;

import ec.edu.ups.poo.clases.Solicitud;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ListaSolic extends Frame {

    public ListaSolic(List<Solicitud> solicitudes) {
        setTitle("Lista de Solicitudes");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        TextArea area = new TextArea();
        area.setEditable(false);

        for (Solicitud s : solicitudes) {
            area.append(s.toString() + "\n\n");
        }

        add(area, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}
