/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.Acceso;
import Clases.Cliente;
import Clases.Empleado;
import Clases.Factura;
import Clases.HistoricoPrecioPieza;
import Clases.HistoricoPrecioVehiculos;
import Clases.FacturaJRADATASOURCE;
import Clases.Facturarechazada;
import Clases.Persona;
import Clases.Pieza;
import Clases.PiezaFactura;
import Clases.RazonSocial;
import Clases.TipoFactura;
import Clases.TipoPago;
import Clases.Validaciones;
import Clases.Vehiculo;
import Clases.VehiculoFactura;
import Clases.informacionFiscal;
import FormModales.ModalPiezas;
import FormModales.ModalVehiculos;
import JPAController.ClienteJpaController;
import JPAController.EmpleadoJpaController;
import JPAController.FacturaJpaController;
import JPAController.FacturarechazadaJpaController;
import JPAController.HistoricoPrecioPiezaJpaController;
import JPAController.HistoricoPrecioVehiculosJpaController;
import JPAController.MarcaJpaController;
import JPAController.Numero_AsientosJpaController;
import JPAController.PersonaJpaController;
import JPAController.PiezaFacturaJpaController;
import JPAController.PiezaJpaController;
import JPAController.RazonSocialJpaController;
import JPAController.TipoCabinaJpaController;
import JPAController.TipoFacturaJpaController;
import JPAController.TipoGasolinaJpaController;
import JPAController.TipoPagoJpaController;
import JPAController.TipoVehiculoJpaController;
import JPAController.Tipo_DocumentoJpaController;
import JPAController.Tipo_colorJpaController;
import JPAController.VehiculoFacturaJpaController;
import JPAController.VehiculoJpaController;
import JPAController.informacionFiscalJpaController;
import JPAController.transmisionJpaController;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.exolab.castor.types.Date;


/**
 *
 * @author Usuario
 */
public class Ventas extends javax.swing.JFrame {

    EntityManagerFactory emf =Persistence.createEntityManagerFactory("CarSoft");
    Tipo_DocumentoJpaController tipoDocumentoDao = new Tipo_DocumentoJpaController(emf);
    PersonaJpaController personaDao = new PersonaJpaController(emf);
    ClienteJpaController clienteDao = new ClienteJpaController(emf);
    EmpleadoJpaController empleadoDao = new EmpleadoJpaController(emf);
    PiezaJpaController piezaDao = new PiezaJpaController(emf);
    HistoricoPrecioPiezaJpaController historicoPiezaDao = new HistoricoPrecioPiezaJpaController(emf);
    HistoricoPrecioVehiculosJpaController historicoVehiculoDao = new HistoricoPrecioVehiculosJpaController(emf);
    VehiculoJpaController vehiculoDao = new VehiculoJpaController(emf);
    MarcaJpaController Marcadao = new MarcaJpaController(emf);
    Tipo_colorJpaController Colorrdao = new Tipo_colorJpaController(emf);
    TipoCabinaJpaController TipoCabinadao = new TipoCabinaJpaController(emf);
    TipoGasolinaJpaController TipoGasolinadao = new TipoGasolinaJpaController(emf);
    transmisionJpaController TipoTransmisiondao = new transmisionJpaController(emf);
    TipoVehiculoJpaController TipoVehiculodao = new TipoVehiculoJpaController(emf);
    Numero_AsientosJpaController NumeroAsientosdao = new Numero_AsientosJpaController(emf);
    informacionFiscalJpaController infFiscalDao = new informacionFiscalJpaController(emf);
    
    FacturaJpaController facturaDao = new FacturaJpaController(emf);
    PiezaFacturaJpaController piezaFacturaDao = new PiezaFacturaJpaController(emf);
    VehiculoFacturaJpaController vehiculoFacturaDao = new VehiculoFacturaJpaController(emf);
    TipoFacturaJpaController tipoFacturaDao = new TipoFacturaJpaController(emf);
    FacturarechazadaJpaController facturaRechazada = new FacturarechazadaJpaController(emf);
    
    
    
    TipoPagoJpaController tipoPagoDao = new TipoPagoJpaController(emf);
    RazonSocialJpaController razonSocialDao = new RazonSocialJpaController(emf);
    
    String empNomb;

    public String getEmpNomb() {
        return empNomb;
    }

    public void setEmpNomb(String empNomb) {
        this.empNomb = empNomb;
    }
    
