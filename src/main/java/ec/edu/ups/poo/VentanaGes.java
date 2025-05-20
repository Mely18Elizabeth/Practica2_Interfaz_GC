package ec.edu.ups.poo;

import ec.edu.ups.poo.clases.Empleado;
import ec.edu.ups.poo.clases.Producto;
import ec.edu.ups.poo.clases.Proveedor;
import ec.edu.ups.poo.registros.RegistroEmp;
import ec.edu.ups.poo.registros.RegistroProd;
import ec.edu.ups.poo.registros.RegistroProv;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.ArrayList;

public class VentanaGes extends Frame {

    private Panel panelGeneral, panelPrincipalSuperior, panelPrincipalInter, panelPrincipalInferior;
    private Button BtnProvedor, BtnEmpleado, BtnProducto, BtnSolicitud;
    private Label Titulo1;

    private List<Empleado> empleados; // Usando List
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

        panelPrincipalSuperior = new Panel(new FlowLayout(FlowLayout.CENTER));
        Titulo1 = new Label("Gestión de Compras");
        Titulo1.setFont(new Font("Arial", Font.BOLD, 18));
        panelPrincipalSuperior.add(Titulo1);

        panelPrincipalInter = new Panel(new FlowLayout(FlowLayout.CENTER, 50, 20));
        BtnEmpleado = new Button("Empleado");
        BtnProducto = new Button("Producto");
        BtnSolicitud = new Button("Solicitud");
        BtnProvedor = new Button("Proveedor");

        Dimension botonGrande = new Dimension(150, 50);

        BtnEmpleado.setPreferredSize(botonGrande);
        BtnProducto.setPreferredSize(botonGrande);
        BtnSolicitud.setPreferredSize(botonGrande);
        BtnProvedor.setPreferredSize(botonGrande);

        BtnEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroEmp(empleados);  // PASA la lista compartida
            }
        });

        BtnProvedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroProv(proveedores); // abrir ventana de proveedores
            }
        });

        BtnProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroProd(productos);
            }
        });

        panelPrincipalInter.add(BtnEmpleado);
        panelPrincipalInter.add(BtnProducto);

        // Panel inferior con dos botones
        panelPrincipalInferior = new Panel(new FlowLayout(FlowLayout.CENTER, 50, 20));
        panelPrincipalInferior.add(BtnSolicitud);
        panelPrincipalInferior.add(BtnProvedor);

        panelGeneral.add(panelPrincipalSuperior, BorderLayout.NORTH);
        panelGeneral.add(panelPrincipalInter, BorderLayout.CENTER);
        panelGeneral.add(panelPrincipalInferior, BorderLayout.SOUTH);

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

    public Panel getPanelPrincipalSuperior() {
        return panelPrincipalSuperior;
    }

    public void setPanelPrincipalSuperior(Panel panelPrincipalSuperior) {
        this.panelPrincipalSuperior = panelPrincipalSuperior;
    }

    public Panel getPanelPrincipalInter() {
        return panelPrincipalInter;
    }

    public void setPanelPrincipalInter(Panel panelPrincipalInter) {
        this.panelPrincipalInter = panelPrincipalInter;
    }

    public Panel getPanelPrincipalInferior() {
        return panelPrincipalInferior;
    }

    public void setPanelPrincipalInferior(Panel panelPrincipalInferior) {
        this.panelPrincipalInferior = panelPrincipalInferior;
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
