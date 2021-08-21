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
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class FrmPieza extends javax.swing.JFrame {

    /**
     * Creates new form Empleados
     * 
     */
    
    PiezaJpaController piezaDao = new PiezaJpaController();
    HistoricoPrecioPiezaJpaController historicoPieza = new HistoricoPrecioPiezaJpaController();
    TipoPiezaJpaController tipoPieza = new TipoPiezaJpaController();
    
    
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


        createTablaPieza();
        createCmbTipoPieza();
        createCmbIDPieza();
        crearcmbPiezaHistorico();
    }
    
    public void crearTbHistorialPrecio(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        
        
        
        jTbHistorialPrecio.setModel(modelo);
        
        
        
        modelo.addColumn("ID Precio Historico");
        modelo.addColumn("ID pieza");
        modelo.addColumn("Pieza");
        modelo.addColumn("Caracteristica");
        modelo.addColumn("Precio");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        
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
            if(e.getIdPieza()==(cmbIDPieza.getSelectedIndex()+1) && e.getFechaFinal()!=null)
            for(Pieza tp : temp2){
                if(tp.getId_Pieza() == e.getIdPieza()){
                    aux1=(tp.getCarateristica_Pieza());
                    aux2=tp.getNombre();
                    auxFecha1 = e.getFechaInicial().substring(8, 10)+"/"+e.getFechaInicial().substring(5,7)+"/"+e.getFechaInicial().substring(0, 4);
                    auxFecha2 = e.getFechaFinal().substring(8, 10)+"/"+e.getFechaFinal().substring(5,7)+"/"+e.getFechaFinal().substring(0, 4);
            modelo.addRow(new Object[]{
                                  e.getIdPrecioHistorico(),
                                  e.getIdPieza(),
                                  aux2,
                                  aux1,
                                  String.format("%,.2f",e.getPrecio()),
                                  auxFecha1,
                                  auxFecha2});
        
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
            modelo.addElement(e.getId_Pieza());
        }
    }
    
    public void btnActivarDesactivar(){
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
    
    public void btnActivarDesactivarPieza(){
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
        DefaultTableModel modelo = new DefaultTableModel();
        jTablePieza.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Tipo de Pieza");
        modelo.addColumn("Nombre");
        modelo.addColumn("Característica");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado Maximo");
        modelo.addColumn("Estado minimo");
        modelo.addColumn("Estado");
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
                if(p.getId_Tipo_Pieza()==p1.getIDtipopieza())
                    aux1=p1.getTipopieza();
                    
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
                formato1.format(auxPrecio),
                p.getStock(),
                p.getStock_Maximo(),
                p.getStock_Minimo(),
                (p.isEstado())? "Activo" : "Inactivo"
            });
        }
        
        
    }
    
    private void crearTableBusquedaPieza(){
        DefaultTableModel modelo = new DefaultTableModel();
        tablaBusqueda.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Tipo de Pieza");
        modelo.addColumn("Nombre");
        modelo.addColumn("Característica");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Estado Maximo");
        modelo.addColumn("Estado minimo");
        modelo.addColumn("Estado");
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
        DefaultTableModel modelo = new DefaultTableModel();
        jTableTipoPieza.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Pieza");
        modelo.addColumn("Estado");
        
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
        jLabel7 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cmbIDPieza = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTbHistorialPrecio = new javax.swing.JTable();
        btnSalir2 = new javax.swing.JButton();
        btnRegresar2 = new javax.swing.JButton();
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

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID Pieza:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Tipo Pieza:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Características:");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Precio:");

        jTablePieza.setForeground(new java.awt.Color(255, 255, 255));
        jTablePieza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Pieza", "Tipo Pieza", "Características", "Precio", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
        if (jTablePieza.getColumnModel().getColumnCount() > 0) {
            jTablePieza.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTablePieza.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTablePieza.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTablePieza.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTablePieza.getColumnModel().getColumn(4).setPreferredWidth(70);
        }

        jLabel12.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Piezas");

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Stock:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Stock minimo:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Stock máximo:");

        btnAgregar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar.png"))); // NOI18N
        btnAgregar3.setText("Agregar");
        btnAgregar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar3ActionPerformed(evt);
            }
        });

        btnModificar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnModificar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/modificar.png"))); // NOI18N
        btnModificar3.setText("Modificar");
        btnModificar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar3ActionPerformed(evt);
            }
        });

        btnLimpiar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpiar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Limpiar.png"))); // NOI18N
        btnLimpiar3.setText("Limpiar");
        btnLimpiar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar3ActionPerformed(evt);
            }
        });

        btnDesactivar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDesactivar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Desactivar.png"))); // NOI18N
        btnDesactivar3.setText("Desactivar");
        btnDesactivar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivar3ActionPerformed(evt);
            }
        });

        jTxtAreaCaracteristica.setColumns(20);
        jTxtAreaCaracteristica.setRows(5);
        jScrollPane1.setViewportView(jTxtAreaCaracteristica);

        txtIDPieza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " ", " " }));
        txtIDPieza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtIDPiezaItemStateChanged(evt);
            }
        });

        jCmbTipoPieza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "1", "2" }));
        jCmbTipoPieza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCmbTipoPiezaItemStateChanged(evt);
            }
        });

        jFtxtStockMaximo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jFtxtStock.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jFtxtStockMinimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jFtxtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFtxtPrecioKeyPressed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Nombre:");

        javax.swing.GroupLayout pnlPiezaLayout = new javax.swing.GroupLayout(pnlPieza);
        pnlPieza.setLayout(pnlPiezaLayout);
        pnlPiezaLayout.setHorizontalGroup(
            pnlPiezaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPiezaLayout.createSequentialGroup()
                .addGroup(pnlPiezaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPiezaLayout.createSequentialGroup()
                        .addGap(650, 650, 650)
                        .addComponent(jLabel12)
                        .addGap(526, 526, 526)
                        .addComponent(btnSalir))
                    .addGroup(pnlPiezaLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(txtIDPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jFtxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jFtxtStockMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPiezaLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jCmbTipoPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jFtxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jFtxtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPiezaLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnAgregar3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar3)
                        .addGap(19, 19, 19)
                        .addComponent(btnLimpiar3)
                        .addGap(19, 19, 19)
                        .addComponent(btnDesactivar3))
                    .addGroup(pnlPiezaLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPiezaLayout.createSequentialGroup()
                        .addGap(1190, 1190, 1190)
                        .addComponent(btnRegresar)))
                .addGap(40, 40, 40))
        );
        pnlPiezaLayout.setVerticalGroup(
            pnlPiezaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPiezaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlPiezaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir))
                .addGap(39, 39, 39)
                .addGroup(pnlPiezaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPiezaLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPiezaLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtIDPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPiezaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4))
                    .addComponent(jFtxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPiezaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6))
                    .addComponent(jFtxtStockMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pnlPiezaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPiezaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPiezaLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jCmbTipoPieza, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPiezaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPiezaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11))
                    .addComponent(jFtxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPiezaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addComponent(jFtxtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlPiezaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificar3)
                    .addComponent(btnLimpiar3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivar3)
                    .addComponent(btnAgregar3))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(btnRegresar))
        );

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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Precio Histórico", "ID Pieza", "Fecha Inicial", "Fecha Final", "Precio", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTbHistorialPrecio);
        if (jTbHistorialPrecio.getColumnModel().getColumnCount() > 0) {
            jTbHistorialPrecio.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTbHistorialPrecio.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTbHistorialPrecio.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTbHistorialPrecio.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTbHistorialPrecio.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTbHistorialPrecio.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1190, 1190, 1190)
                .addComponent(btnRegresar2))
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
                .addGap(203, 203, 203)
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
                "ID Tipo de Pieza", "Tipo de Pieza", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(675, 675, 675)
                .addComponent(jLabel31)
                .addGap(384, 384, 384)
                .addComponent(btnSalir1))
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
                .addGap(68, 68, 68)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1235, 1235, 1235)
                .addComponent(btnRegresar1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSalir1))
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
                .addGap(91, 91, 91)
                .addComponent(btnRegresar1))
        );

        jTabbedPane3.addTab("Nuevo Tipo de pieza", jPanel1);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nombre:");

        tablaBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        tablaBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Pieza", "Tipo Pieza", "Características", "Precio", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
        if (tablaBusqueda.getColumnModel().getColumnCount() > 0) {
            tablaBusqueda.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaBusqueda.getColumnModel().getColumn(1).setPreferredWidth(90);
            tablaBusqueda.getColumnModel().getColumn(2).setPreferredWidth(150);
            tablaBusqueda.getColumnModel().getColumn(3).setPreferredWidth(70);
            tablaBusqueda.getColumnModel().getColumn(4).setPreferredWidth(70);
        }

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Busqueda de Piezas");

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

    }//GEN-LAST:event_btnDesactivar2ActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        LimpiarNuevoTipoPieza();
        // txtTipoPiezaNuevo.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed
        if(txtIDTipoPieza.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Tipo de pieza no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if("".equals(txtTipoPiezaNuevo.getText())){
                JOptionPane.showMessageDialog(null, "El campo de de tipo de pieza esta vacio","ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(txtTipoPiezaNuevo.getText().length()<3){
                JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el Tipo de pieza es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else{

            }
            if(txtTipoPiezaNuevo.getText().length()>25){
                JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Tipo de Pieza es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else{

            }
            if (!ValidacionNombreMayusculaYDemasMinus(txtTipoPiezaNuevo.getText())){
                JOptionPane.showMessageDialog(null,"El Tipo de Pieza debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
                txtTipoPiezaNuevo.requestFocus();
                return;
            }else{

            }
            Pattern pat = Pattern.compile("(?i)(.*aaa.*|.*bbb.*|.*ccc.*|.*ddd.*|.*eee.*|.*fff.*|.*ggg.*|.*hhh.*|.*iii.*"
                + "                         |.*jjj.*|.*kkk.*|.*lll.*|.*mmm.*|.*nnn.*|.*ooo.*|.*ppp.*|.*qqq.*|.*rrr.*|.*sss.*|.*ttt.*|.*uuu.*"
                + "                         |.*vvv.*|.*www.*|.*xxx.*|.*yyy.*|.*zzz.*)");

            Matcher mat = pat.matcher(txtTipoPiezaNuevo.getText());

            if(mat.matches()){
                JOptionPane.showMessageDialog(null, "No se Admite en el Tipo de Pieza la misma letra 3 veces en forma consecutiva","ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if("".equals(txtTipoPiezaNuevo.getText())){
                //JOptionPane.showMessageDialog(null, "Tipo de Pieza no puede ir vacio", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else{
                int i;
                boolean flag=false;
                for(i=0;i<tipoPieza.findTipoPiezaEntities().size();i++){
                    //System.out.println(i);
                    if(txtTipoPiezaNuevo.getText().toLowerCase().equals(tipoPieza.findTipoPieza(i+1).getTipopieza().toLowerCase())){
                        JOptionPane.showMessageDialog(null, "Ya existe este tipo de pieza registrada en el sistema","Error", JOptionPane.PLAIN_MESSAGE);
                        flag=true;
                        return;
                    } else {
                    }
                }
                if(flag){
                    return;
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

        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificar2ActionPerformed

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed

        if(txtIDTipoPieza.getSelectedIndex()!=0){
            JOptionPane.showMessageDialog(null, "El ID Tipo de Pieza siempre debe estar en el ITEM de Nuevo para agregar un nuevo Tipo de Pieza","Error!", JOptionPane.ERROR_MESSAGE);
            txtIDTipoPieza.setSelectedIndex(0);
        }
        else{

        }
        if("".equals(txtTipoPiezaNuevo.getText())){
            JOptionPane.showMessageDialog(null, "El campo de de tipo de pieza esta vacio","ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(txtTipoPiezaNuevo.getText().length()<3){
            JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el Tipo de pieza es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if(txtTipoPiezaNuevo.getText().length()>25){
            JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Tipo de Pieza es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if (!ValidacionNombreMayusculaYDemasMinus(txtTipoPiezaNuevo.getText())){
            JOptionPane.showMessageDialog(null,"El Tipo de Pieza debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            txtTipoPiezaNuevo.requestFocus();
            return;
        }else{

        }
        Pattern pat = Pattern.compile("(?i)(.*aaa.*|.*bbb.*|.*ccc.*|.*ddd.*|.*eee.*|.*fff.*|.*ggg.*|.*hhh.*|.*iii.*"
            + "                         |.*jjj.*|.*kkk.*|.*lll.*|.*mmm.*|.*nnn.*|.*ooo.*|.*ppp.*|.*qqq.*|.*rrr.*|.*sss.*|.*ttt.*|.*uuu.*"
            + "                         |.*vvv.*|.*www.*|.*xxx.*|.*yyy.*|.*zzz.*)");

        Matcher mat = pat.matcher(txtTipoPiezaNuevo.getText());

        if(mat.matches()){
            JOptionPane.showMessageDialog(null, "No se Admite en el Tipo de Pieza la misma letra 3 veces en forma consecutiva","ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        else{
            int i;
            boolean flag=false;
            for(i=0;i<tipoPieza.findTipoPiezaEntities().size();i++){
                //System.out.println(i);
                if(txtTipoPiezaNuevo.getText().toLowerCase().equals(tipoPieza.findTipoPieza(i+1).getTipopieza().toLowerCase())){
                    JOptionPane.showMessageDialog(null, "Ya existe este tipo de pieza registrada en el sistema","ERROR", JOptionPane.ERROR_MESSAGE);
                    flag=true;
                    return;
                } else {
                }
            }
            if(flag){
                return;
            }
            else{
                TipoPieza e1 = new TipoPieza();
                e1.setEstado(true);
                e1.setTipopieza(txtTipoPiezaNuevo.getText());
                tipoPieza.create(e1);
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

        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregar2ActionPerformed

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
        /*Pieza temp;
        temp = piezaDao.findPieza(txtIDPieza.getSelectedIndex());
        if(temp.isEstado()){
            temp.setEstado(false);
        }
        else{
            temp.setEstado(true);
        }
        try {
            piezaDao.edit(temp);
        } catch (Exception ex) {
            Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTablaPieza();
        btnActivarDesactivarPieza();
        */
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesactivar3ActionPerformed

    private void btnLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar3ActionPerformed
        LimpiarPieza();
    }//GEN-LAST:event_btnLimpiar3ActionPerformed

    private void btnModificar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar3ActionPerformed

        if(jCmbTipoPieza.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún Tipo de pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
               if(jCmbTipoPieza.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún Tipo de pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if(jtxtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "El campo de Nombre de la Pieza esta vacio","ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if(jtxtNombre.getText().length()<3){
            JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el Nombre de la Pieza es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if(jtxtNombre.getText().length()>25){
            JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Nombre de la Pieza es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if (!ValidacionNombreMayusculaYDemasMinus(jtxtNombre.getText())){
            JOptionPane.showMessageDialog(null,"El Nombre de la Pieza debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            jtxtNombre.requestFocus();
            return;
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
            return;
        }
        else{

        }
        if(jTxtAreaCaracteristica.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese las Características de la pieza","ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if(jTxtAreaCaracteristica.getText().length()<3){
            JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para la Característica de la Pieza es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if(jTxtAreaCaracteristica.getText().length()>50){
            JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para la Característica de la Pieza es de 50 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        Matcher matt = pat.matcher(jTxtAreaCaracteristica.getText());
        if(matt.matches()){
            JOptionPane.showMessageDialog(null, "No se Admite en la Descripción de la Pieza la misma letra 3 veces en forma consecutiva","ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if (!ValidacionDireccion(jTxtAreaCaracteristica.getText())){
            JOptionPane.showMessageDialog(null,"La Descripción solo puede contener números, letras y los siguiente signos(&:|#\";.,-)","Error!", JOptionPane.ERROR_MESSAGE);
            jTxtAreaCaracteristica.requestFocus();
            return;
        }
        else{
        }
        if("".equals(jFtxtStock.getText())){
            JOptionPane.showMessageDialog(null, "El campo de Stock de la Pieza esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if((Integer.parseInt(jFtxtStock.getText())==0)){
               JOptionPane.showMessageDialog(null, "El Stock no puedo ser cero","Error!",JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{        
           }
        if (!ValidacionRangoStockPieza(jFtxtStock.getText())){
            JOptionPane.showMessageDialog(null,"El rango de Stock de Piezas solo puede estar entre 1-400","Error!", JOptionPane.ERROR_MESSAGE);
            jFtxtStock.requestFocus();
            return;
        }else{

        }
        if("".equals(jFtxtPrecio.getText())){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el precio de la pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if (!ValidacionRangoPrecioPieza(jFtxtPrecio.getText())){
            JOptionPane.showMessageDialog(null,"El rango de Precio de la Pieza solo puede estar entre 20.00-40,000.00","Error!", JOptionPane.ERROR_MESSAGE);
            jFtxtPrecio.requestFocus();
            return;
        }
        else{
        }
        if("".equals(jFtxtStockMaximo.getText())){
            JOptionPane.showMessageDialog(null,"Por favor, ingrese la cantidad Máxima que puede haber de esta pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if((Integer.parseInt(jFtxtStockMaximo.getText())==0)){
               JOptionPane.showMessageDialog(null, "El Stock Máximo no puedo ser cero","Error!",JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{        
           }
        if (!ValidacionRangoStockPieza(jFtxtStockMaximo.getText())){
            JOptionPane.showMessageDialog(null,"El rango de Stock Máximo de Piezas solo puede estar entre 1-400","Error!", JOptionPane.ERROR_MESSAGE);
            jFtxtStockMaximo.requestFocus();
            return;
        }else{

        }
        if(Double.parseDouble(jFtxtStock.getText())>Integer.parseInt(jFtxtStockMaximo.getText())){
            JOptionPane.showMessageDialog(null, "El Stock no puede ser mayor al Stock Máximo","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if("".equals(jFtxtStockMinimo.getText())){
            JOptionPane.showMessageDialog(null,"Por favor, ingrese el Stock Mínimo de la Pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if((Integer.parseInt(jFtxtStockMinimo.getText())<1)){
               JOptionPane.showMessageDialog(null, "El Stock Mínimo actual no puedo ser menor que uno","Error!",JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{        
           }
        if(Integer.parseInt(jFtxtStockMinimo.getText()) >= Integer.parseInt(jFtxtStockMaximo.getText())){
            JOptionPane.showMessageDialog(null, "El Stock Mínimo no puede ser igual o mayor al Stock Máximo","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if(Double.parseDouble(jFtxtStock.getText())<Integer.parseInt(jFtxtStockMinimo.getText())){
            JOptionPane.showMessageDialog(null, "El Stock no puede ser menor al Stock Mínimo ","Error!", JOptionPane.ERROR_MESSAGE);
            return;
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
            Calendar fecha = new GregorianCalendar();
            String fecha1;
            String aux1,aux2,aux3;
            aux1 = Integer.toString(fecha.get(Calendar.YEAR));
            aux2 = (fecha.get(Calendar.MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.MONTH)+1) : Integer.toString(fecha.get(Calendar.MONTH));
            aux3 = (fecha.get(Calendar.DAY_OF_MONTH)<10)? "0"+Integer.toString(fecha.get(Calendar.DAY_OF_MONTH)) : Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
            fecha1 = aux1+aux2+aux3;
            temp2.setFechaFinal(fecha1);
            double auxsueldo=(Double.parseDouble(jFtxtPrecio.getText().replace(",", "").replace(",", "").trim()));
            //double aux=Double.parseDouble(jFtxtPrecio.getText().trim());
            //temp2.setPrecio(auxsueldo);
            temp2.setIdPieza(txtIDPieza.getSelectedIndex());
            try {
                historicoPieza.edit(temp2);
            } catch (Exception ex) {
                Logger.getLogger(FrmPieza.class.getName()).log(Level.SEVERE, null, ex);
            }
            HistoricoPrecioPieza temp3 = new HistoricoPrecioPieza();
            temp3.setFechaInicial(fecha1);
            temp3.setIdPieza(txtIDPieza.getSelectedIndex());
            double auxsueldo1=(Double.parseDouble(jFtxtPrecio.getText().replace(",", "").replace(",", "").trim()));
            temp3.setPrecio(auxsueldo1);
            historicoPieza.create(temp3);
            //txtIDPieza.setSelectedIndex(1);

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

        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificar3ActionPerformed

    private void btnAgregar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar3ActionPerformed
        if(txtIDPieza.getSelectedIndex()==0){

        }
        else{
            txtIDPieza.setSelectedIndex(0);
            JOptionPane.showMessageDialog(null, "El ID Pieza siempre debe estar en el ITEM de Nuevo para agregar una Pieza","Error!", JOptionPane.ERROR_MESSAGE);
        }
        if(jCmbTipoPieza.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún Tipo de pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if(jtxtNombre.getText().equals("")){
            JOptionPane.showMessageDialog(null, "El campo de Nombre de la Pieza esta vacio","ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if(jtxtNombre.getText().length()<3){
            JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para el Nombre de la Pieza es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if(jtxtNombre.getText().length()>25){
            JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para el Nombre de la Pieza es de 25 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if (!ValidacionNombreMayusculaYDemasMinus(jtxtNombre.getText())){
            JOptionPane.showMessageDialog(null,"El Nombre de la Pieza debe contener la primera letra mayúscula y luego minúsculas","Error!", JOptionPane.ERROR_MESSAGE);
            jtxtNombre.requestFocus();
            return;
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
            return;
        }
        else{

        }
        if(jTxtAreaCaracteristica.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese las Características de la pieza","ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if(jTxtAreaCaracteristica.getText().length()<3){
            JOptionPane.showMessageDialog(null, "La cantidad mínima de caracteres para la Característica de la Pieza es de 3 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if(jTxtAreaCaracteristica.getText().length()>50){
            JOptionPane.showMessageDialog(null, "La cantidad máxima de caracteres para la Característica de la Pieza es de 50 caracteres","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        Matcher matt = pat.matcher(jTxtAreaCaracteristica.getText());
        if(matt.matches()){
            JOptionPane.showMessageDialog(null, "No se Admite en la D de la Pieza la misma letra 3 veces en forma consecutiva","ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if (!ValidacionDireccion(jTxtAreaCaracteristica.getText())){
            JOptionPane.showMessageDialog(null,"La dirección solo puede contener números, letras y los siguiente signos(&:|#\";.,-)","Error!", JOptionPane.ERROR_MESSAGE);
            jTxtAreaCaracteristica.requestFocus();
            return;
        }
        else{
        }
        if("".equals(jFtxtStock.getText())){
            JOptionPane.showMessageDialog(null, "El campo de Stock de la Pieza esta vacio","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if((Integer.parseInt(jFtxtStock.getText())==0)){
               JOptionPane.showMessageDialog(null, "El Stock no puedo ser cero","Error!",JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{        
           }
        if (!ValidacionRangoStockPieza(jFtxtStock.getText())){
            JOptionPane.showMessageDialog(null,"El rango de Stock de Piezas solo puede estar entre 1-400","Error!", JOptionPane.ERROR_MESSAGE);
            jFtxtStock.requestFocus();
            return;
        }else{

        }
        if("".equals(jFtxtPrecio.getText())){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el precio de la pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{

        }
        if (!ValidacionRangoPrecioPieza(jFtxtPrecio.getText())){
            JOptionPane.showMessageDialog(null,"El rango de Precio de la Pieza solo puede estar entre 20.00-40,000.00","Error!", JOptionPane.ERROR_MESSAGE);
            jFtxtPrecio.requestFocus();
            return;
        }
        else{
        }
        if("".equals(jFtxtStockMaximo.getText())){
            JOptionPane.showMessageDialog(null,"Por favor, ingrese la cantidad Máxima que puede haber de esta pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if((Integer.parseInt(jFtxtStockMaximo.getText())==0)){
               JOptionPane.showMessageDialog(null, "El Stock Máximo no puedo ser cero","Error!",JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{        
           }
        if (!ValidacionRangoStockPieza(jFtxtStockMaximo.getText())){
            JOptionPane.showMessageDialog(null,"El rango de Stock Máximo de Piezas solo puede estar entre 1-400","Error!", JOptionPane.ERROR_MESSAGE);
            jFtxtStockMaximo.requestFocus();
            return;
        }else{

        }
        if(Double.parseDouble(jFtxtStock.getText())>Integer.parseInt(jFtxtStockMaximo.getText())){
            JOptionPane.showMessageDialog(null, "El Stock no puede ser mayor al Stock Máximo","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if("".equals(jFtxtStockMinimo.getText())){
            JOptionPane.showMessageDialog(null,"Por favor, ingrese el Stock Mínimo de la Pieza","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if((Integer.parseInt(jFtxtStockMinimo.getText())<1)){
               JOptionPane.showMessageDialog(null, "El Stock Mínimo actual no puedo ser menor que uno","Error!",JOptionPane.ERROR_MESSAGE);
                return;
            }
           else{        
           }
        if(Integer.parseInt(jFtxtStockMinimo.getText()) >= Integer.parseInt(jFtxtStockMaximo.getText())){
            JOptionPane.showMessageDialog(null, "El Stock Mínimo no puede ser igual o mayor al Stock Máximo","Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
        }
        if(Double.parseDouble(jFtxtStock.getText())<Integer.parseInt(jFtxtStockMinimo.getText())){
            JOptionPane.showMessageDialog(null, "El Stock no puede ser menor al Stock Mínimo ","Error!", JOptionPane.ERROR_MESSAGE);
            return;
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
        historicoPieza.create(temp2);

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

    }//GEN-LAST:event_btnAgregar3ActionPerformed

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
private boolean ValidacionNombreMayusculaYDemasMinus(String num){
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
   txtIDTipoPieza.setSelectedIndex(1);
        txtIDTipoPieza.setSelectedIndex(0);
        txtTipoPiezaNuevo.setText("");
        btnAgregar2.setEnabled(true);
        btnModificar2.setEnabled(false);
        btnDesactivar2.setEnabled(false);
        createTableTipoPieza();
        createComboBox3(); 

}private boolean ValidacionDireccion(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^(?=.{3,50}$)[A-ZÑÁÉÍÓÚ][a-zñáéíóú]+(?: [&:|#\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús,-]+)?(?: [&:|#\\\";.0-9a-znA-ZÑÁÉÍÓ-Úáéíóús,-]+)?(?: [&:|#\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús,-]+)?(?: [&:|#\\\";.0-9a-znA-ZÑÁÉÍÓ-Úáéíóús,-]+)?(?: [&:|#\\\";.0-9a-znA-ZÑÁÉÍÓ-Úáéíóús,-]+)?(?: [&:|#\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús,-]+)?(?: [&:|#\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús,-]+)?(?: [&:|#\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús,-]+)?(?: [&:|#\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús,-]+)?(?: [&:|#\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús,-]+)?(?: [&:|#\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús,-]+)?(?: [&:|#\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús,-]+)?(?: [&:|#\\\";.0-9a-zñA-ZÑÁÉÍÓ-Úáéíóús,-]+)?$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
private boolean ValidacionRangoPrecioPieza(String num){
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([2-9][0-9][.][0-9][0-9]|[1-9][0-9][0-9][.][0-9][0-9]|[1-9][,][1-9][1-9][1-9][.][0-9][0-9]|[1-3][0-9][,][0-9][0-9][0-9][.][0-9][0-9]|[4][0][,][0][0][0][.][0][0])$");
        mat =pat.matcher(num);
        if (mat.find()){
            return true;
        } else{
        return false;
        }
    }
private boolean ValidacionRangoStockPieza(String num){
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
    private javax.swing.JComboBox<String> jCmbTipoPieza;
    private javax.swing.JTextField jFtxtPrecio;
    private javax.swing.JFormattedTextField jFtxtStock;
    private javax.swing.JFormattedTextField jFtxtStockMaximo;
    private javax.swing.JFormattedTextField jFtxtStockMinimo;
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
    private javax.swing.JTable jTableTipoPieza;
    private javax.swing.JTable jTbHistorialPrecio;
    private javax.swing.JTextArea jTxtAreaCaracteristica;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JPanel pnlPieza;
    private javax.swing.JTable tablaBusqueda;
    private javax.swing.JComboBox<String> txtIDPieza;
    private javax.swing.JComboBox<String> txtIDTipoPieza;
    private javax.swing.JTextField txtNombreBusqueda;
    private javax.swing.JTextField txtTipoPiezaNuevo;
    // End of variables declaration//GEN-END:variables
}