    /**
     * Creates new form Empleados
     */
    public Ventas(Acceso a) {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getResource("/Img/CarSoft-removebg-preview.png")).getImage());
        this.setExtendedState(MAXIMIZED_BOTH);
        tab_Ventas.setBackground(Color.CYAN);
        jPanel1.setBackground(Color.CYAN);
        jPanel2.setBackground(Color.CYAN);
        this.jPanel2.setBackground( new Color(0, 75, 143));
        this.jPanel1.setBackground( new Color(0, 75, 143));
        this.jPanel3.setBackground( new Color(0, 75, 143));
        this.getContentPane().setBackground(new Color(0, 75, 143));
        btnAgregar2.setBackground( new Color(14, 209, 69));
        btnAgregar4.setBackground( new Color(14, 209, 69));
        btnAgregar5.setBackground( new Color(14, 209, 69));
        btnAgregar6.setBackground( new Color(14, 209, 69));
        btnAgregar7.setBackground( new Color(14, 209, 69));
        btnAgregar8.setBackground( new Color(14, 209, 69));
        btnAgregar3.setBackground( new Color(14, 209, 69));
                    btnModificar2.setEnabled(false);
                    btnDesactivar3.setEnabled(false);
        jButton7.setBackground( new Color(14, 209, 69));
        this.jButton19.setBackground( new Color(236, 28, 36));
        this.jButton17.setBackground( new Color(236, 28, 36));
        this.btnSalir2.setBackground( new Color(236, 28, 36));
        this.jButton20.setBackground( new Color(236, 28, 36));
        this.jButton22.setBackground( new Color(236, 28, 36));
        this.jButton24.setBackground( new Color(236, 28, 36));
        jButton1.setEnabled(true);
        btnModificar3.setEnabled(false);
        btnDesactivar4.setEnabled(false);
        this.btnRegresar2.setBackground( new Color(14, 209, 69));
        this.jButton21.setBackground( new Color(14, 209, 69));
        this.jButton23.setBackground( new Color(14, 209, 69));
        this.jButton25.setBackground( new Color(14, 209, 69));
        crearCmbIDEmpleado();
        crearCmbIDPieza();
        crearTbVenta();
        setFechatxt();
        crearCmbIDVehiculo();
        setTxtNumFactura();
        crearCmbIDTipoFactura();
        createCmbTipoFacturaVenta();
        createCmbTipoFactura();
        createTableCAI();
        ltrampa.setVisible(false);
        setCAIFactura();
        cmbIDTipoPagoAgregar();
        createTbTipoPago();
        createCmbTipoPago();
        cargarCmbNombreEmpleado();
        crearTbFacturasRechazado();
        createTbBusquedaGeneral();
        createTbTipoFactura();
        
        try{
            jButton7.setVisible(a.getPermisoSeccionReporteBuscar());
            jTable3.setEnabled(a.getPermisoSeccionReporteBuscar());
            jLabel13.setVisible(a.getPermisoSeccionVentasBuscarPieza());
            jLabel14.setVisible(a.getPermisoSeccionVentasBuscarVehiculo());
            btnAgregarPieza.setVisible(a.getPermisoSeccionVentasAgregarPieza());
            btnAgregarVehiculo.setVisible(a.getPermisoSeccionVentasAgregarVehiculo());
            //jButton3.setVisible(a.getPermisoSeccionVentasBorrar());
            btnImprimirFactura.setVisible(a.getPermisoSeccionVentasGenerarVenta());
            btnAgregar2.setVisible(a.getPermisoSeccionTipoFacturaAgregar());
            btnModificar2.setVisible(a.getPermisoSeccionTipoFacturaModificar());
            btnDesactivar3.setVisible(a.getPermisoSeccionTipoFacturaDesactivar());
            btnAgregar4.setVisible(a.getPermisoSeccionTipoFacturaReportePdf());
            btnAgregar3.setVisible(a.getPermisoSeccionTipoFacturaReporteExcel());
            jButton1.setVisible(a.getPermisoSeccionCaiAgregar());
            btnModificar3.setVisible(a.getPermisoSeccionCaiModificar());
            btnDesactivar4.setVisible(a.getPermisoSeccionCaiDesactivar());
            btnAgregar5.setVisible(a.getPermisoSeccionCaiReportePdf());
            btnAgregar6.setVisible(a.getPermisoSeccionCaiReporteExcel());
            btnAgregarTipoPago.setVisible(a.getPermisoSeccionTipoPagoAgregar());
            btnModificarTipoPago.setVisible(a.getPermisoSeccionTipoPagoModificar());
            btnDesactivarTipoPago.setVisible(a.getPermisoSeccionTipoPagoDesactivar());
            btnAgregar7.setVisible(a.getPermisoSeccionTipoPagoReportePdf());
            btnAgregar8.setVisible(a.getPermisoSeccionTipoPagoReporteExcel());
            jButton2.setVisible(a.getPermisoSeccionFacturasRechazadasBuscar());
            jButton5.setVisible(a.getPermisoSeccionFacturasRechazadasRechazar());
            
            
            //Acceso del usuario
        }catch(Exception e){
            //Acceso como root
        }
        
    }
    
    private void createCmbTipoPago(){
        DefaultComboBoxModel modelo10 = new DefaultComboBoxModel();
        cmbTipoPago.setModel(modelo10);
        modelo10.addElement("Seleccione");
        
        tipoPagoDao.findTipoPagoEntities().forEach((temp) -> {
            modelo10.addElement(temp.getNombre());
        });
                
    }
    
    private void setCAIFactura(){
        List<informacionFiscal> temporal = infFiscalDao.findinformacionFiscalEntities();
        LocalDate f1,f2 ;
        LocalDate fechaActual = LocalDate.now();
        //JOptionPane.showMessageDialog(null, fechaActual);
        List<Factura> fac = facturaDao.findFacturaEntities();
        
        for(informacionFiscal e : temporal){
            f1 = LocalDate.parse(e.getFechaInicio());
            f2 = LocalDate.parse(e.getFechaFinal());
            if(fechaActual.isAfter(f1) && fechaActual.isBefore(f2) && e.isEstado()){
                lCAI.setText(e.getCai());    
            }     
        }
        
        
    }

    private void createCmbTipoFacturaVenta(){
        DefaultComboBoxModel modelo1=new DefaultComboBoxModel();
        cmbTipoFacturaVenta.setModel(modelo1);
        modelo1.addElement("Seleccione");
        List<TipoFactura> temp = tipoFacturaDao.findTipoFacturaEntities();
        for(TipoFactura e : temp){
            modelo1.addElement(e.getTipoFactura());
        }
        
    }
    
    private void createTbTipoFactura(){
        DefaultTableModel modelo2 = (DefaultTableModel) tblNuevoCargo.getModel();
        tblNuevoCargo.setModel(modelo2);
        int i;
        for(i=modelo2.getRowCount()-1;i>=0;i--){
            modelo2.removeRow(i);
        }
        /*modelo2.addColumn("ID");
        modelo2.addColumn("Tipo de Factura");
        modelo2.addColumn("Estado");*/
        
        
        List<TipoFactura> temp = tipoFacturaDao.findTipoFacturaEntities();
        
        for(TipoFactura e : temp)
            modelo2.addRow(
                    new Object[]{
                        e.getIDtipofactura(),
                        e.getTipoFactura(),
                        (e.getEstado())?"Activo":"Inactivo"
            });
    }
    
    private void createCmbTipoFactura(){
        DefaultComboBoxModel modelo1=new DefaultComboBoxModel();
        cmbIDNuevoFactura.setModel(modelo1);
        modelo1.addElement("Nuevo");
        List<TipoFactura> temp = tipoFacturaDao.findTipoFacturaEntities();
        for(TipoFactura e : temp){
            modelo1.addElement(e.getIDtipofactura());
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab_Ventas = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtNumFacturaBusqueda = new javax.swing.JFormattedTextField();
        chkNumFactura = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        txtClienteBusqueda = new javax.swing.JTextField();
        chkCliente = new javax.swing.JCheckBox();
        jLabel37 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNumFactura = new javax.swing.JTextField();
        btnImprimirFactura = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVenta = new javax.swing.JTable();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtVIN = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbIDEmpleado = new javax.swing.JComboBox<>();
        btnAgregarPieza = new javax.swing.JButton();
        btnAgregarVehiculo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtDocumentoCliente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmbTipoFacturaVenta = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtIDPieza = new javax.swing.JFormattedTextField();
        txtIDVehiculo = new javax.swing.JFormattedTextField();
        jLabel22 = new javax.swing.JLabel();
        lCAI = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cmbTipoPago = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        txtImpuesto = new javax.swing.JFormattedTextField();
        ltarjeta = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JFormattedTextField();
        jLabel36 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnRegresar2 = new javax.swing.JButton();
        btnSalir2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblNuevoCargo = new javax.swing.JTable();
        btnAgregar2 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cmbIDNuevoFactura = new javax.swing.JComboBox<>();
        txtTipoFactura = new javax.swing.JTextField();
        btnModificar2 = new javax.swing.JButton();
        btnLimpiar2 = new javax.swing.JButton();
        btnDesactivar3 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        btnAgregar3 = new javax.swing.JButton();
        btnAgregar4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtDe = new javax.swing.JFormattedTextField();
        txtHasta = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCAI = new javax.swing.JTextField();
        txtFechaInicio = new javax.swing.JFormattedTextField();
        txtFechaFinalizacion = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCAI = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnModificar3 = new javax.swing.JButton();
        btnLimpiar3 = new javax.swing.JButton();
        btnDesactivar4 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        ltrampa = new javax.swing.JLabel();
        btnAgregar5 = new javax.swing.JButton();
        btnAgregar6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        cmbIDTipoPagoAgregar = new javax.swing.JComboBox<>();
        txtTipoPago = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        btnAgregarTipoPago = new javax.swing.JButton();
        btnModificarTipoPago = new javax.swing.JButton();
        btnLimpiar4 = new javax.swing.JButton();
        btnDesactivarTipoPago = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbTipoPago = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        btnAgregar7 = new javax.swing.JButton();
        btnAgregar8 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtNumFacturaRechazo = new javax.swing.JFormattedTextField();
        jLabel26 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbBusquedaRechazar = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbFacturaRechazada = new javax.swing.JTable();
        cmbNombreEmpleado = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtAComentario = new javax.swing.JTextArea();
        jLabel32 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 75, 143));

        tab_Ventas.setBackground(new java.awt.Color(0, 75, 143));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número de Factura", "Fecha", "Cliente", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 171, 1233, 288));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jButton7.setText("Buscar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 112, -1, -1));

        jButton18.setBackground(new java.awt.Color(14, 209, 69));
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        jButton18.setText("Regresar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1191, 612, -1, -1));

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        jButton19.setText("Salir");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1249, 17, -1, -1));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Número de Factura:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 26, -1, -1));

        try {
            txtNumFacturaBusqueda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-##-########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNumFacturaBusqueda.setEnabled(false);
        txtNumFacturaBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumFacturaBusquedaKeyTyped(evt);
            }
        });
        jPanel2.add(txtNumFacturaBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 29, 151, -1));

        chkNumFactura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkNumFacturaItemStateChanged(evt);
            }
        });
        jPanel2.add(chkNumFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 26, -1, -1));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Cliente:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 74, 133, -1));

        txtClienteBusqueda.setEnabled(false);
        txtClienteBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClienteBusquedaKeyTyped(evt);
            }
        });
        jPanel2.add(txtClienteBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 71, 151, -1));

        chkCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkClienteItemStateChanged(evt);
            }
        });
        jPanel2.add(chkCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 68, -1, -1));

        jLabel37.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Reportes");
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 0, -1, 35));

        tab_Ventas.addTab("Reportes", jPanel2);

        jPanel1.setBackground(java.awt.Color.black);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Fecha: ");
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 65, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID Empleado:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 105, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Documento Cliente:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 105, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("VIN:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 285, -1, -1));

        txtNumFactura.setEditable(false);
        jPanel1.add(txtNumFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 62, 102, -1));

        btnImprimirFactura.setBackground(new java.awt.Color(14, 209, 69));
        btnImprimirFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/imprimir1.png"))); // NOI18N
        btnImprimirFactura.setText("Generar");
        btnImprimirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirFacturaActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimirFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 597, -1, -1));

        jButton4.setBackground(new java.awt.Color(14, 209, 69));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        jButton4.setText("Nuevo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 595, -1, 45));

        tbVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Decripcion", "Precio Unit", "Cantidad", "SubTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVenta.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbVenta);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 365, 706, 159));

        jButton16.setBackground(new java.awt.Color(14, 209, 69));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        jButton16.setText("Regresar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1185, 628, -1, -1));

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        jButton17.setText("Salir");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1243, 13, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Número de Factura:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 65, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID Vehiculo:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 245, -1, -1));

        txtVIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVINActionPerformed(evt);
            }
        });
        txtVIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVINKeyTyped(evt);
            }
        });
        jPanel1.add(txtVIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 282, 189, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ID Pieza:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 180, -1, -1));

        txtTotal.setEditable(false);
        txtTotal.setText(" ");
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 566, 116, -1));

        jLabel1.setText("Total:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 569, -1, -1));

        cmbIDEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbIDEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 102, 242, -1));

        btnAgregarPieza.setBackground(new java.awt.Color(14, 209, 69));
        btnAgregarPieza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregarPieza.setText("Agregar Pieza");
        btnAgregarPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPiezaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarPieza, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 317, -1, -1));

        btnAgregarVehiculo.setBackground(new java.awt.Color(14, 209, 69));
        btnAgregarVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregarVehiculo.setText("Agregar Vehiculo");
        btnAgregarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVehiculoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 315, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cantidad:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 285, -1, -1));

        txtCantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 282, 214, -1));

        jButton3.setBackground(new java.awt.Color(14, 209, 69));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancelar.png"))); // NOI18N
        jButton3.setText("Borrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(759, 483, -1, -1));

        txtNombre.setEditable(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 212, 242, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 215, -1, -1));

        txtFecha.setEditable(false);
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 62, 242, -1));

        txtDocumentoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoClienteKeyTyped(evt);
            }
        });
        jPanel1.add(txtDocumentoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 102, 189, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tipo de Factura:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 211, -1, 14));

        cmbTipoFacturaVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbTipoFacturaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 207, 189, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 167, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 232, -1, -1));

        txtIDPieza.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtIDPieza.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDPiezaFocusLost(evt);
            }
        });
        txtIDPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDPiezaActionPerformed(evt);
            }
        });
        txtIDPieza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDPiezaKeyTyped(evt);
            }
        });
        jPanel1.add(txtIDPieza, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 177, 242, -1));

        txtIDVehiculo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtIDVehiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDVehiculoKeyTyped(evt);
            }
        });
        jPanel1.add(txtIDVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 242, 189, -1));

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("CAI:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 140, -1, -1));

        lCAI.setForeground(new java.awt.Color(255, 255, 255));
        lCAI.setText("000000-000000-000000-000000-00000-00");
        jPanel1.add(lCAI, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 140, -1, -1));

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Forma de Pago:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 134, -1, -1));

        cmbTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Efectivo", "Tarjeta", "Financiación" }));
        cmbTipoPago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoPagoItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbTipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 131, 189, -1));

        jLabel23.setText("ISV 18%:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 537, -1, -1));

        txtImpuesto.setEditable(false);
        jPanel1.add(txtImpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 531, 116, -1));

        ltarjeta.setForeground(new java.awt.Color(255, 255, 255));
        ltarjeta.setText("Tarjeta:");
        jPanel1.add(ltarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 180, -1, -1));

        txtTarjeta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtTarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTarjetaKeyTyped(evt);
            }
        });
        jPanel1.add(txtTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 177, 189, -1));

        jLabel36.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Ventas");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(599, 0, -1, 35));

        tab_Ventas.addTab("Ventas ", jPanel1);

        jPanel3.setBackground(new java.awt.Color(0, 75, 143));
        jPanel3.setForeground(new java.awt.Color(0, 75, 143));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegresar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar2.setText("Regresar");
        btnRegresar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegresar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1193, 635, -1, -1));

        btnSalir2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir2.setText("Salir");
        btnSalir2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1253, 15, -1, -1));

        tblNuevoCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Tipo de Factura", "Tipo de Factura", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNuevoCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNuevoCargoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblNuevoCargoMouseEntered(evt);
            }
        });
        jScrollPane5.setViewportView(tblNuevoCargo);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 274, 682, 203));

        btnAgregar2.setBackground(new java.awt.Color(14, 209, 69));
        btnAgregar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar2.setText("Agregar");
        btnAgregar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 195, -1, -1));

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Tipo de Factura:");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 151, 104, 23));

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("ID de Factura:");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 110, 104, 23));

        cmbIDNuevoFactura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDNuevoFacturaItemStateChanged(evt);
            }
        });
        jPanel3.add(cmbIDNuevoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 110, 93, -1));

        txtTipoFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoFacturaKeyTyped(evt);
            }
        });
        jPanel3.add(txtTipoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 151, 93, -1));

        btnModificar2.setBackground(new java.awt.Color(14, 209, 69));
        btnModificar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar2.setText("Modificar");
        btnModificar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnModificar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 192, -1, -1));

        btnLimpiar2.setBackground(new java.awt.Color(14, 209, 69));
        btnLimpiar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar2.setText("Limpiar");
        btnLimpiar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnLimpiar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 192, -1, 41));

        btnDesactivar3.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar3.setText("Desactivar");
        btnDesactivar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar3ActionPerformed(evt);
            }
        });
        jPanel3.add(btnDesactivar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 193, -1, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Ingresar Nuevo Tipo de Factura");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 13, -1, 35));

        btnAgregar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        btnAgregar3.setText("Generar Reporte Excel");
        btnAgregar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar3ActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 522, -1, -1));

        btnAgregar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        btnAgregar4.setText("Generar Reporte PDF");
        btnAgregar4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar4ActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 522, -1, -1));

        tab_Ventas.addTab("Tipo de Factura", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 75, 143));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        try {
            txtDe.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-##-########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDeKeyTyped(evt);
            }
        });
        jPanel4.add(txtDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 61, 157, -1));

        try {
            txtHasta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-##-########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHastaKeyTyped(evt);
            }
        });
        jPanel4.add(txtHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 91, 204, -1));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("CAI:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 59, 116, 20));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Fecha de Inicio:");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 93, 116, 20));

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Fecha de Finalización:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 127, 116, 20));

        txtCAI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCAIKeyTyped(evt);
            }
        });
        jPanel4.add(txtCAI, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 58, 248, -1));

        txtFechaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaInicioActionPerformed(evt);
            }
        });
        txtFechaInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaInicioKeyTyped(evt);
            }
        });
        jPanel4.add(txtFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 92, 209, -1));

        txtFechaFinalizacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtFechaFinalizacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaFinalizacionKeyTyped(evt);
            }
        });
        jPanel4.add(txtFechaFinalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 127, 205, -1));

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Desde:");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 61, 59, 19));

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Hasta:");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 92, 59, 20));

        tbCAI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CAI", "Fecha de Inicio", "Fecha Límite", "Desde", "Hasta", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCAI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCAIMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCAI);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 297, 1212, 126));

        jButton1.setBackground(new java.awt.Color(14, 209, 69));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 214, -1, -1));

        btnModificar3.setBackground(new java.awt.Color(14, 209, 69));
        btnModificar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar3.setText("Modificar");
        btnModificar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar3ActionPerformed(evt);
            }
        });
        jPanel4.add(btnModificar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 215, -1, -1));

        btnLimpiar3.setBackground(new java.awt.Color(14, 209, 69));
        btnLimpiar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar3.setText("Limpiar");
        btnLimpiar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar3ActionPerformed(evt);
            }
        });
        jPanel4.add(btnLimpiar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 215, -1, 41));

        btnDesactivar4.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar4.setText("Desactivar");
        btnDesactivar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar4ActionPerformed(evt);
            }
        });
        jPanel4.add(btnDesactivar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 216, -1, -1));

        jLabel33.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Ingresar Nuevo CAI");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(708, 6, -1, 35));

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        jButton20.setText("Salir");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1257, 7, -1, -1));

        jButton21.setBackground(new java.awt.Color(14, 209, 69));
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        jButton21.setText("Regresar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1199, 625, -1, -1));

        ltrampa.setText("00");
        jPanel4.add(ltrampa, new org.netbeans.lib.awtextra.AbsoluteConstraints(751, 94, -1, -1));

        btnAgregar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        btnAgregar5.setText("Generar Reporte PDF");
        btnAgregar5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar5ActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 454, -1, -1));

        btnAgregar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        btnAgregar6.setText("Generar Reporte Excel");
        btnAgregar6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar6ActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 454, -1, -1));

        tab_Ventas.addTab("CAI", jPanel4);

        jPanel6.setBackground(new java.awt.Color(0, 75, 143));

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("ID de Tipo de Pago:");

        cmbIDTipoPagoAgregar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDTipoPagoAgregarItemStateChanged(evt);
            }
        });

        txtTipoPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoPagoKeyTyped(evt);
            }
        });

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Tipo de Pago:");

        btnAgregarTipoPago.setBackground(new java.awt.Color(14, 209, 69));
        btnAgregarTipoPago.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregarTipoPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregarTipoPago.setText("Agregar");
        btnAgregarTipoPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarTipoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTipoPagoActionPerformed(evt);
            }
        });

        btnModificarTipoPago.setBackground(new java.awt.Color(14, 209, 69));
        btnModificarTipoPago.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificarTipoPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificarTipoPago.setText("Modificar");
        btnModificarTipoPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarTipoPago.setEnabled(false);
        btnModificarTipoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarTipoPagoActionPerformed(evt);
            }
        });

        btnLimpiar4.setBackground(new java.awt.Color(14, 209, 69));
        btnLimpiar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar4.setText("Limpiar");
        btnLimpiar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar4ActionPerformed(evt);
            }
        });

        btnDesactivarTipoPago.setBackground(new java.awt.Color(14, 209, 69));
        btnDesactivarTipoPago.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivarTipoPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivarTipoPago.setText("Desactivar");
        btnDesactivarTipoPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivarTipoPago.setEnabled(false);
        btnDesactivarTipoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarTipoPagoActionPerformed(evt);
            }
        });

        tbTipoPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Tipo de Pago", "Tipo de Pago", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTipoPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTipoPagoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbTipoPagoMouseEntered(evt);
            }
        });
        jScrollPane6.setViewportView(tbTipoPago);

        jLabel34.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Ingresar Nuevo Tipo de Pago");

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        jButton22.setText("Salir");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(14, 209, 69));
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        jButton23.setText("Regresar");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        btnAgregar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        btnAgregar7.setText("Generar Reporte PDF");
        btnAgregar7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar7ActionPerformed(evt);
            }
        });

        btnAgregar8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        btnAgregar8.setText("Generar Reporte Excel");
        btnAgregar8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton23))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(btnAgregarTipoPago)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnModificarTipoPago)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnLimpiar4))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(cmbIDTipoPagoAgregar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDesactivarTipoPago))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(btnAgregar7)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAgregar8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 540, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel34)
                                .addGap(307, 307, 307)))
                        .addComponent(jButton22)))
                .addGap(19, 19, 19))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbIDTipoPagoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnAgregarTipoPago))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificarTipoPago)
                            .addComponent(btnLimpiar4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivarTipoPago))))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar7)
                    .addComponent(btnAgregar8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(jButton23)
                .addGap(397, 397, 397))
        );

        tab_Ventas.addTab("Tipo de Pago", jPanel6);

        jPanel5.setBackground(new java.awt.Color(0, 75, 143));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Número de Factura:");

        try {
            txtNumFacturaRechazo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-##-########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNumFacturaRechazo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumFacturaRechazoKeyTyped(evt);
            }
        });

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Nombre del Empleado:");

        jButton2.setBackground(new java.awt.Color(14, 209, 69));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tbBusquedaRechazar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num. Factura", "Fecha", "Empleado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbBusquedaRechazar.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tbBusquedaRechazar);

        jButton5.setBackground(new java.awt.Color(14, 209, 69));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancelar.png"))); // NOI18N
        jButton5.setText("Rechazar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tbFacturaRechazada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num Factura", "Fecha", "Estado", "Decripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFacturaRechazada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFacturaRechazadaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbFacturaRechazada);

        cmbNombreEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtAComentario.setColumns(20);
        txtAComentario.setRows(5);
        jScrollPane8.setViewportView(txtAComentario);

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Comentario:");

        jLabel35.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Ingresar Nuevo Tipo de Pago");

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        jButton24.setText("Salir");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(14, 209, 69));
        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        jButton25.setText("Regresar");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumFacturaRechazo, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(cmbNombreEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(119, 119, 119)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(300, 300, 300))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton25))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(404, 404, 404)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton24)))
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtNumFacturaRechazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(cmbNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)))
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton25)
                .addContainerGap(400, Short.MAX_VALUE))
        );

        tab_Ventas.addTab("Facturas Rechazadas", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tab_Ventas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab_Ventas)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int btnDesactivar3ActionPerfomedTest(int cmbIDNuevoFactura){
        TipoFactura temp;
        temp = tipoFacturaDao.findTipoFactura(cmbIDNuevoFactura);
        if(temp.getEstado()){
            temp.setEstado(false);
//            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
//            JOptionPane.showMessageDialog(null,"Tipo de Factura Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
//            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
//            JOptionPane.showMessageDialog(null,"Tipo de Factura Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        try {
           // tipoFacturaDao.edit(temp);
        } catch (Exception ex) {
           // Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
//        this.createTbTipoFactura();
//        
//        btnActivarDesactivar();
//        
//        limpiarTipoFactura();
//        //this.limpiarPieza();
//        
//        this.createCmbTipoFactura();
//        
//        btnDesactivar3.setEnabled(false);
//        btnAgregar2.setEnabled(true);
//        btnModificar3.setEnabled(false);
    return 100;
    }
    
    private void btnDesactivar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar3ActionPerformed
        try{
        TipoFactura temp;
        temp = tipoFacturaDao.findTipoFactura(cmbIDNuevoFactura.getSelectedIndex());
        if(temp.getEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Tipo de Factura Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Tipo de Factura Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
      
            tipoFacturaDao.edit(temp);
        
        this.createTbTipoFactura();
        
        btnActivarDesactivar();
        
        limpiarTipoFactura();
        //this.limpiarPieza();
        
        this.createCmbTipoFactura();
        
        btnDesactivar3.setEnabled(false);
        btnAgregar2.setEnabled(true);
        btnModificar3.setEnabled(false);
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoFacturaDesactivar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnDesactivar3ActionPerformed

    private void limpiarTipoFactura(){
        cmbIDNuevoFactura.setSelectedIndex(0);
        txtTipoFactura.setText("");
        btnAgregar2.setEnabled(true);
                    btnModificar2.setEnabled(false);
                    btnDesactivar3.setEnabled(false);
    }
    
    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        try{
        limpiarTipoFactura();
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoFacturaLimpiar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    public int btnModificar2ActionPerfomed(int cmbIDNuevoFactura,String txtTipoFactura){
        if(cmbIDNuevoFactura==0){
            JOptionPane.showMessageDialog(null, "Tipo de pieza no encontrado");
            return 0;
        }
        else{
            if("".equals(txtTipoFactura)){
                JOptionPane.showMessageDialog(null, "Tipo de Pieza no puede ir vacio");
                return 0;
            }
            else{
                Validaciones temp = new Validaciones();
                if(temp.validacionTresLetras(txtTipoFactura)){
                JOptionPane.showMessageDialog(null, "Tipo de Factura Invalido","ERROR",0);
                return 0;
                }
                else{
                
                }
                
                if(!Validaciones.ValidacionNombreMayusculaYDemasMinus(txtTipoFactura)){
                JOptionPane.showMessageDialog(null,"El Tipo de Factura debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
                //txtTipoFactura.requestFocus();
                return 0;
                }else{

                }
                int i;
                boolean flag=false;
                for(i=0;i<tipoFacturaDao.findTipoFacturaEntities().size();i++){
                    //System.out.println(i);
                if(txtTipoFactura.toLowerCase().equals(tipoFacturaDao.findTipoFactura(i+1).getTipoFactura())){
                    //JOptionPane.showMessageDialog(null, "Ya existe este tipo de Factura registrada en el sistema");
                    flag=true;
                    return 100;
                } else {
                }
            }
                if(flag){
                    return 0;
                }
                else{
                    TipoFactura e1;
                    e1=tipoFacturaDao.findTipoFactura(cmbIDNuevoFactura);
                    e1.setTipoFactura(txtTipoFactura);
                    try {
                        tipoFacturaDao.edit(e1);
                    } catch (Exception ex) {
                        Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }  
        } 
//                cmbIDNuevoFactura.setSelectedIndex(1);
//                cmbIDNuevoFactura.setSelectedIndex(0);
//                Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
//                    JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
        
        
        
        
        return 100;
        
        
//        this.limpiarTipoFactura();
//        createTbTipoFactura();
//        createCmbTipoFactura();
    }
    
    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed
        try{
        if(cmbIDNuevoFactura.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Tipo de pieza no encontrado");
            return;
        }
        else{
            if("".equals(txtTipoFactura.getText())){
                JOptionPane.showMessageDialog(null, "Tipo de Pieza no puede ir vacio");
                return;
            }
            else{
                Validaciones temp = new Validaciones();
                if(temp.validacionTresLetras(txtTipoFactura.getText())){
                JOptionPane.showMessageDialog(null, "Tipo de Factura Invalido","ERROR",0);
                return;
                }
                else{
                
                }
                
                if(!Validaciones.ValidacionNombreMayusculaYDemasMinus(txtTipoFactura.getText())){
                JOptionPane.showMessageDialog(null,"El Tipo de Factura debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
                txtTipoFactura.requestFocus();
                return;
                }else{

                }
                int i;
                boolean flag=false;
                for(i=0;i<tipoFacturaDao.findTipoFacturaEntities().size();i++){
                    //System.out.println(i);
                if(txtTipoFactura.getText().toLowerCase().equals(tipoFacturaDao.findTipoFactura(i+1).getTipoFactura())){
                    JOptionPane.showMessageDialog(null, "Ya existe este tipo de Factura registrada en el sistema");
                    flag=true;
                    return;
                } else {
                }
            }
                if(flag){
                    return;
                }
                else{
                    TipoFactura e1;
                    e1=tipoFacturaDao.findTipoFactura(cmbIDNuevoFactura.getSelectedIndex());
                    e1.setTipoFactura(txtTipoFactura.getText());
                    try {
                        tipoFacturaDao.edit(e1);
                    } catch (Exception ex) {
                        Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }  
        } 
                cmbIDNuevoFactura.setSelectedIndex(1);
                cmbIDNuevoFactura.setSelectedIndex(0);
                Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
                    JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
        
        
        
        
        
        
        
        this.limpiarTipoFactura();
        createTbTipoFactura();
        createCmbTipoFactura();
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoFacturaModificar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnModificar2ActionPerformed

    private void txtTipoFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoFacturaKeyTyped

        char c = evt.getKeyChar();
        String Texto = txtTipoFactura.getText();

        if((c < 'A' || c > 'Z') && (c < 'a' || c > 'z')&& (c!=KeyEvent.VK_SPACE))
        {            
            evt.consume();
        }
              
        if (txtTipoFactura.getText().length() >= 10)
        {
            evt.consume();        
        }
    
        /*if((evt.getKeyChar() == 22))
        {
            txtTipoFactura.setText(Texto.substring(0, 20));                    
        }*/
          
        if (txtTipoFactura.getText().length() == 1)
        {          
            char mayuscula = Texto.charAt(0);
            Texto = Character.toUpperCase(mayuscula)+ Texto.substring(1,Texto.length());
            txtTipoFactura.setText(Texto);
        }

        
    }//GEN-LAST:event_txtTipoFacturaKeyTyped

    private void cmbIDNuevoFacturaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDNuevoFacturaItemStateChanged
        if(cmbIDNuevoFactura.getSelectedIndex()==0){
            txtTipoFactura.setText("");
            btnDesactivar3.setEnabled(false);

        }
        else{
            TipoFactura temp = tipoFacturaDao.findTipoFactura(cmbIDNuevoFactura.getSelectedIndex());
            txtTipoFactura.setText(temp.getTipoFactura());
            btnActivarDesactivar();
            
        }
    }//GEN-LAST:event_cmbIDNuevoFacturaItemStateChanged
 private void btnActivarDesactivar(){
        TipoFactura temp;
        temp = tipoFacturaDao.findTipoFactura(cmbIDNuevoFactura.getSelectedIndex());
        
        if(temp.getEstado()){
        btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar3.setText("Desactivar");  
        btnDesactivar3.setEnabled(true);
        }
        else{
            btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png"))); // NOI18N
            btnDesactivar3.setText("Activar");
            btnDesactivar3.setEnabled(true);
        }
    }
    
    public int btnAgregar2ActionPerfomed(int cmbIDNuevoFactura,String txtTipoFactura){
        if(cmbIDNuevoFactura==0){
                
            }
            else{
                return 0;
            }
            Validaciones temp = new Validaciones();
            
            if(txtTipoFactura.length()<2){
                JOptionPane.showMessageDialog(null,"Campo insuficiente, debe tener mínimo 3 caracteres","INSUFICIENTE",0);
                return 0;
            }
            else{
                
            }
            
            
            if(temp.validacionTresLetras(txtTipoFactura)){
                JOptionPane.showMessageDialog(null, "Tipo de Factura Invalido","ERROR",0);
                return 0;
            }
            else{
                
            }
            
            if (!Validaciones.ValidacionNombreMayusculaYDemasMinus(txtTipoFactura)){
                JOptionPane.showMessageDialog(null,"El Tipo de Factura debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
//                txtTipoFactura.requestFocus();
                return 0;
            }else{

            }
            
            
            TipoFactura temp2 = new TipoFactura();
            temp2.setEstado(true);
            temp2.setTipoFactura(txtTipoFactura);
            //temp2.setIDtipofactura(tipoFacturaDao.getTipoFacturaCount()+1);
            
            tipoFacturaDao.create(temp2);
            
//            createTbTipoFactura();
//            createCmbTipoFactura();
//            tab_Ventas.setSelectedIndex(1);
//            createCmbTipoFacturaVenta();
//            tab_Ventas.setSelectedIndex(2);
//            Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
//                JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
//            
//            this.limpiarTipoFactura();
            return 100;
    }
 
    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
            
        try{
            if(cmbIDNuevoFactura.getSelectedIndex()==0){
                
            }
            else{
                cmbIDNuevoFactura.setSelectedIndex(0);
            }
            Validaciones temp = new Validaciones();
            
            if(txtTipoFactura.getText().length()<2){
                JOptionPane.showMessageDialog(null,"Campo insuficiente, debe tener mínimo 3 caracteres","INSUFICIENTE",0);
                return;
            }
            else{
                
            }
            
            
            if(temp.validacionTresLetras(txtTipoFactura.getText())){
                JOptionPane.showMessageDialog(null, "Tipo de Factura Invalido","ERROR",0);
                return;
            }
            else{
                
            }
            
            if (!Validaciones.ValidacionNombreMayusculaYDemasMinus(txtTipoFactura.getText())){
                JOptionPane.showMessageDialog(null,"El Tipo de Factura debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
                txtTipoFactura.requestFocus();
                return;
            }else{

            }
            
            
            TipoFactura temp2 = new TipoFactura();
            temp2.setEstado(true);
            temp2.setTipoFactura(txtTipoFactura.getText());
            //temp2.setIDtipofactura(tipoFacturaDao.getTipoFacturaCount()+1);
            
            tipoFacturaDao.create(temp2);
            
            createTbTipoFactura();
            createCmbTipoFactura();
            tab_Ventas.setSelectedIndex(1);
            createCmbTipoFacturaVenta();
            tab_Ventas.setSelectedIndex(2);
            Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
                JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
            
            this.limpiarTipoFactura();
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoFactura"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void crearCmbIDTipoFactura(){
        DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
        cmbIDNuevoFactura.setModel(modelo1);
        modelo1.addElement("Nuevo");
        
        List<TipoFactura> temp = tipoFacturaDao.findTipoFacturaEntities();
        for(TipoFactura e : temp){
            modelo1.addElement(e.getIDtipofactura());
        }
    }
    
    private void tblNuevoCargoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNuevoCargoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblNuevoCargoMouseEntered

    private void tblNuevoCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNuevoCargoMouseClicked
        btnAgregar2.setEnabled(false);
        btnModificar2.setEnabled(true);
        btnDesactivar3.setEnabled(true);
        int column=0;
        int fila = tblNuevoCargo.getSelectedRow();
        if (fila > -1){
            cmbIDNuevoFactura.setSelectedIndex(Integer.parseInt(tblNuevoCargo.getModel().getValueAt(fila, column).toString()));
            txtTipoFactura.setText(String.valueOf(tblNuevoCargo.getValueAt(fila, ++column)));
           // btnActivarDesactivarCargo();
        }
    }//GEN-LAST:event_tblNuevoCargoMouseClicked

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void btnRegresar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar2ActionPerformed

        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar2ActionPerformed

    private void btnAgregarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVehiculoActionPerformed
        // TODO add your handling code here:
        try{
        crearTbVentaAgregarVehiculo();
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"FacturaAgregarVehiculo"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgregarVehiculoActionPerformed

    private void btnAgregarPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPiezaActionPerformed
        try{
        crearTbVentaAgregarPieza();
        limpiarPieza();
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(FrmPieza.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"FacturaAgregarPieza"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarPiezaActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        System.exit(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed

        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    public int imprimirFacturaBusquedaTest(Factura f) throws JRException{
        Object [][] arrayDetallesFactura;
        int contador = 0;
        List<PiezaFactura> arregloPiezas = new ArrayList<>();
        List<VehiculoFactura> arregloVehiculos = new ArrayList<>();
        
        List<PiezaFactura> piezaFTemp = piezaFacturaDao.findPiezaFacturaEntities();
        for(PiezaFactura pf : piezaFTemp){
            if(pf.getIdFactura()==f.getIDFactura()){
                arregloPiezas.add(pf);
                contador++;
            }
        }
        List<VehiculoFactura> vehiculoFTemp = vehiculoFacturaDao.findVehiculoFacturaEntities();
        for(VehiculoFactura vF : vehiculoFTemp){
            if(vF.getIdFactura()==f.getIDFactura()){
                arregloVehiculos.add(vF);
                contador++;
            }
        }
        
        
        
        
        
        arrayDetallesFactura = new Object[contador][5];
        double containerPrecio = 0;
        double containerImpuesto = 0;
        
        for(int i = 0;i<arregloPiezas.size();i++){
            arrayDetallesFactura[i][0]=(i+1);
            arrayDetallesFactura[i][1]=piezaDao.findPieza(arregloPiezas.get(i).getIdPieza()).getNombre()+piezaDao.findPieza(arregloPiezas.get(i).getIdPieza()).getCarateristica_Pieza();
            //arrayDetallesFactura[i][2]
            List<HistoricoPrecioPieza> temporalHPP=historicoPiezaDao.findHistoricoPrecioPiezaEntities();
            for(HistoricoPrecioPieza htp : temporalHPP){
                if(htp.getIdPieza()==arregloPiezas.get(i).getIdPieza() && htp.getFechaFinal()!=null){
                    LocalDate auxFechaInicial = LocalDate.parse(htp.getFechaInicial());
                    LocalDate auxFechaFinal = LocalDate.parse(htp.getFechaFinal());
                    LocalDate auxFechaEmision = LocalDate.parse(f.getFechaHora().substring(0, 10));
                    if(auxFechaEmision.isAfter(auxFechaInicial) && auxFechaEmision.isBefore(auxFechaFinal)){
                        arrayDetallesFactura[i][2]=String.valueOf(htp.getPrecio());
                        break;
                    }
                                        
                }
                else{
                        arrayDetallesFactura[i][2]=String.valueOf(htp.getPrecio());
                        break;
                }
                
                
            }
            
            //Fin de array para precio
            arrayDetallesFactura[i][3]=String.valueOf(arregloPiezas.get(i).getCantidad());
            arrayDetallesFactura[i][4]=String.valueOf(Double.parseDouble(String.valueOf(arrayDetallesFactura[i][2]))*arregloPiezas.get(i).getCantidad());
            containerPrecio += Double.parseDouble(String.valueOf(arrayDetallesFactura[i][4]));
            containerImpuesto += Double.parseDouble(String.valueOf(arrayDetallesFactura[i][4]))*0.18;
        }
        
        for(int i = 0;i<arregloVehiculos.size();i++){
            arrayDetallesFactura[i][0]=arregloVehiculos.get(i).getIdVehiculo();
            arrayDetallesFactura[i][1]=arregloVehiculos.get(i).getCantidad()+" "+Marcadao.findMarca(vehiculoDao.findVehiculo(arregloVehiculos.get(i).getIdVehiculo()).getId_marca()).getMarca();
            //arrayDetallesFactura[i][2]
            List<HistoricoPrecioVehiculos> temporalHPV=historicoVehiculoDao.findHistoricoPrecioVehiculosEntities();
            for(HistoricoPrecioVehiculos htp : temporalHPV){
                if(htp.getId_vehiculo()==arregloVehiculos.get(i).getIdVehiculo() && htp.getFechaFinal()!=null){
                    LocalDate auxFechaInicial = LocalDate.parse(htp.getFechaInicial());
                    LocalDate auxFechaFinal = LocalDate.parse(htp.getFechaFinal());
                    LocalDate auxFechaEmision = LocalDate.parse(f.getFechaHora().substring(0, 10));
                    if(auxFechaEmision.isAfter(auxFechaInicial) && auxFechaEmision.isBefore(auxFechaFinal)){
                        arrayDetallesFactura[i][2]=String.valueOf(htp.getPrecio());
                        //JOptionPane.showMessageDialog(null,"");
                        break;
                    }
                                        
                }
                else{
                        arrayDetallesFactura[i][2]=String.valueOf(htp.getPrecio());
                        break;
                }
                
                
            }
            
            //Fin de array para precio
            arrayDetallesFactura[i][3]=String.valueOf(1);
            arrayDetallesFactura[i][4]=String.valueOf(Double.parseDouble(String.valueOf(arrayDetallesFactura[i][2]))*1);
            containerPrecio += Double.parseDouble(String.valueOf(arrayDetallesFactura[i][4]));
            containerImpuesto += Double.parseDouble(String.valueOf(arrayDetallesFactura[i][4]))*0.18;
            
        }
        
        
        
       /* for(int i = 0;i<contador;i++){
            
                    arrayDetallesFactura[i][0]=tbVenta.getValueAt(i,0);
                    arrayDetallesFactura[i][1]=tbVenta.getValueAt(i, 1);
                    arrayDetallesFactura[i][2]=tbVenta.getValueAt(i, 2);
                    arrayDetallesFactura[i][3]=tbVenta.getValueAt(i,3);
                    arrayDetallesFactura[i][4]=tbVenta.getValueAt(i, 4);
                    
                
        }*/
                //JOptionPane.showMessageDialog(null, arrayDetallesFactura[0][1]);
        
        
        
        Empleado e = empleadoDao.findEmpleado(f.getIdEmpleado());
        Persona pp = personaDao.findPersona(e.getId_Persona());
        RazonSocial rs = razonSocialDao.findRazonSocial(f.getIdRazonSocial());
        informacionFiscal iF = infFiscalDao.findinformacionFiscal(f.getIdInf());
        Cliente c = clienteDao.findCliente(f.getIdCliente());
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#,###,##0.00", separadoresPersonalizados);
        
        HashMap param = new HashMap();
        param.put("numFactura", f.getNumFactura());
        param.put("Empleado",pp.getNombre()+" "+pp.getApellido());
        param.put("fechaHora",f.getFechaHora());
        param.put("impuesto", String.valueOf(containerImpuesto));
        param.put("total",String.valueOf(containerImpuesto+containerPrecio));
        param.put("rtnvendedor",rs.getRtn());
        param.put("cai", iF.getCai());
        param.put("tipopago",tipoPagoDao.findTipoPago(f.getIdTipoPago()).getNombre());
        param.put("limite",(iF.getFechaFinal().substring(8, 10)+"/"+iF.getFechaFinal().substring(5, 7)+"/"+iF.getFechaFinal().substring(0, 4)));
        
        
        param.put("monto",formato1.format(f.getCantidadPago()) );
        
        pp = personaDao.findPersona(c.getId_Persona()); // En caso de que no salga declara una persona distinta
        
        param.put("cliente", pp.getNombre()+" "+pp.getApellido());
        param.put("documento",pp.getDocumento_id());
        
        
        
            JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Factura.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,FacturaJRADATASOURCE.getDataSource(arrayDetallesFactura));
            
            //JasperRunManager.runReportToPdf(reporteFactura, param);
            
            JasperViewer view = new JasperViewer(print, false);
            //view.setVisible(true);
           // view.setTitle("Factura" + Integer.parseInt("1"));
            return 100;
    }
    
    private void imprimirFacturaBusqueda(Factura f) throws JRException{
        Object [][] arrayDetallesFactura;
        int contador = 0;
        List<PiezaFactura> arregloPiezas = new ArrayList<>();
        List<VehiculoFactura> arregloVehiculos = new ArrayList<>();
        
        List<PiezaFactura> piezaFTemp = piezaFacturaDao.findPiezaFacturaEntities();
        for(PiezaFactura pf : piezaFTemp){
            if(pf.getIdFactura()==f.getIDFactura()){
                arregloPiezas.add(pf);
                contador++;
            }
        }
        List<VehiculoFactura> vehiculoFTemp = vehiculoFacturaDao.findVehiculoFacturaEntities();
        for(VehiculoFactura vF : vehiculoFTemp){
            if(vF.getIdFactura()==f.getIDFactura()){
                arregloVehiculos.add(vF);
                contador++;
            }
        }
        
        
        
        
        
        arrayDetallesFactura = new Object[contador][5];
        double containerPrecio = 0;
        double containerImpuesto = 0;
        
        for(int i = 0;i<arregloPiezas.size();i++){
            arrayDetallesFactura[i][0]=(i+1);
            arrayDetallesFactura[i][1]=piezaDao.findPieza(arregloPiezas.get(i).getIdPieza()).getNombre()+piezaDao.findPieza(arregloPiezas.get(i).getIdPieza()).getCarateristica_Pieza();
            //arrayDetallesFactura[i][2]
            List<HistoricoPrecioPieza> temporalHPP=historicoPiezaDao.findHistoricoPrecioPiezaEntities();
            for(HistoricoPrecioPieza htp : temporalHPP){
                if(htp.getIdPieza()==arregloPiezas.get(i).getIdPieza() && htp.getFechaFinal()!=null){
                    LocalDate auxFechaInicial = LocalDate.parse(htp.getFechaInicial());
                    LocalDate auxFechaFinal = LocalDate.parse(htp.getFechaFinal());
                    LocalDate auxFechaEmision = LocalDate.parse(f.getFechaHora().substring(0, 10));
                    if(auxFechaEmision.isAfter(auxFechaInicial) && auxFechaEmision.isBefore(auxFechaFinal)){
                        arrayDetallesFactura[i][2]=String.valueOf(htp.getPrecio());
                        break;
                    }
                                        
                }
                else{
                        arrayDetallesFactura[i][2]=String.valueOf(htp.getPrecio());
                        break;
                }
                
                
            }
            
            //Fin de array para precio
            arrayDetallesFactura[i][3]=String.valueOf(arregloPiezas.get(i).getCantidad());
            arrayDetallesFactura[i][4]=String.valueOf(Double.parseDouble(String.valueOf(arrayDetallesFactura[i][2]))*arregloPiezas.get(i).getCantidad());
            containerPrecio += Double.parseDouble(String.valueOf(arrayDetallesFactura[i][4]));
            containerImpuesto += Double.parseDouble(String.valueOf(arrayDetallesFactura[i][4]))*0.18;
        }
        
        for(int i = 0;i<arregloVehiculos.size();i++){
            arrayDetallesFactura[i+arregloPiezas.size()][0]=arregloVehiculos.get(i).getIdVehiculo();
            arrayDetallesFactura[i+arregloPiezas.size()][1]=arregloVehiculos.get(i).getCantidad()+" "+Marcadao.findMarca(vehiculoDao.findVehiculo(arregloVehiculos.get(i).getIdVehiculo()).getId_marca()).getMarca();
            //arrayDetallesFactura[i][2]
            List<HistoricoPrecioVehiculos> temporalHPV=historicoVehiculoDao.findHistoricoPrecioVehiculosEntities();
            for(HistoricoPrecioVehiculos htp : temporalHPV){
                if(htp.getId_vehiculo()==arregloVehiculos.get(i).getIdVehiculo() && htp.getFechaFinal()!=null){
                    LocalDate auxFechaInicial = LocalDate.parse(htp.getFechaInicial());
                    LocalDate auxFechaFinal = LocalDate.parse(htp.getFechaFinal());
                    LocalDate auxFechaEmision = LocalDate.parse(f.getFechaHora().substring(0, 10));
                    if(auxFechaEmision.isAfter(auxFechaInicial) && auxFechaEmision.isBefore(auxFechaFinal)){
                        arrayDetallesFactura[i][2]=String.valueOf(htp.getPrecio());
                        //JOptionPane.showMessageDialog(null,"");
                        break;
                    }
                                        
                }
                else{
                        arrayDetallesFactura[i+arregloPiezas.size()][2]=String.valueOf(htp.getPrecio());
                        break;
                }
                
                
            }
            
            //Fin de array para precio
            arrayDetallesFactura[i+arregloPiezas.size()][3]=String.valueOf(1);
            arrayDetallesFactura[i+arregloPiezas.size()][4]=String.valueOf(Double.parseDouble(String.valueOf(arrayDetallesFactura[i+arregloPiezas.size()][2]))*1);
            containerPrecio += Double.parseDouble(String.valueOf(arrayDetallesFactura[i+arregloPiezas.size()][4]));
            containerImpuesto += Double.parseDouble(String.valueOf(arrayDetallesFactura[i+arregloPiezas.size()][4]))*0.18;
            
        }
        
        
        
       /* for(int i = 0;i<contador;i++){
            
                    arrayDetallesFactura[i][0]=tbVenta.getValueAt(i,0);
                    arrayDetallesFactura[i][1]=tbVenta.getValueAt(i, 1);
                    arrayDetallesFactura[i][2]=tbVenta.getValueAt(i, 2);
                    arrayDetallesFactura[i][3]=tbVenta.getValueAt(i,3);
                    arrayDetallesFactura[i][4]=tbVenta.getValueAt(i, 4);
                    
                
        }*/
                //JOptionPane.showMessageDialog(null, arrayDetallesFactura[0][1]);
        
        
        
        Empleado e = empleadoDao.findEmpleado(f.getIdEmpleado());
        Persona pp = personaDao.findPersona(e.getId_Persona());
        RazonSocial rs = razonSocialDao.findRazonSocial(f.getIdRazonSocial());
        informacionFiscal iF = infFiscalDao.findinformacionFiscal(f.getIdInf());
        Cliente c = clienteDao.findCliente(f.getIdCliente());
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#,###,##0.00", separadoresPersonalizados);
        
        HashMap param = new HashMap();
        param.put("numFactura", f.getNumFactura());
        param.put("Empleado",pp.getNombre()+" "+pp.getApellido());
        param.put("fechaHora",f.getFechaHora());
        param.put("impuesto", String.valueOf(containerImpuesto));
        param.put("total",String.valueOf(containerImpuesto+containerPrecio));
        param.put("rtnvendedor",rs.getRtn());
        param.put("cai", iF.getCai());
        param.put("tipopago",tipoPagoDao.findTipoPago(f.getIdTipoPago()).getNombre());
        param.put("limite",(iF.getFechaFinal().substring(8, 10)+"/"+iF.getFechaFinal().substring(5, 7)+"/"+iF.getFechaFinal().substring(0, 4)));
        
        
        param.put("monto",formato1.format(f.getCantidadPago()) );
        
        pp = personaDao.findPersona(c.getId_Persona()); // En caso de que no salga declara una persona distinta
        
        param.put("cliente", pp.getNombre()+" "+pp.getApellido());
        param.put("documento",pp.getDocumento_id());
        
        
        
            JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Factura.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,FacturaJRADATASOURCE.getDataSource(arrayDetallesFactura));
            
            //JasperRunManager.runReportToPdf(reporteFactura, param);
            
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
            view.setTitle("Factura" + Integer.parseInt("1"));
    }
    
    public int btnImprimirFacturaActionPerfomedTest(int cmbIDEmpleado,String cmbTipoPago,String txtDocumentoCliente,int cmbTipoFacturaVenta){
        
        
        
        
        if(cmbIDEmpleado==0){
            return 0;
        }

        if(txtDocumentoCliente.equals("")){
            return 0;
        }

        if(cmbTipoFacturaVenta==0){
            return 0;
        }
        
        /*if(cmbTipoPago.getSelectedIndex()==0){
            return 0;
        }*/
        if(cmbTipoPago.toLowerCase().equals("tarjeta") ||cmbTipoPago.toLowerCase().equals("mixto")){
            if(txtTarjeta.getText().equals("")){
                return 0;
            }
            if(Validaciones.validacionTarjetas(txtTarjeta.getText())){
                
            }
            else{
                //JOptionPane.showMessageDialog(null,"Número de Tarjeta no Valido", "TARJETA INVALIDA",0);
                return 0;
            }
        }
        
        List<Persona> temp = personaDao.findPersonaEntities();
        List<Cliente> temp2 = clienteDao.findClienteEntities();
        int auxID=1;
        boolean flag=false;
        for(Persona p : temp){
            if(p.getDocumento_id().equals(txtDocumentoCliente)){
                for(Cliente c : temp2){
                    if(c.getId_Persona()==p.getId_persona()){
                        flag=true;
                        auxID=c.getId_cliente();
                    }
                }
            }
        }

        if(!flag){
            //JOptionPane.showMessageDialog(null,"Cliente no encontrado","CLIENTE NO ENCONTRADO",0);
            return 0;
        }

        String pagoEfectivo="0";
        double pagoAuxiliar=Double.parseDouble("0.00");
        int banderaEfectivo=0;
        
        if(cmbTipoPago.toLowerCase().equals("efectivo")){
            while(banderaEfectivo==0){
                pagoEfectivo ="0.00";
                try{
                    pagoAuxiliar=Double.parseDouble(pagoEfectivo);
                    if(pagoAuxiliar<0.00){
                        //JOptionPane.showMessageDialog(null,"El monto a recibir no puede ser menor al total ","MONTO INSUFICIENTE",0);
                        //return;
                    }
                    else{
                    banderaEfectivo=1;
                    }
                }catch(NumberFormatException e){
                    //JOptionPane.showMessageDialog(null, "Monto no Valido","MONTO NO VALIDO",0);
                }
                
            }
            
        }
        if(cmbTipoPago.toLowerCase().equals("mixto")){
            while(banderaEfectivo==0){
                pagoEfectivo = "0.00";
                try{
                    pagoAuxiliar=Double.parseDouble(pagoEfectivo);
                    if(pagoAuxiliar>=100){
                        //JOptionPane.showMessageDialog(null,"El monto a recibir no puede ser mayor o igual al total ","MONTO EXCEDE",0);
                        //return;
                    }
                    else{
                    banderaEfectivo=1;
                    }
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Monto no Valido","MONTO NO VALIDO",0);
                }
                
            }
            
        }
        
        //List<VehiculoFactura> quezalt = vehiculoFacturaDao.findVehiculoFacturaEntities();
        
        //Validacion de VIN
      /*  for(int i = 0;i<tbVenta.getRowCount();i++){
            if(tbVenta.getModel().getValueAt(i, 1).toString().charAt(0)=='1'){
                
            } else {
                for(VehiculoFactura vfvfvf : quezalt){
                    if(vfvfvf.equals(String.valueOf(tbVenta.getModel().getValueAt(i, 1).toString().substring(1, 18))) && vfvfvf.isEstado()){
                        JOptionPane.showMessageDialog(null, "VIN ya registro en una venta anterior","VIN REGISTRADO",0);
                        return;
                    }
                }
                

                

            }
        }
        */
        
        //FIN De Validacion de VIN
        
        
        
        Factura f = new Factura();
        f.setIdEmpleado(cmbIDEmpleado);
        f.setIdCliente(auxID);
        f.setNumeroTarjeta(txtTarjeta.getText());
        f.setiDtipofactura(cmbTipoFacturaVenta);
        //f.setIDFactura(Integer.parseInt(txtNumFactura.getText()));
        f.setCantidadPago(pagoAuxiliar);//Monto de pago
        
        f.setIdRazonSocial(1);
        f.setIdTipoPago(1);
        Calendar fecha = new GregorianCalendar();
        String auxMinutos =(fecha.get(Calendar.MINUTE)<10)? "0"+(Integer.toString(fecha.get(Calendar.MINUTE))) : Integer.toString(fecha.get(Calendar.MINUTE));
        String auxFecha = (fecha.get(Calendar.MONTH)<=9)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH)+1);
        switch(auxFecha){
            case "01":
                    auxFecha= "01";
                    break;
                    case "02":
                    auxFecha= "02";
                    break;case "03":
                    auxFecha= "03";
                    break;case "04":
                    auxFecha= "04";
                    break;case "05":
                    auxFecha= "05";
                    break;case "06":
                    auxFecha= "06";
                    break;case "07":
                    auxFecha= "07";
                    break;case "08":
                    auxFecha= "08";
                    break;case "09":
                    auxFecha= "09";
                    break;
            case "010":
                    auxFecha= "10";
                    break;
            case "011":
                   auxFecha= "11";
                    break;      
            case "012":
                    auxFecha= "12";
                    break;
                    default:
                    break;
        }
        String auxF=auxFecha;
        String auxHora= (fecha.get(Calendar.HOUR_OF_DAY)<10)? "0"+(Integer.toString(fecha.get(Calendar.HOUR_OF_DAY))) : Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
        String auxSegundo=(fecha.get(Calendar.SECOND)<10)? "0"+(Integer.toString(fecha.get(Calendar.SECOND))) : Integer.toString(fecha.get(Calendar.SECOND));
        String auxDia=(fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.DAY_OF_MONTH))) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        f.setFechaHora(String.valueOf(fecha.get(Calendar.YEAR))+auxF+auxDia+auxHora+auxMinutos+auxSegundo);
        f.setEstado(true);
        
        //CAI
        boolean bandera=false;
        for(informacionFiscal temporaltemporal : infFiscalDao.findinformacionFiscalEntities()){
            LocalDate auxfecha1=LocalDate.parse(temporaltemporal.getFechaInicio());
            LocalDate auxFecha2 = LocalDate.parse(temporaltemporal.getFechaFinal());
            
            LocalDate auxFecha3 = LocalDate.parse(String.valueOf(fecha.get(Calendar.YEAR))+"-"+auxF+"-"+auxDia);
            if(auxfecha1.isBefore(auxFecha3) && auxFecha2.isAfter(auxFecha3) && temporaltemporal.isEstado()){
                f.setIdInf(temporaltemporal.getIdInf());
                f.setNumFactura(temporaltemporal.getActual());
                int conversor = Integer.parseInt(f.getNumFactura().substring(11,19));
                conversor++;
                
                temporaltemporal.setActual(f.getNumFactura().substring(0, 11)+String.format("%0"+8+"d", conversor));
                if(temporaltemporal.getActual().equals(temporaltemporal.getFin())){
                    temporaltemporal.setEstado(false);
                }
                else{
                    
                }
                
               /* try {
                    infFiscalDao.edit(temporaltemporal);
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }*/
               
                //JOptionPane.showMessageDialog(null,temporaltemporal.getActual());
                bandera=true;
                break;
                
            }
        }
        if(!bandera){
           //JOptionPane.showMessageDialog(null,"CAI INVALIDO","CAI INVALIDO",0);
           return 0;
        }
        
        //CAI
        
        //facturaDao.create(f);
        
        PiezaFactura temporal = new PiezaFactura();
        VehiculoFactura temporal2 = new VehiculoFactura();
        
//        for(int i = 0;i<tbVenta.getRowCount();i++){
//            if(tbVenta.getModel().getValueAt(i, 1).toString().charAt(0)=='1'){
//            } else {
//                
//                
//
//                
//                
//                Vehiculo bajada = vehiculoDao.findVehiculo(temporal2.getIdVehiculo());
//                int stock = bajada.getStock();
//                stock-=1;
//                bajada.setStock(stock);
//               
//
//            }
//        }
        
        for(int i = 0;i<0;i++){
            if(tbVenta.getModel().getValueAt(i, 1).toString().charAt(0)=='1'){
                temporal.setIdFactura(Integer.parseInt(txtNumFactura.getText()));
                temporal.setIdPieza(Integer.parseInt(tbVenta.getModel().getValueAt(i, 0).toString()));
                temporal.setCantidad(Integer.parseInt(tbVenta.getModel().getValueAt(i, 3).toString()));

                /*try {
                    piezaFacturaDao.create(temporal);
                    
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                Pieza decremento = piezaDao.findPieza(temporal.getIdPieza());
                int stock = decremento.getStock();
                stock=stock-temporal.getCantidad();
                decremento.setStock(stock);
                /*try {
                    piezaDao.edit(decremento);
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }*/

            } else {
                temporal2.setIdFactura(Integer.parseInt(txtNumFactura.getText()));
                temporal2.setIdVehiculo(Integer.parseInt(tbVenta.getModel().getValueAt(i, 0).toString()));
                temporal2.setCantidad(tbVenta.getModel().getValueAt(i, 1).toString().substring(1, 17));//VIN 
                temporal2.setEstado(true);
                

               /* try {
                    vehiculoFacturaDao.create(temporal2);
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                
                Vehiculo bajada = vehiculoDao.findVehiculo(temporal2.getIdVehiculo());
                int stock = bajada.getStock();
                stock-=1;
                bajada.setStock(stock);
                /*try {
                    vehiculoDao.edit(bajada);
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }*/

            }
        }
        return 100;
    }
    
    private void btnImprimirFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirFacturaActionPerformed
        try{
        if(tbVenta.getRowCount()<=0){
            JOptionPane.showMessageDialog(null,"Ingrese una pieza o un Vehiculo para vender","NINGUN ARTICULO",0);
            return;
        }
        
        
        if(cmbIDEmpleado.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione su id de empleado","EMPLEADO SIN SELECCIONAR",0);
            return;
        }

        if(txtDocumentoCliente.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese un documento del cliente","CAMPO VACIO",0);
            return;
        }

        if(cmbTipoFacturaVenta.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Tipo de Factura sin seleccionar","CAMPO SIN SELECCIONAR",0);
            return;
        }
        
        if(cmbTipoPago.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione una forma de pago","CAMPO SIN SELECCIONAR",0);
            return;
        }
        if(cmbTipoPago.getSelectedItem().toString().toLowerCase().equals("tarjeta") ||cmbTipoPago.getSelectedItem().toString().toLowerCase().equals("mixto")){
            if(txtTarjeta.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Ingrese el número de tarjeta","NUMERO DE TARJETA",0);
                return;
            }
            if(Validaciones.validacionTarjetas(txtTarjeta.getText())){
                
            }
            else{
                JOptionPane.showMessageDialog(null,"Número de Tarjeta no Valido", "TARJETA INVALIDA",0);
                return;
            }
        }
        
        List<Persona> temp = personaDao.findPersonaEntities();
        List<Cliente> temp2 = clienteDao.findClienteEntities();
        int auxID=1;
        boolean flag=false;
        for(Persona p : temp){
            if(p.getDocumento_id().equals(txtDocumentoCliente.getText())){
                for(Cliente c : temp2){
                    if(c.getId_Persona()==p.getId_persona()){
                        flag=true;
                        auxID=c.getId_cliente();
                    }
                }
            }
        }

        if(!flag){
            JOptionPane.showMessageDialog(null,"Cliente no encontrado","CLIENTE NO ENCONTRADO",0);
            return;
        }

        String pagoEfectivo="0";
        double pagoAuxiliar=Double.parseDouble(txtTotal.getText());
        int banderaEfectivo=0;
        
        if(cmbTipoPago.getSelectedItem().toString().toLowerCase().equals("efectivo")){
            while(banderaEfectivo==0){
                pagoEfectivo = JOptionPane.showInputDialog(null, "Ingrese el monto a Recibir","REGISTRO",1);
                try{
                    pagoAuxiliar=Double.parseDouble(pagoEfectivo);
                    if(pagoAuxiliar<Double.parseDouble(txtTotal.getText())){
                        JOptionPane.showMessageDialog(null,"El monto a recibir no puede ser menor al total ","MONTO INSUFICIENTE",0);
                        //return;
                    }
                    else{
                    banderaEfectivo=1;
                    }
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Monto no Valido","MONTO NO VALIDO",0);
                }
                
            }
            
        }
        if(cmbTipoPago.getSelectedItem().toString().toLowerCase().equals("mixto")){
            while(banderaEfectivo==0){
                pagoEfectivo = JOptionPane.showInputDialog(null, "Ingrese el monto a Recibir","REGISTRO",1);
                try{
                    pagoAuxiliar=Double.parseDouble(pagoEfectivo);
                    if(pagoAuxiliar>=Double.parseDouble(txtTotal.getText())){
                        JOptionPane.showMessageDialog(null,"El monto a recibir no puede ser mayor o igual al total ","MONTO EXCEDE",0);
                        //return;
                    }
                    else{
                    banderaEfectivo=1;
                    }
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Monto no Valido","MONTO NO VALIDO",0);
                }
                
            }
            
        }
        
        //List<VehiculoFactura> quezalt = vehiculoFacturaDao.findVehiculoFacturaEntities();
        
        //Validacion de VIN
      /*  for(int i = 0;i<tbVenta.getRowCount();i++){
            if(tbVenta.getModel().getValueAt(i, 1).toString().charAt(0)=='1'){
                
            } else {
                for(VehiculoFactura vfvfvf : quezalt){
                    if(vfvfvf.equals(String.valueOf(tbVenta.getModel().getValueAt(i, 1).toString().substring(1, 18))) && vfvfvf.isEstado()){
                        JOptionPane.showMessageDialog(null, "VIN ya registro en una venta anterior","VIN REGISTRADO",0);
                        return;
                    }
                }
                

                

            }
        }
        */
        
        //FIN De Validacion de VIN
        
        
        
        Factura f = new Factura();
        f.setIdEmpleado(cmbIDEmpleado.getSelectedIndex());
        f.setIdCliente(auxID);
        f.setNumeroTarjeta(txtTarjeta.getText());
        f.setiDtipofactura(cmbTipoFacturaVenta.getSelectedIndex());
        //f.setIDFactura(Integer.parseInt(txtNumFactura.getText()));
        f.setCantidadPago(pagoAuxiliar);//Monto de pago
        
        f.setIdRazonSocial(1);
        f.setIdTipoPago(cmbTipoPago.getSelectedIndex());
        Calendar fecha = new GregorianCalendar();
        String auxMinutos =(fecha.get(Calendar.MINUTE)<10)? "0"+(Integer.toString(fecha.get(Calendar.MINUTE))) : Integer.toString(fecha.get(Calendar.MINUTE));
        String auxFecha = (fecha.get(Calendar.MONTH)<=9)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH)+1);
        switch(auxFecha){
            case "01":
                    auxFecha= "01";
                    break;
                    case "02":
                    auxFecha= "02";
                    break;case "03":
                    auxFecha= "03";
                    break;case "04":
                    auxFecha= "04";
                    break;case "05":
                    auxFecha= "05";
                    break;case "06":
                    auxFecha= "06";
                    break;case "07":
                    auxFecha= "07";
                    break;case "08":
                    auxFecha= "08";
                    break;case "09":
                    auxFecha= "09";
                    break;
            case "010":
                    auxFecha= "10";
                    break;
            case "011":
                   auxFecha= "11";
                    break;      
            case "012":
                    auxFecha= "12";
                    break;
                    default:
                    break;
        }
        String auxF=auxFecha;
        String auxHora= (fecha.get(Calendar.HOUR_OF_DAY)<10)? "0"+(Integer.toString(fecha.get(Calendar.HOUR_OF_DAY))) : Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
        String auxSegundo=(fecha.get(Calendar.SECOND)<10)? "0"+(Integer.toString(fecha.get(Calendar.SECOND))) : Integer.toString(fecha.get(Calendar.SECOND));
        String auxDia=(fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.DAY_OF_MONTH))) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        f.setFechaHora(String.valueOf(fecha.get(Calendar.YEAR))+auxF+auxDia+auxHora+auxMinutos+auxSegundo);
        f.setEstado(true);
        
        //CAI
        boolean bandera=false;
        for(informacionFiscal temporaltemporal : infFiscalDao.findinformacionFiscalEntities()){
            LocalDate auxfecha1=LocalDate.parse(temporaltemporal.getFechaInicio());
            LocalDate auxFecha2 = LocalDate.parse(temporaltemporal.getFechaFinal());
            
            LocalDate auxFecha3 = LocalDate.parse(String.valueOf(fecha.get(Calendar.YEAR))+"-"+auxF+"-"+auxDia);
            if(auxfecha1.isBefore(auxFecha3) && auxFecha2.isAfter(auxFecha3) && temporaltemporal.isEstado()){
                f.setIdInf(temporaltemporal.getIdInf());
                f.setNumFactura(temporaltemporal.getActual());
                int conversor = Integer.parseInt(f.getNumFactura().substring(11,19));
                conversor++;
                
                temporaltemporal.setActual(f.getNumFactura().substring(0, 11)+String.format("%0"+8+"d", conversor));
                if(temporaltemporal.getActual().equals(temporaltemporal.getFin())){
                    temporaltemporal.setEstado(false);
                }
                else{
                    
                }
                
                try {
                    infFiscalDao.edit(temporaltemporal);
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                //JOptionPane.showMessageDialog(null,temporaltemporal.getActual());
                bandera=true;
                break;
                
            }
        }
        if(!bandera){
           JOptionPane.showMessageDialog(null,"CAI NO INVALIDO","CAI INVALIDO",0);
           return;
        }
        
        //CAI
        
        facturaDao.create(f);

        PiezaFactura temporal = new PiezaFactura();
        VehiculoFactura temporal2 = new VehiculoFactura();
        
//        for(int i = 0;i<tbVenta.getRowCount();i++){
//            if(tbVenta.getModel().getValueAt(i, 1).toString().charAt(0)=='1'){
//            } else {
//                
//                
//
//                
//                
//                Vehiculo bajada = vehiculoDao.findVehiculo(temporal2.getIdVehiculo());
//                int stock = bajada.getStock();
//                stock-=1;
//                bajada.setStock(stock);
//               
//
//            }
//        }
        
        for(int i = 0;i<tbVenta.getRowCount();i++){
            if(tbVenta.getModel().getValueAt(i, 1).toString().charAt(0)=='1'){
                temporal.setIdFactura(Integer.parseInt(txtNumFactura.getText()));
                temporal.setIdPieza(Integer.parseInt(tbVenta.getModel().getValueAt(i, 0).toString()));
                temporal.setCantidad(Integer.parseInt(tbVenta.getModel().getValueAt(i, 3).toString()));

                try {
                    piezaFacturaDao.create(temporal);
                    
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }
                Pieza decremento = piezaDao.findPieza(temporal.getIdPieza());
                int stock = decremento.getStock();
                stock=stock-temporal.getCantidad();
                decremento.setStock(stock);
                try {
                    piezaDao.edit(decremento);
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                temporal2.setIdFactura(Integer.parseInt(txtNumFactura.getText()));
                temporal2.setIdVehiculo(Integer.parseInt(tbVenta.getModel().getValueAt(i, 0).toString()));
                temporal2.setCantidad(tbVenta.getModel().getValueAt(i, 1).toString().substring(1, 17));//VIN 
                temporal2.setEstado(true);
                

                try {
                    vehiculoFacturaDao.create(temporal2);
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                Vehiculo bajada = vehiculoDao.findVehiculo(temporal2.getIdVehiculo());
                int stock = bajada.getStock();
                stock-=1;
                bajada.setStock(stock);
                try {
                    vehiculoDao.edit(bajada);
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        
        
        
      
            imprimirFacturaVenta();
        
        
        
        this.txtDocumentoCliente.setText("");
        this.cmbTipoPago.setSelectedIndex(0);
        this.txtTarjeta.setText("");
        
        DefaultTableModel modelo = (DefaultTableModel) tbVenta.getModel();
        
        int a= modelo.getRowCount()-1;
        for(int i=a;i>=0;i--){
            modelo.removeRow(i);
        }
        createTablaBusqueda();
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"VentasGenerar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirFacturaActionPerformed

    
    public int imprimirFacturaVentaTest(Object algo[]) /*throws JRException*/{
         Object [][] arrayDetallesFactura;
        arrayDetallesFactura = new Object[1][5];
        
        for(int i = 0;i<1;i++){
            for(int j = 0;j<5;j++){
                switch(j){
                    case 0:arrayDetallesFactura[i][0]="";break;
                    case 1:arrayDetallesFactura[i][1]="";break;
                    case 2:arrayDetallesFactura[i][2]="";break;
                    case 3:arrayDetallesFactura[i][3]="";break;
                    case 4:arrayDetallesFactura[i][4]="";break;
                    
                }
            }
        }
        //JOptionPane.showMessageDialog(null, arrayDetallesFactura[0][1]);
        
        
        Factura f = facturaDao.findFactura(facturaDao.getFacturaCount());
        Empleado e = empleadoDao.findEmpleado(f.getIdEmpleado());
        Persona pp = personaDao.findPersona(e.getId_Persona());
        RazonSocial rs = razonSocialDao.findRazonSocial(f.getIdRazonSocial());
        informacionFiscal iF = infFiscalDao.findinformacionFiscal(f.getIdInf());
        Cliente c = clienteDao.findCliente(f.getIdCliente());
        
        HashMap param = new HashMap();
        param.put("numFactura", f.getNumFactura());
        param.put("Empleado",pp.getNombre()+" "+pp.getApellido());
        param.put("fechaHora",f.getFechaHora());
        param.put("impuesto", txtImpuesto.getText());
        param.put("total",txtTotal.getText());
        param.put("rtnvendedor",rs.getRtn());
        param.put("cai", iF.getCai());
        param.put("tipopago",tipoPagoDao.findTipoPago(f.getIdTipoPago()).getNombre());
        param.put("limite",(iF.getFechaFinal().substring(8, 10)+"/"+iF.getFechaFinal().substring(5, 7)+"/"+iF.getFechaFinal().substring(0, 4)));
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        
        param.put("monto",formato1.format(f.getCantidadPago()) );
        
        pp = personaDao.findPersona(c.getId_Persona()); 
        
        param.put("cliente", pp.getNombre()+" "+pp.getApellido());
        param.put("documento",pp.getDocumento_id());
        
        
        
            //JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Factura.jrxml");
           // JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,FacturaJRADATASOURCE.getDataSource(arrayDetallesFactura));
            
            //JasperRunManager.runReportToPdf(reporteFactura, param);
            
          //  JasperViewer view = new JasperViewer(print, false);
           // view.setVisible(true);
           // view.setTitle("Factura" + Integer.parseInt("1"));
        
        
        return 100;
    }
    
    
    private void imprimirFacturaVenta() throws JRException{
        Object [][] arrayDetallesFactura;
        arrayDetallesFactura = new Object[tbVenta.getRowCount()][5];
        
        for(int i = 0;i<tbVenta.getRowCount();i++){
            for(int j = 0;j<5;j++){
                switch(j){
                    case 0:arrayDetallesFactura[i][0]=(i+1);
                    case 1:arrayDetallesFactura[i][1]=tbVenta.getValueAt(i, 1);break;
                    case 2:arrayDetallesFactura[i][2]=tbVenta.getValueAt(i, 2);break;
                    case 3:arrayDetallesFactura[i][3]=String.valueOf(tbVenta.getValueAt(i,3));break;
                    case 4:arrayDetallesFactura[i][4]=tbVenta.getValueAt(i, 4);break;
                    
                }
            }
        }
        //JOptionPane.showMessageDialog(null, arrayDetallesFactura[0][1]);
        
        
        Factura f = facturaDao.findFactura(facturaDao.getFacturaCount());
        Empleado e = empleadoDao.findEmpleado(f.getIdEmpleado());
        Persona pp = personaDao.findPersona(e.getId_Persona());
        RazonSocial rs = razonSocialDao.findRazonSocial(f.getIdRazonSocial());
        informacionFiscal iF = infFiscalDao.findinformacionFiscal(f.getIdInf());
        Cliente c = clienteDao.findCliente(f.getIdCliente());
        
        HashMap param = new HashMap();
        param.put("numFactura", f.getNumFactura());
        param.put("Empleado",pp.getNombre()+" "+pp.getApellido());
        param.put("fechaHora",f.getFechaHora());
        param.put("impuesto", txtImpuesto.getText());
        param.put("total",txtTotal.getText());
        param.put("rtnvendedor",rs.getRtn());
        param.put("cai", iF.getCai());
        param.put("tipopago",tipoPagoDao.findTipoPago(f.getIdTipoPago()).getNombre());
        param.put("limite",(iF.getFechaFinal().substring(8, 10)+"/"+iF.getFechaFinal().substring(5, 7)+"/"+iF.getFechaFinal().substring(0, 4)));
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        
        param.put("monto",formato1.format(f.getCantidadPago()) );
        
        pp = personaDao.findPersona(c.getId_Persona()); 
        
        param.put("cliente", pp.getNombre()+" "+pp.getApellido());
        param.put("documento",pp.getDocumento_id());
        
        
        
            JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Factura.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,FacturaJRADATASOURCE.getDataSource(arrayDetallesFactura));
            
            //JasperRunManager.runReportToPdf(reporteFactura, param);
            
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
            view.setTitle("Factura" + Integer.parseInt("1"));
            
            
        
        
    }
    
    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        this.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        try{
        ModalPiezas temp2 = new ModalPiezas(this,true);
        temp2.setLocationRelativeTo(null);
        temp2.setVisible(true);
        txtIDPieza.setText(String.valueOf(temp2.getId()));
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"VentaBuscarPieza"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        try{
        ModalVehiculos temp2 = new ModalVehiculos(this,true);
        temp2.setLocationRelativeTo(null);
        temp2.setVisible(true);
        txtIDVehiculo.setText(String.valueOf(temp2.getId()));
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"VentaAgregarVehiculo"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void txtVINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVINActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try{
        DefaultTableModel modelo = (DefaultTableModel) tbVenta.getModel();
        if(modelo.getRowCount()==0){
            
        }
        else{
        modelo.removeRow(modelo.getRowCount()-1);
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("0.00", separadoresPersonalizados);
        
        double contenedorPrecio=0;
        double contenedorImpuesto=0;
        for(int i=0;i<modelo.getRowCount();i++){
            contenedorPrecio+=Double.parseDouble((String) modelo.getValueAt(i, 4));
            contenedorImpuesto+=Double.parseDouble((String) modelo.getValueAt(i, 4))*0.18;
            
        }
        txtImpuesto.setText(formato1.format(contenedorImpuesto));
        txtTotal.setText(formato1.format(contenedorPrecio));
        }
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"VentasBorrar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtIDPiezaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDPiezaFocusLost
       Pattern pat = Pattern.compile("^\\d*$");
       Matcher mat = pat.matcher(txtIDPieza.getText());
       
       if(txtIDPieza.getText().equals("")){
           txtNombre.setText("");
           return;
       }
       
       Pieza xd=piezaDao.findPieza(Integer.parseInt(txtIDPieza.getText()));

        if(!mat.matches() || xd==null){
            txtNombre.setText("");
            
            //return;
            
        }
        else{
        txtNombre.setText(piezaDao.findPieza(Integer.parseInt(txtIDPieza.getText())).getNombre());
    }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPiezaFocusLost

    private void txtIDPiezaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDPiezaKeyTyped
char c = evt.getKeyChar();
        if((c < '0' || c > '9')){

            evt.consume();

        }
        if (txtIDPieza.getText().length() >= 5){
        
        evt.consume();
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPiezaKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try{
        createTablaBusqueda();
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"FacturaBuscar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void createTbBusquedaGeneral(){
        DefaultTableModel modelo1 = (DefaultTableModel) jTable3.getModel();
        jTable3.setModel(modelo1);
        /*modelo1.addColumn("Num de Factura");
        modelo1.addColumn("Fecha");
        modelo1.addColumn("Cliente");
        modelo1.addColumn("Estado");*/
        int i;
        for(i=modelo1.getRowCount()-1;i>=0;i--){
            modelo1.removeRow(i);
        }
        
        List<Factura> temp = facturaDao.findFacturaEntities();
        
        for(Factura f : temp){
            Persona personaParaBusqueda=personaDao.findPersona(clienteDao.findCliente(f.getIdCliente()).getId_Persona());
                    
                    String auxiliarEstado = (f.getEstado())? "Aceptado":"Rechazado";
                    modelo1.addRow(new Object[]{f.getNumFactura(),f.getFechaHora(),personaParaBusqueda.getNombre()+" "+personaParaBusqueda.getApellido(),auxiliarEstado});        }
        
    }
    
    private void createTablaBusqueda(){
        if(!chkNumFactura.isSelected()&& !chkCliente.isSelected()){
            JOptionPane.showMessageDialog(null,"No ha Marcado ningún Checkbox","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if("".equals(txtNumFacturaBusqueda.getText().trim())){
            JOptionPane.showMessageDialog(null, "El campo Número de Factura para la Busqueda de la Factura esta vacío","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            if("".equals(txtClienteBusqueda.getText().trim())){
            JOptionPane.showMessageDialog(null, "El campo ID Cliente para la Busqueda de la Factura esta vacío","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        }
        DefaultTableModel modelo1 = new DefaultTableModel();
        jTable3.setModel(modelo1);
        modelo1.addColumn("Núm. de Factura");
        modelo1.addColumn("Fecha");
        modelo1.addColumn("Cliente");
        
        List<Factura> temp = facturaDao.findFacturaEntities();
        
        double valorFactura=0;
        double valorTotal=0;
        
        if(chkNumFactura.isSelected() && !chkCliente.isSelected()){
            for(Factura f : temp){
                if(f.getNumFactura().equals(txtNumFacturaBusqueda.getText())){
//                    for(PiezaFactura p : temp2){
//                        if(p.getIdFactura()==f.getIDFactura()){
//                            List<HistoricoPrecioPieza> temp4 = historicoPiezaDao.findHistoricoPrecioPiezaEntities();
//                            for(HistoricoPrecioPieza pp : temp4){
//                                //Validar con un if si la fecha es null
//                                LocalDate auxFechaInicio= LocalDate.parse(pp.getFechaInicial());
//                                LocalDate auxFechaFinal = LocalDate.parse(pp.getFechaFinal());
//                                LocalDate auxFechaEmision = LocalDate.parse(f.getFechaHora());
//                                
//                                
//                                if(pp.getIdPieza()==p.getIdPieza() && auxFechaEmision.isAfter(auxFechaInicio) && auxFechaEmision.isBefore(auxFechaFinal)){//Cambiar la condicion de la fecha
//                                    valorFactura+=(pp.getPrecio()*p.getCantidad());
//                                }
//                                
//                                else if(pp.getIdPieza()==p.getIdPieza() && pp.getFechaFinal()==null){//Cambiar la condicion de la fecha
//                                    valorFactura+=(pp.getPrecio()*p.getCantidad());
//                                }
//                            }
//                            
//                            
//                            
//                            
//                        }
//                    }
//                    for(VehiculoFactura v : temp3){
//                        if(v.getIdFactura()==f.getIDFactura()){
//                            List<HistoricoPrecioVehiculos> temp5 = historicoVehiculoDao.findHistoricoPrecioVehiculosEntities();
//                            for(HistoricoPrecioVehiculos pv : temp5){
//                                if(v.getIdVehiculo()==pv.getId_vehiculo() && pv.getFechaFinal()==null){//Cambiar la condicion de la fehca
//                                    valorFactura+=(pv.getPrecio());                                    
//                                }
//                                
//                            }
//                        }
//                    }
//                    
                    Persona personaParaBusqueda=personaDao.findPersona(clienteDao.findCliente(f.getIdCliente()).getId_Persona());
                    //JOptionPane.showMessageDialog(null, f.getEstado());
                    String auxiliarEstado = (f.getEstado())? "Aceptado":"Rechazado";
                    modelo1.addRow(new Object[]{f.getNumFactura(),f.getFechaHora(),personaParaBusqueda.getNombre()+" "+personaParaBusqueda.getApellido(),auxiliarEstado});
                    
                    
                }
            }
            
            
        }
        else if(!chkNumFactura.isSelected() && chkCliente.isSelected()){
            List<Factura> facL = facturaDao.findFacturaEntities();
            List<Cliente> clL = clienteDao.findClienteEntities();
            List<Persona> pL = personaDao.findPersonaEntities();
            
            for(Factura f : facL){
                Cliente c = clienteDao.findCliente(f.getIdCliente());
                Persona p = personaDao.findPersona(c.getId_Persona());
                if(p.getNombre().trim().equals(txtClienteBusqueda.getText().trim())){
                    Persona personaParaBusqueda=personaDao.findPersona(clienteDao.findCliente(f.getIdCliente()).getId_Persona());
                    
                    String auxiliarEstado = (f.getEstado())? "Aceptado":"Rechazado";
                    modelo1.addRow(new Object[]{f.getNumFactura(),f.getFechaHora(),personaParaBusqueda.getNombre()+" "+personaParaBusqueda.getApellido(),auxiliarEstado});                }
                
                
            }
            
            
            
            
            
        }
        
        
        
    }
    public boolean BuscarFacturaTest(){
        if(!chkNumFactura.isSelected()&& !chkCliente.isSelected()){
            //JOptionPane.showMessageDialog(null,"No ha Marcado ningún Checkbox","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if("".equals(txtNumFacturaBusqueda.getText().trim())){
            //JOptionPane.showMessageDialog(null, "El campo Número de Factura para la Busqueda de la Factura esta vacío","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            if("".equals(txtClienteBusqueda.getText().trim())){
            //JOptionPane.showMessageDialog(null, "El campo ID Cliente para la Busqueda de la Factura esta vacío","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        }
        DefaultTableModel modelo1 = new DefaultTableModel();
        jTable3.setModel(modelo1);
        modelo1.addColumn("Núm. de Factura");
        modelo1.addColumn("Fecha");
        modelo1.addColumn("Cliente");
        
        List<Factura> temp = facturaDao.findFacturaEntities();
        
        double valorFactura=0;
        double valorTotal=0;
        
        if(chkNumFactura.isSelected() && !chkCliente.isSelected()){
            for(Factura f : temp){
                if(f.getNumFactura().equals(txtNumFacturaBusqueda.getText())){
//                    for(PiezaFactura p : temp2){
//                        if(p.getIdFactura()==f.getIDFactura()){
//                            List<HistoricoPrecioPieza> temp4 = historicoPiezaDao.findHistoricoPrecioPiezaEntities();
//                            for(HistoricoPrecioPieza pp : temp4){
//                                //Validar con un if si la fecha es null
//                                LocalDate auxFechaInicio= LocalDate.parse(pp.getFechaInicial());
//                                LocalDate auxFechaFinal = LocalDate.parse(pp.getFechaFinal());
//                                LocalDate auxFechaEmision = LocalDate.parse(f.getFechaHora());
//                                
//                                
//                                if(pp.getIdPieza()==p.getIdPieza() && auxFechaEmision.isAfter(auxFechaInicio) && auxFechaEmision.isBefore(auxFechaFinal)){//Cambiar la condicion de la fecha
//                                    valorFactura+=(pp.getPrecio()*p.getCantidad());
//                                }
//                                
//                                else if(pp.getIdPieza()==p.getIdPieza() && pp.getFechaFinal()==null){//Cambiar la condicion de la fecha
//                                    valorFactura+=(pp.getPrecio()*p.getCantidad());
//                                }
//                            }
//                            
//                            
//                            
//                            
//                        }
//                    }
//                    for(VehiculoFactura v : temp3){
//                        if(v.getIdFactura()==f.getIDFactura()){
//                            List<HistoricoPrecioVehiculos> temp5 = historicoVehiculoDao.findHistoricoPrecioVehiculosEntities();
//                            for(HistoricoPrecioVehiculos pv : temp5){
//                                if(v.getIdVehiculo()==pv.getId_vehiculo() && pv.getFechaFinal()==null){//Cambiar la condicion de la fehca
//                                    valorFactura+=(pv.getPrecio());                                    
//                                }
//                                
//                            }
//                        }
//                    }
//                    
                    Persona personaParaBusqueda=personaDao.findPersona(clienteDao.findCliente(f.getIdCliente()).getId_Persona());
                    //JOptionPane.showMessageDialog(null, f.getEstado());
                    String auxiliarEstado = (f.getEstado())? "Aceptado":"Rechazado";
                    modelo1.addRow(new Object[]{f.getNumFactura(),f.getFechaHora(),personaParaBusqueda.getNombre()+" "+personaParaBusqueda.getApellido(),auxiliarEstado});
                    
                    
                }
            }
            
            
        }
        else if(!chkNumFactura.isSelected() && chkCliente.isSelected()){
            List<Factura> facL = facturaDao.findFacturaEntities();
            List<Cliente> clL = clienteDao.findClienteEntities();
            List<Persona> pL = personaDao.findPersonaEntities();
            
            for(Factura f : facL){
                Cliente c = clienteDao.findCliente(f.getIdCliente());
                Persona p = personaDao.findPersona(c.getId_Persona());
                if(p.getNombre().trim().equals(txtClienteBusqueda.getText().trim())){
                    Persona personaParaBusqueda=personaDao.findPersona(clienteDao.findCliente(f.getIdCliente()).getId_Persona());
                    
                    String auxiliarEstado = (f.getEstado())? "Aceptado":"Rechazado";
                    modelo1.addRow(new Object[]{f.getNumFactura(),f.getFechaHora(),personaParaBusqueda.getNombre()+" "+personaParaBusqueda.getApellido(),auxiliarEstado});                }
                
                
            }
            
            
            
            
            
        }
        
        
        return true;
    }
    private void chkNumFacturaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkNumFacturaItemStateChanged
        if(chkNumFactura.isSelected()){
            txtNumFacturaBusqueda.setEnabled(true);
            chkCliente.setSelected(false);
//            chkFecha.setSelected(false);
        }
        else{
            txtNumFacturaBusqueda.setEnabled(false);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_chkNumFacturaItemStateChanged

    private void chkClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkClienteItemStateChanged

        if(chkCliente.isSelected()){
            txtClienteBusqueda.setEnabled(true);
            chkNumFactura.setSelected(false);
//            chkFecha.setSelected(false);
        }
        else{
            txtClienteBusqueda.setEnabled(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_chkClienteItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{
        this.txtDocumentoCliente.setText("");
        this.cmbTipoPago.setSelectedIndex(0);
        this.txtTarjeta.setText("");
        
        DefaultTableModel modelo = (DefaultTableModel) tbVenta.getModel();
        
        int a= modelo.getRowCount()-1;
        for(int i=a;i>=0;i--){
            modelo.removeRow(i);
        }
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"VentasLimpiar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInicioActionPerformed

    public int btnModificar3ActionPerfomedTest(String txtCAI,String txtFechaInicio,String txtFechaFinalizacion,String txtDe,String txtHasta, String ltrampa){
         if(txtCAI.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor Ingrese el CAI","CAI EN BLANCO",0);
            return 0;
        }
        else{
            
        }
        
        Pattern pat = Pattern.compile("^[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{2}$");
        Matcher mat = pat.matcher(txtCAI.trim());
        
        if(mat.matches()){
            
        }
        else{
            //JOptionPane.showMessageDialog(null,"CAI NO VALIDO","CAI INVALIDO",0);
            return 0;
        }
        if(txtFechaInicio.equals("")){
            JOptionPane.showMessageDialog(null,"INGRESE UNA FECHA DE INICIO","FECHA DE INICIO EN BLANCO",0);
            return 0;
            
        }
        else{
            
        }
        if(txtFechaFinalizacion.equals("")){
            JOptionPane.showMessageDialog(null,"INGRESE LA FECHA DE FINALIZACION DEL CAI","FECHA DE FINALIZACION EN BLANCO",0);
            return 0;
        }
        else{
            
        }
        //Tomamos la fecha que usaremos para guardar en la base de datos NOTA: NO TOMAR DIRECTAMENTE DE TEXTBOX
        String fechaInicio;
        String fechaFinal;

        fechaInicio=txtFechaInicio.substring(6, 10)+txtFechaInicio.substring(3, 5)+txtFechaInicio.substring(0,2);
        fechaFinal=txtFechaFinalizacion.substring(6, 10)+txtFechaFinalizacion.substring(3, 5)+txtFechaFinalizacion.substring(0, 2);
        /*JOptionPane.showMessageDialog(null,fechaInicio);
        JOptionPane.showMessageDialog(null,fechaFinal);*/
        //FIN
        
        if(txtDe.equals("   -   -  -        ")){
            JOptionPane.showMessageDialog(null,"Ingrese el rango desde","DESDE VACIO",0);
            return 0;
        }
        if(txtHasta.equals("   -   -  -        ")){//Si alguien llega a ver esta parte del codigo SOLAR-Spit It Out
            JOptionPane.showMessageDialog(null,"Ingrese el rango HASTA","HASTA VACIO",0);
            return 0;
        }
        
        
        
        List<informacionFiscal> temp = infFiscalDao.findinformacionFiscalEntities();
        
        informacionFiscal temporal = null;
        
        boolean flag = false;
        
        for(informacionFiscal f : temp){
            if(f.getCai().equals(txtCAI)){
                flag=true;
            }
        }
        
        if(flag){
           // JOptionPane.showMessageDialog(null,"YA EXISTE EL CAI REGISTRADO","CAI EXISTENTE",0);
            return 100;
        }
        
        
        for(informacionFiscal f : temp){
            if(f.getIdInf()==Integer.parseInt(ltrampa)){
                temporal=f;
            }
        }
        
        
        /*if(true){
        
        JOptionPane.showMessageDialog(null,temporal.getCai());
        return;
        }*/
        
        temporal.setCai(txtCAI);
        temporal.setFechaInicio(fechaInicio);
        temporal.setFechaFinal(fechaFinal);
        temporal.setInicio(txtDe);
        temporal.setFin(txtHasta);
        temporal.setEstado(true);
        
        try {
            infFiscalDao.edit(temporal);
        } catch (Exception ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            
        
//        Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
//                JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
//        limpiarCAI();
//        createTableCAI();
        return 100;
//        tab_Ventas.setSelectedIndex(1);
//        setCAIFactura();
//        tab_Ventas.setSelectedIndex(3);
    }
    
    private void btnModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar3ActionPerformed
        try{
        if(txtCAI.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor Ingrese el CAI","CAI EN BLANCO",0);
            return;
        }
        else{
            
        }
        
        Pattern pat = Pattern.compile("^[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{2}$");
        Matcher mat = pat.matcher(txtCAI.getText().trim());
        
        if(mat.matches()){
            
        }
        else{
            JOptionPane.showMessageDialog(null,"CAI NO VALIDO","CAI INVALIDO",0);
            return;
        }
        if(txtFechaInicio.getText().equals("")){
            JOptionPane.showMessageDialog(null,"INGRESE UNA FECHA DE INICIO","FECHA DE INICIO EN BLANCO",0);
            return;
            
        }
        else{
            
        }
        if(txtFechaFinalizacion.getText().equals("")){
            JOptionPane.showMessageDialog(null,"INGRESE LA FECHA DE FINALIZACION DEL CAI","FECHA DE FINALIZACION EN BLANCO",0);
            return;
        }
        else{
            
        }
        //Tomamos la fecha que usaremos para guardar en la base de datos NOTA: NO TOMAR DIRECTAMENTE DE TEXTBOX
        String fechaInicio;
        String fechaFinal;

        fechaInicio=txtFechaInicio.getText().substring(6, 10)+txtFechaInicio.getText().substring(3, 5)+txtFechaInicio.getText().substring(0,2);
        fechaFinal=txtFechaFinalizacion.getText().substring(6, 10)+txtFechaFinalizacion.getText().substring(3, 5)+txtFechaFinalizacion.getText().substring(0, 2);
        /*JOptionPane.showMessageDialog(null,fechaInicio);
        JOptionPane.showMessageDialog(null,fechaFinal);*/
        //FIN
        
        if(txtDe.getText().equals("   -   -  -        ")){
            JOptionPane.showMessageDialog(null,"Ingrese el rango desde","DESDE VACIO",0);
            return;
        }
        if(txtHasta.getText().equals("   -   -  -        ")){//Si alguien llega a ver esta parte del codigo SOLAR-Spit It Out
            JOptionPane.showMessageDialog(null,"Ingrese el rango HASTA","HASTA VACIO",0);
            return;
        }
        
        
        
        List<informacionFiscal> temp = infFiscalDao.findinformacionFiscalEntities();
        
        informacionFiscal temporal = null;
        
        boolean flag = false;
        
        for(informacionFiscal f : temp){
            if(f.getCai().equals(txtCAI.getText())){
                flag=true;
            }
        }
        
        if(flag){
            JOptionPane.showMessageDialog(null,"YA EXISTE EL CAI REGISTRADO","CAI EXISTENTE",0);
            return;
        }
        
        
        for(informacionFiscal f : temp){
            if(f.getIdInf()==Integer.parseInt(ltrampa.getText())){
                temporal=f;
            }
        }
        
        
        /*if(true){
        
        JOptionPane.showMessageDialog(null,temporal.getCai());
        return;
        }*/
        
        temporal.setCai(txtCAI.getText());
        temporal.setFechaInicio(fechaInicio);
        temporal.setFechaFinal(fechaFinal);
        temporal.setInicio(txtDe.getText());
        temporal.setFin(txtHasta.getText());
        temporal.setEstado(true);
        
      
            infFiscalDao.edit(temporal);
        
            
            
            
            
        
        Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
                JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
        limpiarCAI();
        createTableCAI();
        
        tab_Ventas.setSelectedIndex(1);
        setCAIFactura();
        tab_Ventas.setSelectedIndex(3);
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"CAImodificar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificar3ActionPerformed

    private void btnLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar3ActionPerformed
        try{
        limpiarCAI();
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"CAIlimpiar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiar3ActionPerformed

    public int jButton1ActionPerfomedTest(String txtCAI,String txtFechaInicio,String txtFechaFinalizacion,String txtDe,String txtHasta){
        if(txtCAI.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor Ingrese el CAI","CAI EN BLANCO",0);
            return 0;
        }
        else{
            
        }
        
        Pattern pat = Pattern.compile("(^[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{2}$)|(^[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{2}$)");
        Matcher mat = pat.matcher(txtCAI.trim());
        
        if(mat.matches()){
            
        }
        else{
            JOptionPane.showMessageDialog(null,"CAI NO VÁLIDO","CAI INVALIDO",0);
            return 0;
        }
        if(txtFechaInicio.equals("")){
            JOptionPane.showMessageDialog(null,"INGRESE UNA FECHA DE INICIO","FECHA DE INICIO EN BLANCO",0);
            return 0;
            
        }
        else{
            
        }
        if(txtFechaFinalizacion.equals("")){
            JOptionPane.showMessageDialog(null,"INGRESE LA FECHA DE FINALIZACION DEL CAI","FECHA DE FINALIZACION EN BLANCO",0);
            return 0;
        }
        else{
            
        }
        //Tomamos la fecha que usaremos para guardar en la base de datos NOTA: NO TOMAR DIRECTAMENTE DE TEXTBOX
        String fechaInicio;
        String fechaFinal;

        fechaInicio=txtFechaInicio.substring(6, 10)+txtFechaInicio.substring(3, 5)+txtFechaInicio.substring(0,2);
        fechaFinal=txtFechaFinalizacion.substring(6, 10)+txtFechaFinalizacion.substring(3, 5)+txtFechaFinalizacion.substring(0, 2);
        /*JOptionPane.showMessageDialog(null,fechaInicio);
        JOptionPane.showMessageDialog(null,fechaFinal);*/
        //FIN
        
        if(txtDe.equals("   -   -  -        ")){
            JOptionPane.showMessageDialog(null,"Ingrese el rango desde","DESDE VACIO",0);
            return 0;
        }
        if(txtHasta.equals("   -   -  -        ")){//Si alguien llega a ver esta parte del codigo SOLAR-Spit It Out
            JOptionPane.showMessageDialog(null,"Ingrese el rango HASTA","HASTA VACIO",0);
            return 0;
        }
        
        int conversor = Integer.parseInt(txtDe.substring(11,19));
        int conversor2= Integer.parseInt(txtHasta.substring(11,19));
        
        if(txtDe.substring(0, 11).equals(txtHasta.substring(0, 11))){
            
        }
        else{
            JOptionPane.showMessageDialog(null,"El rango debe coincidir en sus primeras tres secciones de numero","ERROR DE RANGO",0);
            return 0;
        }
        
        if(conversor>=conversor2){
            JOptionPane.showMessageDialog(null,"El rango desde no puede ser igual o mayor al Rango hasta","RANGO NO VALIDO",0);
            return 0;
        }
        
        List<informacionFiscal> temp = infFiscalDao.findinformacionFiscalEntities();
        boolean flag = false;
        
        for(informacionFiscal f : temp){
            if(f.getCai().equals(txtCAI)){
                flag=true;
            }
        }
        
        if(flag){
            //JOptionPane.showMessageDialog(null,"YA EXISTE EL CAI REGISTRADO","CAI EXISTENTE",0);
            return 100;
        }
        
        informacionFiscal temporal = new informacionFiscal();
        
        temporal.setIdInf(infFiscalDao.getinformacionFiscalCount()+1);
        temporal.setCai(txtCAI);
        temporal.setFechaInicio(fechaInicio);
        temporal.setFechaFinal(fechaFinal);
        temporal.setInicio(txtDe);
        temporal.setFin(txtHasta);
        temporal.setActual(txtDe);
        temporal.setEstado(true);
        try {
            infFiscalDao.create(temporal);
            
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
//        Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
//                JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
//        limpiarCAI();
//        createTableCAI();
//        tab_Ventas.setSelectedIndex(1);
//        setCAIFactura();
//        tab_Ventas.setSelectedIndex(3);
        return 100;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Agregar nuevo CAI
        try{
        if(txtCAI.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor Ingrese el CAI","CAI EN BLANCO",0);
            return;
        }
        else{
            
        }
        
        Pattern pat = Pattern.compile("(^[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{2}$)|(^[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{6}[-]{1}[A-Z,0-9]{2}$)");
        Matcher mat = pat.matcher(txtCAI.getText().trim());
        
        if(mat.matches()){
            
        }
        else{
            JOptionPane.showMessageDialog(null,"CAI NO VÁLIDO","CAI INVALIDO",0);
            return;
        }
        if(txtFechaInicio.getText().equals("")){
            JOptionPane.showMessageDialog(null,"INGRESE UNA FECHA DE INICIO","FECHA DE INICIO EN BLANCO",0);
            return;
            
        }
        else{
            
        }
        if(txtFechaFinalizacion.getText().equals("")){
            JOptionPane.showMessageDialog(null,"INGRESE LA FECHA DE FINALIZACION DEL CAI","FECHA DE FINALIZACION EN BLANCO",0);
            return;
        }
        else{
            
        }
        //Tomamos la fecha que usaremos para guardar en la base de datos NOTA: NO TOMAR DIRECTAMENTE DE TEXTBOX
        String fechaInicio;
        String fechaFinal;

        fechaInicio=txtFechaInicio.getText().substring(6, 10)+txtFechaInicio.getText().substring(3, 5)+txtFechaInicio.getText().substring(0,2);
        fechaFinal=txtFechaFinalizacion.getText().substring(6, 10)+txtFechaFinalizacion.getText().substring(3, 5)+txtFechaFinalizacion.getText().substring(0, 2);
        /*JOptionPane.showMessageDialog(null,fechaInicio);
        JOptionPane.showMessageDialog(null,fechaFinal);*/
        //FIN
        
        if(txtDe.getText().equals("   -   -  -        ")){
            JOptionPane.showMessageDialog(null,"Ingrese el rango desde","DESDE VACIO",0);
            return;
        }
        if(txtHasta.getText().equals("   -   -  -        ")){//Si alguien llega a ver esta parte del codigo SOLAR-Spit It Out
            JOptionPane.showMessageDialog(null,"Ingrese el rango HASTA","HASTA VACIO",0);
            return;
        }
        
        int conversor = Integer.parseInt(txtDe.getText().substring(11,19));
        int conversor2= Integer.parseInt(txtHasta.getText().substring(11,19));
        
        if(txtDe.getText().substring(0, 11).equals(txtHasta.getText().substring(0, 11))){
            
        }
        else{
            JOptionPane.showMessageDialog(null,"El rango debe coincidir en sus primeras tres secciones de numero","ERROR DE RANGO",0);
            return;
        }
        
        if(conversor>=conversor2){
            JOptionPane.showMessageDialog(null,"El rango desde no puede ser igual o mayor al Rango hasta","RANGO NO VALIDO",0);
            return;
        }
        
        List<informacionFiscal> temp = infFiscalDao.findinformacionFiscalEntities();
        boolean flag = false;
        
        for(informacionFiscal f : temp){
            if(f.getCai().equals(txtCAI.getText())){
                flag=true;
            }
        }
        
        if(flag){
            JOptionPane.showMessageDialog(null,"YA EXISTE EL CAI REGISTRADO","CAI EXISTENTE",0);
            return;
        }
        
        informacionFiscal temporal = new informacionFiscal();
        
        temporal.setIdInf(infFiscalDao.getinformacionFiscalCount()+1);
        temporal.setCai(txtCAI.getText());
        temporal.setFechaInicio(fechaInicio);
        temporal.setFechaFinal(fechaFinal);
        temporal.setInicio(txtDe.getText());
        temporal.setFin(txtHasta.getText());
        temporal.setActual(txtDe.getText());
        temporal.setEstado(true);
        
            infFiscalDao.create(temporal);
            
            
            
            
        
        Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
                JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        limpiarCAI();
        createTableCAI();
        tab_Ventas.setSelectedIndex(1);
        setCAIFactura();
        tab_Ventas.setSelectedIndex(3);
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"CAIagregar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public int btnDesactivar4ActionPerfomedTest(String ltrampa){
        informacionFiscal temp;
        temp = infFiscalDao.findinformacionFiscal(Integer.parseInt(ltrampa));
        //temp = piezaDao.findPieza(txtIDPieza.getSelectedIndex()+1);
        //JOptionPane.showMessageDialog(null, temp.isEstado());
        if(temp.isEstado()){
            temp.setEstado(false);
//            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
//            JOptionPane.showMessageDialog(null,"CAI Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
//            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
//            JOptionPane.showMessageDialog(null,"CAI Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        try {
           // infFiscalDao.edit(temp);
        } catch (Exception ex) {
           // Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
//        createTableCAI();
//        btnActivarDesactivarCAI();
//        jButton1.setEnabled(true);
//        btnModificar3.setEnabled(false);
//        btnDesactivar4.setEnabled(false); 
        /*btnDesactivar4.setEnabled(false);
        jButton1.setEnabled(true);
        btnModificar3.setEnabled(false);*/
        return 100;
    }
    
    private void btnDesactivar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar4ActionPerformed
        try{
        informacionFiscal temp;
        temp = infFiscalDao.findinformacionFiscal(Integer.parseInt(ltrampa.getText()));
        //temp = piezaDao.findPieza(txtIDPieza.getSelectedIndex()+1);
        //JOptionPane.showMessageDialog(null, temp.isEstado());
        if(temp.isEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"CAI Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);}
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"CAI Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        
            infFiscalDao.edit(temp);
        
        createTableCAI();
        btnActivarDesactivarCAI();
        jButton1.setEnabled(true);
        btnModificar3.setEnabled(false);
        btnDesactivar4.setEnabled(false); 
        /*btnDesactivar4.setEnabled(false);
        jButton1.setEnabled(true);
        btnModificar3.setEnabled(false);*/
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"CAIDesactivar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesactivar4ActionPerformed

    
    
    private void btnActivarDesactivarCAI(){
        informacionFiscal temp;
        temp = infFiscalDao.findinformacionFiscal(Integer.parseInt(ltrampa.getText()));
        
        if(temp.isEstado()){
        btnDesactivar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar4.setText("Desactivar");  
        btnDesactivar4.setEnabled(true);
        }
        else{
            btnDesactivar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png"))); // NOI18N
            btnDesactivar4.setText("Activar");
            btnDesactivar4.setEnabled(true);
        }
    }
    
    private void ActivarDesactivarTipoPago(){
        TipoPago temp;
        temp = tipoPagoDao.findTipoPago(cmbIDTipoPagoAgregar.getSelectedIndex());
        
        if(temp.getEstado()){
        btnDesactivarTipoPago.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivarTipoPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivarTipoPago.setText("Desactivar");  
        btnDesactivarTipoPago.setEnabled(true);
        }
        else{
            btnDesactivarTipoPago.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivarTipoPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png"))); // NOI18N
            btnDesactivarTipoPago.setText("Activar");
            btnDesactivarTipoPago.setEnabled(true);
        }
    }
    
    private void tbCAIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCAIMouseClicked
        jButton1.setEnabled(false);
        btnModificar3.setEnabled(true);
        btnDesactivar4.setEnabled(true);         
        int fila = tbCAI.getSelectedRow();
         informacionFiscal temp;
         if (fila > -1){
           temp=infFiscalDao.findinformacionFiscal(Integer.parseInt(tbCAI.getModel().getValueAt(fila, 0).toString()));
           txtCAI.setText(temp.getCai());
           txtFechaInicio.setText(temp.getFechaInicio().substring(8, 10)+"/"+temp.getFechaInicio().substring(5, 7)+"/"+temp.getFechaInicio().substring(0,4));
           txtFechaFinalizacion.setText(temp.getFechaFinal().substring(8, 10)+"/"+temp.getFechaFinal().substring(5, 7)+"/"+temp.getFechaFinal().substring(0,4));
           txtDe.setText(temp.getInicio()); txtHasta.setText(temp.getFin());
           ltrampa.setText(String.valueOf(temp.getIdInf()));
           btnActivarDesactivarCAI();
           
       }
         
      
         
        // TODO add your handling code here:
    }//GEN-LAST:event_tbCAIMouseClicked

    private void cmbIDTipoPagoAgregarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDTipoPagoAgregarItemStateChanged
        if(cmbIDTipoPagoAgregar.getSelectedIndex()==0){
            txtTipoPago.setText("");
            btnAgregarTipoPago.setEnabled(true);
            btnModificarTipoPago.setEnabled(false);
            btnDesactivarTipoPago.setEnabled(false);
        }
        else{
           TipoPago temp;
           temp=tipoPagoDao.findTipoPago(cmbIDTipoPagoAgregar.getSelectedIndex());
           
           txtTipoPago.setText(temp.getNombre());
           btnAgregarTipoPago.setEnabled(false);
           btnModificarTipoPago.setEnabled(true);
           btnDesactivarTipoPago.setEnabled(true);
           ActivarDesactivarTipoPago();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDTipoPagoAgregarItemStateChanged

    private void txtTipoPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoPagoKeyTyped
                char c = evt.getKeyChar();
                if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'&& c != 'Ñ' && c != 'ñ' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú')&& (c!=KeyEvent.VK_SPACE) ){

            evt.consume();

        }
              
        if (txtTipoPago.getText().length() >= 25){
        
        evt.consume();
        
        }
    }//GEN-LAST:event_txtTipoPagoKeyTyped

    public int btnAgregarTipoPagoActionPerfomed(int cmbIDTipoPagoAgregar,String txtTipoPago){
         if(cmbIDTipoPagoAgregar==0){
            
        }
        else{
            cmbIDTipoPagoAgregar=0;
        }
        if(txtTipoPago.equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese el tipo de pago.", "CAMPO VACIO",0);
            return 0;
        }
        else{
            
        }
        if(txtTipoPago.length()<3){
            JOptionPane.showMessageDialog(null,"El tipo de pago debe llevar minimo tres letras","CARACTERES MINIMO",0);
            return 0;
                    
        }
        if(txtTipoPago.length()>15){
            JOptionPane.showMessageDialog(null,"El tipo de pago no puede tener mas de 15 caracteres","CARACTERES MAXIMO",0);
            return 0;
        }
        Validaciones v = new Validaciones();
        
        
        if(v.validacionTresLetras(txtTipoPago)){
            JOptionPane.showMessageDialog(null, "Tipo de Pago no valido \nContiene tres letras consecutivas iguales","TRES LETRAS CONSECUTIVAS",0);
            return 0;
        }
        
        
                
        if(!Validaciones.ValidacionNombreMayusculaYDemasMinus(txtTipoPago)){
//        JOptionPane.showMessageDialog(null,"El Tipo de Pago debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
//        txtTipoFactura.requestFocus();
        return 0;
        }else{

        }
        
        
        TipoPago tP = new TipoPago();
        
        List<TipoPago> temporal = tipoPagoDao.findTipoPagoEntities();
        for(TipoPago temp : temporal){
            if(temp.getNombre().toLowerCase().equals(txtTipoPago)){
                //JOptionPane.showMessageDialog(null, "Ya existe un tipo de pago igual","DATO DUPLICADO",0);
                return 100;
            }
            
        }
        
        tP.setNombre(txtTipoPago);
        tP.setEstado(true);
        
        //tipoPagoDao.create(tP);
        
//        cmbIDTipoPagoAgregar();
//        limpiarPanelTipoPago();
//        createTbTipoPago();
//        
//        tab_Ventas.setSelectedIndex(1);
//        createCmbTipoPago();
//        tab_Ventas.setSelectedIndex(4);
//        Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
//                JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        
                return 100;
    }
    
    private void btnAgregarTipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTipoPagoActionPerformed
        try{
        if(cmbIDTipoPagoAgregar.getSelectedIndex()==0){
            
        }
        else{
            cmbIDTipoPagoAgregar.setSelectedIndex(0);
        }
        if(txtTipoPago.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese el tipo de pago.", "CAMPO VACIO",0);
            return;
        }
        else{
            
        }
        if(txtTipoPago.getText().length()<3){
            JOptionPane.showMessageDialog(null,"El tipo de pago debe llevar minimo tres letras","CARACTERES MINIMO",0);
            return;
                    
        }
        if(txtTipoPago.getText().length()>15){
            JOptionPane.showMessageDialog(null,"El tipo de pago no puede tener mas de 15 caracteres","CARACTERES MAXIMO",0);
            return;
        }
        Validaciones v = new Validaciones();
        
        
        if(v.validacionTresLetras(txtTipoPago.getText())){
            JOptionPane.showMessageDialog(null, "Tipo de Pago no valido \nContiene tres letras consecutivas iguales","TRES LETRAS CONSECUTIVAS",0);
            return;
        }
        
        
                
        if(!Validaciones.ValidacionNombreMayusculaYDemasMinus(txtTipoPago.getText())){
        JOptionPane.showMessageDialog(null,"El Tipo de Pago debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
        txtTipoFactura.requestFocus();
        return;
        }else{

        }
        
        
        TipoPago tP = new TipoPago();
        
        List<TipoPago> temporal = tipoPagoDao.findTipoPagoEntities();
        for(TipoPago temp : temporal){
            if(temp.getNombre().toLowerCase().equals(txtTipoPago.getText())){
                JOptionPane.showMessageDialog(null, "Ya existe un tipo de pago igual","DATO DUPLICADO",0);
                return;
            }
            
        }
        
        tP.setNombre(txtTipoPago.getText());
        tP.setEstado(true);
        
        tipoPagoDao.create(tP);
        
        cmbIDTipoPagoAgregar();
        limpiarPanelTipoPago();
        createTbTipoPago();
        
        tab_Ventas.setSelectedIndex(1);
        createCmbTipoPago();
        tab_Ventas.setSelectedIndex(4);
        Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
                JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoPagoAgregar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarTipoPagoActionPerformed

    private void limpiarPanelTipoPago(){
        cmbIDTipoPagoAgregar.setSelectedIndex(0);
        txtTipoPago.setText("");
        btnAgregarTipoPago.setEnabled(true);
        btnModificarTipoPago.setEnabled(false);
        btnDesactivarTipoPago.setEnabled(false);
        
        
    }
    
    private void createTbTipoPago(){
        DefaultTableModel modelo9 = (DefaultTableModel) tbTipoPago.getModel();
        tbTipoPago.setModel(modelo9);
        int i;
        for(i=modelo9.getRowCount()-1;i>=0;i--){
            modelo9.removeRow(i);
        }
        /*modelo9.addColumn("ID");
        modelo9.addColumn("Tipo de Pago");
        modelo9.addColumn("Estado");*/
        
        List<TipoPago> temporal = tipoPagoDao.findTipoPagoEntities();
        for(TipoPago tp : temporal){
            modelo9.addRow(new Object[]{
                tp.getIdTipoPago(),
                tp.getNombre(),
                (tp.getEstado())? "Activo":"Inactivo"
            });
        }
        
        
    }
    
    private void cmbIDTipoPagoAgregar(){
        DefaultComboBoxModel xd = new DefaultComboBoxModel(); //si estas por aqui, tienes que poner UI-LILAC para entender 
        cmbIDTipoPagoAgregar.setModel(xd);
        
        xd.addElement("Nuevo");
        
        List<TipoPago> temporal = tipoPagoDao.findTipoPagoEntities();
        for(TipoPago t : temporal){
            xd.addElement(t.getIdTipoPago());
        }
        
        
        
    }
    
    public int btnModificarTipoPagoActionPerfomedTest(int cmbIDTipoPagoAgregar, String txtTipoPago){
            
        if(txtTipoPago.equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese el tipo de pago", "CAMPO VACIO",0);
            return 0;
        }
        else{
            
        }
        if(txtTipoPago.length()<3){
            JOptionPane.showMessageDialog(null,"El tipo de pago debe llevar minimo tres letras","CARACTERES MINIMO",0);
            return 0;
                    
        }
        if(txtTipoPago.length()>15){
            JOptionPane.showMessageDialog(null,"El tipo de pago no puede tener mas de 15 caracteres","CARACTERES MAXIMO",0);
            return 0;
        }
        Validaciones v = new Validaciones();
        
        
        if(v.validacionTresLetras(txtTipoPago)){
            JOptionPane.showMessageDialog(null, "Tipo de Pago no valido \nContiene tres letras consecutivas iguales","TRES LETRAS CONSECUTIVAS",0);
            return 0;
        }
        
        if(!Validaciones.ValidacionNombreMayusculaYDemasMinus(txtTipoPago)){
            JOptionPane.showMessageDialog(null,"El Tipo de Pago debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
                //txtTipoFactura.requestFocus();
                return 0;
            }else{

            }
        
        
        TipoPago tP = tipoPagoDao.findTipoPago(cmbIDTipoPagoAgregar);
        
        List<TipoPago> temporal = tipoPagoDao.findTipoPagoEntities();
        for(TipoPago temp : temporal){
            if(temp.getNombre().toLowerCase().equals(txtTipoPago)){
                //JOptionPane.showMessageDialog(null, "Ya existe un tipo de pago igual","DATO DUPLICADO",0);
                return 100;
            }
            
        }
        
        
        
        
        tP.setNombre(txtTipoPago);
        
        
//        try {
//            tipoPagoDao.edit(tP);
//        } catch (Exception ex) {
//            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//        cmbIDTipoPagoAgregar();
//        limpiarPanelTipoPago();
//        createTbTipoPago();
//        tab_Ventas.setSelectedIndex(1);
//        createCmbTipoPago();
//        tab_Ventas.setSelectedIndex(4);
//        Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
//                    JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
        
        
        return 100;
    }
    
    private void btnModificarTipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTipoPagoActionPerformed
        try{
        if(txtTipoPago.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese el tipo de pago", "CAMPO VACIO",0);
            return;
        }
        else{
            
        }
        if(txtTipoPago.getText().length()<3){
            JOptionPane.showMessageDialog(null,"El tipo de pago debe llevar minimo tres letras","CARACTERES MINIMO",0);
            return;
                    
        }
        if(txtTipoPago.getText().length()>15){
            JOptionPane.showMessageDialog(null,"El tipo de pago no puede tener mas de 15 caracteres","CARACTERES MAXIMO",0);
            return;
        }
        Validaciones v = new Validaciones();
        
        
        if(v.validacionTresLetras(txtTipoPago.getText())){
            JOptionPane.showMessageDialog(null, "Tipo de Pago no valido \nContiene tres letras consecutivas iguales","TRES LETRAS CONSECUTIVAS",0);
            return;
        }
        
        if(!Validaciones.ValidacionNombreMayusculaYDemasMinus(txtTipoPago.getText())){
            JOptionPane.showMessageDialog(null,"El Tipo de Pago debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
                txtTipoFactura.requestFocus();
                return;
            }else{

            }
        
        
        TipoPago tP = tipoPagoDao.findTipoPago(cmbIDTipoPagoAgregar.getSelectedIndex());
        
        List<TipoPago> temporal = tipoPagoDao.findTipoPagoEntities();
        for(TipoPago temp : temporal){
            if(temp.getNombre().toLowerCase().equals(txtTipoPago.getText())){
                JOptionPane.showMessageDialog(null, "Ya existe un tipo de pago igual","DATO DUPLICADO",0);
                return;
            }
            
        }
        
        
        
        
        tP.setNombre(txtTipoPago.getText());
        
        
        
            tipoPagoDao.edit(tP);
        
        
        cmbIDTipoPagoAgregar();
        limpiarPanelTipoPago();
        createTbTipoPago();
        tab_Ventas.setSelectedIndex(1);
        createCmbTipoPago();
        tab_Ventas.setSelectedIndex(4);
        Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
                    JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
        
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoPagoModificar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarTipoPagoActionPerformed

    private void btnLimpiar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar4ActionPerformed
        try{
        limpiarPanelTipoPago();
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoPagoLimpiar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiar4ActionPerformed

    public int btnDesactivarTipoPagoActionPerfomedTest(int cmbIDTipoPagoAgregar){
        TipoPago temp;
        temp = tipoPagoDao.findTipoPago(cmbIDTipoPagoAgregar);
        if(temp.getEstado()){
            temp.setEstado(false);
//            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
//            JOptionPane.showMessageDialog(null,"Tipo de Pago Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
//            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
//            JOptionPane.showMessageDialog(null,"Tipo de Pago Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
//        try {
//            tipoPagoDao.edit(temp);
//        } catch (Exception ex) {
//            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        limpiarPanelTipoPago();
//        cmbIDTipoPagoAgregar();
//        limpiarPanelTipoPago();
//        createTbTipoPago();
        return 100;
    }
    
    private void btnDesactivarTipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarTipoPagoActionPerformed
        try{
        TipoPago temp;
        temp = tipoPagoDao.findTipoPago(cmbIDTipoPagoAgregar.getSelectedIndex());
        if(temp.getEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Tipo de Pago Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Tipo de Pago Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
      
            tipoPagoDao.edit(temp);
        
        limpiarPanelTipoPago();
        cmbIDTipoPagoAgregar();
        limpiarPanelTipoPago();
        createTbTipoPago();
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoPagoDesactivar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesactivarTipoPagoActionPerformed

    private void tbTipoPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTipoPagoMouseClicked
        int fila = tbTipoPago.getSelectedRow();
         TipoPago temp;
         if (fila > -1){
           temp=tipoPagoDao.findTipoPago(Integer.parseInt(tbTipoPago.getModel().getValueAt(fila, 0).toString()));
           cmbIDTipoPagoAgregar.setSelectedIndex(temp.getIdTipoPago());
           txtTipoPago.setText(temp.getNombre());
           btnAgregarTipoPago.setEnabled(false);
           btnModificarTipoPago.setEnabled(true);
           btnDesactivarTipoPago.setEnabled(true);
           ActivarDesactivarTipoPago();
           
           
           //btnActivarDesactivarCAI();
           
       }

        // TODO add your handling code here:
    }//GEN-LAST:event_tbTipoPagoMouseClicked

    private void tbTipoPagoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTipoPagoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbTipoPagoMouseEntered

    private void txtIDPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDPiezaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPiezaActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cmbTipoPagoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoPagoItemStateChanged
        //JOptionPane.showMessageDialog(null,cmbTipoPago.getSelectedItem());
        if(cmbTipoPago.getSelectedIndex()==0 || cmbTipoPago.getSelectedItem().equals("Efectivo")){
            ltarjeta.setVisible(false);
            txtTarjeta.setVisible(false);
        }
        else{
            ltarjeta.setVisible(true);
            txtTarjeta.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoPagoItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
        if(txtNumFacturaRechazo.getText().equals("   -   -  -        ")){
            JOptionPane.showMessageDialog(null, "Ingrese un número de Factura","CAMPO VACIO",0);
            return;
        }
        if(cmbNombreEmpleado.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Seleccione el Nombre del Empleado","CAMPO VAACIO",0);
            return;            
        }
        
        List<Factura> fac = facturaDao.findFacturaEntities();
        Factura factura=null;
        for(Factura f : fac){
            if(f.getNumFactura().equals(txtNumFacturaRechazo.getText())){
                factura=f;
                break;
            }
        }
        if(factura==null){
            JOptionPane.showMessageDialog(null, "Factura no encontrada","NO ENCONTRADO",0);
            return;
        }
        
        if(factura.getIdEmpleado()!=cmbNombreEmpleado.getSelectedIndex()){
            JOptionPane.showMessageDialog(null, "El empleado seleccionado no coincide con el de la factura","NO COINCIDENCIA",0);
            return;
        }
        
        
        crearTbFacturaRechazar(factura);
        
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"FacturaRechazarBuscar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try{
        if(txtAComentario.getText().replace(" ", "").equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese un comentario sobre el rechazo de la Factura","COMENTARIO EN BLANCO",0);
            return;
        }    
        
        Validaciones va = new Validaciones();
        
        if(va.validacionTresLetras(txtAComentario.getText())){
            JOptionPane.showMessageDialog(null,"Comentario Invalido, no puede contener 3 letras consecutivas","COMENTARIO INVALIDO",0);
            return;
        }
        
        int fila = tbBusquedaRechazar.getSelectedRow();
        
        if(fila>-1){
            int confirmacion = JOptionPane.showConfirmDialog(null, "Una vez Rechazada la Factura no se puede revocar\nDesa Continuar?");
            JOptionPane.showMessageDialog(null, confirmacion);
            if(confirmacion==0){
                Factura aux = facturaDao.findFactura(Integer.parseInt((String.valueOf(tbBusquedaRechazar.getValueAt(0, fila)))));
                aux.setEstado(false);
                try {
                    facturaDao.edit(aux);
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }
                List<PiezaFactura> piezaIncremento = piezaFacturaDao.findPiezaFacturaEntities()  ;
                
                for(PiezaFactura pi : piezaIncremento){
                    if(pi.getIdFactura()==aux.getIDFactura()){
                        int incremento;
                        incremento = pi.getCantidad();
                        
                        Pieza batata = piezaDao.findPieza(pi.getIdPieza());
                        incremento+=batata.getStock();
                        batata.setStock(incremento);
                        
                        try {
                            piezaDao.edit(batata);
                        } catch (Exception ex) {
                            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }      
                }
                
                List<VehiculoFactura> vehi = vehiculoFacturaDao.findVehiculoFacturaEntities();
                
                for(VehiculoFactura vf : vehi){
                    if(vf.getIdFactura()==aux.getIDFactura()){
                        int incremento=1;
                        vf.setEstado(false);
                        
                        Vehiculo  v= vehiculoDao.findVehiculo(vf.getIdVehiculo());
                        
                        incremento +=v.getStock();
                        
                        v.setStock(incremento);
                        
                        try {
                            vehiculoFacturaDao.edit(vf);
                        } catch (Exception ex) {
                            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        try {
                            vehiculoDao.edit(v);
                        } catch (Exception ex) {
                            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                }
                        
                
                
                //A;adir a la de factura rechazadas
                Facturarechazada facRec = new Facturarechazada();
                
                facRec.setDescripcion(txtAComentario.getText());
                facRec.setId(aux.getIDFactura());
                
                
                Calendar fecha = new GregorianCalendar();
                String auxFecha = (fecha.get(Calendar.MONTH)<=9)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH)+1);
                switch(auxFecha){
            case "01":
                    auxFecha= "01";
                    break;
                    case "02":
                    auxFecha= "02";
                    break;case "03":
                    auxFecha= "03";
                    break;case "04":
                    auxFecha= "04";
                    break;case "05":
                    auxFecha= "05";
                    break;case "06":
                    auxFecha= "06";
                    break;case "07":
                    auxFecha= "07";
                    break;case "08":
                    auxFecha= "08";
                    break;case "09":
                    auxFecha= "09";
                    break;
            case "010":
                    auxFecha= "10";
                    break;
            case "011":
                   auxFecha= "11";
                    break;      
            case "012":
                    auxFecha= "12";
                    break;
                    default:
                    break;
        }
                String auxF=auxFecha;
                String auxDia=(fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.DAY_OF_MONTH))) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                
                facRec.setFechaRechazo(String.valueOf(fecha.get(Calendar.YEAR))+auxF+auxDia);
                
                facturaRechazada.create(facRec);
                
                
            }
            
            
        } else {
            JOptionPane.showMessageDialog(null,"Seleccione una Factura","FACTURA SIN SELECCIONAR",0);
        }
        
        
        
        
        crearTbFacturasRechazado();
        
        }catch(Exception e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"FacturaRechazarRechazar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        
        int fila = jTable3.getSelectedRow();
        if(fila > -1){
            List<Factura> fac = facturaDao.findFacturaEntities();
            Factura facw = null;
            for(Factura w : fac ){
                if(w.getNumFactura().equals(jTable3.getValueAt(fila, 0))){
                    facw=w;
                    break;
                }
            }
           // JOptionPane.showMessageDialog(null, facw.getNumFactura());
            try {
                this.imprimirFacturaBusqueda(facw);
            } catch (JRException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        

// TODO add your handling code here:
    }//GEN-LAST:event_jTable3MouseClicked

    private void tbFacturaRechazadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFacturaRechazadaMouseClicked
        try{
        int fila = tbFacturaRechazada.getSelectedRow();
        if(fila > -1){
            List<Factura> fac = facturaDao.findFacturaEntities();
            Factura facw = null;
            for(Factura w : fac ){
                if(w.getNumFactura().equals(tbFacturaRechazada.getValueAt(fila, 0))){
                    facw=w;
                    break;
                }
            }
           // JOptionPane.showMessageDialog(null, facw.getNumFactura());
            
                this.imprimirFacturaBusqueda(facw);
            
            
            
        }
        }catch(JRException e){
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh;
                fh = new FileHandler("./"+"FacturaRechazadaImprimir"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbFacturaRechazadaMouseClicked

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void txtDocumentoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoClienteKeyTyped
         char c = evt.getKeyChar();
        if((c < '0' || c > '9')&&(c < 'A' || c > 'Z')){

            evt.consume();

        }
        if (txtDocumentoCliente.getText().length() >= 14){
        
        evt.consume();
        
        }
              
    }//GEN-LAST:event_txtDocumentoClienteKeyTyped

    private void txtTarjetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTarjetaKeyTyped
        char c = evt.getKeyChar();
        if((c < '0' || c > '9') && (c != '-')){

            evt.consume();

        }
              
        if (txtTarjeta.getText().length() >= 20)
        {
            evt.consume();        
        }
    }//GEN-LAST:event_txtTarjetaKeyTyped

    private void txtIDVehiculoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDVehiculoKeyTyped
char c = evt.getKeyChar();
        if((c < '0' || c > '9')){

            evt.consume();

        }
        if (txtIDVehiculo.getText().length() >= 5){
        
        evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDVehiculoKeyTyped

    private void txtVINKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVINKeyTyped
        char c = evt.getKeyChar();

        if((c < 'a' || c > 'z') && (c < '0' || c > '9')&& (c < 'A' || c > 'Z')){

            evt.consume();

        }
              
        if (txtVIN.getText().length() >= 18)
        {
            evt.consume();        
        }
    }//GEN-LAST:event_txtVINKeyTyped

    private void txtCAIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCAIKeyTyped
        
        char c = evt.getKeyChar();

        if((c < 'A' || c > 'Z') && (c < 'a' || c > 'z') && (c < '0' || c > '9') &&  (c != '-' ) ){

            evt.consume();

        }

              
        if (txtCAI.getText().length() >= 38)
        {
            evt.consume();        
        }
    }//GEN-LAST:event_txtCAIKeyTyped

    private void txtFechaInicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaInicioKeyTyped
                char c = evt.getKeyChar();
        if((c < '0' || c > '9') && (c != '/')){

            evt.consume();

        }
        if (txtFechaInicio.getText().length() >= 10){
        
        evt.consume();
        }
    }//GEN-LAST:event_txtFechaInicioKeyTyped

    private void txtFechaFinalizacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaFinalizacionKeyTyped
                        char c = evt.getKeyChar();
        if((c < '0' || c > '9') && (c != '/')){

            evt.consume();

        }
        if (txtFechaFinalizacion.getText().length() >= 10){
        
        evt.consume();
        }
    }//GEN-LAST:event_txtFechaFinalizacionKeyTyped

    private void txtDeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDeKeyTyped
                char c = evt.getKeyChar();
        if((c < '0' || c > '9') && (c != '-')){

            evt.consume();

        }
              
        
    }//GEN-LAST:event_txtDeKeyTyped

    private void txtHastaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHastaKeyTyped
                        char c = evt.getKeyChar();
        if((c < '0' || c > '9') && (c != '-')){

            evt.consume();

        }
              
        
    }//GEN-LAST:event_txtHastaKeyTyped

    private void txtNumFacturaBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumFacturaBusquedaKeyTyped
                char c = evt.getKeyChar();
        if((c < '0' || c > '9') && (c != '-')){

            evt.consume();

        }
              
        if (txtNumFactura.getText().length() >= 20)
        {
            evt.consume();        
        }
    }//GEN-LAST:event_txtNumFacturaBusquedaKeyTyped

    private void txtClienteBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteBusquedaKeyTyped
        char c = evt.getKeyChar();
        if((c < '0' || c > '9')&&(c < 'A' || c > 'Z')){

            evt.consume();

        }
        if (txtClienteBusqueda.getText().length() >= 14){
        
        evt.consume();
        
        }
    }//GEN-LAST:event_txtClienteBusquedaKeyTyped

    private void txtNumFacturaRechazoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumFacturaRechazoKeyTyped
         char c = evt.getKeyChar();
        if((c < '0' || c > '9') && (c != '-')){

            evt.consume();

        }
              
        if (txtNumFacturaRechazo.getText().length() >= 20)
        {
            evt.consume();        
        }
    }//GEN-LAST:event_txtNumFacturaRechazoKeyTyped

    private void generarReporteTipoFacturaExcel() throws ClassNotFoundException, SQLException, JRException, IOException{
        Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteTipoFactura.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,con);
        //JasperViewer.viewReport(print);
        
       // File excel = File.createTempFile("Reporte de Bancos"+"-"+".", ".xls",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
            JRXlsxExporter exporter = new JRXlsxExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\Reportes\\reporteTipoFactura.xlsx");

            exporter.exportReport();
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\Reportes\\reporteTipoFactura.xlsx");
        p.start();
    }
    
    private void btnAgregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar3ActionPerformed

        try {
            generarReporteTipoFacturaExcel();
            // TODO add your handling code here:
        } catch (ClassNotFoundException | SQLException | JRException | IOException e) {
           try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoFacturaExcel"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgregar3ActionPerformed

    private void generarReporteTipoFactura() throws ClassNotFoundException, SQLException, JRException, IOException{
        
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteTipoFactura.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", this.empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,con);
        //JasperViewer.viewReport(print);
        
        File pdf = File.createTempFile("Reporte de Tipos de Facturas"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
        JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        //JOptionPane.showMessageDialog(null,pdf.getPath());
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
        p.start();
    }
    
    private void btnAgregar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar4ActionPerformed

        try {
            generarReporteTipoFactura();
            // TODO add your handling code here:
        } catch (JRException | SQLException | ClassNotFoundException | IOException e) {
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoFacturaPDF"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgregar4ActionPerformed

    private void generarReporteCAI()throws ClassNotFoundException, SQLException, JRException, IOException{
        Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteCAI.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", this.empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,con);
        //JasperViewer.viewReport(print);
        
        File pdf = File.createTempFile("Reporte de CAI"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
        JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        //JOptionPane.showMessageDialog(null,pdf.getPath());
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
        p.start();
        
    }
    
    private void btnAgregar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar5ActionPerformed

        try {
            generarReporteCAI();
            // TODO add your handling code here:
        } catch (JRException | SQLException | ClassNotFoundException | IOException e) {
           try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"CAIPDF"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgregar5ActionPerformed

    private void generarReporteCAIExcel()throws ClassNotFoundException, SQLException, JRException, IOException{
        Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteCAI.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,con);
        //JasperViewer.viewReport(print);
        
       // File excel = File.createTempFile("Reporte de Bancos"+"-"+".", ".xls",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
            JRXlsxExporter exporter = new JRXlsxExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\Reportes\\reporteCAI.xlsx");

            exporter.exportReport();
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\Reportes\\reporteCAI.xlsx");
        p.start();
    }
    
    private void btnAgregar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar6ActionPerformed

        try {
            generarReporteCAIExcel();
            // TODO add your handling code here:
        } catch (ClassNotFoundException | SQLException | JRException | IOException e) {
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"CAIExcel"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgregar6ActionPerformed

    private void generarReportePago() throws ClassNotFoundException, SQLException, JRException, IOException{
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteTipoPago.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", this.empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,con);
        //JasperViewer.viewReport(print);
        
        File pdf = File.createTempFile("Reporte de Tipo de Pagos"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
        JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
        //JOptionPane.showMessageDialog(null,pdf.getPath());
        ProcessBuilder p = new ProcessBuilder();
        p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
        p.start();
    }
    
    private void btnAgregar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar7ActionPerformed

        try {
            generarReportePago();
            // TODO add your handling code here:
        } catch (JRException | SQLException | ClassNotFoundException | IOException e) {
           try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoPagoPDF"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgregar7ActionPerformed

    private void generarReporteBancoExcel() throws ClassNotFoundException, SQLException, JRException, IOException{
        Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        
        JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteTipoPago.jrxml");
        HashMap param = new HashMap();
        param.put("Empleado", empNomb);
        JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,con);
        //JasperViewer.viewReport(print);
        
       // File excel = File.createTempFile("Reporte de Bancos"+"-"+".", ".xls",new File("C:\\CarSoft-Version-2.1\\Reportes"));
        
            JRXlsxExporter exporter = new JRXlsxExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\Reportes\\reporteTipoPago.xlsx");

            exporter.exportReport();
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\Reportes\\reporteTipoPago.xlsx");
        p.start();
    }
    
    private void btnAgregar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar8ActionPerformed

        try {
            generarReporteBancoExcel();
            // TODO add your handling code here:
        } catch (ClassNotFoundException | SQLException | JRException | IOException e) {
            try {
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
                switch(aux2){
                    case "01":
                        aux2= "01";
                        break;
                    case "02":
                        aux2= "02";
                        break;case "03":
                            aux2= "03";
                            break;case "04":
                                aux2= "04";
                                break;case "05":
                                    aux2= "05";
                                    break;case "06":
                                        aux2= "06";
                                        break;case "07":
                                            aux2= "07";
                                            break;case "08":
                                                aux2= "08";
                                                break;case "09":
                                                    aux2= "09";
                                                    break;
                                                case "010":
                                                    aux2= "10";
                                                    break;
                                                case "011":
                                                    aux2= "11";
                                                    break;
                                                case "012":
                                                    aux2= "12";
                                                    break;
                                                default:
                                                    break;
                }
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                fecha1 = aux1+"-"+aux2+"-"+aux3+" "+fecha.get(Calendar.HOUR_OF_DAY)+" "+fecha.get(Calendar.MINUTE)+" "+fecha.get(Calendar.SECOND);
                Logger logger = Logger.getLogger(Ventas.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"TipoPagoExcel"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgregar8ActionPerformed

    private void crearTbFacturasRechazado(){
        DefaultTableModel modelo = (DefaultTableModel) tbFacturaRechazada.getModel();
        
        List<Facturarechazada> facRec = facturaRechazada.findFacturarechazadaEntities();
        
        for(Facturarechazada rz : facRec){
            modelo.addRow(new Object[]{facturaDao.findFactura(rz.getId()).getNumFactura(),
            rz.getFechaRechazo(),"Rechazado",rz.getDescripcion()});
            
        }
        
        
    } 
    
    private void crearTbFacturaRechazar(Factura temporal){
        DefaultTableModel de = (DefaultTableModel) tbBusquedaRechazar.getModel();
        
        Persona p = personaDao.findPersona(empleadoDao.findEmpleado(temporal.getIdEmpleado()).getId_Persona());
        
        de.addRow(new Object[]{temporal.getIDFactura(),temporal.getFechaHora(),p.getNombre()+" "+p.getApellido()});
        
        
        
    }
    
    private void cargarCmbNombreEmpleado(){
        DefaultComboBoxModel er = new DefaultComboBoxModel();
        cmbNombreEmpleado.setModel(er);
        er.addElement("Seleccione");
        
        List<Empleado> empleado = empleadoDao.findEmpleadoEntities();
        
        for(Empleado e : empleado){
            er.addElement(personaDao.findPersona(e.getId_Persona()).getNombre()+" "+personaDao.findPersona(e.getId_Persona()).getApellido());      
        }
    
    
    }
    
    private void createTableCAI(){
        DefaultTableModel modelo10 = (DefaultTableModel) tbCAI.getModel();
        tbCAI.setModel(modelo10);
        int i;
        for(i=modelo10.getRowCount()-1;i>=0;i--){
            modelo10.removeRow(i);
        }
        /*modelo10.addColumn("ID");
        modelo10.addColumn("CAI");
        modelo10.addColumn("Fecha de Inicio");
        modelo10.addColumn("Fecha Limite");
        modelo10.addColumn("Desde");
        modelo10.addColumn("Hasta");
        modelo10.addColumn("Estado");*/
        
        List<informacionFiscal> temporal = infFiscalDao.findinformacionFiscalEntities();
        int contador=0;
        for(informacionFiscal e : temporal){
            ;
            modelo10.addRow(new Object[]{
                e.getIdInf(),
                e.getCai(),
                e.getFechaInicio().substring(8, 10)+"/"+e.getFechaInicio().substring(5, 7)+"/"+e.getFechaInicio().substring(0,4),
                e.getFechaFinal().substring(8, 10)+"/"+e.getFechaFinal().substring(5, 7)+"/"+e.getFechaFinal().substring(0,4),
                e.getInicio(),
                e.getFin(),
                (e.isEstado())? "Activo": "Inactivo"
                    
            });
         /*   modelo10.isCellEditable( contador,0);
            modelo10.isCellEditable(contador,1 );
            modelo10.isCellEditable(contador, 2);
            modelo10.isCellEditable(contador, 3);
            modelo10.isCellEditable(contador, 4);
            modelo10.is*/
        }
        
        
        
    }
    
    private void limpiarCAI(){
        txtCAI.setText("");
        txtFechaInicio.setText("");
        txtFechaFinalizacion.setText("");
        txtDe.setText("");txtHasta.setText("");
        jButton1.setEnabled(true);
        btnModificar3.setEnabled(false);
        btnDesactivar4.setEnabled(false);
    }
    
    private void setTxtNumFactura(){
        txtNumFactura.setText(String.valueOf(facturaDao.getFacturaCount()+1));
    }
    
    private void crearCmbIDPieza(){
     /*   DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
        cmbIDPieza.setModel(modelo1);
        modelo1.addElement("Seleccione");
        
        List<Pieza> temp = piezaDao.findPiezaEntities();
        for(Pieza e : temp){
            modelo1.addElement(e.getId_Pieza());
        }
     */   
    }
    
    private void crearCmbIDVehiculo(){
       /* DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
        cmbIDVehiculo.setModel(modelo1);
        modelo1.addElement("Seleccione");
        
        List<Vehiculo> temp = vehiculoDao.findVehiculoEntities();
        
        for(Vehiculo e : temp){
            modelo1.addElement(e.getId_vehiculo());
        }*/
    }
    
    private void setFechatxt(){
        
        Calendar fecha = new GregorianCalendar();
        String fecha1;
        String aux1,aux2,aux3;
        aux1 = Integer.toString(fecha.get(Calendar.YEAR));
        aux2 = (fecha.get(Calendar.MONTH)<=9)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
        aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        switch(aux2){
            case "01":
                    aux2= "01";
                    break;
                    case "02":
                    aux2= "02";
                    break;case "03":
                    aux2= "03";
                    break;case "04":
                    aux2= "04";
                    break;case "05":
                    aux2= "05";
                    break;case "06":
                    aux2= "06";
                    break;case "07":
                    aux2= "07";
                    break;case "08":
                    aux2= "08";
                    break;case "09":
                    aux2= "09";
                    break;
            case "010":
                    aux2= "10";
                    break;
            case "011":
                    aux2= "11";
                    break;      
            case "012":
                    aux2= "12";
                    break;
                    default:
                    break;
        }
        String auxF=aux2;
        fecha1 = aux1+auxF+aux3;
        
        txtFecha.setText(aux3+"/"+auxF+"/"+aux1+"   "+fecha.get(Calendar.HOUR_OF_DAY)+":"+fecha.get(Calendar.MINUTE)/*+":"+fecha.get(Calendar.SECOND)*/);
        
    }
    
    private void crearTbVenta(){
        DefaultTableModel modelo = (DefaultTableModel) tbVenta.getModel();
        tbVenta.setModel(modelo);
//        modelo.addColumn("ID");
//        modelo.addColumn("Descripcion");
//        modelo.addColumn("Precio Unit");
//        modelo.addColumn("Cant");
//        modelo.addColumn("SubTotal");
    }
    
    private void crearCmbIDEmpleado(){
        DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
        cmbIDEmpleado.setModel(modelo1);
        modelo1.addElement("Seleccione");
        List<Empleado> temp = empleadoDao.findEmpleadoEntities();
        for(Empleado e : temp){
            modelo1.addElement(personaDao.findPersona(e.getId_Persona()).getNombre()+" "+personaDao.findPersona(e.getId_Persona()).getApellido());
        }
        
    }
    
    public void setCmbEmpleado(int valor){
        cmbIDEmpleado.setSelectedIndex(valor);
    }
    
    private void crearTbVentaAgregarVehiculo(){
        DefaultTableModel modelo = (DefaultTableModel) tbVenta.getModel();
        tbVenta.setModel(modelo);
        
        
        if("".equals(txtIDVehiculo.getText())){
            JOptionPane.showMessageDialog(null,"Por favor, seleccione un Vehiculo","ID SIN SELECCIONAR",0);
            return;
        }
        
         if("0".equals(txtIDVehiculo.getText())){
            JOptionPane.showMessageDialog(null,"No hay ningun Vehiculo con ID 0 ","ID NO RECONOCIDO",0);
            return;
        }
        
        
        Vehiculo temp = vehiculoDao.findVehiculo(Integer.parseInt(txtIDVehiculo.getText()));
        
        if(temp==null){
            JOptionPane.showMessageDialog(null,"Vehiculo no encontrado","ID NO VALIDO",0);
            return;
        }
        
        if(txtVIN.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese el VIN del Vehiculo","CAMPO VACíO",0);
            return;
        }
        
        Pattern pat = Pattern.compile("^(?=.*[0-9])(?=.*[A-z])[0-9A-z-]{17}$");
        Matcher mat = pat.matcher(txtVIN.getText());
        
        
        if(!mat.matches()){
            JOptionPane.showMessageDialog(null, "VIN no Valido","VIN INVALIDO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        
        
        
        if(temp.getStock()==0){
            JOptionPane.showMessageDialog(null, "No hay vehiculos disponibles en el inventario","Sin Stock",0);
            return;
        }
        
        if(!temp.isEstado()){
            JOptionPane.showMessageDialog(null, "Vehiculo descontinuada, por favor, Ponerse en contacto con el Gerente","VEHICULO DESCONTINUADO",0);
        }
     
        List<HistoricoPrecioVehiculos> temp2 = historicoVehiculoDao.findHistoricoPrecioVehiculosEntities();
        double aux=0.00;
        for(HistoricoPrecioVehiculos e : temp2){
            if(e.getId_vehiculo()==temp.getId_vehiculo() && e.getFechaFinal()==null){
                aux=e.getPrecio();
            }
        }
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        
        
        modelo.addRow(new Object[]{
            temp.getId_vehiculo(),"2"+txtVIN.getText()+Marcadao.findMarca(temp.getId_marca()).getMarca()+temp.getVin(),formato1.format(aux),1,formato1.format((aux))
        });
        
        
        double contenedorPrecio=0;
        double contenedorImpuesto=0;
        for(int i=0;i<modelo.getRowCount();i++){
            contenedorPrecio+=Double.parseDouble((String) modelo.getValueAt(i, 4));
            contenedorImpuesto+=Double.parseDouble((String) modelo.getValueAt(i, 4))*0.18;
            
        }
        contenedorPrecio+=contenedorImpuesto;
        txtImpuesto.setText(formato1.format(contenedorImpuesto));
        txtTotal.setText(formato1.format(contenedorPrecio));
        
    }
    
    private void crearTbVentaAgregarPieza(){
        //label1.setText("11223");
       DefaultTableModel modelo = (DefaultTableModel) tbVenta.getModel();
        tbVenta.setModel(modelo);
        
        
        if("".equals(txtIDPieza.getText())){
            JOptionPane.showMessageDialog(null,"Por favor, seleccione una pieza","ID SIN SELECCIONAR",0);
            return;
        }
        
        if("0".equals(txtIDPieza.getText())){
            JOptionPane.showMessageDialog(null,"No hay ninguna pieza con ID 0 ","ID NO RECONOCIDO",0);
            return;
        }
        
        Pieza temp = piezaDao.findPieza(Integer.parseInt(txtIDPieza.getText()));
        
        if(temp==null){
            JOptionPane.showMessageDialog(null,"Pieza no encontrada","ID NO VALIDO",0);
            return;
        }
        
        if(txtCantidad.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese la cantidad","CAMPO VACíO",0);
            return;
        }
        
        if(temp.getStock()==0){
            JOptionPane.showMessageDialog(null, "No hay piezas en el inventario","Sin Stock",0);
            return;
        }
        
        if((temp.getStock()-Integer.parseInt(txtCantidad.getText()))<0){
            JOptionPane.showMessageDialog(null,"No hay inventario suficiente","ESCACEZ DE INVENTARIO",0);
            return;
        }
        
        if(!temp.isEstado()){
            JOptionPane.showMessageDialog(null, "Pieza descontinuada, por favor, Ponerse en contacto con el Gerente","PIEZA DESCONTINUADA",0);
        }
     
        
        
        List<HistoricoPrecioPieza> temp2 = historicoPiezaDao.findHistoricoPrecioPiezaEntities();
        double aux=0.00;
        for(HistoricoPrecioPieza e : temp2){
            if(e.getIdPieza()==temp.getId_Pieza() && e.getFechaFinal()==null){
                aux=e.getPrecio();
            }
        }
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        
        int seleccion = 0;
        boolean bandera=false;
        
        for(int i=0;i<modelo.getRowCount();i++){
            if(Integer.parseInt(String.valueOf(modelo.getValueAt(i, 0)))==temp.getId_Pieza()){
                bandera=true;
                seleccion=i;
                break;                        
            }
            
        }
        
        if(bandera){
            int auxiliarCantidad = Integer.parseInt(txtCantidad.getText());
            int auxiliarCantidad2 = Integer.parseInt(String.valueOf(modelo.getValueAt(seleccion, 3)));
            
            modelo.setValueAt((auxiliarCantidad+auxiliarCantidad2), seleccion, 3);
            modelo.setValueAt((formato1.format((aux*(auxiliarCantidad+auxiliarCantidad2)))),seleccion, 4);
            
        }
        else{
        modelo.addRow(new Object[]{
            temp.getId_Pieza(),"1"+temp.getNombre()+temp.getCarateristica_Pieza(),formato1.format(aux),txtCantidad.getText(),formato1.format((aux*Double.parseDouble(txtCantidad.getText())))
        });
        }
        double contenedorPrecio=0;
        double contenedorImpuesto=0;
        for(int i=0;i<modelo.getRowCount();i++){
            contenedorPrecio+=Double.parseDouble((String) modelo.getValueAt(i, 4));
            contenedorImpuesto+=Double.parseDouble((String) modelo.getValueAt(i, 4))*0.18;
             
            
        }
        contenedorPrecio+=contenedorImpuesto;
        txtImpuesto.setText(formato1.format(contenedorImpuesto));
        txtTotal.setText(formato1.format(contenedorPrecio));
    }
    
    private void limpiarPieza(){
        txtIDPieza.setText("");
        txtNombre.setText("");
        txtCantidad.setText("");
    }
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnAgregar3;
    private javax.swing.JButton btnAgregar4;
    private javax.swing.JButton btnAgregar5;
    private javax.swing.JButton btnAgregar6;
    private javax.swing.JButton btnAgregar7;
    private javax.swing.JButton btnAgregar8;
    private javax.swing.JButton btnAgregarPieza;
    private javax.swing.JButton btnAgregarTipoPago;
    private javax.swing.JButton btnAgregarVehiculo;
    private javax.swing.JButton btnDesactivar3;
    private javax.swing.JButton btnDesactivar4;
    private javax.swing.JButton btnDesactivarTipoPago;
    private javax.swing.JButton btnImprimirFactura;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnLimpiar3;
    private javax.swing.JButton btnLimpiar4;
    private javax.swing.JButton btnModificar2;
    private javax.swing.JButton btnModificar3;
    private javax.swing.JButton btnModificarTipoPago;
    private javax.swing.JButton btnRegresar2;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JCheckBox chkCliente;
    public javax.swing.JCheckBox chkNumFactura;
    public static javax.swing.JComboBox<String> cmbIDEmpleado;
    private javax.swing.JComboBox<String> cmbIDNuevoFactura;
    private javax.swing.JComboBox<String> cmbIDTipoPagoAgregar;
    private javax.swing.JComboBox<String> cmbNombreEmpleado;
    private javax.swing.JComboBox<String> cmbTipoFacturaVenta;
    private javax.swing.JComboBox<String> cmbTipoPago;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lCAI;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel ltarjeta;
    private javax.swing.JLabel ltrampa;
    private javax.swing.JTabbedPane tab_Ventas;
    private javax.swing.JTable tbBusquedaRechazar;
    private javax.swing.JTable tbCAI;
    private javax.swing.JTable tbFacturaRechazada;
    private javax.swing.JTable tbTipoPago;
    private javax.swing.JTable tbVenta;
    private javax.swing.JTable tblNuevoCargo;
    private javax.swing.JTextArea txtAComentario;
    private javax.swing.JTextField txtCAI;
    private javax.swing.JFormattedTextField txtCantidad;
    private javax.swing.JTextField txtClienteBusqueda;
    private javax.swing.JFormattedTextField txtDe;
    private javax.swing.JTextField txtDocumentoCliente;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JFormattedTextField txtFechaFinalizacion;
    private javax.swing.JFormattedTextField txtFechaInicio;
    private javax.swing.JFormattedTextField txtHasta;
    public static javax.swing.JFormattedTextField txtIDPieza;
    private javax.swing.JFormattedTextField txtIDVehiculo;
    private javax.swing.JFormattedTextField txtImpuesto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumFactura;
    public javax.swing.JFormattedTextField txtNumFacturaBusqueda;
    private javax.swing.JFormattedTextField txtNumFacturaRechazo;
    private javax.swing.JFormattedTextField txtTarjeta;
    private javax.swing.JTextField txtTipoFactura;
    private javax.swing.JTextField txtTipoPago;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVIN;
    // End of variables declaration//GEN-END:variables
}
