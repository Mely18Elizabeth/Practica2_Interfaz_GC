package ec.edu.ups.poo.opciones;
import ec.edu.ups.poo.clases.Solicitud;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class BusqSolic extends Frame {

    private TextField txtBusqueda;
    private Button btnBuscar;
    private TextArea areaResultados;
    private List<Solicitud> solicitudes;

    public BusqSolic(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
        setBackground(new Color(188, 204, 220));
        setTitle("Buscar Solicitud (solo Solicitado)");
        setSize(400, 300);
        setLayout(new BorderLayout(5, 5));
        setLocationRelativeTo(null);

        Panel panelTop = new Panel(new FlowLayout());
        panelTop.add(new Label("Número de Solicitud:"));
        txtBusqueda = new TextField(20);
        panelTop.add(txtBusqueda);
        btnBuscar = new Button("Buscar");
        panelTop.add(btnBuscar);

        add(panelTop, BorderLayout.NORTH);

        areaResultados = new TextArea();
        areaResultados.setEditable(false);
        add(areaResultados, BorderLayout.CENTER);
        btnBuscar.setBackground(new Color(204, 196, 184));
        btnBuscar.addActionListener(e -> buscarSolicitud());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void buscarSolicitud() {
        String criterio = txtBusqueda.getText().trim();
        areaResultados.setText("");

        if (criterio.isEmpty()) {
            areaResultados.setText("Ingrese un número");
            return;
        }

        boolean encontrado = false;
        for (Solicitud s : solicitudes) {
            if (s.getNumero().equalsIgnoreCase(criterio)) {
                areaResultados.append(s.toString() + "\n\n");
                encontrado = true;
            }
        }

        if (!encontrado) {
            areaResultados.setText("No se encontro");
        }
    }

}
