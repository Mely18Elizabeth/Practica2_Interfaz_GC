package ec.edu.ups.poo;

import ec.edu.ups.poo.clases.Empleado;
import ec.edu.ups.poo.clases.Producto;
import ec.edu.ups.poo.clases.Proveedor;
import ec.edu.ups.poo.registros.RegistroEmp;
import ec.edu.ups.poo.registros.RegistroProd;
import ec.edu.ups.poo.registros.RegistroProv;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaGes extends Frame {

    private Panel panelGeneral, panelSuperior, panelCentral;
    private Button BtnProvedor, BtnEmpleado, BtnProducto, BtnSolicitud, BtnSalir;
    private Label Titulo1;

    private List<Empleado> empleados;
    private List<Producto> productos;
    private List<Proveedor> proveedores;

    public VentanaGes() {
        empleados = new ArrayList<>();
        productos = new ArrayList<>();
        proveedores = new ArrayList<>();

        setTitle("Pantalla Principal");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        panelGeneral = new Panel(new BorderLayout());

        panelSuperior = new Panel(new FlowLayout(FlowLayout.CENTER));
        Titulo1 = new Label("Gestión de Compras");
        Titulo1.setFont(new Font("Arial", Font.BOLD, 18));
        panelSuperior.add(Titulo1);

        panelCentral = new Panel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);

        BtnEmpleado = new Button("Empleado");
        BtnProducto = new Button("Producto");
        BtnSolicitud = new Button("Solicitud");
        BtnProvedor = new Button("Proveedor");
        BtnSalir = new Button("Salir");

        Dimension btnSize = new Dimension(120, 50);
        for (Button b : new Button[]{BtnEmpleado, BtnProducto, BtnSolicitud, BtnProvedor, BtnSalir}) {
            b.setPreferredSize(btnSize);
        }
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        panelCentral.add(BtnEmpleado, gbc);

        gbc.gridx = 1;
        panelCentral.add(BtnProducto, gbc);

        gbc.gridx = 2;
        panelCentral.add(BtnSolicitud, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panelCentral.add(BtnProvedor, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panelCentral.add(BtnSalir, gbc);

        BtnEmpleado.addActionListener(e -> new RegistroEmp(empleados));
        BtnProducto.addActionListener(e -> new RegistroProd(productos));
        BtnProvedor.addActionListener(e -> new RegistroProv(proveedores));
        BtnSalir.addActionListener(e -> dispose());

        panelGeneral.add(panelSuperior, BorderLayout.NORTH);
        panelGeneral.add(panelCentral, BorderLayout.CENTER);
        add(panelGeneral);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public Panel getPanelGeneral() {
        return panelGeneral;
    }

    public void setPanelGeneral(Panel panelGeneral) {
        this.panelGeneral = panelGeneral;
    }

    public Panel getPanelSuperior() {
        return panelSuperior;
    }

    public void setPanelSuperior(Panel panelSuperior) {
        this.panelSuperior = panelSuperior;
    }

    public Panel getPanelCentral() {
        return panelCentral;
    }

    public void setPanelCentral(Panel panelCentral) {
        this.panelCentral = panelCentral;
    }

    public Button getBtnProvedor() {
        return BtnProvedor;
    }

    public void setBtnProvedor(Button btnProvedor) {
        BtnProvedor = btnProvedor;
    }

    public Button getBtnEmpleado() {
        return BtnEmpleado;
    }

    public void setBtnEmpleado(Button btnEmpleado) {
        BtnEmpleado = btnEmpleado;
    }

    public Button getBtnProducto() {
        return BtnProducto;
    }

    public void setBtnProducto(Button btnProducto) {
        BtnProducto = btnProducto;
    }

    public Button getBtnSolicitud() {
        return BtnSolicitud;
    }

    public void setBtnSolicitud(Button btnSolicitud) {
        BtnSolicitud = btnSolicitud;
    }

    public Button getBtnSalir() {
        return BtnSalir;
    }

    public void setBtnSalir(Button btnSalir) {
        BtnSalir = btnSalir;
    }

    public Label getTitulo1() {
        return Titulo1;
    }

    public void setTitulo1(Label titulo1) {
        Titulo1 = titulo1;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
}