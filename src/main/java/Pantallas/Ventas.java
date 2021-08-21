/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.exolab.castor.types.Date;


/**
 *
 * @author Usuario
 */
public class Ventas extends javax.swing.JFrame {

    
    Tipo_DocumentoJpaController tipoDocumentoDao = new Tipo_DocumentoJpaController();
    PersonaJpaController personaDao = new PersonaJpaController();
    ClienteJpaController clienteDao = new ClienteJpaController();
    EmpleadoJpaController empleadoDao = new EmpleadoJpaController();
    PiezaJpaController piezaDao = new PiezaJpaController();
    HistoricoPrecioPiezaJpaController historicoPiezaDao = new HistoricoPrecioPiezaJpaController();
    HistoricoPrecioVehiculosJpaController historicoVehiculoDao = new HistoricoPrecioVehiculosJpaController();
    VehiculoJpaController vehiculoDao = new VehiculoJpaController();
    MarcaJpaController Marcadao = new MarcaJpaController();
    Tipo_colorJpaController Colorrdao = new Tipo_colorJpaController();
    TipoCabinaJpaController TipoCabinadao = new TipoCabinaJpaController();
    TipoGasolinaJpaController TipoGasolinadao = new TipoGasolinaJpaController();
    transmisionJpaController TipoTransmisiondao = new transmisionJpaController();
    TipoVehiculoJpaController TipoVehiculodao = new TipoVehiculoJpaController();
    Numero_AsientosJpaController NumeroAsientosdao = new Numero_AsientosJpaController();
    informacionFiscalJpaController infFiscalDao = new informacionFiscalJpaController();
    
    FacturaJpaController facturaDao = new FacturaJpaController();
    PiezaFacturaJpaController piezaFacturaDao = new PiezaFacturaJpaController();
    VehiculoFacturaJpaController vehiculoFacturaDao = new VehiculoFacturaJpaController();
    TipoFacturaJpaController tipoFacturaDao = new TipoFacturaJpaController();
    FacturarechazadaJpaController facturaRechazada = new FacturarechazadaJpaController();
    
    
    
