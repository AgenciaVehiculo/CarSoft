/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.Acceso;
import Clases.Cliente;
import Clases.Detalle_Banco_Cliente;
import Clases.Detalle_Pedido_Vehiculo;
import Clases.Detalle_Pedido_pieza;
import Clases.Empleado;
import Clases.FacturaJRADATASOURCE;
import Clases.HistoricoPrecioPieza;
import Clases.HistoricoPrecioVehiculos;
import Clases.Marca;
import Clases.Pedido;
import Clases.Persona;
import Clases.Pieza;
import Clases.PiezaFactura;
import Clases.RazonSocial;
import Clases.TipoPieza;
import Clases.Tipo_Documento;
import Clases.Vehiculo;
import Clases.VehiculoFactura;
import Clases.informacionFiscal;
import FormModales.ModalPiezasCombo;
import FormModales.ModalVehiculosCombo;
import JPAController.Detalle_Pedido_VehiculoJpaController;
import JPAController.Detalle_Pedido_piezaJpaController;
import JPAController.HistoricoPrecioPiezaJpaController;
import JPAController.HistoricoPrecioVehiculosJpaController;
import JPAController.MarcaJpaController;
import JPAController.PedidoJpaController;
import JPAController.PiezaJpaController;
import JPAController.TipoPiezaJpaController;
import JPAController.VehiculoJpaController;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Usuario
 */
public class FrmPedidos extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     */
    EntityManagerFactory emf =Persistence.createEntityManagerFactory("CarSoft");
    PedidoJpaController Pedidodao = new PedidoJpaController(emf);
    Detalle_Pedido_VehiculoJpaController PedidoVehiculodao = new Detalle_Pedido_VehiculoJpaController(emf);
    Detalle_Pedido_piezaJpaController PedidoPiezadao = new Detalle_Pedido_piezaJpaController(emf);
    PiezaJpaController PiezaDao = new PiezaJpaController(emf);
    VehiculoJpaController Vehiculodao = new VehiculoJpaController(emf);
    MarcaJpaController MarcaDao = new MarcaJpaController(emf);
    TipoPiezaJpaController TipoPiezaDao = new TipoPiezaJpaController(emf);
    HistoricoPrecioPiezaJpaController historicoPiezaDao = new HistoricoPrecioPiezaJpaController(emf);
    HistoricoPrecioVehiculosJpaController historicoVehiculoDao = new HistoricoPrecioVehiculosJpaController(emf);
    MarcaJpaController Marcadao = new MarcaJpaController(emf);
    String empNomb;

    public String getEmpNomb() {
        return empNomb;
    }

    public void setEmpNomb(String empNomb) {
        this.empNomb = empNomb;
    }
    
    
    public FrmPedidos(Acceso a ) {
        initComponents();
         setIconImage(new ImageIcon(getClass().getResource("/Img/CarSoft-removebg-preview.png")).getImage());
        this.setExtendedState(MAXIMIZED_BOTH);
        //btnDesactivar3.setEnabled(false);
        createComboBoxPedido();
        
        createComboPieza();
        createComboVehiculo();

        //btnModificar3.setEnabled(false);
        this.jPanel3.setBackground( new Color(0, 75, 143));
        this.jPanel1.setBackground( new Color(0, 75, 143));
        this.getContentPane().setBackground(new Color(0, 75, 143));
        this.btnAgregar3.setBackground( new Color(14, 209, 69));
        btnAgregar5.setBackground( new Color(14, 209, 69));
        btnAgregar4.setBackground( new Color(14, 209, 69));
        this.btnSalir.setBackground( new Color(236, 28, 36));
        this.btnSalir1.setBackground( new Color(236, 28, 36));
        btnLimpiar.setBackground( new Color(14, 209, 69));
        btnBorrar.setBackground( new Color(14, 209, 69));
        btnBuscar1.setBackground( new Color(14, 209, 69));
        btnBuscar.setBackground( new Color(14, 209, 69));
        jButton1.setBackground( new Color(14, 209, 69));
        jButton2.setBackground( new Color(14, 209, 69));
        btnDesactivar.setBackground( new Color(14, 209, 69));
        btnDesactivar.setEnabled(false);
//        btnAgregar6.setBackground( new Color(14, 209, 69));
        //this.btnModificar3.setBackground( new Color(14, 209, 69));
        //this.btnLimpiar3.setBackground( new Color(14, 209, 69));
        //this.btnDesactivar3.setBackground( new Color(14, 209, 69));
        this.btnRegresar1.setBackground( new Color(14, 209, 69));
        this.btnRegresar.setBackground( new Color(14, 209, 69));
        tblPedido.setForeground(Color.WHITE);
        tblPedido.setBackground(Color.BLACK);
        cmbIDVehiculo.setEnabled(true);
        cmbIDVehiculo.setEnabled(true);
        crearTbPedido();
        txtPedidoListaBusqueda();
        createTablePedido();
        
        try{
            btnBuscar.setVisible(a.getPermisoSeccionPedidosBuscarVehiculo());
            btnBuscar1.setVisible(a.getPermisoSeccionPedidosBuscarPieza());
            btnAgregar3.setVisible(a.getPermisoSeccionPedidosAgregarPedido());
            btnAgregar5.setVisible(a.getPermisoSeccionPedidosAgregarPieza());
            btnAgregar4.setVisible(a.getPermisoSeccionPedidosAgregarVehiculo());
            
            btnDesactivar.setVisible(a.getPermisoSeccionListadoPedidosDesactivar());
            jButton1.setVisible(a.getPermisoSeccionListadoPedidosReportePdf());
            jButton2.setVisible(a.getPermisoSeccionListadoPedidosReporteExcel());
            
            
            //Acceso Uusuario
        }catch(Exception e){
            //Acceso root
        }
        
    }

public void btnActivarDesactivarPedido(){
        Pedido temp = new Pedido();
        int fila = tblPedido.getSelectedRow();
        String pedido= String.valueOf(tblPedido.getValueAt(fila, 0));
        temp = Pedidodao.findPedido(Integer.parseInt(pedido));

        if(temp.isEstado()){
        btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar.setText("Desactivar");  
        btnDesactivar.setEnabled(true);
        }
        else{
            btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar.setText("Activar");
            btnDesactivar.setEnabled(true);
        }
        }
public void createComboBoxPedido(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cmbIDPedido.setModel(modelo);
        List<Pedido> temp = Pedidodao.findPedidoEntities();
        modelo.addElement("Nuevo");
        temp.forEach((c) -> {
        modelo.addElement(c.getId_pedido());
        });
        }


public void createComboVehiculo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbIDVehiculo.setModel(modelo);
        List<Vehiculo> temp = Vehiculodao.findVehiculoEntities();
        List<Marca> tempp = MarcaDao.findMarcaEntities();
        modelo.addElement("Seleccione...");
        for (Vehiculo tpp : temp){     
            for(Marca tp : tempp){
            if(tpp.getId_marca()== tp.getIdMarca()){
            modelo.addElement(tpp.getId_vehiculo()+". "+tp.getMarca()+" ("+tpp.getVin()+"-"+tpp.getTotal_cilindraje()+")");
            }         
            //return;
        }
        }
                }
public void createComboPieza(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbIDPieza.setModel(modelo);
        List<Pieza> temp = PiezaDao.findPiezaEntities();
        List<TipoPieza> temp2 = TipoPiezaDao.findTipoPiezaEntities();
        modelo.addElement("Seleccione...");
        for(Pieza tp:temp){
            for(TipoPieza tpp: temp2){
            if(tpp.getIDtipopieza()==tp.getId_Tipo_Pieza()){
            modelo.addElement(tp.getId_Pieza()+". "+tpp.getTipopieza()+" ("+tp.getNombre()+")");
        }
            }
        }
                }
   
