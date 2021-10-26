/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import Clases.HistoricoPrecioPieza;
import Clases.Pieza;
import Clases.TipoPieza;
import Clases.Validaciones;
import JPAController.HistoricoPrecioPiezaJpaController;
import JPAController.PiezaJpaController;
import JPAController.TipoPiezaJpaController;
import static Pantallas.FrmMenu.labelEmple1;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Usuario
 */
public class FrmPieza extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     * 
     */
    EntityManagerFactory emf =Persistence.createEntityManagerFactory("CarSoft");
    
    PiezaJpaController piezaDao = new PiezaJpaController(emf);
    HistoricoPrecioPiezaJpaController historicoPieza = new HistoricoPrecioPiezaJpaController(emf);
    TipoPiezaJpaController tipoPieza = new TipoPiezaJpaController(emf);
    Connection con;
    
    public FrmPieza() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Img/CarSoft-removebg-preview.png")).getImage());
        this.setExtendedState(MAXIMIZED_BOTH);
        pnlPieza.setBackground(Color.CYAN);
        jTabbedPane3.setBackground(Color.CYAN);
        jPanel2.setBackground(Color.CYAN);
        jPanel1.setBackground(Color.CYAN);
        txtIDPieza.setBackground(Color.GRAY);
        txtIDTipoPieza.setBackground(Color.GRAY);
        
        createTableTipoPieza();
        createComboBox3();
        btnDesactivar2.setEnabled(false);
        btnDesactivar3.setEnabled(false);
        
        btnModificar3.setEnabled(false);
        btnModificar2.setEnabled(false);
        this.btnAgregar2.setBackground( new Color(14, 209, 69));
        this.btnSalir2.setBackground( new Color(236, 28, 36));
        this.btnModificar2.setBackground( new Color(14, 209, 69));
        this.btnLimpiar2.setBackground( new Color(14, 209, 69));
        this.btnDesactivar2.setBackground( new Color(14, 209, 69));
        this.btnRegresar2.setBackground( new Color(14, 209, 69));
        this.btnAgregar3.setBackground( new Color(14, 209, 69));
        this.btnSalir1.setBackground( new Color(236, 28, 36));
        this.btnRegresar1.setBackground( new Color(14, 209, 69));
        this.btnSalir.setBackground( new Color(236, 28, 36));
        this.btnSalir3.setBackground( new Color(236, 28, 36));
        this.btnRegresar3.setBackground( new Color(14, 209, 69));
        this.btnModificar3.setBackground( new Color(14, 209, 69));
        this.btnLimpiar3.setBackground( new Color(14, 209, 69));
        this.btnDesactivar3.setBackground( new Color(14, 209, 69));
        this.btnRegresar.setBackground( new Color(14, 209, 69));
        this.getContentPane().setBackground(new Color(0, 75, 143));
        this.jPanel1.setBackground( new Color(0, 75, 143));
        this.jPanel2.setBackground( new Color(0, 75, 143));
        this.jPanel3.setBackground( new Color(0, 75, 143));
        this.pnlPieza.setBackground( new Color(0, 75, 143));
        this.btnBuscar.setBackground( new Color(14, 209, 69));
        
        
            jTablePieza.setForeground(Color.WHITE);
            jTablePieza.setBackground(Color.BLACK);
            
            jTbHistorialPrecio.setForeground(Color.WHITE);
            jTbHistorialPrecio.setBackground(Color.BLACK);
            
            jTableTipoPieza.setForeground(Color.WHITE);
            jTableTipoPieza.setBackground(Color.BLACK);
            
            tablaBusqueda.setForeground(Color.WHITE);
            tablaBusqueda.setBackground(Color.BLACK);
            this.btnGenerar.setBackground( new Color(14, 209, 69));
        this.btnGenerar2.setBackground( new Color(14, 209, 69));
        this.btnGenerar3.setBackground( new Color(14, 209, 69));
        this.btnGenerar4.setBackground( new Color(14, 209, 69));
        this.btnGenerar5.setBackground( new Color(14, 209, 69));
        this.btnGenerar6.setBackground( new Color(14, 209, 69));

        createTablaPieza();
        createCmbTipoPieza();
        createCmbIDPieza();
        crearcmbPiezaHistorico();
        setlabelEmpleado(String.valueOf(labelEmple1.getText()));
        labelempleado.setVisible(false);
    }
 public void setlabelEmpleado(String valor){
        //IniciodeSesion i = new IniciodeSesion();
        //String valor = i.labelEmple1.getText();
        labelempleado.setText(valor);
    }   
    public void crearTbHistorialPrecio(){
        DefaultTableModel modelo = (DefaultTableModel) jTbHistorialPrecio.getModel();
        
        
        
        
        jTbHistorialPrecio.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        
        
        /*modelo.addColumn("ID Precio Historico");
        modelo.addColumn("ID pieza");
        modelo.addColumn("Pieza");
        modelo.addColumn("Caracteristica");
        modelo.addColumn("Precio");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        modelo.addColumn("Estado");*/
        
        List<HistoricoPrecioPieza> temp = historicoPieza.findHistoricoPrecioPiezaEntities();
        List<Pieza> temp2 = piezaDao.findPiezaEntities();
        String aux1="";
        String aux2="";
        String auxFecha1 = "";
        String auxFecha2 = "";
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
        for(HistoricoPrecioPieza e : temp){
            if(e.getIdPieza()==(cmbIDPieza.getSelectedIndex())){
            for(Pieza tp : temp2){
                if(tp.getId_Pieza() == e.getIdPieza()){
                    aux1=(tp.getCarateristica_Pieza());
                    aux2=tp.getNombre();auxFecha2="";
                    auxFecha1 = e.getFechaInicial().substring(8, 10)+"/"+e.getFechaInicial().substring(5,7)+"/"+e.getFechaInicial().substring(0, 4);
                    if(e.getFechaFinal()!=null){
                        auxFecha2 = e.getFechaFinal().substring(8, 10)+"/"+e.getFechaFinal().substring(5,7)+"/"+e.getFechaFinal().substring(0, 4);
                    }
                    
                    modelo.addRow(new Object[]{
                                  e.getIdPrecioHistorico(),
                                  e.getIdPieza(),
                                  aux2,
                                  aux1,
                                  String.format("%,.2f",e.getPrecio()),
                                  auxFecha1,
                                  auxFecha2,
                                  (e.getEstado())? "Activo":"Inactivo"});
        
        }
            }
        }
        }
            
    }
    
    public void crearcmbPiezaHistorico(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        cmbIDPieza.setModel(modelo);
        List<Pieza> temp = piezaDao.findPiezaEntities();
        modelo.addElement("Seleccione...");
        for (Pieza e : temp){
            modelo.addElement(e.getNombre());
        }
    }
    
    private void btnActivarDesactivar(){
        TipoPieza temp;
        temp = tipoPieza.findTipoPieza(txtIDTipoPieza.getSelectedIndex());
        
        if(temp.getEstado()){
        btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar2.setText("Desactivar");  
        btnDesactivar2.setEnabled(true);
        }
        else{
            btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Activar.png"))); // NOI18N
            btnDesactivar2.setText("Activar");
            btnDesactivar2.setEnabled(true);
        }
    }
    
    private void btnActivarDesactivarPieza(){
        Pieza temp;
        temp = piezaDao.findPieza(txtIDPieza.getSelectedIndex());
        
        if(temp.isEstado()){
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

    public void createComboBox3(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        txtIDTipoPieza.setModel(modelo);
        List<TipoPieza> temp = tipoPieza.findTipoPiezaEntities();
        modelo.addElement("Nuevo");
        temp.forEach((e) -> {
            modelo.addElement(e.getIDtipopieza());
        });
        
    }
    
    public void createCmbTipoPieza(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        jCmbTipoPieza.setModel(modelo);
        modelo.addElement("Seleccione...");
        List<TipoPieza> temp = tipoPieza.findTipoPiezaEntities();
       temp.forEach((e) -> {
            modelo.addElement(e.getTipopieza());
        });
        
    }
    
    public void createCmbIDPieza(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
        txtIDPieza.setModel(modelo);
        List<Pieza> temp = piezaDao.findPiezaEntities();
        modelo.addElement("Nuevo");
        temp.forEach((e) -> {
            modelo.addElement(e.getId_Pieza());
        });
        
    }
    
    public void createTablaPieza(){
        DefaultTableModel modelo = (DefaultTableModel) jTablePieza.getModel();
        jTablePieza.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID");
        modelo.addColumn("Tipo de Pieza");
        modelo.addColumn("Nombre");
        modelo.addColumn("Característica");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado Maximo");
        modelo.addColumn("Estado minimo");
        modelo.addColumn("Estado");*/
        List<Pieza> temp = piezaDao.findPiezaEntities();
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        double auxPrecio=0;
        String aux1="";
        List<TipoPieza> temp2 = tipoPieza.findTipoPiezaEntities();
        List<HistoricoPrecioPieza> temp3 = historicoPieza.findHistoricoPrecioPiezaEntities();
        
        for(Pieza p : temp){
            for(TipoPieza p1 : temp2){
                if(p.getId_Tipo_Pieza()==p1.getIDtipopieza()){
                    aux1=p1.getTipopieza();
                    for(HistoricoPrecioPieza p2 : temp3){
                    if(p2.getIdPieza() == p.getId_Pieza()){
                    if(p2.getFechaFinal()==null){
                        auxPrecio=p2.getPrecio();
                    }
                }
                }
                }
                    
            }
            
            
            modelo.addRow(new Object[]{
                p.getId_Pieza(),
                aux1,
                p.getNombre(),
                p.getCarateristica_Pieza(),
                String.format("%,.2f",auxPrecio),
                p.getStock(),
                p.getStock_Maximo(),
                p.getStock_Minimo(),
                (p.isEstado())? "Activo" : "Inactivo"
            });
        }
        
        
    }
    
    private void crearTableBusquedaPieza(){
        if("".equals(txtNombreBusqueda.getText().trim())){
            JOptionPane.showMessageDialog(null, "El campo para la Búsqueda de Piezas esta vacío","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        boolean bandera = false;
        DefaultTableModel modelo = (DefaultTableModel) tablaBusqueda.getModel();
        tablaBusqueda.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID");
        modelo.addColumn("Tipo de Pieza");
        modelo.addColumn("Nombre");
        modelo.addColumn("Característica");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado Maximo");
        modelo.addColumn("Estado minimo");
        modelo.addColumn("Estado");*/
        List<Pieza> temp = piezaDao.findPiezaEntities();
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        double auxPrecio=0;
        String aux1="";
        List<TipoPieza> temp2 = tipoPieza.findTipoPiezaEntities();
        List<HistoricoPrecioPieza> temp3 = historicoPieza.findHistoricoPrecioPiezaEntities();
        
        for(Pieza p : temp){
            if(p.getNombre().equalsIgnoreCase(txtNombreBusqueda.getText())){
            for(TipoPieza p1 : temp2){
                if(p.getId_Tipo_Pieza()==p1.getIDtipopieza())
                    aux1=p1.getTipopieza();
                    bandera=true;
            }
            for(HistoricoPrecioPieza p2 : temp3){
                if(p2.getIdPieza() == p.getId_Pieza()){
                    if(p2.getFechaFinal()==null){
                        auxPrecio=p2.getPrecio();
                    }
                }
            }
            
            modelo.addRow(new Object[]{
                p.getId_Pieza(),
                aux1,
                p.getNombre(),
                p.getCarateristica_Pieza(),
                String.format("%,.2f",auxPrecio),
                p.getStock(),
                p.getStock_Maximo(),
                p.getStock_Minimo(),
                (p.isEstado())? "Activo" : "Inactivo"
            });}
        }
        if(!bandera){
                    JOptionPane.showMessageDialog(null,"La Pieza que ingreso no existe","Error!",JOptionPane.ERROR_MESSAGE);
                }
        else{
            
        }
        
        
    }
  public boolean BuscarPiezaTest(){
      if("".equals(txtNombreBusqueda.getText().trim())){
            //JOptionPane.showMessageDialog(null, "El campo para la Búsqueda de Piezas esta vacío","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        boolean bandera = false;
        DefaultTableModel modelo = (DefaultTableModel) tablaBusqueda.getModel();
        tablaBusqueda.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID");
        modelo.addColumn("Tipo de Pieza");
        modelo.addColumn("Nombre");
        modelo.addColumn("Característica");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado Maximo");
        modelo.addColumn("Estado minimo");
        modelo.addColumn("Estado");*/
        List<Pieza> temp = piezaDao.findPiezaEntities();
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        double auxPrecio=0;
        String aux1="";
        List<TipoPieza> temp2 = tipoPieza.findTipoPiezaEntities();
        List<HistoricoPrecioPieza> temp3 = historicoPieza.findHistoricoPrecioPiezaEntities();
        
        for(Pieza p : temp){
            if(p.getNombre().equalsIgnoreCase(txtNombreBusqueda.getText())){
            for(TipoPieza p1 : temp2){
                if(p.getId_Tipo_Pieza()==p1.getIDtipopieza())
                    aux1=p1.getTipopieza();
                    bandera=true;
            }
            for(HistoricoPrecioPieza p2 : temp3){
                if(p2.getIdPieza() == p.getId_Pieza()){
                    if(p2.getFechaFinal()==null){
                        auxPrecio=p2.getPrecio();
                    }
                }
            }
            
            modelo.addRow(new Object[]{
                p.getId_Pieza(),
                aux1,
                p.getNombre(),
                p.getCarateristica_Pieza(),
                String.format("%,.2f",auxPrecio),
                p.getStock(),
                p.getStock_Maximo(),
                p.getStock_Minimo(),
                (p.isEstado())? "Activo" : "Inactivo"
            });}
        }
        if(!bandera){
                    //JOptionPane.showMessageDialog(null,"La Pieza que ingreso no existe","Error!",JOptionPane.ERROR_MESSAGE);
                return false;
        }
        else{
            
        }
        return true;
  }  
    public void limpiar(){
        txtIDPieza.setSelectedIndex(0);
        jCmbTipoPieza.setSelectedIndex(0);
        jTxtAreaCaracteristica.setText("");
        jFtxtStock.setText("");
        jFtxtStockMaximo.setText("");
        jFtxtStockMinimo.setText("");
        jFtxtPrecio.setText("");
    }
    
    public void createTableTipoPieza(){
        DefaultTableModel modelo = (DefaultTableModel) jTableTipoPieza.getModel();
        jTableTipoPieza.setModel(modelo);
        int i;
        for(i=modelo.getRowCount()-1;i>=0;i--){
            modelo.removeRow(i);
        }
        /*modelo.addColumn("ID Pieza");
        modelo.addColumn("Pieza");
        modelo.addColumn("Estado");*/
        
        List<TipoPieza> temp = tipoPieza.findTipoPiezaEntities();
        
        for(TipoPieza e : temp)
            modelo.addRow(
                    new Object[]{
                        e.getIDtipopieza(),
                        e.getTipopieza(),
                        (e.getEstado())?"Activo":"Inactivo"
            });
                     
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        pnlPieza = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePieza = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAgregar3 = new javax.swing.JButton();
        btnModificar3 = new javax.swing.JButton();
        btnLimpiar3 = new javax.swing.JButton();
        btnDesactivar3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtAreaCaracteristica = new javax.swing.JTextArea();
        txtIDPieza = new javax.swing.JComboBox<>();
        jCmbTipoPieza = new javax.swing.JComboBox<>();
        jFtxtStockMaximo = new javax.swing.JFormattedTextField();
        jFtxtStock = new javax.swing.JFormattedTextField();
        jFtxtStockMinimo = new javax.swing.JFormattedTextField();
        jFtxtPrecio = new javax.swing.JTextField();
        labelempleado = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        btnGenerar2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cmbIDPieza = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTbHistorialPrecio = new javax.swing.JTable();
        btnSalir2 = new javax.swing.JButton();
        btnRegresar2 = new javax.swing.JButton();
        btnGenerar3 = new javax.swing.JButton();
        btnGenerar4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtTipoPiezaNuevo = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableTipoPieza = new javax.swing.JTable();
        btnAgregar2 = new javax.swing.JButton();
        btnModificar2 = new javax.swing.JButton();
        btnLimpiar2 = new javax.swing.JButton();
        btnDesactivar2 = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        btnRegresar1 = new javax.swing.JButton();
        txtIDTipoPieza = new javax.swing.JComboBox<>();
        btnGenerar5 = new javax.swing.JButton();
        btnGenerar6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtNombreBusqueda = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaBusqueda = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        btnRegresar3 = new javax.swing.JButton();
        btnSalir3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTabbedPane3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTabbedPane3FocusLost(evt);
            }
        });

        pnlPieza.setBackground(new java.awt.Color(0, 255, 255));
        pnlPieza.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID Pieza:");
        pnlPieza.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 95, 70, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Tipo Pieza:");
        pnlPieza.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 136, 70, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Características:");
        pnlPieza.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 150, 102, 25));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Precio:");
        pnlPieza.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 50, -1));

        jTablePieza.setForeground(new java.awt.Color(255, 255, 255));
        jTablePieza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pieza", "Tipo de Pieza", "Nombre", "Características", "Precio", "Stock", "Stock Máximo", "Estado Mínimo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePieza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePiezaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePieza);

        pnlPieza.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 306, 1270, 190));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Piezas");
        pnlPieza.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, 35));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        pnlPieza.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, -1, -1));

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        pnlPieza.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 600, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Stock:");
        pnlPieza.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 50, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Stock minimo:");
        pnlPieza.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 92, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Stock máximo:");
        pnlPieza.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 92, -1));

        btnAgregar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar3.setText("Agregar");
        btnAgregar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar3ActionPerformed(evt);
            }
        });
        pnlPieza.add(btnAgregar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 213, 130, -1));

        btnModificar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar3.setText("Modificar");
        btnModificar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar3ActionPerformed(evt);
            }
        });
        pnlPieza.add(btnModificar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 213, -1, -1));

        btnLimpiar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar3.setText("Limpiar");
        btnLimpiar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar3ActionPerformed(evt);
            }
        });
        pnlPieza.add(btnLimpiar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 213, -1, 41));

        btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar3.setText("Desactivar");
        btnDesactivar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar3ActionPerformed(evt);
            }
        });
        pnlPieza.add(btnDesactivar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 213, -1, -1));

        jTxtAreaCaracteristica.setColumns(20);
        jTxtAreaCaracteristica.setRows(5);
        jTxtAreaCaracteristica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtAreaCaracteristicaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTxtAreaCaracteristica);

        pnlPieza.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 214, 72));

        txtIDPieza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " ", " " }));
        txtIDPieza.setEnabled(false);
        txtIDPieza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtIDPiezaItemStateChanged(evt);
            }
        });
        pnlPieza.add(txtIDPieza, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 92, 230, 30));

        jCmbTipoPieza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "1", "2" }));
        jCmbTipoPieza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCmbTipoPiezaItemStateChanged(evt);
            }
        });
        pnlPieza.add(jCmbTipoPieza, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 133, 230, 30));

        jFtxtStockMaximo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFtxtStockMaximo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFtxtStockMaximoKeyTyped(evt);
            }
        });
        pnlPieza.add(jFtxtStockMaximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 90, 94, 30));

        jFtxtStock.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFtxtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFtxtStockKeyTyped(evt);
            }
        });
        pnlPieza.add(jFtxtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 98, 30));

        jFtxtStockMinimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFtxtStockMinimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFtxtStockMinimoKeyTyped(evt);
            }
        });
        pnlPieza.add(jFtxtStockMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 130, 94, 30));

        jFtxtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFtxtPrecioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFtxtPrecioKeyTyped(evt);
            }
        });
        pnlPieza.add(jFtxtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 98, 30));

        labelempleado.setText("jLabel1");
        pnlPieza.add(labelempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Nombre:");
        pnlPieza.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 90, 25));

        jtxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtNombreKeyTyped(evt);
            }
        });
        pnlPieza.add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 214, 30));

        btnGenerar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        btnGenerar.setText("Generar PDF");
        btnGenerar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        pnlPieza.add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, -1));

        btnGenerar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGenerar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        btnGenerar2.setText("Generar EXCEL");
        btnGenerar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerar2ActionPerformed(evt);
            }
        });
        pnlPieza.add(btnGenerar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, -1, -1));

        jTabbedPane3.addTab("Piezas", pnlPieza);

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("ID Pieza:");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Historial de precios de las piezas");

        cmbIDPieza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDPiezaItemStateChanged(evt);
            }
        });

        jTbHistorialPrecio.setForeground(new java.awt.Color(255, 255, 255));
        jTbHistorialPrecio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Precio Histórico", "ID pieza", "Características", "Precio", "Desde", "Hasta", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTbHistorialPrecio);

        btnSalir2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir2.setText("Salir");
        btnSalir2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });

        btnRegresar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar2.setText("Regresar");
        btnRegresar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar2ActionPerformed(evt);
            }
        });

        btnGenerar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGenerar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        btnGenerar3.setText("Generar PDF");
        btnGenerar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerar3ActionPerformed(evt);
            }
        });

        btnGenerar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGenerar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        btnGenerar4.setText("Generar EXCEL");
        btnGenerar4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerar4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(517, 517, 517)
                        .addComponent(jLabel16)
                        .addGap(361, 361, 361)
                        .addComponent(btnSalir2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbIDPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1190, 1190, 1190)
                        .addComponent(btnRegresar2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnGenerar3)
                                .addGap(11, 11, 11)
                                .addComponent(btnGenerar4))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnSalir2)))
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbIDPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerar3)
                    .addComponent(btnGenerar4))
                .addGap(144, 144, 144)
                .addComponent(btnRegresar2))
        );

        jTabbedPane3.addTab("Historial de Precios", jPanel2);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("ID Tipo de Pieza:");

        jLabel29.setForeground(new java.awt.Color(255, 246, 239));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Tipo de Pieza:");

        txtTipoPiezaNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoPiezaNuevoActionPerformed(evt);
            }
        });
        txtTipoPiezaNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoPiezaNuevoKeyTyped(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Nuevo Tipo de pieza");

        jTableTipoPieza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pieza", "Tipo de Pieza", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTipoPieza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTipoPiezaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableTipoPieza);

        btnAgregar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar2.setText("Agregar");
        btnAgregar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });

        btnModificar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar2.setText("Modificar");
        btnModificar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar2ActionPerformed(evt);
            }
        });

        btnLimpiar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar2.setText("Limpiar");
        btnLimpiar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });

        btnDesactivar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar2.setText("Desactivar");
        btnDesactivar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar2ActionPerformed(evt);
            }
        });

        btnSalir1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        btnRegresar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar1.setText("Regresar");
        btnRegresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });

        txtIDTipoPieza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "1", "2" }));
        txtIDTipoPieza.setEnabled(false);
        txtIDTipoPieza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtIDTipoPiezaItemStateChanged(evt);
            }
        });
        txtIDTipoPieza.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDTipoPiezaFocusLost(evt);
            }
        });
        txtIDTipoPieza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDTipoPiezaKeyTyped(evt);
            }
        });

        btnGenerar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGenerar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf (1).png"))); // NOI18N
        btnGenerar5.setText("Generar PDF");
        btnGenerar5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerar5ActionPerformed(evt);
            }
        });

        btnGenerar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGenerar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel (1).png"))); // NOI18N
        btnGenerar6.setText("Generar EXCEL");
        btnGenerar6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerar6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(17, 17, 17)
                            .addComponent(txtIDTipoPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtTipoPiezaNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addComponent(btnAgregar2)
                            .addGap(6, 6, 6)
                            .addComponent(btnModificar2)
                            .addGap(6, 6, 6)
                            .addComponent(btnLimpiar2)
                            .addGap(6, 6, 6)
                            .addComponent(btnDesactivar2))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(656, 656, 656)
                            .addComponent(jLabel31)
                            .addGap(345, 345, 345)
                            .addComponent(btnSalir1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnGenerar5)
                                    .addGap(11, 11, 11)
                                    .addComponent(btnGenerar6))
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir1)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtIDTipoPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtTipoPiezaNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar2)
                    .addComponent(btnModificar2)
                    .addComponent(btnLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnDesactivar2)))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerar5)
                    .addComponent(btnGenerar6))
                .addGap(32, 32, 32)
                .addComponent(btnRegresar1))
        );

        jTabbedPane3.addTab("Nuevo Tipo de pieza", jPanel1);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nombre:");

        tablaBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        tablaBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID  Pieza", "Tipo de Pieza", "Nombre", "Características", "Precio", "Stock", "Stock Máximo", "Stock Mínimo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBusquedaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablaBusqueda);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Búsqueda de Piezas");

        btnRegresar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar3.setText("Regresar");
        btnRegresar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar3ActionPerformed(evt);
            }
        });

        btnSalir3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir3.setText("Salir");
        btnSalir3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(630, 630, 630)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(388, 388, 388)
                        .addComponent(btnSalir3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(txtNombreBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1200, 1200, 1200)
                        .addComponent(btnRegresar3)))
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSalir3))
                .addGap(65, 65, 65)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197)
                .addComponent(btnRegresar3))
        );

        jTabbedPane3.addTab("Buscar", jPanel3);

        getContentPane().add(jTabbedPane3);
        jTabbedPane3.setBounds(0, 0, 1388, 796);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane3FocusLost
        createCmbIDPieza();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane3FocusLost

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        crearTableBusquedaPieza();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tablaBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBusquedaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaBusquedaMouseClicked

    private void txtIDTipoPiezaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDTipoPiezaKeyTyped

        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDTipoPiezaKeyTyped

    private void txtIDTipoPiezaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDTipoPiezaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDTipoPiezaFocusLost

    private void txtIDTipoPiezaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtIDTipoPiezaItemStateChanged
        if(txtIDTipoPieza.getSelectedIndex()==0){
            txtTipoPiezaNuevo.setText("");
            btnDesactivar2.setEnabled(false);

        }
        else{
            TipoPieza e1;
            e1=tipoPieza.findTipoPieza( txtIDTipoPieza.getSelectedIndex());
            txtTipoPiezaNuevo.setText(e1.getTipopieza());
            btnActivarDesactivar();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDTipoPiezaItemStateChanged

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        //FrmMenu m = new FrmMenu();
        //m.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnDesactivar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar2ActionPerformed

    }//GEN-LAST:event_btnDesactivar2ActionPerformed
