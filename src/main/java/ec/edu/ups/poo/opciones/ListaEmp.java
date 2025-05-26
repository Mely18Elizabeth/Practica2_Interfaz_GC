package ec.edu.ups.poo.opciones;
import ec.edu.ups.poo.clases.Empleado;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ListaEmp extends Frame {

    public ListaEmp(List<Empleado> empleados) {
        setTitle("Lista de Empleados");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        TextArea area = new TextArea();
        area.setEditable(false);
        for (Empleado e : empleados) {
            area.append(e.toString() + "\n\n");
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