/*public void createTablePedido2(){
        DefaultTableModel modelo = new DefaultTableModel();
        tblPedido.setModel(modelo);
        modelo.addColumn("ID Pedido");
        modelo.addColumn("Vehículo");
        modelo.addColumn("Cantidad de Vehículos Pedidos");
        modelo.addColumn("Precio de Cada Vehículo");
        modelo.addColumn("Pieza");
        modelo.addColumn("Cantidad de Piezas Pedidas");
        modelo.addColumn("Precio de Cada Pieza");
        modelo.addColumn("Monto total del pedido");
        modelo.addColumn("Fecha pedido");
        modelo.addColumn("Estado");
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
        List<Pedido> tempo = Pedidodao.findPedidoEntities();
        List<Detalle_Pedido_Vehiculo> temp = PedidoVehiculodao.findDetalle_Pedido_VehiculoEntities();
        int auxcantidadvehiculos=0;
        double auxpreciovehiculo=0;
        List<Vehiculo> tempv = Vehiculodao.findVehiculoEntities();
        String auxmarca="";
        int auxVeh=0;
        String veh="";
        List<Detalle_Pedido_pieza> tempp = PedidoPiezadao.findDetalle_Pedido_piezaEntities();
        List<Pieza> temppp = PiezaDao.findPiezaEntities();
        String auxpieza="";
        int auxidpieza=0;
        String pieza="";
        String auxfecha="";
        String auxfechab="";
        List<Marca> tempm = MarcaDao.findMarcaEntities();
        int auxcantidadpiezas=0;
        double auxpreciopieza=0;
        for(Pedido p : tempo){
            for(Detalle_Pedido_Vehiculo cc : temp){
                if(p.getId_pedido()==cc.getId_pedido()){
                    auxcantidadvehiculos=(cc.getCantidad());
                    auxpreciovehiculo=cc.getPrecio();
                    for(Vehiculo v : tempv){
                if(cc.getId_vehiculo()==v.getId_vehiculo()){
                    for(Marca m : tempm){
                        if(v.getId_marca()==m.getIdMarca()){
                    auxmarca=(m.getMarca());
                    auxVeh=v.getId_vehiculo();
                    veh=auxVeh+". "+auxmarca;
                        }
                    }
                }   
            }
                }
             
            }
            auxfecha=(p.getFecha_pedido().substring(8, 10)+"/"+p.getFecha_pedido().substring(5, 7)+"/"+p.getFecha_pedido().substring(0, 4));
            if(p.getFecha_entrega()==null) {
                                            auxfechab="";
                                    } else {
                                        auxfechab=(p.getFecha_entrega().substring(8, 10)+"/"+p.getFecha_entrega().substring(5, 7)+"/"+p.getFecha_entrega().substring(0, 4));
                                    } 
            for(Detalle_Pedido_pieza tp : tempp){
                if(p.getId_pedido() == tp.getId_pedido()){
                    auxcantidadpiezas=(tp.getCantidad());
                    auxpreciopieza=tp.getPrecio();
                    for(Pieza pp : temppp){
                if(tp.getId_pieza()==pp.getId_Pieza()){
                    auxpieza=pp.getNombre();
                    auxidpieza=pp.getId_Pieza();
                    pieza=(auxidpieza+". "+auxpieza);
                }   
            }
                }
            
            }
            modelo.addRow(
                    new Object[]{
                        p.getId_pedido(),
                        veh,
                        auxcantidadvehiculos,
                         formato1.format(auxpreciovehiculo),
                        pieza,
                        auxcantidadpiezas,
                         formato1.format(auxpreciopieza),
                        p.getMonto_pedido(),
                        auxfecha,
                        //auxfechab,
                        p.isEstado()? "Activo" : "Inactivo",
                      
            });  
    
        }      
        }*/