    TipoPagoJpaController tipoPagoDao = new TipoPagoJpaController();
    RazonSocialJpaController razonSocialDao = new RazonSocialJpaController();
    /**
     * Creates new form Empleados
     */
    public Ventas() {
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
        crearCmbIDEmpleado();
        crearCmbIDPieza();
        crearTbVenta();
        setFechatxt();
        crearCmbIDVehiculo();
        setTxtNumFactura();
        crearCmbIDTipoFactura();
        createCmbTipoFacturaVenta();
        createCmbTipoFactura();
        createTbTipoFactura();
        createTableCAI();
        ltrampa.setVisible(false);
        setCAIFactura();
        cmbIDTipoPagoAgregar();
        createTbTipoPago();
        createCmbTipoPago();
        cargarCmbNombreEmpleado();
        crearTbFacturasRechazado();
        createTbBusquedaGeneral();
        
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
        DefaultTableModel modelo2 = new DefaultTableModel();
        tblNuevoCargo.setModel(modelo2);
        modelo2.addColumn("ID");
        modelo2.addColumn("Tipo de Factura");
        modelo2.addColumn("Estado");
        
        
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
            modelo1.addElement(e.getTipoFactura());
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
        jButton10 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtNumFacturaBusqueda = new javax.swing.JFormattedTextField();
        chkNumFactura = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        txtClienteBusqueda = new javax.swing.JTextField();
        chkCliente = new javax.swing.JCheckBox();
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
        ltrampa = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 75, 143));

        tab_Ventas.setBackground(new java.awt.Color(0, 75, 143));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num Factura", "Fecha", "Empleado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/imprimir1.png"))); // NOI18N
        jButton10.setText("Imprimir");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jButton7.setText("Buscar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        jButton18.setText("Regresar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        jButton19.setText("Salir");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Numero de Factura:");

        try {
            txtNumFacturaBusqueda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-##-########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNumFacturaBusqueda.setEnabled(false);

        chkNumFactura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkNumFacturaItemStateChanged(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Cliente:");

        txtClienteBusqueda.setEnabled(false);

        chkCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkClienteItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(155, 155, 155))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumFacturaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtClienteBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkNumFactura)
                            .addComponent(chkCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton19))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton18))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1127, Short.MAX_VALUE))
                        .addGap(85, 85, 85)))
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jButton7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton19))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chkNumFactura)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(txtNumFacturaBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(txtClienteBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chkCliente))))
                .addGap(15, 15, 15)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton10)
                    .addComponent(jButton18))
                .addGap(0, 529, Short.MAX_VALUE))
        );

        tab_Ventas.addTab("Reportes", jPanel2);

        jPanel1.setBackground(java.awt.Color.black);

        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Fecha: ");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID Empleado:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Documento Cliente:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("VIN:");

        txtNumFactura.setEditable(false);

        btnImprimirFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/imprimir1.png"))); // NOI18N
        btnImprimirFactura.setText("Imprimir");
        btnImprimirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirFacturaActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        jButton4.setText("Nuevo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        jButton16.setText("Regresar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        jButton17.setText("Salir");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Número de Factura:");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID Vehiculo:");

        txtVIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVINActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ID Pieza:");

        txtTotal.setEditable(false);
        txtTotal.setText(" ");
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel1.setText("Total:");

        cmbIDEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAgregarPieza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregarPieza.setText("Agregar Pieza");
        btnAgregarPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPiezaActionPerformed(evt);
            }
        });

        btnAgregarVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregarVehiculo.setText("Agregar Vehiculo");
        btnAgregarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVehiculoActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cantidad:");

        txtCantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancelar.png"))); // NOI18N
        jButton3.setText("Borrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtNombre.setEditable(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");

        txtFecha.setEditable(false);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tipo de Factura:");

        cmbTipoFacturaVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

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

        txtIDVehiculo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("CAI:");

        lCAI.setForeground(new java.awt.Color(255, 255, 255));
        lCAI.setText("000000-000000-000000-000000-00000-00");

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Forma de Pago:");

        cmbTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Efectivo", "Tarjeta", "Financiación" }));
        cmbTipoPago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoPagoItemStateChanged(evt);
            }
        });

        jLabel23.setText("ISV 18%:");

        txtImpuesto.setEditable(false);

        ltarjeta.setForeground(new java.awt.Color(255, 255, 255));
        ltarjeta.setText("Tarjeta:");

        txtTarjeta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtIDPieza, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbIDEmpleado, javax.swing.GroupLayout.Alignment.LEADING, 0, 214, Short.MAX_VALUE)
                                    .addComponent(lCAI, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAgregarPieza))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtVIN, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDocumentoCliente)
                                        .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12)
                                    .addComponent(ltarjeta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbTipoFacturaVenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtIDVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(txtTarjeta)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAgregarVehiculo, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel23)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                        .addComponent(txtImpuesto))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(btnImprimirFactura)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton4)
                            .addGap(499, 499, 499))))
                .addGap(298, 298, 298)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton17)
                    .addComponent(jButton16))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton17)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtDocumentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24)
                                .addComponent(cmbTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(111, 111, 111))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ltarjeta)
                                    .addComponent(txtTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTipoFacturaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtIDVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label1)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cmbIDEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(lCAI))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtIDPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregarPieza))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtVIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(btnAgregarVehiculo)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jButton16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImprimirFactura))))
                .addContainerGap(416, Short.MAX_VALUE))
        );

        tab_Ventas.addTab("Ventas ", jPanel1);

        jPanel3.setBackground(new java.awt.Color(0, 75, 143));
        jPanel3.setForeground(new java.awt.Color(0, 75, 143));

        btnRegresar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar2.setText("Regresar");
        btnRegresar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar2ActionPerformed(evt);
            }
        });

        btnSalir2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir2.setText("Salir");
        btnSalir2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });

        tblNuevoCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Tipo de Documento", "Tipo de Documento", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
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

        btnAgregar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar2.setText("Agregar");
        btnAgregar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Tipo de Factura:");

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("ID de Factura:");

        cmbIDNuevoFactura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDNuevoFacturaItemStateChanged(evt);
            }
        });

        txtTipoFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoFacturaKeyTyped(evt);
            }
        });

        btnModificar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar2.setText("Modificar");
        btnModificar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar2ActionPerformed(evt);
            }
        });

        btnLimpiar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar2.setText("Limpiar");
        btnLimpiar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });

        btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar3.setText("Desactivar");
        btnDesactivar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar3ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Ingresar Nuevo Tipo de Factura");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnAgregar2)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar2)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbIDNuevoFactura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTipoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnDesactivar3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(475, 475, 475)
                        .addComponent(btnSalir2)))
                .addGap(81, 81, 81))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSalir2)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbIDNuevoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnAgregar2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar2)
                            .addComponent(btnLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivar3))))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar2)
                .addGap(388, 388, 388))
        );

        tab_Ventas.addTab("Tipo de Factura", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 75, 143));

        try {
            txtDe.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-##-########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtHasta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-##-########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("CAI:");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Fecha de Inicio:");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Fecha de Finalización:");

        txtFechaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaInicioActionPerformed(evt);
            }
        });

        txtFechaFinalizacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Desde:");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Hasta:");

        tbCAI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbCAI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCAIMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCAI);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnModificar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar3.setText("Modificar");
        btnModificar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar3ActionPerformed(evt);
            }
        });

        btnLimpiar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar3.setText("Limpiar");
        btnLimpiar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar3ActionPerformed(evt);
            }
        });

        btnDesactivar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar4.setText("Desactivar");
        btnDesactivar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesactivar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar4ActionPerformed(evt);
            }
        });

        ltrampa.setText("00");

        jLabel33.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Ingresar Nuevo CAI");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(91, 91, 91)
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCAI, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(225, 225, 225)
                        .addComponent(ltrampa))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDe, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1002, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar3)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpiar3)
                                .addGap(18, 18, 18)
                                .addComponent(btnDesactivar4))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(458, 458, 458)
                        .addComponent(jLabel33)))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtCAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ltrampa)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtFechaFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnModificar3)
                    .addComponent(btnLimpiar3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(644, Short.MAX_VALUE))
        );

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

        btnAgregarTipoPago.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregarTipoPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregarTipoPago.setText("Agregar");
        btnAgregarTipoPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarTipoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTipoPagoActionPerformed(evt);
            }
        });

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

        btnLimpiar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar4.setText("Limpiar");
        btnLimpiar4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar4ActionPerformed(evt);
            }
        });

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
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Tipo de Documento", "Tipo de Documento", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(btnDesactivarTipoPago))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(376, 376, 376)
                        .addComponent(jLabel34)))
                .addContainerGap(548, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(607, Short.MAX_VALUE))
        );

        tab_Ventas.addTab("Tipo de Pago", jPanel6);

        jPanel5.setBackground(new java.awt.Color(0, 75, 143));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Numero de Factura:");

        try {
            txtNumFacturaRechazo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-##-########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Nombre del Empleado:");

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
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
                        .addGap(266, 266, 266)))
                .addGap(34, 34, 34))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(404, 404, 404)
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(16, 16, 16)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(437, Short.MAX_VALUE))
        );

        tab_Ventas.addTab("Facturas Rechazadas", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab_Ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 1263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab_Ventas)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDesactivar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar3ActionPerformed
       
    }//GEN-LAST:event_btnDesactivar3ActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        
    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed

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
                    e1.setTipoFactura(txtTipoFactura.getText().toLowerCase());
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
        
        
        
        
        
        
        
        
        
        createTbTipoFactura();
        createCmbTipoFactura();
        
    }//GEN-LAST:event_btnModificar2ActionPerformed

    private void txtTipoFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoFacturaKeyTyped
        
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
 public void btnActivarDesactivar(){
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
    
    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
            if(cmbIDNuevoFactura.getSelectedIndex()==0){
                
            }
            else{
                cmbIDNuevoFactura.setSelectedIndex(0);
            }
            Validaciones temp = new Validaciones();
            
            if(txtTipoFactura.getText().length()<2){
                JOptionPane.showMessageDialog(null,"Campo insuficiente, debe tener minimo 3 caracteres","INSUFICIENTE",0);
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
        FrmMenu m = new FrmMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar2ActionPerformed

    private void btnAgregarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVehiculoActionPerformed
        // TODO add your handling code here:
        crearTbVentaAgregarVehiculo();
    }//GEN-LAST:event_btnAgregarVehiculoActionPerformed

    private void btnAgregarPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPiezaActionPerformed
        
        crearTbVentaAgregarPieza();
        limpiarPieza();
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
            arrayDetallesFactura[i][0]=arregloPiezas.get(i).getIdPieza();
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
        
        
        
        param.put("monto",formato1.format(f.getCantidadPago()) );
        
        pp = personaDao.findPersona(c.getId_Persona()); // En caso de que no salga declara una persona distinta
        
        param.put("cliente", pp.getNombre()+" "+pp.getApellido());
        param.put("documento",pp.getDocumento_id());
        
        
        
            JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\Users\\Kur013\\Desktop\\II PERIODO 2021\\Ingenieria de software I\\28-07-2021\\Base2\\Base2\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Factura.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,FacturaJRADATASOURCE.getDataSource(arrayDetallesFactura));
            
            //JasperRunManager.runReportToPdf(reporteFactura, param);
            
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
            view.setTitle("Factura" + Integer.parseInt("1"));
    }
    
    private void btnImprimirFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirFacturaActionPerformed

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
        double pagoAuxiliar=0;
        int banderaEfectivo=0;
        
        if(cmbTipoPago.getSelectedItem().toString().toLowerCase().equals("efectivo") ||cmbTipoPago.getSelectedItem().toString().toLowerCase().equals("mixto") ){
            while(banderaEfectivo==0){
                pagoEfectivo = JOptionPane.showInputDialog(null, "Ingrese el monto a Recibir","REGISTRO",1);
                try{
                    pagoAuxiliar=Double.parseDouble(pagoEfectivo);
                    banderaEfectivo=1;
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
        f.setCantidadPago(pagoAuxiliar);
        
        f.setIdRazonSocial(1);
        f.setIdTipoPago(cmbTipoPago.getSelectedIndex());
        Calendar fecha = new GregorianCalendar();
        String auxMinutos =(fecha.get(Calendar.MINUTE)<10)? "0"+(Integer.toString(fecha.get(Calendar.MINUTE))) : Integer.toString(fecha.get(Calendar.MINUTE));
        String auxFecha = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH)+1);
        String auxHora= (fecha.get(Calendar.HOUR_OF_DAY)<10)? "0"+(Integer.toString(fecha.get(Calendar.HOUR_OF_DAY))) : Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
        String auxSegundo=(fecha.get(Calendar.SECOND)<10)? "0"+(Integer.toString(fecha.get(Calendar.SECOND))) : Integer.toString(fecha.get(Calendar.SECOND));
        String auxDia=(fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.DAY_OF_MONTH))) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        f.setFechaHora(String.valueOf(fecha.get(Calendar.YEAR))+auxFecha+auxDia+auxHora+auxMinutos+auxSegundo);
        f.setEstado(true);
        
        //CAI
        boolean bandera=false;
        for(informacionFiscal temporaltemporal : infFiscalDao.findinformacionFiscalEntities()){
            LocalDate auxfecha1=LocalDate.parse(temporaltemporal.getFechaInicio());
            LocalDate auxFecha2 = LocalDate.parse(temporaltemporal.getFechaFinal());
            
            LocalDate auxFecha3 = LocalDate.parse(String.valueOf(fecha.get(Calendar.YEAR))+"-"+auxFecha+"-"+auxDia);
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
        
        
        
        try {
            imprimirFacturaVenta();
        } catch (JRException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        this.txtDocumentoCliente.setText("");
        this.cmbTipoPago.setSelectedIndex(0);
        this.txtTarjeta.setText("");
        
        DefaultTableModel modelo = (DefaultTableModel) tbVenta.getModel();
        
        int a= modelo.getRowCount()-1;
        for(int i=a;i>=0;i--){
            modelo.removeRow(i);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirFacturaActionPerformed

    public void imprimirFacturaVenta() throws JRException{
        Object [][] arrayDetallesFactura;
        arrayDetallesFactura = new Object[tbVenta.getRowCount()][5];
        
        for(int i = 0;i<tbVenta.getRowCount();i++){
            for(int j = 0;j<5;j++){
                switch(j){
                    case 0:arrayDetallesFactura[i][0]=tbVenta.getValueAt(i,0);break;
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
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        
        param.put("monto",formato1.format(f.getCantidadPago()) );
        
        pp = personaDao.findPersona(c.getId_Persona()); // En caso de que no salga declara una persona distinta
        
        param.put("cliente", pp.getNombre()+" "+pp.getApellido());
        param.put("documento",pp.getDocumento_id());
        
        
        
            JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\Users\\Kur013\\Desktop\\II PERIODO 2021\\Ingenieria de software I\\28-07-2021\\Base2\\Base2\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\Factura.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,FacturaJRADATASOURCE.getDataSource(arrayDetallesFactura));
            
            //JasperRunManager.runReportToPdf(reporteFactura, param);
            
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
            view.setTitle("Factura" + Integer.parseInt("1"));
            
            
        
        
    }
    
    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        this.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        
        ModalPiezas temp2 = new ModalPiezas(this,true);
        temp2.setLocationRelativeTo(null);
        temp2.setVisible(true);
        txtIDPieza.setText(String.valueOf(temp2.getId()));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        ModalVehiculos temp2 = new ModalVehiculos(this,true);
        temp2.setLocationRelativeTo(null);
        temp2.setVisible(true);
        txtIDVehiculo.setText(String.valueOf(temp2.getId()));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void txtVINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVINActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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
        
        char validar=evt.getKeyChar();
        if((validar<'0'||validar>'9')&&  (validar!=(char)KeyEvent.VK_BACKSPACE && (validar!=(char)KeyEvent.VK_SPACE)) ){
          JOptionPane.showMessageDialog(null,"Solo se admiten numeros para el ID de Pieza","Error!", JOptionPane.ERROR_MESSAGE);
          txtIDPieza.setText("");
          evt.consume();
            //   JOptionPane.showMessageDialog(null,"Solo se admiten letras para el nuevo tipo de pieza","Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPiezaKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        createTablaBusqueda();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void createTbBusquedaGeneral(){
        DefaultTableModel modelo1 = new DefaultTableModel();
        jTable3.setModel(modelo1);
        modelo1.addColumn("Num de Factura");
        modelo1.addColumn("Fecha");
        modelo1.addColumn("Cliente");
        modelo1.addColumn("Estado");
        
        List<Factura> temp = facturaDao.findFacturaEntities();
        
        for(Factura f : temp){
            Persona personaParaBusqueda=personaDao.findPersona(clienteDao.findCliente(f.getIdCliente()).getId_Persona());
                    
                    String auxiliarEstado = (f.getEstado())? "Aceptado":"Rechazado";
                    modelo1.addRow(new Object[]{f.getNumFactura(),f.getFechaHora(),personaParaBusqueda.getNombre()+" "+personaParaBusqueda.getApellido(),auxiliarEstado});        }
        
    }
    
    private void createTablaBusqueda(){
        DefaultTableModel modelo1 = new DefaultTableModel();
        jTable3.setModel(modelo1);
        modelo1.addColumn("Num de Factura");
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
        this.txtDocumentoCliente.setText("");
        this.cmbTipoPago.setSelectedIndex(0);
        this.txtTarjeta.setText("");
        
        DefaultTableModel modelo = (DefaultTableModel) tbVenta.getModel();
        
        int a= modelo.getRowCount()-1;
        for(int i=a;i>=0;i--){
            modelo.removeRow(i);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInicioActionPerformed

    private void btnModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar3ActionPerformed
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
        
        try {
            infFiscalDao.edit(temporal);
        } catch (Exception ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            
        
        
        limpiarCAI();
        createTableCAI();
        
        tab_Ventas.setSelectedIndex(1);
        setCAIFactura();
        tab_Ventas.setSelectedIndex(3);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificar3ActionPerformed

    private void btnLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar3ActionPerformed

        limpiarCAI();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiar3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Agregar nuevo CAI
        
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
        try {
            infFiscalDao.create(temporal);
            
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        limpiarCAI();
        createTableCAI();
        tab_Ventas.setSelectedIndex(1);
        setCAIFactura();
        tab_Ventas.setSelectedIndex(3);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDesactivar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar4ActionPerformed
        informacionFiscal temp;
        temp = infFiscalDao.findinformacionFiscal(Integer.parseInt(ltrampa.getText()));
        //temp = piezaDao.findPieza(txtIDPieza.getSelectedIndex()+1);
        //JOptionPane.showMessageDialog(null, temp.isEstado());
        if(temp.isEstado()){
            temp.setEstado(false);
            /*Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Usuario Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
      */  }
        else{
            temp.setEstado(true);
            /*Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Usuario Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        */}
        try {
            infFiscalDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableCAI();
        btnActivarDesactivarCAI();
        /*btnDesactivar4.setEnabled(false);
        jButton1.setEnabled(true);
        btnModificar3.setEnabled(false);*/

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
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoPagoKeyTyped

    private void btnAgregarTipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTipoPagoActionPerformed

        if(cmbIDTipoPagoAgregar.getSelectedIndex()==0){
            
        }
        else{
            cmbIDTipoPagoAgregar.setSelectedIndex(0);
        }
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
        DefaultTableModel modelo9 = new DefaultTableModel();
        tbTipoPago.setModel(modelo9);
        modelo9.addColumn("ID");
        modelo9.addColumn("Tipo de Pago");
        modelo9.addColumn("Estado");
        
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
    
    private void btnModificarTipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTipoPagoActionPerformed
        
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
        
        
        try {
            tipoPagoDao.edit(tP);
        } catch (Exception ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cmbIDTipoPagoAgregar();
        limpiarPanelTipoPago();
        createTbTipoPago();
        tab_Ventas.setSelectedIndex(1);
        createCmbTipoPago();
        tab_Ventas.setSelectedIndex(4);
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarTipoPagoActionPerformed

    private void btnLimpiar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar4ActionPerformed
        limpiarPanelTipoPago();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiar4ActionPerformed

    private void btnDesactivarTipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarTipoPagoActionPerformed
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
        if(cmbTipoPago.getSelectedIndex()==0 || cmbTipoPago.getSelectedIndex()==1){
            ltarjeta.setVisible(false);
            txtTarjeta.setVisible(false);
        }
        else{
            ltarjeta.setVisible(true);
            txtTarjeta.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoPagoItemStateChanged

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

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
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

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
                String auxFecha = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH)+1);
                String auxDia=(fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.DAY_OF_MONTH))) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                
                facRec.setFechaRechazo(String.valueOf(fecha.get(Calendar.YEAR))+auxFecha+auxDia);
                
                facturaRechazada.create(facRec);
                
                
            }
            
            
        } else {
            JOptionPane.showMessageDialog(null,"Seleccione una Factura","FACTURA SIN SELECCIONAR",0);
        }
        
        
        
        
        crearTbFacturasRechazado();
        
        
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
            try {
                this.imprimirFacturaBusqueda(facw);
            } catch (JRException ex) {
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_tbFacturaRechazadaMouseClicked

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
        DefaultTableModel modelo10 = new DefaultTableModel();
        tbCAI.setModel(modelo10);
        modelo10.addColumn("ID");
        modelo10.addColumn("CAI");
        modelo10.addColumn("Fecha de Inicio");
        modelo10.addColumn("Fecha Limite");
        modelo10.addColumn("Desde");
        modelo10.addColumn("Hasta");
        modelo10.addColumn("Estado");
        
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
        aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
        aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        fecha1 = aux1+aux2+aux3;
        
        txtFecha.setText(aux3+"/"+aux2+"/"+aux1+"   "+fecha.get(Calendar.HOUR_OF_DAY)+":"+fecha.get(Calendar.MINUTE)/*+":"+fecha.get(Calendar.SECOND)*/);
        
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
        
        if((temp.getStock()-Integer.parseInt(txtCantidad.getText()))<=0){
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
    private javax.swing.JCheckBox chkNumFactura;
    public static javax.swing.JComboBox<String> cmbIDEmpleado;
    private javax.swing.JComboBox<String> cmbIDNuevoFactura;
    private javax.swing.JComboBox<String> cmbIDTipoPagoAgregar;
    private javax.swing.JComboBox<String> cmbNombreEmpleado;
    private javax.swing.JComboBox<String> cmbTipoFacturaVenta;
    private javax.swing.JComboBox<String> cmbTipoPago;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JFormattedTextField txtNumFacturaBusqueda;
    private javax.swing.JFormattedTextField txtNumFacturaRechazo;
    private javax.swing.JFormattedTextField txtTarjeta;
    private javax.swing.JTextField txtTipoFactura;
    private javax.swing.JTextField txtTipoPago;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVIN;
    // End of variables declaration//GEN-END:variables
}
