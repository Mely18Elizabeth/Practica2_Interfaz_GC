package ec.edu.ups.poo.opciones;

import ec.edu.ups.poo.clases.Solicitud;
import ec.edu.ups.poo.Enums.Estado;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class EstadoSolic extends Frame {

    private TextField txtNumero;
    private TextArea areaInfo;
    private Button btnBuscar, btnAprobar, btnRechazar;
    private List<Solicitud> solicitudes;
    private Solicitud solicitudEncontrada;

    public EstadoSolic(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;

        setTitle("Buscar y Cambiar Estado de Solicitud");
        setSize(400, 300);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);

        // Panel superior para búsqueda
        Panel panelTop = new Panel(new FlowLayout());
        panelTop.add(new Label("Número de Solicitud:"));
        txtNumero = new TextField(20);
        panelTop.add(txtNumero);
        btnBuscar = new Button("Buscar");
        panelTop.add(btnBuscar);

        add(panelTop, BorderLayout.NORTH);

        // Área para mostrar info de la solicitud
        areaInfo = new TextArea();
        areaInfo.setEditable(false);
        add(areaInfo, BorderLayout.CENTER);

        // Panel inferior para botones de cambio de estado
        Panel panelBottom = new Panel(new FlowLayout());
        btnAprobar = new Button("Aprobar");
        btnRechazar = new Button("Rechazar");

        // Inicialmente deshabilitados hasta que se encuentre la solicitud
        btnAprobar.setEnabled(false);
        btnRechazar.setEnabled(false);

        panelBottom.add(btnAprobar);
        panelBottom.add(btnRechazar);

        add(panelBottom, BorderLayout.SOUTH);

        // Eventos
        btnBuscar.addActionListener(e -> buscarSolicitud());
        btnAprobar.addActionListener(e -> cambiarEstado(Estado.Aprobado));
        btnRechazar.addActionListener(e -> cambiarEstado(Estado.Rechazado));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void buscarSolicitud() {
        String numero = txtNumero.getText().trim();
        solicitudEncontrada = null;
        areaInfo.setText("");

        if (numero.isEmpty()) {
            areaInfo.setText("Ingrese un número de solicitud para buscar.");
            btnAprobar.setEnabled(false);
            btnRechazar.setEnabled(false);
            return;
        }

        for (Solicitud s : solicitudes) {
            if (s.getNumero().equalsIgnoreCase(numero)) {
                solicitudEncontrada = s;
                break;
            }
        }

        if (solicitudEncontrada != null) {
            areaInfo.setText("Solicitud encontrada:\n" + solicitudEncontrada.toString());
            btnAprobar.setEnabled(true);
            btnRechazar.setEnabled(true);
        } else {
            areaInfo.setText("No se encontró ninguna solicitud con ese número.");
            btnAprobar.setEnabled(false);
            btnRechazar.setEnabled(false);
        }
    }

    private void cambiarEstado(Estado nuevoEstado) {
        if (solicitudEncontrada != null) {
            solicitudEncontrada.setEstado(nuevoEstado);
            areaInfo.setText("Estado cambiado a: " + nuevoEstado + "\n\n" + solicitudEncontrada.toString());
            // Opcional: deshabilitar botones después del cambio para evitar repetidos cambios accidentales
            btnAprobar.setEnabled(false);
            btnRechazar.setEnabled(false);
        }
    }
}