public void createTablePedido(){
        DefaultTableModel modelo = (DefaultTableModel) tblPedido.getModel();
        tblPedido.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        //modelo.addColumn("ID Pedido");
        //modelo.addColumn("Monto total del pedido");
        //modelo.addColumn("Fecha pedido");
        //modelo.addColumn("Fecha de Entrega");
        //modelo.addColumn("Estado");
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
        List<Pedido> tempo = Pedidodao.findPedidoEntities();
        List<Detalle_Pedido_Vehiculo> temp = PedidoVehiculodao.findDetalle_Pedido_VehiculoEntities();
        int auxcantidadvehiculos=0;
        double auxpreciovehiculo=0;
        List<Vehiculo> tempv = Vehiculodao.findVehiculoEntities();
        String auxmarca="";
        int auxVeh=0;
        String veh="";
        List<Detalle_Pedido_pieza> tempp = PedidoPiezadao.findDetalle_Pedido_piezaEntities();
        List<Pieza> temppp = PiezaDao.findPiezaEntities();
        String auxpieza="";
        int auxidpieza=0;
        String pieza="";
        String auxfecha="";
        String auxfechab="";
        List<Marca> tempm = MarcaDao.findMarcaEntities();
        int auxcantidadpiezas=0;
        double auxpreciopieza=0;
        for(Pedido p : tempo){
            for(Detalle_Pedido_Vehiculo cc : temp){
                if(p.getId_pedido()==cc.getId_pedido()){
                    auxcantidadvehiculos=(cc.getCantidad());
                    auxpreciovehiculo=cc.getPrecio();
                    for(Vehiculo v : tempv){
                if(cc.getId_vehiculo()==v.getId_vehiculo()){
                    for(Marca m : tempm){
                        if(v.getId_marca()==m.getIdMarca()){
                    auxmarca=(m.getMarca());
                    auxVeh=v.getId_vehiculo();
                    veh=auxVeh+". "+auxmarca;
                        }
                    }
                }   
            }
                }
             
            }
            auxfecha=(p.getFecha_pedido().substring(8, 10)+"/"+p.getFecha_pedido().substring(5, 7)+"/"+p.getFecha_pedido().substring(0, 4));
            if(p.getFecha_entrega()==null) {
                                            auxfechab="";
                                    } else {
                                        auxfechab=(p.getFecha_entrega().substring(8, 10)+"/"+p.getFecha_entrega().substring(5, 7)+"/"+p.getFecha_entrega().substring(0, 4));
                                    } 
            for(Detalle_Pedido_pieza tp : tempp){
                if(p.getId_pedido() == tp.getId_pedido()){
                    auxcantidadpiezas=(tp.getCantidad());
                    auxpreciopieza=tp.getPrecio();
                    for(Pieza pp : temppp){
                if(tp.getId_pieza()==pp.getId_Pieza()){
                    auxpieza=pp.getNombre();
                    auxidpieza=pp.getId_Pieza();
                    pieza=(auxidpieza+". "+auxpieza);
                }   
            }
                }
            
            }
            modelo.addRow(
                    new Object[]{
                        p.getId_pedido(),
                        
                        String.format("%,.2f",p.getMonto_pedido()),
                        auxfecha,
                        //auxfechab,
                        p.isEstado()? "Activo" : "Inactivo",
                      
            });  
    
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

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        cmbIDPedido = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        btnAgregar3 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantidadVehiculos = new javax.swing.JTextField();
        txtCantidadPiezas = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cmbIDPieza = new javax.swing.JComboBox<>();
        cmbIDVehiculo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtPrecioPieza = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPrecioVehiculo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAgregar4 = new javax.swing.JButton();
        btnAgregar5 = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnBuscar1 = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPedidoPiezaVehiculo = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        btnDesactivar = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        btnRegresar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbIDPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " ", " " }));
        cmbIDPedido.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDPedidoItemStateChanged(evt);
            }
        });
        jPanel3.add(cmbIDPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 75, 109, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Pedidos");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, -1, 35));

        btnAgregar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar3.setText("Agregar Pedido");
        btnAgregar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar3ActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 556, -1, -1));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1239, 13, -1, -1));

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1179, 578, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cantidad de Vehículos:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 155, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID Pedido:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 84, 131, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad de Piezas:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 155, 122, -1));

        txtCantidadVehiculos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadVehiculosFocusLost(evt);
            }
        });
        txtCantidadVehiculos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadVehiculosKeyTyped(evt);
            }
        });
        jPanel3.add(txtCantidadVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 152, 102, -1));

        txtCantidadPiezas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadPiezasFocusLost(evt);
            }
        });
        txtCantidadPiezas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadPiezasKeyTyped(evt);
            }
        });
        jPanel3.add(txtCantidadPiezas, new org.netbeans.lib.awtextra.AbsoluteConstraints(842, 152, 111, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Pieza:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 115, 122, -1));

        cmbIDPieza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDPiezaItemStateChanged(evt);
            }
        });
        cmbIDPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDPiezaActionPerformed(evt);
            }
        });
        jPanel3.add(cmbIDPieza, new org.netbeans.lib.awtextra.AbsoluteConstraints(842, 112, 236, -1));

        cmbIDVehiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDVehiculoItemStateChanged(evt);
            }
        });
        cmbIDVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbIDVehiculoActionPerformed(evt);
            }
        });
        jPanel3.add(cmbIDVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 112, 297, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText(" Vehículo:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 115, 131, -1));

        txtPrecioPieza.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioPiezaFocusLost(evt);
            }
        });
        txtPrecioPieza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioPiezaKeyTyped(evt);
            }
        });
        jPanel3.add(txtPrecioPieza, new org.netbeans.lib.awtextra.AbsoluteConstraints(842, 192, 111, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Lps.");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 195, 33, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Precio del  Vehículo:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 195, 131, -1));

        txtPrecioVehiculo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioVehiculoFocusLost(evt);
            }
        });
        txtPrecioVehiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVehiculoKeyTyped(evt);
            }
        });
        jPanel3.add(txtPrecioVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 192, 111, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Precio de la pieza:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 195, 122, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Lps.");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(971, 195, 33, -1));

        btnAgregar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar4.setText("Agregar Vehículo");
        btnAgregar4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar4ActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 248, -1, -1));

        btnAgregar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar5.setText("Agregar Pieza");
        btnAgregar5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar5ActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(842, 248, -1, -1));

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cancelar.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel3.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 445, -1, -1));

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar.setText("Nuevo");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel3.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 554, -1, 45));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 110, -1, 29));

        btnBuscar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscar1.setText("Buscar");
        btnBuscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1096, 110, -1, 29));

        txtTotal.setEditable(false);
        txtTotal.setText(" ");
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        jPanel3.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 504, 116, -1));

        jLabel3.setText("Total:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 507, -1, -1));

        tblPedidoPiezaVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripción", "Precio Unitario", "Cantidad", "SubTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblPedidoPiezaVehiculo);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 327, 633, 159));

        jTabbedPane2.addTab("Pedidos", jPanel3);

        jPanel1.setBackground(new java.awt.Color(255, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pedido", "Monto del Pedido", "Fecha del Pedido", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPedido);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 174, 1116, 183));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Lista de Pedidos");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 13, -1, 35));

        btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar.setText("Desactivar");
        btnDesactivar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDesactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 371, -1, -1));

        btnSalir1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1254, 15, -1, -1));

        btnRegresar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar1.setText("Regresar");
        btnRegresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1194, 588, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        jButton1.setText("Generar Reporte PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        jButton2.setText("Generar Reporte Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 370, -1, -1));

        jTabbedPane2.addTab("Lista de Pedidos", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void filtroPedido() {
      /*  TableRowSorter trsfiltro = new TableRowSorter(tblPedido.getModel());
        tblPedido.setRowSorter(trsfiltro);
        trsfiltro.setRowFilter(RowFilter.regexFilter(txtPedidoListaBusqueda.getText(), 1)); */
        
}
    private void tblPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidoMouseClicked
Pedido temp = new Pedido();
        int fila = tblPedido.getSelectedRow();
        String pedido= String.valueOf(tblPedido.getValueAt(fila, 0));
        temp = Pedidodao.findPedido(Integer.parseInt(pedido));

        if(temp.isEstado()){
        btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 11));
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png")));
        btnDesactivar.setText("Desactivar");  
        btnDesactivar.setEnabled(true);
        }
        else{
            btnDesactivar.setFont(new java.awt.Font("Tahoma", 1, 11));
            btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png")));
            btnDesactivar.setText("Activar");
            btnDesactivar.setEnabled(true);
        }/*
        btnAgregar3.setEnabled(false);
        btnDesactivar.setEnabled(true);
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
        int column=0;
        String auxfechab="";
        int fila = tblPedido.getSelectedRow();
        if (fila > -1){
            Pedido temp = Pedidodao.findPedido(Integer.parseInt(tblPedido.getModel().getValueAt(fila, column).toString()));
            List<Vehiculo> tempv = Vehiculodao.findVehiculoEntities();
            List<Pieza> tempp = PiezaDao.findPiezaEntities();
            List<Marca> tempm = MarcaDao.findMarcaEntities();
            List<Detalle_Pedido_Vehiculo> tempdpv = PedidoVehiculodao.findDetalle_Pedido_VehiculoEntities();
            List<Detalle_Pedido_pieza> tempdpp = PedidoPiezadao.findDetalle_Pedido_piezaEntities();
            for(Detalle_Pedido_Vehiculo b : tempdpv){
                if(b.getId_pedido()==temp.getId_pedido()){
                    for(Vehiculo cc : tempv){
                        if(b.getId_vehiculo()==b.getId_vehiculo()){
                            for(Marca mm : tempm){
                                if(mm.getIdMarca()==cc.getId_marca()){
                                    txtPedidoListaBusqueda.setText(String.valueOf(temp.getId_pedido()));
                                    
                                    if(temp.getFecha_entrega()==null) {
                                            auxfechab="";
                                    } else {
                                        auxfechab=(temp.getFecha_entrega().substring(8, 10)+"/"+temp.getFecha_entrega().substring(5, 7)+"/"+temp.getFecha_entrega().substring(0, 4));
                                    }
                                    //txtFechaFinal2.setText(auxfechab);
                                }
                            }
                        }
                    }
                }
            }


            /*if(null== temp.getFecha_entrega()){
                txtFechaEntrega.setText("");
            } else switch (temp.getFecha_entrega()) {
                case "":
                txtFechaEntrega.setText("");
                break;
                default:
                txtFechaEntrega.setText(String.valueOf(temp.getFecha_entrega()));
                break;
            }
            btnActivarDesactivarPedido();

        }
        }*/
    }//GEN-LAST:event_tblPedidoMouseClicked

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        try{
        BuscarPieza();
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
                Logger logger = Logger.getLogger(FrmPedidos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"PedidosPieza"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try{
        BuscarVehiculo();
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
                Logger logger = Logger.getLogger(FrmPedidos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"PedidosBuscarVehiculo"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        try{
        DefaultTableModel modelo = (DefaultTableModel) tblPedidoPiezaVehiculo.getModel();

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
                Logger logger = Logger.getLogger(FrmPedidos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"PedidoNuevo"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

        try{
        DefaultTableModel modelo = (DefaultTableModel) tblPedidoPiezaVehiculo.getModel();
        if(modelo.getRowCount()==0){

        }
        else{
            modelo.removeRow(modelo.getRowCount()-1);

            DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
            separadoresPersonalizados.setDecimalSeparator('.');
            DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);

            double contenedorPrecio=0;
            for(int i=0;i<modelo.getRowCount();i++){
                contenedorPrecio+=Double.parseDouble((String) modelo.getValueAt(i, 4));

            }
            txtTotal.setText(formato1.format(contenedorPrecio));
        }}catch(Exception e){
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
                Logger logger = Logger.getLogger(FrmPedidos.class.getName());
                FileHandler fh;
                fh = new FileHandler("./"+"PedidosBorrar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnAgregar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar5ActionPerformed
        try{                    
        crearTbAgregarPieza();
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
                Logger logger = Logger.getLogger(FrmPedidos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"PedidosAgregarPieza"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgregar5ActionPerformed

    private void btnAgregar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar4ActionPerformed
        try{
        crearTbAgregarVehiculo();
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
                Logger logger = Logger.getLogger(FrmPedidos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"PedidosAgregarVehiculo"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAgregar4ActionPerformed

    private void txtPrecioVehiculoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVehiculoKeyTyped
        
                 
                char c = evt.getKeyChar();
        if((c < '0' || c > '9') && (c != '.' && c != ',')){

            evt.consume();

        }
        if (txtPrecioVehiculo.getText().length() >= 12){
        
        evt.consume();
        }
    }//GEN-LAST:event_txtPrecioVehiculoKeyTyped

    private void txtPrecioVehiculoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioVehiculoFocusLost
        /*if (NumerosEnterosDecimales(txtPrecioVehiculo.getText())){
        }else{
            JOptionPane.showMessageDialog(null,"Formato incorrecto del Precio de Vehículos, debe ser un entero positivo y con 2 decimales","Error!", JOptionPane.ERROR_MESSAGE);
            txtPrecioVehiculo.requestFocus();
        }*/
    }//GEN-LAST:event_txtPrecioVehiculoFocusLost

    private void txtPrecioPiezaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioPiezaFocusLost
        /*if (NumerosEnterosDecimales(txtPrecioPieza.getText())){
        }else{
            JOptionPane.showMessageDialog(null,"Formato incorrecto del Precio de piezas, debe ser un entero positivo y con 2 decimales","Error!", JOptionPane.ERROR_MESSAGE);
            txtPrecioPieza.requestFocus();
        }*/
    }//GEN-LAST:event_txtPrecioPiezaFocusLost

    private void cmbIDVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDVehiculoActionPerformed

    private void cmbIDVehiculoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDVehiculoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDVehiculoItemStateChanged

    private void cmbIDPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbIDPiezaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDPiezaActionPerformed

    private void cmbIDPiezaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDPiezaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDPiezaItemStateChanged

    private void txtCantidadPiezasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadPiezasFocusLost
        /*if (NumerosEnteros(txtCantidadPiezas.getText())){
        }else{
            JOptionPane.showMessageDialog(null,"Formato incorrecto de la Cantidad de Piezas, debe ser un entero positivo.","Error!", JOptionPane.ERROR_MESSAGE);
            txtCantidadPiezas.requestFocus();
        }*/
    }//GEN-LAST:event_txtCantidadPiezasFocusLost

    private void txtCantidadVehiculosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadVehiculosFocusLost
        /*if (NumerosEnteros(txtCantidadVehiculos.getText())){
        }else{
            JOptionPane.showMessageDialog(null,"Formato incorrecto de la Cantidad de Vehículos, debe ser un entero positivo","Error!", JOptionPane.ERROR_MESSAGE);
            txtCantidadVehiculos.requestFocus();
        }*/
    }//GEN-LAST:event_txtCantidadVehiculosFocusLost

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
//        FrmMenu m = new FrmMenu();
        //m.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar3ActionPerformed
        
        try{
        //AgregarPedido();
        createTablePedido();
        
        if(cmbIDPedido.getSelectedIndex()==0){

        }
        else{
            cmbIDPedido.setSelectedIndex(0);
        }
        if("".equals(txtPrecioPieza.getText())){
            JOptionPane.showMessageDialog(null,"El campo de precio de la pieza esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }

        if (!ValidacionNumerosSiTienenDecimal(txtPrecioPieza.getText())){
            JOptionPane.showMessageDialog(null,"El precio de la Pieza solo puede contener Números positivos","Error!", JOptionPane.ERROR_MESSAGE);
            txtPrecioPieza.requestFocus();
            return;
        }else{

        }
        if("".equals(txtPrecioVehiculo.getText())){
            JOptionPane.showMessageDialog(null,"El campo de precio del vehículo esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if (!ValidacionNumerosSiTienenDecimal(txtPrecioVehiculo.getText())){
            JOptionPane.showMessageDialog(null,"El precio del vehículo solo puede contener Números positivos","Error!", JOptionPane.ERROR_MESSAGE);
            txtPrecioVehiculo.requestFocus();
            return;
        }else{

        }

        if("".equals(txtCantidadVehiculos.getText())){
            JOptionPane.showMessageDialog(null,"El campo de la cantidad de Vehículos esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if (!ValidacionNumeros(txtCantidadVehiculos.getText())){
            JOptionPane.showMessageDialog(null,"La Cantidad de vehículos debe ser de Números enteros positivos","Error!", JOptionPane.ERROR_MESSAGE);
            txtCantidadVehiculos.requestFocus();
            return;
        }else{

        }
        if("".equals(txtCantidadPiezas.getText())){
            JOptionPane.showMessageDialog(null,"El campo de cantidad de piezas esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if (!ValidacionNumeros(txtCantidadPiezas.getText())){
            JOptionPane.showMessageDialog(null,"La Cantidad de piezas debe ser de Números enteros positivos","Error!", JOptionPane.ERROR_MESSAGE);
            txtCantidadPiezas.requestFocus();
            return;
        }else{

        }
        Pedido temp = new Pedido();
        temp.setEstado(true);
        temp.setMonto_pedido(((Double.parseDouble(txtPrecioPieza.getText())*(Integer.parseInt(txtCantidadPiezas.getText())))+(Double.parseDouble(txtPrecioVehiculo.getText())*(Integer.parseInt(txtCantidadVehiculos.getText())))));

        int auxCmbPieza=cmbIDPieza.getSelectedIndex();

        int auxCmbVehiculo=cmbIDVehiculo.getSelectedIndex();
        //JOptionPane.showMessageDialog(null,auxCmbPieza+" "+auxCmbVehiculo);

        temp.setId_pedido(Pedidodao.getPedidoCount()+1);
        Calendar fecha = new GregorianCalendar();
        String fecha1;
        String aux1,aux2,aux3;
        aux1 = Integer.toString(fecha.get(Calendar.YEAR));
        aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
        aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        fecha1 = aux1+aux2+aux3;
        temp.setFecha_pedido(fecha1);

        
            Pedidodao.create(temp);
        

        Detalle_Pedido_Vehiculo tempp = new Detalle_Pedido_Vehiculo();
        tempp.setId_pedido_Vehiculo(PedidoVehiculodao.getDetalle_Pedido_VehiculoCount()+1);

        tempp.setId_pedido(Pedidodao.getPedidoCount());
        tempp.setId_vehiculo(auxCmbVehiculo);

        tempp.setCantidad(Integer.parseInt(txtCantidadVehiculos.getText()));
        tempp.setPrecio(Double.parseDouble(txtPrecioVehiculo.getText()));

       
            PedidoVehiculodao.create(tempp);
        

        Detalle_Pedido_pieza temppp = new Detalle_Pedido_pieza();
        temppp.setId_pedido_pieza(PedidoPiezadao.getDetalle_Pedido_piezaCount()+1);

        temppp.setId_pedido((Pedidodao.getPedidoCount()));
        temppp.setId_pieza(auxCmbPieza);
        temppp.setCantidad(Integer.parseInt(txtCantidadPiezas.getText()));
        temppp.setPrecio(Double.parseDouble(txtPrecioPieza.getText()));
       
            PedidoPiezadao.create(temppp);
        
        JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE);
        createTablePedido();
        createComboVehiculo();
        createComboPieza();
        btnAgregar3.setEnabled(true);

        Limpiar();
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
                Logger logger = Logger.getLogger(FrmPedidos.class.getName());
                FileHandler fh;
                fh = new FileHandler("./"+"PedidosAgregar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnAgregar3ActionPerformed

    private void cmbIDPedidoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDPedidoItemStateChanged
        /* if(cmbIDPedido.getSelectedIndex()==0){
            //txtIDPieza.setSelectedIndex(0);
            jCmbTipoPieza.setSelectedIndex(0);
            jTxtAreaCaracteristica.setText("");
            jFtxtStock.setText("");
            jFtxtStockMaximo.setText("");
            jFtxtStockMinimo.setText("");
            jFtxtPrecio.setText("");

        }
        else{
            Pieza e1;
            e1=piezaDao.findPieza( cmbIDPedido.getSelectedIndex());
            jCmbTipoPieza.setSelectedIndex(e1.getId_Tipo_Pieza()-1);
            jTxtAreaCaracteristica.setText(e1.getCarateristica_Pieza());
            jFtxtStock.setText(Integer.toString(e1.getStock()));
            jFtxtStockMaximo.setText(Integer.toString(e1.getStock_Maximo()));
            jFtxtStockMinimo.setText(Integer.toString(e1.getStock_Minimo()));
            List<HistoricoPrecioPieza> h1 = historicoPieza.findHistoricoPrecioPiezaEntities();
            for(HistoricoPrecioPieza p2 : h1){
                if(p2.getIdPieza() == e1.getId_Pieza()){
                    if(p2.getFechaFinal()==null){
                        jFtxtPrecio.setText(Double.toString(p2.getPrecio()));
                        break;
                    }
                    else
                    jFtxtPrecio.setText("0.00");

                }
                else{
                    jFtxtPrecio.setText("0.00");
                }
            }
            btnActivarDesactivarPieza();

        }*/

        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDPedidoItemStateChanged

    public int btnDesactivarActionPerfomedTest(int tblPedidoget,int tblPedido){
        if(tblPedidoget==-1){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún Pedido de la tabla","Error!",0);
            return 0;
        }
        else{
            
        }
        Pedido temp;
        int fila = tblPedidoget;
        if(fila > -1){   
        
        String pedido= String.valueOf(tblPedido);
        temp = Pedidodao.findPedido(Integer.parseInt(pedido));

        //temp = piezaDao.findPieza(txtIDPieza.getSelectedIndex()+1);
        //JOptionPane.showMessageDialog(null, temp.isEstado());
        
        
        if(temp.isEstado()){
            temp.setEstado(false);
//            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
//            JOptionPane.showMessageDialog(null,"Pedido Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
//            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
//            JOptionPane.showMessageDialog(null,"Pedido Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
//        try {
//            Pedidodao.edit(temp);
//        } catch (Exception ex) {
//            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        createTablePedido();
////        btnActivarDesactivarPedido();
//        btnDesactivar.setEnabled(false);
        
        }
        return 100;
    }
    
    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        try{
        if(tblPedido.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún Pedido de la tabla","Error!",0);
            return;
        }
        else{
            
        }
        Pedido temp;
        int fila = tblPedido.getSelectedRow();
        if(fila > -1){   
        
        String pedido= String.valueOf(tblPedido.getValueAt(fila, 0));
        temp = Pedidodao.findPedido(Integer.parseInt(pedido));
        btnDesactivar.setEnabled(true);
        //temp = piezaDao.findPieza(txtIDPieza.getSelectedIndex()+1);
        //JOptionPane.showMessageDialog(null, temp.isEstado());
        
        
        if(temp.isEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Pedido Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Pedido Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
     
            Pedidodao.edit(temp);
        
        createTablePedido();
//        btnActivarDesactivarPedido();
        btnDesactivar.setEnabled(false);
        
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
                Logger logger = Logger.getLogger(FrmPedidos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"PedidosDesactivar"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
//        FrmMenu m = new FrmMenu();
       // m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void txtCantidadVehiculosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVehiculosKeyTyped
       char c = evt.getKeyChar();
        if((c < '0' || c > '9')){

            evt.consume();

        }
        if (txtCantidadVehiculos.getText().length() >= 5){
        
        evt.consume();
        }
    }//GEN-LAST:event_txtCantidadVehiculosKeyTyped

    private void txtPrecioPiezaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioPiezaKeyTyped
        
                 
                char c = evt.getKeyChar();
        if((c < '0' || c > '9') && (c != '.' && c != ',')){

            evt.consume();

        }
        if (txtPrecioPieza.getText().length() >= 12){
        
        evt.consume();
        }
    }//GEN-LAST:event_txtPrecioPiezaKeyTyped

    private void txtCantidadPiezasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadPiezasKeyTyped
        char c = evt.getKeyChar();
        if((c < '0' || c > '9')){

            evt.consume();

        }
        if (txtCantidadPiezas.getText().length() >= 5){
        
        evt.consume();
        }
    }//GEN-LAST:event_txtCantidadPiezasKeyTyped

    private void imprimirReportePDF(Pedido d) throws JRException, IOException{
         Object [][] arrayDetallesFactura;
        int contador = 0;
        List<Detalle_Pedido_pieza> arregloPiezas = new ArrayList<>();
        List<Detalle_Pedido_Vehiculo> arregloVehiculos = new ArrayList<>();
//        JOptionPane.showMessageDialog(null, d.getId_pedido());
        List<Detalle_Pedido_pieza> piezaFTemp = PedidoPiezadao.findDetalle_Pedido_piezaEntities();
        for(Detalle_Pedido_pieza pf : piezaFTemp){
            if(pf.getId_pedido()==d.getId_pedido()){
                arregloPiezas.add(pf);
                contador++;
            }
        }
        List<Detalle_Pedido_Vehiculo> vehiculoFTemp = PedidoVehiculodao.findDetalle_Pedido_VehiculoEntities();
        for(Detalle_Pedido_Vehiculo vF : vehiculoFTemp){
            if(vF.getId_pedido()==d.getId_pedido()){
                arregloVehiculos.add(vF);
                contador++;
            }
        }
        
        
        
        
        
        arrayDetallesFactura = new Object[contador][5];
        double containerPrecio = 0;
        double containerImpuesto = 0;
        
        for(int i = 0;i<arregloPiezas.size();i++){
            arrayDetallesFactura[i][0]=(i+1);
            arrayDetallesFactura[i][1]=PiezaDao.findPieza(arregloPiezas.get(i).getId_pieza()).getNombre()+PiezaDao.findPieza(arregloPiezas.get(i).getId_pieza()).getCarateristica_Pieza();
            //arrayDetallesFactura[i][2]
            List<HistoricoPrecioPieza> temporalHPP=historicoPiezaDao.findHistoricoPrecioPiezaEntities();
            for(HistoricoPrecioPieza htp : temporalHPP){
                if(htp.getIdPieza()==arregloPiezas.get(i).getId_pieza() && htp.getFechaFinal()!=null){
                    LocalDate auxFechaInicial = LocalDate.parse(htp.getFechaInicial());
                    LocalDate auxFechaFinal = LocalDate.parse(htp.getFechaFinal());
                    LocalDate auxFechaEmision = LocalDate.parse(d.getFecha_pedido());
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
            arrayDetallesFactura[i+arregloPiezas.size()][0]=arregloVehiculos.get(i).getId_vehiculo();
            arrayDetallesFactura[i+arregloPiezas.size()][1]=arregloVehiculos.get(i).getCantidad()+" "+Marcadao.findMarca(Vehiculodao.findVehiculo(arregloVehiculos.get(i).getId_vehiculo()).getId_marca()).getMarca();
            //arrayDetallesFactura[i][2]
            List<HistoricoPrecioVehiculos> temporalHPV=historicoVehiculoDao.findHistoricoPrecioVehiculosEntities();
            for(HistoricoPrecioVehiculos htp : temporalHPV){
                if(htp.getId_vehiculo()==arregloVehiculos.get(i).getId_vehiculo() && htp.getFechaFinal()!=null){
                    LocalDate auxFechaInicial = LocalDate.parse(htp.getFechaInicial());
                    LocalDate auxFechaFinal = LocalDate.parse(htp.getFechaFinal());
                    LocalDate auxFechaEmision = LocalDate.parse(d.getFecha_pedido());
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
            arrayDetallesFactura[i+arregloPiezas.size()][4]=String.valueOf(Double.parseDouble(String.valueOf(arrayDetallesFactura[i][2]))*1);
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
        
        
        
        
        
       
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#,###,##0.00", separadoresPersonalizados);
        
        HashMap param = new HashMap();
        param.put("numFactura",String.valueOf(d.getId_pedido()));
        param.put("Empleado",empNomb);
        param.put("fechaHora",d.getFecha_pedido());
        param.put("impuesto", String.valueOf(containerImpuesto));
        param.put("total",String.valueOf(containerImpuesto+containerPrecio));
        //param.put("rtnvendedor",rs.getRtn());
        //param.put("cai", iF.getCai());
        //param.put("tipopago",tipoPagoDao.findTipoPago(f.getIdTipoPago()).getNombre());
       // param.put("limite",(iF.getFechaFinal().substring(8, 10)+"/"+iF.getFechaFinal().substring(5, 7)+"/"+iF.getFechaFinal().substring(0, 4)));
        
        
        //param.put("monto",formato1.format(f.getCantidadPago()) );
        
        //pp = personaDao.findPersona(c.getId_Persona()); // En caso de que no salga declara una persona distinta
        
        //p/aram.put("cliente", pp.getNombre()+" "+pp.getApellido());
        //param.put("documento",pp.getDocumento_id());
        
        
        
            JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\pedido.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,FacturaJRADATASOURCE.getDataSource(arrayDetallesFactura));
            
            //JasperRunManager.runReportToPdf(reporteFactura, param);
            
            File pdf = File.createTempFile("Reporte de Pedido"+"-"+".", ".pdf",new File("C:\\CarSoft-Version-2.1\\Reportes"));
            //JasperExportManager.exportReportToPdfFile(print, empNomb);
            JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdf));
            //JOptionPane.showMessageDialog(null,pdf.getPath());
            ProcessBuilder p = new ProcessBuilder();
            p.command("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","/c",pdf.getPath());
            p.start();
            
            
    }
    
    private void imprimirReporteExcel(Pedido d) throws JRException, IOException{
         Object [][] arrayDetallesFactura;
        int contador = 0;
        List<Detalle_Pedido_pieza> arregloPiezas = new ArrayList<>();
        List<Detalle_Pedido_Vehiculo> arregloVehiculos = new ArrayList<>();
//        JOptionPane.showMessageDialog(null, d.getId_pedido());
        List<Detalle_Pedido_pieza> piezaFTemp = PedidoPiezadao.findDetalle_Pedido_piezaEntities();
        for(Detalle_Pedido_pieza pf : piezaFTemp){
            if(pf.getId_pedido()==d.getId_pedido()){
                //JOptionPane.showMessageDialog(null,"Piezas");
                arregloPiezas.add(pf);
                contador++;
            }
        }
        List<Detalle_Pedido_Vehiculo> vehiculoFTemp = PedidoVehiculodao.findDetalle_Pedido_VehiculoEntities();
        for(Detalle_Pedido_Vehiculo vF : vehiculoFTemp){
            if(vF.getId_pedido()==d.getId_pedido()){
                arregloVehiculos.add(vF);
                contador++;
            }
        }
        
        
        
        
        
        arrayDetallesFactura = new Object[contador][5];
        double containerPrecio = 0;
        double containerImpuesto = 0;
        //JOptionPane.showMessageDialog(null,arregloPiezas.size());
        for(int i = 0;i<arregloPiezas.size();i++){
          //  JOptionPane.showMessageDialog(null,arregloPiezas.get(i).getId_pieza());
            arrayDetallesFactura[i][0]=(i+1);
            arrayDetallesFactura[i][1]=PiezaDao.findPieza(arregloPiezas.get(i).getId_pieza()).getNombre()+PiezaDao.findPieza(arregloPiezas.get(i).getId_pieza()).getCarateristica_Pieza();
            //arrayDetallesFactura[i][2]
            List<HistoricoPrecioPieza> temporalHPP=historicoPiezaDao.findHistoricoPrecioPiezaEntities();
            for(HistoricoPrecioPieza htp : temporalHPP){
                if(htp.getIdPieza()==arregloPiezas.get(i).getId_pieza() && htp.getFechaFinal()!=null){
                    LocalDate auxFechaInicial = LocalDate.parse(htp.getFechaInicial());
                    LocalDate auxFechaFinal = LocalDate.parse(htp.getFechaFinal());
                    LocalDate auxFechaEmision = LocalDate.parse(d.getFecha_pedido());
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
            
            arrayDetallesFactura[i+arregloPiezas.size()][0]=arregloVehiculos.get(i).getId_vehiculo();
            arrayDetallesFactura[i+arregloPiezas.size()][1]=arregloVehiculos.get(i).getCantidad()+" "+Marcadao.findMarca(Vehiculodao.findVehiculo(arregloVehiculos.get(i).getId_vehiculo()).getId_marca()).getMarca();
            //arrayDetallesFactura[i][2]
            List<HistoricoPrecioVehiculos> temporalHPV=historicoVehiculoDao.findHistoricoPrecioVehiculosEntities();
            for(HistoricoPrecioVehiculos htp : temporalHPV){
                if(htp.getId_vehiculo()==arregloVehiculos.get(i).getId_vehiculo() && htp.getFechaFinal()!=null){
                    LocalDate auxFechaInicial = LocalDate.parse(htp.getFechaInicial());
                    LocalDate auxFechaFinal = LocalDate.parse(htp.getFechaFinal());
                    LocalDate auxFechaEmision = LocalDate.parse(d.getFecha_pedido());
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
            arrayDetallesFactura[i+arregloPiezas.size()][4]=String.valueOf(Double.parseDouble(String.valueOf(arrayDetallesFactura[i][2]))*1);
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
        
        
        
        
        
       
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#,###,##0.00", separadoresPersonalizados);
        
        HashMap param = new HashMap();
        param.put("numFactura",String.valueOf(d.getId_pedido()));
        param.put("Empleado",empNomb);
        param.put("fechaHora",d.getFecha_pedido());
        param.put("impuesto", String.valueOf(containerImpuesto));
        param.put("total",String.valueOf(containerImpuesto+containerPrecio));
        //param.put("rtnvendedor",rs.getRtn());
        //param.put("cai", iF.getCai());
        //param.put("tipopago",tipoPagoDao.findTipoPago(f.getIdTipoPago()).getNombre());
       // param.put("limite",(iF.getFechaFinal().substring(8, 10)+"/"+iF.getFechaFinal().substring(5, 7)+"/"+iF.getFechaFinal().substring(0, 4)));
        
        
        //param.put("monto",formato1.format(f.getCantidadPago()) );
        
        //pp = personaDao.findPersona(c.getId_Persona()); // En caso de que no salga declara una persona distinta
        
        //p/aram.put("cliente", pp.getNombre()+" "+pp.getApellido());
        //param.put("documento",pp.getDocumento_id());
        
        
        
            JasperReport reporteFactura = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\pedido.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporteFactura, param,FacturaJRADATASOURCE.getDataSource(arrayDetallesFactura));
            
            //JasperRunManager.runReportToPdf(reporteFactura, param);
            
            JRXlsxExporter exporter = new JRXlsxExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\Reportes\\reportePedido.xlsx");

            exporter.exportReport();
            
            ProcessBuilder p = new ProcessBuilder();
            p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\Reportes\\reportePedido.xlsx");
            p.start();

            
            
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Pedido d = null;
        int fila = tblPedido.getSelectedRow();
        if(fila > -1){
            List<Pedido> fac = Pedidodao.findPedidoEntities();
            ///JOptionPane.showMessageDialog(null,String.valueOf(tblPedido.getValueAt(fila, 0)));
            for(Pedido w : fac ){
                if(w.getId_pedido()==Integer.parseInt(String.valueOf(tblPedido.getValueAt(fila, 0)))){
                   // JOptionPane.showMessageDialog(null,w.getId_pedido());
                    d=w;
                    break;
                }
            }
        
        
        try {
            //Codigo de Buscar Pedido
            
            imprimirReportePDF(d);
            
            // TODO add your handling code here:
        } catch (JRException | IOException e) {
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
                Logger logger = Logger.getLogger(FrmPedidos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"PedidoPDF"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        Pedido d = null;
        int fila = tblPedido.getSelectedRow();
        if(fila > -1){
            List<Pedido> fac = Pedidodao.findPedidoEntities();
            ///JOptionPane.showMessageDialog(null,String.valueOf(tblPedido.getValueAt(fila, 0)));
            for(Pedido w : fac ){
                if(w.getId_pedido()==Integer.parseInt(String.valueOf(tblPedido.getValueAt(fila, 0)))){
                   // JOptionPane.showMessageDialog(null,w.getId_pedido());
                    d=w;
                    break;
                }
            }
        
        
        try {
            //Codigo de Buscar Pedido
            
            imprimirReporteExcel(d);
            
            // TODO add your handling code here:
        } catch (JRException | IOException e) {
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
                Logger logger = Logger.getLogger(FrmPedidos.class.getName());
                FileHandler fh = null;
                fh = new FileHandler("./"+"PedidoExcel"+fecha1+".log");
                logger.addHandler(fh);
                fh.setFormatter(new SimpleFormatter());
                logger.setLevel(Level.WARNING);
                logger.log(Level.SEVERE,e.getMessage());
                fh.close();
            } catch (IOException | SecurityException ex) {
                Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public int AgregarPedidoTest(int cmbIDPieza,int cmbIDVehiculo){
        Pedido temp = new Pedido();
        temp.setEstado(true);
        
        
        int auxCmbPieza=cmbIDPieza;
        
        int auxCmbVehiculo=cmbIDVehiculo;
        //JOptionPane.showMessageDialog(null,auxCmbPieza+" "+auxCmbVehiculo);
        
        temp.setId_pedido(Pedidodao.getPedidoCount()+1);
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
           fecha1 = aux1+aux2+aux3;
        temp.setMonto_pedido(Double.parseDouble("0.01".trim()));
        temp.setFecha_pedido(fecha1);

//        try {
//            Pedidodao.create(temp);
//        } catch (Exception ex) {
//            Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
//        }

        Detalle_Pedido_pieza temporal = new Detalle_Pedido_pieza();
        Detalle_Pedido_Vehiculo temporal2 = new Detalle_Pedido_Vehiculo();

//        for(int i = 0;i<tblPedidoPiezaVehiculo.getRowCount();i++){
//            if(tblPedidoPiezaVehiculo.getModel().getValueAt(i, 1).toString().charAt(0)=='1'){
//                temporal.setId_pedido_pieza(PedidoPiezadao.getDetalle_Pedido_piezaCount()+1);
//                temporal.setId_pedido((Pedidodao.getPedidoCount()));
//                temporal.setId_pieza(Integer.parseInt("1"));
//                temporal.setPrecio(Double.parseDouble("0.00"));
//                temporal.setCantidad(Integer.parseInt("1"));
//                
////                try {
////                    PedidoPiezadao.create(temporal);
////                } catch (Exception ex) {
////                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
////                }
//
//            } else {
//               temporal2.setId_pedido_Vehiculo(PedidoVehiculodao.getDetalle_Pedido_VehiculoCount()+1);
//                temporal2.setId_pedido((Pedidodao.getPedidoCount()));
//                temporal2.setId_vehiculo(Integer.parseInt("1"));
//                temporal2.setPrecio(Double.parseDouble("0.00"));
//                temporal2.setCantidad(Integer.parseInt(tblPedidoPiezaVehiculo.getModel().getValueAt(i, 3).toString()));

//                try {
//                    PedidoVehiculodao.create(temporal2);
//                } catch (Exception ex) {
//                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
//                Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
//                JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
//                txtTotal.setText("");
            //}
        //}
        
//        int a= tblPedidoPiezaVehiculo.getRowCount()-1;
//        DefaultTableModel modelo = (DefaultTableModel) tblPedidoPiezaVehiculo.getModel();
//        for(int i=a;i>=0;i--){
//            modelo.removeRow(i);
//        }
        return 100;
    }
    
    private void AgregarPedido(){

         Pedido temp = new Pedido();
        temp.setEstado(true);
        
        
        int auxCmbPieza=cmbIDPieza.getSelectedIndex();
        
        int auxCmbVehiculo=cmbIDVehiculo.getSelectedIndex();
        //JOptionPane.showMessageDialog(null,auxCmbPieza+" "+auxCmbVehiculo);
        
        temp.setId_pedido(Pedidodao.getPedidoCount()+1);
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
           fecha1 = aux1+aux2+aux3;
        temp.setMonto_pedido(Double.parseDouble(txtTotal.getText().replace(",", "").replace(",", "").trim()));
        temp.setFecha_pedido(fecha1);

        try {
            Pedidodao.create(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }

        Detalle_Pedido_pieza temporal = new Detalle_Pedido_pieza();
        Detalle_Pedido_Vehiculo temporal2 = new Detalle_Pedido_Vehiculo();

        for(int i = 0;i<tblPedidoPiezaVehiculo.getRowCount();i++){
            if(tblPedidoPiezaVehiculo.getModel().getValueAt(i, 1).toString().charAt(0)=='1'){
                temporal.setId_pedido_pieza(PedidoPiezadao.getDetalle_Pedido_piezaCount()+1);
                temporal.setId_pedido((Pedidodao.getPedidoCount()));
                temporal.setId_pieza(Integer.parseInt(tblPedidoPiezaVehiculo.getModel().getValueAt(i, 0).toString()));
                temporal.setPrecio(Double.parseDouble(tblPedidoPiezaVehiculo.getModel().getValueAt(i, 2).toString().replace(",", "").replace(",", "").trim()));
                temporal.setCantidad(Integer.parseInt(tblPedidoPiezaVehiculo.getModel().getValueAt(i, 3).toString()));
                
                try {
                    PedidoPiezadao.create(temporal);
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
               temporal2.setId_pedido_Vehiculo(PedidoVehiculodao.getDetalle_Pedido_VehiculoCount()+1);
                temporal2.setId_pedido((Pedidodao.getPedidoCount()));
                temporal2.setId_vehiculo(Integer.parseInt(tblPedidoPiezaVehiculo.getModel().getValueAt(i, 0).toString()));
                temporal2.setPrecio(Double.parseDouble(tblPedidoPiezaVehiculo.getModel().getValueAt(i, 2).toString().replace(",", "").replace(",", "").trim()));
                temporal2.setCantidad(Integer.parseInt(tblPedidoPiezaVehiculo.getModel().getValueAt(i, 3).toString()));

                try {
                    PedidoVehiculodao.create(temporal2);
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
                JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
                txtTotal.setText("");
            }
        }
        
        int a= tblPedidoPiezaVehiculo.getRowCount()-1;
        DefaultTableModel modelo = (DefaultTableModel) tblPedidoPiezaVehiculo.getModel();
        for(int i=a;i>=0;i--){
            modelo.removeRow(i);
        }
}public boolean ValidacionNumerosSiTienenDecimal(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^\\d*\\.?\\d*$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{       
        return false;
        
        }
    }
public boolean ValidacionNumerosDecimales(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^\\d*\\.\\d*$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{       
        return false;
        
        }
    }
public boolean ValidacionNumeros(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^\\d*$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{       
        return false;
        
        }
    }
public boolean ValidacionFechaDDMMYYYY(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^(?:(?:(?:0[1-9]|1\\d|2[0-8])[/](?:0[1-9]|1[0-2])|(?:29|30)[/](?:0[13-9]|1[0-2])|31[/](?:0[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\\d|0?[1-9]\\d{2}|[1-9]\\d{3})|29[/]0?2[/](?:\\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }private void Limpiar(){
        cmbIDPedido.setSelectedIndex(0);
        cmbIDVehiculo.setSelectedIndex(0);
        cmbIDPieza.setSelectedIndex(0);
        txtCantidadVehiculos.setText("");
        txtCantidadPiezas.setText("");
        txtPrecioPieza.setText("");
        txtPrecioVehiculo.setText("");
        //btnDesactivar3.setEnabled(false);
        //btnModificar3.setEnabled(false);
        btnAgregar3.setEnabled(true);
}private void crearTbAgregarPieza(){
        //label1.setText("11223");
        DefaultTableModel modelo = (DefaultTableModel) tblPedidoPiezaVehiculo.getModel();
        tblPedidoPiezaVehiculo.setModel(modelo);
        
        
        if(cmbIDPieza.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Por favor, seleccione una Pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if("".equals(txtCantidadPiezas.getText())){
            JOptionPane.showMessageDialog(null,"Por favor, ingrese la Cantidad de pIezas","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
     
        }
        if (!ValidacionCantidadPiezas(txtCantidadPiezas.getText())){
            JOptionPane.showMessageDialog(null,"El rango de la cantidad de Piezas solo puede estar entre 1-100","Error!", JOptionPane.ERROR_MESSAGE);
            txtCantidadPiezas.requestFocus();
            return;
        }else{

        }
        
        if("".equals(txtPrecioPieza.getText())){
            JOptionPane.showMessageDialog(null,"Por favor, ingrese el Precio de la Pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if (!ValidacionRangoPrecioPieza(txtPrecioPieza.getText())){
            JOptionPane.showMessageDialog(null,"El rango de Precio de la Pieza solo puede estar entre 20.00-40,000.00","Error!", JOptionPane.ERROR_MESSAGE);
            txtPrecioPieza.requestFocus();
            return;
        }
        
        
       /* if(txtCantidadVehiculos.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese la cantidad","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }*/
        
       /*if(txtPrecioVehiculo.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese el precio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }*/

        Pieza temp = PiezaDao.findPieza((cmbIDPieza.getSelectedIndex()));
        
        if(temp==null){
            JOptionPane.showMessageDialog(null,"Pieza no encontrada","ID NO VALIDO",0);
            return;
        }
        
        if(txtCantidadPiezas.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese la cantidad","CAMPO VACíO",0);
            return;
        }
        
       if(txtPrecioPieza.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese el precio","CAMPO VACíO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!temp.isEstado()){
            JOptionPane.showMessageDialog(null, "Pieza descontinuada, por favor, Ponerse en contacto con el Gerente","PIEZA DESCONTINUADA",0);
        }
     
        List<HistoricoPrecioPieza> temp2 = historicoPiezaDao.findHistoricoPrecioPiezaEntities();

        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        double auxpreciov=(Double.parseDouble(txtPrecioPieza.getText().replace(",", "").replace(",", "").trim()));
        int auxcantidadv=(Integer.parseInt(txtCantidadPiezas.getText()));
        modelo.addRow(new Object[]{
            temp.getId_Pieza(),
            "1. "+temp.getNombre()+temp.getCarateristica_Pieza(),
            String.format("%,.2f", (auxpreciov)),
            auxcantidadv,
           String.format("%,.2f",((auxcantidadv)*(auxpreciov)))
        });
        
        double contenedorPrecio=0;
        for(int i=0;i<modelo.getRowCount();i++){
            contenedorPrecio+=Double.parseDouble(modelo.getValueAt(i, 4).toString().replace(",", "").replace(",", "").trim());
            
            
        }
        txtTotal.setText(String.format("%,.2f",contenedorPrecio));
        Limpiar();
    }
public boolean ValidacionRangoPrecioPieza(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([2-9][0-9][.][0-9][0-9]|[1-9][0-9][0-9][.][0-9][0-9]|[1-9][,][1-9][1-9][1-9][.][0-9][0-9]|[0-3][0-9][,][0-9][0-9][0-9][.][0-9][0-9]|[4][0][,][0][0][0][.][0][0])$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
 private void crearTbAgregarVehiculo(){
     DefaultTableModel modelo = (DefaultTableModel) tblPedidoPiezaVehiculo.getModel();   
     tblPedidoPiezaVehiculo.setModel(modelo);
        
         if((cmbIDVehiculo.getSelectedIndex())==0){
            JOptionPane.showMessageDialog(null,"Por favor, seleccione un Vehículo","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        /*if(cmbIDVehiculo.getSelectedIndex()!=0){
            JOptionPane.showMessageDialog(null,"No hay ningun Vehiculo con ID 0 ","ID NO RECONOCIDO",0);
            cmbIDVehiculo.setSelectedIndex(0);
            return;
        }
        else{

        }*/
        if("".equals(txtCantidadVehiculos.getText())){
            JOptionPane.showMessageDialog(null,"Por favor, ingrese la Cantidad de Vehículos","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
     
        }
        if (!ValidacionCantidadVehiculos(txtCantidadVehiculos.getText())){
            JOptionPane.showMessageDialog(null,"El rango de la cantidad de Vehículos solo puede estar entre 1-20","Error!", JOptionPane.ERROR_MESSAGE);
            txtCantidadVehiculos.requestFocus();
            return;
        }else{

        }
        
        if("".equals(txtPrecioVehiculo.getText())){
            JOptionPane.showMessageDialog(null,"Por favor, ingrese el Precio del Vehículo","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            
        }
        if (!ValidacionRangoPrecioVehiculo(txtPrecioVehiculo.getText())){
            JOptionPane.showMessageDialog(null,"El rango de Precio del Vehículo solo puede estar entre 50,000.00-800,000.00","Error!", JOptionPane.ERROR_MESSAGE);
            txtPrecioVehiculo.requestFocus();
            return;
            }else{

            }
        Vehiculo temp = Vehiculodao.findVehiculo(cmbIDVehiculo.getSelectedIndex());
        
        if(temp==null){
            JOptionPane.showMessageDialog(null,"Vehiculo no encontrado","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(txtCantidadVehiculos.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese la cantidad","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
       if(txtPrecioVehiculo.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese el precio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!temp.isEstado()){
            JOptionPane.showMessageDialog(null, "Vehiculo descontinuada, por favor, Ponerse en contacto con el Gerente","Error!", JOptionPane.ERROR_MESSAGE);
        }
     
        
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        double auxpreciov=(Double.parseDouble(txtPrecioVehiculo.getText().replace(",", "").replace(",", "").trim()));
        int auxcantidadv=(Integer.parseInt(txtCantidadVehiculos.getText()));
        modelo.addRow(new Object[]{
            
            temp.getId_vehiculo(),"2. "+Marcadao.findMarca(temp.getId_marca()).getMarca()+temp.getVin(),
            String.format("%,.2f", (auxpreciov)),
             auxcantidadv,
           String.format("%,.2f",((auxcantidadv)*(auxpreciov)))
        });
        
        
        double contenedorPrecio=0;
        for(int i=0;i<modelo.getRowCount();i++){
            contenedorPrecio+=Double.parseDouble(modelo.getValueAt(i, 4).toString().replace(",", "").trim());
            
            
        }
        txtTotal.setText(String.format("%,.2f",contenedorPrecio));
        Limpiar();
        
    }
  public boolean ValidacionRangoPrecioVehiculo(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([5-9][0-9][,][0-9][0-9][0-9][.][0-9][0-9]|[1-7][0-9][0-9][,][0-9][0-9][0-9][.][0-9][0-9]|[8][0][0][,][0][0][0][.][0][0])$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    } 
 public boolean ValidacionCantidadVehiculos(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([1-9]|[1][0-9]|[2][0])$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
  public boolean ValidacionCantidadPiezas(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([1-9]|[1-9][0-9]|[1][0][0])$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
     private void crearTbPedido(){
         
         DefaultTableModel modelo = (DefaultTableModel) tblPedidoPiezaVehiculo.getModel();
        tblPedidoPiezaVehiculo.setModel(modelo);
        /*modelo.addColumn("ID");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio Unit");
        modelo.addColumn("Cant");
        modelo.addColumn("SubTotal");*/
        
    }
     
    
     
     
     
     public void BuscarVehiculo(){
        ModalVehiculosCombo temp2 = new ModalVehiculosCombo(this,true);
        temp2.setLocationRelativeTo(null);
        temp2.setVisible(true);
        cmbIDVehiculo.setSelectedItem(temp2.getId()+". "+temp2.getMarca()+" ("+temp2.getModelo()+"-"+temp2.getTotalcilin()+")");
}public void BuscarPieza(){
        ModalPiezasCombo temp2 = new ModalPiezasCombo(this,true);
        temp2.setLocationRelativeTo(null);
        temp2.setVisible(true);
        cmbIDPieza.setSelectedItem(temp2.getId()+". "+temp2.getTipo()+" ("+temp2.getNombre()+")");
}
/*
private void createTablaBusqueda(){
        
        boolean bandera = false;
        List<Pedido> temp = Pedidodao.findPedidoEntities();
        if(chkFecha.isSelected()){
            for(Pedido f : temp){
           String auxfecha="";
           String auxfechainiciotemp="";
           String anio="";
           String mes="";
           String dia="";
           String auxfechafinaltabla="";
           String auxfechainiciotabla="";
           auxfecha=txtFechaPedido.getText();
           anio=auxfecha.substring(6,10);
           mes=auxfecha.substring(3,5);
           dia=auxfecha.substring(0,2);
           
           auxfechainiciotemp=anio+"-"+mes+"-"+dia;
           
                //JOptionPane.showMessageDialog(null,f.getFecha_pedido(),"", 0);
                if(auxfechainiciotemp.equals(f.getFecha_pedido())){
               //Pedidodao.findPedido(f.getId_pedido()).getFecha_pedido();
                auxfechainiciotabla=(f.getFecha_pedido().substring(8, 10)+"/"+f.getFecha_pedido().substring(5, 7)+"/"+f.getFecha_pedido().substring(0, 4));
               //JOptionPane.showMessageDialog(null,auxfechainiciotabla,"", 0);
                           
                if(f.getFecha_entrega()==null) {
        
                                            auxfechafinaltabla="";
                                            
                                    } else {
                                         auxfechafinaltabla=(f.getFecha_entrega().substring(8, 10)+"/"+f.getFecha_entrega().substring(5, 7)+"/"+f.getFecha_entrega().substring(0, 4));
  
                                    }
        DefaultTableModel modelo1 = new DefaultTableModel();
        tblPedido.setModel(modelo1);
        modelo.addColumn("ID Pedido");
        modelo.addColumn("Monto total del pedido");
        modelo.addColumn("Fecha pedido");
        modelo.addColumn("Fecha de Entrega");
        modelo.addColumn("Estado");
        modelo1.addRow
                    (new Object[]{
                        f.getId_pedido(),
                        f.getMonto_pedido(),
                        auxfechainiciotabla,
                        //"",
                        auxfechafinaltabla,
                        //"",
                        f.isEstado()? "Activo" : "Inactivo",
                    });
                //JOptionPane.showMessageDialog(null,f.getId_pedido(),"", 0);
                //JOptionPane.showMessageDialog(null,f.getMonto_pedido(),"", 0);
                //JOptionPane.showMessageDialog(null,auxfechainiciotabla,"", 0);
                //JOptionPane.showMessageDialog(null,auxfechafinaltabla,"", 0);
                //JOptionPane.showMessageDialog(null,f.isEstado(),"", 0);
                      
                bandera = true;
                }
                else{
                    
                }
            }
            if(!bandera){
            JOptionPane.showMessageDialog(null,"No se encontro ningun Pedido");
        }
            
        }   
    }*/
public void txtPedidoListaBusqueda(){

}private boolean NumerosEnterosDecimales(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[0-9](.)[0-9]{2}$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
private boolean NumerosEnteros(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[0-9]$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar3;
    private javax.swing.JButton btnAgregar4;
    private javax.swing.JButton btnAgregar5;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JComboBox<String> cmbIDPedido;
    private javax.swing.JComboBox<String> cmbIDPieza;
    private javax.swing.JComboBox<String> cmbIDVehiculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTable tblPedidoPiezaVehiculo;
    private javax.swing.JTextField txtCantidadPiezas;
    private javax.swing.JTextField txtCantidadVehiculos;
    private javax.swing.JTextField txtPrecioPieza;
    private javax.swing.JTextField txtPrecioVehiculo;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