public boolean DesactivarTipoPieza(){
            TipoPieza temp;
        temp = tipoPieza.findTipoPieza(txtIDTipoPieza.getSelectedIndex());
        if(temp.getEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Tipo de pieza Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Tipo de pieza Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        try {
            tipoPieza.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTableTipoPieza();
        btnActivarDesactivar();
        LimpiarNuevoTipoPieza();
        createCmbTipoPieza();
        btnDesactivar2.setEnabled(false);
        btnAgregar2.setEnabled(true);
        btnModificar2.setEnabled(false);
return true;
}
    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        LimpiarNuevoTipoPieza();
        // txtTipoPiezaNuevo.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed
        ModificarTipoPieza();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificar2ActionPerformed
public boolean ModificarTipoPieza(){
    if(txtIDTipoPieza.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Tipo de pieza no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
            if("".equals(txtTipoPiezaNuevo.getText().trim())){
                JOptionPane.showMessageDialog(null, "El campo de de tipo de pieza esta vacío","ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if(txtTipoPiezaNuevo.getText().length()<3){
                JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el Tipo de pieza es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            else{

            }
            if(txtTipoPiezaNuevo.getText().length()>25){
                JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Tipo de Pieza es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            else{

            }
            if (!ValidacionNombreMayusculaYDemasMinus(txtTipoPiezaNuevo.getText())){
                JOptionPane.showMessageDialog(null,"El Tipo de Pieza debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
                txtTipoPiezaNuevo.requestFocus();
                return false;
            }else{

            }
            Pattern pat = Pattern.compile("(?i)(.*aaa.*|.*bbb.*|.*ccc.*|.*ddd.*|.*eee.*|.*fff.*|.*ggg.*|.*hhh.*|.*iii.*"
                + "                         |.*jjj.*|.*kkk.*|.*lll.*|.*mmm.*|.*nnn.*|.*ooo.*|.*ppp.*|.*qqq.*|.*rrr.*|.*sss.*|.*ttt.*|.*uuu.*"
                + "                         |.*vvv.*|.*www.*|.*xxx.*|.*yyy.*|.*zzz.*)");

            Matcher mat = pat.matcher(txtTipoPiezaNuevo.getText());

            if(mat.matches()){
                JOptionPane.showMessageDialog(null, "No se Admite en el Tipo de Pieza la misma letra 3 veces en forma consecutiva","ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if("".equals(txtTipoPiezaNuevo.getText())){
                JOptionPane.showMessageDialog(null, "Tipo de Pieza no puede ir vacio", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<tipoPieza.findTipoPiezaEntities().size();i++){
                    //System.out.println(i);
                    if(txtTipoPiezaNuevo.getText().toLowerCase().equals(tipoPieza.findTipoPieza(i+1).getTipopieza().toLowerCase())){
                        JOptionPane.showMessageDialog(null, "Ya existe este tipo de pieza registrada en el sistema","Error", JOptionPane.PLAIN_MESSAGE);
                        flag=true;
                        return false;
                    } else {
                    }
                }
                if(flag){
                    return false;
                }
                else{
                    TipoPieza e1;
                    e1=tipoPieza.findTipoPieza(txtIDTipoPieza.getSelectedIndex());
                    e1.setTipopieza(txtTipoPiezaNuevo.getText());
                    try {
                        tipoPieza.edit(e1);
                    } catch (Exception ex) {
                        Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
                    JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
                    txtIDTipoPieza.setSelectedIndex(1);
                    txtIDTipoPieza.setSelectedIndex(0);
                    createTableTipoPieza();
                    createComboBox3();
                    createCmbTipoPieza();
                    LimpiarNuevoTipoPieza();
                    btnAgregar2.setEnabled(true);
                    btnModificar2.setEnabled(false);
                    btnDesactivar2.setEnabled(false);

                }
            }
        }
    return true;
}
    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed

        AgregarTipoPieza();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregar2ActionPerformed
public boolean AgregarTipoPieza(){
    if(txtIDTipoPieza.getSelectedIndex()!=0){
            JOptionPane.showMessageDialog(null, "El ID Tipo de Pieza siempre debe estar en el ITEM de Nuevo para agregar un nuevo Tipo de Pieza","Error!", JOptionPane.ERROR_MESSAGE);
            txtIDTipoPieza.setSelectedIndex(0);
            return false;
        }
        else{

        }
        if("".equals(txtTipoPiezaNuevo.getText().trim())){
            JOptionPane.showMessageDialog(null, "El campo de de tipo de pieza esta vacío","ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(txtTipoPiezaNuevo.getText().length()<3){
            JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el Tipo de pieza es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(txtTipoPiezaNuevo.getText().length()>25){
            JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Tipo de Pieza es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if (!ValidacionNombreMayusculaYDemasMinus(txtTipoPiezaNuevo.getText())){
            JOptionPane.showMessageDialog(null,"El Tipo de Pieza debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoPiezaNuevo.requestFocus();
            return false;
        }else{

        }
        Pattern pat = Pattern.compile("(?i)(.*aaa.*|.*bbb.*|.*ccc.*|.*ddd.*|.*eee.*|.*fff.*|.*ggg.*|.*hhh.*|.*iii.*"
            + "                         |.*jjj.*|.*kkk.*|.*lll.*|.*mmm.*|.*nnn.*|.*ooo.*|.*ppp.*|.*qqq.*|.*rrr.*|.*sss.*|.*ttt.*|.*uuu.*"
            + "                         |.*vvv.*|.*www.*|.*xxx.*|.*yyy.*|.*zzz.*)");

        Matcher mat = pat.matcher(txtTipoPiezaNuevo.getText());

        if(mat.matches()){
            JOptionPane.showMessageDialog(null, "No se Admite en el Tipo de Pieza la misma letra 3 veces en forma consecutiva","ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        else{
            int i;
            boolean flag=false;
            for(i=0;i<tipoPieza.findTipoPiezaEntities().size();i++){
                //System.out.println(i);
                if(txtTipoPiezaNuevo.getText().toLowerCase().equals(tipoPieza.findTipoPieza(i+1).getTipopieza().toLowerCase())){
                    JOptionPane.showMessageDialog(null, "Ya existe este tipo de pieza registrada en el sistema","ERROR", JOptionPane.ERROR_MESSAGE);
                    flag=true;
                    return false;
                } else {
                }
            }
            if(flag){
                return false;
            }
            else{
                TipoPieza e1 = new TipoPieza();
                e1.setEstado(true);
                e1.setTipopieza(txtTipoPiezaNuevo.getText());
                try {
                    tipoPieza.create(e1);
                } catch (Exception ex) {
                    Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
                }
                Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
                JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
                //           txtIDTipoPieza.setSelectedIndex(1);
                txtIDTipoPieza.setSelectedIndex(0);
                
                //FrmPieza f= new FrmPieza();
                //f.show();
                //f.jTabbedPane3.setSelectedIndex(2);
                //this.hide();
                LimpiarNuevoTipoPieza();
                createCmbTipoPieza();
                btnAgregar2.setEnabled(true);
                btnModificar2.setEnabled(false);

            }
        }
        return true;
}

    private void jTableTipoPiezaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTipoPiezaMouseClicked
        btnAgregar2.setEnabled(false);
        btnModificar2.setEnabled(true);
        btnDesactivar2.setEnabled(true);
        int column=0;
        int fila = jTableTipoPieza.getSelectedRow();
        if (fila > -1){
            txtIDTipoPieza.setSelectedIndex(Integer.parseInt(jTableTipoPieza.getModel().getValueAt(fila, column).toString()));
            txtTipoPiezaNuevo.setText(String.valueOf(jTableTipoPieza.getValueAt(fila, ++column)));
            btnActivarDesactivar();
        }
    }//GEN-LAST:event_jTableTipoPiezaMouseClicked

    private void txtTipoPiezaNuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoPiezaNuevoKeyTyped
        char c = evt.getKeyChar();
                if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z'&& c != 'Ñ' && c != 'ñ' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú')&& (c!=KeyEvent.VK_SPACE) ){

            evt.consume();

        }
              
        if (txtTipoPiezaNuevo.getText().length() >= 25){
        
        evt.consume();
        
        }
    }//GEN-LAST:event_txtTipoPiezaNuevoKeyTyped

    private void btnRegresar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar2ActionPerformed
        //FrmMenu m = new FrmMenu();
        //m.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresar2ActionPerformed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void cmbIDPiezaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDPiezaItemStateChanged
        crearTbHistorialPrecio();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDPiezaItemStateChanged

    private void jFtxtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFtxtPrecioKeyPressed

    }//GEN-LAST:event_jFtxtPrecioKeyPressed

    private void jCmbTipoPiezaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCmbTipoPiezaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCmbTipoPiezaItemStateChanged

    private void txtIDPiezaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtIDPiezaItemStateChanged
        if(txtIDPieza.getSelectedIndex()==0){
            //txtIDPieza.setSelectedIndex(0);
            //            jCmbTipoPieza.setSelectedIndex(0);
            jtxtNombre.setText("");
            jTxtAreaCaracteristica.setText("");
            jFtxtStock.setText("");
            jFtxtStockMaximo.setText("");
            jFtxtStockMinimo.setText("");
            jFtxtPrecio.setText("");

        }
        else{
            Pieza e1;
            e1=piezaDao.findPieza( txtIDPieza.getSelectedIndex());
            jCmbTipoPieza.setSelectedIndex(e1.getId_Tipo_Pieza());
            jTxtAreaCaracteristica.setText(e1.getCarateristica_Pieza());
            jFtxtStock.setText(Integer.toString(e1.getStock()));
            jFtxtStockMaximo.setText(Integer.toString(e1.getStock_Maximo()));
            jFtxtStockMinimo.setText(Integer.toString(e1.getStock_Minimo()));

            DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
            separadoresPersonalizados.setDecimalSeparator('.');
            DecimalFormat formato1 = new DecimalFormat("#.00",separadoresPersonalizados);
            List<HistoricoPrecioPieza> h1 = historicoPieza.findHistoricoPrecioPiezaEntities();
            for(HistoricoPrecioPieza p2 : h1){
                if(p2.getIdPieza() == e1.getId_Pieza()){
                    if(p2.getFechaFinal()==null){
                        jFtxtPrecio.setText(formato1.format(p2.getPrecio()));
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
            btnModificar3.setEnabled(true);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPiezaItemStateChanged

    private void btnDesactivar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivar3ActionPerformed


    }//GEN-LAST:event_btnDesactivar3ActionPerformed
public boolean DesactivarPieza(){
            Pieza temp;
        temp = piezaDao.findPieza(txtIDPieza.getSelectedIndex());
        //temp = piezaDao.findPieza(txtIDPieza.getSelectedIndex()+1);
        //JOptionPane.showMessageDialog(null, temp.isEstado());
        if(temp.isEstado()){
            temp.setEstado(false);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Desactivar.png"));
            JOptionPane.showMessageDialog(null,"Pieza Desactivado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        else{
            temp.setEstado(true);
            Icon icono = new ImageIcon(getClass().getResource("/Img/Activar.png"));
            JOptionPane.showMessageDialog(null,"Pieza Activado exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        }
        try {
            piezaDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTablaPieza();
        btnActivarDesactivarPieza();
        createCmbTipoPieza();
        btnAgregar3.setEnabled(true);
        btnModificar3.setEnabled(false);
        btnDesactivar3.setEnabled(false);
        return true;
}
    private void btnLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar3ActionPerformed
        LimpiarPieza();
    }//GEN-LAST:event_btnLimpiar3ActionPerformed

    private void btnModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar3ActionPerformed
        ModificarPieza();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificar3ActionPerformed
public boolean ModificarPieza(){
    
        if(jCmbTipoPieza.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún Tipo de pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
               if(jCmbTipoPieza.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún Tipo de pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(jtxtNombre.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "El campo de Nombre de la Pieza esta vacío","ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(jtxtNombre.getText().length()<3){
            JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el Nombre de la Pieza es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(jtxtNombre.getText().length()>25){
            JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Nombre de la Pieza es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if (!ValidacionNombreMayusculaYDemasMinus(jtxtNombre.getText())){
            JOptionPane.showMessageDialog(null,"El Nombre de la Pieza debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            jtxtNombre.requestFocus();
            return false;
        }
        else{
        }
        //Validacion del campo Nombre
        Pattern pat = Pattern.compile("(?i)(.*aaa.*|.*bbb.*|.*ccc.*|.*ddd.*|.*eee.*|.*fff.*|.*ggg.*|.*hhh.*|.*iii.*"
            + "                         |.*jjj.*|.*kkk.*|.*lll.*|.*mmm.*|.*nnn.*|.*ooo.*|.*ppp.*|.*qqq.*|.*rrr.*|.*sss.*|.*ttt.*|.*uuu.*"
            + "                         |.*vvv.*|.*www.*|.*xxx.*|.*yyy.*|.*zzz.*)");

        Matcher mat = pat.matcher(jtxtNombre.getText());
        if(mat.matches()){
            JOptionPane.showMessageDialog(null, "No se Admite en el nombre de la Pieza la misma letra 3 veces en forma consecutiva","ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(jTxtAreaCaracteristica.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese las Características de la pieza","ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(jTxtAreaCaracteristica.getText().length()<3){
            JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para la Característica de la Pieza es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(jTxtAreaCaracteristica.getText().length()>50){
            JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para la Característica de la Pieza es de 50 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        Matcher matt = pat.matcher(jTxtAreaCaracteristica.getText());
        if(matt.matches()){
            JOptionPane.showMessageDialog(null, "No se Admite en la Características de la Pieza la misma letra 3 veces en forma consecutiva","ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if (!ValidacionCaracteristicas(jTxtAreaCaracteristica.getText())){
            JOptionPane.showMessageDialog(null,"La Características solo puede contener números, letras y los siguiente signos(&:|#\";.,-)","Error!", JOptionPane.ERROR_MESSAGE);
            jTxtAreaCaracteristica.requestFocus();
            return false;
        }
        else{
        }
        if("".equals(jFtxtStock.getText().trim())){
            JOptionPane.showMessageDialog(null, "El campo de Stock de la Pieza esta vacío","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if((Integer.parseInt(jFtxtStock.getText())==0)){
               JOptionPane.showMessageDialog(null, "El Stock no puedo ser cero","Error!",JOptionPane.ERROR_MESSAGE);
               return false;
            }
           else{        
           }
        if (!ValidacionRangoStockPieza(jFtxtStock.getText())){
            JOptionPane.showMessageDialog(null,"El rango de Stock de Piezas solo puede estar entre 1-400","Error!", JOptionPane.ERROR_MESSAGE);
            jFtxtStock.requestFocus();
            return false;
        }else{

        }
        if("".equals(jFtxtPrecio.getText().trim())){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el precio de la pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if (!ValidacionRangoPrecioPieza(jFtxtPrecio.getText())){
            JOptionPane.showMessageDialog(null,"El rango de Precio de la Pieza solo puede estar entre 20.00-40,000.00","Error!", JOptionPane.ERROR_MESSAGE);
            jFtxtPrecio.requestFocus();
            return false;
        }
        else{
        }
        if("".equals(jFtxtStockMaximo.getText().trim())){
            JOptionPane.showMessageDialog(null,"Por favor, ingrese la cantidad Máxima que puede haber de esta pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if((Integer.parseInt(jFtxtStockMaximo.getText())==0)){
               JOptionPane.showMessageDialog(null, "El Stock Máximo no puedo ser cero","Error!",JOptionPane.ERROR_MESSAGE);
                return false;
            }
           else{        
           }
        if (!ValidacionRangoStockPieza(jFtxtStockMaximo.getText())){
            JOptionPane.showMessageDialog(null,"El rango de Stock Máximo de Piezas solo puede estar entre 1-400","Error!", JOptionPane.ERROR_MESSAGE);
            //jFtxtStockMaximo.requestFocus();
            return false;
        }else{

        }
        if(Double.parseDouble(jFtxtStock.getText())>Integer.parseInt(jFtxtStockMaximo.getText())){
            JOptionPane.showMessageDialog(null, "El Stock no puede ser mayor al Stock Máximo","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if("".equals(jFtxtStockMinimo.getText().trim())){
            JOptionPane.showMessageDialog(null,"Por favor, ingrese el Stock Mínimo de la Pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if((Integer.parseInt(jFtxtStockMinimo.getText())<1)){
               JOptionPane.showMessageDialog(null, "El Stock Mínimo actual no puedo ser menor que uno","Error!",JOptionPane.ERROR_MESSAGE);
                return false;
            }
           else{        
           }
        if(Integer.parseInt(jFtxtStockMinimo.getText()) >= Integer.parseInt(jFtxtStockMaximo.getText())){
            JOptionPane.showMessageDialog(null, "El Stock Mínimo no puede ser igual o mayor al Stock Máximo","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(Double.parseDouble(jFtxtStock.getText())<Integer.parseInt(jFtxtStockMinimo.getText())){
            JOptionPane.showMessageDialog(null, "El Stock no puede ser menor al Stock Mínimo ","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }

        Pieza temp = new Pieza();
        temp.setId_Pieza(txtIDPieza.getSelectedIndex());
        temp.setNombre(jtxtNombre.getText());
        temp.setCarateristica_Pieza(jTxtAreaCaracteristica.getText());
        temp.setId_Tipo_Pieza(jCmbTipoPieza.getSelectedIndex());
        temp.setStock(Integer.parseInt(jFtxtStock.getText()));
        temp.setStock_Maximo(Integer.parseInt(jFtxtStockMaximo.getText()));
        temp.setStock_Minimo(Integer.parseInt(jFtxtStockMinimo.getText()));
        temp.setEstado(true);

        try {
            piezaDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<HistoricoPrecioPieza> t1 = historicoPieza.findHistoricoPrecioPiezaEntities();
        HistoricoPrecioPieza temp2 = new HistoricoPrecioPieza();

        for(HistoricoPrecioPieza t : t1){
            if(t.getIdPieza() == txtIDPieza.getSelectedIndex()){
                if(t.getFechaFinal()==null){
                    temp2 = t;

                }

            }
        }

        if(temp2.getPrecio()!=(Double.parseDouble(jFtxtPrecio.getText().replace(",", "").replace(",", "").replace("%.2f%n", "")))){
            //temp2.setEstado(true);
                Calendar fecha = new GregorianCalendar();
                String fecha1;
                String aux1,aux2,aux3;
                aux1 = Integer.toString(fecha.get(Calendar.YEAR));
                if(fecha.get(Calendar.DAY_OF_MONTH)==1){
                    aux2=(fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH))) : Integer.toString(fecha.get(Calendar.MONTH));
                    aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)-1) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)-1);
                }
                else{
                aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH)+1);
                aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)-1) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)-1);
                }
            fecha1 = aux1+aux2+aux3;
            temp2.setFechaFinal(fecha1);
            temp2.setEstado(false);
            //double auxsueldo=(Double.parseDouble(jFtxtPrecio.getText().replace(",", "").replace(",", "").trim()));
            //double aux=Double.parseDouble(jFtxtPrecio.getText().trim());
            //temp2.setPrecio(auxsueldo);
            temp2.setIdPieza(txtIDPieza.getSelectedIndex());
            try {
                historicoPieza.edit(temp2);
            } catch (Exception ex) {
                Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
            }
            aux1 = Integer.toString(fecha.get(Calendar.YEAR));
            aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH)+1);
            aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
            fecha1 = aux1+aux2+aux3;
            
            HistoricoPrecioPieza temp3 = new HistoricoPrecioPieza();
            temp3.setFechaInicial(fecha1);
            temp3.setIdPieza(txtIDPieza.getSelectedIndex());
            double auxsueldo1=(Double.parseDouble(jFtxtPrecio.getText().replace(",", "").replace(",", "").trim()));
            temp3.setPrecio(auxsueldo1);
            temp3.setEstado(true);
            try {
                historicoPieza.create(temp3);
                //txtIDPieza.setSelectedIndex(1);
            } catch (Exception ex) {
                Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        txtIDPieza.setSelectedIndex(0);
        createTablaPieza();
        createCmbIDPieza();

        Icon icono = new ImageIcon(getClass().getResource("/Img/modificar.png"));
        JOptionPane.showMessageDialog(null,"Datos Modificados exitosamente","Modificado",JOptionPane.PLAIN_MESSAGE, icono);
        btnAgregar3.setEnabled(true);
        btnModificar3.setEnabled(false);
        btnDesactivar3.setEnabled(false);
        LimpiarPieza();
        ///new FrmPieza().show();
        //this.hide();
        return true;
}
    private void btnAgregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar3ActionPerformed
        AgregarPieza();

    }//GEN-LAST:event_btnAgregar3ActionPerformed

    public boolean AgregarPieza(){
        if(txtIDPieza.getSelectedIndex()==0){

        }
        else{
            txtIDPieza.setSelectedIndex(0);
            JOptionPane.showMessageDialog(null, "El ID Pieza siempre debe estar en el ITEM de Nuevo para agregar una Pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(jCmbTipoPieza.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún Tipo de pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(jtxtNombre.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "El campo de Nombre de la Pieza esta vacío","ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(jtxtNombre.getText().length()<3){
            JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el Nombre de la Pieza es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(jtxtNombre.getText().length()>25){
            JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Nombre de la Pieza es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if (!ValidacionNombreMayusculaYDemasMinus(jtxtNombre.getText())){
            JOptionPane.showMessageDialog(null,"El Nombre de la Pieza debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            //jtxtNombre.requestFocus();
            return false;
        }
        else{
        }
        //Validacion del campo Nombre
        Pattern pat = Pattern.compile("(?i)(.*aaa.*|.*bbb.*|.*ccc.*|.*ddd.*|.*eee.*|.*fff.*|.*ggg.*|.*hhh.*|.*iii.*"
            + "                         |.*jjj.*|.*kkk.*|.*lll.*|.*mmm.*|.*nnn.*|.*ooo.*|.*ppp.*|.*qqq.*|.*rrr.*|.*sss.*|.*ttt.*|.*uuu.*"
            + "                         |.*vvv.*|.*www.*|.*xxx.*|.*yyy.*|.*zzz.*)");

        Matcher mat = pat.matcher(jtxtNombre.getText());
        if(mat.matches()){
            JOptionPane.showMessageDialog(null, "No se Admite en el nombre de la Pieza la misma letra 3 veces en forma consecutiva","ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(jTxtAreaCaracteristica.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese las Características de la pieza","ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(jTxtAreaCaracteristica.getText().length()<3){
            JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para la Característica de la Pieza es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if(jTxtAreaCaracteristica.getText().length()>50){
            JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para la Característica de la Pieza es de 50 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        Matcher matt = pat.matcher(jTxtAreaCaracteristica.getText());
        if(matt.matches()){
            JOptionPane.showMessageDialog(null, "No se Admite en la Características de la Pieza la misma letra 3 veces en forma consecutiva","ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if (!ValidacionCaracteristicas(jTxtAreaCaracteristica.getText())){
            JOptionPane.showMessageDialog(null,"La Características solo puede contener números, letras y los siguiente signos(&:|#\";.,-)","Error!", JOptionPane.ERROR_MESSAGE);
            //jTxtAreaCaracteristica.requestFocus();
            return false;
        }
        else{
        }
        if("".equals(jFtxtStock.getText().trim())){
            JOptionPane.showMessageDialog(null, "El campo de Stock de la Pieza esta vacío","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if((Integer.parseInt(jFtxtStock.getText())==0)){
               JOptionPane.showMessageDialog(null, "El Stock no puedo ser cero","Error!",JOptionPane.ERROR_MESSAGE);
                return false;
            }
           else{        
           }
        if (!ValidacionRangoStockPieza(jFtxtStock.getText())){
            JOptionPane.showMessageDialog(null,"El rango de Stock de Piezas solo puede estar entre 1-400","Error!", JOptionPane.ERROR_MESSAGE);
            jFtxtStock.requestFocus();
            return false;
        }else{

        }
        if("".equals(jFtxtPrecio.getText().trim())){
           JOptionPane.showMessageDialog(null, "Por favor, ingrese el precio de la pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{

        }
        if (!ValidacionRangoPrecioPieza(jFtxtPrecio.getText())){
            JOptionPane.showMessageDialog(null,"El rango de Precio de la Pieza solo puede estar entre 20.00-40,000.00","Error!", JOptionPane.ERROR_MESSAGE);
            jFtxtPrecio.requestFocus();
            return false;
        }
        else{
        }
        if("".equals(jFtxtStockMaximo.getText().trim())){
            JOptionPane.showMessageDialog(null,"Por favor, ingrese la cantidad Máxima que puede haber de esta pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if((Integer.parseInt(jFtxtStockMaximo.getText())==0)){
               JOptionPane.showMessageDialog(null, "El Stock Máximo no puedo ser cero","Error!",JOptionPane.ERROR_MESSAGE);
                return false;
            }
           else{        
           }
        if (!ValidacionRangoStockPieza(jFtxtStockMaximo.getText())){
            JOptionPane.showMessageDialog(null,"El rango de Stock Máximo de Piezas solo puede estar entre 1-400","Error!", JOptionPane.ERROR_MESSAGE);
            jFtxtStockMaximo.requestFocus();
            return false;
        }else{

        }
        if(Double.parseDouble(jFtxtStock.getText())>Integer.parseInt(jFtxtStockMaximo.getText())){
            JOptionPane.showMessageDialog(null, "El Stock no puede ser mayor al Stock Máximo","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if("".equals(jFtxtStockMinimo.getText().trim())){
            JOptionPane.showMessageDialog(null,"Por favor, ingrese el Stock Mínimo de la Pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if((Integer.parseInt(jFtxtStockMinimo.getText())<1)){
               JOptionPane.showMessageDialog(null, "El Stock Mínimo actual no puedo ser menor que uno","Error!",JOptionPane.ERROR_MESSAGE);
                return false;
            }
           else{        
           }
        if(Integer.parseInt(jFtxtStockMinimo.getText()) >= Integer.parseInt(jFtxtStockMaximo.getText())){
            JOptionPane.showMessageDialog(null, "El Stock Mínimo no puede ser igual o mayor al Stock Máximo","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }
        if(Double.parseDouble(jFtxtStock.getText())<Integer.parseInt(jFtxtStockMinimo.getText())){
            JOptionPane.showMessageDialog(null, "El Stock no puede ser menor al Stock Mínimo ","Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else{
        }

        Pieza temp = new Pieza();
        temp.setEstado(true);
        temp.setNombre(jtxtNombre.getText());
        temp.setCarateristica_Pieza(jTxtAreaCaracteristica.getText());
        temp.setId_Tipo_Pieza(jCmbTipoPieza.getSelectedIndex());
        temp.setStock(Integer.parseInt(jFtxtStock.getText()));
        temp.setStock_Maximo(Integer.parseInt(jFtxtStockMaximo.getText()));
        temp.setStock_Minimo(Integer.parseInt(jFtxtStockMinimo.getText()));

        try {
            piezaDao.create(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }

        HistoricoPrecioPieza temp2 = new HistoricoPrecioPieza();
        temp2.setEstado(true);
        Calendar fecha = new GregorianCalendar();
        String fecha1;
        String aux1,aux2,aux3;
        aux1 = Integer.toString(fecha.get(Calendar.YEAR));
        aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+(Integer.toString(fecha.get(Calendar.MONTH)+1)) : Integer.toString(fecha.get(Calendar.MONTH));
        aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
        fecha1 = aux1+aux2+aux3;
        temp2.setFechaInicial(fecha1);
        double auxsueldo=(Double.parseDouble(jFtxtPrecio.getText().replace(",", "").replace(",", "").trim()));
        //double aux=Float.parseFloat(jFtxtPrecio.getText().trim());
        temp2.setPrecio(auxsueldo);
        temp2.setIdPieza(piezaDao.getPiezaCount());
        try {
            historicoPieza.create(temp2);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }

        //           txtIDPieza.setSelectedIndex(1);
        Icon icono = new ImageIcon(getClass().getResource("/Img/agregar.png"));
        JOptionPane.showMessageDialog(null,"Datos Guardados exitosamente","Guardado",JOptionPane.PLAIN_MESSAGE, icono);
        txtIDPieza.setSelectedIndex(0);
        createTablaPieza();
        createCmbIDPieza();
        LimpiarPieza();
        btnAgregar3.setEnabled(true);
        btnModificar3.setEnabled(false);
        btnDesactivar3.setEnabled(false);

        //new FrmPieza().show();
        //this.hide();
        return true;
    }
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        //FrmMenu m = new FrmMenu();
       // m.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jTablePiezaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePiezaMouseClicked
        btnAgregar3.setEnabled(false);
        btnModificar3.setEnabled(true);
        btnDesactivar3.setEnabled(true);
        int column=0;
        int fila = jTablePieza.getSelectedRow();
        if (fila > -1){
            txtIDPieza.setSelectedIndex(Integer.parseInt(jTablePieza.getModel().getValueAt(fila, column).toString()));
            Pieza temp = piezaDao.findPieza(Integer.parseInt(jTablePieza.getModel().getValueAt(fila, column).toString()));
            jCmbTipoPieza.setSelectedIndex(temp.getId_Tipo_Pieza());
            jtxtNombre.setText(temp.getNombre());
            jTxtAreaCaracteristica.setText(temp.getCarateristica_Pieza());
            List<HistoricoPrecioPieza> tempc = historicoPieza.findHistoricoPrecioPiezaEntities();
            for(HistoricoPrecioPieza hp: tempc){
                if(hp.getIdPieza()==temp.getId_Pieza()){
            //txtPrecio.setText(String.valueOf(tbAgregarVehiculo.getValueAt(fila, 11)));
            double precio=hp.getPrecio();
            jFtxtPrecio.setText(String.format("%,.2f",precio));
                }
            }
            jFtxtStock.setText(String.valueOf(temp.getStock()));
            jFtxtStockMaximo.setText(String.valueOf(temp.getStock_Maximo()));
            jFtxtStockMinimo.setText(String.valueOf(temp.getStock_Minimo()));

            btnActivarDesactivarPieza();
            
        }
    }//GEN-LAST:event_jTablePiezaMouseClicked

    private void btnRegresar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar3ActionPerformed
         //FrmMenu m = new FrmMenu();
        //m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresar3ActionPerformed

    private void btnSalir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir3ActionPerformed

    private void jtxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNombreKeyTyped
                char c = evt.getKeyChar();
        if((c < 'A' || c > 'Z') && (c < 'a' || c > 'z' && c != 'Ñ' && c != 'ñ' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú')&& (c!=KeyEvent.VK_SPACE) ){

            evt.consume();

        }
              
        if (jtxtNombre.getText().length() >= 15){
        
        evt.consume();
        
        }
    }//GEN-LAST:event_jtxtNombreKeyTyped

    private void jTxtAreaCaracteristicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtAreaCaracteristicaKeyTyped
        char c = evt.getKeyChar();
        if((c < 'a' || c > 'z') && (c != '.' && c != '-' && c != ',' && c != ';' && c != '"' && c != '#' && c != '|' && c != ':' && c != '&')&&(c < '0' || c > '9')&& (c < 'A' || c > 'Z'&& c != 'Ñ' && c != 'ñ' && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú')&& (c!=KeyEvent.VK_SPACE)){

            evt.consume();

        }
              
        if (jtxtNombre.getText().length() >= 50){
        
        evt.consume();
        
        }
    }//GEN-LAST:event_jTxtAreaCaracteristicaKeyTyped

    private void jFtxtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFtxtStockKeyTyped
        char c = evt.getKeyChar();
        if((c < '0' || c > '9')){

            evt.consume();

        }
        if (jFtxtStock.getText().length() >= 5){
        
        evt.consume();
        }

    }//GEN-LAST:event_jFtxtStockKeyTyped

    private void jFtxtStockMaximoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFtxtStockMaximoKeyTyped
        char c = evt.getKeyChar();
        if((c < '0' || c > '9')){

            evt.consume();

        }
        if (jFtxtStockMaximo.getText().length() >= 5){
        
        evt.consume();
        }
    }//GEN-LAST:event_jFtxtStockMaximoKeyTyped

    private void jFtxtStockMinimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFtxtStockMinimoKeyTyped
                char c = evt.getKeyChar();
        if((c < '0' || c > '9')){

            evt.consume();

        }
        if (jFtxtStockMinimo.getText().length() >= 5){
        
        evt.consume();
        }
    }//GEN-LAST:event_jFtxtStockMinimoKeyTyped

    private void txtTipoPiezaNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoPiezaNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoPiezaNuevoActionPerformed

    private void jFtxtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFtxtPrecioKeyTyped
        
        char c = evt.getKeyChar();


        if((c < '0' || c > '9') && (c != '.' && c != ',')&& (c!=KeyEvent.VK_BACKSPACE)){

            evt.consume();

        }
              
        if (jFtxtPrecio.getText().length() >= 12){
        
        evt.consume();
        
        }
    }//GEN-LAST:event_jFtxtPrecioKeyTyped

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
                    HashMap param = new HashMap();
            param.put("Empleado",labelempleado.getText());
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        } catch (SQLException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            JasperDesign reporteEmpleados = null;
        try {
            reporteEmpleados = JRXmlLoader.load("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reportePiezas.jrxml");
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            String query = "select SYSDATE() as 'HoraSistema', pieza.ID_pieza as 'ID Pieza', tipo_pieza.Tipo_pieza as 'Tipo de Pieza',pieza.nombre as 'Nombre', pieza.Caracteristicas_pieza as 'Características', FORMAT(historico_precio_pieza.precio,2,'en_US')  as 'Precio', pieza.Stock as 'Stock', pieza.Stock_maximo as 'Stock máximo', pieza.Stock_minimo as 'Stock minimo', If(pieza.estado=true, 'Activo', 'Inactivo') as 'Estado' from pieza, tipo_pieza, historico_precio_pieza\n" +
"where pieza.ID_tipo_pieza=tipo_pieza.ID_tipo_pieza and pieza.ID_pieza=historico_precio_pieza.ID_pieza order by pieza.ID_pieza;";
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(query);
            JasperReport jreport = null;
        try {
            jreport = JasperCompileManager.compileReport(reporteEmpleados);
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            JasperPrint print = null;
        try {
            print = JasperFillManager.fillReport(jreport,param,con);
        } catch (JRException ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
            JasperViewer.viewReport(print, false);
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnGenerar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerar2ActionPerformed
        reportePiezas();
    }//GEN-LAST:event_btnGenerar2ActionPerformed
public void reportePiezas(){
     try{
   Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        } catch (SQLException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JasperReport reporte = null;
        try {
            reporte = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reportePiezas.jrxml");
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        HashMap param = new HashMap();
        param.put("Empleado", labelempleado.getText());
        JasperPrint print = null;
        try {
            print = JasperFillManager.fillReport(reporte, param,con);
            //JasperViewer.viewReport(print);
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            JRXlsxExporter exporter = new JRXlsxExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reportePiezas.xlsx");

        try {
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reportePiezas.xlsx");
        
        try {
            p.start();
        }catch (IOException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    private void btnGenerar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerar3ActionPerformed
                            HashMap param = new HashMap();
            param.put("Empleado",labelempleado.getText());
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        } catch (SQLException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            JasperDesign reporteEmpleados = null;
        try {
            reporteEmpleados = JRXmlLoader.load("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteHistorialPiezas.jrxml");
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            String query = "select SYSDATE() as 'HoraSistema', historico_precio_pieza.id_precio_historico as 'ID Pieza Histórico', tipo_pieza.Tipo_pieza as 'Tipo Pieza' ,pieza.nombre as 'Nombre', pieza.Caracteristicas_pieza as 'Características', FORMAT(historico_precio_pieza.precio,2,'en_US') as 'Precio', concat_ws('/', substring(historico_precio_pieza.fecha_inicial from 9 for 10),substring(historico_precio_pieza.fecha_inicial from 6 for 2), substring(historico_precio_pieza.fecha_inicial from 1 for 4)) as 'Fecha Inicial', \n" +
                "If(historico_precio_pieza.fecha_final=null, '', concat_ws('/', substring(historico_precio_pieza.fecha_final from 9 for 10),substring(historico_precio_pieza.fecha_final from 6 for 2), substring(historico_precio_pieza.fecha_final from 1 for 4))) as 'Fecha Final' , If(historico_precio_pieza.estado=true, 'Activo', 'Inactivo') as 'Estado'\n" +
                    "from historico_precio_pieza, pieza, tipo_pieza where historico_precio_pieza.ID_pieza=pieza.ID_pieza and pieza.ID_tipo_pieza=tipo_pieza.ID_tipo_pieza order by historico_precio_pieza.id_precio_historico;";
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(query);
            JasperReport jreport = null;
        try {
            jreport = JasperCompileManager.compileReport(reporteEmpleados);
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            JasperPrint print = null;
        try {
            print = JasperFillManager.fillReport(jreport,param,con);
        } catch (JRException ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
            JasperViewer.viewReport(print, false);
    }//GEN-LAST:event_btnGenerar3ActionPerformed

    private void btnGenerar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerar4ActionPerformed
        reporteHistorialPrecioPieza();
    }//GEN-LAST:event_btnGenerar4ActionPerformed
public void reporteHistorialPrecioPieza(){
     try{
   Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        } catch (SQLException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JasperReport reporte = null;
        try {
            reporte = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteHistorialPiezas.jrxml");
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        HashMap param = new HashMap();
        param.put("Empleado", labelempleado.getText());
        JasperPrint print = null;
        try {
            print = JasperFillManager.fillReport(reporte, param,con);
            //JasperViewer.viewReport(print);
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            JRXlsxExporter exporter = new JRXlsxExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteHistorialPiezas.xlsx");

        try {
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteHistorialPiezas.xlsx");
        
        try {
            p.start();
        }catch (IOException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    private void btnGenerar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerar5ActionPerformed
                                    HashMap param = new HashMap();
            param.put("Empleado",labelempleado.getText());
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        } catch (SQLException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            JasperDesign reporteEmpleados = null;
        try {
            reporteEmpleados = JRXmlLoader.load("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reportTipoPieza.jrxml");
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            String query = "select SYSDATE() as 'HoraSistema', tipo_pieza.ID_tipo_pieza as 'ID Tipo Pieza', tipo_pieza.Tipo_pieza as 'Tipo de Pieza', If(tipo_pieza.estado=true, 'Activo', 'Inactivo') as 'Estado' from tipo_pieza order by tipo_pieza.ID_tipo_pieza;";
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(query);
            JasperReport jreport = null;
        try {
            jreport = JasperCompileManager.compileReport(reporteEmpleados);
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            JasperPrint print = null;
        try {
            print = JasperFillManager.fillReport(jreport,param,con);
        } catch (JRException ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
            JasperViewer.viewReport(print, false);
    }//GEN-LAST:event_btnGenerar5ActionPerformed

    private void btnGenerar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerar6ActionPerformed
        reporteTipoPieza();
    }//GEN-LAST:event_btnGenerar6ActionPerformed
public void reporteTipoPieza(){
     try{
   Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsoft","root","");
        } catch (SQLException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JasperReport reporte = null;
        try {
            reporte = JasperCompileManager.compileReport("C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reportTipoPieza.jrxml");
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        HashMap param = new HashMap();
        param.put("Empleado", labelempleado.getText());
        JasperPrint print = null;
        try {
            print = JasperFillManager.fillReport(reporte, param,con);
            //JasperViewer.viewReport(print);
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            JRXlsxExporter exporter = new JRXlsxExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteTipoPieza.xlsx");

        try {
            exporter.exportReport();
        } catch (JRException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            ProcessBuilder p = new ProcessBuilder();
        p.command("cmd.exe","/c","C:\\CarSoft-Version-2.1\\src\\main\\java\\Reportes\\reporteTipoPieza.xlsx");
        
        try {
            p.start();
        }catch (IOException ex) {
            Logger.getLogger(FrmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public boolean ValidacionNombreMayusculaYDemasMinus(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^(?=.{3,40}$)[A-ZÑÁÉÍÓÚ][a-zñáéíóú]+(?: [a-zñáéíóúA-ZÑÁÉÍÓÚ]+)?+(?: [a-zñáéíóúA-ZÑÁÉÍÓÚ]+)?$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
}
private boolean ValidacionNombreMayuscula(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^(?=.{3,40}$)[A-ZÑÁÉÍÓÚ][a-zñáéíóú]+(?: [A-ZÑÁÉÍÓÚ][a-zñáéíóú]+)?(?: [A-ZÑÁÉÍÓÚ][a-zñáéíóú]+)?(?: [A-ZÑÁÉÍÓÚ][a-zñáéíóú]+)?$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
public void LimpiarNuevoTipoPieza(){
  // txtIDTipoPieza.setSelectedIndex(1);
        txtIDTipoPieza.setSelectedIndex(0);
        txtTipoPiezaNuevo.setText("");
        btnAgregar2.setEnabled(true);
        btnModificar2.setEnabled(false);
        btnDesactivar2.setEnabled(false);
        createTableTipoPieza();
        createComboBox3(); 

}
public boolean ValidacionCaracteristicas(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^(?=.{3,50}$)[A-ZÑÁÉÍÓÚ][a-zñáéíóú&:|#\";.,-]+(?: [&:|#\\\\\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús&:|#\";.,-]+)?(?: [&:|#\\\\\\\";.0-9a-znA-ZÑÁÉÍÓ-Úáéíóús&:|#\";.,-]+)?(?: [&:|#\\\\\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús&:|#\";.,-]+)?(?: [&:|#\\\\\\\";.0-9a-znA-ZÑÁÉÍÓ-Úáéíóús&:|#\";.,-]+)?(?: [&:|#\\\\\\\";.0-9a-znA-ZÑÁÉÍÓ-Úáéíóús&:|#\";.,-]+)?(?: [&:|#\\\\\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús&:|#\";.,-]+)?(?: [&:|#\\\\\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús&:|#\";.,-]+)?(?: [&:|#\\\\\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús&:|#\";.,-]+)?(?: [&:|#\\\\\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús&:|#\";.,-]+)?(?: [&:|#\\\\\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús&:|#\";.,-]+)?(?: [&:|#\\\\\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús&:|#\";.,-]+)?(?: [&:|#\\\\\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús&:|#\";.,-]+)?(?: [&:|#\\\\\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús&:|#\";.,-])?$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
public boolean ValidacionRangoPrecioPieza(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([2-9][0-9][.][0-9][0-9]|[0-9][0-9][0-9][.][0-9][0-9]|[1-9][,][0-9][0-9][0-9][.][0-9][0-9]|[1-3][0-9][,][0-9][0-9][0-9][.][0-9][0-9]|[4][0][,][0][0][0][.][0][0])$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
public boolean ValidacionRangoStockPieza(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([1]|[2-9]|[1-9][0-9]|[1-3][0-9][0-9]|[4][0][0])$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
    private boolean ValidacionPrecio(String sueldo){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^^(?!0+\\.00)(?=.{1,9}(\\.|$))(?!0(?!\\.))\\d{1,3}(,\\d{3})*(\\.\\d+)$");
        mat =pat.matcher(sueldo);
        if (mat.find()){
            return true;
        } else{       
        return false;
        
        }
    }public void LimpiarPieza(){
    txtIDPieza.setSelectedIndex(0);
    jCmbTipoPieza.setSelectedIndex(0);
    jtxtNombre.setText("");
    jFtxtStock.setText("");
    jFtxtPrecio.setText("");
    jFtxtStockMaximo.setText("");
    jFtxtStockMinimo.setText("");
    jTxtAreaCaracteristica.setText("");
    btnAgregar3.setEnabled(true);
    createTablaPieza();
        createCmbIDPieza();
        createCmbTipoPieza();
    btnModificar3.setEnabled(false);
    btnDesactivar3.setEnabled(false);
}
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnAgregar3;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDesactivar2;
    private javax.swing.JButton btnDesactivar3;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnGenerar2;
    private javax.swing.JButton btnGenerar3;
    private javax.swing.JButton btnGenerar4;
    private javax.swing.JButton btnGenerar5;
    private javax.swing.JButton btnGenerar6;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnLimpiar3;
    private javax.swing.JButton btnModificar2;
    private javax.swing.JButton btnModificar3;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JButton btnRegresar2;
    private javax.swing.JButton btnRegresar3;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JButton btnSalir3;
    private javax.swing.JComboBox<String> cmbIDPieza;
    public javax.swing.JComboBox<String> jCmbTipoPieza;
    public javax.swing.JTextField jFtxtPrecio;
    public javax.swing.JFormattedTextField jFtxtStock;
    public javax.swing.JFormattedTextField jFtxtStockMaximo;
    public javax.swing.JFormattedTextField jFtxtStockMinimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTablePieza;
    public javax.swing.JTable jTableTipoPieza;
    private javax.swing.JTable jTbHistorialPrecio;
    public javax.swing.JTextArea jTxtAreaCaracteristica;
    public javax.swing.JTextField jtxtNombre;
    public javax.swing.JLabel labelempleado;
    private javax.swing.JPanel pnlPieza;
    private javax.swing.JTable tablaBusqueda;
    public javax.swing.JComboBox<String> txtIDPieza;
    public javax.swing.JComboBox<String> txtIDTipoPieza;
    public javax.swing.JTextField txtNombreBusqueda;
    public javax.swing.JTextField txtTipoPiezaNuevo;
    // End of variables declaration//GEN-END:variables
}
